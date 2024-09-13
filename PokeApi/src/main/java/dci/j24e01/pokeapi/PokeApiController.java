package dci.j24e01.pokeapi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import javafx.application.Platform;

import java.io.IOException;
import java.net.URISyntaxException;

public class PokeApiController {
    @FXML
    private TextField input;
    @FXML
    private ImageView imageView;
    @FXML
    private Button playSoundButton;
    @FXML
    private Button searchButton;
    @FXML
    private ListView<Pokemon> pokemonsList;

    private Pokemon current;

    @FXML
    private void initialize() throws IOException, URISyntaxException {
        new SearchTable();
        pokemonsList.getItems().addAll(PokeApi.getPokemons());
        pokemonsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pokemon>() {
            @Override
            public void changed(ObservableValue<? extends Pokemon> observable, Pokemon oldValue, Pokemon newValue) {
                try {
                    changePokemon(newValue);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        playSoundButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                playSound();
            }
        });
    }

    private void changePokemon(Pokemon pokemon) throws IOException {
        current = pokemon;
        searchButton.setDisable(true);
        searchButton.setText("Loading...");
        new Thread(() -> {
            try {
                Platform.runLater(() -> {
                    playSoundButton.setVisible(true);
                    searchButton.setDisable(false);
                    searchButton.setText("Search");
                });
                imageView.setImage(getImage());
            } catch (IOException e) {
                try {
                    imageView.setImage(getExtraImage());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }).start();

    }

    private Image getImage() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/" + current.id())
                .build();

        Response response = client.newCall(request).execute();
        JsonNode root = mapper.readTree(response.body().string());
        response.close();
        JsonNode image = root.get("sprites").get("other").get("home").get("front_default");
        return new Image(image.asText());
    }
    private Image getExtraImage() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://pokeapi.co/api/v2/pokemon/" + current.id())
                .build();

        Response response = client.newCall(request).execute();
        JsonNode root = mapper.readTree(response.body().string());
        response.close();
        JsonNode image = root.get("sprites").get("other").get("official-artwork").get("front_default");
        return new Image(image.asText());
    }

    private void playSound() {
        new Thread(() -> {
            ObjectMapper mapper = new ObjectMapper();
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://pokeapi.co/api/v2/pokemon/" + current.id())
                    .build();
            playSoundButton.setDisable(true);
            Platform.runLater(() -> {
                    playSoundButton.setText("Loading...");
            });
            Response response;
            try {
                response = client.newCall(request).execute();
                JsonNode root = mapper.readTree(response.body().string());
                response.close();
                JOrbis player = new JOrbis(root.get("cries").get("latest").asText());
                player.run();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            playSoundButton.setDisable(false);
            Platform.runLater(() -> {
                playSoundButton.setText("Play Sound");
            });
        }).start();

    }
    @FXML
    private void search() {
        String inputText = input.getText().toLowerCase();
        try {
            int number = Integer.parseInt(inputText);
            pokemonsList.scrollTo(number - 1);
        } catch (NumberFormatException e) {
            for (int i = Math.max(0, pokemonsList.getSelectionModel().getSelectedIndex()) + 1;
                                                        i < PokeApi.getPokemons().size(); i++) {
                if (PokeApi.getPokemons().get(i).name().contains(inputText)) {
                    pokemonsList.scrollTo(i);
                    pokemonsList.getSelectionModel().select(i);
                    break;
                }
                if (i == PokeApi.getPokemons().size() - 1) {

                }
            }
        }
    }
}
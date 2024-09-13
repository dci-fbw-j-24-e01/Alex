package dci.j24e01.pokeapi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class PokeApi extends Application {
    private static final ArrayList<Pokemon> pokemons = new ArrayList<>();
    public static ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PokeApi.class.getResource("pokeapi-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 525);
        stage.setResizable(false);
        stage.setTitle("PokeAPI Application");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();
    }
}
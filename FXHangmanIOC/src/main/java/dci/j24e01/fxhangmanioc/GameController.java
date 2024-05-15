package dci.j24e01.fxhangmanioc;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.media.AudioClip;
import java.util.Random;

public class GameController implements EventHandler<ActionEvent> {
    @FXML
    private VBox buttonContainer;

    @FXML
    private ImageView hangmanImageView;

    @FXML
    private void initialize() {
        HBox hBox1 = createLine("QWERTYUIOP");
        HBox hBox2 = createLine("ASDFGHJKL");
        HBox hBox3 = createLine("ZXCVBNM");

        Button extraButton = new Button();
        extraButton.setText("Extra \uD83D\uDE2D");
        hBox3.getChildren().add(extraButton);
        extraButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                extraAction();
            }
        });

        buttonContainer.getChildren().add(hBox1);
        buttonContainer.getChildren().add(hBox2);
        buttonContainer.getChildren().add(hBox3);
    }

    private HBox createLine(String letters) {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        for (int i = 0; i < letters.length(); i++) {
            Button button = new Button();
            button.setText(String.valueOf(letters.charAt(i)));
            button.setOnAction(this);
            hBox.getChildren().add(button);
        }
        return hBox;
    }

    @Override
    public void handle(ActionEvent event) {
        Button button = (Button) event.getSource();
        String letter = button.getText();
        System.out.println(letter);
        Random random = new Random();
        int randomIndex = random.nextInt(0, 7);
        Image image = new Image(HangmanApplication.class.getResource("images/hangman_" + randomIndex + ".png").toString());
        hangmanImageView.setImage(image);
    }

    private void extraAction() {
        String path = HangmanApplication.class.getResource("audio/wilhelm-splash-14579.mp3").toString();
        AudioClip audioClip = new AudioClip(path);
        audioClip.setVolume(0.3);
        audioClip.play();
    }
}
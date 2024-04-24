package dci.j24e01.javafxbasicdemo.fxdemo;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;


public class HelloController {
    @FXML
    private Label counterLabel;

    @FXML
    private Button downButton;

    int counter = 0;
    @FXML
    public void initialize() {
        counterLabel.setText("Counter: " + counter);
    }
    @FXML
    private void clickedUpButton() {
        counterLabel.setText("Counter: " + ++counter);
        if (counter > 0) {
            downButton.setDisable(false);
        }
        if (counter > 10) {
            counterLabel.setTextFill(Paint.valueOf("#FF0000"));
        }
    }

    @FXML
    private void clickedDownButton() {
        counterLabel.setText("Counter: " + --counter);
        if (counter <= 10) {
            counterLabel.setTextFill(Paint.valueOf("#000000"));
        }
        if (counter < 1) {
            downButton.setDisable(true);
        }
    }


}
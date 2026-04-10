package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import java.util.Random;

public class Controller {
    @FXML private VBox vbox1;
    @FXML private VBox vbox2;
    @FXML private VBox vbox3;
    @FXML private VBox vbox4;
    private String getRandomColor() {
        Random rand = new Random();
        String r = String.format("%02X", rand.nextInt(256));
        String g = String.format("%02X", rand.nextInt(256));
        String b = String.format("%02X", rand.nextInt(256));
        return "#" + r + g + b;
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor());
        vbox2.setStyle("-fx-background-color: " + getRandomColor());
        vbox3.setStyle("-fx-background-color: " + getRandomColor());
        vbox4.setStyle("-fx-background-color: " + getRandomColor());
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
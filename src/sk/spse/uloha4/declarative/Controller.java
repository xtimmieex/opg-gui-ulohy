package sk.spse.uloha4.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import java.util.Locale;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Controller {
    @FXML private VBox vbox1;
    @FXML private VBox vbox2;
    @FXML private VBox vbox3;
    @FXML private VBox vbox4;

    @FXML private ImageView img1;
    @FXML private ImageView img2;
    @FXML private ImageView img3;
    @FXML private ImageView img4;


    private String getRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    private static String getRandomOpaque() {
        Random rand = new Random();
        double x = rand.nextDouble();
        String s = String.format(Locale.ROOT, "%.2f", x);
        return s;
    }

    private static String getRandomRotate() {
        Random rand = new Random();
        int x =rand.nextInt(360);
        String s = String.format("%d", x);
        return s;
    }

    private static String getRandomScale() {
        Random rand = new Random();
        int x = rand.nextInt(150) + 10;
        String s = String.format("%d%%", x);
        return s;
    }

    @FXML
    private void randomize() {
        vbox1.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity:" + getRandomOpaque());
        vbox2.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity:" + getRandomOpaque());
        vbox3.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity:" + getRandomOpaque());
        vbox4.setStyle("-fx-background-color: " + getRandomColor() + "; -fx-opacity:" + getRandomOpaque());

        img4.setStyle(" -fx-rotate: " + getRandomRotate());
        img2.setStyle(" -fx-scale-x: " + getRandomScale());
        img3.setStyle(" -fx-scale-y: " + getRandomScale());
        img1.setStyle(" -fx-scale-x: " + getRandomScale() + "; -fx-scale-y: " + getRandomScale() + "; -fx-rotate: " + getRandomRotate() + "; -fx-opacity: " + getRandomOpaque());
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
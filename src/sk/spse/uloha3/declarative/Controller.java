package sk.spse.uloha3.declarative;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    private int counter = 0;

    @FXML
    private TextField counterField;

    @FXML
    private void incrementCounter() {
        counter++;
        counterField.setText(String.valueOf(counter));
    }

    public void openLink(ActionEvent actionEvent) {
    }

    public void close(ActionEvent actionEvent) {
    }
}

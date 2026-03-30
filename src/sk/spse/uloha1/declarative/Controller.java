package sk.spse.uloha1.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    private int counter = 0;

    @FXML
    private TextField cField;

    @FXML
    private TextField fField;

    @FXML
    private void convertFtoC() {
        try {
            double f = Double.parseDouble(fField.getText());
            double c = Math.round((f - 32) / 1.8 * 100.0) / 100.0;
            cField.setText(String.format("%.2f", c));
        } catch (NumberFormatException e) {}
    }

    private void convertCtoF() {
        try {
            double c = Double.parseDouble(cField.getText());
            double f = Math.round((1.8 * c + 32) * 100.0) / 100.0;
            fField.setText(String.format("%.2f", f));
        } catch (NumberFormatException e) {}
    }

    public void onCelsiusChange(KeyEvent keyEvent) {
        convertCtoF();
    }

    public void onFahrenheitChange(KeyEvent keyEvent) {
        convertFtoC();
    }
}



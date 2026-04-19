package sk.spse.uloha5.declarative;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PridajController {

    @FXML private TextField nazovField;
    @FXML private TextField kalorieField;
    @FXML private TextField cenaField;
    @FXML private Label chybaLabel;

    private Jedlo vysledok = null;
    private int nextId;

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public Jedlo getVysledok() {
        return vysledok;
    }

    @FXML
    private void potvrdit() {
        chybaLabel.setText("");

        String nazov = nazovField.getText().trim();
        if (nazov.isEmpty()) {
            chybaLabel.setText("Názov nesmie byť prázdny.");
            return;
        }

        int kalorie;
        try {
            kalorie = Integer.parseInt(kalorieField.getText().trim());
            if (kalorie < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            chybaLabel.setText("Kalórie musia byť kladné celé číslo.");
            return;
        }

        double cena;
        try {
            cena = Double.parseDouble(cenaField.getText().trim().replace(",", "."));
            if (cena < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            chybaLabel.setText("Cena musí byť kladné číslo (napr. 1.99).");
            return;
        }

        vysledok = new Jedlo(nextId, nazov, kalorie, cena);
        zavriet();
    }

    @FXML
    private void zrusit() {
        zavriet();
    }

    private void zavriet() {
        Stage stage = (Stage) nazovField.getScene().getWindow();
        stage.close();
    }
}
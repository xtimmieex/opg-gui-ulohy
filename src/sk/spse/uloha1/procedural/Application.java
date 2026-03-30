package sk.spse.uloha1.procedural;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

///
/// Trieda pre procedurálne vytvorené GUI
///
/// Upravujte túto triedu
///

public class Application extends javafx.application.Application {

    private TextField cField;
    private TextField fField;

    @Override
    public void start(Stage stage) {
        Label labelC = new Label("Stupne Celsia:");
        cField = new TextField("0");
        cField.setStyle("-fx-padding: 10 20 10 20;");
        Label unitC = new Label("C");

        HBox rowC = new HBox(10, labelC, cField, unitC);
        rowC.setAlignment(Pos.CENTER_RIGHT);
        rowC.setPadding(new Insets(10));

        Label labelF = new Label("Stupne Fahrenheita: ");
        fField = new TextField("0");
        fField.setStyle("-fx-padding: 10 20 10 20;");
        Label unitF = new Label("F");

        HBox rowF = new HBox(10, labelF, fField, unitF);
        rowF.setAlignment(Pos.CENTER_RIGHT);
        rowF.setPadding(new Insets(10));

        VBox root = new VBox(0, rowC, rowF);

        Scene scene = new Scene(root);

        cField.setOnKeyTyped(key -> convertCtoF());
        fField.setOnKeyTyped(key -> convertFtoC());

        stage.setTitle("Procedural Application 1");
        stage.setScene(scene);
        stage.show();
    }

    private void convertCtoF() {
        try {
            double c = Double.parseDouble(cField.getText());
            double f = 1.8 * c + 32;
            fField.setText(String.format("%.2f", f));
        } catch (NumberFormatException e) {}
    }

    private void convertFtoC() {
        try {
            double f = Double.parseDouble(fField.getText());
            double c = (f - 32) / 1.8;
            cField.setText(String.format("%.2f", c));
        } catch (NumberFormatException e) {}
    }
}
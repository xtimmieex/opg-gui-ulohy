package sk.spse.uloha5.declarative;

import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML private TableView<Jedlo> tabulka;
    @FXML private TableColumn<Jedlo, Integer> id;
    @FXML private TableColumn<Jedlo, String> nazovJedal;
    @FXML private TableColumn<Jedlo, Integer> kalorie;
    @FXML private TableColumn<Jedlo, Double> cena;

    private List<Jedlo> jedloList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tabulka.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        tabulka.setFixedCellSize(25);
        tabulka.prefHeightProperty().bind(tabulka.fixedCellSizeProperty().multiply(7).add(27));

        jedloList.add(new Jedlo(0, "Chlieb", 200, 2.0));
        jedloList.add(new Jedlo(1, "Mlieko", 300, 0.65));
        jedloList.add(new Jedlo(2, "Kebab", 500, 12.5));
        jedloList.add(new Jedlo(3, "Coca Cola", 30, 1.39));
        jedloList.add(new Jedlo(4, "Jablko", 50, 0.99));

        id.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().id()).asObject());
        nazovJedal.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().nazov()));
        kalorie.setCellValueFactory(p -> new SimpleIntegerProperty(p.getValue().kalorie()).asObject());
        cena.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().cena()).asObject());
        tabulka.getItems().setAll(jedloList);
    }

    @FXML
    private void pridaj() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pridaj_dialog.fxml"));
            Parent root = loader.load();

            PridajController dialogController = loader.getController();
            dialogController.setNextId(jedloList.size());

            Stage dialog = new Stage();
            dialog.setTitle("Pridať potravinu");
            dialog.setScene(new Scene(root));
            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(tabulka.getScene().getWindow());
            dialog.setResizable(false);
            dialog.showAndWait();

            Jedlo nove = dialogController.getVysledok();
            if (nove != null) {
                jedloList.add(nove);
                tabulka.getItems().add(nove);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void vymaz() {
        Jedlo selected = tabulka.getSelectionModel().getSelectedItem();
        if (selected != null) {
            jedloList.remove(selected);
            tabulka.getItems().remove(selected);
        }
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}
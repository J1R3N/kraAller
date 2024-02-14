package de.curelei.kraller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeiteresFensterController {
    @FXML
    private void oeffneAllergeneFenster() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/AllergeneFenster.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("AllergeneFenster");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void oeffneZusatzstoffeFenster() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ZusatzstoffeFenster.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("ZusatzStoffe");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void schliessen(ActionEvent event) {
        // Fenster wird Geschlossen
        Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

package de.curelei.kraller.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KategorienFensterController {

    @FXML
    public void oeffneKategorienFenster(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/KategorienFenster.fxml"));
            Parent root = loader.load();

            Stage primaryStage = new Stage();
            primaryStage.setScene(new Scene(root));
            primaryStage.setTitle("Kategorien");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package de.curelei.kraller.gui;

import de.curelei.kraller.KraAllerApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class KrallerApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        KraAllerApp s = new KraAllerApp();
        Label l = new Label("Hallo kraAller! "+s.getVersion());
        HBox root = new HBox();
        root.getChildren().add(l);
        Scene scene = new Scene(root, 300, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void oeffneWeiteresFenster() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WeiteresFenster.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("WeiteresFenster");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void oeffneKategorieFenster() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("KategorienFenster.fxml"));
            Parent root = loader.load();

            Stage k = new Stage();
            k.setScene(new Scene(root));
            k.setTitle("Kategorien");
            k.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


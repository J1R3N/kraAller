package de.curelei.kraller.gui;

import de.curelei.kraller.KraAllerApp;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class KrallerApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        KraAllerApp s = new KraAllerApp();
        URL res = getClass().getResource("/fxml/HauptFenster.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("Allergen-Auskunft");
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void oeffneWeiteresFenster() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/WeiteresFenster.fxml"));
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/KategorienFenster.fxml"));
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


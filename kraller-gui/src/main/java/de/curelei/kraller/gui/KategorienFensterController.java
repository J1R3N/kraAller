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

    public void schließeFenster(ActionEvent event) {
        Stage stage = (Stage) ((javafx.scene.control.Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void oeffneHeisseGetraenke() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/HeisseGetraenke.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Heiße Getränke");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneBiere() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Biere.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Biere");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneWeineUndWeinmixgetränke() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/WeineUndWeinmixgetränke.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Weine und Weinmixgetränke");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneAlkoholfreieGetränke() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/AlkoholfreieGetraenke.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("alkoholfreie Getränke");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneSpirituosen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Spirituosen.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Spirituosen");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneEisDessertGebäck() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/EisDessertsGebäck.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Eis/Dessert/Gebäck");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneSuppen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Suppen.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Suppen");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneToasts() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Toasts.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Toast´s");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffnePfannengerichte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Pfannengerichte.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Pfannengerichte");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneBratengerichte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Bratengerichte.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Bratengerichte");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneFischgerichte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Fischgerichte.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Fischgerichte");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneKleineGerichte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/KleineGerichte.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("kleine Gerichte");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneKalteKueche() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/KalteKueche.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("kalte Küche");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void oeffneSpargelgerichte() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Kategorien/Spargelgerichte.fxml"));
            Parent root = loader.load();

            Stage w = new Stage();
            w.setScene(new Scene(root));
            w.setTitle("Spargelgerichte");
            w.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

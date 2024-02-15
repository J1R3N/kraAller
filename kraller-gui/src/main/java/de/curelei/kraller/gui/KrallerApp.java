package de.curelei.kraller.gui;

import de.curelei.kraller.KraAllerApp;
import de.curelei.kraller.patient.Patient;
import de.curelei.kraller.patient.PatientDAO;
import de.curelei.kraller.patient.PatientDAOImpl;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class KrallerApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @FXML
    private TableView<Patient> personTable;

    @FXML
    private TableColumn<Patient, Integer> idColumn;

    @FXML
    private TableColumn<Patient, String> infoColumn;

    private final PatientDAO personDAO = new PatientDAOImpl();

    @FXML
    private void initialize() {
        // Set up cell value factories for columns
        idColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        infoColumn.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNname()));

        // Populate the TableView with data
        List<Patient> patients = personDAO.search();
        personTable.getItems().addAll(patients);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        KraAllerApp s = new KraAllerApp();
        URL res = getClass
                ().getResource("/fxml/HauptFenster.fxml");
        Parent root = FXMLLoader.load(res);
        primaryStage.setTitle("Allergen-Auskunft");
        Scene scene = new Scene(root, 500, 300);
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


package de.curelei.kraller.gui;

import de.curelei.kraller.KrallerService;
import de.curelei.kraller.KrallerServiceImpl;
import de.curelei.kraller.db.H2AllergenDAO;
import de.curelei.kraller.db.H2GerichtDAO;
import de.curelei.kraller.db.H2PatientDAO;
import de.curelei.kraller.gericht.Gericht;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class KrallerApp extends Application {
    KrallerService krallerService = new KrallerServiceImpl(new H2PatientDAO(), new H2GerichtDAO(), new H2AllergenDAO());

    public KrallerApp() {
    }

    public KrallerApp(KrallerService krallerService) {
        this.krallerService = krallerService;
    }


    @FXML
    private TableView<Gericht> gerichtTable;
    @FXML
    private TableColumn<Gericht, Integer> idColumn;

    @FXML
    private TableColumn<Gericht, String> infoColumn;

    @Override
    public void start(Stage primaryStage) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Hauptfenster.fxml"));
            loader.setController(this); // Set the controller to the current instance of KrallerApp
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Allergenauskunft");
            primaryStage.show();
            System.out.println("Applikation wurde gestartet");
            loadGerichtData();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadGerichtData() {
        try {
            List<Gericht> gerichtList = krallerService.getAllGerichte();
            ObservableList<Gericht> observableGerichtList = FXCollections.observableArrayList(gerichtList);

            gerichtTable.setItems(observableGerichtList);
            gerichtTable.refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Gerichte wurden geladen!");
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
            System.out.println("WeiteresFenster wurden geladen");
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
            System.out.println("KategorienFenster wurden geladen");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        KrallerService krallerService = new KrallerServiceImpl(new H2PatientDAO(), new H2GerichtDAO(), new H2AllergenDAO());

        System.out.println("Pruefe auf korrekte Datenbank-Übermittlung");
        try {
            List<Gericht> gerichte = krallerService.getAllGerichte();
            for (Gericht gericht : gerichte) {
                System.out.println("ID: " + gericht.getId() + ", Bezeichnung: " + gericht.getBezeichnung());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch(args);
    }
}

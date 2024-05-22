package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuPrincipal {
    private Stage primaryStage;

    public MenuPrincipal(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void load(Scene scene) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Title
        Text title = new Text("Menu");
        title.setFont(Font.font("Ubuntu", 38));
        title.setFill(Color.web("#00215E"));
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // Menu Options
        VBox menuOptions = new VBox(20);
        menuOptions.setAlignment(Pos.CENTER);
        menuOptions.setPadding(new Insets(20));

        // Option: Paramètres du Compte
        Button accountSettingsButton = createMenuButton("Paramètres du Compte");
        accountSettingsButton.setOnAction(e -> {
            // Navigate to Account Settings Page
            // AccountSettingsPage accountSettingsPage = new AccountSettingsPage(primaryStage);
            // accountSettingsPage.load(scene);
        });

        // Option: Consulter le Dossier d'un Patient
        Button viewPatientRecordsButton = createMenuButton("Consulter le Dossier d'un Patient");
        viewPatientRecordsButton.setOnAction(e -> {
            // Navigate to View Patient Records Page
            ViewPatientRecordsPage viewPatientRecordsPage = new ViewPatientRecordsPage(primaryStage);
            viewPatientRecordsPage.load(scene);
        });

        // Option: Ajouter un Patient
        Button addPatientButton = createMenuButton("Créer un dossier pour un nouveau Patient");
        addPatientButton.setOnAction(e -> {
            // Navigate to Add Patient Page
            AddPatientPage addPatientPage = new AddPatientPage(primaryStage);
            addPatientPage.load(scene);
        });

        // Option: Supprimer un Patient
        Button removePatientButton = createMenuButton("Supprimer le dossier d'un Patient");
        removePatientButton.setOnAction(e -> {
            // Navigate to Remove Patient Page
            RemovePatientPage removePatientPage = new RemovePatientPage(primaryStage);
            removePatientPage.load(scene);
        });

        // Option: Gestion des Tests et Anamnèses
        Button manageTestsButton = createMenuButton("Gestion des Tests et Anamnèses");
        manageTestsButton.setOnAction(e -> {
            // Navigate to Manage Tests Page
            // ManageTestsPage manageTestsPage = new ManageTestsPage(primaryStage);
            // manageTestsPage.load(scene);
        });

        // Option: Se déconnecter de l'application
        Button logOutButton = createMenuButton("Se déconnecter de l'application");
        logOutButton.setOnAction(e -> {
            // Navigate to Log Out Page
            // LogOutPage logOutPage = new LogOutPage(primaryStage);
            // logOutPage.load(scene);
        });

        menuOptions.getChildren().addAll(
                accountSettingsButton,
                viewPatientRecordsButton,
                addPatientButton,
                removePatientButton,
                manageTestsButton,
                logOutButton
        );

        root.setCenter(menuOptions);

        Scene menuScene = new Scene(root, 800, 700);
        menuScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(menuScene);
    }

    private Button createMenuButton(String text) {
        Button button = new Button(text);
        button.getStyleClass().add("menu-button");
        button.setPrefWidth(500);
        button.setPrefHeight(60);
        return button;
    }
}

package application;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddPatientPage {
    private Stage primaryStage;
    private Label messageLabel;
    Orthophoniste orthophoniste;
    // les comptes des orthophonistes qui l'utilisent 
    private HashSet<Orthophoniste> comptesUtilisateurs = new HashSet<Orthophoniste>();

    public AddPatientPage(Stage primaryStage,Orthophoniste orthophoniste) {
        this.primaryStage = primaryStage;
        this.orthophoniste= orthophoniste;
    }

    public void load(Scene scene) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Title
        Text title = new Text("Ajouter un Nouveau Patient");
        title.setFont(Font.font("Ubuntu", 30));
        title.setFill(Color.web("#00215E"));
        BorderPane.setAlignment(title, Pos.CENTER);
        root.setTop(title);

        // Form
        VBox form = new VBox(10);
        form.setAlignment(Pos.CENTER);

        TextField nameField = new TextField();
        nameField.setPromptText("Nom du patient");
        nameField.setMaxWidth(200);

        TextField surenameField = new TextField();
        surenameField.setPromptText("Prénom");
        surenameField.setMaxWidth(200);

        TextField birthdayField = new TextField();
        birthdayField.setPromptText("Date de naissance du patient ( jj / mm / yyyy )");
        birthdayField.setMaxWidth(200);

        TextField birthPlaceField = new TextField();
        birthPlaceField.setPromptText("Lieu de naissance du patient");
        birthPlaceField.setMaxWidth(200);

        TextField addressField = new TextField();
        addressField.setPromptText("Adresse du patient");
        addressField.setMaxWidth(200);

        form.getChildren().addAll(nameField, surenameField, birthdayField, birthPlaceField, addressField);

        // Message Label
        messageLabel = new Label();
        form.getChildren().add(messageLabel);

        // Submit Button
        Button submitButton = new Button("Ajouter le Patient");
        submitButton.getStyleClass().add("button-style");
        submitButton.setOnAction(e -> {
            // Handle form submission
            String name = nameField.getText();
            String surename = surenameField.getText();
            String birthday = birthdayField.getText();
            String birthPlace = birthPlaceField.getText();
            String address = addressField.getText();

            // Convertir la date de naissance en LocalDate
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dateDeNaissance = LocalDate.parse(birthday, formatter);

            // Calculer l'âge du patient
            int agePatient = Period.between(dateDeNaissance, LocalDate.now()).getYears();

            // Créer le dossier du patient
            Dossier dossierPatient = new Dossier(name, surename, agePatient, address, birthday, birthPlace);

            // Créer le patient avec le dossier
            Patient patient = new Patient(dossierPatient);

            comptesUtilisateurs = loadComptesOrthophonisteFromFile();
             if (comptesUtilisateurs.contains(orthophoniste)) {
            	 comptesUtilisateurs.remove(orthophoniste);
            }
            
             if (orthophoniste.getListePatients() == null) {
            	 orthophoniste.setListePatients(new HashSet<>())  ;
            	}
             if (!orthophoniste.getListePatients().contains(patient))   orthophoniste.getListePatients().add(patient);
           
            comptesUtilisateurs.add(orthophoniste); // ajouter apres le changement
            
            saveComptesOrthophonisteToFile( comptesUtilisateurs); // sauvegarder les nouvelles données dans un fichier
            

            setMessage("Le patient a été ajouté avec succès.", "green");
        });

        // Back Button
        Button backButton = new Button("Retour");
        backButton.getStyleClass().add("button-style");
        backButton.setOnAction(e -> {
            MenuPrincipal menuPrincipal = new MenuPrincipal(primaryStage,orthophoniste);
            menuPrincipal.load(scene);
        });

        // Button Container
        VBox buttonBox = new VBox(10, submitButton, backButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20));

        root.setCenter(form);
        root.setBottom(buttonBox);
        BorderPane.setAlignment(buttonBox, Pos.CENTER);

        Scene addPatientScene = new Scene(root, 800, 700);
        addPatientScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        primaryStage.setScene(addPatientScene);
    }

    public void saveComptesOrthophonisteToFile(HashSet<Orthophoniste> comptesUtilisateurs) {
    	File f = new File ("comptesOrthophoniste.ser");
        try (FileOutputStream fileOut = new FileOutputStream(f);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(comptesUtilisateurs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
    
    public HashSet<Orthophoniste> loadComptesOrthophonisteFromFile() {
        HashSet<Orthophoniste> comptesUtilisateurs = new HashSet<>();
        File f = new File("comptesOrthophoniste.ser");
        if (f.exists()) {
            try (FileInputStream fileIn = new FileInputStream(f);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {
                comptesUtilisateurs = (HashSet<Orthophoniste>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return comptesUtilisateurs;
    }
    private void setMessage(String message, String color) {
        messageLabel.setText(message);
        messageLabel.setStyle("-fx-text-fill: " + color + ";");
    }
}

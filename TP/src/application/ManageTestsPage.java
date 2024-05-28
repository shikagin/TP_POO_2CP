package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Accordion;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class ManageTestsPage {
    private Stage primaryStage;
    private Patient patient;

    public ManageTestsPage(Stage primaryStage, Patient patient) {
        this.primaryStage = primaryStage;
        this.patient = patient;
    }

    public void load(Scene scene) {
        primaryStage.setTitle("Gestion des Tests");

        // Main menu options
        Label gestionQuestionnaireLabel = createLabel("Gestion des Questionnaires");
        Label gestionExercicesLabel = createLabel("Gestion des Séries d'Exercices");
        Label gestionAnamnesesLabel = createLabel("Gestion des Anamnèses");

        // Sub-menus
        VBox questionnaireOptions = createSubMenu(
                createLabel("Ajouter une question à un questionnaire", event -> goToAjoutQuestionPage()),
                createLabel("Supprimer une question d'un questionnaire", event -> goToSupprQuestionPage()),
                createLabel("Modifier une question dans un questionnaire")
        );

        VBox exercicesOptions = createSubMenu(
                createLabel("Ajouter un exercice à une série d'exercices"),
                createLabel("Supprimer un exercice d'une série d'exercices"),
                createLabel("Modifier un exercice dans une série d'exercices")
        );

        VBox anamnesesOptions = createSubMenu(
                createLabel("Ajouter une anamnèse à un bilan orthophonique"),
                createLabel("Supprimer l'anamnèse d'un patient de son BO"),
                createLabel("Modifier l'anamnèse d'un patient")
        );

        VBox modifyAnamneseOptions = createSubMenu(
                createLabel("Ajouter une nouvelle question à l'anamnèse d'un patient"),
                createLabel("Supprimer une question d'une anamnèse"),
                createLabel("Modifier une question dans une anamnèse")
        );

        TitledPane modifyAnamnesePane = new TitledPane("Modifier l'anamnèse d'un patient", modifyAnamneseOptions);
        modifyAnamnesePane.getStyleClass().add("titled-pane");
        anamnesesOptions.getChildren().add(modifyAnamnesePane);

        // TitledPanes
        TitledPane gestionQuestionnaireTitledPane = new TitledPane("Gestion des Questionnaires", questionnaireOptions);
        TitledPane gestionExercicesTitledPane = new TitledPane("Gestion des Séries d'Exercices", exercicesOptions);
        TitledPane gestionAnamnesesTitledPane = new TitledPane("Gestion des Anamnèses", anamnesesOptions);

        // Accordion
        Accordion accordion = new Accordion();
        accordion.getPanes().addAll(gestionQuestionnaireTitledPane, gestionExercicesTitledPane, gestionAnamnesesTitledPane);

        StackPane root = new StackPane(accordion);
        scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Label createLabel(String text) {
        Label label = new Label(text);
        label.getStyleClass().add("options-label");
        return label;
    }
    
    private Label createLabel(String text, EventHandler<MouseEvent> eventHandler) {
        Label label = createLabel(text);
        label.setOnMouseClicked(eventHandler);
        return label;
    }

    private VBox createSubMenu(Label... options) {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        vbox.getStyleClass().add("options-box");
        for (Label option : options) {
            vbox.getChildren().add(option);
        }
        return vbox;
    }

    private void goToAjoutQuestionPage() {
        AjoutQuestionPage ajoutQuestionPage = new AjoutQuestionPage(primaryStage,patient);
        ajoutQuestionPage.load(new Scene(new StackPane(), 600, 600));  // Adjust the scene as needed
    }
    
    private void goToSupprQuestionPage() {
    	SupprQuestionPage supprQuestionPage = new SupprQuestionPage(primaryStage,patient);
        supprQuestionPage.load();  // Adjust the scene as needed
    }
}

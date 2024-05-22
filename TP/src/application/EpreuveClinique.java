package application;
import java.util.ArrayList;
import java.util.Arrays;

public class EpreuveClinique {
    
    private String[] observationClinique; 
    private ArrayList<Test> listeTests; 
    
    public EpreuveClinique() {
        this.observationClinique = new String[0];
        this.listeTests = new ArrayList<>();
    }

    // Méthode d'ajout d'un test (questionnaire/série d'exercices)
    public void ajouterTest(Test nouveauTest) {
        if (!listeTests.contains(nouveauTest)) {
            listeTests.add(nouveauTest);
        } else {
            System.out.println("Le test que vous voulez ajouter existe déjà.");
        }
    }
    
    // Méthode de suppression d'un test
    public void supprimerTest(Test ancienTest) {
        if (listeTests.contains(ancienTest)) {
            listeTests.remove(ancienTest);
        } else {
            System.out.println("Le test que vous voulez supprimer n'existe pas.");
        }
    }
    
    // Méthode pour modifier un test 
    public void modifierTest(Test ancienTest, Test nouveauTest) {
    	if (listeTests.contains(ancienTest)) {
            listeTests.remove(ancienTest);
            listeTests.add(nouveauTest);
        } else {
            System.out.println("La question à modifier n'existe pas dans la liste.");
        }
    }

    // Méthode d'ajout d'une observation
    public void ajouterObservation(String nouvelleObservation) {
        ArrayList<String> observationsList = new ArrayList<>(Arrays.asList(observationClinique));
        if (!observationsList.contains(nouvelleObservation)) {
            observationsList.add(nouvelleObservation);
            observationClinique = observationsList.toArray(new String[0]);
            System.out.println("Observation ajoutée avec succès.");
        } else {
            System.out.println("L'observation existe déjà.");
        }
    }

    // Méthode de suppression d'une observation
    public void supprimerObservation(String observationASupprimer) {
        ArrayList<String> observationsList = new ArrayList<>(Arrays.asList(observationClinique));
        if (observationsList.contains(observationASupprimer)) {
            observationsList.remove(observationASupprimer);
            observationClinique = observationsList.toArray(new String[0]);
            System.out.println("Observation supprimée avec succès.");
        } else {
            System.out.println("L'observation n'existe pas.");
        }
    }
    

    // Méthode d'affichage d'une épreuve clinique
    public void afficherEpreuveClinique() {        
        // Affichage des observations cliniques
        System.out.println("Observations cliniques :");
        afficherObservations();
        
        // Affichage des tests
        afficherTests();
    }

    // Méthode d'affichage des observations (pour vérifier)
    public void afficherObservations() {
        System.out.println("Observations cliniques : ");
        for (String observation : observationClinique) {
            System.out.println("- " + observation);
        }
    }
    
   // Méthode d'affichage des tests
   public void afficherTests() {
        System.out.println("Tests :");
        if (listeTests.isEmpty()) {
            System.out.println("Aucun test disponible.");
        } else {
            for (Test test : listeTests) {
                test.afficherTest();
            }
        }
    }
   
   public ArrayList<Test> getListeTests (){
	   return this.listeTests;
   }
}


import java.util.ArrayList;


public class TestExercices extends Test {
	ArrayList<Exercice> exercices;


	public TestExercices(String nom, int capacite, String conclusion) {
		super(nom, capacite, conclusion);
		this.exercices = new ArrayList<Exercice>() ;
	}

	
	@Override
	// Méthode de calcul du score total d'un test (série d'exercices)
	public float calculeScoreTotal() {

		for (Exercice ex : exercices) {
			scoreTotal = +ex.calculeMoyenne();

		}
		return (scoreTotal);
	}

	// Méthode d'ajout d'un exercice à la liste des exercices
	public void ajouterExercice(String consigne, String nomMateriel, float scores[]) {
		Exercice exercice = new Exercice (consigne, nomMateriel, scores);
		exercices.add(exercice);
	}

	// Méthode de recherche d'un exercice (retourne la position de l'exercice dans la liste)
	public int rechercherExercice(String consigne) {
		int pos = 0;
		for (Exercice ex : exercices) {
			if (ex.equals(consigne) == true) {
				break;
			}
			pos++;
		}
		return (pos);
	}

	public void supprimerExercice(String consigne) {
		int p = rechercherExercice(consigne);
		exercices.remove(p);
	}

	
}


public class QstLibreAnamneseAdulte extends QstLibreAnamnese {
	
	private TypeQstAnamneseAdulte categorie ;
	
	public QstLibreAnamneseAdulte(String enonce, String categorie) {
		super(enonce);
		switch (categorie) {
		case "Histoire de la maladie" : this.categorie = TypeQstAnamneseAdulte.HistoireMaladie ; break ;
		case "Suivi médical" : this.categorie = TypeQstAnamneseAdulte.SuiviMedical ; break ;
		default : throw new IllegalArgumentException("Catégorie de question inconnue : " + categorie) ;
		}
		
	}

	// Méthode d'affichage d'une question d'anamnèse (Adulte)
	public void afficherQuestion() {
		System.out.print("Enoncé : ") ;
		System.out.println(super.enonce) ;
		System.out.print("Catégorie : ") ;
		System.out.println(categorie) ;
	}
}
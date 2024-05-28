package application;
public class RendezVous {
    private String date;
    private String heure;
    private String Observation;
    protected Type type;
    
	// Le constructeur de la classe RendezVous 
	 public RendezVous(String date, String heure) {
		this.date=date;
		this.heure=heure;
	
	}
	
	 // Les Getters
	 public String getDate() {
		 return this.date;
	 }
	 
	 public String getHeure() {
		 return this.heure;
	 }
	 
	 public String getObservation() {
		 return this.Observation;
	 }
	 
	 public Type getType() {
		 return this.type;
	 }

     // Les setters
	 public void setHeure(String heure) {
		 this.heure=heure;
	 }

	 public void setDate(String date) {
		 this.date=date;
	 }
	 public void setType(Type type) {
		 this.type=type;
	 }
	 
	public void AfficherRendezVous () {
		System.out.println(" La date du Rendez Vous : "+this.date);
		System.out.println(" L'heure du Rendez Vous : "+this.heure);
		System.out.println(" Le type du Rendez Vous : "+this.type);
		System.out.println(" L'observation à la fin du Rendez Vous : "+this.Observation);
	}
	 
	 	 
	 // Comme si un setter de l'attribut Observation
	 public void AjouterObservation(String Observation) {
		 this.Observation=Observation;
	 }
	 	
}

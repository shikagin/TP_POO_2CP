
public class SeanceDeSuivi extends RendezVous {
    private int NmrPatient;
    private enum Etat {PRESENTIEL,ENLIGNE};
    private final String duree="1h";
    private Etat etat;
    
    // Le constructeur de la classe SeanceDeSuivi 
	public SeanceDeSuivi(String date, String heure, Type type,int NmrPatient,Etat etat) {
		super (date,heure,type);
	 this.NmrPatient=NmrPatient;
	 this.etat=etat;
	}
	
	// Les getters de la classe SeanceDesuivi 
	public int getNmrPatient() {
		return this.NmrPatient;
	}
	
	public Etat getEtat() {
		return this.etat;
	}
	
	public String getDuree() {
		return this.duree;
	}
	
	// Les setters de la classe SeanceDeSuivi 
	public void setNmrPatient(int NmrPatient) {
		this.NmrPatient=NmrPatient;
	}
	
	public void setEtat(Etat etat) {
		this.etat=etat;
	}
		
	public void AfficherRendezVous() {
		super.AfficherRendezVous();
		System.out.println("La séance de suivi est déroulée en : "+this.etat);
		System.out.println("Le numéro du patient : "+this.NmrPatient);
		System.out.println("La durée de la séance e suivi : 1h");
	}
	

}

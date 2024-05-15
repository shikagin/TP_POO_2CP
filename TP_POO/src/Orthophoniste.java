// Compte d'utilisateur de l'application "Cabinet Orthophonique"

import java.util.* ;
import java.time.* ;
import java.time.format.* ;

public class Orthophoniste {

	// Informations de l'orthophoniste
	private String nom ;
	private String prenom ;
	private String numeroTelephone ;
	private String adresse ;
	private String adresseEmail ;
	private String motDePass ;
	
	// Liste des patients de l'orthophoniste
	private ArrayList<Patient> listePatients ;
	
	// Agenda de l'orthophoniste
	// Agenda agendaOrthophoniste ;
	
	
	// Constructeur
	public Orthophoniste(String nom ,String prenom , String numeroTelephone , String adresse , String adresseEmail , String motDePass) {
		this.nom = nom ;
		this.prenom = prenom ;
		this.numeroTelephone = numeroTelephone ;
		this.adresse = adresse ;
		this.adresseEmail = adresseEmail ;
		this.motDePass = motDePass ;
	}
	

	// Méthode d'ajout d'un patient 
	public void AjouterPatient () {
		Scanner sc = new Scanner(System.in);
        
        System.out.print("Saisir le nom du patient : ");
        String nomPatient = sc.nextLine();
        
        System.out.print("Saisir le prénom du patient : ");
        String prenomPatient = sc.nextLine();
        
        System.out.print("Saisir la date de naissance du patient (format JJ/MM/AAAA) : ");
        String dateDeNaissanceStr = sc.nextLine();
        
        System.out.print("Saisir le lieu de naissance du patient : ");
        String lieuDeNaissance = sc.nextLine();
        
        System.out.print("Saisir l'adresse du patient : ");
        String adressePatient = sc.nextLine();

        // Convertir la date de naissance en LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateDeNaissance = LocalDate.parse(dateDeNaissanceStr, formatter);
        
        // Calculer l'âge du patient
        int agePatient = Period.between(dateDeNaissance, LocalDate.now()).getYears();
        
        // Créer le dossier du patient
        Dossier dossierPatient = new Dossier(nomPatient, prenomPatient, agePatient, adressePatient, dateDeNaissanceStr, lieuDeNaissance);
        
        // Créer le patient avec le dossier
        Patient patient = new Patient(dossierPatient);
        
        // Ajouter le patient à la liste des patients
        listePatients.add(patient);
        
        System.out.println("Patient ajouté avec succès !");
        
        sc.close() ;
    }
	
	
	// Méthode de suppression d'un patient 
	public void SupprimerPatient() {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Saisir le nom du patient à supprimer: ");
        String nomPatient = sc.nextLine();
        
        System.out.print("Saisir le prénom du patient à supprimer: ");
        String prenomPatient = sc.nextLine();
        
        Patient patientASupprimer = null;
        
        // Recherche du patient dans la liste (critère : nom & prénom)
        for (Patient patient : listePatients) {
            if (patient.getDossierPatient().getNom().equalsIgnoreCase(nomPatient) && 
                patient.getDossierPatient().getPrenom().equalsIgnoreCase(prenomPatient)) {
                patientASupprimer = patient;
                break;
            }
        }
        
        if (patientASupprimer != null) {
        	// Patient trouvé dans la liste
            listePatients.remove(patientASupprimer);
            System.out.println("Patient supprimé avec succès !");
        } else {
        	// Le patient n'existe pas dans la liste
            System.out.println("Patient non trouvé !");
        }
        
        sc.close() ;
    }

	
	/* Autres méthodes : ajouterRendezVous, SupprimerRendezVous, CreerAnamnese, SauvegarderAnamnese,
	CreerTest, SauvegarderTest, ModifierAnamnese, ModifierTest (ajout, suppression, modification) */

	// Getter & Setters 
	public String getAdresseEmail() {
		return adresseEmail ;
	}
	
	public String getMotDePass() {
		return motDePass ;
	}
}

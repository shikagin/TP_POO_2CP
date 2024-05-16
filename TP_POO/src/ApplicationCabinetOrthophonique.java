import java.util.* ;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ApplicationCabinetOrthophonique {
	// L'application contient les comptes des orthophonistes qui la utilisent 
	private ArrayList<Orthophoniste> comptesUtilisateurs ;
	
	// Initialisation de la liste des comptes d'utilisateurs
	public ApplicationCabinetOrthophonique() {
		comptesUtilisateurs = new ArrayList<Orthophoniste>() ;
	}
	
	
	// Méthode de création d'un nouveau compte utilisateur
	public void creerNouveauCompte() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Création d'un nouveau compte utilisateur");

        System.out.print("Saisir votre nom : ");
        String nom = sc.nextLine();

        System.out.print("Saisir votre prénom : ");
        String prenom = sc.nextLine();

        System.out.print("Saisir votre numéro de téléphone : ");
        String numeroTelephone = sc.nextLine();

        System.out.print("Saisir votre adresse : ");
        String adresse = sc.nextLine();

        System.out.print("Saisir votre adresse email : ");
        String adresseEmail = sc.nextLine();

        String motDePass;
        while (true) {
            System.out.print("Saisir votre mot de passe : ");
            motDePass = sc.nextLine();
            if (verifierMotDePasse(motDePass)) {
                break;
            } else {
                System.out.println("Le mot de passe doit contenir au moins 8 caractères, dont une majuscule, une minuscule, un chiffre et un caractère spécial.");
            }
        }

        // Créer un nouvel orthophoniste avec les informations fournies
        Orthophoniste nouvelOrthophoniste = new Orthophoniste(nom, prenom, numeroTelephone, adresse, adresseEmail, motDePass);

        // Ajouter le nouvel orthophoniste à la liste des comptes utilisateurs
        comptesUtilisateurs.add(nouvelOrthophoniste);

        System.out.println("Nouveau compte utilisateur créé avec succès!");
        
        sc.close();
    }

    // Méthode de vérification du mot de passe
    private boolean verifierMotDePasse(String motDePasse) {
        // Mot de passe doit contenir au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial
        String motDePasseRegEx = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(motDePasseRegEx);
        Matcher matcher = pattern.matcher(motDePasse);
        return matcher.matches();
    }
    
    
    // Méthode d'authentification (accès au compte utilisateur)
    public Orthophoniste authentifierUtilisateur() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Authentification de l'utilisateur");

        System.out.print("Saisir votre adresse email : ");
        String adresseEmail = sc.nextLine();

        System.out.print("Saisir votre mot de passe : ");
        String motDePass = sc.nextLine();

        sc.close() ;
        
        for (Orthophoniste orthophoniste : comptesUtilisateurs) {
            if (orthophoniste.getAdresseEmail().equals(adresseEmail) && orthophoniste.getMotDePass().equals(motDePass)) {
                System.out.println("Authentification réussie !");
                return orthophoniste;
            }
        }
        
        System.out.println("Erreur d'authentification! Adresse email ou mot de passe incorrect.");
        return null ;
    }
    
    
    // Menu à afficher pour l'orthophoniste après l'authentification
    public void menuOrthophoniste(Orthophoniste orthophoniste) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Ajouter un patient");
            System.out.println("2. Supprimer un patient");
            System.out.println("3. Se déconnecter");
            System.out.print("Choisir une option: ");
            int choix = sc.nextInt();
            sc.nextLine(); 

            if (choix == 1) {
                orthophoniste.AjouterPatient();
            } else if (choix == 2) {
                orthophoniste.SupprimerPatient();
            } else if (choix == 3) {
                System.out.println("Déconnexion réussie!");
                break;
            } else {
                System.out.println("Option invalide. Veuillez réessayer.");
            }
        }
        sc.close() ;
    }
    
}

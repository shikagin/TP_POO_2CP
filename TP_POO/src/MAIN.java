import java.util.* ; 

public class MAIN {
	public static void main(String[] args) {
	    ApplicationCabinetOrthophonique app = new ApplicationCabinetOrthophonique();

	    Scanner sc = new Scanner(System.in);
	    while (true) {
	        System.out.println("1. Créer un nouveau compte");
	        System.out.println("2. Se connecter");
	        System.out.println("3. Quitter");
	        System.out.print("Choisir une option: ");
	        int choix = sc.nextInt();
	        sc.nextLine(); 

	        if (choix == 1) {
	            app.creerNouveauCompte();
				break ;
	        } else if (choix == 2) {
	            Orthophoniste orthophoniste = app.authentifierUtilisateur();
	            if (orthophoniste != null) {
	                app.menuOrthophoniste(orthophoniste);
	            }
				break ;
	        } else if (choix == 3) {
	            System.out.println("Au revoir!");
	            break;
	        } else {
	            System.out.println("Option invalide. Veuillez réessayer.");
	        }
	    }
	    sc.close() ;
	}

}

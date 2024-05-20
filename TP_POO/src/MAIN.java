import java.util.* ; 

public class MAIN {
	public static void main(String[] args) {
	    ApplicationCabinetOrthophonique app = new ApplicationCabinetOrthophonique();

	    Scanner sc = new Scanner(System.in);
	    boolean MenuBool =true;
	    while (MenuBool) {
	        System.out.println("1. Créer un nouveau compte");
	        System.out.println("2. Se connecter");
	        System.out.println("3. Quitter");
	        System.out.print("Choisir une option: ");
	        int choix = sc.nextInt();
	        sc.nextLine(); 

	        if (choix == 1) {
	            app.creerNouveauCompte();		
	        } 
	        if (choix == 2) {
	            Orthophoniste orthophoniste = app.authentifierUtilisateur();
	            if (orthophoniste != null) {
	                app.menuOrthophoniste(orthophoniste);
	            }
				
	        } if (choix == 3) {
	        	MenuBool=false;
	            System.out.println("Au revoir!");
	           
	        } if(choix>3) {
	            System.out.println("Option invalide. Veuillez réessayer.");
	        }
	        
	    }
	    sc.close() ;
	}

}

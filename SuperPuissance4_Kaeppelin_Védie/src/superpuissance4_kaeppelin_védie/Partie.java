package superpuissance4_kaeppelin_védie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KAEPPELIN Mayeul
 */
public class Partie {

    Joueur[] ListeJoueurs = new Joueur[2];// tableau de 2 joueurs créé. ListeJoueur est de type Joueur
    Joueur joueurCourant; // joueurCourant est de type Joueur 
    Grille GrilleJeu = new Grille(); // la grille de jeu GrilleJeu sera de type Grille définit dans la classe Grille

    public void attribuerCouleursAuxJoueurs() { // nous allons maintenant attribuer les couleurs jaune ou rouge au joueur 
        Random generateurAleat = new Random(); // generons un chiffre aléatoire pour choisir les couleurs
        int n = generateurAleat.nextInt(1); // nombre aléatoire entre 0 et 1 
        if (n != 1) {// toute cette partie va servir à dire si le joueur 1 a le numéro 1 alors il sera rouge et l'autre jaune; et inversement 
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
            System.out.println("la couleur de " + ListeJoueurs[0].Nom + " est " + ListeJoueurs[0].Couleur); // affichage du nom du joueur et de sa couleur
            System.out.println("la couleur de " + ListeJoueurs[1].Nom + " est " + ListeJoueurs[1].Couleur);
        } else {
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
           System.out.println("la couleur de " + ListeJoueurs[0].Nom + " est " + ListeJoueurs[0].Couleur);
            System.out.println("la couleur de " + ListeJoueurs[1].Nom + " est " + ListeJoueurs[1].Couleur);
        }

    }

    public void initialiserPartie() { // initialisons la partie maintenant ( permet de débuter la partie et de jouer )
        //Création de la grille
        GrilleJeu.viderGrille();// important de vider la grille lorque nous commençons la partie
        int nbTN = 0;
        while (nbTN <= 5) {// va placer le désintégrateur sur les cellules 
            int ligne = (int) (Math.random() * 6);// numéro de ligne au hasard
            int colone = (int) (Math.random() * 7);// numéro de colonne au hasard
            if (GrilleJeu.CellulesJeu[ligne][colone].desintegrateur == false && GrilleJeu.CellulesJeu[ligne][colone].trouNoir == false) {// va placer des désintegrateurs sur les cellules seulement si la cellule ne contient pas de trous noirs ou de désintégrateurs
                if (nbTN == 4 || nbTN == 5) { // si le nb de trous noirs est égal à 4 ou 5
                    GrilleJeu.placerTrouNoir(ligne, colone); //on en place un
                    GrilleJeu.placerDesintegrateur(ligne, colone); // et on place un désintégrateur
                } else { 
                    GrilleJeu.placerTrouNoir(ligne, colone);
                }
                nbTN += 1;
            }
        }

        int nbDesint = 0; // nous allons placer 4 désintégrateurs
        while (nbDesint <= 3) {
            int ligne = (int) (Math.random() * 6);// nous gérerons un nombre aléatoire comme auparavant
            int colone = (int) (Math.random() * 7);
            if (GrilleJeu.CellulesJeu[ligne][colone].desintegrateur == false && GrilleJeu.CellulesJeu[ligne][colone].trouNoir == false) {
                GrilleJeu.placerDesintegrateur(ligne, colone);
                nbDesint += 1;
            } else {
                nbDesint = nbDesint;
            }
        }
        
        for (int i = 0; i < 21; i++) {
            if (ListeJoueurs[0].Couleur.equals("jaune")) { // si la couleur du joueur est jaune  alors ses jetons seront jaunes
                Jeton jetonjoueurR = new Jeton("jaune");
                ListeJoueurs[0].ajouterJeton(jetonjoueurR);
                Jeton jetonjoueurJ = new Jeton("rouge");
                ListeJoueurs[1].ajouterJeton(jetonjoueurJ);
            } else { // sinon ses jetons sont rouges!
                Jeton jetonjoueurR = new Jeton("jaune"); 
                ListeJoueurs[1].ajouterJeton(jetonjoueurR);
                    Jeton jetonjoueurJ = new Jeton("rouge");
                ListeJoueurs[0].ajouterJeton(jetonjoueurJ);
            }
        }
    }

    public void debuterPartie() {
        //inscription des 2 joueurs:
        Scanner sca = new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur :");
        String Joueur1 = sca.next(); //l'utilisateur entre son nom
        System.out.println("Entrez le nom du second joueur :");
        String Joueur2 = sca.next(); //le deuxième aussi
        Joueur J1 = new Joueur(Joueur1); //on les appelle J1 et J2
        Joueur J2 = new Joueur(Joueur2);
        ListeJoueurs[0] = J1;
        ListeJoueurs[1] = J2;

        // premier joueur à commencer la partie 
        Random generateurAleat = new Random();
        int n = generateurAleat.nextInt(1);
        if (n != 1) {
            joueurCourant = ListeJoueurs[0];

        } else {
            joueurCourant = ListeJoueurs[1];
        }

        attribuerCouleursAuxJoueurs();    //Distribution des couleurs:

        initialiserPartie(); 

        while (GrilleJeu.etreRemplie() == false/* tant que la grille n'est pas remplie*/ && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false /*et que aucun des joueurs n'a gagné*/ && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == false) {
            GrilleJeu.afficherGrilleSurConsole(); 

            Scanner sc = new Scanner(System.in);
            System.out.println(joueurCourant.Nom + ", c'est à vous de jouer ! ");
            System.out.println(joueurCourant.Nom + ", il vous reste " + joueurCourant.nombreDesintegrateurs + " désintégrateurs.");
            System.out.println("1) Placer un jeton");
            System.out.println("2) Récupérer un jeton");
            System.out.println("3) Utiliser un désintégrateur");
            int saisie = sc.nextInt(); //on demande l'action que souhaite effectuer le joueur
            while (saisie > 3 || saisie <= 0) {
                System.out.println("ERREUR!! Veuillez ressaisir un chiffre compris entre 1 et 3:");
                saisie = sc.nextInt();

            }
            if (saisie == 1) { //s'il décide de placer un jeton
                System.out.println("Entrez le numéro de colonne: ");
                Scanner s = new Scanner(System.in);
                int Numcolonne = s.nextInt() - 1; // on lui demande un num de colonne dans laquelle il souhaite jouer son jeton
                while (Numcolonne > 6 && Numcolonne < 0) { 
                    System.out.println("Ressaisissez un numéro de colonne");
                    Numcolonne = s.nextInt() - 1;

                }
                while (GrilleJeu.etreRemplie() == true) {
                    System.out.println("La colonne est pleine, entrez à nouveau un nouveau numéro de colonne");
                    Numcolonne = s.nextInt() - 1;

                }
                

                Jeton J = joueurCourant.ListeJetons[joueurCourant.nombreJetonsRestants - 1]; //on initialise J comme étant le nb de jeton restant
                GrilleJeu.ajouterJetonDansColonne(J, Numcolonne);
                
                joueurCourant.nombreJetonsRestants -= 1; // le joueur vient de jouer un jeton, donc -1 au nb de jetons restants
                System.out.println("Vous avez "+joueurCourant.nombreJetonsRestants +" jetons et "+joueurCourant.nombreDesintegrateurs+" désintégrateur(s) ");
            }

            if (saisie == 2) { //s'il décide de retirer un jeton
                Scanner nbre = new Scanner(System.in);
                System.out.println("Entrez le numéro de ligne du jeton à récupérer:");
                int ligne = nbre.nextInt()-1; //le joueur renseigne la ligne
                Scanner Nombre = new Scanner(System.in);
                System.out.println("Entrez le numéro de colonne du jeton à récupérer:");
                int colonne = Nombre.nextInt()-1; //puis la colonne
                
                while (ligne < 0 && ligne > 5) { //on effectue des tests pour etre sur que tout fonctionne bien
                    System.out.println("Veuillez recommencer");
                    ligne = nbre.nextInt() - 1;
                }
                
                while (colonne < 0 && colonne > 6) {
                    System.out.println("Veuillez recommencer");
                    colonne = nbre.nextInt() - 1;
                }
                

                if (GrilleJeu.celluleOccupee(ligne, colonne) == true && GrilleJeu.recupererJeton(ligne, colonne).Couleur.equals(joueurCourant.Couleur)) {
                    //si la cellule est occupée et que le jeton correspond à la couleur du joueur
                    joueurCourant.nombreJetonsRestants = joueurCourant.nombreJetonsRestants - 1; 
                    System.out.println(joueurCourant.Nom + ", il vous reste " + joueurCourant.nombreJetonsRestants);
                    GrilleJeu.tasserGrille(colonne); //on tasse la grille par soucis de gravité :)

                }

            }

            if (saisie == 3 && joueurCourant.nombreDesintegrateurs != 0) { //si l'utilisateur décide d'utiliser un désintégrateur (cette fonction ne marche pas)
                System.out.println("Vous allez utiliser un désintégrateur");
                Scanner nbre2 = new Scanner(System.in);
                System.out.println("Entrez votre numéro de ligne pour récuperer votre jeton");
                int ligne = nbre2.nextInt(); 

                while (ligne < 0 && ligne > 5) { //on fait des tests
                    System.out.println("Vous ne pouvez pas saisir un tel chiffre.");
                    ligne = nbre2.nextInt() - 1;
                }
                Scanner Nombre2 = new Scanner(System.in);
                int colonne = Nombre2.nextInt();

                while (colonne < 0 && colonne > 6) {
                    System.out.println("Vous ne pouvez pas saisir un tel chiffre");
                    colonne = Nombre2.nextInt() - 1;

                
                joueurCourant.utiliserDesintegrateur(); 
                GrilleJeu.supprimerJeton(ligne,colonne);
                GrilleJeu.tasserGrille(colonne);
                }
            }
             if (saisie == 3 && joueurCourant.nombreDesintegrateurs == 0) { //si le joueur ne possède pas de désintégrateur, message d'erreur
                    System.out.println("ERREUR: Vous n'avez pas de désintégrateur à utiliser");
                    System.out.println("Rechoississez ce que vous voulez faire: 1)Placer un jeton ou 2)Récupérer un jeton");
                    saisie = sc.nextInt();
                    while (saisie > 2 || saisie <= 0) {
                        System.out.println("ERREUR: Veuillez ressaisir un choix compris entre 1 et 2:");
                        saisie = sc.nextInt();
                    }
                }
            

            if (joueurCourant == ListeJoueurs[0]) { //nous oermet de changer de joueur à chaque fin de tour
                joueurCourant= ListeJoueurs[1] ;
            } else {
                joueurCourant= ListeJoueurs[0] ;
            }

            if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0]) == true) { //on vérifie à chaque fin de tour si les joueurs ont gagné ou non
                System.out.println(ListeJoueurs[0].Nom + " a gagné");
                break; //si oui, la partie se termine; sinon ca continue, on revient au début de débuterpartie
            }

            if (GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1]) == true) {
                System.out.println(ListeJoueurs[1].Nom + " a gagné");
                break;
            }

            if (GrilleJeu.etreRemplie() == true) { //si la grille est remplie sans gagnant
                System.out.println("La partie se termine, il n'y a pas de gagnant --> égalité!");
                break;
            }
    
        }
    }
    
}
    //afficher la grille
    //demander au joueur ce qu'il veut faire
    //placer un jeton dans une colonne
    //récupérer un jeton de la grille de jeu
    //utiliser un desintégrateur


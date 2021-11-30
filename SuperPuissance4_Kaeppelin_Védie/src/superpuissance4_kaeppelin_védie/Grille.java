/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_kaeppelin_védie;

/**
 *
 * @author vedie
 */
public class Grille {

    Cellule CellulesJeu[][]; // on initialise une nouvelle cellule nommée CellulesJeu avec comme arguments dans le premier [] le numéro de ligne et dans le deuxième le num de colonne

    public Grille() {
        CellulesJeu = new Cellule[6][7]; // on crée notre grille avec 6 lignes et 7 colonnes
        for (int i = 0; i < 6; i++) { 
            for (int j = 0; j < 7; j++) { // on fait deux boucles for avec i et j qui nous permet de parcourir toutes les cases du tableau
                CellulesJeu[i][j] = new Cellule(); //on crée une cellule pour chaque case du tableau en indiquant son num de ligne et de colonne
            }
        }

    }

    public boolean ajouterJetonDansColonne(Jeton JetonCourant, int Colonne) {  // la méthode prend en entrée le numéro de colonne dans laquelle le joueur souhaite insérer son jeton ainsi que le jeton en question
        // on va dans la colonne choisie, on parcourt les lignes du bas vers le haut jusqu'a qu'il y en ait une vide --> on met le jeton dedans.
        if (CellulesJeu[0][Colonne].jetonCourant != null) { // si la case la plus haute de la colonne remplie est remplie, alors on renvoie false
            return false; // nous permet de ne pas jouer dans une colonne déjà remplie
        }
        
        for (int i = 5; i >= 0; i--) { //on parcourt du bas vers le haut notre grille (notre ligne du haut étant la ligne 0)
            if (CellulesJeu[i][Colonne].jetonCourant == null) { // dès qu'une case de la colonne, en partant du bas, est libre, on insère le jeton dans cet
               

                return CellulesJeu[i][Colonne].affecterJeton(JetonCourant); //on affecte le jeton dans la cellule en question
                 // affecterJeton est une fonction qui renvoie un booléen, donc nous pouvons directement retourner ce que retourne la fonction: true si
                 // l'affectation s'est bien passée, false sinon.
            }
            
        }

        int i = 0;
        while (CellulesJeu[i][Colonne].jetonCourant != null) {
            if (CellulesJeu[i][Colonne].presenceDesintegrateurs()) {
                CellulesJeu[i][Colonne].recupererDesintegrateur(); //on récupère le désintégrateur s'il y en a un dans la colonne en question
              //  joueurCourant.nombreDesintegrateurs++; il aurait fallu incrémenter le nombre de désintégrateurs du joueurcourant,
               //mais nous n'y sommes pas arrivés, car nous voulions accéder au nb de désintégrateur via le joueurCourant, mais nous n'avons pas mis cette entrée
               //dans les paramètres de la méthode, donc notre nombre de désintégrateur n'augmente pas et il est malheureusement impossible de jouer avec.
            }

            // on active le potentiel trou noir dans la colonne en question
            if (CellulesJeu[i][Colonne].presenceTrouNoir()) {
                CellulesJeu[i][Colonne].activerTrouNoir();
            }
            
        }
        
        return true; //permet à l'ordinateur d'être 'rassuré' sur le fait qu'il y aura dans tous les cas une sortie booléenne, mais ce return true ne sera en fait jamais utilisé.

    }

    public boolean etreRemplie() { //on vérifie si la grille est remplie
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) { //on parcourt chacune des cellules grâces aux 2 boucles
                if (CellulesJeu[i][j] == null) { //dès qu'il y a une cellule vide (s'il y en a une)
                    return true; // la fonction return true
                } else { //si elle est remplie
                    return false; //false
                }
            }
        }
        return true; //pareil que pour la fonction ajouterJetonDansColonne, ne sera jamais utilisé.
    }

    public void viderGrille() { 
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j].jetonCourant = null; //on enlève tous les jetons
                CellulesJeu[i][j].trouNoir = false; // on désactive les trous noirs
                CellulesJeu[i][j].desintegrateur = false; //on désactive les désintégrateurs
            }
        }
    }

    public void afficherGrilleSurConsole() { 
        for (int i = 0; i < CellulesJeu.length; i++) { //on parcourt toute la grille
            for (int j = 0; j < CellulesJeu[0].length; j++) {

                if (CellulesJeu[i][j].presenceTrouNoir() == true) { // si il y a un trou noir dans une case
                    System.out.print("\u058D "); // on affiche un petit symbole (trouvé sur internet :) )
                } else if (CellulesJeu[i][j].presenceDesintegrateurs() == true && CellulesJeu[i][j].presenceTrouNoir() == false) { //si il y a un désintégrateur
                    System.out.print("\u235D "); // on affiche un autre symbole
                } else if (CellulesJeu[i][j].jetonCourant != null) { //si il existe un jeton dans la cellule
                    if ("rouge".equals(CellulesJeu[i][j].jetonCourant.Couleur)) {  // si c'est rouge on affiche R
                        System.out.print("R ");
                    }
                    if ("jaune".equals(CellulesJeu[i][j].jetonCourant.Couleur)) { // si c'est jaune on affiche J
                        System.out.print("J ");
                    }
                } else {
                    System.out.print("\u2395 "); // si il n'y a rien dans la case, on affiche une case vide.
                }
            }
            System.out.println(); // on revient à la ligne à chaque fin de boucle j, donc à chaque fois qu'on a parcouru une ligne, pour avoir une grille sous forme de tableau
        }
    }

    public boolean celluleOccupee(int ligne, int col) { //on vérifie si la cellule dont les paramètres sont donnés est vide ou occupée
        if (CellulesJeu[ligne][col] != null) {
            return true; //renvoie vrai si occupée
        } else {
            return false;
        }
    }

    public String lireCouleurDuJeton(int lig, int col) {
        if ("rouge".equals(CellulesJeu[lig][col].lireCouleurDuJeton())) { //dans la cellules dont les paramètres sont donnés, si le jeton est rouge
            return "rouge"; //on retourne rouge
        } else {
            return "jaune"; // sinon jaune
        }
    }

    public boolean etreGagnantePourJoueur(Joueur Player) {

        String c = Player.Couleur; //on initialise c pour que ce soit plus simple à utiliser dans nos longs if ci dessous
        for (int i = 0; i < 6; i++) {  // on vérifie les victoires en ligne
            for (int j = 0; j < 4; j++) {

                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i][j + 3].lireCouleurDuJeton() == c) {
                    return true; //on parcourt tout le tableau, si 4 jetons d'affilés horizontaux sont de la même couleur, on renvoie vrai
                }
            }

        }
        // on vérifie en colonne
        for (int j = 0; j < 6; j++) { 
            for (int i = 0; i < 3; i++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i + 1][j].lireCouleurDuJeton() == c && CellulesJeu[i + 2][j].lireCouleurDuJeton() == c && CellulesJeu[i + 3][j].lireCouleurDuJeton() == c) {
                    return true; //même manière pour 4 jetons verticaux
                }
            }
        }
        // on vérifie en diagonale montante
        for (int i = 3; i < 6; i++) { //on peut restreindre le champ d'étude car il est impossible de commencer une diagonale montante dans notre case en haut à droite par exemple
            for (int j = 0; j < 4; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i - 1][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i - 2][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i - 3][j + 3].lireCouleurDuJeton() == c) {
                    return true;
                }
            }
        }
        // on vérifie en diagonale descendante
        for (int i = 0; i < 3; i++) { //pareil que pour diagonale montante
            for (int j = 0; j < 4; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i + 1][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i + 2][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i + 3][j + 3].lireCouleurDuJeton() == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean colonneRemplie(int col) {
        if (CellulesJeu[0][col] != null) { //on regarde seulement si il y a un jeton dans la case la plus haute de la colonne indiquée
            return true; //si remplie, renvoie vrai
        } else {
            return false;
        }
    }

    public boolean placerTrouNoir(int L, int C) {
        if (CellulesJeu[L][C].trouNoir == false) { // si il n'y a pas de trou noir, on en place un
            CellulesJeu[L][C].trouNoir = true;
            return true;
        } else {
            return false;
        }
    }

    public void tasserGrille(int col) {
        for (int i = 5; i >= 1; i--) { //on part du bas de la grille
            if (CellulesJeu[i][col].jetonCourant == null) { // si la case du bas est vide
                CellulesJeu[i][col].jetonCourant = CellulesJeu[i - 1][col].jetonCourant; //le jeton situé juste au dessus prend la place de la case vide
                CellulesJeu[i - 1][col].jetonCourant = null; //on supprime après le jeton dans la case initiale, pour créer encore une case vide afin de tasser la grille

            }
        }

    }

    public Jeton recupererJeton(int L, int C) {
        Jeton jetonVisé;
        jetonVisé = CellulesJeu[L][C].jetonCourant; //on affecte à jetonVisé un jeton en particulier
        CellulesJeu[L][C].jetonCourant = null; //ce jeton en particulier est supprimé de la cellule
        return jetonVisé; //on récupère le jeton dans notre jeu
    }

    public boolean placerDesintegrateur(int L, int C) {
        if (CellulesJeu[L][C].desintegrateur == false) { //si il n'y a pas de désintégrateur, on en met un.
            CellulesJeu[L][C].desintegrateur = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimerJeton(int L, int C) {
        if (CellulesJeu[L][C].jetonCourant != null) { //si la cellule contient un jeton
            CellulesJeu[L][C].jetonCourant = null; //on enlève le jeton
            return true;
        } else {
            return false;
        }
    }

}

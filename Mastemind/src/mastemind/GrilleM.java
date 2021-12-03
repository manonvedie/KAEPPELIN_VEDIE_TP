package mastemind;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vedie
 */
public class GrilleM {
    
    CelluleM CelluleJeu[][];
    CelluleM CelluleSol [][];
    
    public void GrilleJeu () {
        CelluleJeu = new CelluleM[12][4];
        for (int i = 0; i < 13; i++) { //les 12 essais 
            for (int j = 0; j < 5; j++) {  // 4 jetons diff
                CelluleJeu[i][j] = new CelluleM(); 
        }
    }
    }
    
    public void GrilleSolution () { //la grille qui comprend la combi des 4 couleurs aléatoires
        CelluleSol = new CelluleM[1][4];
        for (int i = 0; i < 2; i++) { 
            for (int j = 0; j < 5; j++) { 
                CelluleSol[i][j] = new CelluleM();
            }
        }
    }  
    
    public boolean ajouterPionDansColonne(Pion PionCourant, int Colonne) {
        for (int i=0; i<13; i++) {
            if (CelluleJeu[i][0] == null) {
                
            }
        }
        return true;
    }
    
    public boolean etreRempli() {
        for (int i=0; i<13; i++) {
            if (CelluleJeu[i][0]==null) {
                return true;
            }
            else{
                return false;
            }
        }
     return true;   
    }
    
    
        public void afficherGrilleSurConsole() { 
        for (int i = 0; i < CelluleJeu.length; i++) { //on parcourt toute la grille
            for (int j = 0; j < CelluleJeu[0].length; j++) {

                
                 if (CelluleJeu[i][j].pionCourant != null) { //si il existe un jeton dans la cellule
                    if ("rouge".equals(CelluleJeu[i][j].pionCourant.Couleur)) {  // si c'est rouge on affiche R
                        System.out.print("R ");
                    }
                    if ("jaune".equals(CelluleJeu[i][j].pionCourant.Couleur)) { // si c'est jaune on affiche J
                        System.out.print("J ");
                    }
                } else {
                    System.out.print("\u2395 "); // si il n'y a rien dans la case, on affiche une case vide.
                }
            }
            System.out.println(); // on revient à la ligne à chaque fin de boucle j, donc à chaque fois qu'on a parcouru une ligne, pour avoir une grille sous forme de tableau
        }
    }
}

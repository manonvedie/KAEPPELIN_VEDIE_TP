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

    Cellule CellulesJeu[][];

    public Grille() {
        CellulesJeu = new Cellule[6][7];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j] = new Cellule();
            }
        }

    }

    public boolean ajouterJetonDansColonne(Jeton J, int Colonne) { // fonction validée par le prof     Jeton J
        // on va dans la colonne choisie, on parcourt les lignes du bas vers le haut jusqu'a qu'il y en ait une vide --> on met le jeton dedans.
        if (CellulesJeu[0][Colonne].jetonCourant != null) {
            return false;
        }
       //  Jeton J = joueurCourant.ListeJetons[]supprimerJeton();
        for (int i = 5; i >= 0; i--) {
            if (CellulesJeu[i][Colonne].jetonCourant == null) {
                return CellulesJeu[i][Colonne].affecterJeton(J);

            }

        }

        int i = 0;
        while (CellulesJeu[i][Colonne].jetonCourant != null) {
            if (CellulesJeu[i][Colonne].presenceDesintegrateurs()) {
                CellulesJeu[i][Colonne].recupererDesintegrateur();
               // joueurCourant.nombreDesintegrateurs++;
            }

            // on active le potentiel trou noir
            if (CellulesJeu[i][Colonne].presenceTrouNoir()) {
                CellulesJeu[i][Colonne].activerTrouNoir();
            }

        }
        return true;
    }

    public boolean etreRemplie() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (CellulesJeu[i][j] == null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public void viderGrille() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                CellulesJeu[i][j].jetonCourant = null;
                CellulesJeu[i][j].trouNoir = false;
                CellulesJeu[i][j].desintegrateur = false;
            }
        }
    }

    public void afficherGrilleSurConsole() { // faire les trous noirs
        for (int i = 0; i < CellulesJeu.length; i++) {
            for (int j = 0; j < CellulesJeu[0].length; j++) {

                if (CellulesJeu[i][j].presenceTrouNoir() == true && CellulesJeu[i][j].presenceDesintegrateurs() == true) {
                    System.out.print("\u058D ");
                } else if (CellulesJeu[i][j].presenceDesintegrateurs() == true && CellulesJeu[i][j].presenceTrouNoir() == false) {
                    System.out.print("\u235D ");
                } else if (CellulesJeu[i][j].jetonCourant != null) {
                    if ("rouge".equals(CellulesJeu[i][j].jetonCourant.Couleur)) {
                        System.out.print("R ");
                    }
                    if ("jaune".equals(CellulesJeu[i][j].jetonCourant.Couleur)) {
                        System.out.print("J ");
                    }
                } else {
                    System.out.print("\u2395 ");
                }
            }
            System.out.println();
        }
    }

    public boolean celluleOccupee(int ligne, int col) {
        if (CellulesJeu[ligne][col] != null) {
            return true;
        } else {
            return false;
        }
    }

    public String lireCouleurDuJeton(int lig, int col) {
        if ("rouge".equals(CellulesJeu[lig][col].lireCouleurDuJeton())) {
            return "rouge";
        } else {
            return "jaune";
        }
    }

    public boolean etreGagnantePourJoueur(Joueur Player) {

        String c = Player.Couleur;
        for (int i = 0; i < 6; i++) {  // if en ligne //5
            for (int j = 0; j < 4; j++) {

                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i][j + 3].lireCouleurDuJeton() == c) {
                    return true;
                }
            }

        }
        // if en colonne
        for (int j = 0; j < 6; j++) {
            for (int i = 0; i < 3; i++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i + 1][j].lireCouleurDuJeton() == c && CellulesJeu[i + 2][j].lireCouleurDuJeton() == c && CellulesJeu[i + 3][j].lireCouleurDuJeton() == c) {
                    return true;
                }
            }
        }
        // if en diagonale montante
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i - 1][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i - 2][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i - 3][j + 3].lireCouleurDuJeton() == c) {
                    return true;
                }
            }
        }
        // if en diagonale descendante
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (CellulesJeu[i][j].lireCouleurDuJeton() == c && CellulesJeu[i + 1][j + 1].lireCouleurDuJeton() == c && CellulesJeu[i + 2][j + 2].lireCouleurDuJeton() == c && CellulesJeu[i + 3][j + 3].lireCouleurDuJeton() == c) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean colonneRemplie(int col) {
        if (CellulesJeu[0][col] != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean placerTrouNoir(int L, int C) {
        if (CellulesJeu[L][C].trouNoir == false) {
            CellulesJeu[L][C].trouNoir = true;
            return true;
        } else {
            return false;
        }
    }

    public void tasserGrille(int col) {
        for (int i = 5; i >= 0; i--) {
            if (CellulesJeu[i][col] == null) {
                CellulesJeu[i][col].jetonCourant = CellulesJeu[i - 1][col].jetonCourant;
                CellulesJeu[i - 1][col].jetonCourant = null;

            }
        }

    }

    public Jeton recupererJeton(int L, int C) {
        Jeton jetonVisé;
        jetonVisé = CellulesJeu[L][C].jetonCourant;
        CellulesJeu[L][C].jetonCourant = null;
        return jetonVisé;
    }

    public boolean placerDesintegrateur(int L, int C) {
        if (CellulesJeu[L][C].desintegrateur == false) {
            CellulesJeu[L][C].desintegrateur = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean supprimerJeton(int L, int C) {
        if (CellulesJeu[L][C].jetonCourant != null) {
            CellulesJeu[L][C].jetonCourant = null;
            return true;
        } else {
            return false;
        }
    }

}

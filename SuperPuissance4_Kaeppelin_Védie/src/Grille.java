/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vedie
 */

public class Grille {
  Cellule CellulesJeu [][];
  
  public Grille() {
      CellulesJeu= new Cellule [6][7];
      for (int i=0; i<6; i++){
          for (int j=0; j<7; i++) {
              CellulesJeu[i][j] = new Cellule();
          }
      }
      
  }
  public boolean ajouterJetonDansColonne(Jeton J, int Colonne){
     // on va dans la colonne choisie, on parcourt les lignes du bas vers le haut jusqu'a qu'il y en ait une vide --> on met le jeton dedans.
    for (int i=5; i>0; i--) {
        if(CellulesJeu[i][Colonne].jetonCourant==null){
            J=CellulesJeu[i][Colonne].jetonCourant;
        }
    } 
}
}

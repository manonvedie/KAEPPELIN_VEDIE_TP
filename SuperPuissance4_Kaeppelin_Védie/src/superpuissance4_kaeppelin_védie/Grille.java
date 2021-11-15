package superpuissance4_kaeppelin_védie;

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
          for (int j=0; j<7; j++) {
              CellulesJeu[i][j] = new Cellule();
          }
      }
      
  }
  public boolean ajouterJetonDansColonne(Jeton J, int Colonne){ // fonction validée par le prof
     // on va dans la colonne choisie, on parcourt les lignes du bas vers le haut jusqu'a qu'il y en ait une vide --> on met le jeton dedans.
    if (CellulesJeu[0][Colonne].jetonCourant!=null) {
            return false;
    }
     
    for (int i=5; i>=0; i--) { 
        if(CellulesJeu[i][Colonne].jetonCourant==null){
            return CellulesJeu[i][Colonne].affecterJeton(J);
           
        }
    
}
    return true;
}
  
  public boolean etreRemplie(){
      for (int i=0; i<6; i++) {
          for (int j=0; j<7; j++) {
              if(CellulesJeu[i][j]== null){
                  return true;    
              }
              else {
                  return false;
              }
          }
      }
      return true;
  }

  public void viderGrille() {
      for (int i=0; i<6; i++) {
          for (int j=0; j<7; j++) {
             CellulesJeu[i][j].jetonCourant=null; 
             CellulesJeu[i][j].trouNoir=false;
             CellulesJeu[i][j].desintegrateur=false;
          }
      }
  }
  
  public void afficherGrilleSurConsole() {
      for(int i=0; i<6; i++) {
          for (int j=0; j<7; j++) {
              if (CellulesJeu[i][j].lireCouleurDuJeton()=="rouge") {
                  System.out.print("R");
              }
              if (CellulesJeu[i][j].lireCouleurDuJeton()=="jaune") {
                  System.out.print("J");
              }
              if (CellulesJeu[i][j].lireCouleurDuJeton()=="vide") {
                  System.out.print("_ ");
              }
          }
          System.out.println();
      }
  }
  
  public boolean celluleOccupee(int ligne, int col) {
      return true;
  }
}

  


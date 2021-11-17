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
  
  public void afficherGrilleSurConsole() { // faire les trous noirs
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
      if (CellulesJeu[ligne][col]!=null){
        return true;
      }
      
      else {
          return false;
      }
  }
  
  public String lireCouleurDuJeton(int lig, int col){
      if (CellulesJeu[lig][col].lireCouleurDuJeton()=="rouge") {
            return "Rouge";
        }
      else {
            return "Jaune";
      }
  }
  
  public boolean etreGagnantePourJoueur(Joueur Player) {
      
      String c=Player.Couleur;
      for (int i=0; i<5; i++) {  // if en ligne
          for (int j=0; j<4; j++) {
              
              if (CellulesJeu[i][j].lireCouleurDuJeton()==c && CellulesJeu[i][j+1].lireCouleurDuJeton()==c && CellulesJeu[i][j+2].lireCouleurDuJeton()==c && CellulesJeu[i][j+3].lireCouleurDuJeton()==c) {
                  return true;
              }
          }
          
      }
      // if en colonne
      for (int j=0; j<6; j++) {
          for (int i=0; i<3; i++) {
              if (CellulesJeu[i][j].lireCouleurDuJeton()==c && CellulesJeu[i+1][j].lireCouleurDuJeton()==c && CellulesJeu[i+2][j].lireCouleurDuJeton()==c && CellulesJeu[i+3][j].lireCouleurDuJeton()==c) {
                  return true;
              }
          }
      }
      // if en diagonale montante
      for (int i=3; i<6; i++) {
          for (int j=0; j<4; j++) {
              if (CellulesJeu[i][j].lireCouleurDuJeton()==c && CellulesJeu[i+1][j+1].lireCouleurDuJeton()==c && CellulesJeu[i+2][j+2].lireCouleurDuJeton()==c && CellulesJeu[i+3][j+3].lireCouleurDuJeton()==c) {
                  return true;
          }
      }
      // if en diagonale descendante
       for (int i=0; i<3; i++) {
          for (int j=0; j<4; j++) {
              if (CellulesJeu[i][j].lireCouleurDuJeton()==c && CellulesJeu[i+1][j+1].lireCouleurDuJeton()==c && CellulesJeu[i+2][j+2].lireCouleurDuJeton()==c && CellulesJeu[i+3][j+3].lireCouleurDuJeton()==c) {
                  return true;
              }
          }
      }
  }
}

  


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;

/**
 
 * @author KAEPPELIN Mayeul
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    int joueurCourant;
    Grille GrilleJeu = new Grille();
            
    public void attribuerCouleursAuxJoueurs(){
        Random generateurAleat = new Random();
            int n = generateurAleat.nextInt(1);
        if (n!=1){
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
            System.out.println("la couleur du joueur1 est" +ListeJoueurs[0].Nom);
            System.out.println("la couleur du joueur2 est" +ListeJoueurs[1].Nom);
        }
        else {
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
            System.out.println("la couleur du joueur1 est" +ListeJoueurs[1].Nom);
            System.out.println("la couleur du joueur2 est" +ListeJoueurs[0].Nom);
            
        }  
        
 
    }
    public void initialiserPartie(){
        int nbrTN = 0 ;
        while(nbrTN<=5){
            int i=(int)(Math.random() * 6);
            int j=(int)(Math.random() * 7);
            if (GrilleJeu.CellulesJeu[i][j].desintegrateur==false && GrilleJeu.CellulesJeu[i][j].trouNoir==false){
                GrilleJeu.
                nbrTN+=1
            }
            
        }       
    }
        
    
    
}

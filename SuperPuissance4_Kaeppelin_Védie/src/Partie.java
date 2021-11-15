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
    int nbraléat;
            
    public void attribuerCouleursAuxJoueurs(){
        int.nbraléat = Maths.Random();
        if (nbraléat!=1){
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
        
    }
        
    
    
}

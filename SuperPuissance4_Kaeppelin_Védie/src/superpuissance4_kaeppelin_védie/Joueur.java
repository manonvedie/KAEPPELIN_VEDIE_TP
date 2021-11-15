package superpuissance4_kaeppelin_védie;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vedie
 */
public class Joueur {
    String Nom;
    String Couleur;
    Jeton [] ListeJetons = new Jeton [21];
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
    
    public Joueur(String nomJoueur){
        Nom= nomJoueur;
    }
    
    public void affecterCouleur(String CouleurJoueur){
        Couleur = CouleurJoueur;
    }
    
    public boolean ajouterJeton(Jeton J){
        int i=0;
        while (ListeJetons[i]!=null) {
            i+=1;
            if (i==20) {
                return false;      
            }
        }    
        ListeJetons[i]=J; 
        return true;
     
    }
   // continuer !!! (en jaune)
    
}

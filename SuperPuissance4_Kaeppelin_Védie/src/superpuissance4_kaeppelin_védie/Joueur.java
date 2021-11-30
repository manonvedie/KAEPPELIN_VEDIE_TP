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
    String Nom; //on définit des caractéristiques utiles du joueur
    String Couleur;
    Jeton [] ListeJetons = new Jeton [21]; //on crée un tableau de 21 cases qui va comprendre tous les jetons du joueur
    int nombreJetonsRestants;
    int nombreDesintegrateurs;
    
    public Joueur(String nomJoueur){ //le nom qui est demandé à l'utilisateur d'écrire dans une autre classe rentre dans la variable Nom.
        Nom= nomJoueur;
    }
    
    public void affecterCouleur(String CouleurJoueur){ //on affecte une couleur au joueur
        Couleur = CouleurJoueur;
    }
    
    public boolean ajouterJeton(Jeton J){
        int i=0;
        while (ListeJetons[i]!=null) { //on parcourt le tableau de jetons, et tant qu'on ne tombe pas sur un jeton on incrémente le i
            i+=1;
            if (i==20) { // si le i vient jusqu'à 20, cela veut dire que le joueur n'a plus de jeton, et donc la fonction retournera false.
                return false;      
            }
        }    
        ListeJetons[i]=J; // si il reste un ou plusieurs jeton(s) dans ListeJetons, le premier qui vient prend le nom de J
        nombreJetonsRestants++; 
        return true;
     
    }
   public void obtenirDesintegrateur(){
       nombreDesintegrateurs=nombreDesintegrateurs+1; 
   }
   
   public boolean utiliserDesintegrateur() {
       if (nombreDesintegrateurs>0) {
           nombreDesintegrateurs-=1;
           return true;
       }
       else {
           return false;
       }
   }
    
}

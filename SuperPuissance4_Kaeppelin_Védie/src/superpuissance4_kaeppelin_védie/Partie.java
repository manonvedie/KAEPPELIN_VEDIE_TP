package superpuissance4_kaeppelin_védie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;

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
        int nbrD = 0;
        while(nbrTN<=5 && nbrD<=5 ){
            int i=(int)(Math.random() * 6);
            int j=(int)(Math.random() * 7);
            if (GrilleJeu.CellulesJeu[i][j].desintegrateur==false && GrilleJeu.CellulesJeu[i][j].trouNoir==false){
                
                // a compteter après pour les parties 2,3...
            }
            
        }       
        for (int i =0; i<21;i++){
            if(ListeJoueurs[0].Couleur.equals("rouge")){
                Jeton JetonJoueurR = new Jeton ("rouge");
                ListeJoueurs[0].ajouterJeton(JetonJoueurR);
                Jeton JetonJoueurJ = new Jeton ("jaune");
                ListeJoueurs[0].ajouterJeton(JetonJoueurJ);
                
                
                
                
            }
            
        }
    
    }
        
    public void debuterPartie(){
            //inscription des 2 joueurs:
        Scanner sca = new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur");
        String Joueur1=sca.next();
        System.out.println("Entrez le nom du second joueur");
        String Joueur2=sca.next();
        Joueur J1 = new Joueur(Joueur1);
        Joueur J2 = new Joueur(Joueur2);
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        
        // premier joueur à commencer la partie 
        Random generateurAleat = new Random();
        int n = generateurAleat.nextInt(1);
        if (n!=1){
            joueurCourant = ListeJoueurs[0];
                                           
                       
        }
        else{
            joueurCourant = ListeJoueurs[1];
        }
    }
        
    
    
}

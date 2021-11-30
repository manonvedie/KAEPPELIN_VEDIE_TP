package superpuissance4_kaeppelin_védie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author KAEPPELIN Mayeul
 */
public class Cellule {
    Jeton jetonCourant; // on initialise le jeton courant de la partie 
    boolean trouNoir;  // on définie trounoir commme étant un boolean, idem pour désintegrateur
    boolean desintegrateur;
    
    public void Cellule(){ 
        jetonCourant=null; // le jeton courant prend de base une valeur nulle (il n'y a rien dans le jeton courant)
        trouNoir = true; // la valeur de trounoir et de désintegrateur est définie par défaut comme étant "vraie"
        desintegrateur = true;
    }    
    public boolean affecterJeton(Jeton JETON){ 
        if (jetonCourant== null) {
            jetonCourant = JETON; //on affecte le jeton en question à la variable jetonCourant
            return true;            
        }
        else {
            return false;
        }
            
    }    
    public String lireCouleurDuJeton () {
        if (jetonCourant!= null){
            return jetonCourant.Couleur;
        }
        else{
            return ("vide");
        }            
        
        
    }
    
    public boolean placerTrouNoir() {
        if (trouNoir==false) {
            trouNoir=true; // si il n'y a pas de trou noir déjà positionné dans cette cellule, alors on en positionne un
            return true;
        }
        else {
            return false;// condition pour connaitre la "valeur" de trounoir 
        }
    }
    
    public boolean presenceTrouNoir() {
        if (trouNoir==true) { // si il y a un trou noir
            return true; //renvoyer le boolean vrai
        }
        else {
         return false;   
        }
    }
    
    public boolean activerTrouNoir() {// activation de trou noir !
        if (trouNoir==true) {   // si il a un trou noir sur la case, alors le jeton sur cette case va disparaitre(valeur null)
            jetonCourant=null; //si il y a un trou noir, alors on enlève le jeton présent sur la cellule
            trouNoir=false; // on enlève ensuite le trou noir pour la suite de la partie 
            return true;
        }
        else {
            return false;
        }
    }
      
    public Jeton recupererJeton() { // methode qui va permettre de récuperer le jeton courant 
        return jetonCourant; 
    }
    
    public boolean supprimerJeton() { // nous sert a supprimer un jeton c'est assez explicite:)
        if (jetonCourant!=null) { // si il y a un jeton (sa valeur attribué est" non nulle" ...
            jetonCourant=null; // ...on le supprime
            return true;
        }
        
        else{ //sinon 
            return false; // on renvoie false
        }
    }
    
    public boolean placerDesintegrateur() {
        if (desintegrateur==false) { //si il n'y a pas de desintegrateur sur la cellule... 
            desintegrateur=true; // ...on en place un sur la cellule
            return true;
         }
        else{ 
            return false;
        }
    }
    
    public boolean presenceDesintegrateurs() { // pour cette methode nous allons verifier la presence des désintégrateurs dans la grille 
        if (desintegrateur==true) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean recupererDesintegrateur() {
        if (presenceDesintegrateurs()==true) { // si il y a un désintégrateur
            desintegrateur=false; //on le supprime
            return true;
        }
        else {
            return false;
        }
    }
    }
    
    


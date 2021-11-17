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
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public void Cellule(){
        jetonCourant=null;
        trouNoir = true;
        desintegrateur = true;
    }    
    public boolean affecterJeton(Jeton JETON){
        if (jetonCourant== null) {
            jetonCourant = JETON;
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
            return false;
        }
    }
    
    public boolean presenceTrouNoir() {
        if (trouNoir==true) {
            return true;
        }
        else {
         return false;   
        }
    }
    
    public boolean activerTrouNoir() {
        if (trouNoir==true) {
            jetonCourant=null; //si il y a un trou noir, alors on enlève le jeton présent sur la céllule
            trouNoir=false; // on enlève le trou noir
            return true;
        }
        else {
            return false;
        }
    }
      
    public Jeton recupererJeton() {
        return jetonCourant; 
    }
    
    
    }
    
    


/*
 * TP2 - 10 novembre 2021
 * VEDIE - KAEPPELIN
 * Exercice 3
 */
package manip_védie_kaeppelin;

import manip_VEDIE_KAEPPELIN.Tartiflette;
import manip_vedie_kaeppelin.Moussaka;

/**
 *
 * @author vedie
 */
public class Manip_VEDIE_KAEPPELIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    Tartiflette assiette1 = new Tartiflette(500);
    Tartiflette assiette2 = new Tartiflette(600);
    assiette2.nbCalorie = 856;
    Tartiflette assiette3 = assiette2;
    //il n'y a réellement que 2 tartiflettes qui ont été créees car l'instruction 'new' n'apparait que 2 fois
    //assiette2 et assiette3 référencent la même tartiflette
    
    System.out.println("nb de calories de Assiette 3: " + assiette3.nbCalorie);
    //on a bien la valeur incrémentée de l'assiette 2 pour l'assiette 3 
    
    assiette2 = assiette1;
    assiette1 = assiette3;
    
    System.out.println("nb decalories de Assiette 1: " + assiette1.nbCalorie);
    System.out.println("nb de calories de Assiette 2: " + assiette2.nbCalorie);
    // on retrouve assiette1 = 856 et assiette2 = 500
    
    
   /* Moussaka assiette666 = assiette1;
    * Moussaka assiette667 = new Tartiflette();
    * on ne peut pas référencer un type d'objet pout référencer un autre type d'objet
    */
   
    Moussaka [] tableau = new Moussaka[10];
    System.out.print("[");
    for (int i=0;i<tableau.length;i++){
        tableau[i] = new Moussaka(100*(1+i));
        if (i==tableau.length-1){
            System.out.println(tableau[i]+"]");   // a la fin du tableau il faut juste afficher le dernier nombre suivit de ']'
        }
        else{
            System.out.print(tableau[i]+" ; ");
        
    }
    
    
    }
    }
}
    



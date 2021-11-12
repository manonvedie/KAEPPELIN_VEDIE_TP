/*
 * TP2 
 * Exercice 3 - Classe Moussaka
 */
package manip_vedie_kaeppelin;
/**
 *
 * @author vedie
 */
public class Moussaka {
    //Ajout d'un attribut:
    int nbCalories;
 
  public Moussaka (int valeur){
      nbCalories = valeur;
  }
  
  @Override
  public String toString() {
      return String.valueOf(nbCalories);
  }
    
}
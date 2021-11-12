/*
 * TP2 
 * Exercice 4 - Classe Voiture
 */
package relation_1_vedie_kaeppelin;

/**
 *
 * @author vedie
 */
public class Voiture {
     //Attributs:
    String Modèle;
    String Marque;
    int PuissanceCV;
    Personne Propriétaire;

    public Voiture (String leModele, String laMarque, int laPuissance, Personne P){
        Modèle = leModele;
        Marque = laMarque;
        PuissanceCV = laPuissance;
        Propriétaire = P;
    }
    
    @Override
    public String toString() {
        return Modèle+" de la marque "+Marque+" de puissance "+PuissanceCV;
    }
}


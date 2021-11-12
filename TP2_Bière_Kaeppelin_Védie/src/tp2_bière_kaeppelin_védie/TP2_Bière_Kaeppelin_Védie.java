/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp2_bière_kaeppelin_védie;

/**
 *
 * @author vedie
 */
public class TP2_Bière_Kaeppelin_Védie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {    
        
        BouteilleBiere uneBiere = new BouteilleBiere("Cuvée des trolls", 7.0, "Dubuisson") ;
        System.out.println(uneBiere) ;
        uneBiere.ouverte = false;
        uneBiere.lireEtiquette();
        
        BouteilleBiere autreBiere = new BouteilleBiere("Leffe", 6.6 ,"Abbaye de Leffe") ;
        autreBiere.lireEtiquette();
        
        BouteilleBiere Biere3 = new BouteilleBiere("Goudale", 7.5 ,"Goudale and co") ;
        Biere3.lireEtiquette();
        
        BouteilleBiere Biere4 = new BouteilleBiere("fischer", 7.0 ,"Fischer factory") ;
        Biere4.lireEtiquette();
        
        BouteilleBiere Biere5 = new BouteilleBiere("heineken", 6.0 ,"Le petit comptoir") ;
        Biere5.lireEtiquette();
        System.out.println(Biere5);
        
        boolean result = Biere3.Décapsuler();
        System.out.println(result);
        result=Biere3.Décapsuler();
        System.out.println(result);
        
        
        
        

        
    }
    
}

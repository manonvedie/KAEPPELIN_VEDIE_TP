/*
 * TP2 
 * Exercice 4
 */
package relation_1_vedie_kaeppelin;

/**
 *
 * @author vedie
 */
public class Relation_1_KAEPPELIN_VEDIE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
    Voiture uneClio= new Voiture ("Clio", "Renault", 5, null );
    Voiture autrevoiture= new Voiture ("Touran", "Renault", 5, null ); //on crée d'autres voitures pour tester la méthode ajouter_voiture
    Voiture uneAudi= new Voiture ("A3", "Audi", 7, null );
    Voiture uneAutreClio= new Voiture ("Clio", "Renault", 5, null );
    Voiture une2008= new Voiture ("2008", "Peugeot", 6, null );
    Voiture uneMicra= new Voiture ("Micra", "Nissan", 4, null );
    Personne bob = new Personne("Bobby", "Sixkiller",0);
    Personne reno = new Personne("Reno", "Raines",0);
    System.out.println("liste des voitures disponibles \n"+ uneClio+ "\n"+ uneAutreClio+"\n"+autrevoiture+ "\n"+ une2008+ "\n"+ uneMicra);
     
    bob.ajouter_voiture(uneClio); //méthode permet d'alléger le code
    System.out.println("la premiere voiture de Bob est " + bob.liste_voitures[0] ) ;
    bob.ajouter_voiture(une2008);
    System.out.println("la deuxième voiture de Bob est " + bob.liste_voitures[1] ) ;
    
    reno.ajouter_voiture(uneMicra);
    System.out.println("la premiere voiture de Reno est " + reno.liste_voitures[0] ) ;
    reno.ajouter_voiture(uneAutreClio);
    System.out.println("la deuxième voiture de Reno est " + reno.liste_voitures[1] ) ;
    
    
   bob.ajouter_voiture(autrevoiture);
   bob.ajouter_voiture(uneAudi); //bob possède déja 3 voitures donc ne peut pas en avoir plus
   reno.ajouter_voiture(uneClio); // la Clio est déjà possédée par bob donc reno ne peut pas l'avoir
   System.out.println(bob);
   System.out.println(reno);
   
}
    
}

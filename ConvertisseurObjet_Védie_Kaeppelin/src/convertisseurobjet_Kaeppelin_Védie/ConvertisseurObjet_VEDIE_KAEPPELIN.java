/*
 * TP2 - 
 * Kaeppelin - Védie
 * Exercice 2
 */
package convertisseurobjet_Kaeppelin_Védie;

import convertisseurobjet_védie_kaeppelin.Convertisseur;
import java.util.Scanner;

/**
 *
 * @author vedie
 */
public class ConvertisseurObjet_VEDIE_KAEPPELIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Convertisseur temperature = new Convertisseur (); //création de l'objet
        float result=temperature.CelciusVersKelvin(28);
        System.out.println(result);
        float result2=temperature.KelvinVersCelcius(121);
        System.out.println(result2);
        float result3=temperature.KelvinVersFarenheit(-15);
        System.out.println(result3);
        System.out.println(temperature);
        
        
        //Saisie de la valeur à convertir
    float val;
    Scanner sc;
    sc=new Scanner(System.in);
    System.out.println("Saisissez une valeur:");
    val=sc.nextFloat();
    System.out.println("Saisissez la conversion que vous souhaiter effectuer :");
      //choix d'une opération //création du menu
        Scanner ch;
        int rep;
        ch = new Scanner(System.in);
        System.out.println("1) De Celcius vers Kelvin");
        System.out.println("2) De Kelvin vers Celcius");
        System.out.println("3) De Farenheit vers Celcius");
        System.out.println("4) De Celcius vers Farenheit");
        System.out.println("5) De Kelvin vers Farenheit");
        System.out.println("6) De Farenheit vers Kelvin");
        rep = ch.nextInt();
        
        //exécution de la méthode:
        if (rep==1){
            float sortie= temperature.CelciusVersKelvin(val); // On appelle la méthode CelciusVersKelvin dans notre main pour l'exécuter
            System.out.println(val+" degrés Celcius est égal à "+sortie+" degrés Kelvin");  
        }
        if (rep==2){
            float sortie= temperature.KelvinVersCelcius(val); // On appelle la méthode KelvinVersCelcius dans notre main pour l'exécuter
            System.out.println(val+" degrés Kelvin est égal à "+sortie+" degrés Celcius");  
        }
        if (rep==3){
            float sortie= temperature.FarenheitVersCelcius(val); // On appelle la méthode FarenheitVersCelcius dans notre main pour l'exécuter
            System.out.println(val+" degrés Farenheit est égal à "+sortie+" degrés Celcius");  
        }
        if (rep==4){
            float sortie= temperature.CelciusVersFarenheit(val); // On appelle la méthode CelciusVersFarenheit dans notre main pour l'exécuter
            System.out.println(val+" degrés Celcius est égal à "+sortie+" degrés Farenheit");  
        }
        if (rep==5){
            float sortie= temperature.KelvinVersFarenheit(val); // On appelle la méthode KelvinVersFarenheit dans notre main pour l'exécuter
            System.out.println(val+" degrés Kelvin est égal à "+sortie+" degrés Farenheit");  
        }
        if (rep==6){
            float sortie= temperature.FarenheitVersKelvin(val); // On appelle la méthode FarenheitVersKelvin dans notre main pour l'exécuter
            System.out.println(val+" degrés Farenheit est égal à "+sortie+" degrés Kelvin");  
        }
    }
    
}

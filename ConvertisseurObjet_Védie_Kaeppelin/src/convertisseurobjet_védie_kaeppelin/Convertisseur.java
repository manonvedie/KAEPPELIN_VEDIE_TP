/*
 * TP2 - 12 novembre 2021
 * Kaeppelin - Védie
 * Exercice 2 - Convertisseur
 */
package convertisseurobjet_védie_kaeppelin;

/**
 *
 * @author vedie
 */
public class Convertisseur {
    //Ajout de l'attribut:
    int nbConversions;
    
  public Convertisseur () {
      nbConversions= 0;
  }  
  
  @Override
  public String toString() {
      return "nb de conversions = "+ nbConversions;
  }

  //Création des méthodes:
    public float CelciusVersKelvin(float tempCelcius){ 
        float tempKelvin=tempCelcius+273.15f; //On ajoute le 'f' derrière le nombre pour le forcer à être en float
        nbConversions+=1;
        return(tempKelvin);
    }
    
    public float KelvinVersCelcius(float tempKelvin){ 
        float tempCelcius=tempKelvin-273.15f; //On ajoute le 'f' derrière le nombre pour le forcer à être en float
        nbConversions+=1;
        return(tempCelcius);
    }
    public float FarenheitVersCelcius(float tempFarenheit){ 
        float tempCelcius=(tempFarenheit-32)*5/9; 
        nbConversions+=1;
        return(tempCelcius);
    }
    public float CelciusVersFarenheit(float tempCelcius){ 
        float tempFarenheit=tempCelcius*9/5+32; 
        nbConversions+=1;
        return(tempFarenheit);
    }
    
    public float KelvinVersFarenheit(float tempKelvin){ 
        float tempFarenheit=CelciusVersFarenheit(KelvinVersCelcius(tempKelvin)); //On utilise l'appel des autres méthodes 
        nbConversions-=1; //on retire 1 au nb de conversions car on appelle 2 autres méthodes
        return(tempFarenheit);
    }
    
    public float FarenheitVersKelvin(float tempFarenheit){ 
        float tempKelvin=CelciusVersKelvin(FarenheitVersCelcius(tempFarenheit)); //On utilise l'appel des autres méthodes 
        nbConversions-=1;
        return(tempKelvin);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_ex2_kaeppelin_védie;

import java.util.Scanner;

/**
 *
 * @author vedie
 */
public class TP1_EX2_Kaeppelin_Védie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          double var1;
       Scanner sc;
       System.out.println("Bonjour, saisissez une valeur:");
       sc= new Scanner(System.in);
       var1= sc.nextDouble();
       System.out.println(var1);
       System.out.println("""
                          Saisissez la conversion que vous souhaitez effectuer:
                           1) De Celcius vers Kelvin
                           2) De Kelvin vers Celcius
                           3) De Farenheit vers Celcius
                           4) De Celcius Vers Farenheit 
                           5) De Kelvin vers Farenheit
                           6) De Farenheit vers Kelvin""");
       int var2;
       var2 = sc.nextInt();
       
       if (var2==1) {
       System.out.println("La température en Kelvin est de "+CelciusVersKelvin(var1)+"K");
       }
       
       if (var2==2) {
       System.out.println("La température en Celcius est de "+KelvinVersCelcius(var1)+"°C");
       }
       
       if (var2==3) {
       
       System.out.println("La température en Celcius est de "+FarenheitVersCelcius(var1)+"°C");
       }
       
       if (var2==4) {
       System.out.println("La température en Farenheit est de "+CelciusVersFarenheit(var1)+"°F");
       }
       
       if (var2==5) {
       System.out.println("La température en Farenheit est de "+KelvinVersFarenheit(var1)+"°F");
       }
       
       if (var2==6) {
       System.out.println("La température en Kelvin est de "+FarenheitVersKelvin(var1)+"K");
       }
       
    }
   public static double CelciusVersKelvin(double tempCelcius) {
       double Kelvin = tempCelcius-273.5;
       return Kelvin;
    }
    
    public static double KelvinVersCelcius(double tempKelvin) {
       double Celcius = tempKelvin+273.5;
       return Celcius;
    }
    
    public static double FarenheitVersCelcius(double tempFarenheit) {
       double Farenheit = tempFarenheit-17.77;
       return Farenheit;
    }
    
    public static double CelciusVersFarenheit(double tempCelcius2) {
       double Farenheit = tempCelcius2+17.77;
       return Farenheit;
    }
    
    public static double KelvinVersFarenheit(double tempKelvin2) {
        double tempK;
        tempK= KelvinVersCelcius(tempKelvin2);
        tempK=CelciusVersFarenheit(tempK);
        return(tempK);
    }
    
    public static double FarenheitVersKelvin(double tempFarenheit2) {
        double tempF;
        tempF=FarenheitVersCelcius(tempFarenheit2);
        tempF=CelciusVersKelvin(tempF);
        return(tempF); 
    }
}

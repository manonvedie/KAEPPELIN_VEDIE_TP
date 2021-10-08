/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package guess_my_number;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KAEPPELIN Mayeul
 */
public class Guess_my_number {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc;
        sc = new Scanner(System.in);
        
        String entrée = "";
        System.out.println("choisisez votre niveau; facile ou difficile");
        entrée = sc.next();
        if ("facile".equals(entrée) ){
            
            System.out.println("entrez un nombre entre 1 et 100");
            
            double nb = sc.nextDouble();
            int compteur = 0;
            Random generateurAleat = new Random();
            int n = generateurAleat.nextInt(100);
            System.out.println(n);
            
            while (nb != n){
                if(nb>n){
                    System.out.println("trop grand");
                    nb = sc.nextDouble();
                    compteur +=1;

                }
                if(nb<n){
                    System.out.println("trop petit");
                    nb = sc.nextDouble();
                    compteur +=1;


                }
                if(nb==n){
                    System.out.println("bien joué");

                    compteur +=1;
                    System.out.println("vous avez mis " + compteur + " essais");
                


       
                }
            }
        }
            
        if ("difficile".equals(entrée) ){
           
            System.out.println("entrez un nombre entre 1 et 1000");
            
            double nb1 = sc.nextDouble();
            int compteur1 = 0;
            Random generateurAleat = new Random();

            int n1 = generateurAleat.nextInt(1000);
            System.out.println(n1);
            
            while (nb1 != n1 && compteur1 <=  2){
                if(nb1>n1){
                    System.out.println("trop grand");
                    nb1 = sc.nextDouble();
                    compteur1 +=1;

                }
                if(nb1<n1){
                    System.out.println("trop petit");
                    nb1 = sc.nextDouble();
                    compteur1 +=1;


                }
                if(nb1==n1){
                    System.out.println("bien joué");

                    compteur1 +=1;
                    System.out.println("vous avez mis " + compteur1 + " essais");
                


       


            }
        }
    }

            }
        }
    }
            
        }
        

         


        
        
        
}
        


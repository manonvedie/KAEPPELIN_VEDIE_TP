/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package statistiques;

import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author vedie
 */
public class Statistiques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] TabDé = new int[6];
        
        for (int i=0; i<5; i++) {
            TabDé[i]=0;
        }
        
        
        
        Scanner sc;
        sc= new Scanner(System.in);
        System.out.println("Saisissez un nombre entier : ");
        int m= sc.nextInt();
        
        for (int j=0; j<m; j++) {
            Random generateurAleat = new Random();
            int n = generateurAleat.nextInt(5);
            TabDé[n]=TabDé[n]+1;
        }
   
        
        for (int k=0; k<6; k++) {
            System.out.println(TabDé[k]);
            
        }  
        
        for (int j=0; j<6; j++){ //boucle permettant d'affficher le tableau en pourcentage
                
             System.out.println(((TabDé[j]*1.0)/m)*100+"%");
        }

        
        
        
        


        
        
        
        
                
        
        
    }
    
}

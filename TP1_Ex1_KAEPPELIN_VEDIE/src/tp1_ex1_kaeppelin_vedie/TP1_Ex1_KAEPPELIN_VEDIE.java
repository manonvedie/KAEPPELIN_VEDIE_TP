/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp1_ex1_kaeppelin_vedie;

import java.util.Scanner;

/**
 *
 * @author vedie
 */
public class TP1_Ex1_KAEPPELIN_VEDIE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int var1;
        int var2;
        Scanner sc;
        sc= new Scanner(System.in);
        var1= sc.nextInt();
        var2= sc.nextInt();
        System.out.println(var1 + ";" + var2); 
        System.out.println("Leur somme est égale à " + (var1 + var2)); 
        System.out.println("Leur différence est égale à " + (var1 - var2)); 
        System.out.println("Leur produit est égal à " + (var1 * var2)); 
        
        System.out.println("Leur quotient est égal à " + (var1 / var2));
        System.out.println("Le reste de leur division euclidienne est égal à " + (var1 % var2));
    }
    
}

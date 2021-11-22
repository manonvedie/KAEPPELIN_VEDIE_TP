package superpuissance4_kaeppelin_védie;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Random;
import java.util.Scanner;

/**
 
 * @author KAEPPELIN Mayeul
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille GrilleJeu = new Grille();
            
    public void attribuerCouleursAuxJoueurs(){
        Random generateurAleat = new Random();
        int n = generateurAleat.nextInt(1);
        if (n!=1){
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
            System.out.println("la couleur du joueur1 est" +ListeJoueurs[0].Nom);
             System.out.println("la couleur du joueur2 est" +ListeJoueurs[1].Nom);
        }
        else {
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
            System.out.println("la couleur du joueur1 est" +ListeJoueurs[1].Nom);
            System.out.println("la couleur du joueur2 est" +ListeJoueurs[0].Nom);
            
        }  
        
 
    }
    public void initialiserPartie(){
        int nbrTN = 0 ;
        int nbrD = 0;
        while(nbrTN<=5 && nbrD<=5 ){
            int i=(int)(Math.random() * 6);
            int j=(int)(Math.random() * 7);
            if (GrilleJeu.CellulesJeu[i][j].desintegrateur==false && GrilleJeu.CellulesJeu[i][j].trouNoir==false){
                
                // a compteter après pour les parties 2,3...
            }
            
        }       
        for (int i =0; i<21;i++){
            if(ListeJoueurs[0].Couleur.equals("rouge")){
                Jeton JetonJoueurR = new Jeton ("rouge");
                ListeJoueurs[0].ajouterJeton(JetonJoueurR);
                Jeton JetonJoueurJ = new Jeton ("jaune");
                ListeJoueurs[0].ajouterJeton(JetonJoueurJ);
                
                
                
                
            }
            
        }
    
    }
        
    public void debuterPartie(){
            //inscription des 2 joueurs:
        Scanner sca = new Scanner(System.in);
        System.out.println("Entrez le nom du premier joueur");
        String Joueur1=sca.next();
        System.out.println("Entrez le nom du second joueur");
        String Joueur2=sca.next();
        Joueur J1 = new Joueur(Joueur1);
        Joueur J2 = new Joueur(Joueur2);
        ListeJoueurs[0]=J1;
        ListeJoueurs[1]=J2;
        
        // premier joueur à commencer la partie 
        Random generateurAleat = new Random();
        int n = generateurAleat.nextInt(1);
        if (n!=1){
            joueurCourant = ListeJoueurs[0];
                                           
                       
        }
        else{
            joueurCourant = ListeJoueurs[1];
        }
                
        attribuerCouleursAuxJoueurs();    //Distribution des couleurs:

        
        
        initialiserPartie();
        
        while(GrilleJeu.etreRemplie()==false/* =nombre de jetons pour le joueur(verifier)*/ && GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==false  /*partie finie?*/&&GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==false ){
            GrilleJeu.afficherGrilleSurConsole();
            
            Scanner sc = new Scanner(System.in);
            System.out.println(joueurCourant.Nom + "c'est a vous de jouer ");
            System.out.println(joueurCourant.Nom + "il vous reste il faut aussi rajouter le nombre de désintégrateur");
            System.out.println("1) Placer un jeton");
            System.out.println("2) Récupérer un jeton");
            System.out.println("3) Utiliser un désintégrateur");
            int saisie = sc.nextInt();
            while (saisie>3 || saisie<=0){
                System.out.println("ERREUR!!!!: Veuillez ressaisir un chiffre compris entre 1 et 3:");
                saisie = sc.nextInt();
           
            }
            if (saisie==1){ 
                Scanner s = new Scanner(System.in);
                int Numcolonne = s.nextInt()-1;
                while(Numcolonne>6 && Numcolonne<0 ){
                    System.out.println("monsieur vous ne savez pas compter les colonnes, ressaisissez un numéro de colonne");
                    Numcolonne = s.nextInt()-1;
                    
                }    
                while (GrilleJeu.etreRemplie()==true){
                    System.out.println("la colonne est pleine, entrez a nouveau un nouveau numéro de colonne");
                    Numcolonne = s.nextInt()-1;
                }                    
                
            }
                
            joueurCourant.nombreJetonsRestants = joueurCourant.nombreJetonsRestants-1;
            System.out.println(joueurCourant.Nom + ", il vous reste"+ joueurCourant.nombreJetonsRestants);
                
                
                
                
                
            if (saisie==2){
                Scanner nbre = new Scanner(System.in);
                System.out.println("entrez votre numéro de ligne pour récuperer votre jeton");
                int ligne = nbre.nextInt();
                while (ligne<0 && ligne>5){
                    System.out.println("vous ne pouvez pas saisir un tel chiffre boloss");
                    ligne = nbre.nextInt()-1;
                }
                Scanner Nombre = new Scanner(System.in);
                int colonne = Nombre.nextInt();
                while (colonne <0 && colonne>6){
                    System.out.println("vous ne pouvez pas saisir un tel chiffre boloss");
                    colonne = nbre.nextInt()-1;                                                      
                }                
                if (GrilleJeu.celluleOccupee(ligne, colonne)==false && GrilleJeu.recupererJeton(ligne, colonne).Couleur.equals(joueurCourant.Couleur)){
                    GrilleJeu.tasserGrille(colonne);
                    joueurCourant.nombreJetonsRestants = joueurCourant.nombreJetonsRestants-1;
                    System.out.println(joueurCourant.Nom + ", il vous reste"+ joueurCourant.nombreJetonsRestants);                                       
                }
                              
            }                      
            
            if (saisie==3 && joueurCourant.nombreDesintegrateurs!=0){
                System.out.println("vous allez utiliser un désintégrateur");             
                Scanner nbre2 = new Scanner(System.in);
                System.out.println("entrez votre numéro de ligne pour récuperer votre jeton");
                int ligne = nbre2.nextInt();
                
                while (ligne<0 && ligne>5){
                    System.out.println("vous ne pouvez pas saisir un tel chiffre boloss");
                    ligne = nbre2.nextInt()-1;
                }
                Scanner Nombre2 = new Scanner(System.in);
                int colonne = Nombre2.nextInt();
                
                while (colonne <0 && colonne>6){
                    System.out.println("vous ne pouvez pas saisir un tel chiffre boloss");
                    colonne = Nombre2.nextInt()-1;        
               
                
            }
            if (saisie==3 && joueurCourant.nombreDesintegrateurs==0){
                System.out.println("ERREUR: Vous n'avez pas de désintégrateur à utiliser");
                System.out.println("Rechoississez ce que vous voulez faire: 1)Placer un jeton ou 2)Récupérer un jeton");
                saisie = sc.nextInt();
                while (saisie>2 || saisie<=0){
                    System.out.println("ERREUR: Veuillez ressaisir un choix compris entre 1 et 2:");
                    saisie = sc.nextInt();
                }
            }
            if (joueurCourant==ListeJoueurs[0]){
                joueurCourant=ListeJoueurs[1];
            }
            else{
                joueurCourant=ListeJoueurs[0];
            }

            }
            if(GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[0])==true){
                System.out.println(ListeJoueurs[0].Nom+" a gagné'");  
            }
            
            if(GrilleJeu.etreGagnantePourJoueur(ListeJoueurs[1])==true){
                System.out.println(ListeJoueurs[1].Nom+" a gagné");
            }
            
            if(GrilleJeu.etreRemplie()==true){
                System.out.println("LA partie de termine, il n'y a pas de gagant--> égalité!");
            }
            
                
            
        }    
    
    
    
    
    
    }
        
    
            //afficher la grille
        //demander au joueur ce qu'il veut faire
           //placer un jeton dans une colonne
            //récupérer un jeton de la grille de jeu
            //utiliser un desintégrateur

}

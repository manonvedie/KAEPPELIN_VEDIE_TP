/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_kaeppelin_védie;

import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 *
 * @author KAEPPELIN Mayeul
 */
public class CelluleGraphique extends JButton {

    Cellule CelluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_desint = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_jetonJaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_jetonRouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));

    public CelluleGraphique(Cellule uneCellule) {
        CelluleAssociee = uneCellule;

    }

    @Override
    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        if (CelluleAssociee.presenceTrouNoir() == true) {
            setIcon(img_trouNoir); // on attrivbue l'image trou noir

        } else if (CelluleAssociee.presenceDesintegrateurs() == true) {
            setIcon(img_desint); // on met une image de désintégrateur

        } else {
            String couleur_jeton = CelluleAssociee.lireCouleurDuJeton();
            switch (couleur_jeton) {
                case "vide":
                    setIcon(img_vide);
                    break;
                case "rouge":
                    setIcon(img_jetonRouge);

                    break;
                case "jaune":
                    setIcon(img_jetonJaune);
                    break;
            }
        }

    }
 
}

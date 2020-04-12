package items;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
La classe Game est la classe principale du jeu
Elle va permettre dans un premier temps d'initialiser le jeu, avec la méthode initializelevel()
Elle va aussi permettre d'incrémenter le score au fur et à mesure de la partie
Enfin, elle va permettre de régénérer les pacgommes et les super-pacgommes, une fois qu'elles auront étaient toutes consommées
 */
public class Game {
    private int nbLignes;
    private int nbColonnes;
    private int nbPacGomme;
    private IntegerProperty score = new SimpleIntegerProperty();
    private Pane pane;
    private Pacman pacman;
    private ArrayList<String> murs = new ArrayList<>();
    private ArrayList<String> pacGommes = new ArrayList<>();
    private Ghost red_ghost = new Ghost();
    private Ghost red_ghost2 = new Ghost();
    private int nbPacGommeInit;

    public Game() {
        nbPacGommeInit=0;
        nbPacGomme=0;
        nbLignes = 0;
        nbColonnes = 0;
        pane = new Pane();
        pane.setStyle("-fx-background-color: BLACK;");
        pacman = new Pacman(1, 1, 1, 1, "pala", "gentil");
        score.set(0);
    }

    public Ghost getRed_ghost2() {
        return red_ghost2;
    }

    public Ghost getRed_ghost() {
        return red_ghost;
    }

    public Pane getPane() {
        return pane;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public ArrayList<String> getMurs() {
        return murs;
    }

    public  IntegerProperty getScore() {
        return score;
    }

    public void setNbPacGomme(int nbPacGomme) {
        this.nbPacGomme = nbPacGomme;
    }

    public int getNbPacGomme() {
        return nbPacGomme;
    }

    public void initializelevel() {
        try {
            InputStream flux = new FileInputStream("resources/Niveau1.txt");
            InputStreamReader lecture = new InputStreamReader(flux);
            BufferedReader buff = new BufferedReader(lecture);
            String ligne;
            int j = 0;
            int i = 0;
            while ((ligne = buff.readLine()) != null) {
                for (i = 0; i < (nbColonnes=ligne.length()); i++) {
                    if (ligne.charAt(i) == 'W') {
                        Rectangle rectangle = new Rectangle(25, 25, Color.BLUE);
                        rectangle.setX(i * 12.5);
                        rectangle.setY(j * 25);
                        pane.getChildren().add(rectangle);
                        nbColonnes++;
                        String cord = new Coordonnees(rectangle.getX() + 12.5, rectangle.getY() + 12.5).toString();
                        murs.add(cord);
                    }
                    if (ligne.charAt(i) == 'S') {
                        Circle pacGomme = (new PacGomme("pacGomme", 10, "none", "null")).getPacgomme();
                        pacGomme.setCenterX(i * 12.5 + 12.5);
                        pacGomme.setCenterY(j * 25 + 12.5);
                        pane.getChildren().add(pacGomme);
                        nbColonnes++;
                        nbPacGomme++;
                        String cord = new Coordonnees(pacGomme.getCenterX(), pacGomme.getCenterY()).toString();
                        pacGommes.add(cord);
                    }
                    if (ligne.charAt(i) == 'B') {
                        Circle superPacGomme = (new SuperPacGomme("superPacGomme", 50, "none", "null")).getSuperPacGomme();
                        superPacGomme.setCenterX(i * 12.5 + 12.5);
                        superPacGomme.setCenterY(j * 25 + 12.5);
                        pane.getChildren().add(superPacGomme);
                        nbColonnes++;
                        String cord = new Coordonnees(superPacGomme.getCenterX(), superPacGomme.getCenterY()).toString();
                        pacGommes.add(cord);
                        nbPacGomme++;
                    }
                    if (ligne.charAt(i) == 'P') {
                        pacman.getCircle().setCenterX(i * 12.5 + 12.5); //au lieu de i*12.5 -> permet de centrer le centre du cercle
                        pacman.getCircle().setCenterY(j * 25 + 12.5); //au lieu de j*25 -> permet de centrer le centre du cercle
                        pane.getChildren().add(pacman.getCircle());
                        nbColonnes++;

                    }
                    if (ligne.charAt(i) == '1') {
                        red_ghost.setCircle(red_ghost.getCircle());
                        red_ghost.getCircle().setCenterX(i*12.5+12.5);
                        red_ghost.getCircle().setCenterY(j*25+12.5);
                        pane.getChildren().add(red_ghost.getCircle());
                    }
                    if (ligne.charAt(i) == '2') {
                        red_ghost2.setCircle(red_ghost2.getCircle());
                        red_ghost2.getCircle().setCenterX(i*12.5+12.5);
                        red_ghost2.getCircle().setCenterY(j*25+12.5);
                        pane.getChildren().add(red_ghost2.getCircle());
                    }

                }
                nbLignes++;
                j++;
            }
            buff.close();
            nbPacGommeInit=nbPacGomme;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

    public int incrementerScore(int score, Circle node){

        if (node.getRadius() == 7) {
            score=score+50;
        } else{
            score=score+10;
        }
        return score;
    }

    public void reloadPacGomme(){
        setNbPacGomme(nbPacGommeInit);
        for (Node p : pane.getChildren()){
            if (p instanceof Circle && ((Circle) p).getRadius()!=12.5){
                p.setStyle("-fx-background-color:" + "yellow" + "; -fx-fill:" + "yellow" + ";");
            }
        }
    }
}



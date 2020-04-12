package items;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.awt.*;
import java.util.*;
import java.util.List;

/*
La classe Pacman étend de la classe Character, c'est donc une classe fille
Elle possède un attribut Circle qui permet de définir la forme et la couleur du pacman
 */
public class Pacman extends Character {
    private Circle pacman;

    public Pacman(float coordX, float coordY, float speedX, float speedY, String model, String state) {
        super(coordX, coordY, speedX, speedY, model, state);
        this.pacman = new Circle(12.5,Color.YELLOW);
    }

    public Circle getCircle(){
        return this.pacman;
    }

    /*
    Ici, on redéfini la méthode seDeplacer de la classe mère
    Elle va permettre de déplacer pacman sur le Pane et la Game donnés en paramètres et suivant la liste des murs donnée elle aussi en paramètre
     */
    @Override
    public void seDeplacer(Pane pane, Game game, ArrayList<String> murs){
        String test = new Coordonnees(game.getPacman().getCircle().getCenterX()+getSpeedX(),game.getPacman().getCircle().getCenterY() +getSpeedY()).toString();
        if(!murs.contains(test)){
            game.getPacman().getCircle().setCenterX(game.getPacman().getCircle().getCenterX()+game.getPacman().getSpeedX());
            game.getPacman().getCircle().setCenterY(game.getPacman().getCircle().getCenterY()+game.getPacman().getSpeedY());
        }

        if(game.getPacman().getCircle().getCenterX()<0){
            game.getPacman().getCircle().setCenterX(19*25-12.5);
        }
        if(game.getPacman().getCircle().getCenterX()>=19*25+12.5){
            game.getPacman().getCircle().setCenterX(12.5);
        }
    }

    /*
    La méthode "manger" va permettre au pacman de manger les pacgommes et les super-pacgommes
    Lorsqu'il mange une pacgommes ou une super-pacgommes, celle-ci disparait, le score augmente et le nombre de pacgommes total diminue
     */
    public void manger(Pane pane, Game game){
        List<Node> pacG = new ArrayList<Node>();
        for (Node p : pane.getChildren()) {
            if (p instanceof Circle && p.contains(game.getPacman().getCircle().getCenterX(), game.getPacman().getCircle().getCenterY()) && !p.getStyle().equals("-fx-background-color:" + "black" + "; -fx-fill:" + "black" + ";")) {
                if(((Circle) p).getRadius()!=12.5) {
                    //p.setStyle("-fx-background-color:" + "black" + "; -fx-fill:" + "black" + ";"); //remettre ca pour le reload
                    pacG.add(p);
                    game.getScore().set(game.incrementerScore(game.getScore().get(), (Circle) p));
                    game.setNbPacGomme(game.getNbPacGomme()-1);
                }
            }
        }
        pane.getChildren().removeAll(pacG);
    }

    @Override
    public String toString() {
        return super.toString() + "Pacman{" +
                "NbLives=" +
                '}';
    }
}

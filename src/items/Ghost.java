package items;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.Random;

/*
La classe Ghost étend de la classe Character, c'est donc une classe fille
Elle possède un attribut Circle qui permet de définir la forme et la couleur d'un fantôme
 */
public class Ghost extends Character {
    private Circle ghostView = new Circle(12.5, Color.RED);

    public Ghost(double coordX, double coordY, float speedX, float speedY, String model, String state, String color, Circle ghostView) {
        super(coordX, coordY, speedX, speedY, model, state);
        this.ghostView = ghostView;
    }

    public Ghost(){

    }

    public Circle getCircle(){
        return this.ghostView;
    }

    public void setCircle(Circle ghostView) {
        this.ghostView = ghostView;
    }

    /*
    Ici, on redéfini la méthode seDeplacer de la classe mère
    Elle va permettre de déplacer un fantôme sur le Pane et la Game donnés en paramètres et suivant la liste des murs donnée elle aussi en paramètre
     */
    @Override
    public void seDeplacer(Pane pane, Game game, ArrayList<String> murs) throws InterruptedException {
        double posX = ghostView.getCenterX();
        double posY = ghostView.getCenterY();
        String test = new Coordonnees(posX+getSpeedX(),posY+getSpeedY()).toString();
        if(!murs.contains(test)){
            ghostView.setCenterX(posX+getSpeedX());
            ghostView.setCenterY(posY+getSpeedY());
        }
        if (ghostView.getCenterX()<0){
            ghostView.setCenterX(19*25-12.5);
        }
        if (ghostView.getCenterX()>19*25){
            ghostView.setCenterX(12.5);
        }
    }

    /*
    La méthode choisirDeplacement() permet aux fantôme de se déplacer de manière complétement aléatoire
     */
    public void choisirDeplacement(){
        Random r = new Random();
        int choix = r.nextInt(4);
        if (choix==0){
            setSpeedX(25);
            setSpeedY(0);
        }
        else if(choix ==1){
            setSpeedX(-25);
            setSpeedY(0);
        }
        else if (choix==2){
            setSpeedY(25);
            setSpeedX(0);
        }
        else if(choix==3){
            setSpeedY(-25);
            setSpeedX(0);
        }
    }
}

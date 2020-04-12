package items;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

/*
La classe Character est la classe mère de Pacman et Ghost
Elle est présente pour éviter la duplication de code du fait que Pacman et Ghost possèdent des attributs et des méthodes communes
Cette classe est abstract car on ne peut pas instancier un personnage en tant que Character. Un personnage est soit un Pacman, soit un Ghost
 */
public abstract class Character {
    private double CoordX;
    private double CoordY;
    private float SpeedX;
    private float SpeedY;
    private String Model;
    private String State;

     public Character(double coordX, double coordY, float speedX, float speedY, String model, String state) {
        CoordX = coordX;
        CoordY = coordY;
        SpeedX = speedX;
        SpeedY = speedY;
        Model = model;
        State = state;
    }

    public Character(double coordX, double coordY){
        CoordX = coordX;
        CoordY = coordY;
    }

    public Character(){

    }


    public void setCoordX(double coordX) {
        CoordX = coordX;
    }


    public void setCoordY(double coordY) {
        CoordY = coordY;
    }

    public float getSpeedX() {
        return SpeedX;
    }

    public void setSpeedX(float speedX) {
        SpeedX = speedX;
    }

    public float getSpeedY() {
        return SpeedY;
    }

    public void setSpeedY(float speedY) {
        SpeedY = speedY;
    }

    /*
    La méthode se déplacer est abstract car le déplacement est différent suivant le personnage
    Elle sera donc redéfini dans les classes filles avec le mot clé : @Override
     */
    public abstract void seDeplacer(Pane pane, Game game, ArrayList<String> murs) throws InterruptedException;

    @Override
    public String toString() {
        return "Character{" +
                "CoordX=" + CoordX +
                ", CoordY=" + CoordY +
                ", SpeedX=" + SpeedX +
                ", SpeedY=" + SpeedY +
                ", Model='" + Model + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}

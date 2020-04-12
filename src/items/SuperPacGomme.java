package items;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
La classe SuperPacGomme étend de la classe Object, c'est donc une classe fille
Elle possède un attribut Circle qui permet de définir la forme et la couleur d'une SuperPacGomme
 */
public class SuperPacGomme extends Object {
    private Circle superPacGomme;

    public SuperPacGomme(String name, float nbPts, String model, String effect) {
        super(name, nbPts, model, effect);
        superPacGomme = new Circle(7, Color.YELLOW);
    }

    public Circle getSuperPacGomme() {
        return superPacGomme;
    }
}

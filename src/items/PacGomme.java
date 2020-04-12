package items;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/*
La classe PacGomme étend de la classe Object, c'est donc une classe fille
Elle possède un attribut Circle qui permet de définir la forme et la couleur d'une PacGomme
 */
public class PacGomme extends Object {
    private Circle pacgomme;

    public PacGomme(String name, int nbPts, String model, String effect) {
        super(name, nbPts, model,effect);
        pacgomme = new Circle(4, Color.YELLOW);
    }

    public Circle getPacgomme() {
        return pacgomme;
    }
}

package Views;

import Manager.GameManager;
import javafx.animation.AnimationTimer;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.util.ArrayList;

/*
La classe GameView permet d'organiser l'affichage de certains éléments dans la vue du jeu tel que le temps et le score
 */
public class GameView {
    private Scene scene;
   private DoubleProperty secondes;

   /*Le constructeur de GameView est responsable de la construction de la vue du jeu, de l'affichage des scores et du temps*/

    /**
     *
     * @param GM le game manager
     * @throws InterruptedException exception levéee si...
     */
    public GameView(GameManager GM) throws InterruptedException {
        IntegerProperty afficheScores = new SimpleIntegerProperty(GameManager.getGame().getScore().get());
        afficheScores.bind(GM.getGame().getScore());
        final int[] compteur = {0};
        secondes = new SimpleDoubleProperty(120);
        /* Met en place une propriété pour afficher le temps restant */
        AnimationTimer mouvement = new AnimationTimer() {
            @Override
            public void handle(long now) {
                compteur[0]++;
                if (compteur[0] % 60 == 0) {
                    secondes.set(120 - compteur[0] / 60);
                }
                if(secondes.get()==0){
                    GM.setInGame(false);
                }
            }
        };
        mouvement.start();
        Text score = new Text("Score : "+ afficheScores.get());
        Text time = new Text("Temps:");

        time.textProperty().bindBidirectional(secondes, new StringConverter<Number>() { //bind du temps
            @Override
            public String toString(Number temps) {
                return "Temps:" + temps;
            }

            @Override
            public Number fromString(String s) {
                return null;
            }
        });
        score.textProperty().bindBidirectional(afficheScores, new StringConverter<Number>() { //bind du score
            @Override
            public String toString(Number monScore) {
                return "Score :"+ monScore;
            }
            @Override
            public Number fromString(String s) {
                return null;
            }
        });
        score.getStyleClass().add("AffTxt");
        time.getStyleClass().add("AffTxt");
        FlowPane root = new FlowPane();
        root.setHgap(50);
        root.getStyleClass().add("MyFlowPane");
        root.getChildren().addAll(GM.getGame().getPane(),   score,time);
        scene = new Scene(root);
        scene.getStylesheets().add("PacmanGame.css");

    }

    public Scene getScene() {
        return scene;
    }
}

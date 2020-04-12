package Controllers;

import Manager.GameManager;
import items.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/*
Ce controlleur va permettre de signaler une collision entre un fantôme et pacman
 */
public class DefeatController {
    public DefeatController(Game game, GameManager gm){
        /*
        La timeline va permettre de vérifier toutes les 1ms si il y a collision entre un fantôme et pacman
         */
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        gm.setInGame(true);
        gm.InGame();
        KeyFrame kf = new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double posXpacman = game.getPacman().getCircle().getCenterX();
                double posYpacman = game.getPacman().getCircle().getCenterY();
                double posXred = game.getRed_ghost().getCircle().getCenterX();
                double posYred = game.getRed_ghost().getCircle().getCenterY();
                double posXgreen = game.getRed_ghost2().getCircle().getCenterX();
                double posYgreen = game.getRed_ghost2().getCircle().getCenterY();
                boolean collision = false;

                if ((posXpacman==posXred && posYpacman==posYred)||(posXpacman==posXgreen && posYpacman==posYgreen)){
                    collision = true;
                }

                if (collision==true){
                    IntegerProperty score = game.getScore();
                    gm.setInGame(false);
                }
            }
        });
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }

}

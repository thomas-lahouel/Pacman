package Controllers;

import items.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

/*
Ce controlleur va permettre aux fantômes de se déplacer de seuls
 */
public class TimeController {

    public TimeController(Game game) {
        /*
        Ici, la timeline va permettre aux fantômes de se déplacer toutes les 100ms
         */
        Timeline timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE); //l'animation se répète à l'inifni
        KeyFrame kf = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                game.getRed_ghost().choisirDeplacement();
                game.getRed_ghost2().choisirDeplacement();
                try {
                    game.getRed_ghost().seDeplacer(game.getPane(), game, game.getMurs());
                    game.getRed_ghost2().seDeplacer(game.getPane(), game, game.getMurs());
                }catch (Exception e){
                }
            }
        });
        timeline.getKeyFrames().add(kf);
        timeline.play();
    }
}

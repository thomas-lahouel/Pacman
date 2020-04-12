package Controllers;

import items.Game;
import javafx.scene.Scene;

/*
Cette classe va permettre de gérer le déplacement du pacman à partir des touches du clavier
 */
public class Controller {

    public Controller(Scene scene, Game game) {
        scene.setOnKeyPressed(keyEvent -> { //utilisation d'une lambda expression
                switch (keyEvent.getCode()) {

                    case UP:
                        game.getPacman().setSpeedY(-25);
                        game.getPacman().setSpeedX(0);
                        break;

                    case DOWN:
                        game.getPacman().setSpeedY(25);
                        game.getPacman().setSpeedX(0);
                        break;

                    case RIGHT:
                        game.getPacman().setSpeedY(0);
                        game.getPacman().setSpeedX(25);
                        break;

                    case LEFT:
                        game.getPacman().setSpeedY(0);
                        game.getPacman().setSpeedX(-25);
                        break;

                }
                game.getPacman().seDeplacer(game.getPane(), game, game.getMurs());
                game.getPacman().manger(game.getPane(),game);
                if(game.getNbPacGomme()==0) {
                    game.reloadPacGomme();
                }
        });
    }

}

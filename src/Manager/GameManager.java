package Manager;

import Controllers.Controller;
import Controllers.DefeatController;
import Controllers.TimeController;
import Views.GameView;
import items.Game;
import items.SauvegardeurScore;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/*
C'est la classe GameManager qui va être appellée dans le main
Elle doit donc permettre de gérer le jeu, c'est-à-dire le lancement et la fin d'une partie
 */
public class GameManager{
    private Stage primaryStage;
    private BooleanProperty inGame;
    private SauvegardeurScore sauvegardeurScore;
    private static Game game;

    public GameManager(Stage primaryStage) throws InterruptedException, IOException {
        sauvegardeurScore = new SauvegardeurScore();
        this.primaryStage = primaryStage;
        game = new Game();
        game.initializelevel();
        inGame = new SimpleBooleanProperty(true);
    }

    /*
    La méthode lancerJeu() permet de récupérer la Scene créée dans GameView puis de l'afficher
    On va aussi appeller les controlleurs utilent au bon fonctionnement du jeu c'est-à-dire :
        - Controller : pour le déplacement du pacman
        - TimeController : pour le déplacement des fantômes
        - DefeatController : pour signaler une collision entre pacman et un fantôme
     */
    public void lancerJeu() throws InterruptedException {
        Scene scene = new GameView(this).getScene();
        primaryStage.setTitle("Pac man");
        primaryStage.setScene(scene);;
        new Controller(scene,getGame());
        new TimeController(getGame());
        new DefeatController(getGame(),this);
        primaryStage.show();
    }

    /*
    La méthode gameOver() permet de changer de Scene lorsqu'on détecte un collision entre pacman et un fantôme
     */
    public void gameOver() throws IOException {
        sauvegardeurScore.sauvegarder(game);
        /*
        FXMLLoader permet de charger un fichier fxml
         */
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Defeat.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*
    La méthode InGame permet de rattacher un listener sur la propriété "inGame", qui sera appellé dès que inGame() change de valeur
     */
    public void InGame(){
        inGame = new SimpleBooleanProperty(true);
        inGameProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            try {
                gameOver();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public final void setInGame(boolean changement){
        inGame.set(changement);
    }


    /*
   La méthode InGameProperty permet de retourner la propriété inGame
    */
    public BooleanProperty inGameProperty(){
        return inGame;
    }

    public static Game getGame() {
        return game;
    }
}

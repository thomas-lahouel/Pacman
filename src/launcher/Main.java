package launcher;


import Manager.GameManager;
import javafx.application.Application;
import javafx.stage.Stage;

/*
La classe Main est la classe maîtresse de notre application puisque c'est elle qui va nous permettre de lancer l'application
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameManager gm = new GameManager(primaryStage);
        gm.lancerJeu();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
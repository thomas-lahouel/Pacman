package items;

import java.io.*;

/*
La classe SauvegardeurScore va permettre de faire de la persistance en enregistrant les scores obtenus dans un fichier texte : "score.txt"
 */
public class SauvegardeurScore {
    /*
    Un FileWriter permet d'écrire dans un fichier et d'écrire à la suite du fichier s'il posssède des lignes
     */
    private FileWriter writer;

    public SauvegardeurScore() throws IOException {
        writer = new FileWriter("resources/score.txt",true);
    }

    /*
    La méthode "sauvegarder" ca permettre d'écrire le score dans le fichier
     */
    public void sauvegarder(Game game) throws IOException {
        writer.write(game.getScore().get() + "\n");
        writer.close();
    }
}

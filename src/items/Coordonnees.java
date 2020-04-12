package items;
/*
Cette classe va permettre de stocker les Coordonnees x et y de différents élements du jeu tels que les murs, les pacgommes et les super-pacgommes
 */
public class Coordonnees {
    private double x;
    private double y;

    public Coordonnees(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordonnees{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

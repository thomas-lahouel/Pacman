package items;

/*
La classe Object est la classe mère de PacGomme et SuperPacGomme
Elle est présente pour éviter la duplication de code du fait que PacGomme et SuperPacGomme possèdent des attributs communs
Cette classe est abstract car on ne peut pas instancier un objet en tant que Object. Un objet est soit une PacGomme, soit une SuperPacGomme
 */
public abstract class Object {
    private String Name;
    private float NbPts;
    private String Model;
    private String Effect;

    public Object(String name, float nbPts, String model, String effect) {
        Name = name;
        NbPts = nbPts;
        Model = model;
        Effect = effect;
    }

    @Override
    public String toString() {
        return "Object{" +
                "Name='" + Name + '\'' +
                ", NbPts=" + NbPts +
                ", Model='" + Model + '\'' +
                ", Effect='" + Effect + '\'' +
                '}';
    }
}

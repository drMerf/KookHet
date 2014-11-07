package be.howest.nmct.android.data;

/**
 * Created by Tom on 11/6/2014.
 */
public class Categorie{
    int ID;
    String naam;

    public Categorie(int ID, String naam) {
        this.ID = ID;
        this.naam = naam;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }
}

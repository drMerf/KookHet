package be.howest.nmct.android.kookhet.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.Duration;

// TODO: Replace all uses of this class before publishing your app.
// Helper class for providing sample content for user interfaces created by Android template wizards.
public class DummyContent {

    // An array of sample items.
    public static List<Categorie> CATEGORIEEN = new ArrayList<Categorie>();
    public static List<Recept> RECEPTEN = new ArrayList<Recept>();

    // A map of sample items, by ID.
    public static Map<String, Categorie> CATEGORIEEN_MAP = new HashMap<String, Categorie>();
    public static Map<String, Recept> RECEPTEN_MAP = new HashMap<String, Recept>();

    private static void addItem(Categorie item) {
        CATEGORIEEN.add(item);
        CATEGORIEEN_MAP.put(item.id, item);
    }

    private static void addItem(Recept item) {
        RECEPTEN.add(item);
        RECEPTEN_MAP.put(item.id, item);
    }

    static {
        addItem(new Categorie("1", "Voorgerechten"));
        addItem(new Categorie("2", "Hoofdgerechten"));
        addItem(new Categorie("3", "Deserts"));
        addItem(new Recept("1", "1", "Tomatensoep met balletjes", "", null, false));
        addItem(new Recept("2", "2", "Spaghetti Bolognese", "", null, false));
        addItem(new Recept("3", "2", "Kip met appelmoes en kroketjes", "", null, false));
        addItem(new Recept("4", "2", "Stoofvlees met frieten", "", null, false));
        addItem(new Recept("5", "3", "Chocolademousse", "", null, false));
    }

    public static class Categorie {
        public String id;
        public String naam;

        public Categorie(String id, String naam) {
            this.id = id;
            this.naam = naam;
        }

        @Override
        public String toString() {
            return naam;
        }
    }

    public static class Recept {
        public String id;
        public String naam;
        public String categorie;
        public String bereidingswijze;
        public Duration bereidingstijd;
        public boolean vegetarisch;

        public Recept(String id, String categorie, String naam, String bereidingswijze, Duration bereidingstijd, boolean vegetarisch) {
            this.id = id;
            this.naam = naam;
            this.categorie = categorie;
            this.bereidingswijze = bereidingswijze;
            this.bereidingstijd = bereidingstijd;
            this.vegetarisch = vegetarisch;
        }

        @Override
        public String toString() {
            return naam;
        }
    }
}

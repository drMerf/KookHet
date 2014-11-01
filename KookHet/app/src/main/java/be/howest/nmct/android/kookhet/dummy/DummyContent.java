package be.howest.nmct.android.kookhet.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Helper class for providing sample content for user interfaces created by Android template wizards.
// TODO: Replace all uses of this class before publishing your app.
public class DummyContent {

    // An array of sample items.
    public static List<Categorie> CATEGORIEEN = new ArrayList<Categorie>();
    public static List<Recept> RECEPTEN = new ArrayList<Recept>();

    // A map of sample items, by ID.
    public static Map<String, Categorie> CATEGORIEEN_MAP = new HashMap<String, Categorie>();
    public static Map<String, Recept> RECEPTEN_MAP = new HashMap<String, Recept>();

    static {
        // Add sample items.
        addItem(new Categorie("1", "Categorie 1"));
        addItem(new Categorie("2", "Categorie 2"));
        addItem(new Categorie("3", "Categorie 3"));
        addItem(new Recept("1", "Recept 1"));
        addItem(new Recept("2", "Recept 2"));
        addItem(new Recept("3", "Recept 3"));
        addItem(new Recept("4", "Recept 4"));
    }

    public static class Categorie {
        public String id;
        public String content;

        public Categorie(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    private static void addItem(Categorie item) {
        CATEGORIEEN.add(item);
        CATEGORIEEN_MAP.put(item.id, item);
    }

    public static class Recept {
        public String id;
        public String content;

        public Recept(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    private static void addItem(Recept item) {
        RECEPTEN.add(item);
        RECEPTEN_MAP.put(item.id, item);
    }
}

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    private HashMap<Integer, Uzel> uzly = new HashMap<>();
    private HashSet<Hrana> hrany = new HashSet<Hrana>();

    public void pridej(int nazev1, int nazev2, int cena) {
        Uzel u1 = vezmiExistujiciNeboVytvor(nazev1);
        Uzel u2 = vezmiExistujiciNeboVytvor(nazev2);

        Hrana h1 = new Hrana(u1, u2, cena);
        hrany.add(h1);
    }

    private Uzel vezmiExistujiciNeboVytvor(int nazev1) {
        Uzel novy = uzly.get(nazev1);
        if(novy == null){
            novy = new Uzel(nazev1);
            uzly.put(nazev1, novy);
        }
        return novy;
    }

    public Collection<Uzel> getVrcholy(){
        return uzly.values();
    }

    public HashSet<Hrana> getHrany(){
        return hrany;
    }
}
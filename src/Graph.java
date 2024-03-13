import java.util.HashMap;

public class Graph {
    private HashMap<String, Uzel> vrcholy = new HashMap<>();

    public void pridej(String nazev1, String nazev2, int i) {
        Uzel u1 = vezmiExistujiciNeboVytvor(nazev1);
        Uzel u2 = vezmiExistujiciNeboVytvor(nazev2);

        u1.pridejSouseda(u2, i);
        u2.pridejSouseda(u1, i);
    }
    private Uzel vezmiExistujiciNeboVytvor(String nazev) {
        Uzel u = vrcholy.get(nazev);
        if(u == null) {
            Uzel novy = new Uzel();
            vrcholy.put(nazev, novy);
            u = novy;
        }
        return u;
    }
    public int getCenaMeziUzly(String s1, String s2){
        Uzel u1 = vrcholy.get(s1);
        Uzel u2 = vrcholy.get(s2);
        return u1.getPrimaCena(u2);
    }
}

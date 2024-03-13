import java.util.ArrayList;

public class Cesta {
    private int cena = 0;
    private ArrayList<String> vrcholy = new ArrayList<>();
    private Graph g;

    public Cesta(Graph g) {
        this.g = g;
    }
    public void pridajVrchol(String nazev) {
        vrcholy.add(nazev);
    }
    public int getCena(){
        for(int i = 0; i < vrcholy.size() - 1; i++) {
            cena += g.getCenaMeziUzly(vrcholy.get(i), vrcholy.get(i + 1));
        }
        return cena;
    }
}

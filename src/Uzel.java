import java.util.HashMap;

public class Uzel {
    private int nazev;

    public Uzel(int nazev) {
        this.nazev = nazev;
    }
    public int getNazev(){
        return nazev;
    }
    @Override
    public String toString(){
        return "Uzel name: " + nazev;
    }
}

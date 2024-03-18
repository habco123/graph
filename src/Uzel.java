import java.util.HashMap;

public class Uzel {
    private HashMap<Uzel, Integer> hehe = new HashMap<>();

    public void pridejSouseda(Uzel sused, int vaha) {
        hehe.put(sused, vaha);
    }
    public int getPrimaCena(Uzel u) {
        return hehe.get(u);
    }
}

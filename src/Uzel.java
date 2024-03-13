import java.util.ArrayList;

public class Uzel {
    private ArrayList<Uzel> sousede = new ArrayList<>();
    private ArrayList<Integer> vahy = new ArrayList<>();

    public void pridejSouseda(Uzel sused, int vaha) {
        sousede.add(sused);
        vahy.add(vaha);
    }
    public int getPrimaCena(Uzel u) {
        return vahy.get(sousede.indexOf(u));
    }
}

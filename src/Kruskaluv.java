import com.sun.jdi.connect.spi.TransportService;

import java.util.*;

public class Kruskaluv {
    private Graph g;

    public Kruskaluv(Graph g){
        this.g = g;
    }

    public ArrayList<Hrana> getSpanningTree(){
        HashMap<Uzel, Set<Uzel>> forest = new HashMap<>();
        inicializujeLes(forest);
        ArrayList<Hrana> minSpanTree = new ArrayList<>();
        nalezniKostruGrafu(forest, minSpanTree);

        return minSpanTree;
    }
    private void inicializujeLes(HashMap<Uzel, Set<Uzel>> forest) {
        Collection<Uzel> uzly = g.getVrcholy();
        for (Uzel uzel : uzly) {
            Set<Uzel> set = new HashSet<>();
            set.add(uzel);
            forest.put(uzel, set);
        }
    }
    private void nalezniKostruGrafu(HashMap<Uzel, Set<Uzel>> forest, ArrayList<Hrana> minSpanTree) {

        LinkedList<Hrana> hrany = new LinkedList<>();
        hrany.addAll(g.getHrany());

        Collections.sort(hrany, new ComparatorHranDleCeny());

        for(Hrana hrana : hrany){
            Set<Uzel> mnozinaUzlu1 = forest.get(hrana.getOdkud());
            Set<Uzel> mnozinaUzlu2 = forest.get(hrana.getKam());
            if(!mnozinaUzlu1.equals(mnozinaUzlu2)){
                minSpanTree.add(hrana);
                mnozinaUzlu1.addAll(mnozinaUzlu2);
                for(Uzel u : mnozinaUzlu1){
                    forest.put(u , mnozinaUzlu1);
                }
            }
        }
    }
}

import java.util.Comparator;

public class ComparatorHranDleCeny implements Comparator<Hrana> {

    @Override
    public int compare(Hrana h1, Hrana h2){
        Integer cena1 = h1.getCena();
        Integer cena2 = h2.getCena();
        return cena1.compareTo(cena2);
    }
}


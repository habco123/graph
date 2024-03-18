import java.util.*;

public class main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final int HORE = 1;
        final int DOLE = 2;
        final int DOPRAVA = 3;
        final int DOLAVA = 4;
        Pole pole = new Pole();
        System.out.println("zaciatocna pozicia: \n" + pole);
        if (pole.countInversions() % 2 != 0) {
            System.out.println("The puzzle is unsolvable from this initial state.");
            return;
        }
        LinkedList<Pole> queue = new LinkedList<>();
        HashSet<Pole> pozrene = new HashSet<>();
        queue.addFirst(pole);
        pozrene.add(pole);
        while(!queue.isEmpty()){
            Pole tmp = queue.poll();
            if(tmp.jeReseni()){
                System.out.println(tmp);
                System.out.println(tmp.getPohyby());
                break;
            }
            for (int move : Arrays.asList(HORE, DOLE, DOPRAVA, DOLAVA)) {
                Pole next = tmp.klonujAPohni(move);
                if (!pozrene.contains(next)) {
                    queue.add(next);
                    pozrene.add(next);
                }
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Runtime: " + elapsedTime + " milliseconds");
    }
}

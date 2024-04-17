public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.pridej(1, 2, 4);
        g.pridej(2, 3, 24);
        g.pridej(1, 6, 6);
        g.pridej(1, 7, 16);
        g.pridej(6, 3, 23);
        g.pridej(6, 5, 5);
        g.pridej(6, 7, 8);
        g.pridej(7, 8, 21);
        g.pridej(5, 8, 14);
        g.pridej(5, 4, 11);
        g.pridej(5, 3, 18);
        g.pridej(4, 3, 9);
        g.pridej(4, 8, 7);

        Kruskaluv k = new Kruskaluv(g);
        System.out.println(k.getSpanningTree());
    }
}

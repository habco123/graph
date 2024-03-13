public class main {

    public static void main(String[] args) {
        Graph g = new Graph();

        g.pridej("1", "2", 4);
        g.pridej("2", "3", 24);
        g.pridej("1", "6", 6);
        g.pridej("1", "7", 16);
        g.pridej("7", "8", 21);
        g.pridej("7", "6", 8);
        g.pridej("7", "5", 10);
        g.pridej("6", "5", 5);
        g.pridej("5", "3", 18);
        g.pridej("5", "4", 11);
        g.pridej("5", "8", 1);
        g.pridej("3", "4", 9);
        g.pridej("8", "4", 7);
        g.pridej("6", "3", 23);

        Cesta c = new Cesta(g);
        c.pridajVrchol("1");
        c.pridajVrchol("6");
        c.pridajVrchol("5");
        c.pridajVrchol("4");
        c.pridajVrchol("3");
        System.out.println(c.getCena());

    }
}

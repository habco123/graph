public class Hrana {
    private Uzel u1;
    private Uzel u2;
    private int cena;

    public Hrana(Uzel u1, Uzel u2, int cena) {
        this.u1 = u1;
        this.u2 = u2;
        this.cena = cena;
    }

    public int getCena(){
        return cena;
    }

    @Override
    public String toString(){
        return "U1: " + u1.getNazev() + " U2: " + u2.getNazev() + " Cena: " + cena;
    }
    public Uzel getOdkud() {
        return u1;
    }
    public Uzel getKam() {
        return u2;
    }
}

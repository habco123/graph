import java.util.Arrays;
import java.util.LinkedList;


public class Pole implements Comparable<Pole>{
    static final int HORE = 1;
    static final int DOLE = 2;
    static final int DOPRAVA = 3;
    static final int DOLAVA = 4;
    private int[][] pole = {{8,6,7}, {2,5,4}, {3,0,1}};//hardest starting state
    private LinkedList<String> pohyby = new LinkedList<>();
    private int x = 2;
    private int y = 1;

    public void pohni(int move){
        switch(move){
            case HORE:
                if(x <= 0){
                    return;
                }
                pole[x][y] = pole[x-1][y];
                pole[x-1][y] = 0;
                x--;
                break;
            case DOLE:
                if(x >= 2){
                    return;
                }
                pole[x][y] = pole[x+1][y];
                pole[x+1][y] = 0;
                x++;
                break;
            case DOLAVA:
                if(y <= 0){
                    return;
                }
                pole[x][y] = pole[x][y-1];
                pole[x][y-1] = 0;
                y--;
                break;
            case DOPRAVA:
                if(y >= 2){
                    return;
                }
                pole[x][y] = pole[x][y+1];
                pole[x][y+1] = 0;
                y++;
                break;
        }
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i< pole.length; i++) {
            for(int j = 0; j< pole.length; j++) {
                builder.append(pole[i][j]);
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
    public Pole klonujAPohni(int move) {
        Pole copiedPole = new Pole();
        for (int i = 0; i < pole.length; i++) {
            copiedPole.pole[i] = Arrays.copyOf(this.pole[i], this.pole[i].length);
        }
        copiedPole.x = this.x;
        copiedPole.y = this.y;
        copiedPole.pohyby.addAll(this.pohyby);

        copiedPole.pohni(move);
        copiedPole.pohyby.add(moveAsString(move));

        return copiedPole;
    }
    private String moveAsString(int move) {
        return switch (move) {
            case HORE -> "HORE";
            case DOLE -> "DOLE";
            case DOLAVA -> "DOLAVA";
            case DOPRAVA -> "DOPRAVA";
            default -> "";
        };
    }
    public boolean jeReseni() {
        int[][] reseni = {{1,2,3}, {4,5,6},{7,8,0}};
        return Arrays.deepEquals(this.pole, reseni);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Pole other = (Pole) obj;
        return Arrays.deepEquals(pole, other.pole) && x == other.x && y == other.y;
    }
    @Override
    public int hashCode() {
        int result = Arrays.deepHashCode(pole);
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }
    @Override
    public int compareTo(Pole other) {
        if (this.x != other.x) {
            return Integer.compare(this.x, other.x);
        } else {
            return Integer.compare(this.y, other.y);
        }
    }
    public LinkedList<String> getPohyby() {
        return pohyby;
    }

    public int countInversions() {
        int inversions = 0;
        for (int i = 0; i < pole.length * pole.length; i++) {
            int row1 = i / pole.length;
            int col1 = i % pole.length;
            if (pole[row1][col1] != 0) {
                for (int j = i + 1; j < pole.length * pole.length; j++) {
                    int row2 = j / pole.length;
                    int col2 = j % pole.length;
                    if (pole[row2][col2] != 0 && pole[row1][col1] > pole[row2][col2]) {
                        inversions++;
                    }
                }
            }
        }
        return inversions;
    }
}

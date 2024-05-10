package parkinglot;

public class Position {
    private int i;
    private int j;

    public Position(int i,int j) {
        this.j = j;
        this.i = i;
    }
    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    @Override
    public String toString() {
        return "Position{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }
}

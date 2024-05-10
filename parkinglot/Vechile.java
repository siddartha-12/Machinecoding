package parkinglot;

public class Vechile {

    public Vechile(int registrationNumber, Color color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    private int registrationNumber;
    private Color color;
}

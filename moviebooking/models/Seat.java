package moviebooking.models;

import lombok.Getter;

@Getter
public class Seat {
    private final String id;
    private final int row;
    private final int col;

    public Seat(String id, int row, int col) {
        this.id = id;
        this.row = row;
        this.col = col;
    }
}

package moviebooking.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

@Getter
public class Screen {
    private final String id;
    private final String name;
    private final Theatre theatre;
    private final Map<String,Seat> seats;

    public Screen(@NonNull final String id, @NonNull final String name, @NonNull final Theatre theatre) {
        this.id = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new HashMap<>();
    }

    public void addSeat(@NonNull final Seat seat){
        seats.put(seat.getId(),seat);
    }
    public Seat getSeat(String id){
        return seats.getOrDefault(id,null);
    }
}

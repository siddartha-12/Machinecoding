package moviebooking.models;

import lombok.Getter;
import lombok.NonNull;
@Getter
public class Movie {
    private final String id;
    private final String name;

    public Movie(@NonNull final String id,@NonNull final String name) {
        this.id = id;
        this.name = name;
    }
}

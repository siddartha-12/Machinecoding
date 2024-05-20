package moviebooking.models;

import lombok.Getter;
import lombok.NonNull;

import java.util.Date;

@Getter
public class Show {
    private final String id;
    private final Screen screen;
    private final Movie movie;
    private final Date startTime;
    private final Long durationInSeconds;

    public Show(@NonNull final String id,@NonNull final Screen screen, @NonNull final Movie movie, @NonNull final Date startTime, @NonNull final Long durationInSeconds) {
        this.id = id;
        this.screen = screen;
        this.movie = movie;
        this.startTime = startTime;
        this.durationInSeconds = durationInSeconds;
    }
}

package moviebooking.LockProviders;

import lombok.NonNull;
import moviebooking.models.Seat;
import moviebooking.models.Show;

import java.util.List;

public interface LockProvider {
    public void lockSeats(Show show, List<Seat> seats, String userId);
    public void unlockSeats(Show show, List<Seat> seats, String userId);

    boolean validateLock(@NonNull Show show, @NonNull Seat seat, @NonNull String user);

    List<Seat> getLockedSeats(@NonNull Show show);
}

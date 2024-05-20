package cabbooking.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Location {
    private int x;
    private int y;

    public void updateLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
}

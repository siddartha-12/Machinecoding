package tictoctoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private int id;
    private String name;
    private String symbol;
}

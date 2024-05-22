package tictoctoe.services;

import lombok.AllArgsConstructor;
import tictoctoe.models.Board;

@AllArgsConstructor
public class GameValidator {
    private Board board;

    public boolean isCoordinatesValid(int i, int j){
        return i>=0 && i<board.getBoard().length && j>=0 && j<board.getBoard().length;
    }
    public boolean isPositionEmpty(int i, int j){
        return board.getPosition(i,j).equals("-");
    }
}

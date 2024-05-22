package tictoctoe.exceptions;

public class BoardFilledException extends RuntimeException{
    public BoardFilledException(String message){
        super(message);
    }
}

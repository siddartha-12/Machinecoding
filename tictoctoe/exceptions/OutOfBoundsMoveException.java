package tictoctoe.exceptions;

public class OutOfBoundsMoveException extends RuntimeException{
    public OutOfBoundsMoveException(String message){
        super(message);
    }
}

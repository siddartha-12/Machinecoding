package tictoctoe.exceptions;

public class AlreadyFilledException extends RuntimeException{
    public AlreadyFilledException(String message){
        super(message);
    }
}

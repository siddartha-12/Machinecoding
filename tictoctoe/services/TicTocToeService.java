package tictoctoe.services;

import lombok.AllArgsConstructor;
import tictoctoe.exceptions.AlreadyFilledException;
import tictoctoe.exceptions.BoardFilledException;
import tictoctoe.exceptions.OutOfBoundsMoveException;
import tictoctoe.models.Board;
import tictoctoe.models.Player;

import java.util.List;


public class TicTocToeService {
    private final Board board;
    private final GameValidator gameValidator;
    public int filledPosition;

    public TicTocToeService(List<Player> players, GameValidator gameValidator, Board board) {
        this.players = players;
        this.gameValidator = gameValidator;
        this.board = board;
        filledPosition = 0;
    }

    private List<Player> players;
    public void input(int i, int j,Player player){
        if(!gameValidator.isCoordinatesValid(i,j)){
            throw new OutOfBoundsMoveException("Moving out of the grid");
        }
        if (!gameValidator.isPositionEmpty(i,j)){
            throw new AlreadyFilledException("This position is already filled");
        }
        String symbol = player.getSymbol();
        filledPosition+=1;
        board.setPosition(i,j,symbol);
        if (isWon(i,j,symbol)){
            System.out.println("Player "+player.getId()+" won");
            System.exit(0);
        }
        if(isBoardFilled()){
            System.out.println("Game is draw");
            System.exit(0);
        }
    }

    private boolean isWon(int i, int j, String  symbol){
        boolean rowWin=true,colWin=true,rightDi = true, leftDi = true;
        for(int k=0;k<board.getBoard().length;k++){
            if(!board.getPosition(i,k).equals(symbol)){
                rowWin = false;
            }
            if(!board.getPosition(k,j).equals(symbol)){
                colWin = false;
            }
            if(!board.getPosition(k,k).equals(symbol)){
                leftDi = false;
            }
            if(!board.getPosition(k,board.getBoard().length-k-1).equals(symbol)){
                rightDi = false;
            }
        }
        return colWin || rowWin || leftDi || rightDi;
    }

    private boolean isBoardFilled(){
        return filledPosition == this.board.getBoard().length*this.board.getBoard().length;
    }
}

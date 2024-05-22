package tictoctoe.models;

public class Board {
    private String[][] board;
    public Board(int size){
        board = new String[size][size];
        for(int i=0;i<size;i++){
            for (int j=0;j<size;j++){
                board[i][j]="_";
            }
        }
    }
    public String getPosition(int i, int j){
        return board[i][j];
    }
    public void setPosition(int i, int j, String symbol){
        board[i][j] = symbol;
    }
    public String[][] getBoard(){
        return this.board;
    }
}

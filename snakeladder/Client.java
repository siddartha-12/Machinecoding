package snakeladder;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Entities entities = Entities.getEntitiesInstance();

        int noOfSnakes = scan.nextInt();
        while(noOfSnakes>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.putSnake(startPosition, endPosition);
            noOfSnakes--;
        }
        int noOfLadders = scan.nextInt();
        while(noOfLadders>0){
            int startPosition = scan.nextInt();
            int endPosition = scan.nextInt();
            entities.putLadder(startPosition, endPosition);
            noOfLadders--;
        }
        int noOfPlayers = scan.nextInt();
        while(noOfPlayers>0){
            Integer player = scan.nextInt();
            entities.playersPosition.put(player,0);
            noOfPlayers--;
        }
        SnakeLadder snakeLadder = new SnakeLadder(6);
        System.out.println(snakeLadder.play());
    }

}

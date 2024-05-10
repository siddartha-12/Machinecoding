package snakeladder;

public class SnakeLadder {
    private Dice dice;
    private Entities entities;
    SnakeLadder(int n)
    {
        dice = new Dice(n);
        this.entities = Entities.getEntitiesInstance();
    }
    public int play()
    {
        int player = 0;
        do {
            player+=1;
            if(player == entities.playersPosition.size()+1)
            {
                player=1;
            }
            int diceNumber = dice.getRandom();
            int lastPosition = entities.playersPosition.get(player);
            int nextPosition = diceNumber + lastPosition;
            if(nextPosition>100)
                continue;
            if(entities.snakes.containsKey(nextPosition))
            {
                entities.playersPosition.put(player,nextPosition-entities.snakes.get(nextPosition));
                System.out.println(""+player+" moved from"+lastPosition+" to "+entities.playersPosition.get(player));
            }
            else if(entities.ladder.containsKey(nextPosition))
            {
                entities.playersPosition.put(player,nextPosition+entities.ladder.get(nextPosition));
                System.out.println(""+player+" moved from"+lastPosition+" to "+entities.playersPosition.get(player));
            }
            else{
                entities.playersPosition.put(player,nextPosition);
                System.out.println(""+player+" moved from"+lastPosition+" to "+entities.playersPosition.get(player));
            }

        }while(entities.playersPosition.get(player)!=100);
        return player;
    }

}


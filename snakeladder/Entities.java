package snakeladder;

import java.util.HashMap;
import java.util.Map;

public class Entities {
    Map<Integer,Integer> snakes;
    Map<Integer,Integer> ladder;
    Map<Integer,Integer> playersPosition;
    static Entities entitiesInstance;
    Entities()
    {
        snakes = new HashMap<>();
        ladder = new HashMap<>();
        playersPosition = new HashMap<>();
    }
    public static Entities getEntitiesInstance()
    {
        if(entitiesInstance == null)
        {
            entitiesInstance = new Entities();
        }
        return entitiesInstance;
    }
    public void putSnake(int start,int end)
    {
        snakes.put(start,end);
    }
    public void putLadder(int start, int end)
    {
        ladder.put(start,end);
    }
}

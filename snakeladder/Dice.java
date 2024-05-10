package snakeladder;

import java.util.Random;

public class Dice {
    private static int min = 1;
    private int max ;
    private Random random;
    Dice(int max)
    {
        this.max = max;
        random = new Random();
    }
    public int getRandom()
    {
        return (random.nextInt(max-min+1))+min;
    }

}

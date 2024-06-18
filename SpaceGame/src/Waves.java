import greenfoot.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waves extends Actor {

    private int cooldown;
    private int amount;
    private int[] monster;
    private int waveNumber=0;
    public Waves(){
        monster = new int[]{10,20,30,40};
    }

    private void spawnCooldown(){
        cooldown = 250;
    }

    private int location(){
        Random rand = new Random();
        int rx = rand.nextInt(1000);
        rx += 100;
        return  rx;
    }

    private void increaseWave(){
        waveNumber++;
    }

    @Override
    public void act(){
        getWorld().showText("Wave: "+ (waveNumber +1), 40, 100);
        cooldown--;

        if(cooldown<=0 && waveNumber<1){
            if(amount < monster[waveNumber]){
                int rx = location();
                int y = 10;
                Monster monster = new Monster();
                getWorld().addObject(monster,rx, y);
                spawnCooldown();

                amount ++;
            }
            else{
                increaseWave();
            }
        }
    }
}

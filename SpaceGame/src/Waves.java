import greenfoot.Actor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Waves extends Actor {

    private int cooldown;
    private int amount;
    public Waves(){

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



    @Override
    public void act(){

        cooldown--;

        if(cooldown<=0 && amount <= 10){
            int rx = location();
            int y = 10;
            Monster monster = new Monster(rx,y);
            getWorld().addObject(monster,rx, y);

            spawnCooldown();

            amount ++;
        }
    }
}

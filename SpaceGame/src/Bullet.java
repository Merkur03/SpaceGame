import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.rmi.MarshalledObject;

public class Bullet extends Actor {

    private int x;
    private int y;
    private int strength;
    private String direction;
    int score = 0;

    public Bullet(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        setImage(new GreenfootImage("./bullet.png"));
        this.strength = 1;
        this.direction = direction;
    }

    public int getStrength() {
        return strength;
    }

    private int rotation(){
        switch (direction){
            case "up": {
                return  -90;
            }
            case "down":{
                return 90;
            }
            case "left":{
                return 180;
            }
        }
        return 0;
    }

    @Override
    public void act() {
        setRotation(rotation());
        move(10);

        if(this.isAtEdge()){
            getWorld().removeObject(this);
            return;
        }


        if (this.isTouching(Monster.class)) {
            getIntersectingObjects(Monster.class).get(0).attacked(getStrength());
            getWorld().removeObject(this);
        }
    }
}

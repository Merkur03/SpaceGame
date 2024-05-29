import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Monster extends Actor {

    private int x;
    private int y;
    private int health;
    private int strength;

    public Monster(int x, int y){
        this.x = x;
        this.y = y;
        setImage(new GreenfootImage("./monster.png"));
        this.health = 2;
        this.strength = 1;
    }

    public void attacked(int strength){
        health -= strength;
        if(health <=0){
            getWorld().removeObject(this);
        }
    }


    @Override
    public void act(){
        setLocation(x, y +1);
        y+= 1;

        if(this.isAtEdge()){
            getWorld().removeObject(this);
            return;
        }

        if (this.isTouching(SpaceShip.class)) {
            getIntersectingObjects(SpaceShip.class).get(0).attacked(getStrength());
            getWorld().removeObject(this);
        }
    }

    public int getHealth(){
        return this.health;
    }
    public int getStrength() {
        return strength;
    }
}

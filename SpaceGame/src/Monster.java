import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Monster extends Actor {

    private int health;
    private final int strength;
    private final String direction;

    public Monster(){
        setImage(new GreenfootImage("./monster.png"));
        this.health = 2;
        this.strength = 1;
        direction = "down";
    }

    public void attacked(int strength){
        health -= strength;
        if(health <=0){
            getWorld().removeObject(this);
            SpaceShip.increaseScore();
        }
    }

    private void move(){
        switch (direction){
            case "down":{
                setLocation(getX(), getY() +1);
                break;
            }
            case"up":{
                setLocation(getX(), getY() -1);
                break;
            }
        }
    }

    @Override
    public void act(){
        move();

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

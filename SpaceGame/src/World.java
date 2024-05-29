import greenfoot.GreenfootImage;

public class World extends greenfoot.World {

    public World(){
        super(1200, 580 ,1);
        setBackground(new GreenfootImage("./space.jpg"));
        SpaceShip s = new SpaceShip(700, 500);
        addObject(s,700,500);
    }
}

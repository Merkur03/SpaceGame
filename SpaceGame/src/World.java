import greenfoot.GreenfootImage;

public class World extends greenfoot.World {

    public World(){
        super(1200, 580 ,1);
        setBackground(new GreenfootImage("./space.jpg"));

        SpaceShip ship = new SpaceShip();
        addObject(ship,700,500);

        Waves waves = new Waves();
        addObject(waves,0,0);
    }
}

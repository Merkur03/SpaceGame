import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class SpaceShip extends Actor {

    private int x;
    private int y;
    private int shootCooldown;
    private int health;
    boolean a=true;
    public SpaceShip(int x, int y){
        this.x = x;
        this.y =y;
        setImage(new GreenfootImage("./ufo.png"));
        this.health = 3;
    }


    private void shootBulletCooldown(){
        shootCooldown = 25;
    }

    public void attacked(int strength){
        health-=strength;
        if(this.health <=0){
            getWorld().removeObject(this);
        }
    }

    @Override
    public void act() {
        shootCooldown--;
        Waves waves = new Waves();

        if(a){
            getWorld().addObject(waves,0,0);
            a= false;
        }

        if(Greenfoot.isKeyDown("a")){
            move(-8);
            x+= -8;
        }

        if(Greenfoot.isKeyDown("d")){
            move(8);
            x += 8;
        }
        if(Greenfoot.isKeyDown("w")){
             setLocation(x, y -8);
             y+= -8;
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(x, y +8);
            y +=8;
        }

        if(Greenfoot.isKeyDown("up")){
            String direction = "up";
            shootBullet(direction);
        }

        if(Greenfoot.isKeyDown("down")){
            String direction = "down";
            shootBullet(direction);
        }
        if(Greenfoot.isKeyDown("right")){
            String direction = "right";
            shootBullet(direction);
        }
        if(Greenfoot.isKeyDown("left")){
            String direction = "left";
            shootBullet(direction);
        }
    }

    private void shootBullet(String direction){
        if(shootCooldown<=0){
            Bullet bullet1 = new Bullet(x-6,y-30, direction);
            getWorld().addObject(bullet1,x-6,y-30);
            shootBulletCooldown();
        }
    }
}

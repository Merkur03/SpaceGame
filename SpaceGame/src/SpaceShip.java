import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class SpaceShip extends Actor {

    private int shootCooldown;
    private boolean attacked;
    private HeartDisplay heartDisplay;
    private int health;
    private int speed;
    private static int score;
    public SpaceShip(){
        setImage(new GreenfootImage("./ufo.png"));
        this.health = 5;
        this.speed = 8;
        heartDisplay = new HeartDisplay(health);
    }

    public static void increaseScore(){
        score ++;
    }
    private void shootBulletCooldown(){
        shootCooldown = 25;
    }

    public void attacked(int strength){
        health-=strength;
        if(this.health <=0){
            getWorld().removeObject(this);
            GameOver gameover = new GameOver();
            Greenfoot.setWorld(gameover);
        }
        attacked = true;
    }

    @Override
    public void act() {
        shootCooldown--;
        getWorld().addObject(heartDisplay,0,0);
        getWorld().showText("Score: "+ score, 40, 120);

        if(attacked){
            heartDisplay.decreaseAmount();
            attacked = false;
        }

        if(Greenfoot.isKeyDown("a")){
            setLocation(getX()-speed,getY());
        }

        if(Greenfoot.isKeyDown("d")){
            setLocation(getX()+speed,getY());
        }
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY()-speed);
        }
        if(Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+speed);
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
            Bullet bullet1 = new Bullet(direction);
            getWorld().addObject(bullet1,getX()-6,getY()-30);
            shootBulletCooldown();
        }
    }
}

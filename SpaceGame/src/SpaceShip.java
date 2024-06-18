import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class SpaceShip extends Actor {

    private int x;
    private int y;
    private int shootCooldown;
    private int health;
    private boolean attacked =false;
    private HeartDisplay heartDisplay;
    //private Waves waves;
    private int speed = 8;

    private static int score;
    boolean a=true;
    public SpaceShip(int x, int y){
        this.x = x;
        this.y =y;
        setImage(new GreenfootImage("./ufo.png"));
        this.health = 5;

        heartDisplay = new HeartDisplay(health);
        //waves = new Waves();

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
            Gameover gameover = new Gameover();
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

        if(a){
            //getWorld().addObject(waves,0,0);
            a= false;
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
            Bullet bullet1 = new Bullet(getX()-6,getY()-30, direction);
            getWorld().addObject(bullet1,getX()-6,getY()-30);
            shootBulletCooldown();
        }
    }
}

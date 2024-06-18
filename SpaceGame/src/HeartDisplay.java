import greenfoot.Actor;

import java.util.ArrayList;
import java.util.List;

public class HeartDisplay extends Actor {

    private int hearts;
    private int currentHearts;

    //[heart][0]-> x.cord, [1]-> y.cord;
    private int locationsY;
    private int[] locationsX;
    private Heart[] heart;

    private List<Heart> heartList;

    public HeartDisplay(int amount) {
        this.hearts = amount;
        this.currentHearts = 0;
        this.locationsY = 50;
        this.locationsX = new int[] {50, 100, 150, 200, 250};
        heartList = new ArrayList<>();
    }

    @Override
    public void act() {
        if(currentHearts<hearts){
            Heart heart = new Heart();
            heartList.add(heart);
            getWorld().addObject(heart,this.locationsX[currentHearts], this.locationsY);
            this.currentHearts++;
        }


        if(currentHearts>hearts){
            getWorld().removeObject(heartList.get(hearts));
        }
    }

    public void setHearts(){
        hearts --;
    }

    public void increaseAmount(){
        if(hearts<5){
            hearts++;
        }
    }

    public void decreaseAmount(){
        if(hearts>1){
            hearts--;
        }
    }

    public int getHearts() {
        return hearts;
    }

    public int getLocationsX(int amount){
        return this.locationsX[amount-1];
    }
    public int getLocationsY(){
        return this.locationsY;
    }
}

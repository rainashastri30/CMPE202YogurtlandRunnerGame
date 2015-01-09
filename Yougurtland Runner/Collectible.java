import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Collectible extends SpeedObserver
{
    //private String[] cList = ["cherry","banana"];
    //private int count = 0;
    public void updateSpeed(int speed)
    {
       this.speed  = -speed;
    }
    public Collectible(){
        GreenfootImage image = getImage() ;
        image.scale(40, 40);
    }
    public void act() 
    {  
        move();
        if (getX() == 0)
        {
            Background bgWorld = (Background) getWorld() ;
            bgWorld.removeObject( this ) ;
            bgWorld.getSpeedNotifier().detachSpeedObserver(this);
        }
    }    
    
    public Collectible getRandomCollectible(){
       int i = Greenfoot.getRandomNumber(5);
       Collectible c = null;
       switch(i) {
           case 0: c = new Cherry();
                    break;
           case 1: c = new Banana();
                    break;
           case 2: c = new Pear();
                    break;
           case 3: c = new Pineapple();
                    break;
           case 4: c = new Strawberry();
                    break;
        }
        return c;
    }
}

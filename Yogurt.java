import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Yogurt extends Actor
{
    private int scale;
    private int transparency;
    private GreenfootImage yogurtImage;
    
    public Yogurt()
    {
        scale = 130;
        transparency = 255;
        yogurtImage = new GreenfootImage("./images/yogurt.png");
        yogurtImage.scale(scale,scale);
    }
    
    public void act() 
    {
        if(transparency == 1)
        {
            getWorld().removeObject(this);
        }
        yogurtImage.setTransparency(transparency);
        this.setImage(yogurtImage);
        transparency -=1;
    }    
}

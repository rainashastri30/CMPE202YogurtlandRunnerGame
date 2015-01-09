import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackgroundTheme here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackgroundTheme extends Actor
{
    /**
     * Act - do whatever the BackgroundTheme wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     public void act() 
    {
       // moveBG();
       
       // if(Greenfoot.isKeyDown("right"))
       // {
            //System.out.println(getX());
            setLocation(getX()-1,getY());
            //move(-1);
       // }
        
       // if(Greenfoot.isKeyDown("left"))
       // {
       //     setLocation(getX()+1,getY());
       // }
        if(getX()==(getWorld().getWidth())-1)
        {
            setLocation(400,300);

        } 
         if(getX()==0)
        {
            //System.out.println("if x -1 -"+getX());
            setLocation(400,300);

        } 
        
    }    
    
   private void moveBG()
   {
       //setRotation(0);
       //move(2);
       setLocation(this.getX()+1,this.getY());
   }    
}

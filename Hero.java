import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.*;
/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor implements ScoreSubject
{
    private ActorStrategy hero;
    private ActorStrategy walkingHero;
    private ActorStrategy jumpingHero;
    private ActorStrategy slidingHero;

    private int jumpCounter = 0;
    private ArrayList<ScoreObserver> observers = new ArrayList();
    boolean gameOver = false;
    public Hero(){
        walkingHero = new Walking();
        jumpingHero = new Jumping();
        slidingHero = new Sliding();
        hero = walkingHero;
        
    }

    public void act() 
    {
        if(getY() == 440) {
            jumpCounter = 0;
        }
        hero = walkingHero;
        hero.movement(this);
        
        if(Greenfoot.isKeyDown("up") && jumpCounter < 120){
            hero = jumpingHero;
            hero.movement(this);
            incrementCounter();
        } else if(getY() < 440){
            setImage("Figureright3.png");
            setLocation(getX(),getY()+2);
        }
        
        if(Greenfoot.isKeyDown("down")) {
            hero = slidingHero;
            hero.movement(this);
        } else if(getY() > 440) {
            setLocation(getX(),440);
            hero = walkingHero;
        }
        
        Collectible collectible = (Collectible)getOneIntersectingObject( Collectible.class ) ;
        
        if(collectible != null)
        {
            Background bgWorld = (Background) getWorld() ;
            bgWorld.removeObject(collectible) ;
            bgWorld.getSpeedNotifier().detachSpeedObserver(collectible);
            
            this.notifyObservers(collectible.getClass().getName());
        }
        
        if((getOneObjectAtOffset(1,1,ObstacleAnimal.class)!=null)||
        (getOneObjectAtOffset(-1,-1,ObstacleAnimal.class)!=null)||
        (getOneObjectAtOffset(-1,1,ObstacleAnimal.class)!=null)||
        (getOneObjectAtOffset(1,-1,ObstacleAnimal.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstacleAnimal.class)!=null))
        {
            gameOver = true;
        } else 
        if((getOneObjectAtOffset(1,1,ObstacleWheel.class)!=null) ||
        (getOneObjectAtOffset(-1,-1,ObstacleWheel.class)!=null)||
        (getOneObjectAtOffset(1,-1,ObstacleWheel.class)!=null)||
        (getOneObjectAtOffset(-1,1,ObstacleWheel.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstacleWheel.class)!=null)){
            gameOver = true;
        }
        else
        if((getOneObjectAtOffset(3,3,ObstaclePlant.class)!=null)||
        (getOneObjectAtOffset(-3,-3,ObstaclePlant.class)!=null)||
        (getOneObjectAtOffset(3,-3,ObstaclePlant.class)!=null)||
        (getOneObjectAtOffset(-3,3,ObstaclePlant.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstaclePlant.class)!=null)){
            gameOver = true;
        }
        else
        if((getOneObjectAtOffset(1,1,ObstacleBrick.class)!=null)||
        (getOneObjectAtOffset(-1,-1,ObstacleBrick.class)!=null)||
        (getOneObjectAtOffset(1,-1,ObstacleBrick.class)!=null)||
        (getOneObjectAtOffset(-1,1,ObstacleBrick.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstacleBrick.class)!=null)){
            gameOver = true;
        } else 
        if((getOneObjectAtOffset(1,1,ObstacleBall.class)!=null)||
        (getOneObjectAtOffset(-1,-1,ObstacleBall.class)!=null)||
        (getOneObjectAtOffset(1,-1,ObstacleBall.class)!=null)||
        (getOneObjectAtOffset(-1,1,ObstacleBall.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstacleBall.class)!=null))
        {
            gameOver = true;
        }else if((getOneObjectAtOffset(1,1,ObstacleFence.class)!=null)||
        (getOneObjectAtOffset(-1,-1,ObstacleFence.class)!=null)||
        (getOneObjectAtOffset(1,-1,ObstacleFence.class)!=null)||
        (getOneObjectAtOffset(-1,1,ObstacleFence.class)!=null)||
        (getOneObjectAtOffset(0,0,ObstacleFence.class)!=null))
        {
            gameOver = true;
        }
        
        if(gameOver) {
            Background background = (Background)getWorld();
            background.getGameMenuFacade().stopGame();
        }
    }
    
    public void incrementCounter()
    {
        jumpCounter++;
    }
    
    public void attach(ScoreObserver obj)
    {
        this.observers.add(obj);
    }
    
    public void detach(ScoreObserver obj)
    {
        this.observers.remove(obj);
    }
    
    public void notifyObservers(String scoreElement)
    {
        for(ScoreObserver observer : observers) 
        {
            observer.update(scoreElement);
        }
    }
}
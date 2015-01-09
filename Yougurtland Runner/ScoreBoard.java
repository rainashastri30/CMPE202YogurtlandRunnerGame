import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.HashMap;

public class ScoreBoard extends Actor implements ScoreObserver
{
    private HashMap<String, ScoreCount> scoreObjects= new HashMap<String, ScoreCount>();
    
    public void act() 
    {
    }
    
    public void update(String scoreElement)
    {
        ScoreCount score = scoreObjects.get(scoreElement);
        score.incrementScore();
        score.setImage(score.getScoreImage());
    }
    
    public void addScoreObject(String elementName, ScoreCount element)
    {
        scoreObjects.put(elementName, element);
    }
 
}

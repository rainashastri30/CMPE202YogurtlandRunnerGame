import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class PearScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreCount extends ScoreBoard
{
    private int score = 0;
    public void act() 
    {
        // Add your action code here.
    }
    
    public GreenfootImage getScoreImage() 
    {
        GreenfootImage g = new GreenfootImage(""+score, 20, Color.white, null);
        return g;
    }
    
    public void incrementScore()
    {
        score++;
    }
    
    public int getScore()
    {
        return score;
    }
}

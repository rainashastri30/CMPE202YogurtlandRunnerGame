import greenfoot.*;
 
/**
 * Write a description of class GameMenuFaced here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameMenuFacade  
{
    StartScreen startscreen = null;
    Background mainGame = null;
    
    public GameMenuFacade(StartScreen startscreen,Background mainGame)
    {
        this.startscreen = startscreen;
        this.mainGame = mainGame;
    }
    
    public GameMenuFacade()
    {
        
    }
    
    public void pauseGame(){
        startscreen.setGame(this.mainGame);
        startscreen.setGamePaused(true);
        Greenfoot.setWorld(startscreen); 
        
    }
    
    public void resumeGame(){
        Greenfoot.delay(50);
        Greenfoot.setWorld(mainGame);
        
    }
    
    public void replayGame(){
         mainGame = new Background();
         mainGame.setGameMenuFacade(this);
         mainGame.setStartScreen(startscreen);
         Greenfoot.setWorld(mainGame);
        
    }
    
    public void startGame()
    {
 
            PauseText pauseText = startscreen.getPausedText();
            StartText startText = startscreen.getStartText();
            startscreen.removeObject(pauseText);
            pauseText.setImage("play.png");
            startText.setImage("replay.png");
            startscreen.addObject(pauseText,250,300);
            startscreen.addObject(startText,750,300);

            mainGame = new Background();
            mainGame.setGameMenuFacade(this);
            mainGame.setStartScreen(startscreen);
            Greenfoot.setWorld(mainGame);
        
    }
    
    public void setStartScreen(StartScreen startscreen)
    {
        this.startscreen = startscreen;
    }
    
    public void setMainGame(Background maingame)
    {
        this.mainGame = maingame;
   
    }
   
}

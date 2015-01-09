import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{
    StartText startText = null;
    boolean gamePaused = false;
    Background maingame = null;
    PauseText pauseText = null;
    GameMenuFacade gameMenuFacade = null;
    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    

        super(800, 600, 1);
        startText = new StartText();
        pauseText = new PauseText();
        gameMenuFacade = new GameMenuFacade(this,maingame);
        addObject(startText,400,300);
         
    }
    
    public void act()
    {
        /* if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse.getX() > 260 && mouse.getX() < 540 && mouse.getY() > 20 && mouse.getY() < 320) {
                Greenfoot.setWorld(new Background());
            }
            //System.out.println(mouse.getX() + " " + mouse.getY());
        }*/
        if(!gamePaused){
            
        if(Greenfoot.mouseMoved(startText)){
            
            startText.setImage("start2.png");
        }
        
        if(Greenfoot.mouseClicked(startText)){
            
            gameMenuFacade.startGame();
            /*removeObject(startText);
            pauseText.setImage("play.png");
            startText.setImage("replay.png");
            addObject(pauseText,250,300);
            addObject(startText,550,300);

            maingame = new Background();
            maingame.setStartScreen(this);
            Greenfoot.setWorld(maingame);*/
        }
        }
        else if(gamePaused)
        {
            if(Greenfoot.mouseClicked(pauseText)){
               /* Greenfoot.delay(50);
                Greenfoot.setWorld(maingame);*/
                gameMenuFacade.resumeGame();
            }
            if(Greenfoot.mouseClicked(startText)){
               /*maingame = new Background();
               maingame.setStartScreen(this);
               Greenfoot.setWorld(maingame);*/
               gameMenuFacade.replayGame();
            }
        }
        
       
        
    }
    
    public void setGame(Background maingame)
    {
        this.maingame = maingame;
    }
    
    public void setGamePaused(boolean gamePaused)
    {        
        this.gamePaused = gamePaused;
    }
    
    public PauseText getPausedText()
    {
        return this.pauseText;
    }
    
    public StartText getStartText()
    {
        return this.startText;
    }
}

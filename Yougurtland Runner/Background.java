import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.util.concurrent.TimeUnit;
/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends World
{
    //Amit
    private Manager manager;
    PauseText pauseText =null;
    StartText startText = null;
    boolean screenPaused = true;
    StartScreen startscreen = null;
    GameMenuFacade gameMenuFacade = null;
    int count ,counter=0;
    SpeedNotifier speedNotifier = null;
    //CloudSpeedObserver cloudSpeedObserver = null;
    int speed = 1;
    Date currentDate=null;
    long intialTime = 0;
    long currentTime = 0;
    TimeWatch timeWatch= null;
    Cloud1 cloud1 = null;
    /**
     * Constructor for objects of class Background.
     * 
     */
    public Background()
    {    
        super(800, 600, 1);
        speedNotifier = new SpeedNotifier();
        cloud1 = new Cloud1();

        speedNotifier.attachSpeedObserver(cloud1);
        pauseText = new PauseText();
        startText = new StartText();
        addObject(new BackgroundTheme(),400,300);
        addObject(cloud1,100,100);
        addObject(new Cloud2(),250,225);
        addObject(pauseText,50,50);
        addObject(new Wall(),400,550);
        Hero hero = new Hero();
        addObject(hero,100,440);
        currentDate = new Date();
        intialTime = currentDate.getTime();
        System.out.println(intialTime);
        Greenfoot.start();
        timeWatch = TimeWatch.start();
        manager = new Manager();
        addScoreBoard(hero);
       
    }
    
     public void act()
    {

        currentTime = timeWatch.time(TimeUnit.SECONDS);
        if(currentTime == 5)
        {
            speedNotifier.setGlobalSpeed(++speed);
            //System.out.println(speed);
            timeWatch.reset();
        }
        
        if(Greenfoot.mouseClicked(pauseText)){
            gameMenuFacade.pauseGame();                      
         }
         
       
            if(count++ == 500){
              addNewCollectible();
             
              count = 0;
           
            }
            
            if(counter++ == 700){
           
              addNewObstacle();
              counter = 0;
           //   addObject(manager.getRandomObstacle(), getWidth(), getHeight()-140);
            }
      
        }
    
    public void setStartScreen(StartScreen startscreen)
    {
        this.startscreen = startscreen;
    }
    
    public void setGameMenuFacade(GameMenuFacade gameMenuFacade)
    {
        this.gameMenuFacade = gameMenuFacade;
    }
    
     public void addNewCollectible(){
        CollectibleWrapper colWrapper = manager.getRandomCollectible();
        addObject(colWrapper.getCollectible(), colWrapper.getX(), colWrapper.getY());
        speedNotifier.attachSpeedObserver(colWrapper.getCollectible());
    }
    
    public void addNewObstacle(){
        ObstacleWrapper obsWrapper = manager.getRandomObstacle(this);
        addObject(obsWrapper.getObstacle(),obsWrapper.getX(),obsWrapper.getY());
        speedNotifier.attachSpeedObserver(obsWrapper.getObstacle());
    }
    
    public SpeedNotifier getSpeedNotifier() {
        return this.speedNotifier;
    }
    
    public void addScoreBoard(Hero hero) {
        ScoreImage pear = new ScoreImage();
        pear.setImage(getScoreImage("./images/pear.gif"));
        addObject(pear, 550,30);
        
        ScoreImage cherry = new ScoreImage();
        cherry.setImage(getScoreImage("./images/cherry.gif"));
        addObject(cherry, 600,30);
        
        ScoreImage banana = new ScoreImage();
        banana.setImage(getScoreImage("./images/banana.gif"));
        addObject(banana, 650,30);
        
        ScoreImage pineapple = new ScoreImage();
        pineapple.setImage(getScoreImage("./images/pineapple.gif"));
        addObject(pineapple, 700,30);
        
        ScoreImage strawberry = new ScoreImage();
        strawberry.setImage(getScoreImage("./images/strawberry.gif"));
        addObject(strawberry, 750,30);
        
        ScoreBoard scoreboard = new ScoreBoard();
        hero.attach(scoreboard);
        
        ScoreCount pearScore = new ScoreCount();
        pearScore.setImage(pearScore.getScoreImage());
        addObject(pearScore, 570,30);
        scoreboard.addScoreObject("Pear", pearScore);
        
        ScoreCount cherryScore = new ScoreCount();
        cherryScore.setImage(cherryScore.getScoreImage());
        addObject(cherryScore, 620,30);
        scoreboard.addScoreObject("Cherry",cherryScore);
        
        ScoreCount bananaScore = new ScoreCount();
        bananaScore.setImage(bananaScore.getScoreImage());
        addObject(bananaScore, 670,30);
        scoreboard.addScoreObject("Banana",bananaScore);
        
        ScoreCount pineappleScore = new ScoreCount();
        pineappleScore.setImage(pineappleScore.getScoreImage());
        addObject(pineappleScore, 720,30);
        scoreboard.addScoreObject("Pineapple",pineappleScore);
        
        ScoreCount strawberryScore = new ScoreCount();
        strawberryScore.setImage(strawberryScore.getScoreImage());
        addObject(strawberryScore, 770,30);
        scoreboard.addScoreObject("Strawberry",strawberryScore);
    }
    
    public GreenfootImage getScoreImage(String path) {
        GreenfootImage g = new GreenfootImage(path);
        g.scale(15,20);
        return g;
    }
}

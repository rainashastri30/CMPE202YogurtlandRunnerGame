import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Background extends World
{
    //Amit
    private Manager manager;
    PauseText pauseText =null;
    StartText startText = null;
    boolean screenPaused = true;
    StartScreen startscreen = null;
    GameMenuFacade gameMenuFacade = null;
    int count = 0;
    SpeedNotifier speedNotifier = null;

    int speed = 1;
    Date currentDate=null;
    long currentTime = 0;
    int counter = 0;
    TimeWatch timeWatch= null;
    Cloud1 cloud1 = null;
    private final int MAX_SPEED = 10;
    ScoreBoard scoreboard = null;

    public Background()
    {    
        super(800, 600, 1);
        speedNotifier = new SpeedNotifier();
        cloud1 = new Cloud1();
        speedNotifier.attachSpeedObserver(cloud1);
        pauseText = new PauseText();
        startText = new StartText();
        addObject(new StartScreenBG(),400,300);

        addObject(cloud1,100,100);
        addObject(new Cloud2(),250,225);
        addObject(pauseText,50,50);
        addObject(new Wall(),400,550);
        Hero hero = new Hero();
        addObject(hero,100,440);
        currentDate = new Date();
        
        Greenfoot.start();
        timeWatch = TimeWatch.start();
        manager = new Manager();
        scoreboard = new ScoreBoard();
        hero.attach(scoreboard);
        addScoreBoard();
    }
    
     public void act()
    {
        
        currentTime = timeWatch.time(TimeUnit.SECONDS);
        if(currentTime == 30)
        {
            speedNotifier.setGlobalSpeed(speed < MAX_SPEED ? speed++ : speed);
            //speedNotifier.setGlobalSpeed(10);
            //System.out.println(speed);
            timeWatch.reset();
        }
        
        if(Greenfoot.mouseClicked(pauseText)){
            gameMenuFacade.pauseGame();                      
         }
         
        // if(Greenfoot.isKeyDown("right")) {
            if(count++ == 500){
              addNewCollectible();
              //addNewObstacle();
              count = 0;
           //   addObject(manager.getRandomObstacle(), getWidth(), getHeight()-140);
            }
       // }
          // bg1.setLocation(bg1.getX()-1,bg1.getY());
          // bg1.getOneIntersectingObject(
          // if(bg1.getX() == 0) ;
          
          //  bg2.move(-1);
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
    
    public GameMenuFacade getGameMenuFacade()
    {
        return this.gameMenuFacade;
    }
    
     public void addNewCollectible(){
        List<CollectibleWrapper> list = manager.getRandomCollectible();
        int i =1;
        for(CollectibleWrapper colWrapper : list){
            addObject(colWrapper.getCollectible(), colWrapper.getX(), colWrapper.getY());
            //addObject(colWrapper.getCollectible(),500+(i*200), colWrapper.getY());
            //  addObject(new Cherry(), getWidth(), 300);
              //addObject(new Banana(), getWidth()+30, 300);
              speedNotifier.attachSpeedObserver(colWrapper.getCollectible());
        }
        
    }
    
    public void addNewObstacle(){
        ObstacleWrapper obsWrapper = manager.getRandomObstacle(this);
        addObject(obsWrapper.getObstacle(),obsWrapper.getX(),obsWrapper.getY());
        speedNotifier.attachSpeedObserver(obsWrapper.getObstacle());
    }
    
    public SpeedNotifier getSpeedNotifier() {
        return this.speedNotifier;
    }
    
    public void addScoreBoard() {
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

        ScoreImage yogurt = new ScoreImage();
        GreenfootImage g = new GreenfootImage("./images/yogurt.png");
        g.scale(40,40);
        yogurt.setImage(g);
        addObject(yogurt, 400,30);
        
        ScoreCount pearScore = new ScoreCount();
        pearScore.setImage(pearScore.getScoreImage(20));
        addObject(pearScore, 570,30);
        this.scoreboard.addScoreObject("Pear", pearScore);
        
        ScoreCount cherryScore = new ScoreCount();
        cherryScore.setImage(cherryScore.getScoreImage(20));
        addObject(cherryScore, 620,30);
        scoreboard.addScoreObject("Cherry",cherryScore);
        
        ScoreCount bananaScore = new ScoreCount();
        bananaScore.setImage(bananaScore.getScoreImage(20));
        addObject(bananaScore, 670,30);
        scoreboard.addScoreObject("Banana",bananaScore);
        
        ScoreCount pineappleScore = new ScoreCount();
        pineappleScore.setImage(pineappleScore.getScoreImage(20));
        addObject(pineappleScore, 720,30);
        scoreboard.addScoreObject("Pineapple",pineappleScore);
        
        ScoreCount strawberryScore = new ScoreCount();
        strawberryScore.setImage(strawberryScore.getScoreImage(20));
        addObject(strawberryScore, 770,30);
        scoreboard.addScoreObject("Strawberry",strawberryScore);
        
        ScoreCount yogurtScore = new ScoreCount();
        yogurtScore.setImage(yogurtScore.getScoreImage(40));
        addObject(yogurtScore, 435,30);
        scoreboard.addScoreObject("Yogurt",yogurtScore);

    }
    
    public ScoreBoard getScoreBoard()
    {
        return this.scoreboard;
    }
    
    public GreenfootImage getScoreImage(String path) {
        GreenfootImage g = new GreenfootImage(path);
        g.scale(15,20);
        return g;
    }
}

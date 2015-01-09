import greenfoot.*;
import java.util.Map;
import java.util.HashMap;

public class Manager  
{
    Factory colFactory;
    Factory obsFactory;
    Map<String, Collectible> colMap;
    Map<String, Obstacle> obsMap;
    ObstacleWrapper obsWrapper;
    CollectibleWrapper colWrapper;
    String[] colList = {"banana","pear","cherry","strawberry","pineapple"};
    public Manager(){
        colMap = new HashMap<String, Collectible>();
        obsMap = new HashMap<String, Obstacle>();
        colFactory = new CollectibleFactory();
        obsFactory = new ObstacleFactory();
    }

    public CollectibleWrapper getRandomCollectible(){
        String colType = colList[Greenfoot.getRandomNumber(colList.length)];
        int x = 0;
        int y = 0;

        Collectible c = colMap.get(colType);
        if( c == null) {
            c = colFactory.createCollectible(colType);
            colMap.put(colType, c);
        }
        x = 1000;
        y = 300;

        colWrapper = new CollectibleWrapper();
        colWrapper.setX(x);
        colWrapper.setY(y);
        colWrapper.setCollectible(c);

        return colWrapper;
    }

    public ObstacleWrapper getRandomObstacle(World world){
        String [] obsList = {"plant","brick","fence","ball","wheel"};
        int obstacleType = Greenfoot.getRandomNumber(5);
        Obstacle c = obsMap.get(obsList[obstacleType]);
        if( c == null) {
            c = obsFactory.createObstacle(obsList[obstacleType]);
            obsMap.put(obsList[obstacleType], c);
        }
        obsWrapper = new ObstacleWrapper();
        obsWrapper.setObstacle(c); 
        if(obsList[obstacleType].equals("ball")){
            obsWrapper.setX(((world.getWidth())-200));
            obsWrapper.setY((world.getHeight()-570));
        }else if(obsList[obstacleType].equals("plant")){
            obsWrapper.setX(((world.getWidth())));
            obsWrapper.setY((world.getHeight()-200));

        }else if(obsList[obstacleType].equals("fence")){
            obsWrapper.setX(((world.getWidth())));
            obsWrapper.setY((world.getHeight()-140));}
        else{
            obsWrapper.setX((world.getWidth()));
            obsWrapper.setY((world.getHeight()-160)); }
        return obsWrapper; 
    }
}
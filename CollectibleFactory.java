public class CollectibleFactory  extends Factory
{
    public Collectible createCollectible(String collectible) {
       int i = 4;
       Collectible c = null;
       if(collectible.equals("cherry"))
                c = new Cherry();
       else if(collectible.equals("banana"))
                c = new Banana();
       else if(collectible.equals("pear"))
                 c = new Pear();
       else if(collectible.equals("pineapple"))
                c = new Pineapple();
       else if(collectible.equals("strawberry"))
                c = new Strawberry();
       return c;
    }
    
    public Obstacle createObstacle(String s){
        return null;
    }
}

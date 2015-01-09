public abstract class Factory  
{
    public abstract Obstacle createObstacle(String obstacleType);
    public abstract Collectible createCollectible(String collectibleType);
}

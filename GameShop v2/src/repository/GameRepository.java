package repository;

import entity.GameEntity;
import entity.GameEntity;
import mapper.GameEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    public static List<GameEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Game", new GameEntityMapper());
        List<GameEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof GameEntity){
                result.add((GameEntity) object);
            } else {
                throw new RuntimeException("Expected GameEntity instance");
            }
        }

        return result;
    }

    public static void addGame(GameEntity GameEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Game values(" + GameEntity.getId() + ", '" + GameEntity.getName() + "', " + GameEntity.getSize() + ", " + GameEntity.getPrice() + ", " + GameEntity.getRating() + ", " + GameEntity.getPublisher_id() + ", " + GameEntity.getDeveloper_id() + ", " + GameEntity.getBundle_id() + ")");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Games(name) values('" + GameEntity.getName() + "')");
    }

    public static void updateGame(int Check, double newprice, double newsize, double newrating)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Game" + System.lineSeparator() + "SET PRICE= " + newprice + System.lineSeparator() + "WHERE ID=" + Check);
        DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Game" + System.lineSeparator() + "SET SIZE= " + newsize + System.lineSeparator() + "WHERE ID=" + Check);
        DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Game" + System.lineSeparator() + "SET RATING= " + newrating + System.lineSeparator() + "WHERE ID=" + Check);
    }

    public static void deleteGame(int Check)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Game" + System.lineSeparator() + "WHERE ID=" + Check);
    }
}

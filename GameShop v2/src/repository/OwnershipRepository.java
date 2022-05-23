package repository;

import entity.OwnershipEntity;
import mapper.OwnershipEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class OwnershipRepository {

    public static List<OwnershipEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Ownership", new OwnershipEntityMapper());
        List<OwnershipEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof OwnershipEntity){
                result.add((OwnershipEntity) object);
            } else {
                throw new RuntimeException("Expected OwnershipEntity instance");
            }
        }

        return result;
    }

    public static void addOwnership(OwnershipEntity OwnershipEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Ownership values(" + OwnershipEntity.getGameId() + ", " + OwnershipEntity.getUsersId() + ")");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Ownerships(name) values('" + OwnershipEntity.getName() + "')");
    }
}

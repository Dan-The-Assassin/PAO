package repository;

import entity.PublisherEntity;
import mapper.PublisherEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class PublisherRepository {

    public static List<PublisherEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Publisher", new PublisherEntityMapper());
        List<PublisherEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof PublisherEntity){
                result.add((PublisherEntity) object);
            } else {
                throw new RuntimeException("Expected PublisherEntity instance");
            }
        }

        return result;
    }

    public static void addPublisher(PublisherEntity PublisherEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Publisher values(" + PublisherEntity.getId() + ", '" + PublisherEntity.getName() + "')");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Publishers(name) values('" + PublisherEntity.getName() + "')");
    }

    public static void updatePublisher(int Check, String newname)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Publisher" + System.lineSeparator() + "SET NAME= '" + newname + "'" + System.lineSeparator() + "WHERE ID=" + Check);
    }

    public static void deletePublisher(int Check)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Publisher" + System.lineSeparator() + "WHERE ID=" + Check);
    }
}

package repository;

import entity.DeveloperEntity;
import mapper.DeveloperEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class DeveloperRepository {

    public static List<DeveloperEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Developer", new DeveloperEntityMapper());
        List<DeveloperEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof DeveloperEntity){
                result.add((DeveloperEntity) object);
            } else {
                throw new RuntimeException("Expected DeveloperEntity instance");
            }
        }

        return result;
    }

    public static void addDeveloper(DeveloperEntity DeveloperEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Developer values(" + DeveloperEntity.getId() + ", '" + DeveloperEntity.getName() + "')");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Developers(name) values('" + DeveloperEntity.getName() + "')");
    }

    public static void updateDeveloper(int Check, String newname)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Developer" + System.lineSeparator() + "SET NAME= '" + newname + "'" + System.lineSeparator() + "WHERE ID=" + Check);
    }

    public static void deleteDeveloper(int Check)
    {
        DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Developer" + System.lineSeparator() + "WHERE ID=" + Check);
    }
}

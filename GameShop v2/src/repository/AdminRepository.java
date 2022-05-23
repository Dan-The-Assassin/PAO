package repository;

import entity.AdminEntity;
import mapper.AdminEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

    public static List<AdminEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Admin", new AdminEntityMapper());
        List<AdminEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof AdminEntity){
                result.add((AdminEntity) object);
            } else {
                throw new RuntimeException("Expected AdminEntity instance");
            }
        }

        return result;
    }

    public static void addAdmin(AdminEntity AdminEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Admin values(" + AdminEntity.getId() + ", '" + AdminEntity.getName() + "', '" + AdminEntity.getPassword() + "')");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Admins(name) values('" + AdminEntity.getName() + "')");
    }

    public static void updateAdmin(Object Check, String newpass)
    {
        if(Check instanceof Integer)
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Admin" + System.lineSeparator() + "SET PASSWORD= '" + newpass + "'" + System.lineSeparator() + "WHERE ID=" + Check);
        }
        else
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Admin" + System.lineSeparator() + "SET PASSWORD= '" + newpass + "'" + System.lineSeparator() + "WHERE NAME='" + Check + "'");
        }
    }

    public static void deleteAdmin(Object Check)
    {
        if(Check instanceof Integer)
        {
            DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Admin" + System.lineSeparator() + "WHERE ID=" + Check);
        }
        else
        {
            DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Admin" + System.lineSeparator() + "WHERE NAME='" + Check + "'");
        }
    }
}

package repository;

import entity.UserEntity;
import mapper.UserEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    public static List<UserEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Users", new UserEntityMapper());
        List<UserEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof UserEntity){
                result.add((UserEntity) object);
            } else {
                throw new RuntimeException("Expected UserEntity instance");
            }
        }

        return result;
    }

    public static void addUser(UserEntity UserEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into USERS values(" + UserEntity.getId() + ", '" + UserEntity.getName() + "', '" + UserEntity.getPassword() + "')");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Users(name) values('" + UserEntity.getName() + "')");
    }

    public static void updateUser(Object Check, String newpass)
    {
        if(Check instanceof Integer)
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Users" + System.lineSeparator() + "SET PASSWORD= '" + newpass + "'" + System.lineSeparator() + "WHERE ID=" + Check);
        }
        else
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Users" + System.lineSeparator() + "SET PASSWORD= '" + newpass + "'" + System.lineSeparator() + "WHERE NAME='" + Check + "'");
        }
    }

    public static void deleteUser(Object Check)
    {
        if(Check instanceof Integer)
        {
            DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Users" + System.lineSeparator() + "WHERE ID=" + Check);
        }
        else
        {
            DatabaseQueryExecutorService.executeUpdateQuery("DELETE FROM Users" + System.lineSeparator() + "WHERE NAME='" + Check + "'");
        }
    }
}

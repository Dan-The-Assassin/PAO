package mapper;

import entity.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserEntityMapper implements RowMapper<UserEntity>{

    public UserEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");

        return new UserEntity(id, name, password);
    }
}

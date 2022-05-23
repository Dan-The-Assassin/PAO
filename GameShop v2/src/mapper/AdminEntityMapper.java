package mapper;

import entity.AdminEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminEntityMapper implements RowMapper<AdminEntity>{

    public AdminEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String password = resultSet.getString("password");

        return new AdminEntity(id, name, password);
    }
}

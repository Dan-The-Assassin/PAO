package mapper;

import entity.DeveloperEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeveloperEntityMapper implements RowMapper<DeveloperEntity>{

    public DeveloperEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new DeveloperEntity(id, name);
    }
}

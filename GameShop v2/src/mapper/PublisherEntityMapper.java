package mapper;

import entity.PublisherEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherEntityMapper implements RowMapper<PublisherEntity>{

    public PublisherEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        return new PublisherEntity(id, name);
    }
}

package mapper;

import entity.GameEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GameEntityMapper implements RowMapper<GameEntity>{

    public GameEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double size = resultSet.getDouble("size");
        double price = resultSet.getDouble("price");
        double rating = resultSet.getDouble("rating");
        int publisher_id = resultSet.getInt("publisherid");
        int developer_id = resultSet.getInt("developerid");
        int bundle_id = resultSet.getInt("bundleid");

        return new GameEntity(id, name, size, price, rating, publisher_id, developer_id, bundle_id);
    }
}

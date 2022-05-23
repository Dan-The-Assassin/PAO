package mapper;

import entity.BundleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BundleEntityMapper implements RowMapper<BundleEntity>{

    public BundleEntity mapRow(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int discount = resultSet.getInt("discount");

        return new BundleEntity(id, name, discount);
    }
}

package mapper;

import entity.OwnershipEntity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OwnershipEntityMapper implements RowMapper<OwnershipEntity> {

    public OwnershipEntity mapRow(ResultSet resultSet) throws SQLException {

        int GameId = resultSet.getInt("GameId");
        int UsersId = resultSet.getInt("UsersId");


        OwnershipEntity ownershipEntity = new OwnershipEntity();
        ownershipEntity.setGameId(GameId);
        ownershipEntity.setUsersId(UsersId);

        return ownershipEntity;
    }
}

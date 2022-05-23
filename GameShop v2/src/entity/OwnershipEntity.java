package entity;

public class OwnershipEntity {
    protected int GameId;
    protected int UsersId;

    public int getGameId() {
        return GameId;
    }

    public int getUsersId() {
        return UsersId;
    }

    public void setGameId(int gameId) {
        this.GameId = gameId;
    }

    public void setUsersId(int usersId) {
        this.UsersId = usersId;
    }

    @Override
    public String toString() {
        return "OwnershipEntity{" +
                "GameId=" + GameId +
                ", UsersId=" + UsersId +
                '}';
    }
}

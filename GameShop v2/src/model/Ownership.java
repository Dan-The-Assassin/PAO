package model;

public class Ownership {
    protected int GameId;
    protected int UsersId;

    public Ownership(int GameId, int UsersId)
    {
        this.GameId=GameId;
        this.UsersId=UsersId;
    }

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
        return "Ownership{" +
                "GameId=" + GameId +
                ", UsersId=" + UsersId +
                '}';
    }
}

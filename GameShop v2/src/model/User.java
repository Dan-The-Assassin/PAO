package model;

public class User {

    private int id;
    private String name;
    private String password;
    private static int currentid=0;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password=password;
    }

    public static int getCurrentid() {
        return currentid;
    }

    public static void setCurrentid(int currentid) {
        User.currentid = currentid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        /*return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';*/
        return id + ") " +
                name + " with password: " + password;
    }
}

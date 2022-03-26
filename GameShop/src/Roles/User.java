package Roles;

public class User extends Role{
    protected static int usercount=0;

    public User(String username, String password){
        this.username=username;
        this.password=password;
        this.id=usercount++;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }
}

package Roles;

import Games.Game;

import java.util.Vector;

public class Admin extends Role{
    protected static int admincount=0;

    public Admin(String username, String password){
        this.username=username;
        this.password=password;
        this.id=admincount++;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public void setPassword(String password){
        this.password=password;
    }
}

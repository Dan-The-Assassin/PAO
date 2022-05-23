package service;

import model.Game;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //GameService.addGame(new Game(5,"Jocul Jocurilor",15.5, 1.4,9.5,PublisherService.getById(2), DeveloperService.getById(1), BundleService.getById(2)));
        //GameService.addGame(new Game(1,"Leo","5678"));
        //GameService.UpdateGame(4);
        //GameService.DeleteGame(5);
        //System.out.println(GameService.getAllGames());
        boolean exit=false;
        String page="l";
        Scanner input=new Scanner(System.in);
        String command="";
        String type = "u"; //u - user, a - admin
        boolean switching = false; //for switching page so that old input won't be used
        while(!exit)
        {
            switch(page)
            {
                case "l":
                    //LOGIN
                    System.out.println("Write username");
                    String name = input.nextLine();
                    System.out.println("Write password");
                    String pass = input.nextLine();
                    if(UserService.Login(name, pass))
                    {
                        System.out.println("Conectarea s-a realizat, apasati orice pentru a continua");
                        page="c";
                        switching=true;
                    }
                    else
                    {
                        if(AdminService.Login(name, pass))
                        {
                            System.out.println("Conectarea s-a realizat, apasati orice pentru a continua");
                            page="c";
                            type="a";
                            switching=true;
                        }
                        else {
                            System.out.println("Nume sau parola gresita, incercati iar");
                        }
                    }
                    break;
            }
            command=input.nextLine();
            if(command.equals("x"))
            {
                exit=true;
            }
        }
    }
}
import Companies.Developer;
import Companies.Publisher;
import Functionality.Menu;
import Functionality.ShopService;
import Games.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ShopService s = new ShopService();
        Scanner input=new Scanner(System.in);

        //Adds devs and publishers
        s.AddDeveloper("Developer");
        s.AddPublisher("Publisher");
        s.AddPublisher("Alt Publisher");
        s.AddDeveloper("Dezvoltator");

        //Adds games
        s.AddGame("Jocul",100,13.99f,"Publisher","Dezvoltator");
        s.AddGame("Jocul2", 200, 14.99f,"Publisher","Dezvoltator");
        s.AddGame("Jocul3",50,4.55f,"Alt Publisher","Developer");
        s.GetGames().get(0).setRating(1.5f);
        s.GetGames().get(1).setRating(10f);
        s.GetGames().get(2).setRating(4.6f);

        //Adds bundle
        s.Add_Bundle("Jocul si Jocul2",20);
        s.GetBundles().get(0).addGame(s.GetGames().get(0));
        s.GetBundles().get(0).addGame(s.GetGames().get(1));
        s.Add_Bundle("Another Bundle",20);
        s.GetBundles().get(1).addGame(s.GetGames().get(1));
        s.GetBundles().get(1).addGame(s.GetGames().get(2));

        //Adds users
        s.Add_User("Daniel","abcd");
        s.Add_User("User","1234");

       // Game a = new Game("Jocul",100,13.99f,noname,none);
       // Game b = new Game("Jocul",50,14.99f,noname,none);
       // Game b = new Game("Jocul2", 200, 14.99f,noname,none);
       // System.out.println( s.GetDevelopers().get(0).getName());

        int cpage=0;
        boolean exit=false;
        String sinput="default";

        /*s.Add_User("EpicGamer","abcd");
        s.Add_User("John","1234");

        s.Update_User();
        System.out.println(s.GetUsers().get(0).getName());
        System.out.println(s.GetUsers().get(0).getPassword());*/
        //s.Update_Game();
       // s.GetDevelopers().get(0).Update_Developer();
        //s.Update_Developer();
        //System.out.println(s.GetGames().get(2).getDeveloper());
        //System.out.println(s.GetDevelopers().get(0).getName());

        //s.sort_games();
        //s.Print_All_Games();
        //s.GetGames().get(0).printInfo();
        Object[][] array;
        Menu m = new Menu(s);
        while(!exit){
            if(sinput.matches("-?\\d+")){
                cpage++;
            }
            m.setCpage(cpage);
            //Print/Visual
            m.print_cpage(s);
            if(sinput.matches("-?\\d+")){
                m.execute(s,sinput);
            }
            sinput=input.nextLine();
            m.execute(s,sinput);
                switch(cpage)
                {
                    case 0:                   //CODE FOR LOGIN/REGISTER SCREEN
                    switch(sinput) {
                        case "R":
                            s.Add_New_User();
                            cpage=1;
                            break;
                        case "L":
                            cpage=1;
                            break;
                        case "X":
                            exit = true;
                            break;
                    }
                    break;
                    case 1:
                        switch (sinput) {
                            case "X":
                                cpage = 0;
                                break;
                            case "III":
                                cpage=3;
                                break;
                            case "V":
                                cpage=5;
                                break;
                        }
                    break;
                    case 2:
                        switch(sinput){
                            case "X":
                                cpage=1;
                                break;
                        }
                        break;
                    case 3:
                        switch(sinput){
                            case "X":
                                cpage=0;
                                break;
                            case "I":
                                cpage=1;
                                break;
                            case "V":
                                cpage=5;
                                break;
                        }
                        break;
                    case 4:
                        switch(sinput){
                            case "X":
                                cpage=3;
                                break;
                        }
                        break;
                    case 5:
                        switch(sinput){
                            case "X":
                                cpage=0;
                                break;
                            case "III":
                                cpage=3;
                                break;
                            case "I":
                                cpage=1;
                                break;
                        }
                        break;
                }
        }
        //System.out.println(m.array_collection[1][0]);  -prints option itself
        //                                     [][1] -prints the type the setting is
        //                                     [][2] -prints the function used and [][3] for parameters if any or for array in shift
    }
}

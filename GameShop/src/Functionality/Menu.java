package Functionality;

import java.util.Vector;

public class Menu {
    protected enum setting{
        function_runner, //for most things
        input,   //for login
        page_transfer, //for changing menu page
        shift, //change setting as member of a vector
        print,
    }

    protected int cpage; //current page from array of pages //0 - login, 1 - shop, 2-game info, 3 - bundles, 4 - bundles info, 5 - admin

    public boolean login_check(String username, String password){
        //nu este implementat
        this.cpage=1;
        return true;
    }

    public boolean register_account(String username, String password){
        //nu este implementat
        this.cpage=1;
        return true;
    }

    //NOT FUNCTIONAL, skips directly to next page whatever you pick
    protected Object[][] array_login= {
            {"L. Login", setting.input, "login_check"},      //Menu text that will be shown : Login : , action will be : inputting, it will then execute function : login_check
            {"R. Register", setting.input, "register_account"},
            {"X. Exit", setting.function_runner, "exit"}
    };

    protected String[] array_sort= {"Date ascending","Rating ascending","Price ascending", "Date descending", "Rating descending", "Price descending"};

    protected Object[][] array_shop= {
            {"<>. Sort by : ", setting.shift, "sort_games", 0, array_sort},  //setting shifts the selected element of the array, default is 0 - "Date ascending", checks in array "array_sort"
            {"All games : ", setting.print, "print_games"},
            {"+. Add game", setting.function_runner, "add_game"},
            {"=. Update Game", setting.function_runner, "update_game"},
            {"III. Go to bundles page", setting.page_transfer, 3},
            {"V. Go to admin page", setting.page_transfer, 5},
            {"X. Go to login page", setting.page_transfer, 0},
    };

    protected Object[][] array_game={
            {"X. Go to games page", setting.page_transfer, 1},
            {"Game Info : ", setting.function_runner, "print_game_info"},
    };

    protected Object[][] array_bundles={
            {"All bundles :", setting.print, "print_bundles"},
            {"-. Delete Bundle", setting.function_runner, "delete_bundle"},
            {"=. Update Bundle", setting.function_runner, "update_bundle"},
            {"I. Go to games page", setting.page_transfer, 1},
            {"V. Go to admin page", setting.page_transfer, 5},
            {"X. Go to login page", setting.page_transfer, 0},
    };

    protected Object[][] array_bundle={
            {"X. Go to bundles page", setting.page_transfer, 3},
            {"Bundle info : ", setting.function_runner, "print_bundle_info"},
    };

    protected Object[][] array_admin= {
            {"+d. Add Developer", setting.function_runner, "add_developer"},
            {"+p. Add Publisher", setting.function_runner, "add_publisher"},
            {"=d. Update Developer", setting.function_runner, "update_developer"},
            {"=p. Update Publisher", setting.function_runner, "update_publisher"},
            {"=u. Update User", setting.function_runner, "update_user"},
            {"-u. Delete User", setting.function_runner, "delete_user"},
            {"=g. Rate Game", setting.function_runner, "rate_game"},
            {"I. Go to games page", setting.page_transfer, 1},
            {"III. Go to bundles page", setting.page_transfer, 3},
            {"X. Go to login page", setting.page_transfer, 0},
    };

    protected Vector<Object[][]> arrays;

    public Menu(ShopService s){
        this.arrays=new Vector<>();
        this.arrays.add(array_login);
        this.arrays.add(array_shop);
        this.arrays.add(array_game);
        this.arrays.add(array_bundles);
        this.arrays.add(array_bundle);
        this.arrays.add(array_admin);
        this.cpage=0;
        s.sort_games((int)array_shop[0][3]);
    }

    public void setCpage(int cpage){
        this.cpage=cpage;
    }

    public void execute(ShopService s, String sinput){
        for(int i=0;i<arrays.get(cpage).length;i++) {
            //if type of option inputted is shift, do shifting
            if((arrays.get(cpage))[i][1].equals(setting.shift)){
                if(arrays.get(cpage)[i][2].equals("sort_games")){
                    int a= (int)array_shop[0][3];
                    if(sinput.equals(">") && a<array_sort.length-1) {
                        array_shop[0][3] =(int)array_shop[0][3]+1;
                    }
                    if(sinput.equals("<") && a>0) {
                        array_shop[0][3]=(int)array_shop[0][3]-1;
                    }
                    s.sort_games((int)array_shop[0][3]);
                }
            }
            //if type of option inputted is function, do function
            if((arrays.get(cpage))[i][1].equals(setting.function_runner)){
                if(arrays.get(cpage)[i][2].equals("print_game_info") && sinput.matches("-?\\d+")){
                    int a=Integer.parseInt(sinput);
                    s.games.get(a).printInfo();
                }
                if(arrays.get(cpage)[i][2].equals("print_bundle_info") && sinput.matches("-?\\d+")){
                    int a=Integer.parseInt(sinput);
                    s.bundles.get(a).printInfo();
                }
                if(arrays.get(cpage)[i][2].equals("add_game") && sinput.equals("+")){
                    s.Add_New_Game();
                    s.sort_games((int)array_shop[0][3]);
                }
                if(arrays.get(cpage)[i][2].equals("update_game") && sinput.equals("=")){
                    s.Update_Game();
                }
                if(arrays.get(cpage)[i][2].equals("update_bundle") && sinput.equals("=")){
                    s.Update_Bundle();
                }
                if(arrays.get(cpage)[i][2].equals("delete_bundle") && sinput.equals("-")){
                    s.Delete_Bundle();
                }
                if(arrays.get(cpage)[i][2].equals("delete_user") && sinput.equals("-u")){
                    s.Delete_User();
                }
                if(arrays.get(cpage)[i][2].equals("update_user") && sinput.equals("=u")){
                    s.Update_User();
                }
                if(arrays.get(cpage)[i][2].equals("update_publisher") && sinput.equals("=p")){
                    s.Update_Publisher();
                }
                if(arrays.get(cpage)[i][2].equals("update_developer") && sinput.equals("=d")){
                    s.Update_Developer();
                }
                if(arrays.get(cpage)[i][2].equals("add_publisher") && sinput.equals("+p")){
                    s.Add_New_Publisher();
                }
                if(arrays.get(cpage)[i][2].equals("add_developer") && sinput.equals("+d")){
                    s.Add_New_Developer();
                }
            }
        }
    }

    public void print_cpage(ShopService s){
        for(int i=0;i<arrays.get(cpage).length;i++){
            //if type of option is print, print stuff
            if((arrays.get(cpage))[i][1].equals(setting.print)){
                System.out.println((arrays.get(cpage))[i][0]);
                if(arrays.get(cpage)[i][2].equals("print_games"))
                s.Print_All_Games();
                if(arrays.get(cpage)[i][2].equals("print_bundles"))
                    s.Print_Bundles();
            }

            //if type is shift, show current option selected
            if((arrays.get(cpage))[i][1].equals(setting.shift)){
                System.out.println((arrays.get(cpage))[i][0]);
                if(arrays.get(cpage)[i][2].equals("sort_games")){
                    String[] a = (String[])arrays.get(cpage)[i][4];
                    int b=(int)arrays.get(cpage)[i][3];
                    System.out.println(a[b]);
                }
            }
            if((arrays.get(cpage))[i][1].equals(setting.function_runner)) {
                System.out.println((arrays.get(cpage))[i][0]);
            }
            if((arrays.get(cpage))[i][1].equals(setting.page_transfer)) {
                System.out.println((arrays.get(cpage))[i][0]);
            }
            if((arrays.get(cpage))[i][1].equals(setting.input)) {
                System.out.println((arrays.get(cpage))[i][0]);
            }
        }
    }

}

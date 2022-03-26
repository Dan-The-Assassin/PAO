package Functionality;

import Companies.Developer;
import Companies.Publisher;
import Games.Bundle;
import Games.Game;
import Roles.Admin;
import Roles.User;

import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class ShopService {

    protected Vector<Game> games;
    protected Vector<Publisher> publishers;
    protected Vector<Developer> developers;
    protected Vector<Bundle> bundles;
    protected Vector<User> users;
    protected Vector<Admin> admins;

    public Vector<Game> GetGames(){
        return this.games;
    }

    public Vector<Publisher> GetPublishers(){
        return this.publishers;
    }

    public Vector<Developer> GetDevelopers(){
        return this.developers;
    }

    public Vector<Bundle> GetBundles(){
        return this.bundles;
    }

    public Vector<User> GetUsers(){
        return this.users;
    }

    public Vector<Admin> GetAdmins(){
        return this.admins;
    }

    public void Add_User(String username, String password){
        User u = new User(username,password);
        this.users.add(u);
    }

    public void Add_New_Publisher(){
        System.out.println("Type in the name: ");
        Scanner s= new Scanner(System.in);
        String name = s.nextLine();
        int a=-1;
        boolean OK2=true;
        for(int i=0;i<publishers.size();i++){
            if(publishers.get(i).getName().equals(name)){
                OK2=false;
            }
        }
        if(OK2){
            Publisher p = new Publisher(name);
            publishers.add(p);
        }
        if(!OK2){
            System.out.println("Name already taken. Try again");
            Add_New_Publisher();
        }
    }

    public void Add_New_Developer(){
        System.out.println("Type in the name: ");
        Scanner s= new Scanner(System.in);
        String name = s.nextLine();
        int a=-1;
        boolean OK2=true;
        for(int i=0;i<developers.size();i++){
            if(developers.get(i).getName().equals(name)){
                OK2=false;
            }
        }
        if(OK2){
            Developer d = new Developer(name);
            developers.add(d);
        }
        if(!OK2){
            System.out.println("Name already taken. Try again");
            Add_New_Developer();
        }
    }

    public void Add_New_User(){
        String username;
        String password;
        Scanner s=new Scanner(System.in);
        System.out.println("Type username : ");
        username=s.nextLine();
        boolean OK=true;
        for(int i=0;i<this.users.size();i++)
        {
            if(this.users.get(i).getName().equals(username))
            {
                OK=false;
            }
        }

        if(!OK){
            System.out.println("There's already a user with this name. Try again");
            Add_New_User();
        }

        System.out.println("Type password : ");
        password=s.nextLine();
        User u = new User(username,password);
        this.users.add(u);
    }

    public void Add_New_Game(){
        String title;
        Scanner s=new Scanner(System.in);
        System.out.println("Type title : ");
        title = s.nextLine();
        boolean OK=true;
        for(int i=0;i<this.games.size();i++)
        {
            if(this.games.get(i).getName().equals(title))
            {
                OK=false;
            }
        }

        if(!OK){
            System.out.println("There's already a game with this name");
            return;
        }

       System.out.println("Type size : ");
        int size= s.nextInt();
            s.nextLine();

        System.out.println("Type price : ");
        float price= s.nextFloat();
        s.nextLine();

        System.out.println("Type publisher name : ");
        String name= s.nextLine();
        Publisher p=null;
        OK=false;
        for(int i=0;i<publishers.size();i++)
        {
            if(publishers.get(i).getName().equals(name)){
                OK=true;
                p=publishers.get(i);
            }
        }
        if(!OK) {
            System.out.println("Publisher doesn't exist");
            return;
        }


            System.out.println("Type new developer name : ");
            name= s.nextLine();
            OK=false;
            Developer d=null;
            for(int i=0;i<developers.size();i++)
            {
                if(developers.get(i).getName().equals(name)){
                    OK=true;
                    d=developers.get(i);
                }
            }
            if(!OK) {
                System.out.println("Developer doesn't exist");
            }
            Game g = new Game(title,size,price,p,d);
            this.games.add(g);
    }

    public void Delete_User(){
        System.out.println("Type id of user to delete : ");
        Scanner s = new Scanner(System.in);
        int input=s.nextInt();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getId()==input){
                users.remove(i);
            }
        }
    }

    public void Add_Bundle(String title, int discount){
        Bundle b = new Bundle(title,discount);
        this.bundles.add(b);
    }

    public void Delete_Bundle(){
        System.out.println("Type id of bundle to delete : ");
        Scanner s = new Scanner(System.in);
        int input=s.nextInt();
        for(int i=0;i<bundles.size();i++)
        {
            if(bundles.get(i).getId()==input){
                bundles.remove(i);
            }
        }
    }

    public void Print_Bundles(){
        for(int i=0;i< bundles.size();i++){
            System.out.println(i + ". " + bundles.get(i).getName());
        }
    }

    public void Update_Bundle(){
        Scanner s=new Scanner(System.in);
        int intput;
        boolean OK=false;
        System.out.println("Type id of bundle to change");
        intput=s.nextInt();
        s.nextLine();
        for(int i=0;i<bundles.size();i++)
        {
            if(bundles.get(i).getId()==intput){
                OK=true;
            }
        }
        if(!OK)
        {
            System.out.println("Bundle of this id doesn't exist");
            return;
        }

        String sinput;
        System.out.println("Change title? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new title : ");
            sinput = s.nextLine();
            for(int i=0;i<bundles.size();i++)
            {
                if(bundles.get(i).getName().equals(sinput)&&i!=intput){
                    OK=false;
                }
            }
            if(OK){
                bundles.get(intput).setTitle(sinput);
            }
            else
            {
                System.out.println("There's already a bundle with this title");
                this.Update_Bundle();
                return;
            }
        }
        System.out.println("Change discount? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new discount");
            int input = s.nextInt();
            s.nextLine();
            bundles.get(intput).setDiscount(input);
        }
    }

    public void Update_User(){
        Scanner s=new Scanner(System.in);
        int intput;
        boolean OK=false;
        System.out.println("Type id of user to change");
        intput=s.nextInt();
        s.nextLine();
        for(int i=0;i<users.size();i++)
        {
            if(users.get(i).getId()==intput){
                OK=true;
            }
        }
        if(!OK)
        {
            System.out.println("User of this id doesn't exist");
            return;
        }

        String sinput;
        System.out.println("Change username? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new username : ");
            sinput = s.nextLine();
            for(int i=0;i<users.size();i++)
            {
                if(users.get(i).getName().equals(sinput)&&i!=intput){
                    OK=false;
                }
            }
            if(OK){
                users.get(intput).setUsername(sinput);
            }
            else
            {
                System.out.println("There's already a user with this name");
                this.Update_User();
                return;
            }
        }

        System.out.println("Change password? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new password : ");
            sinput = s.nextLine();
            users.get(intput).setPassword(sinput);
        }

    }

    public void Update_Game(){
        Scanner s=new Scanner(System.in);
        int intput;
        boolean OK=false;
        System.out.println("Type id of game to change");
        intput=s.nextInt();
        for(int i=0;i<games.size();i++)
        {
            if(games.get(i).getId()==intput){
                OK=true;
            }
        }
        if(!OK)
        {
            System.out.println("Game of this id doesn't exist");
            return;
        }
        s.nextLine();
        String sinput;
        System.out.println("Change title? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y"))
        {
            System.out.println("Type new title : ");
            sinput = s.nextLine();
            for(int i=0;i<this.games.size();i++)
            {
                if(this.games.get(i).getName().equals(sinput) && this.games.get(i).getId()!=intput)
                {
                    OK=false;
                }
            }
            if(OK)
                this.games.get(intput).setTitle(sinput);
            else {
                System.out.println("There's already a game with this name");
                return;
            }

        }
        System.out.println("Change size? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new size : ");
            int size= s.nextInt();
            s.nextLine();
            this.games.get(intput).setSize(size);
        }
        System.out.println("Change price? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new price : ");
            float price= s.nextFloat();
            s.nextLine();
            this.games.get(intput).setPrice(price);
        }
        System.out.println("Change rating? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new rating : ");
            float rating= s.nextFloat();
            s.nextLine();
            this.games.get(intput).setRating(rating);
        }
        System.out.println("Change publisher? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new publisher name : ");
            String name= s.nextLine();
            OK=false;
            for(int i=0;i<publishers.size();i++)
            {
                if(publishers.get(i).getName().equals(name)){
                    OK=true;
                    this.games.get(intput).setPub(publishers.get(i));
                }
            }
            if(!OK) {
                System.out.println("Publisher doesn't exist");
                return;
            }
        }

        System.out.println("Change developer? Y/N");
        sinput = s.nextLine();
        if(sinput.equals("Y")){
            System.out.println("Type new developer name : ");
            String name= s.nextLine();
            OK=false;
            for(int i=0;i<developers.size();i++)
            {
                if(developers.get(i).getName().equals(name)){
                    OK=true;
                    this.games.get(intput).setDev(developers.get(i));
                }
            }
            if(!OK) {
                System.out.println("Developer doesn't exist");
            }
        }
    }

    public void Update_Publisher(){
        Scanner s=new Scanner(System.in);
        System.out.println("Type in the id of the publisher to update");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("Type in the new name to change it to : ");
        String name = s.nextLine();
        int a=-1;
        boolean OK=false;
        boolean OK2=true;
        for(int i=0;i<publishers.size();i++){
            if(publishers.get(i).getId()==id){
              a=i;  OK=true;
            }
            if(publishers.get(i).getName().equals(name) && a!=i){
                OK2=false;
            }
        }
        if(OK && OK2){
            publishers.get(a).setName(name);
        }
        if(!OK){
            System.out.println("No publisher with this id");
        }
        if(!OK2){
            System.out.println("Name already taken. Try again");
            Update_Publisher();
        }
    }

    public void sort_games(int way){
        //Scanner s = new Scanner(System.in);
        //System.out.println("What type of sorting do you want?");
        //String way=s.nextLine();
        /*if(!games.isEmpty()) {
            switch (way) {
                case "ascending rating":
                    games.get(0).setSort(2);
                    break;
                case "ascending price":
                    games.get(0).setSort(1);
                    break;
                case "ascending date":
                    games.get(0).setSort(0);
                    break;
                case "descending rating":
                    games.get(0).setSort(5);
                    break;
                case "descending price":
                    games.get(0).setSort(4);
                    break;
                case "descending date":
                    games.get(0).setSort(3);
                    break;
                default:
                    System.out.println("This method of sorting doesn't exist");
                    break;
            }
            Collections.sort(games);
        }*/
        if(!games.isEmpty()) {
            games.get(0).setSort(way);
            Collections.sort(games);
        }
    }

    public void Update_Developer(){
        Scanner s=new Scanner(System.in);
        System.out.println("Type in the id of the developer to update");
        int id = s.nextInt();
        s.nextLine();
        System.out.println("Type in the new name to change it to : ");
        String name = s.nextLine();
        int a=-1;
        boolean OK=false;
        boolean OK2=true;
        for(int i=0;i<developers.size();i++){
            if(developers.get(i).getId()==id){
                a=i;  OK=true;
            }
            if(developers.get(i).getName().equals(name) && a!=i){
                OK2=false;
            }
        }
        if(OK && OK2){
            developers.get(a).setName(name);
        }
        if(!OK){
            System.out.println("No developer with this id");
        }
        if(!OK2){
            System.out.println("Name already taken. Try again");
            Update_Developer();
        }
    }


    public ShopService(){
        this.games= new Vector<>();
        this.publishers= new Vector<>();
        this.developers= new Vector<>();
        this.bundles= new Vector<>();
        this.users=new Vector<>();
        this.admins=new Vector<>();
    }

    public void Print_All_Games() {

        for (int i = 0; i < games.size(); i++){
            System.out.println(i + ". " + games.get(i).getName());
        }
    }

    /*public void Delete_Game(){
        String title;
        System.out.println("Type title of game to delete : ");
        Scanner s=new Scanner(System.in);
        title=s.nextLine();
        boolean OK=false;
        for (int i = 0; i < this.games.size(); i++)
        {
            if(this.games.get(i).getName().equals(title))
            {
                OK=true;
                this.games.remove(i);
                break;
            }
        }
        //DELETE GAME FROM BUNDLES
        for (int i = 0; i < this.bundles.size(); i++)
        {
            for(int j=0;j<this.bundles.get(i).getGames().size();j++) {
                if (this.bundles.get(i).getGames().get(j).getName().equals(title)) {
                    this.games.remove(i);
                    break;
                }
            }
        }
        if(!OK)
            System.out.println("Game not found");
    }*/

    /*public void Delete_Publisher(String name){
        boolean OK=false;
        int a=0;
        for (int i = 0; i < this.publishers.size(); i++)
        {
            if(this.publishers.get(i).getName().equals(name))
            {
                OK=true;
                a=i;
                break;
            }
        }

        if(!OK)
            System.out.println("Publisher not found");
        else {                //DELETE ANY GAMES THE PUBLISHER IS RELATED TO
            for (int i = 0; i < this.games.size(); i++)
            {
                if(this.games.get(i).getPublisher().equals(name))
                {
                    this.games.remove(i);
                    i--;
                }
            }
            this.publishers.remove(a);
        }
    }*/

    /*public void Delete_Developer(String name){
        boolean OK=false;
        int a=0;
        for (int i = 0; i < this.developers.size(); i++)
        {
            if(this.developers.get(i).getName().equals(name))
            {
                OK=true;
                a=i;
                break;
            }
        }

        if(!OK)
            System.out.println("Developer not found");
        else {                //DELETE ANY GAMES THE DEVELOPER IS RELATED TO
            for (int i = 0; i < this.games.size(); i++)
            {
                if(this.games.get(i).getDeveloper().equals(name))
                {
                    this.games.remove(i);
                    i--;
                }
            }
            this.developers.remove(a);
        }
    }*/

    public void Print_Owned_Games(){

        for(int i=0;i<games.size();i++){
            if(games.get(i).check_ownership()){
                System.out.println(games.get(i).getName());
            }
        }
    }

    public void AddPublisher(String name){
        Publisher p = new Publisher(name);
        this.publishers.add(p);
    }

    public void AddDeveloper(String name){
        Developer d = new Developer(name);
        this.developers.add(d);
    }

    public void AddGame(String title, int size, float price, String pub, String dev) {
        boolean OK=false;
        Publisher p=null;

        //Check if publisher name given exists, if not create it
        for (int i = 0; i < this.publishers.size(); i++)
        {
            if(this.publishers.get(i).getName().equals(pub))
            {
                OK=true;
                p=this.publishers.get(i);
                break;
            }
        }
        if(!OK)
        {
            System.out.println("Can't add game, publisher doesn't exist");
            return;
            //this.AddPublisher(pub);
            //p=this.publishers.lastElement();
        }

        //Check the same but for developer
        Developer d=null;
        OK=false;
        for (int i = 0; i < this.developers.size(); i++)
        {
            if(this.developers.get(i).getName().equals(dev))
            {
                OK=true;
                d=this.developers.get(i);
                break;
            }
        }
        if(!OK)
        {
            System.out.println("Can't add game, developer doesn't exist");
            return;
            //this.AddDeveloper(dev);
            //d=this.developers.lastElement();
        }

        Game g = new Game(title,size,price,p,d);
        p.AddEntry(g);
        d.AddEntry(g);
        for(int i=0;i<this.games.size();i++)
        {
            if(this.games.get(i).getName().equals(title))
            {
                OK=false;
            }
        }
        if(OK)
            this.games.add(g);
        else
            System.out.println("There's already a game with this name");
    }
}

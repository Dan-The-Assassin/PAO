package Games;

import Companies.Developer;
import Companies.Publisher;
import Functionality.Structure;

public class Game implements Structure, Comparable {
    protected String title;
    protected int size;
    protected float price;
    protected float rating; //rating given by admins
    protected Publisher pub;
    protected Developer dev;
    protected int id;
    protected static int gamecount=0;
    protected boolean owned;
    protected static int sort=0; // 0 - by date, 1 - by price, 2 - by rating (ascending order), 3 - by date, 4 - by price, 5 - by rating (descending order)

    public Game(String title, int size, float price, Publisher pub, Developer dev){
        this.rating=-1;
        this.title=title;
        this.size=size;
        this.price=price;
        this.pub=pub;
        this.dev=dev;
        this.id=gamecount++;
        this.owned=false;
    }

    public void setRating(float rating){

        this.rating=rating;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setSize(int size){
        this.size=size;
    }

    public void setPrice(float price){
        this.price=price;
    }

    public void setPub(Publisher pub){
        this.pub=pub;
    }

    public void setDev(Developer dev){
        this.dev=dev;
    }

    public void setSort(int i){
        sort=i;
    }

    @Override
    public int compareTo(Object o) {
        Game game = (Game) o;
        switch(this.sort){
            case 0: return Integer.compare(this.id, game.id);
            case 1: return Float.compare(this.price, game.price);
            case 2: return Float.compare(this.rating, game.rating);
            case 3: return Integer.compare(game.id,this.id);
            case 4: return Float.compare(game.price,this.price);
            case 5: return Float.compare(game.rating,this.rating);
            default : return 0;
        }
    }

    public boolean check_ownership(){
        return this.owned;
    }

    public void buy(){
        this.owned=true;
    }

    public String getPublisher(){
        return this.pub.getName();
    }

    public String getDeveloper(){
        return this.dev.getName();
    }

    @Override
    public String getName() {

        return this.title;
    }

    public float getPrice(){
        return this.price;
    }

    @Override
    public void printInfo() {
        System.out.println("Title : " + this.title);
        System.out.println("Price : " + this.price);
        if(this.rating==-1) {
            System.out.println("Rating : not rated yet");
        }
        else {
            System.out.println("Rating : " + this.rating);
        }
        System.out.println("Developed by : " + this.dev.getName());
        System.out.println("Published by : " + this.pub.getName());
        System.out.println("Disk space required : " + this.size + "GB");
        System.out.println("Id : " +this.id);
    }

    @Override
    public int getId() {
        return this.id;
    }
}

package model;

public class Game {
    protected int id;
    protected String name;
    protected double size;
    protected double price;
    protected double rating; //rating given by admins
    protected Publisher pub;
    protected Developer dev;
    protected Bundle bundle;
    //protected static int gamecount=0;
    //protected boolean owned;
    //protected static String sort = ">d"; // >d - by date, >p - by price, >r - by rating (ascending order), <d - by date, <p - by price, <r - by rating (descending order)

    public Game(int id, String name, double size, double price, double rating, Publisher pub, Developer dev, Bundle bundle)
    {
        this.id=id;
        this.name=name;
        this.size=size;
        this.price=price;
        this.rating=rating;
        this.pub=pub;
        this.dev=dev;
        this.bundle=bundle;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void setDev(Developer dev) {
        this.dev = dev;
    }

    public void setPub(Publisher pub) {
        this.pub = pub;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public Bundle getBundle() {
        return bundle;
    }

    public Developer getDev() {
        return dev;
    }

    public double getSize() {
        return size;
    }

    public Publisher getPub() {
        return pub;
    }

    public String toString() {
        return id + ") " +
                name + System.lineSeparator() + "Price : " + price + System.lineSeparator() + "Size : " + size + System.lineSeparator() + "Rating : " + rating + System.lineSeparator() + "Made by : " + dev.getName() + System.lineSeparator() + "Published by : " + pub.getName() + System.lineSeparator() ;
    }
}

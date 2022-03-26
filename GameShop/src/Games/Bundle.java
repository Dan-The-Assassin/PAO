package Games;

import Functionality.Structure;

import java.util.*;
import java.io.*;

public class Bundle implements Structure {
    protected Vector<Game> game_list;
    protected float price;
    protected String title;
    protected int discount;
    protected int id;
    protected static int bundlecount=0;

    public Bundle(String title, int discount){
        //this.game_list=game_list;
        this.game_list=new Vector<>();
        this.title=title;
        this.discount=discount;
        this.price=0;
        for(int i=0;i<game_list.size();i++){
            this.price=this.price+game_list.get(i).getPrice();
        }
        this.price=this.price-this.price*discount/100;
        this.id=bundlecount++;
    }

    public void addGame(Game g){
        this.game_list.add(g);
        for(int i=0;i<game_list.size();i++){
            this.price=this.price+game_list.get(i).getPrice();
        }
        this.price=this.price-this.price*discount/100;
    }

    public void deleteGame(Game g){
        for(int i=0;i<game_list.size();i++){
            if(game_list.get(i).equals(g)){
                game_list.remove(i);
            }
        }
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setDiscount(int discount){
        this.discount=discount;
        for(int i=0;i<game_list.size();i++){
            this.price=this.price+game_list.get(i).getPrice();
        }
        this.price=this.price-this.price*discount/100;
    }

    @Override
    public String getName() {
        return this.title;
    }

    public Vector<Game> getGames() {
        return this.game_list;
    }

    @Override
    public void printInfo() {

        System.out.println("Title : " + this.title);
        System.out.println("Price : " + this.price);
        System.out.println("Games : ");
        for(int i=0;i<game_list.size();i++){
            System.out.println(i + ". " + game_list.get(i).getName());
        }
        System.out.println("Id : " +this.id);
    }

    @Override
    public int getId() {
        return 0;
    }
}

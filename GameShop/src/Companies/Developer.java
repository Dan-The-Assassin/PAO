package Companies;

import Functionality.Structure;
import Games.Game;

import java.util.Scanner;
import java.util.Vector;

public class Developer extends Company implements Structure {

    protected static int devcount=0;

    public Developer(String name){
        this.games = new Vector<Game>();
        this.name=name;
        this.gameNr=0;
        this.id=devcount++;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }

    @Override
    public void printInfo() {

    }

    @Override
    public int getId() {
        return this.id;
    }

    public void AddEntry(Game g){
        this.games.add(g);
        this.gameNr++;
    }
}

package Companies;

import Functionality.Structure;
import Games.Game;

import java.util.Scanner;
import java.util.Vector;

public class Publisher extends Company implements Structure {

    protected static int pubcount=0;

    public Publisher(String name){
        this.games = new Vector<Game>();
        this.name=name;
        this.gameNr=0;
        this.id=pubcount++;
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

    public void AddEntry(Game g)
    {
        this.games.add(g);
        this.gameNr++;
    }
}

package service;

import entity.GameEntity;
import entity.OwnershipEntity;
import model.Game;
import model.User;
import repository.GameRepository;
import repository.OwnershipRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameService {

    public static List<Game> getAllGames() {

        List<GameEntity> GameEntities = GameRepository.findAll();
        List<Game> result = new ArrayList<>();
        for (GameEntity GameEntity : GameEntities) {

            result.add(new Game(GameEntity.getId(), GameEntity.getName(), GameEntity.getSize(), GameEntity.getPrice(), GameEntity.getRating(), PublisherService.getById(GameEntity.getPublisher_id()), DeveloperService.getById(GameEntity.getDeveloper_id()), BundleService.getById(GameEntity.getBundle_id())));
        }
        return result;
    }

    public static List<Game> getAllOwned() {
        List<GameEntity> GameEntities = GameRepository.findAll();
        List<Game> result = new ArrayList<>();

        List<OwnershipEntity> OwnershipEntities = OwnershipRepository.findAll();
        for (GameEntity GameEntity : GameEntities) {
            for(OwnershipEntity OwnershipEntity : OwnershipEntities)
            {
                if(GameEntity.getId()==OwnershipEntity.getGameId() && User.getCurrentid() == OwnershipEntity.getUsersId())
                {
                    result.add(new Game(GameEntity.getId(), GameEntity.getName(), GameEntity.getSize(), GameEntity.getPrice(), GameEntity.getRating(), PublisherService.getById(GameEntity.getPublisher_id()), DeveloperService.getById(GameEntity.getDeveloper_id()), BundleService.getById(GameEntity.getBundle_id())));
                }
            }
        }
        return result;
    }

    public static Game getById(int id){
        List<Game> array = getAllGames();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new Game(-1,"",0,0,0,null,null,null);
    }

    public static Game getByName(String name){
        List<Game> array = getAllGames();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new Game(-1,"",0,0,0,null,null,null);
    }

    public static void addGame(Game Game) {
        Game result=getById(Game.getId());
        Game result1=getByName(Game.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            GameEntity GameEntity = new GameEntity();
            GameEntity.setName(Game.getName());
            GameEntity.setId(Game.getId());
            GameEntity.setPrice(Game.getPrice());
            GameEntity.setSize(Game.getSize());
            GameEntity.setRating(Game.getRating());
            GameEntity.setPublisher_id(Game.getPub().getId());
            GameEntity.setDeveloper_id(Game.getDev().getId());
            GameEntity.setBundle_id(Game.getBundle().getId());
            GameRepository.addGame(GameEntity);
        }
    }

    public static void UpdateGame(int Check) {

        Game result=getById((int)Check);
        if(result.getId()==-1)
        {
            System.out.println("Nu exista entitate care are acest id");
            return;
        }
        System.out.println("Scrieti pret nou");
        Scanner input = new Scanner(System.in);
        double newprice = input.nextDouble();
        System.out.println("Scrieti dimensiune noua");
        double newsize = input.nextDouble();
        System.out.println("Scrieti rating nou");
        double newrating = input.nextDouble();
        GameRepository.updateGame(Check, newprice,newsize,newrating);
    }

    public static void DeleteGame(int Check) {
        Game result=getById((int)Check);
        if(result.getId()==-1)
        {
            System.out.println("Nu exista entitate care are acest id");
            return;
        }
        GameRepository.deleteGame(Check);
    }
}

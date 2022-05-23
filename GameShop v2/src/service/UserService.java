package service;

import entity.OwnershipEntity;
import entity.UserEntity;
import model.Ownership;
import model.User;
import repository.OwnershipRepository;
import repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    public static List<User> getAllUsers() {

        List<UserEntity> UserEntities = UserRepository.findAll();
        List<User> result = new ArrayList<>();

        for (UserEntity UserEntity : UserEntities) {
            result.add(new User(UserEntity.getId(), UserEntity.getName(), UserEntity.getPassword()));
        }
        return result;
    }

    public static boolean Login(String username, String password) {
        User result = getByName(username);
        if(result.getId()==-1)
        {
            return false;
        }
        if(result.getPassword().equals(password))
        {
            User.setCurrentid(result.getId());
            return true;
        }
        return false;
    }

    public static User getById(int id){
        List<User> array = getAllUsers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new User(-1,"","");
    }

    public static User getByName(String name){
        List<User> array = getAllUsers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new User(-1,"","");
    }

    public static void addUser(User User) {
        User result=getById(User.getId());
        User result1=getByName(User.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            UserEntity UserEntity = new UserEntity();
            UserEntity.setName(User.getName());
            UserEntity.setPassword(User.getPassword());
            UserEntity.setId(User.getId());
            UserRepository.addUser(UserEntity);
        }
    }

    public static void UpdateUser(Object Check) {

        User result=null;
        if(Check instanceof Integer)
        {
            result = getById((int)Check);
        }
        if(Check instanceof String)
        {
            result = getByName((String)Check);
        }
        if(result!=null)
        {
            if(result.getId()==-1)
            {
                System.out.println("Nu exista entitate care are acest id sau nume");
                return;
            }
            System.out.println("Scrieti parola noua");
            Scanner input = new Scanner(System.in);
            String newpass=input.nextLine();
            UserRepository.updateUser(Check, newpass);
            return;
        }
        System.out.println("Tip de data gresit");
    }

    public static void DeleteUser(Object Check) {
        User result=null;
        if(Check instanceof Integer)
        {
            result = getById((int)Check);
        }
        if(Check instanceof String) {
            result = getByName((String) Check);
        }
        if(result!=null) {
            if (result.getId() == -1) {
                System.out.println("Nu exista entitate care are acest id");
                return;
            }
            UserRepository.deleteUser(Check);
            return;
        }
        System.out.println("Tip de data gresit");
    }

    public static void OwnGame(Object Check){
        //checks if game exists by name/id then "adds" it to user by creating an OwnershipEntity with this user id and that game id then adds it to database
        User result=null;
        if(Check instanceof Integer)
        {
            result = getById((int)Check);
        }
        if(Check instanceof String)
        {
            result = getByName((String) Check);
        }
        if(result!=null)
        {
            if (result.getId() == -1) {
                System.out.println("Nu exista entitate care are acest id");
                return;
            }
            OwnershipEntity OwnershipEntity = new OwnershipEntity();
            OwnershipEntity.setGameId(result.getId());
            OwnershipEntity.setUsersId(User.getCurrentid());
            OwnershipRepository.addOwnership(OwnershipEntity);
        }
        System.out.println("Tip de data gresit");
    }
}

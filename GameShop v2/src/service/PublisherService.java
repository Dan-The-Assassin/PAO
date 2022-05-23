package service;

import entity.PublisherEntity;
import model.Publisher;
import repository.PublisherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PublisherService {

    public static List<Publisher> getAllPublishers() {

        List<PublisherEntity> PublisherEntities = PublisherRepository.findAll();
        List<Publisher> result = new ArrayList<>();

        for (PublisherEntity PublisherEntity : PublisherEntities) {
            result.add(new Publisher(PublisherEntity.getId(), PublisherEntity.getName()));
        }
        return result;
    }

    public static Publisher getById(int id){
        List<Publisher> array = getAllPublishers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new Publisher(-1,"");
    }

    public static Publisher getByName(String name){
        List<Publisher> array = getAllPublishers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new Publisher(-1,"");
    }

    public static void addPublisher(Publisher Publisher) {
        Publisher result=getById(Publisher.getId());
        Publisher result1=getByName(Publisher.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            PublisherEntity PublisherEntity = new PublisherEntity();
            PublisherEntity.setName(Publisher.getName());
            PublisherEntity.setId(Publisher.getId());
            PublisherRepository.addPublisher(PublisherEntity);
        }
    }

    public static void UpdatePublisher(int Check) {

        Publisher result=getById((int)Check);
        if(result.getId()==-1)
        {
            System.out.println("Nu exista entitate care are acest id");
            return;
        }
        System.out.println("Scrieti nume nou");
        Scanner input = new Scanner(System.in);
        String newname=input.nextLine();
        PublisherRepository.updatePublisher(Check, newname);
    }

    public static void DeletePublisher(int Check) {
        Publisher result=getById((int)Check);
        if(result.getId()==-1)
        {
            System.out.println("Nu exista entitate care are acest id");
            return;
        }
        PublisherRepository.deletePublisher(Check);
    }
}

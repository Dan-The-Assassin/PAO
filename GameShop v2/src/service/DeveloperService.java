package service;

import entity.DeveloperEntity;
import model.Developer;
import repository.DeveloperRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperService {

    public static List<Developer> getAllDevelopers() {

        List<DeveloperEntity> DeveloperEntities = DeveloperRepository.findAll();
        List<Developer> result = new ArrayList<>();

        for (DeveloperEntity DeveloperEntity : DeveloperEntities) {
            result.add(new Developer(DeveloperEntity.getId(), DeveloperEntity.getName()));
        }
        return result;
    }

    public static Developer getById(int id){
        List<Developer> array = getAllDevelopers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new Developer(-1,"");
    }

    public static Developer getByName(String name){
        List<Developer> array = getAllDevelopers();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new Developer(-1,"");
    }

    public static void addDeveloper(Developer Developer) {
        Developer result=getById(Developer.getId());
        Developer result1=getByName(Developer.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            DeveloperEntity DeveloperEntity = new DeveloperEntity();
            DeveloperEntity.setName(Developer.getName());
            DeveloperEntity.setId(Developer.getId());
            DeveloperRepository.addDeveloper(DeveloperEntity);
        }
    }

    public static void UpdateDeveloper(int Check) {

        Developer result=getById((int)Check);
            if(result.getId()==-1)
            {
                System.out.println("Nu exista entitate care are acest id");
                return;
            }
            System.out.println("Scrieti nume nou");
            Scanner input = new Scanner(System.in);
            String newname=input.nextLine();
            DeveloperRepository.updateDeveloper(Check, newname);
    }

    public static void DeleteDeveloper(int Check) {
        Developer result=getById((int)Check);
        if(result.getId()==-1)
        {
            System.out.println("Nu exista entitate care are acest id");
            return;
        }
        DeveloperRepository.deleteDeveloper(Check);
    }

}

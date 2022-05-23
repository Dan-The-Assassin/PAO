package service;

import entity.BundleEntity;
import model.Bundle;
import repository.BundleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BundleService {

    public static List<Bundle> getAllBundles() {

        List<BundleEntity> BundleEntities = BundleRepository.findAll();
        List<Bundle> result = new ArrayList<>();

        for (BundleEntity BundleEntity : BundleEntities) {
            result.add(new Bundle(BundleEntity.getId(), BundleEntity.getName(), BundleEntity.getDiscount()));
        }
        return result;
    }

    public static Bundle getById(int id){
        List<Bundle> array = getAllBundles();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new Bundle(-1,"",0);
    }

    public static Bundle getByName(String name){
        List<Bundle> array = getAllBundles();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new Bundle(-1,"",0);
    }

    public static void addBundle(Bundle Bundle) {
        Bundle result=getById(Bundle.getId());
        Bundle result1=getByName(Bundle.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            BundleEntity BundleEntity = new BundleEntity();
            BundleEntity.setName(Bundle.getName());
            BundleEntity.setDiscount(Bundle.getDiscount());
            BundleEntity.setId(Bundle.getId());
            BundleRepository.addBundle(BundleEntity);
        }
    }

    public static void UpdateBundle(Object Check) {

        Bundle result=null;
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
            System.out.println("Scrieti discount nou");
            Scanner input = new Scanner(System.in);
            int newdiscount=input.nextInt();
            BundleRepository.updateBundle(Check, newdiscount);
            return;
        }
        System.out.println("Tip de data gresit");
    }

}

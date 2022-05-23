package service;

import entity.AdminEntity;
import model.Admin;
import repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {

    public static List<Admin> getAllAdmins() {

        List<AdminEntity> AdminEntities = AdminRepository.findAll();
        List<Admin> result = new ArrayList<>();

        for (AdminEntity AdminEntity : AdminEntities) {
            result.add(new Admin(AdminEntity.getId(), AdminEntity.getName(), AdminEntity.getPassword()));
        }
        return result;
    }

    public static Admin getById(int id){
        List<Admin> array = getAllAdmins();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getId()==id)
            {
                return array.get(i);
            }
        }

        return new Admin(-1,"","");
    }

    public static Admin getByName(String name){
        List<Admin> array = getAllAdmins();
        for(int i=0; i<array.size();i++)
        {
            if(array.get(i).getName().equals(name))
            {
                return array.get(i);
            }
        }

        return new Admin(-1,"","");
    }

    public static boolean Login(String adminname, String password) {
        Admin result = getByName(adminname);
        if(result.getId()==-1)
        {
            return false;
        }
        if(result.getPassword().equals(password))
        {
            return true;
        }
        return false;
    }

    public static void addAdmin(Admin Admin) {
        Admin result=getById(Admin.getId());
        Admin result1=getByName(Admin.getName());

        if(result.getId()!=-1 || result1.getId() != -1)
        {
            System.out.println("O entitate exista deja care are acelasi id sau nume");
        }
        else {
            AdminEntity AdminEntity = new AdminEntity();
            AdminEntity.setName(Admin.getName());
            AdminEntity.setPassword(Admin.getPassword());
            AdminEntity.setId(Admin.getId());
            AdminRepository.addAdmin(AdminEntity);
        }
    }

    public static void UpdateAdmin(Object Check) {

        Admin result=null;
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
            AdminRepository.updateAdmin(Check, newpass);
            return;
        }
        System.out.println("Tip de data gresit");
    }

    public static void DeleteAdmin(Object Check) {
        Admin result=null;
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
            AdminRepository.deleteAdmin(Check);
            return;
        }
        System.out.println("Tip de data gresit");
    }
}

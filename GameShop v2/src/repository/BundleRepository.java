package repository;

import entity.BundleEntity;
import mapper.BundleEntityMapper;
import service.DatabaseQueryExecutorService;

import java.util.ArrayList;
import java.util.List;

public class BundleRepository {

    public static List<BundleEntity> findAll(){

        List<Object> objects = DatabaseQueryExecutorService.executeReadQuery("select * from Bundle", new BundleEntityMapper());
        List<BundleEntity> result = new ArrayList<>();

        for (Object object : objects) {
            if(object instanceof BundleEntity){
                result.add((BundleEntity) object);
            } else {
                throw new RuntimeException("Expected BundleEntity instance");
            }
        }

        return result;
    }

    public static void addBundle(BundleEntity BundleEntity) {
        DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Bundle values(" + BundleEntity.getId() + ", '" + BundleEntity.getName() + "'," + BundleEntity.getDiscount() + ")");
        //DatabaseQueryExecutorService.executeUpdateQuery("INSERT into Bundles(name) values('" + BundleEntity.getName() + "')");
    }

    public static void updateBundle(Object Check, int newdiscount)
    {
        if(Check instanceof Integer)
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Bundle" + System.lineSeparator() + "SET DISCOUNT= '" + newdiscount + "'" + System.lineSeparator() + "WHERE ID=" + Check);
        }
        else
        {
            DatabaseQueryExecutorService.executeUpdateQuery("UPDATE Bundle" + System.lineSeparator() + "SET DISCOUNT= '" + newdiscount + "'" + System.lineSeparator() + "WHERE NAME='" + Check + "'");
        }
    }
}

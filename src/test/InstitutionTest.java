package test;

import entities.Institution;
import services.InstitutionService;

import java.util.List;
import java.util.UUID;

/**
 * Created by hotelkey on 3/9/17.
 */
public class InstitutionTest {


    public static void main(String[] args){
       testInsert();
//       testGetAll();
    }

    private static void testInsert(){
        Institution obj = new Institution();
        obj.setId(UUID.randomUUID().toString());
        obj.setName("UCK");
        obj.setAddress("hfyueweryuvf");
        obj.setEmail("hjhj@jkjk.dfvd");
        obj.setMob("32452354325");
        obj.setWebsite("www.ubt.com");
//        obj.setInstitutionType(new InstitutionType("3e08a8b4-0c45-4ef5-9def-e35e723f5097"));

        if (InstitutionService.insert(obj) > 0){
            System.out.println("Ok");
        }else {
            System.out.println("Grrrrrr.....");
        }
    }

    private static void testGetAll(){
        List<Institution> objs = InstitutionService.getAllLazy();
        for (Institution obj : objs) {
            System.out.println(obj);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Total: " + objs.size());

    }
}

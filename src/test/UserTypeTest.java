package test;
import entities.UserType;
import services.UserTypeService;

import java.util.List;
import java.util.UUID;
/**
 * Created by Admin on 3/4/2017.
 */
public class UserTypeTest {
    public static void main(String[] args){
       testInsert();
//        testUpdate();
//        testDelete();
//        testGetAll();
//        testGetById();
    }

    private static void testInsert(){
        UserType userType = new UserType();
        userType.setId(UUID.randomUUID().toString());
        userType.setName("Profesor");
        userType.setDescription("Profesor i Guh's Shype");

        if (UserTypeService.insert(userType) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }

    private static void testUpdate(){
        UserType userType = new UserType();
        userType.setId("");
        userType.setName("");
        userType.setDescription("");

        if (UserTypeService.update(userType) > 0) {

            System.out.println("Recordi u ndryshua me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu ndryshuar");
        }
    }

    private static void testDelete(){
        if (UserTypeService.delete("") > 0) {
            System.out.println("Rekordi u fshi me sukses");
        } else {
            System.out.println("Rekordi deshtoi te fshihet");
        }
    }

    private static void testGetAll(){
        List<UserType> userTypeList = UserTypeService.getAll();
        for (UserType userType : userTypeList) {
            System.out.println(userType);
            System.out.println("");
        }

    }

    private static void testGetById(){
        UserType userType = UserTypeService.getById("");
        System.out.println(userType);
    }
}


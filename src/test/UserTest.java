package test;

import entities.Gender;
import entities.User;
import entities.UserType;
import services.UserService;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 3/5/2017.
 */

public class UserTest {
    public static void main(String[] args){
//        testGetAll();
//        testInsert();

//        testUpdate();
//        testDelete();

        testGetById();
//        testGetAll();
    }


    private static void testInsert(){
        User user = new User();
 //       user.setId("a6f1aec8-4f33-422f-86dc-7a1df461bb97");
        user.setId(UUID.randomUUID().toString());
        user.setName("aaaaaaaa");
        user.setSurname("bbbbbbbb");
        user.setUsername("FSH");
        user.setPassword("fatos");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1989);
        c.set(Calendar.MONTH, 06);
        c.set(Calendar.DAY_OF_MONTH, 29);
        user.setBirthday(c.getTime());
        user.setGender(Gender.M);
        user.setAddress("PRRONI I NURIS");
        user.setEmail("fatosshahini@gmail.com");
        user.setMob("044299983");
        user.setUserType(new UserType("b497a0d1-035e-11e7-99bd-34e6d783f5f1", "", ""));


        if (UserService.insert(user) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }

    private static void testUpdate(){
        User user = new User();
        user.setId("e58b4a99-e47a-41c4-af89-7b3fe5a1f6c9");
        user.setName("Barok");
        user.setSurname("Ishag");
        user.setUsername("IshagBarok");
        user.setPassword("");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1985);
        c.set(Calendar.MONTH, 06);
        c.set(Calendar.DAY_OF_MONTH, 29);
        user.setBirthday(c.getTime());
        user.setGender(Gender.M);
        user.setAddress("FSHATI QKEMI");
        user.setEmail("princiIVajzave@mydirtylove.com");
        user.setMob("12Nalt23Posht");
        user.setUserType(new UserType("b497a0d1-035e-11e7-99bd-34e6d783f5f1", "", ""));

        if (UserService.update(user) > 0) {

            System.out.println("Recordi u ndryshua me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu ndryshuar");
        }
    }

    private static void testDelete(){
        if (UserService.delete("") > 0) {
            System.out.println("Rekordi u fshi me sukses");
        } else {
            System.out.println("Rekordi deshtoi te fshihet");
        }
    }

    private static void testGetAll(){
        List<User> userList = UserService.getAll(null);
        for (User user : userList) {
            System.out.println(user);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Total: " + userList.size());

    }

    private static void testGetById(){
        User user = UserService.getById("78712254-559b-44f5-b27b-106a54c60ab8");
        System.out.println(user);
    }
}


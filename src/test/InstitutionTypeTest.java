package test;

import entities.InstitutionType;
import services.InstitutionTypeService;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by hotelkey on 2/24/17.
 */
public class InstitutionTypeTest {
    public static void main(String[] args){
//        testInsert();
        testGetAll();
    }

    private static void testInsert(){
        InstitutionType institutionType = new InstitutionType();
        institutionType.setId(UUID.randomUUID().toString());
        institutionType.setName("FIEK");
        institutionType.setDepartment("Computer science");

        try {
            InstitutionTypeService.insert(institutionType);
            System.out.println("Recordi u insertu me sukses");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }

    private static void testUpdate(){
        InstitutionType institutionType = new InstitutionType();
        institutionType.setId("");
        institutionType.setName("FIEK");
        institutionType.setDepartment("Computer science 2");

        try {
            InstitutionTypeService.update(institutionType);
            System.out.println("Recordi u ndryshua me sukses");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Rekordi deshtoi per tu ndryshuar");
        }
    }

    private static void testDelete(){
        try {
            InstitutionTypeService.delete("");
            System.out.println("Rekordi u fshi me sukses");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Rekordi deshtoi te fshihet");
        }
    }

    private static void testGetAll(){
        try {
            List<InstitutionType> institutionTypeList = InstitutionTypeService.getAll();
            for (InstitutionType institutionType : institutionTypeList) {
                System.out.println(institutionType);
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void testGetById(){
        try {
            InstitutionType institutionType = InstitutionTypeService.getById("");
            System.out.println(institutionType);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

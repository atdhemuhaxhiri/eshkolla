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
//        testUpdate();
//        testDelete();
        testGetAll();
//        testGetById();
    }

    private static void testInsert(){
        InstitutionType institutionType = new InstitutionType();
        institutionType.setId(UUID.randomUUID().toString());
        institutionType.setName("UBT");
        institutionType.setDepartment("Computer science & Eng");

        if (InstitutionTypeService.insert(institutionType) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }

    private static void testUpdate(){
        InstitutionType institutionType = new InstitutionType();
        institutionType.setId("c619ffa4-06f8-443a-a549-84c4315a63b9");
        institutionType.setName("FIEK #1");
        institutionType.setDepartment("Computer science & Math");

        if (InstitutionTypeService.update(institutionType) > 0) {

            System.out.println("Recordi u ndryshua me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu ndryshuar");
        }
    }

    private static void testDelete(){
        if (InstitutionTypeService.delete("c619ffa4-06f8-443a-a549-84c4315a63b9") > 0) {
            System.out.println("Rekordi u fshi me sukses");
        } else {
            System.out.println("Rekordi deshtoi te fshihet");
        }
    }

    private static void testGetAll(){
        List<InstitutionType> institutionTypeList = InstitutionTypeService.getAll();
        for (InstitutionType institutionType : institutionTypeList) {
            System.out.println(institutionType);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }

    }

    private static void testGetById(){
        InstitutionType institutionType = InstitutionTypeService.getById("c619ffa4-06f8-443a-a549-84c4315a63b9");
        System.out.println(institutionType);
    }
}

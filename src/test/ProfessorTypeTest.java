package test;

import entities.ProfessorType;
import services.ProfessorTypeService;

import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 3/9/2017.
 */
public class ProfessorTypeTest {
    public static void main(String[] args){
//        testInsert();
//        testUpdate();
//        testDelete();
        testGetById();
//        testGetAll();
    }
    public static void testInsert(){
        ProfessorType professorType = new ProfessorType();
        professorType.setId(UUID.randomUUID().toString());
        professorType.setDescription("aaaaaa");
        if (ProfessorTypeService.insert(professorType) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }
    public static void testUpdate(){
        ProfessorType professorType = new ProfessorType();
        professorType.setId(UUID.randomUUID().toString());
        professorType.setDescription("");
        if (ProfessorTypeService.insert(professorType) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }
    }
    private static void testDelete() {
        if (ProfessorTypeService.delete("") > 0) {
            System.out.println("Rekordi u fshi me sukses");
        }else System.out.println("Rekordi deshtoi te fshihet");
    }
    private static void testGetAll() {
        List<ProfessorType> professorTypeList = ProfessorTypeService.getAll();
        for (ProfessorType professorType : professorTypeList) {
            System.out.println(professorType);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
    }
    private static void testGetById() {
        ProfessorType professorType = ProfessorTypeService.getById("c619ffa4-06f8-443a-a549-84c4315a63b9");
        System.out.println(professorType);
    }
}

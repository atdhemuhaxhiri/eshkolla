package test;


import entities.Subject;
import services.SubjectService;

import java.util.List;
import java.util.UUID;

/**
 * Created by Admin on 3/9/2017.
 */
    public class SubjectTest {
    public static void main(String[] args){

        testInsert();
        testUpdate();
        testDelete();
        testGetById();
        testGetAll();

    }
    public static void testInsert(){
        Subject subject = new Subject();
        subject.setId(UUID.randomUUID().toString());
        subject.setName("");
//        subject.setInstitution(new Institution("", "", ""));
//        subject.setSyllabus(new Syllabus(""));
        if (SubjectService.insert(subject) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }

    }
    public static void testUpdate(){
        Subject subject = new Subject();
        subject.setId(UUID.randomUUID().toString());
        subject.setName("");
//        subject.setInstitution(new Institution("", "", ""));
//        subject.setSyllabus(new Syllabus(""));
        if (SubjectService.insert(subject) > 0){
            System.out.println("Recordi u insertu me sukses");
        } else {
            System.out.println("Rekordi deshtoi per tu insertuar");
        }


    }
    private static void testDelete(){
        if (SubjectService.delete("") > 0) {
            System.out.println("Rekordi u fshi me sukses");
        } else {
            System.out.println("Rekordi deshtoi te fshihet");
        }
    }
    private static void testGetAll(){
        List<Subject> subjectList = SubjectService.getAll();
        for (Subject subject : subjectList) {
            System.out.println(subject);
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Total: " + subjectList.size());
    }
    private static void testGetById(){
        Subject subject = SubjectService.getById("c619ffa4-06f8-443a-a549-84c4315a63b9");
        System.out.println(subject);
    }
}

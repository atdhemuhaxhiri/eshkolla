package test;

import entities.Gender;

/**
 * Created by Admin on 3/7/2017.
 */
public class EnumTest {
    public static void main(String[] args){
        Gender gender = Gender.M;

        System.out.println("ToString: " + gender.toString());

        System.out.println("Name: " + gender.name());

        System.out.println("Ordinal: " + gender.ordinal());



    }
}

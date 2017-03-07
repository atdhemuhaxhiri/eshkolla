package test;

import java.util.Calendar;

/**
 * Created by Admin on 3/7/2017.
 */
public class CalendarTest {
    public static void main(String[] args){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 1988);
        c.set(Calendar.MONTH, 11);
        c.set(Calendar.DAY_OF_MONTH, 5);
        System.out.println(c.getTime());
    }
}

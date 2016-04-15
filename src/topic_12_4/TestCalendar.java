package topic_12_4;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * - Used to manipulate dates (easier than Date).
 * - Abstract class. Instances obtained from factory method.
 */

public class TestCalendar {
    public static void main(String[] args) {
//        Calendar calendar = new Calendar(); //illegal
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        
        calendar.setTime(date);
        System.out.println(date);
        
        //Add 5 hours
//        calendar.add(Calendar.HOUR, 5);
//        calendar.roll(Calendar.HOUR, 5);
        date = calendar.getTime();
        
        System.out.println(date);
        System.out.printf("First day of week: %s\n", calendar.getFirstDayOfWeek());
        System.out.printf("Today's day of week is: %s\n", calendar.get(Calendar.DAY_OF_WEEK));
        
    }
}

/**
 * To check:
 * - What is printed when a Calendar instance is passed as argument to print() method?
 * - What method is used to subtract an amount of time?
 * - What is the difference between roll and add?
 * - What number represents the first month of the year (January)?
 * - Send a Locale (US for example) reference as argument to getInstance() method, what's different?
 */
package topic_12_4;

import java.util.Date;

/**
 * - Represents a single date and time.
 * - Internally it stores a value of the milliseconds (between the date and
 * January 1 of 1970) in a long variable.
 * - Most of its methods are deprecated. Use Calendar instead.
 * - Good if you want a universal time.
 * - Used as bridge to format a Calendar object.
 * - Acceptable methods to use: setTime() and getTime()
 */
public class TestDateClass {
    public static void main(String[] args) {
        Date date = new Date(); //now
        System.out.println(date);
        
        //Adding 5 hours
        int fiveHours = 1000 * 60 * 60 * 5;
        date.setTime(date.getTime() + fiveHours);
        System.out.println(date);
    }
}

/**
 * To check:
 * - What other constructor Date class has?
 */
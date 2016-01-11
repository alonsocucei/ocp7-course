package topic_2_5;

/**
 *
 * @author jjsanche
 */


enum Day {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

public class TestEnums {   
    public static void main(String[] args) {
        printAllDays();
        Day d = Day.THURSDAY;
        Day d2 = Day.WEDNESDAY;
        
        switch(d2) {
            //compile error: on switch statemends complete enum names are not allowed.
//            case Day.MONDAY:
            case TUESDAY:
            default:    
        }
        
    }
    
    public static void printAllDays() {
        for (Day d: Day.values()) {
            System.out.println(d.toString());
        }
    }
}

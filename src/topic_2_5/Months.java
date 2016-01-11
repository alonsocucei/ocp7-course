package topic_2_5;

/**
 *
 * @author jjsanche
 */
public enum Months {
    JANURAY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
    enum Days {MONDAY, TUESDAY, WEDNESDAY, THURSDAY};
    
    public static void main(String... a) {
        System.out.println("cualquier cosa");
        System.out.println(Months.Days.MONDAY);
    }
}

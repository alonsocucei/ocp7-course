package topic_12_4;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

/**
 * - DateFormat is used to formate Dates.
 * - It's abstract and uses factory methods as Calendar to create instances.
 * - format() method is used to actually give the format to the date
 * - parse() method is used to convert a String to a Date object.
 */
public class TestDateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat[] formatters = {
            DateFormat.getInstance(),
            DateFormat.getDateTimeInstance(),
            DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT),
            DateFormat.getDateInstance(),
            DateFormat.getDateInstance(DateFormat.SHORT),
            DateFormat.getDateInstance(DateFormat.MEDIUM),
            DateFormat.getDateInstance(DateFormat.LONG),
            DateFormat.getDateInstance(DateFormat.FULL)
        };
        
        for (DateFormat formatter: formatters) {
            System.out.println(formatter.format(date));
        }
        
        try {
            int source = formatters.length - 1;
            int target = formatters.length - 4;
            
            Date parsedDate = formatters[source].parse("lunes 18 de abril de 2016");
            System.out.println(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What other class has a parse() method to convert String to milliseconds (long)?
 * - What the format() method returns?
 * - What other factory methods DateFormat class has?
 * - Modify line 30 so formatters indexes are different. What happens?
 */
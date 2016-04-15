package topic_12_4;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * - DateFormat is used to formate Dates.
 * - It's abstract and uses factory methods as Calendar.
 * - format() method is used to actually give the format to the date
 * - parse() method is used to convert a String to a Date object.
 */
public class TestDateFormat {
    public static void main(String[] args) {
        Date date = new Date();
        DateFormat[] formatters = {
            DateFormat.getInstance(),
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
            Date parsedDate = formatters[formatters.length - 1].parse(formatters[formatters.length - 1].format(date));
            System.out.println(parsedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What other class has a parse() method to convert String to Date?
 * - What the format() method returns?
 * - What other factory methods DateFormat class has?
 * - Modify line 30 so formatters indexes are different. What happens?
 */
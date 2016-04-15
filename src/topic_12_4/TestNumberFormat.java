package topic_12_4;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * - NumberFormat is used to format numbers or currency values.
 * - Same than DateFormat, this class is abstract, instances are obtained
 * calling factory methods.
 * - format() method works the same way than in DateFormat.
 * - setMaximumFractionDigits(), getMaximumFractionDigits(), parse() and 
 * setParseIntegerOnly() are methods in the exam.
 */

public class TestNumberFormat {
    public static void main(String[] args) {
        double number = 44888.98789;
        Locale locale = new Locale("pt", "BR");
        
        NumberFormat[] formatters = {
            NumberFormat.getInstance(),
            NumberFormat.getInstance(locale),
            NumberFormat.getNumberInstance(),
            NumberFormat.getNumberInstance(locale),
            NumberFormat.getCurrencyInstance(),
            NumberFormat.getCurrencyInstance(locale)
        };
        
        for (NumberFormat formatter: formatters) {
            System.out.println(formatter.format(number));
        }
        
        System.out.printf("Maximum fraction digits: %d\n", formatters[0].getMaximumFractionDigits());
        System.out.printf("Maximum fraction digits: %d\n", formatters[4].getMaximumFractionDigits());
        formatters[0].setMaximumFractionDigits(5);
        formatters[4].setMaximumFractionDigits(5);
        System.out.printf("Maximum fraction digits: %d\n", formatters[0].getMaximumFractionDigits());
        System.out.printf("Maximum fraction digits: %d\n", formatters[4].getMaximumFractionDigits());
        System.out.println(formatters[0].format(number));
        System.out.println(formatters[4].format(number));
        
        try {
            System.out.printf("Parsing %s: %s\n", "1234.5678987", formatters[0].parse("1234.5678987"));
            formatters[0].setParseIntegerOnly(true);
            System.out.printf("Parsing %s: %s\n", "1234.5678987", formatters[0].parse("1234.5678987"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

/**
 * To check:
 * - What's the return type for parse() method?
 * - When having more fraction digits than the maximum, what the format() method 
 * does with the rest?
 */
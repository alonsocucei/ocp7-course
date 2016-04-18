package topic_12_1;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * - The API defines a locale as a specific geographical, political or cultural
 * region. 
 * - A Locale instance receives as arguments two Strings, one representing the language
 * (lowercase) and the other representing the country (uppercase).
 */
public class TestLocale {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 3, 16);

        System.out.println(calendar.getTime());

        Locale[] locales = {
            new Locale("es", "MX"),
            new Locale("it", "IT"),
            new Locale("pt", "BR"),
            Locale.GERMANY,
            new Locale("nl", "NL")
        };

        for (Locale locale : locales) {
            DateFormat formatter = DateFormat.getDateInstance(DateFormat.FULL, locale);
            System.out.println(formatter.format(calendar.getTime()));
        }

        for (Locale locale : locales) {
            System.out.printf("Name:%s\tLanguage: %s\tCountry:%s\n", locale.getDisplayName(), locale.getDisplayLanguage(), locale.getDisplayCountry());
            System.out.printf("Name:%s\tLanguage: %s\tCountry:%s\n", locale.getDisplayName(locale), locale.getDisplayLanguage(locale), locale.getDisplayCountry(locale));
        }
    }
}

/**
 * To check:
 * - Change the order of arguments for a Locale constructor. What happens?
 * - Change the values for the calendar instance an see the results.
 * - Locale has a constructor that declares only a String, what is this parameter for?
 * - What's the difference when calling the getDisplayXxx() methods with and without argument?
 * - What's another way to get a Locale object (using the same class)?
 */

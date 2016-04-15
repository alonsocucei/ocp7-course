package topic_12_6;

import java.util.Locale;

/**
 * - As good practice save the default locale and at the end restore back to
 * original value.
 * - i18n stands for Internationalization. It's the design of the application to adapt locales.
 * - l10n stands for Localization. It's the process to adapting the software to a locale.
 */
public class TestLocaleClass {
    public static void main(String[] args) {
        Locale myLocale = Locale.getDefault();
        System.out.println(myLocale);
        
        Locale.setDefault(Locale.GERMANY);
        System.out.println(Locale.getDefault());
        
        Locale.setDefault(myLocale);
        System.out.println(Locale.getDefault());
    }
}

/**
 * To check:
 * - How many locales exist?
 * - What ISO countries are available?
 * - What languages are available?
 * - What are default language/country default values for predefined Locale objects
 * like Locale.FRANCE?
 */
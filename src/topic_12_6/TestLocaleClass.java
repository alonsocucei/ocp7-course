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
        
        Locale.setDefault(new Locale("fr", "MX"));
        System.out.println(Locale.getDefault());
        System.out.println(Locale.getDefault().getDisplayName());
        
        Locale.setDefault(myLocale);
        System.out.println(Locale.getDefault());
        
        Locale[] locales = Locale.getAvailableLocales();
        String[] isoCountries = Locale.getISOCountries();
        String[] languages = Locale.getISOLanguages();
        
//        for(Locale locale: locales) {
//            System.out.println(locale.getDisplayName());
//        }
        
//        for (String country: isoCountries) {
//            Locale  l = new Locale("es", country);
//            System.out.println(l.getDisplayName(l));
//        }

        for (String language: languages) {
            Locale  l = new Locale(language, "MX");
            System.out.println(l.getDisplayName(l));
        }
        
        System.out.println("Available locales: " + locales.length);
        System.out.println("Available countries: " + isoCountries.length);
        System.out.println("Available languages: " + languages.length);
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
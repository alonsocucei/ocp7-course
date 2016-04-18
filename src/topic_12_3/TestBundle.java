package topic_12_3;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * - A ResourceBundle is like a map containing keys for titles or messages to display
 * in the application which must be translated at runtime depending on the Locale.
 * - When values are read from a properties file, internally a PropertyResourceBundle is used,
 * when values are read from another Java class then we extend from ListResourceBundle.
 */
public class TestBundle {
    public static void main(String[] args) {
        Locale locale = new Locale("es", "PE");
        System.out.println(Locale.getDefault());
        ResourceBundle bundle = ResourceBundle.getBundle("topic_12_2.MyResources", locale);

        System.out.println(bundle.getClass());

        System.out.printf("saludo: %s\n", bundle.getString("helloKey"));
        System.out.printf("despedida: %s\n", bundle.getString("byeKey"));
        System.out.printf("felicitacion: %s\n", bundle.getString("congratsKey"));
    }
}

/**
 * To check:
 * - What's a ResourceBundle?
 * - How can I use a different bundle?
 * - What's the difference between using property files and Java classes for
 * key-value pairs?
 * - Which one has priority ListResourceBundle or PropertyResourceBundle?
 * - What's the order Java searches for bundles?
 * - What if the bundle is not found?
 * - What if not all properties are in the same file?
 * - How ResourceBundle files hierarchy works?
 */
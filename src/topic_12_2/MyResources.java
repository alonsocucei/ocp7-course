package topic_12_2;

import java.util.ListResourceBundle;

/**
 * @author alonsocucei
 */
public class MyResources extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
            {"helloKey", "Hello"},
            {"byeKey", "Bye bye"},
            {"congratsKey", "Congratulations!"}
        };
    }
}

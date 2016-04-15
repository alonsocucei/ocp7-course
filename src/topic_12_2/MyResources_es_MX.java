package topic_12_2;

import java.util.ListResourceBundle;

/**
 * @author alonsocucei
 */
public class MyResources_es_MX extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][] {
            {"helloKey", "Que onda güey"},
            {"byeKey", "Hay nos vidrios"},
            {"congratsKey", "Chingao, felicidades canijo!"}
        };
    }
}

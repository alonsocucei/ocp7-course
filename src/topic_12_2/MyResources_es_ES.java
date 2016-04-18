package topic_12_2;

import java.util.ListResourceBundle;

/**
 * @author alonsocucei
 */
public class MyResources_es_ES extends ListResourceBundle {
protected Object[][] getContents() {
        return new Object[][] {
            {"helloKey", "Hola macho - ListResourceBundle"},
            {"byeKey", "Hay nos vidrios"}
//                ,
//            {"congratsKey", "Chingao, felicidades canijo!"}
        };
    }
}

package topic_1_7.util;

/**
 * This file will be stored in file system as follows:
 * - topic_1_7
 *      |
 *      - util
 *         |
 *         TestSubpackage.java
 * 
 * So, a package is stored in file systems as folders inside parent package folders,
 * but netbeans display them together in order to easy visualize them.
 * 
 * An important thing to realize is that
 * import topic_1_7.*;
 * won't include this file, because it's a totally different package.
 * 
 * To include this file the 2 options are:
 * import topic_1_7.util.*;
 * import topic_1_7.util.TestSubpackage;
 * 
 * @author alonsocucei
 */
public class TestSubpackage {

}

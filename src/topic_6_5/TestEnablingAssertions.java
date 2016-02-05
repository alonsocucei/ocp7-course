package topic_6_5;

/**
 * - 'ea' and 'enableassertions' options are passed to java in order to enable
 * assertions at runtime.
 * - 'da' and 'disableassertions' options do the opposite.
 * - assertions are disabled by default.
 * - enabling/disabling can be done just to 1 class or package or select just
 * - there are options to do the same for system assertions (API assertions):
 * 'esa', 'dsa' and the long versions: 'enablesystemassertions' and 'disablesystemassertions'
 * some classes of certain packages.
 * Example:
 *  enable assertions for a package:
 * java -ea:<package_name>... <class_name_to_execute>
 * 
 *  enable assertions for two packages:
 * java -ea:<package_name>... -ea:<package_name_2>... <class_name_to_execute>
 * 
 *  enable assertions for a package except one class:
 * java -ea:<package_name>... -da:<package_name>.<class_name> <class_name_to_execute>
 * 
 */
public class TestEnablingAssertions {

}

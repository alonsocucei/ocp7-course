package topic_3_3;

/**
 * - IS A relationship means one class extends another or implements an interface.
 * - <any_class> IS A Object will always be true.
 */

/**
 * To check:
 * - How many IS A statements can you think of for the classes and interfaces declared?
 */
public class Test_IS_A_Relationship {
}

interface Heroe {}
interface SuperHeroe extends Heroe {}
class IronMan implements SuperHeroe {}
class ChapulinColorado implements Heroe {}
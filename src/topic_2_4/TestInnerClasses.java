package topic_2_4;

/**
 * - Inner classes are declared inside an outer class.
 * - Inner classes can't live without an instance of the outer class.
 * - Inner classes can't declare static members.
 * - Valid modifiers are: strictfp, abstract, final, public, protected and private.
 */
public class TestInnerClasses {
    public static void main(String[] args) {
        OutClass oc = new OutClass();
//        OutClass.InnerClass ic = new OutClass.InnerClass();//compile error: invalid syntax
        OutClass.InnerClass ic = oc.new InnerClass();
//        oc.InnerClass ocic = oc.new InnerClass(); //compile error: invalid syntax
        OutClass.InnerClass occ = new OutClass().new InnerClass();
        OutClass.InnerClass.DeeperClass ocdc = new OutClass().new InnerClass().new DeeperClass();
        occ.im1();
        ocdc.dm1();
    }
}

/**
 * To check:
 * - How to create instances of the inner class.
 * - How to reference the outer object from the inner class.
 */
class OutClass {
    private int field = 3;
    private int repeatedNameField;
    private InnerClass ic = new InnerClass();
    private InnerClass.DeeperClass dc = ic.new DeeperClass();
    private InnerClass.DeeperClass dc2 = new InnerClass().new DeeperClass();
    
    public void m1(){}
    class InnerClass {
        private int field = 2;
        private int innerField;
        private int repeatedNameField;
//        private static int a; //compile error: cannot declare static members in inner classes.
        
        public void im1() {
            System.out.println(field);
            System.out.println(OutClass.this.field);
            m1();
        }
        
        class DeeperClass {
            private int field = 0;
            
            public void dm1() {
                im1();
//                super.im1(); //compile error: Object class doesn't have im1 method.
                System.out.println(field);
                System.out.println(InnerClass.this.field);
                System.out.println(OutClass.this.field);
            }
        }
    }
}
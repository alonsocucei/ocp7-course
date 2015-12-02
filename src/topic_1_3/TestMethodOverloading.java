package topic_1_3;

/**
 * This file tests how java works when making calls on overloading methods.
 * There are 2 main scenarios.
 * 
 * 1.- Parameters are primitive types:
 *      exact match -> bigger type (promotion) -> reference type (auto-boxing) -> super classes -> var args
 * 
 * 2.- Parameters are reference types:
 *      exact match -> super classes -> primitive type (auto-unboxing) -> var args
 * 
 * @author alonsocucei
 */
public class TestMethodOverloading {
    public static void main(String[] args) {
        Calculator c = new Calculator();
        c.suma(3, 4);
        c.suma(new Integer(3), new Integer(4));
        c.suma(new Short((short)3), new Short((short)4));
        c.suma((short)3, (short)4);
//        c.suma(3.3f, 4);
        c.suma(3l, 4l);
        c.suma((byte)3, (byte)4);
        c.suma(3);
    }
}

class Calculator {
    //método original
//    public double suma(int a, int b) {
//        System.out.println("1");
//        return a + b;
//    }
//    
//    //sobrecarga, cambio de tipos
//    public double suma(int a, float b){
//        System.out.println("2");
//        return a + b;
//    }
//    
//    //sobrecarga, número de parámetros
//    public double suma(int a, int b, int c){
//        System.out.println("3");
//        return a + b + c;
//    }
//    
//    //sobrecarga, cambio en el orden de los parámetros
//    public double suma(float a, int b){
//        System.out.println("4");
//        return a + b;
//    }
//    
//    public double suma(short a, short b) {
//        System.out.println("5");
//        return a + b;
//    }
    
    public double suma(Integer a, Integer b) {
        System.out.println("6");
        return a + b;
    }
    
//    public void suma(Object a, Object b) {
//        System.out.println("7");
//    }
//    
//    public void suma(Number a, Number b) {
//        System.out.println("8");
//    }
    
    public void suma(long... a) {
        System.out.println("9");
    }
    
    public double suma(Short a, Short b) {
        System.out.println("10");
        return a + b;
    }
    
    //compile error: method already exists
    //return type is not important on overloading
//    public int suma(int a, int b){
//        return a + b;
//    }
}
package topic_4_3;

import java.util.ArrayList;
import java.util.List;

/**
 * - Generics and raw declarations must compile in order to have compatibility.
 * - When mixing raw and generic types compiler will send warnings.
 * - Be careful when mixing types, as it may produce runtime exceptions.
 */
public class TestMixingGenericAndRawTypes {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();
        myList.add(10);
        
        List secondList = myList;
        secondList.add("hahaha");
        
        for (Integer i: myList) {
            System.out.println(i);
        }
    }
}

/**
 * To check:
 * - Will the code in mail compile?
 * - Check the compiler message
 * - Will it run? If it does, will it generate exceptions?
 */
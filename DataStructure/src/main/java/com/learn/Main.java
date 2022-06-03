package com.learn;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("Kamlesh");

        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("Kamlesh");

        System.out.println(arrayList);
        System.out.println(linkedList);
    }
}
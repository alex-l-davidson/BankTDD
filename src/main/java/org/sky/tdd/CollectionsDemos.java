package org.sky.tdd;

import java.awt.*;
import java.util.*;
import java.util.List;

public class CollectionsDemos {


    public static void moreListDemo() {
        // can nest lists
        List<List<Integer>> my2dList = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(10);
        row1.add(20);
        row1.add(30);
        row1.add(40);
        my2dList.add(row1);
        System.out.println(my2dList.get(0).get(2)); //will print 30
        // 3rd item on the first list
        my2dList.get(0).set(2, 52);
        // this changes the 3rd item (index=2) on the 1st list (index=0) to 52
        System.out.println(my2dList.get(0).get(2));

        // Sets and Lists are both implementations of Collection interface
        // Sets are like unordered lists, cannot access by index
        // contain only unique items
        // if you add duplicates, they will automatically be removed
        // diff types of Sets: HashSet, TreeSet, AbstractSet...
        // those are different implementations of the Set interface
        // they basically order the sets using different algorithms
        Set<Integer> myNumbers = new HashSet<>();
        myNumbers.add(1);
        myNumbers.add(1);
        myNumbers.add(23);
        myNumbers.add(52);
        myNumbers.add(19);
        myNumbers.add(52);
        System.out.println(myNumbers);

        Map<Integer, String> myMap = new HashMap<>(); //equivalent of Python dictionary
        //key,value pairs
        myMap.put(1,"One");
        myMap.put(7, "Two");
        myMap.put(5, "Three");
        System.out.println(myMap.get(5));
        //access items in a Map based on the Key (no index)
    }

    public static void ListDemo(){
        //Collections Interface uses Generics, indicated by <>
        // Generics are asking for a data type (non-primitive)
        // Collection Interface -> List Interface -> ArrayList
        // List<TYPE>
        // all three of the following work, just diff level of abstraction
        // choose based on level of functionality you are looking for
        Collection<String> myStrings1 = new ArrayList<>();
        List<String> myStrings2 = new ArrayList<>();
        ArrayList<String> myStrings3 = new ArrayList<>();

        // to add to lists
        myStrings3.add("Hello");
        myStrings3.add("World");

        // to access list items
        System.out.println(myStrings3.get(0)); // instead of myStrings3[0]

        // to access length
        System.out.println(myStrings3.size()); // instead of myStrings3.length()

        // for lists of integers, since Generic should be non-primitive
        List<Integer> myNumbers = new Vector<>();
        myNumbers.add(2);

        System.out.println(myNumbers.get(0));

        List<Point> myPoints = new ArrayList<>();
        myPoints.add(new Point (0,0));
        System.out.println(myPoints.get(0));

        // LinkedList is another collection very similar to ArrayList
        // they are just built differently under the hood
    }

        public static void ArrayDemo(){
            // Arrays are immutable, just like strings
            // Can't change the length of an array.
            // Everytime you change a string, a new one is created.
            int[] myNumbers = new int[5]; //this is creating an array with 5 items in it
            // but we didn't specify the values so
            System.out.println(myNumbers[0]); // is 0
            System.out.println(myNumbers[3]); // is 0
            // primitive data types are set to their default value (e.g. 0)
            Point[] myStrings = new Point[5];
            // non-primitive default to null
            // can access length
            System.out.println(myNumbers.length); // will print 5
            //shortcut for loops
            for (int x : myNumbers){
                // this is the same as for (int x = 0; x < myNumbers.length; x++)
                System.out.println(x);
            }
            for (Point p : myStrings){
                System.out.println(p);
            }
        }
}

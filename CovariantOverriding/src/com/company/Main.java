package com.company;

import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {
        // write your code here


        for (Method m : Point.class.getMethods())
            if (m.getName().equals("clone"))
                System.out.println(m.toGenericString());
    }
/*
*
*public Point Point.clone()
public bridge java.lang.Object Point.clone() bridge call the first method
* */


}

// Covariant Overriding
// Java 5 supports covariant method overriding, it is implemented using a bridge tech

/* In java 1.4 and earlier, one method can override another only if the argument
 * and return types match exactly.
 * In java 5, a method can override another if the argument type match and return type
 * of the overriding method is a subtype of the return type of the other
 *
 *
 *
 *
 * */

//  IN java 1.4 and earlier

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Object clone(){}; // return type must be Object due to the clone method of Object

    public Point clone()... // after java 5

}


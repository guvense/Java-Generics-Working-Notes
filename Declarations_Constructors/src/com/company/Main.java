package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        // If I write without parameters I gonna got unchecked error
        //  Unchecked error occur when a parameterized type assign to raw type(Heap Pollution)
        Pair<String,Integer> pair = new Pair("HELLO",1);

        // correct usage should be like that
        Pair<String,Integer> pair1=new Pair<>("hello",1);


        Cell<String> cs = new Cell<String>(1);
        Cell<Integer> ci = new Cell<>(2);

       System.out.println( Cell.getCount());;
       Cell<?>.getCount(); // error
       Cell<Integer>.getCount(); // error


        // Error can occur due to static members belongs to whole class 
    }
}

// In generic class type parameters appear in the header not const

class Pair <T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }


}
// Static members are member of whole class not particular one
class Cell <T> {
    private  int id;
    private static int count = 0;

    public static int getCount(){return count;}
    public Cell(int id) {
        this.id = id;
        count ++ ;
    }
}



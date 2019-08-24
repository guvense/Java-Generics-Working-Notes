package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Comparison and Bounds

        // Comparable

        /*
         *  Number class not implemented Comparable interface
         *  x.equals(y) if and only if x.compareTo(y) == 0
         * Comparable consistent with equal
         * Sorted, Set, SortedMap compare items with natural ordering
         * Almost every class in the java natural ordering is consistent
         * with equals except BigDecimal
         * x.equals(null) --> false
         * x.compareTo(null) --> NUllPointerException
         *
         * */

        // Test section part 1

        assert "two".compareTo("three") > 0;


    }


    // Hint: unlike wildcards type variables never show with super
    public static <T extends Comparable<T>> T max(Collection<T> coll) {

        T candidate = coll.iterator().next();
        // we use next because collection has not get
        for (T elt : coll) {
            if (candidate.compareTo(elt) < 0) candidate = elt;
        }
        return candidate;
    }

    //  public static <T extends Comparable<? super T> T max2(Collection<? extends T> coll);


    //  max with comparator

    public static <T> T maxWithComparator(Collection<? extends T> coll, Comparator<? super T> cmp) {
        T candidate = coll.iterator().next();
        for (T elt : coll) {
            if (cmp.compare(candidate, elt) < 0) {
                candidate = elt;
            }
        }
        return candidate;
    }


    //  comparator provide natural ordering

    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return new Comparator<T>() {
            public int compare(T t, T t1) {
                return t.compareTo(t1);
            }
        };
    }

    public static <T extends Comparable<? super T>> T maxComp(Collection<? extends T> coll) {
        return maxWithComparator(coll, naturalOrder());
    }

    /*
     * Info
     * We can use reverse of max in order to declare min function which is easier maintain but when we look at
       source code we see that max and min declare separately it is much more faster . 30 percent much more faster
      * JAva utilities use in loop so performance is more important.
     */
    //

    // my implement
    private static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
        T candidate = coll.iterator().next();

        for (T e : coll) {
            if (candidate.compareTo(e) > 0) {
                candidate = e;
            }
        }
        return candidate;
    }

    private static <T> T minWithComparator(Collection<? extends T> coll, Comparator<? super T> comp) {

        T candidate = coll.iterator().next();
        for (T el : coll) {
            if (comp.compare(candidate, el) > 0) {
                candidate = el;
            }
        }
        return candidate;
    }

    private static <T extends Comparable<? super T>> Comparator<T> naturalOr() {
        return new Comparator<T>() {

            public int compare(T t, T t1) {
                return t.compareTo(t1);
            }
        };
    }

    private static <T extends Comparable<T>> T minWithNaturalComparator(Collection<? extends T> coll) {
      return   minWithComparator(coll, naturalOr());
    }

}

// This interface called natural ordering
interface myComparable<T> {

    public int compareTo(T o);

}

//  Comparator unnatural ordering

interface myComparator<T> {
    public int compare(T o1, T o2);

    public boolean equals(Object obj);
}

// Permitting comparision of apples with oranges
/*
abstract class Fruit implements Comparable<Fruit> {

    protected String name;
    protected int size;

    protected Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public boolean equals(Object o) {
        if (o instanceof Fruit) {
            Fruit that = (Fruit) o;
            return this.name.equals(that.name) && that.size == that.size;

        } else
            return false;
    }

    public int hashcode() {
        return name.hashCode() * 29 + size;

    }

    // Our section begin at this part
    public int compareTo(Fruit that) {
        return this.size < that.size ? -1 :
                this.size == that.size ? 0 : 1;
    }


}

class Apple extends Fruit {
    public Apple(int size) {
        super("Apple", size);
    }
}

class Orange extends Fruit {
    public Orange(int size) {
        super("Orange", size);
    }
}
*/

// Prohibiting comparison of apples with oranges
/*
abstract class Fruit {
    protected String name;
    protected int size;

    protected Fruit(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public boolean equals(Object o) {
        if (o instanceof Fruit) {
            Fruit that = (Fruit) o;
            return this.name.equals(that.name) && this.size == that.size;

        } else return false;
    }

    public int hashCode() {
        return name.hashCode() * 29 + size;
    }

    protected int compareTo(Fruit that) {
        return this.size < that.size ? -1 :
                this.size == that.size ? 0 : 1;

    }

}

class Apple extends Fruit implements Comparable<Apple>{

    public Apple(int size) {super("Apple",size);}


    public int compareTo(Apple apple) {
      return super.compareTo(apple);
    }

}

class Orange extends Fruit implements Comparable<Orange>{

    public Orange(int size){super("Orange",size);}

    public int compareTo(Orange orange){
        return super.compareTo(orange);
    }
}


*/


/* Test data
*        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);

        Orange o1 = new Orange(3);
        Orange o2 = new Orange(4);

        List<Apple> apples = Arrays.asList(a1, a2);
        assert Collections.max(apples).equals(a2);

        List<Orange> oranges = Arrays.asList(o1, o2);
        assert Collections.max(oranges).equals(o2);

        List<Fruit> fruits = Arrays.asList(a1, o1);
        assert Collections.max(fruits).equals(a1);
* */











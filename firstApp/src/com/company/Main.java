package com.company;

import org.jetbrains.annotations.NotNull;

import javax.print.attribute.standard.NumberUp;
import java.util.*;

public class Main {

    public static void main(String[] args) {


        // PECS
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<? super Integer> numbers = a;
        numbers.add(0);
        sum(numbers);




//        List<Number> numbers = new ArrayList<>();
//        numbers.add(2);
//        numbers.add(3.4);
//        assert numbers.toString().equals("[2,3.14]");

//        compile time error because  Lists are invariant
//        List<Integer> ints= new ArrayList<>();
//        ints.add(1);
//        ints.add(2);
//        List<Number> numbers=ints;

//        List<Number> nums = new ArrayList<Number>();
//        List<Integer> ints= Arrays.asList(1,2);
//        List<Double> doubles= Arrays.asList(2.78,3.14);
//        List<Integer> test= Collections.singletonList(1);
//        nums.addAll(ints);
//        nums.addAll(doubles);
//        nums.add(test.get(0));

//        List<Integer> integers = new ArrayList<Integer>();
//        integers.add(1);
//        integers.add(2);
//
//        List<? extends Number> numbers = integers;

//        In general, if a structure contains elements with a type of the form ? extends E , we can
//        get elements out of the structure, but we cannot put elements into the structure

//        List<Object> objs = Arrays.asList(2, 3.14, "hi");
//        List<Integer> ints = Arrays.asList(5, 6);
//        List<Double> doubles = Arrays.asList(1.1, 1.2);
//         double sum = sum(doubles);
//        System.out.println(sum);
//
//         Extend e get okay but put is error
//        List<Integer> integers = new ArrayList<Integer>();
//        integers.add(1);
//        integers.add(2);
//        List<? extends Number> nums = integers;

        // sum is fine because of get values
//        double sum = sum(nums);
//
//         add is not except null because puts a value otherwise we can add double
//        nums.add(null);

        //You cannot
        //put anything into a type declared with an extends wildcard—except for the value
        //null , which belongs to every reference type

        // Super de ise put okay get fail

//        List<Object> objects = new ArrayList<>();
//        objects.add(1);
//        List<? super Integer> integers1 = objects;

        // put a value is ok for super pecs
//        integers1.add(1);
        // error
//        sum(integers1);


//        The assignment violates the Get and Put Principle, be-
//                cause you cannot put a value into a type declared with an extends wildcard

        // Arrays

        // Why ?
        // Reified type is a run type representation of its component type

        //        Integer[] f = new Integer[]{1, 2, 3};
        //        Number[] numbers = integers2;
        //        numbers[2] = 3.14;

        // Wildcards also introduce contravariant subtyping for generics, in that type List<S> is
        //considered to be a subtype of List<? super T> when S is a supertype of T (as opposed
        //to a subtype).
        // generally get is okay for extends put is invalid except null
        // put is okay for super get is invalid except object


    }


    // Wildcard Capture
    // we write the values from T to T so its okay
    private static <T> void reverse0(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i< list.size(); i++){
            list.set(i,tmp.get(list.size()-i-1));
        }
    }
    // second
    // we write values from object to unknown type so its not okay
   /* public static void reverse2(List<?> list){
        List<Object> tmp = new ArrayList<>(list);
        for(int i =0; i< list.size();i++){
            list.set(i,tmp.get(list.size()-i-1));
        }
    }*/


    // wildcard capture
    public static void reverse(List<?> list) { rev(list); }

    private static <T> void rev(List<T> list) {
        List<T> tmp = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
        list.set(i, tmp.get(list.size()-i-1));
        }
    }


    // Restrictions on Wildcards

    /*
    * 1. Instance creation
    * List<?> list= new ArrayList<?>(); compile time error
    * Nested is okey
    * List<List<?>> lists= new ArrayList<
    * List<?> list = new ArrayList<Object>(); // ok
    List<?> list = new List<Object>() // compile-time error Lİst interface
    List<?> list = new ArrayList<?>() // compile-time error wildcard object creation fail
    * The Java designers had in mind
that every wildcard type is shorthand for some ordinary type, so they believed that
ultimately every object should be created with an ordinary type
    *
    * 2. explicit type parameter cannot be wildcard
    * List<?> list = Lists.<?>factory(); // compile-time error (nested is okay)
    *
    * 3. class extends
    * class AnyList extends ArrayList<?> {...} // compile-time error (nested okay)
    * */

    // PECS Producer extend consumer super or get put principle
    // producer get consumer set
//    private static <T> void copy(List<? super T> dst, List<? extends T> src) {
//
//        for (int i = 0; i < src.size(); i++) {
//            dst.set(i, src.get(i));
//        }
//    }


    // Works only if t is same type
    //    public static <T> void copy1(List<T> dst, List<T> src){}


    // T is object
    //  public static <T> void copy2(List<T> dst,List<? extends T> src){}

    // T is a Integer
//    public static <T> void copy3(List<? super T> dst, List<T> src){}
//
//     object number integer
//    public static <T> void copy4(List<? super T> dst, List<? extends T> src){}

    //    The Get and Put Principle: use an extends wildcard when you only get values out of a
//    structure, use a super wildcard when you only put values into a structure, and don’t use
//    a wildcard when you both get and put.
    // producer example
    private static double sum(@NotNull Collection<? extends Number> nums) {
        double s = 0.0;
        for (Number a : nums)
            s += a.doubleValue();
        return s;
    }
/*
    public static void count(Collection<? super Integer> ints, int n) {
        for (int i = 0; i < n; i++) ints.add(i);
    }
*/


}

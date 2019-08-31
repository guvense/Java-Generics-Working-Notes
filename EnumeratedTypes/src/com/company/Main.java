package com.company;

import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.CharBuffer;


class MultipleBounds {

    // Readable interface  has read method buffer from source
    // Appendable interface  append method copy from buffer into a target
    // Closeable close method close a source or target

    public static <E extends Readable & Closeable,T extends Appendable & Closeable> void copy(E src, T dest, int size) throws Exception {


        try {

            CharBuffer cb = CharBuffer.allocate(size);
            int i =src.read(cb);

            while (i!= -1){

                cb.flip();
                dest.append(cb);
                cb.clear();
                i=src.read(cb);

            }
        }catch (Exception e){

            throw new Exception(e.getMessage());
        }finally {
            src.close();
            dest.close();
        }
    }

}

/* generics are implemented by erasure. Normally this process is the same
* to without generics.
* In the case of a parameterized type such as Comparable<T>, this may cause
* additional methods to be be inserted by the complies. These addition called
* BRIDGES
*
*
*  */



public class Main {

    public static void main(String[] args) {
        // write your code here

        // using reflection
        for (Method m: Integer.class.getMethods())
            if (m.getName().equals("compareTo"))
                System.out.println(m.toGenericString());
    }
}

/*
* public int java.lang.Integer.compareTo(java.lang.Object)
* public int java.lang.Integer.compareTo(java.lang.Integer)
*
* Object parameter is bridge method
* */














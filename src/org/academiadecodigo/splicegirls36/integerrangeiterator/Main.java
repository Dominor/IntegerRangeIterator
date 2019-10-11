package org.academiadecodigo.splicegirls36.integerrangeiterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        IntegerRange range = new IntegerRange(1, 10);
        Iterator<Integer> iterator = range.iterator();

        /** for (Integer i : range) {
            System.out.println(i);
        }*/

        System.out.println("Range " + range);
        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}

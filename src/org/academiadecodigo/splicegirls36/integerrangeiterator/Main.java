package org.academiadecodigo.splicegirls36.integerrangeiterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        IntegerRange range = new IntegerRange(1, 10);

        for (Integer i : range) {
            System.out.println(i);
        }

        range.iterator().remove();
        range.setReversed(true);

        System.out.println("\n Titanic has hit. Time to go back to Mother England. \n");

        for(Integer i : range) {
            System.out.println(i);
        }
    }
}

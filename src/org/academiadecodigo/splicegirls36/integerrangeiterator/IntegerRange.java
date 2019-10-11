package org.academiadecodigo.splicegirls36.integerrangeiterator;

import java.util.Iterator;

public class IntegerRange implements Iterable<Integer> {

    private final Integer lowerBound;
    private final Integer upperBound;

    public IntegerRange(Integer lowerBound, Integer upperBound) {

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public Integer getLowerBound() {
        return lowerBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new IntegerRangeIterator();
    }

    @Override
    public String toString() {
        return "[" + lowerBound + ", " + upperBound + "]";
    }

    private class IntegerRangeIterator implements Iterator<Integer> {

        private Integer current;

        IntegerRangeIterator() {
            this.current = getLowerBound();
        }

        @Override
        public boolean hasNext() {
            return current <= getUpperBound();
        }

        @Override
        public Integer next() {
            return current++;
        }
    }
}

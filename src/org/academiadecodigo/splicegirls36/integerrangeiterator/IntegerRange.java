package org.academiadecodigo.splicegirls36.integerrangeiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class IntegerRange implements Iterable<Integer> {

    private final Integer lowerBound;
    private final Integer upperBound;
    private boolean reversed = false;

    private Set<Integer> removed;

    public IntegerRange(Integer lowerBound, Integer upperBound) {

        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        removed = new HashSet<>();
    }

    public Integer getLowerBound() {
        return lowerBound;
    }

    public Integer getUpperBound() {
        return upperBound;
    }

    /**@Override
    public Iterator<Integer> iterator() {
        return new IntegerRangeIterator();
    }*/

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {

            Integer current = (reversed) ? upperBound + 1 : lowerBound - 1;

            @Override
            public boolean hasNext() {
                if(reversed) {
                    while (removed.contains(current - 1)) {
                        current--;
                    }
                    return current > lowerBound;
                } else {
                    while(removed.contains(current + 1)) {
                        current++;
                    }
                    return current < upperBound;
                }
            }

            @Override
            public Integer next() {
                if(reversed) {
                    if(!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return current--;
                } else {
                    if(!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return current++;
                }
            }

            @Override
            public void remove() throws IllegalStateException {
                if (current > upperBound) {
                    throw new IllegalStateException("You need to call next() at least once.");
                }
                if (current < lowerBound) {
                    throw new IllegalStateException("You need to call next() at least once.");
                }
                removed.add(current);
            }
        };
    }

    @Override
    public String toString() {
        return "[" + lowerBound + ", " + upperBound + "]";
    }

    /**private class IntegerRangeIterator implements Iterator<Integer> {

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
    }*/

    public void setReversed(boolean flag) {
        this.reversed = flag;
    }
}

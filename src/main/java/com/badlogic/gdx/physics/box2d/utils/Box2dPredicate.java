package com.badlogic.gdx.physics.box2d.utils;

import java.util.Iterator;

public interface Box2dPredicate<T> {
    boolean evaluate(T t);

    public static class PredicateIterator<T> implements Iterator<T> {
        public boolean end;
        public Iterator<T> iterator;
        public T next;
        public boolean peeked;
        public Box2dPredicate<T> predicate;

        public PredicateIterator(Iterable<T> iterable, Box2dPredicate<T> box2dPredicate) {
            this(iterable.iterator(), box2dPredicate);
        }

        public PredicateIterator(Iterator<T> it, Box2dPredicate<T> box2dPredicate) {
            this.end = false;
            this.peeked = false;
            this.next = null;
            set(it, box2dPredicate);
        }

        public void set(Iterable<T> iterable, Box2dPredicate<T> box2dPredicate) {
            set(iterable.iterator(), box2dPredicate);
        }

        public void set(Iterator<T> it, Box2dPredicate<T> box2dPredicate) {
            this.iterator = it;
            this.predicate = box2dPredicate;
            this.peeked = false;
            this.end = false;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.end) {
                return false;
            }
            if (this.next != null) {
                return true;
            }
            this.peeked = true;
            while (this.iterator.hasNext()) {
                T next2 = this.iterator.next();
                if (this.predicate.evaluate(next2)) {
                    this.next = next2;
                    return true;
                }
            }
            this.end = true;
            return false;
        }

        public T next() {
            if (this.next == null && !hasNext()) {
                return null;
            }
            T t = this.next;
            this.next = null;
            this.peeked = false;
            return t;
        }

        public void remove() {
            if (!this.peeked) {
                this.iterator.remove();
                return;
            }
            throw new Box2dRuntimeException("Cannot remove between a call to hasNext() and next().");
        }
    }

    public static class PredicateIterable<T> implements Iterable<T> {
        public Iterable<T> iterable;
        public PredicateIterator<T> iterator = null;
        public Box2dPredicate<T> predicate;

        public PredicateIterable(Iterable<T> iterable2, Box2dPredicate<T> box2dPredicate) {
            set(iterable2, box2dPredicate);
        }

        public void set(Iterable<T> iterable2, Box2dPredicate<T> box2dPredicate) {
            this.iterable = iterable2;
            this.predicate = box2dPredicate;
        }

        public Iterator<T> iterator() {
            PredicateIterator<T> predicateIterator = this.iterator;
            if (predicateIterator == null) {
                this.iterator = new PredicateIterator<>(this.iterable.iterator(), this.predicate);
            } else {
                predicateIterator.set(this.iterable.iterator(), this.predicate);
            }
            return this.iterator;
        }
    }
}

package com.badlogic.gdx.physics.box2d.utils;

import com.badlogic.gdx.physics.box2d.utils.Box2dPredicate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Box2dArray<T> implements Iterable<T> {
    public T[] items;
    private ArrayIterable iterable;
    public boolean ordered;
    private Box2dPredicate.PredicateIterable<T> predicateIterable;
    public int size;

    public Box2dArray() {
        this(true, 16);
    }

    public Box2dArray(int i) {
        this(true, i);
    }

    public Box2dArray(boolean z, int i) {
        this.ordered = z;
        this.items = new Object[i];
    }

    public Box2dArray(boolean z, int i, Class cls) {
        this.ordered = z;
        this.items = (Object[]) Box2dArrayReflection.newInstance(cls, i);
    }

    public Box2dArray(Class cls) {
        this(true, 16, cls);
    }

    public Box2dArray(Box2dArray<? extends T> box2dArray) {
        this(box2dArray.ordered, box2dArray.size, box2dArray.items.getClass().getComponentType());
        this.size = box2dArray.size;
        System.arraycopy(box2dArray.items, 0, this.items, 0, this.size);
    }

    public Box2dArray(T[] tArr) {
        this(true, tArr, 0, tArr.length);
    }

    public Box2dArray(boolean z, T[] tArr, int i, int i2) {
        this(z, i2, tArr.getClass().getComponentType());
        this.size = i2;
        System.arraycopy(tArr, i, this.items, 0, this.size);
    }

    public void add(T t) {
        T[] tArr = this.items;
        int i = this.size;
        if (i == tArr.length) {
            tArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        tArr[i2] = t;
    }

    public void add(T t, T t2) {
        T[] tArr = this.items;
        int i = this.size;
        if (i + 1 >= tArr.length) {
            tArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        tArr[i2] = t;
        tArr[i2 + 1] = t2;
        this.size = i2 + 2;
    }

    public void add(T t, T t2, T t3) {
        T[] tArr = this.items;
        int i = this.size;
        if (i + 2 >= tArr.length) {
            tArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        tArr[i2] = t;
        tArr[i2 + 1] = t2;
        tArr[i2 + 2] = t3;
        this.size = i2 + 3;
    }

    public void add(T t, T t2, T t3, T t4) {
        T[] tArr = this.items;
        int i = this.size;
        if (i + 3 >= tArr.length) {
            tArr = resize(Math.max(8, (int) (((float) i) * 1.8f)));
        }
        int i2 = this.size;
        tArr[i2] = t;
        tArr[i2 + 1] = t2;
        tArr[i2 + 2] = t3;
        tArr[i2 + 3] = t4;
        this.size = i2 + 4;
    }

    public void addAll(Box2dArray<? extends T> box2dArray) {
        addAll(box2dArray.items, 0, box2dArray.size);
    }

    public void addAll(Box2dArray<? extends T> box2dArray, int i, int i2) {
        if (i + i2 <= box2dArray.size) {
            addAll(box2dArray.items, i, i2);
            return;
        }
        throw new IllegalArgumentException("start + count must be <= size: " + i + " + " + i2 + " <= " + box2dArray.size);
    }

    public void addAll(T... tArr) {
        addAll(tArr, 0, tArr.length);
    }

    public void addAll(T[] tArr, int i, int i2) {
        T[] tArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > tArr2.length) {
            tArr2 = resize(Math.max(8, (int) (((float) i3) * 1.75f)));
        }
        System.arraycopy(tArr, i, tArr2, this.size, i2);
        this.size += i2;
    }

    public T get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void set(int i, T t) {
        if (i < this.size) {
            this.items[i] = t;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void insert(int i, T t) {
        int i2 = this.size;
        if (i <= i2) {
            T[] tArr = this.items;
            if (i2 == tArr.length) {
                tArr = resize(Math.max(8, (int) (((float) i2) * 1.75f)));
            }
            if (this.ordered) {
                System.arraycopy(tArr, i, tArr, i + 1, this.size - i);
            } else {
                tArr[this.size] = tArr[i];
            }
            this.size++;
            tArr[i] = t;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new IndexOutOfBoundsException("first can't be >= size: " + i + " >= " + this.size);
        } else if (i2 < i3) {
            T[] tArr = this.items;
            T t = tArr[i];
            tArr[i] = tArr[i2];
            tArr[i2] = t;
        } else {
            throw new IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
        }
    }

    public boolean contains(T t, boolean z) {
        T[] tArr = this.items;
        int i = this.size - 1;
        if (z || t == null) {
            while (i >= 0) {
                int i2 = i - 1;
                if (tArr[i] == t) {
                    return true;
                }
                i = i2;
            }
            return false;
        }
        while (i >= 0) {
            int i3 = i - 1;
            if (t.equals(tArr[i])) {
                return true;
            }
            i = i3;
        }
        return false;
    }

    public boolean containsAll(Box2dArray<? extends T> box2dArray, boolean z) {
        T[] tArr = box2dArray.items;
        int i = box2dArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (!contains(tArr[i2], z)) {
                return false;
            }
        }
        return true;
    }

    public boolean containsAny(Box2dArray<? extends T> box2dArray, boolean z) {
        T[] tArr = box2dArray.items;
        int i = box2dArray.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (contains(tArr[i2], z)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T t, boolean z) {
        T[] tArr = this.items;
        int i = 0;
        if (z || t == null) {
            int i2 = this.size;
            while (i < i2) {
                if (tArr[i] == t) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        int i3 = this.size;
        while (i < i3) {
            if (t.equals(tArr[i])) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public int lastIndexOf(T t, boolean z) {
        T[] tArr = this.items;
        if (z || t == null) {
            for (int i = this.size - 1; i >= 0; i--) {
                if (tArr[i] == t) {
                    return i;
                }
            }
            return -1;
        }
        for (int i2 = this.size - 1; i2 >= 0; i2--) {
            if (t.equals(tArr[i2])) {
                return i2;
            }
        }
        return -1;
    }

    public boolean removeValue(T t, boolean z) {
        T[] tArr = this.items;
        if (z || t == null) {
            int i = this.size;
            for (int i2 = 0; i2 < i; i2++) {
                if (tArr[i2] == t) {
                    removeIndex(i2);
                    return true;
                }
            }
        } else {
            int i3 = this.size;
            for (int i4 = 0; i4 < i3; i4++) {
                if (t.equals(tArr[i4])) {
                    removeIndex(i4);
                    return true;
                }
            }
        }
        return false;
    }

    public T removeIndex(int i) {
        int i2 = this.size;
        if (i < i2) {
            T[] tArr = this.items;
            T t = tArr[i];
            this.size = i2 - 1;
            if (this.ordered) {
                System.arraycopy(tArr, i + 1, tArr, i, this.size - i);
            } else {
                tArr[i] = tArr[this.size];
            }
            tArr[this.size] = null;
            return t;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        } else if (i <= i2) {
            T[] tArr = this.items;
            int i4 = (i2 - i) + 1;
            int i5 = i3 - i4;
            if (this.ordered) {
                int i6 = i + i4;
                System.arraycopy(tArr, i6, tArr, i, i3 - i6);
            } else {
                for (int i7 = 0; i7 < i4; i7++) {
                    tArr[i + i7] = tArr[i5 + i7];
                }
            }
            int i8 = this.size;
            while (i5 < i8) {
                tArr[i5] = null;
                i5++;
            }
            this.size -= i4;
        } else {
            throw new IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
    }

    public boolean removeAll(Box2dArray<? extends T> box2dArray, boolean z) {
        int i;
        int i2 = this.size;
        T[] tArr = this.items;
        if (z) {
            int i3 = box2dArray.size;
            i = i2;
            for (int i4 = 0; i4 < i3; i4++) {
                T t = box2dArray.get(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= i) {
                        break;
                    } else if (t == tArr[i5]) {
                        removeIndex(i5);
                        i--;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        } else {
            int i6 = box2dArray.size;
            i = i2;
            for (int i7 = 0; i7 < i6; i7++) {
                Object obj = box2dArray.get(i7);
                int i8 = 0;
                while (true) {
                    if (i8 >= i) {
                        break;
                    } else if (obj.equals(tArr[i8])) {
                        removeIndex(i8);
                        i--;
                        break;
                    } else {
                        i8++;
                    }
                }
            }
        }
        if (i != i2) {
            return true;
        }
        return false;
    }

    public T pop() {
        int i = this.size;
        if (i != 0) {
            this.size = i - 1;
            T[] tArr = this.items;
            int i2 = this.size;
            T t = tArr[i2];
            tArr[i2] = null;
            return t;
        }
        throw new IllegalStateException("Array is empty.");
    }

    public T peek() {
        int i = this.size;
        if (i != 0) {
            return this.items[i - 1];
        }
        throw new IllegalStateException("Array is empty.");
    }

    public T first() {
        if (this.size != 0) {
            return this.items[0];
        }
        throw new IllegalStateException("Array is empty.");
    }

    public boolean notEmpty() {
        return this.size > 0;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        T[] tArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            tArr[i2] = null;
        }
        this.size = 0;
    }

    public T[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public T[] ensureCapacity(int i) {
        if (i >= 0) {
            int i2 = this.size + i;
            if (i2 > this.items.length) {
                resize(Math.max(8, i2));
            }
            return this.items;
        }
        throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
    }

    public T[] setSize(int i) {
        truncate(i);
        if (i > this.items.length) {
            resize(Math.max(8, i));
        }
        this.size = i;
        return this.items;
    }

    /* access modifiers changed from: protected */
    public T[] resize(int i) {
        T[] tArr = this.items;
        T[] tArr2 = (Object[]) Box2dArrayReflection.newInstance(tArr.getClass().getComponentType(), i);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(this.size, tArr2.length));
        this.items = tArr2;
        return tArr2;
    }

    public void sort() {
        Box2dSort.instance().sort(this.items, 0, this.size);
    }

    public void sort(Comparator<? super T> comparator) {
        Box2dSort.instance().sort(this.items, comparator, 0, this.size);
    }

    public T selectRanked(Comparator<T> comparator, int i) {
        if (i >= 1) {
            return Box2dSelect.instance().select(this.items, comparator, i, this.size);
        }
        throw new Box2dRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    }

    public int selectRankedIndex(Comparator<T> comparator, int i) {
        if (i >= 1) {
            return Box2dSelect.instance().selectIndex(this.items, comparator, i, this.size);
        }
        throw new Box2dRuntimeException("nth_lowest must be greater than 0, 1 = first, 2 = second...");
    }

    public void reverse() {
        T[] tArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            T t = tArr[i4];
            tArr[i4] = tArr[i5];
            tArr[i5] = t;
        }
    }

    public void shuffle() {
        T[] tArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = Box2dMathUtils.random(i);
            T t = tArr[i];
            tArr[i] = tArr[random];
            tArr[random] = t;
        }
    }

    public Iterator<T> iterator() {
        if (this.iterable == null) {
            this.iterable = new ArrayIterable(this);
        }
        return this.iterable.iterator();
    }

    public Iterable<T> select(Box2dPredicate<T> box2dPredicate) {
        Box2dPredicate.PredicateIterable<T> predicateIterable2 = this.predicateIterable;
        if (predicateIterable2 == null) {
            this.predicateIterable = new Box2dPredicate.PredicateIterable<>(this, box2dPredicate);
        } else {
            predicateIterable2.set(this, box2dPredicate);
        }
        return this.predicateIterable;
    }

    public void truncate(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("newSize must be >= 0: " + i);
        } else if (this.size > i) {
            for (int i2 = i; i2 < this.size; i2++) {
                this.items[i2] = null;
            }
            this.size = i;
        }
    }

    public T random() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        return this.items[Box2dMathUtils.random(0, i - 1)];
    }

    public T[] toArray() {
        return toArray(this.items.getClass().getComponentType());
    }

    public <V> V[] toArray(Class<V> cls) {
        V[] vArr = (Object[]) Box2dArrayReflection.newInstance(cls, this.size);
        System.arraycopy(this.items, 0, vArr, 0, this.size);
        return vArr;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        T[] tArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 *= 31;
            T t = tArr[i3];
            if (t != null) {
                i2 += t.hashCode();
            }
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof Box2dArray)) {
            return false;
        }
        Box2dArray box2dArray = (Box2dArray) obj;
        if (!box2dArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != box2dArray.size) {
            return false;
        }
        T[] tArr = this.items;
        T[] tArr2 = box2dArray.items;
        int i2 = 0;
        while (i2 < i) {
            T t = tArr[i2];
            T t2 = tArr2[i2];
            if (t == null) {
                if (t2 == null) {
                    i2++;
                }
            } else if (t.equals(t2)) {
                i2++;
            }
            return false;
        }
        return true;
    }

    public boolean equalsIdentity(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof Box2dArray)) {
            return false;
        }
        Box2dArray box2dArray = (Box2dArray) obj;
        if (!box2dArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != box2dArray.size) {
            return false;
        }
        T[] tArr = this.items;
        T[] tArr2 = box2dArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (tArr[i2] != tArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        T[] tArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(tArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(", ");
            sb.append(tArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public String toString(String str) {
        if (this.size == 0) {
            return "";
        }
        T[] tArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append(tArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(str);
            sb.append(tArr[i]);
        }
        return sb.toString();
    }

    public static <T> Box2dArray<T> of(Class<T> cls) {
        return new Box2dArray<>((Class) cls);
    }

    public static <T> Box2dArray<T> of(boolean z, int i, Class<T> cls) {
        return new Box2dArray<>(z, i, cls);
    }

    public static <T> Box2dArray<T> with(T... tArr) {
        return new Box2dArray<>(tArr);
    }

    public static class ArrayIterator<T> implements Iterable<T>, Iterator<T> {
        private final boolean allowRemove;
        private final Box2dArray<T> array;
        int index;
        boolean valid;

        public Iterator<T> iterator() {
            return this;
        }

        public ArrayIterator(Box2dArray<T> box2dArray) {
            this(box2dArray, true);
        }

        public ArrayIterator(Box2dArray<T> box2dArray, boolean z) {
            this.valid = true;
            this.array = box2dArray;
            this.allowRemove = z;
        }

        public boolean hasNext() {
            if (this.valid) {
                return this.index < this.array.size;
            }
            throw new Box2dRuntimeException("#iterator() cannot be used nested.");
        }

        public T next() {
            if (this.index >= this.array.size) {
                throw new NoSuchElementException(String.valueOf(this.index));
            } else if (this.valid) {
                T[] tArr = this.array.items;
                int i = this.index;
                this.index = i + 1;
                return tArr[i];
            } else {
                throw new Box2dRuntimeException("#iterator() cannot be used nested.");
            }
        }

        public void remove() {
            if (this.allowRemove) {
                this.index--;
                this.array.removeIndex(this.index);
                return;
            }
            throw new Box2dRuntimeException("Remove not allowed.");
        }

        public void reset() {
            this.index = 0;
        }
    }

    public static class ArrayIterable<T> implements Iterable<T> {
        private final boolean allowRemove;
        private final Box2dArray<T> array;
        private ArrayIterator iterator1;
        private ArrayIterator iterator2;

        public ArrayIterable(Box2dArray<T> box2dArray) {
            this(box2dArray, true);
        }

        public ArrayIterable(Box2dArray<T> box2dArray, boolean z) {
            this.array = box2dArray;
            this.allowRemove = z;
        }

        public Iterator<T> iterator() {
            if (this.iterator1 == null) {
                this.iterator1 = new ArrayIterator(this.array, this.allowRemove);
                this.iterator2 = new ArrayIterator(this.array, this.allowRemove);
            }
            if (!this.iterator1.valid) {
                ArrayIterator arrayIterator = this.iterator1;
                arrayIterator.index = 0;
                arrayIterator.valid = true;
                this.iterator2.valid = false;
                return arrayIterator;
            }
            ArrayIterator arrayIterator2 = this.iterator2;
            arrayIterator2.index = 0;
            arrayIterator2.valid = true;
            this.iterator1.valid = false;
            return arrayIterator2;
        }
    }
}

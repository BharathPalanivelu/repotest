package com.badlogic.gdx.physics.box2d.utils;

import java.util.Arrays;

public class Box2dLongArray {
    public long[] items;
    public boolean ordered;
    public int size;

    public Box2dLongArray() {
        this(true, 16);
    }

    public Box2dLongArray(int i) {
        this(true, i);
    }

    public Box2dLongArray(boolean z, int i) {
        this.ordered = z;
        this.items = new long[i];
    }

    public Box2dLongArray(Box2dLongArray box2dLongArray) {
        this.ordered = box2dLongArray.ordered;
        this.size = box2dLongArray.size;
        int i = this.size;
        this.items = new long[i];
        System.arraycopy(box2dLongArray.items, 0, this.items, 0, i);
    }

    public Box2dLongArray(long[] jArr) {
        this(true, jArr, 0, jArr.length);
    }

    public Box2dLongArray(boolean z, long[] jArr, int i, int i2) {
        this(z, i2);
        this.size = i2;
        System.arraycopy(jArr, i, this.items, 0, i2);
    }

    public void add(long j) {
        long[] jArr = this.items;
        int i = this.size;
        if (i == jArr.length) {
            jArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        this.size = i2 + 1;
        jArr[i2] = j;
    }

    public void add(long j, long j2) {
        long[] jArr = this.items;
        int i = this.size;
        if (i + 1 >= jArr.length) {
            jArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        jArr[i2] = j;
        jArr[i2 + 1] = j2;
        this.size = i2 + 2;
    }

    public void add(long j, long j2, long j3) {
        long[] jArr = this.items;
        int i = this.size;
        if (i + 2 >= jArr.length) {
            jArr = resize(Math.max(8, (int) (((float) i) * 1.75f)));
        }
        int i2 = this.size;
        jArr[i2] = j;
        jArr[i2 + 1] = j2;
        jArr[i2 + 2] = j3;
        this.size = i2 + 3;
    }

    public void add(long j, long j2, long j3, long j4) {
        long[] jArr = this.items;
        int i = this.size;
        if (i + 3 >= jArr.length) {
            jArr = resize(Math.max(8, (int) (((float) i) * 1.8f)));
        }
        int i2 = this.size;
        jArr[i2] = j;
        jArr[i2 + 1] = j2;
        jArr[i2 + 2] = j3;
        jArr[i2 + 3] = j4;
        this.size = i2 + 4;
    }

    public void addAll(Box2dLongArray box2dLongArray) {
        addAll(box2dLongArray.items, 0, box2dLongArray.size);
    }

    public void addAll(Box2dLongArray box2dLongArray, int i, int i2) {
        if (i + i2 <= box2dLongArray.size) {
            addAll(box2dLongArray.items, i, i2);
            return;
        }
        throw new IllegalArgumentException("offset + length must be <= size: " + i + " + " + i2 + " <= " + box2dLongArray.size);
    }

    public void addAll(long... jArr) {
        addAll(jArr, 0, jArr.length);
    }

    public void addAll(long[] jArr, int i, int i2) {
        long[] jArr2 = this.items;
        int i3 = this.size + i2;
        if (i3 > jArr2.length) {
            jArr2 = resize(Math.max(8, (int) (((float) i3) * 1.75f)));
        }
        System.arraycopy(jArr, i, jArr2, this.size, i2);
        this.size += i2;
    }

    public long get(int i) {
        if (i < this.size) {
            return this.items[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void set(int i, long j) {
        if (i < this.size) {
            this.items[i] = j;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void incr(int i, long j) {
        if (i < this.size) {
            long[] jArr = this.items;
            jArr[i] = jArr[i] + j;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void mul(int i, long j) {
        if (i < this.size) {
            long[] jArr = this.items;
            jArr[i] = jArr[i] * j;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void insert(int i, long j) {
        int i2 = this.size;
        if (i <= i2) {
            long[] jArr = this.items;
            if (i2 == jArr.length) {
                jArr = resize(Math.max(8, (int) (((float) i2) * 1.75f)));
            }
            if (this.ordered) {
                System.arraycopy(jArr, i, jArr, i + 1, this.size - i);
            } else {
                jArr[this.size] = jArr[i];
            }
            this.size++;
            jArr[i] = j;
            return;
        }
        throw new IndexOutOfBoundsException("index can't be > size: " + i + " > " + this.size);
    }

    public void swap(int i, int i2) {
        int i3 = this.size;
        if (i >= i3) {
            throw new IndexOutOfBoundsException("first can't be >= size: " + i + " >= " + this.size);
        } else if (i2 < i3) {
            long[] jArr = this.items;
            long j = jArr[i];
            jArr[i] = jArr[i2];
            jArr[i2] = j;
        } else {
            throw new IndexOutOfBoundsException("second can't be >= size: " + i2 + " >= " + this.size);
        }
    }

    public boolean contains(long j) {
        int i = this.size - 1;
        long[] jArr = this.items;
        while (i >= 0) {
            int i2 = i - 1;
            if (jArr[i] == j) {
                return true;
            }
            i = i2;
        }
        return false;
    }

    public int indexOf(long j) {
        long[] jArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (jArr[i2] == j) {
                return i2;
            }
        }
        return -1;
    }

    public int lastIndexOf(char c2) {
        long[] jArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            if (jArr[i] == ((long) c2)) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeValue(long j) {
        long[] jArr = this.items;
        int i = this.size;
        for (int i2 = 0; i2 < i; i2++) {
            if (jArr[i2] == j) {
                removeIndex(i2);
                return true;
            }
        }
        return false;
    }

    public long removeIndex(int i) {
        int i2 = this.size;
        if (i < i2) {
            long[] jArr = this.items;
            long j = jArr[i];
            this.size = i2 - 1;
            if (this.ordered) {
                System.arraycopy(jArr, i + 1, jArr, i, this.size - i);
            } else {
                jArr[i] = jArr[this.size];
            }
            return j;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.size);
    }

    public void removeRange(int i, int i2) {
        int i3 = this.size;
        if (i2 >= i3) {
            throw new IndexOutOfBoundsException("end can't be >= size: " + i2 + " >= " + this.size);
        } else if (i <= i2) {
            long[] jArr = this.items;
            int i4 = (i2 - i) + 1;
            if (this.ordered) {
                int i5 = i + i4;
                System.arraycopy(jArr, i5, jArr, i, i3 - i5);
            } else {
                int i6 = i3 - 1;
                for (int i7 = 0; i7 < i4; i7++) {
                    jArr[i + i7] = jArr[i6 - i7];
                }
            }
            this.size -= i4;
        } else {
            throw new IndexOutOfBoundsException("start can't be > end: " + i + " > " + i2);
        }
    }

    public boolean removeAll(Box2dLongArray box2dLongArray) {
        int i = this.size;
        long[] jArr = this.items;
        int i2 = box2dLongArray.size;
        int i3 = i;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = box2dLongArray.get(i4);
            int i5 = 0;
            while (true) {
                if (i5 >= i3) {
                    break;
                } else if (j == jArr[i5]) {
                    removeIndex(i5);
                    i3--;
                    break;
                } else {
                    i5++;
                }
            }
        }
        return i3 != i;
    }

    public long pop() {
        long[] jArr = this.items;
        int i = this.size - 1;
        this.size = i;
        return jArr[i];
    }

    public long peek() {
        return this.items[this.size - 1];
    }

    public long first() {
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
        this.size = 0;
    }

    public long[] shrink() {
        int length = this.items.length;
        int i = this.size;
        if (length != i) {
            resize(i);
        }
        return this.items;
    }

    public long[] ensureCapacity(int i) {
        if (i >= 0) {
            int i2 = this.size + i;
            if (i2 > this.items.length) {
                resize(Math.max(8, i2));
            }
            return this.items;
        }
        throw new IllegalArgumentException("additionalCapacity must be >= 0: " + i);
    }

    public long[] setSize(int i) {
        if (i >= 0) {
            if (i > this.items.length) {
                resize(Math.max(8, i));
            }
            this.size = i;
            return this.items;
        }
        throw new IllegalArgumentException("newSize must be >= 0: " + i);
    }

    /* access modifiers changed from: protected */
    public long[] resize(int i) {
        long[] jArr = new long[i];
        System.arraycopy(this.items, 0, jArr, 0, Math.min(this.size, jArr.length));
        this.items = jArr;
        return jArr;
    }

    public void sort() {
        Arrays.sort(this.items, 0, this.size);
    }

    public void reverse() {
        long[] jArr = this.items;
        int i = this.size;
        int i2 = i - 1;
        int i3 = i / 2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i2 - i4;
            long j = jArr[i4];
            jArr[i4] = jArr[i5];
            jArr[i5] = j;
        }
    }

    public void shuffle() {
        long[] jArr = this.items;
        for (int i = this.size - 1; i >= 0; i--) {
            int random = Box2dMathUtils.random(i);
            long j = jArr[i];
            jArr[i] = jArr[random];
            jArr[random] = j;
        }
    }

    public void truncate(int i) {
        if (this.size > i) {
            this.size = i;
        }
    }

    public long random() {
        int i = this.size;
        if (i == 0) {
            return 0;
        }
        return this.items[Box2dMathUtils.random(0, i - 1)];
    }

    public long[] toArray() {
        int i = this.size;
        long[] jArr = new long[i];
        System.arraycopy(this.items, 0, jArr, 0, i);
        return jArr;
    }

    public int hashCode() {
        if (!this.ordered) {
            return super.hashCode();
        }
        long[] jArr = this.items;
        int i = this.size;
        int i2 = 1;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + ((int) (jArr[i3] ^ (jArr[i3] >>> 32)));
        }
        return i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!this.ordered || !(obj instanceof Box2dLongArray)) {
            return false;
        }
        Box2dLongArray box2dLongArray = (Box2dLongArray) obj;
        if (!box2dLongArray.ordered) {
            return false;
        }
        int i = this.size;
        if (i != box2dLongArray.size) {
            return false;
        }
        long[] jArr = this.items;
        long[] jArr2 = box2dLongArray.items;
        for (int i2 = 0; i2 < i; i2++) {
            if (jArr[i2] != jArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
        long[] jArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append('[');
        sb.append(jArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(", ");
            sb.append(jArr[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    public String toString(String str) {
        if (this.size == 0) {
            return "";
        }
        long[] jArr = this.items;
        StringBuilder sb = new StringBuilder(32);
        sb.append(jArr[0]);
        for (int i = 1; i < this.size; i++) {
            sb.append(str);
            sb.append(jArr[i]);
        }
        return sb.toString();
    }

    public static Box2dLongArray with(long... jArr) {
        return new Box2dLongArray(jArr);
    }
}

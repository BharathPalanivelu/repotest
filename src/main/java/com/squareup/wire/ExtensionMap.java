package com.squareup.wire;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.squareup.wire.ExtendableMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class ExtensionMap<T extends ExtendableMessage<?>> {
    private static final int INITIAL_SIZE = 1;
    private Object[] data;
    private int size;

    public <E> ExtensionMap(Extension<T, E> extension, E e2) {
        this.data = new Object[2];
        Object[] objArr = this.data;
        objArr[0] = extension;
        objArr[1] = e2;
        this.size = 1;
    }

    public ExtensionMap(ExtensionMap<T> extensionMap) {
        this.data = (Object[]) extensionMap.data.clone();
        this.size = extensionMap.size;
    }

    public int size() {
        return this.size;
    }

    public Extension<T, ?> getExtension(int i) {
        if (i >= 0 && i < this.size) {
            return (Extension) this.data[i];
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public Object getExtensionValue(int i) {
        if (i >= 0) {
            int i2 = this.size;
            if (i < i2) {
                return this.data[i2 + i];
            }
        }
        throw new IndexOutOfBoundsException("" + i);
    }

    public List<Extension<T, ?>> getExtensions() {
        ArrayList arrayList = new ArrayList(this.size);
        for (int i = 0; i < this.size; i++) {
            arrayList.add((Extension) this.data[i]);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public <E> E get(Extension<T, E> extension) {
        int binarySearch = Arrays.binarySearch(this.data, 0, this.size, extension);
        if (binarySearch < 0) {
            return null;
        }
        return this.data[this.size + binarySearch];
    }

    public <E> void put(Extension<T, E> extension, E e2) {
        int binarySearch = Arrays.binarySearch(this.data, 0, this.size, extension);
        if (binarySearch >= 0) {
            this.data[this.size + binarySearch] = e2;
        } else {
            insert(extension, e2, -(binarySearch + 1));
        }
    }

    private <E> void insert(Extension<T, E> extension, E e2, int i) {
        Object[] objArr = this.data;
        if (objArr.length < (this.size + 1) * 2) {
            Object[] objArr2 = new Object[(objArr.length * 2)];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            objArr = objArr2;
        }
        int i2 = this.size;
        if (i < i2) {
            System.arraycopy(this.data, i2 + i, objArr, i2 + i + 2, i2 - i);
            System.arraycopy(this.data, i, objArr, i + 1, this.size);
        } else {
            System.arraycopy(this.data, i2, objArr, i2 + 1, i2);
        }
        this.size++;
        this.data = objArr;
        Object[] objArr3 = this.data;
        objArr3[i] = extension;
        objArr3[this.size + i] = e2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExtensionMap)) {
            return false;
        }
        ExtensionMap extensionMap = (ExtensionMap) obj;
        if (this.size != extensionMap.size) {
            return false;
        }
        for (int i = 0; i < this.size * 2; i++) {
            if (!this.data[i].equals(extensionMap.data[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = 0;
        for (int i2 = 0; i2 < this.size * 2; i2++) {
            i = (i * 37) + this.data[i2].hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        String str = "";
        int i = 0;
        while (i < this.size) {
            sb.append(str);
            sb.append(((Extension) this.data[i]).getTag());
            sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            sb.append(this.data[this.size + i]);
            i++;
            str = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}

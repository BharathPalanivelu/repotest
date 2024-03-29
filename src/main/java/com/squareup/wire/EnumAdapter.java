package com.squareup.wire;

import com.squareup.wire.ProtoEnum;
import java.util.Arrays;
import java.util.Comparator;

final class EnumAdapter<E extends ProtoEnum> {
    private static final Comparator<ProtoEnum> COMPARATOR = new Comparator<ProtoEnum>() {
        public int compare(ProtoEnum protoEnum, ProtoEnum protoEnum2) {
            return protoEnum.getValue() - protoEnum2.getValue();
        }
    };
    private final E[] constants;
    private final boolean isDense;
    private final Class<E> type;
    private final int[] values;

    EnumAdapter(Class<E> cls) {
        this.type = cls;
        this.constants = (ProtoEnum[]) cls.getEnumConstants();
        Arrays.sort(this.constants, COMPARATOR);
        E[] eArr = this.constants;
        int length = eArr.length;
        if (eArr[0].getValue() == 1 && this.constants[length - 1].getValue() == length) {
            this.isDense = true;
            this.values = null;
            return;
        }
        this.isDense = false;
        this.values = new int[length];
        for (int i = 0; i < length; i++) {
            this.values[i] = this.constants[i].getValue();
        }
    }

    public int toInt(E e2) {
        return e2.getValue();
    }

    public E fromInt(int i) {
        try {
            return this.constants[this.isDense ? i - 1 : Arrays.binarySearch(this.values, i)];
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("Unknown enum tag " + i + " for " + this.type.getCanonicalName());
        }
    }
}

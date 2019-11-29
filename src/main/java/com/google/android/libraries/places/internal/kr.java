package com.google.android.libraries.places.internal;

public enum kr {
    DOUBLE(0, ks.SCALAR, lf.DOUBLE),
    FLOAT(1, ks.SCALAR, lf.FLOAT),
    INT64(2, ks.SCALAR, lf.LONG),
    UINT64(3, ks.SCALAR, lf.LONG),
    INT32(4, ks.SCALAR, lf.INT),
    FIXED64(5, ks.SCALAR, lf.LONG),
    FIXED32(6, ks.SCALAR, lf.INT),
    BOOL(7, ks.SCALAR, lf.BOOLEAN),
    STRING(8, ks.SCALAR, lf.STRING),
    MESSAGE(9, ks.SCALAR, lf.MESSAGE),
    BYTES(10, ks.SCALAR, lf.BYTE_STRING),
    UINT32(11, ks.SCALAR, lf.INT),
    ENUM(12, ks.SCALAR, lf.ENUM),
    SFIXED32(13, ks.SCALAR, lf.INT),
    SFIXED64(14, ks.SCALAR, lf.LONG),
    SINT32(15, ks.SCALAR, lf.INT),
    SINT64(16, ks.SCALAR, lf.LONG),
    GROUP(17, ks.SCALAR, lf.MESSAGE),
    DOUBLE_LIST(18, ks.VECTOR, lf.DOUBLE),
    FLOAT_LIST(19, ks.VECTOR, lf.FLOAT),
    INT64_LIST(20, ks.VECTOR, lf.LONG),
    UINT64_LIST(21, ks.VECTOR, lf.LONG),
    INT32_LIST(22, ks.VECTOR, lf.INT),
    FIXED64_LIST(23, ks.VECTOR, lf.LONG),
    FIXED32_LIST(24, ks.VECTOR, lf.INT),
    BOOL_LIST(25, ks.VECTOR, lf.BOOLEAN),
    STRING_LIST(26, ks.VECTOR, lf.STRING),
    MESSAGE_LIST(27, ks.VECTOR, lf.MESSAGE),
    BYTES_LIST(28, ks.VECTOR, lf.BYTE_STRING),
    UINT32_LIST(29, ks.VECTOR, lf.INT),
    ENUM_LIST(30, ks.VECTOR, lf.ENUM),
    SFIXED32_LIST(31, ks.VECTOR, lf.INT),
    SFIXED64_LIST(32, ks.VECTOR, lf.LONG),
    SINT32_LIST(33, ks.VECTOR, lf.INT),
    SINT64_LIST(34, ks.VECTOR, lf.LONG),
    DOUBLE_LIST_PACKED(35, ks.PACKED_VECTOR, lf.DOUBLE),
    FLOAT_LIST_PACKED(36, ks.PACKED_VECTOR, lf.FLOAT),
    INT64_LIST_PACKED(37, ks.PACKED_VECTOR, lf.LONG),
    UINT64_LIST_PACKED(38, ks.PACKED_VECTOR, lf.LONG),
    INT32_LIST_PACKED(39, ks.PACKED_VECTOR, lf.INT),
    FIXED64_LIST_PACKED(40, ks.PACKED_VECTOR, lf.LONG),
    FIXED32_LIST_PACKED(41, ks.PACKED_VECTOR, lf.INT),
    BOOL_LIST_PACKED(42, ks.PACKED_VECTOR, lf.BOOLEAN),
    UINT32_LIST_PACKED(43, ks.PACKED_VECTOR, lf.INT),
    ENUM_LIST_PACKED(44, ks.PACKED_VECTOR, lf.ENUM),
    SFIXED32_LIST_PACKED(45, ks.PACKED_VECTOR, lf.INT),
    SFIXED64_LIST_PACKED(46, ks.PACKED_VECTOR, lf.LONG),
    SINT32_LIST_PACKED(47, ks.PACKED_VECTOR, lf.INT),
    SINT64_LIST_PACKED(48, ks.PACKED_VECTOR, lf.LONG),
    GROUP_LIST(49, ks.VECTOR, lf.MESSAGE),
    MAP(50, ks.MAP, lf.VOID);
    
    private static final kr[] ab = null;
    public final int h;
    public final ks i;

    private kr(int i2, ks ksVar, lf lfVar) {
        this.h = i2;
        this.i = ksVar;
        int ordinal = ksVar.ordinal();
        if (ordinal == 1) {
            Class<?> cls = lfVar.k;
        } else if (ordinal == 3) {
            Class<?> cls2 = lfVar.k;
        }
        if (ksVar == ks.SCALAR) {
            int ordinal2 = lfVar.ordinal();
            if (ordinal2 != 6 && ordinal2 != 7) {
            }
        }
    }

    static {
        int i2;
        kr[] values = values();
        ab = new kr[values.length];
        for (kr krVar : values) {
            ab[krVar.h] = krVar;
        }
    }
}

package com.google.android.gms.internal.icing;

import java.lang.reflect.Type;

public enum zzdk {
    DOUBLE(0, zzdm.SCALAR, zzdy.DOUBLE),
    FLOAT(1, zzdm.SCALAR, zzdy.FLOAT),
    INT64(2, zzdm.SCALAR, zzdy.LONG),
    UINT64(3, zzdm.SCALAR, zzdy.LONG),
    INT32(4, zzdm.SCALAR, zzdy.INT),
    FIXED64(5, zzdm.SCALAR, zzdy.LONG),
    FIXED32(6, zzdm.SCALAR, zzdy.INT),
    BOOL(7, zzdm.SCALAR, zzdy.BOOLEAN),
    STRING(8, zzdm.SCALAR, zzdy.STRING),
    MESSAGE(9, zzdm.SCALAR, zzdy.MESSAGE),
    BYTES(10, zzdm.SCALAR, zzdy.BYTE_STRING),
    UINT32(11, zzdm.SCALAR, zzdy.INT),
    ENUM(12, zzdm.SCALAR, zzdy.ENUM),
    SFIXED32(13, zzdm.SCALAR, zzdy.INT),
    SFIXED64(14, zzdm.SCALAR, zzdy.LONG),
    SINT32(15, zzdm.SCALAR, zzdy.INT),
    SINT64(16, zzdm.SCALAR, zzdy.LONG),
    GROUP(17, zzdm.SCALAR, zzdy.MESSAGE),
    DOUBLE_LIST(18, zzdm.VECTOR, zzdy.DOUBLE),
    FLOAT_LIST(19, zzdm.VECTOR, zzdy.FLOAT),
    INT64_LIST(20, zzdm.VECTOR, zzdy.LONG),
    UINT64_LIST(21, zzdm.VECTOR, zzdy.LONG),
    INT32_LIST(22, zzdm.VECTOR, zzdy.INT),
    FIXED64_LIST(23, zzdm.VECTOR, zzdy.LONG),
    FIXED32_LIST(24, zzdm.VECTOR, zzdy.INT),
    BOOL_LIST(25, zzdm.VECTOR, zzdy.BOOLEAN),
    STRING_LIST(26, zzdm.VECTOR, zzdy.STRING),
    MESSAGE_LIST(27, zzdm.VECTOR, zzdy.MESSAGE),
    BYTES_LIST(28, zzdm.VECTOR, zzdy.BYTE_STRING),
    UINT32_LIST(29, zzdm.VECTOR, zzdy.INT),
    ENUM_LIST(30, zzdm.VECTOR, zzdy.ENUM),
    SFIXED32_LIST(31, zzdm.VECTOR, zzdy.INT),
    SFIXED64_LIST(32, zzdm.VECTOR, zzdy.LONG),
    SINT32_LIST(33, zzdm.VECTOR, zzdy.INT),
    SINT64_LIST(34, zzdm.VECTOR, zzdy.LONG),
    DOUBLE_LIST_PACKED(35, zzdm.PACKED_VECTOR, zzdy.DOUBLE),
    FLOAT_LIST_PACKED(36, zzdm.PACKED_VECTOR, zzdy.FLOAT),
    INT64_LIST_PACKED(37, zzdm.PACKED_VECTOR, zzdy.LONG),
    UINT64_LIST_PACKED(38, zzdm.PACKED_VECTOR, zzdy.LONG),
    INT32_LIST_PACKED(39, zzdm.PACKED_VECTOR, zzdy.INT),
    FIXED64_LIST_PACKED(40, zzdm.PACKED_VECTOR, zzdy.LONG),
    FIXED32_LIST_PACKED(41, zzdm.PACKED_VECTOR, zzdy.INT),
    BOOL_LIST_PACKED(42, zzdm.PACKED_VECTOR, zzdy.BOOLEAN),
    UINT32_LIST_PACKED(43, zzdm.PACKED_VECTOR, zzdy.INT),
    ENUM_LIST_PACKED(44, zzdm.PACKED_VECTOR, zzdy.ENUM),
    SFIXED32_LIST_PACKED(45, zzdm.PACKED_VECTOR, zzdy.INT),
    SFIXED64_LIST_PACKED(46, zzdm.PACKED_VECTOR, zzdy.LONG),
    SINT32_LIST_PACKED(47, zzdm.PACKED_VECTOR, zzdy.INT),
    SINT64_LIST_PACKED(48, zzdm.PACKED_VECTOR, zzdy.LONG),
    GROUP_LIST(49, zzdm.VECTOR, zzdy.MESSAGE),
    MAP(50, zzdm.MAP, zzdy.VOID);
    
    private static final zzdk[] zzji = null;
    private static final Type[] zzjj = null;
    private final int id;
    private final zzdy zzje;
    private final zzdm zzjf;
    private final Class<?> zzjg;
    private final boolean zzjh;

    private zzdk(int i, zzdm zzdm, zzdy zzdy) {
        this.id = i;
        this.zzjf = zzdm;
        this.zzje = zzdy;
        int i2 = zzdn.zzjr[zzdm.ordinal()];
        if (i2 == 1) {
            this.zzjg = zzdy.zzca();
        } else if (i2 != 2) {
            this.zzjg = null;
        } else {
            this.zzjg = zzdy.zzca();
        }
        boolean z = false;
        if (zzdm == zzdm.SCALAR) {
            int i3 = zzdn.zzjs[zzdy.ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                z = true;
            }
        }
        this.zzjh = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i;
        zzjj = new Type[0];
        zzdk[] values = values();
        zzji = new zzdk[values.length];
        for (zzdk zzdk : values) {
            zzji[zzdk.id] = zzdk;
        }
    }
}

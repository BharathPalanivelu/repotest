package com.google.android.gms.internal.p000firebaseperf;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzel  reason: invalid package */
public enum zzel {
    DOUBLE(0, zzen.SCALAR, zzfc.DOUBLE),
    FLOAT(1, zzen.SCALAR, zzfc.FLOAT),
    INT64(2, zzen.SCALAR, zzfc.LONG),
    UINT64(3, zzen.SCALAR, zzfc.LONG),
    INT32(4, zzen.SCALAR, zzfc.INT),
    FIXED64(5, zzen.SCALAR, zzfc.LONG),
    FIXED32(6, zzen.SCALAR, zzfc.INT),
    BOOL(7, zzen.SCALAR, zzfc.BOOLEAN),
    STRING(8, zzen.SCALAR, zzfc.STRING),
    MESSAGE(9, zzen.SCALAR, zzfc.MESSAGE),
    BYTES(10, zzen.SCALAR, zzfc.BYTE_STRING),
    UINT32(11, zzen.SCALAR, zzfc.INT),
    ENUM(12, zzen.SCALAR, zzfc.ENUM),
    SFIXED32(13, zzen.SCALAR, zzfc.INT),
    SFIXED64(14, zzen.SCALAR, zzfc.LONG),
    SINT32(15, zzen.SCALAR, zzfc.INT),
    SINT64(16, zzen.SCALAR, zzfc.LONG),
    GROUP(17, zzen.SCALAR, zzfc.MESSAGE),
    DOUBLE_LIST(18, zzen.VECTOR, zzfc.DOUBLE),
    FLOAT_LIST(19, zzen.VECTOR, zzfc.FLOAT),
    INT64_LIST(20, zzen.VECTOR, zzfc.LONG),
    UINT64_LIST(21, zzen.VECTOR, zzfc.LONG),
    INT32_LIST(22, zzen.VECTOR, zzfc.INT),
    FIXED64_LIST(23, zzen.VECTOR, zzfc.LONG),
    FIXED32_LIST(24, zzen.VECTOR, zzfc.INT),
    BOOL_LIST(25, zzen.VECTOR, zzfc.BOOLEAN),
    STRING_LIST(26, zzen.VECTOR, zzfc.STRING),
    MESSAGE_LIST(27, zzen.VECTOR, zzfc.MESSAGE),
    BYTES_LIST(28, zzen.VECTOR, zzfc.BYTE_STRING),
    UINT32_LIST(29, zzen.VECTOR, zzfc.INT),
    ENUM_LIST(30, zzen.VECTOR, zzfc.ENUM),
    SFIXED32_LIST(31, zzen.VECTOR, zzfc.INT),
    SFIXED64_LIST(32, zzen.VECTOR, zzfc.LONG),
    SINT32_LIST(33, zzen.VECTOR, zzfc.INT),
    SINT64_LIST(34, zzen.VECTOR, zzfc.LONG),
    DOUBLE_LIST_PACKED(35, zzen.PACKED_VECTOR, zzfc.DOUBLE),
    FLOAT_LIST_PACKED(36, zzen.PACKED_VECTOR, zzfc.FLOAT),
    INT64_LIST_PACKED(37, zzen.PACKED_VECTOR, zzfc.LONG),
    UINT64_LIST_PACKED(38, zzen.PACKED_VECTOR, zzfc.LONG),
    INT32_LIST_PACKED(39, zzen.PACKED_VECTOR, zzfc.INT),
    FIXED64_LIST_PACKED(40, zzen.PACKED_VECTOR, zzfc.LONG),
    FIXED32_LIST_PACKED(41, zzen.PACKED_VECTOR, zzfc.INT),
    BOOL_LIST_PACKED(42, zzen.PACKED_VECTOR, zzfc.BOOLEAN),
    UINT32_LIST_PACKED(43, zzen.PACKED_VECTOR, zzfc.INT),
    ENUM_LIST_PACKED(44, zzen.PACKED_VECTOR, zzfc.ENUM),
    SFIXED32_LIST_PACKED(45, zzen.PACKED_VECTOR, zzfc.INT),
    SFIXED64_LIST_PACKED(46, zzen.PACKED_VECTOR, zzfc.LONG),
    SINT32_LIST_PACKED(47, zzen.PACKED_VECTOR, zzfc.INT),
    SINT64_LIST_PACKED(48, zzen.PACKED_VECTOR, zzfc.LONG),
    GROUP_LIST(49, zzen.VECTOR, zzfc.MESSAGE),
    MAP(50, zzen.MAP, zzfc.VOID);
    
    private static final zzel[] zzqa = null;
    private static final Type[] zzqb = null;
    private final int id;
    private final zzfc zzpw;
    private final zzen zzpx;
    private final Class<?> zzpy;
    private final boolean zzpz;

    private zzel(int i, zzen zzen, zzfc zzfc) {
        this.id = i;
        this.zzpx = zzen;
        this.zzpw = zzfc;
        int i2 = zzeo.zzqj[zzen.ordinal()];
        if (i2 == 1) {
            this.zzpy = zzfc.zzhv();
        } else if (i2 != 2) {
            this.zzpy = null;
        } else {
            this.zzpy = zzfc.zzhv();
        }
        boolean z = false;
        if (zzen == zzen.SCALAR) {
            int i3 = zzeo.zzqk[zzfc.ordinal()];
            if (!(i3 == 1 || i3 == 2 || i3 == 3)) {
                z = true;
            }
        }
        this.zzpz = z;
    }

    public final int id() {
        return this.id;
    }

    static {
        int i;
        zzqb = new Type[0];
        zzel[] values = values();
        zzqa = new zzel[values.length];
        for (zzel zzel : values) {
            zzqa[zzel.id] = zzel;
        }
    }
}

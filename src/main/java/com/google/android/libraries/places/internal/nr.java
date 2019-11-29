package com.google.android.libraries.places.internal;

public enum nr {
    DOUBLE(ns.DOUBLE, 1),
    FLOAT(ns.FLOAT, 5),
    INT64(ns.LONG, 0),
    UINT64(ns.LONG, 0),
    INT32(ns.INT, 0),
    FIXED64(ns.LONG, 1),
    FIXED32(ns.INT, 5),
    BOOL(ns.BOOLEAN, 0),
    STRING((String) ns.STRING, 2, (ns) 0),
    GROUP((String) ns.MESSAGE, 3, (ns) 0),
    MESSAGE((String) ns.MESSAGE, 2, (ns) 0),
    BYTES((String) ns.BYTE_STRING, 2, (ns) false),
    UINT32(ns.INT, 0),
    ENUM(ns.ENUM, 0),
    SFIXED32(ns.INT, 5),
    SFIXED64(ns.LONG, 1),
    SINT32(ns.INT, 0),
    SINT64(ns.LONG, 0);
    
    public final ns s;
    public final int t;

    private nr(ns nsVar, int i) {
        this.s = nsVar;
        this.t = i;
    }

    nr(ns nsVar, int i, char c2) {
        this(r7, 8, nsVar, 2, (byte) 0);
    }

    nr(ns nsVar, int i, short s2) {
        this(r7, 9, nsVar, 3, (byte) 0);
    }

    nr(ns nsVar, int i, int i2) {
        this(r7, 10, nsVar, 2, (byte) 0);
    }

    nr(ns nsVar, int i, boolean z) {
        this(r7, 11, nsVar, 2, (byte) 0);
    }
}

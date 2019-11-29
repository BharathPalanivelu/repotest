package com.google.c;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.IOException;

public final class ay {

    /* renamed from: a  reason: collision with root package name */
    static final int f13700a = a(1, 3);

    /* renamed from: b  reason: collision with root package name */
    static final int f13701b = a(1, 4);

    /* renamed from: c  reason: collision with root package name */
    static final int f13702c = a(2, 0);

    /* renamed from: d  reason: collision with root package name */
    static final int f13703d = a(3, 2);

    enum c {
        LOOSE {
            /* access modifiers changed from: package-private */
            public Object a(g gVar) throws IOException {
                return gVar.k();
            }
        },
        STRICT {
            /* access modifiers changed from: package-private */
            public Object a(g gVar) throws IOException {
                return gVar.l();
            }
        },
        LAZY {
            /* access modifiers changed from: package-private */
            public Object a(g gVar) throws IOException {
                return gVar.m();
            }
        };

        /* access modifiers changed from: package-private */
        public abstract Object a(g gVar) throws IOException;
    }

    public static int a(int i) {
        return i & 7;
    }

    static int a(int i, int i2) {
        return (i << 3) | i2;
    }

    public static int b(int i) {
        return i >>> 3;
    }

    public enum b {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(BitmapDescriptorFactory.HUE_RED)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(false),
        STRING(""),
        BYTE_STRING(f.f13707a),
        ENUM((String) null),
        MESSAGE((String) null);
        
        private final Object defaultDefault;

        private b(Object obj) {
            this.defaultDefault = obj;
        }
    }

    public enum a {
        DOUBLE(b.DOUBLE, 1),
        FLOAT(b.FLOAT, 5),
        INT64(b.LONG, 0),
        UINT64(b.LONG, 0),
        INT32(b.INT, 0),
        FIXED64(b.LONG, 1),
        FIXED32(b.INT, 5),
        BOOL(b.BOOLEAN, 0),
        STRING(b.STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(b.MESSAGE, 3) {
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(b.MESSAGE, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(b.BYTE_STRING, 2) {
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(b.INT, 0),
        ENUM(b.ENUM, 0),
        SFIXED32(b.INT, 5),
        SFIXED64(b.LONG, 1),
        SINT32(b.INT, 0),
        SINT64(b.LONG, 0);
        
        private final b javaType;
        private final int wireType;

        public boolean isPackable() {
            return true;
        }

        private a(b bVar, int i) {
            this.javaType = bVar;
            this.wireType = i;
        }

        public b getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }
    }

    static Object a(g gVar, a aVar, c cVar) throws IOException {
        switch (aVar) {
            case DOUBLE:
                return Double.valueOf(gVar.c());
            case FLOAT:
                return Float.valueOf(gVar.d());
            case INT64:
                return Long.valueOf(gVar.f());
            case UINT64:
                return Long.valueOf(gVar.e());
            case INT32:
                return Integer.valueOf(gVar.g());
            case FIXED64:
                return Long.valueOf(gVar.h());
            case FIXED32:
                return Integer.valueOf(gVar.i());
            case BOOL:
                return Boolean.valueOf(gVar.j());
            case BYTES:
                return gVar.m();
            case UINT32:
                return Integer.valueOf(gVar.n());
            case SFIXED32:
                return Integer.valueOf(gVar.p());
            case SFIXED64:
                return Long.valueOf(gVar.q());
            case SINT32:
                return Integer.valueOf(gVar.r());
            case SINT64:
                return Long.valueOf(gVar.s());
            case STRING:
                return cVar.a(gVar);
            case GROUP:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case MESSAGE:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case ENUM:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}

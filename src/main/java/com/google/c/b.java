package com.google.c;

import com.google.c.ad;
import com.google.c.b;
import com.google.c.b.a;
import com.google.c.f;
import java.io.IOException;

public abstract class b<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements ad {
    protected int memoizedHashCode = 0;

    public f d() {
        try {
            f.e b2 = f.b(b());
            a(b2.b());
            return b2.a();
        } catch (IOException e2) {
            throw new RuntimeException(a("ByteString"), e2);
        }
    }

    public byte[] e() {
        try {
            byte[] bArr = new byte[b()];
            h a2 = h.a(bArr);
            a(a2);
            a2.b();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(a("byte array"), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public as c() {
        return new as((ad) this);
    }

    private String a(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    public static abstract class a<MessageType extends b<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements ad.a {
        /* renamed from: b */
        public abstract BuilderType c(g gVar, p pVar) throws IOException;

        /* renamed from: d */
        public abstract BuilderType clone();

        public BuilderType b(g gVar) throws IOException {
            return c(gVar, p.e());
        }

        public BuilderType b(f fVar, p pVar) throws v {
            try {
                g f2 = fVar.f();
                c(f2, pVar);
                f2.a(0);
                return this;
            } catch (v e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(a("ByteString"), e3);
            }
        }

        /* renamed from: b */
        public BuilderType c(byte[] bArr) throws v {
            return b(bArr, 0, bArr.length);
        }

        public BuilderType b(byte[] bArr, int i, int i2) throws v {
            try {
                g a2 = g.a(bArr, i, i2);
                b(a2);
                a2.a(0);
                return this;
            } catch (v e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RuntimeException(a("byte array"), e3);
            }
        }

        private String a(String str) {
            return "Reading " + getClass().getName() + " from a " + str + " threw an IOException (should never happen).";
        }
    }
}

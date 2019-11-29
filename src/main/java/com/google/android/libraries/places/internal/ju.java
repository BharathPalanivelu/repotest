package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.internal.ju;
import com.google.android.libraries.places.internal.jv;
import java.io.IOException;

public abstract class ju<MessageType extends ju<MessageType, BuilderType>, BuilderType extends jv<MessageType, BuilderType>> implements ma {
    public int q = 0;

    public final kc b() {
        try {
            lu c2 = kc.c(h());
            a(c2.b());
            return c2.a();
        } catch (IOException e2) {
            throw new RuntimeException(a("ByteString"), e2);
        }
    }

    public final byte[] c() {
        try {
            byte[] bArr = new byte[h()];
            kk a2 = kk.a(bArr);
            a(a2);
            a2.i();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException(a("byte array"), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int d() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public final int a(mp mpVar) {
        int d2 = d();
        if (d2 != -1) {
            return d2;
        }
        int b2 = mpVar.b(this);
        a(b2);
        return b2;
    }

    private final String a(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf(str).length());
        sb.append("Serializing ");
        sb.append(name);
        sb.append(" to a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }
}

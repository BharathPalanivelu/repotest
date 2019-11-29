package com.franmontiel.persistentcookiejar.persistence;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import okhttp3.Cookie;

public class SerializableCookie implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7273a = "SerializableCookie";

    /* renamed from: c  reason: collision with root package name */
    private static long f7274c = -1;
    private static final long serialVersionUID = -8594045714036645534L;

    /* renamed from: b  reason: collision with root package name */
    private transient Cookie f7275b;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043 A[SYNTHETIC, Splitter:B:26:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(okhttp3.Cookie r6) {
        /*
            r5 = this;
            java.lang.String r0 = "Stream not closed in encodeCookie"
            r5.f7275b = r6
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream
            r6.<init>()
            r1 = 0
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r2.<init>(r6)     // Catch:{ IOException -> 0x002a, all -> 0x0027 }
            r2.writeObject(r5)     // Catch:{ IOException -> 0x0025 }
            r2.close()     // Catch:{ IOException -> 0x0016 }
            goto L_0x001c
        L_0x0016:
            r1 = move-exception
            java.lang.String r2 = f7273a
            android.util.Log.d(r2, r0, r1)
        L_0x001c:
            byte[] r6 = r6.toByteArray()
            java.lang.String r6 = a((byte[]) r6)
            return r6
        L_0x0025:
            r6 = move-exception
            goto L_0x002c
        L_0x0027:
            r6 = move-exception
            r2 = r1
            goto L_0x0041
        L_0x002a:
            r6 = move-exception
            r2 = r1
        L_0x002c:
            java.lang.String r3 = f7273a     // Catch:{ all -> 0x0040 }
            java.lang.String r4 = "IOException in encodeCookie"
            android.util.Log.d(r3, r4, r6)     // Catch:{ all -> 0x0040 }
            if (r2 == 0) goto L_0x003f
            r2.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003f
        L_0x0039:
            r6 = move-exception
            java.lang.String r2 = f7273a
            android.util.Log.d(r2, r0, r6)
        L_0x003f:
            return r1
        L_0x0040:
            r6 = move-exception
        L_0x0041:
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x004d
        L_0x0047:
            r1 = move-exception
            java.lang.String r2 = f7273a
            android.util.Log.d(r2, r0, r1)
        L_0x004d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.franmontiel.persistentcookiejar.persistence.SerializableCookie.a(okhttp3.Cookie):java.lang.String");
    }

    private static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            byte b3 = b2 & 255;
            if (b3 < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(b3));
        }
        return sb.toString();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f7275b.name());
        objectOutputStream.writeObject(this.f7275b.value());
        objectOutputStream.writeLong(this.f7275b.persistent() ? this.f7275b.expiresAt() : f7274c);
        objectOutputStream.writeObject(this.f7275b.domain());
        objectOutputStream.writeObject(this.f7275b.path());
        objectOutputStream.writeBoolean(this.f7275b.secure());
        objectOutputStream.writeBoolean(this.f7275b.httpOnly());
        objectOutputStream.writeBoolean(this.f7275b.hostOnly());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Cookie.Builder builder = new Cookie.Builder();
        builder.name((String) objectInputStream.readObject());
        builder.value((String) objectInputStream.readObject());
        long readLong = objectInputStream.readLong();
        if (readLong != f7274c) {
            builder.expiresAt(readLong);
        }
        String str = (String) objectInputStream.readObject();
        builder.domain(str);
        builder.path((String) objectInputStream.readObject());
        if (objectInputStream.readBoolean()) {
            builder.secure();
        }
        if (objectInputStream.readBoolean()) {
            builder.httpOnly();
        }
        if (objectInputStream.readBoolean()) {
            builder.hostOnlyDomain(str);
        }
        this.f7275b = builder.build();
    }
}

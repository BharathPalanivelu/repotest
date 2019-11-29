package com.shopee.app.util.d;

import com.jakewharton.a.a;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private com.jakewharton.a.a f26298a;

    /* renamed from: b  reason: collision with root package name */
    private int f26299b;

    private a(File file, int i, long j) throws IOException {
        this.f26299b = i;
        this.f26298a = com.jakewharton.a.a.a(file, i, 2, j);
    }

    public static synchronized a a(File file, int i, long j) throws IOException {
        a aVar;
        synchronized (a.class) {
            aVar = new a(file, i, j);
        }
        return aVar;
    }

    public b a(String str) throws IOException {
        a.c a2 = this.f26298a.a(b(str));
        if (a2 == null) {
            return null;
        }
        try {
            return new b(a2.b(0), a(a2));
        } finally {
            a2.close();
        }
    }

    public OutputStream a(String str, Map<String, ? extends Serializable> map) throws IOException {
        a.C0242a b2 = this.f26298a.b(b(str));
        try {
            a(map, b2);
            return new C0400a(new BufferedOutputStream(b2.a(0)), b2);
        } catch (IOException e2) {
            b2.b();
            throw e2;
        }
    }

    public void a(String str, String str2) throws IOException {
        a(str, str2, (Map<String, ? extends Serializable>) new HashMap());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r1, java.lang.String r2, java.util.Map<java.lang.String, ? extends java.io.Serializable> r3) throws java.io.IOException {
        /*
            r0 = this;
            java.io.OutputStream r1 = r0.a((java.lang.String) r1, (java.util.Map<java.lang.String, ? extends java.io.Serializable>) r3)     // Catch:{ all -> 0x0013 }
            byte[] r2 = r2.getBytes()     // Catch:{ all -> 0x0011 }
            r1.write(r2)     // Catch:{ all -> 0x0011 }
            if (r1 == 0) goto L_0x0010
            r1.close()
        L_0x0010:
            return
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r1 = 0
        L_0x0015:
            if (r1 == 0) goto L_0x001a
            r1.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.util.d.a.a(java.lang.String, java.lang.String, java.util.Map):void");
    }

    private void a(Map<String, ? extends Serializable> map, a.C0242a aVar) throws IOException {
        ObjectOutputStream objectOutputStream = null;
        try {
            ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new BufferedOutputStream(aVar.a(1)));
            try {
                objectOutputStream2.writeObject(map);
                a((Closeable) objectOutputStream2);
            } catch (Throwable th) {
                th = th;
                objectOutputStream = objectOutputStream2;
                a((Closeable) objectOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            a((Closeable) objectOutputStream);
            throw th;
        }
    }

    private Map<String, Serializable> a(a.c cVar) throws IOException {
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(new BufferedInputStream(cVar.a(1)));
            try {
                Map<String, Serializable> map = (Map) objectInputStream2.readObject();
                a((Closeable) objectInputStream2);
                return map;
            } catch (ClassNotFoundException e2) {
                e = e2;
                objectInputStream = objectInputStream2;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    th = th;
                    a((Closeable) objectInputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                a((Closeable) objectInputStream);
                throw th;
            }
        } catch (ClassNotFoundException e3) {
            e = e3;
            throw new RuntimeException(e);
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String b(String str) {
        return c(str);
    }

    private String c(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(str.getBytes("UTF-8"));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (NoSuchAlgorithmException unused) {
            throw new AssertionError();
        } catch (UnsupportedEncodingException unused2) {
            throw new AssertionError();
        }
    }

    /* renamed from: com.shopee.app.util.d.a$a  reason: collision with other inner class name */
    private class C0400a extends FilterOutputStream {

        /* renamed from: b  reason: collision with root package name */
        private final a.C0242a f26301b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f26302c;

        private C0400a(OutputStream outputStream, a.C0242a aVar) {
            super(outputStream);
            this.f26302c = false;
            this.f26301b = aVar;
        }

        public void close() throws IOException {
            try {
                super.close();
                e = null;
            } catch (IOException e2) {
                e = e2;
            }
            if (this.f26302c) {
                this.f26301b.b();
            } else {
                this.f26301b.a();
            }
            if (e != null) {
                throw e;
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e2) {
                this.f26302c = true;
                throw e2;
            }
        }

        public void write(int i) throws IOException {
            try {
                super.write(i);
            } catch (IOException e2) {
                this.f26302c = true;
                throw e2;
            }
        }

        public void write(byte[] bArr) throws IOException {
            try {
                super.write(bArr);
            } catch (IOException e2) {
                this.f26302c = true;
                throw e2;
            }
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                super.write(bArr, i, i2);
            } catch (IOException e2) {
                this.f26302c = true;
                throw e2;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final String f26303a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<String, Serializable> f26304b;

        public b(String str, Map<String, Serializable> map) {
            this.f26303a = str;
            this.f26304b = map;
        }

        public String a() {
            return this.f26303a;
        }
    }
}

package com.shopee.app.util.i;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import d.d.b.j;

public abstract class e {
    public abstract byte[] a(byte[] bArr, Tag tag) throws IllegalStateException;

    public abstract String[] a();

    private e() {
    }

    public /* synthetic */ e(g gVar) {
        this();
    }

    public static final class a extends e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f26378a = new a();

        private a() {
            super((g) null);
        }

        public String[] a() {
            String name = IsoDep.class.getName();
            j.a((Object) name, "IsoDep::class.java.name");
            return new String[]{name};
        }

        public byte[] a(byte[] bArr, Tag tag) {
            j.b(bArr, "command");
            j.b(tag, "tag");
            IsoDep isoDep = IsoDep.get(tag);
            if (isoDep != null) {
                try {
                    isoDep.connect();
                    byte[] transceive = isoDep.transceive(bArr);
                    j.a((Object) transceive, "tech.transceive(command)");
                    isoDep.close();
                    return transceive;
                } catch (Exception e2) {
                    throw e2;
                } catch (Throwable th) {
                    isoDep.close();
                    throw th;
                }
            } else {
                throw new IllegalStateException("Cannot handle this tag. Expected IsoDep but found " + tag);
            }
        }
    }
}

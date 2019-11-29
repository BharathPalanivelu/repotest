package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.h;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.a;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class m implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f11726a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f11727b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11728c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f11729d;

    public m(f fVar, byte[] bArr, byte[] bArr2) {
        this.f11726a = fVar;
        this.f11727b = bArr;
        this.f11728c = bArr2;
    }

    public long a(i iVar) throws IOException {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f11727b, "AES"), new IvParameterSpec(this.f11728c));
                this.f11729d = new CipherInputStream(new h(this.f11726a, iVar), instance);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void b() throws IOException {
        this.f11729d = null;
        this.f11726a.b();
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        a.b(this.f11729d != null);
        int read = this.f11729d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public Uri a() {
        return this.f11726a.a();
    }
}

package com.google.android.exoplayer2.source.c;

import android.net.Uri;
import com.google.android.exoplayer2.r.f;
import com.google.android.exoplayer2.r.h;
import com.google.android.exoplayer2.r.i;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f11587a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f11588b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f11589c;

    /* renamed from: d  reason: collision with root package name */
    private CipherInputStream f11590d;

    public a(f fVar, byte[] bArr, byte[] bArr2) {
        this.f11587a = fVar;
        this.f11588b = bArr;
        this.f11589c = bArr2;
    }

    public long a(i iVar) throws IOException {
        try {
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            try {
                instance.init(2, new SecretKeySpec(this.f11588b, "AES"), new IvParameterSpec(this.f11589c));
                this.f11590d = new CipherInputStream(new h(this.f11587a, iVar), instance);
                return -1;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }

    public void a() throws IOException {
        this.f11590d = null;
        this.f11587a.a();
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        com.google.android.exoplayer2.s.a.b(this.f11590d != null);
        int read = this.f11590d.read(bArr, i, i2);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    public Uri b() {
        return this.f11587a.b();
    }
}

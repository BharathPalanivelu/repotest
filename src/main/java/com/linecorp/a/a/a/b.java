package com.linecorp.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Object f14973a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final String f14974b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14975c;

    /* renamed from: d  reason: collision with root package name */
    private final SecureRandom f14976d;

    /* renamed from: e  reason: collision with root package name */
    private final SecretKeyFactory f14977e;

    /* renamed from: f  reason: collision with root package name */
    private final Cipher f14978f;

    /* renamed from: g  reason: collision with root package name */
    private final Mac f14979g;
    private a h;

    public b(String str) {
        this.f14974b = str;
        this.f14975c = 5000;
        try {
            this.f14976d = new SecureRandom();
            this.f14977e = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            this.f14978f = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.f14979g = Mac.getInstance("HmacSHA256");
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public final void a(Context context) {
        synchronized (this.f14973a) {
            if (this.h == null) {
                this.h = b(context);
            }
        }
    }

    public final String a(Context context, String str) {
        String encodeToString;
        synchronized (this.f14973a) {
            a(context);
            try {
                byte[] bArr = new byte[this.f14978f.getBlockSize()];
                this.f14976d.nextBytes(bArr);
                this.f14978f.init(1, this.h.f14980a, new IvParameterSpec(bArr));
                byte[] doFinal = this.f14978f.doFinal(str.getBytes("UTF-8"));
                byte[] bArr2 = new byte[(bArr.length + doFinal.length + 32)];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                int length = bArr.length + 0;
                System.arraycopy(doFinal, 0, bArr2, length, doFinal.length);
                this.f14979g.init(this.h.f14981b);
                this.f14979g.update(bArr2, 0, bArr.length + doFinal.length);
                byte[] doFinal2 = this.f14979g.doFinal();
                System.arraycopy(doFinal2, 0, bArr2, length + doFinal.length, doFinal2.length);
                encodeToString = Base64.encodeToString(bArr2, 0);
            } catch (BadPaddingException e2) {
                throw new a(e2);
            } catch (UnsupportedEncodingException e3) {
                e = e3;
                throw new RuntimeException(e);
            } catch (InvalidKeyException e4) {
                e = e4;
                throw new RuntimeException(e);
            } catch (IllegalBlockSizeException e5) {
                e = e5;
                throw new RuntimeException(e);
            } catch (InvalidAlgorithmParameterException e6) {
                e = e6;
                throw new RuntimeException(e);
            }
        }
        return encodeToString;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final SecretKey f14980a;

        /* renamed from: b  reason: collision with root package name */
        final SecretKey f14981b;

        a(SecretKey secretKey, SecretKey secretKey2) {
            this.f14980a = secretKey;
            this.f14981b = secretKey2;
        }
    }

    private a b(Context context) {
        byte[] bArr;
        String str = Build.MODEL + Build.MANUFACTURER + Build.SERIAL + Settings.Secure.getString(context.getContentResolver(), "android_id") + context.getPackageName();
        SharedPreferences sharedPreferences = context.getSharedPreferences(this.f14974b, 0);
        String string = sharedPreferences.getString("salt", (String) null);
        if (!TextUtils.isEmpty(string)) {
            bArr = Base64.decode(string, 0);
        } else {
            byte[] bArr2 = new byte[16];
            this.f14976d.nextBytes(bArr2);
            sharedPreferences.edit().putString("salt", Base64.encodeToString(bArr2, 0)).apply();
            bArr = bArr2;
        }
        try {
            byte[] encoded = this.f14977e.generateSecret(new PBEKeySpec(str.toCharArray(), bArr, this.f14975c, 512)).getEncoded();
            return new a(new SecretKeySpec(Arrays.copyOfRange(encoded, 0, 32), "AES"), new SecretKeySpec(Arrays.copyOfRange(encoded, 32, encoded.length), "HmacSHA256"));
        } catch (InvalidKeySpecException e2) {
            throw new RuntimeException(e2);
        }
    }
}

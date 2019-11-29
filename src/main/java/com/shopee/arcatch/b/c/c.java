package com.shopee.arcatch.b.c;

import android.util.Base64;
import com.garena.android.appkit.d.a;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f26687a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static String a(String str) {
        byte[] bytes = str.getBytes();
        try {
            SecretKeySpec b2 = b("1q61MtWOn3ccBJjf5Y2ZBE8ZZEQsQPqG");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            instance.init(1, b2, new IvParameterSpec(f26687a));
            byte[] doFinal = instance.doFinal(bytes);
            byte[] bArr = new byte[(f26687a.length + doFinal.length)];
            System.arraycopy(f26687a, 0, bArr, 0, f26687a.length);
            System.arraycopy(doFinal, 0, bArr, f26687a.length, doFinal.length);
            return Base64.encodeToString(bArr, 0);
        } catch (Exception e2) {
            a.a(e2);
            return null;
        }
    }

    private static SecretKeySpec b(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return new SecretKeySpec(str.getBytes("UTF-8"), "AES");
    }
}

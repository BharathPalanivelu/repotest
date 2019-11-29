package com.beetalk.sdk.e;

import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f5408a;

    public static byte[] a(String str) {
        try {
            return MessageDigest.getInstance(Hash.ALGORITHM_SHA256).digest(str.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        for (char c2 = '0'; c2 <= '9'; c2 = (char) (c2 + 1)) {
            sb.append(c2);
        }
        for (char c3 = 'a'; c3 <= 'z'; c3 = (char) (c3 + 1)) {
            sb.append(c3);
        }
        for (int i = 0; i < 10; i++) {
            sb.append("!@#$%^&*()".charAt(i));
        }
        f5408a = sb.toString().toCharArray();
    }

    public static String a(int i) {
        char[] cArr = new char[i];
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            char[] cArr2 = f5408a;
            cArr[i2] = cArr2[random.nextInt(cArr2.length)];
        }
        return new String(cArr);
    }

    public static String a() {
        return a(a(a(64)));
    }

    private static String a(byte[] bArr) {
        String str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = (str + "0123456789ABCDEF".charAt((bArr[i] >> 4) & 15)) + "0123456789ABCDEF".charAt(bArr[i] & 15);
        }
        return str;
    }
}

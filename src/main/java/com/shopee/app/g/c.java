package com.shopee.app.g;

import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class c {
    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(str.getBytes());
            return b(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(bArr);
            return b(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String b(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            cArr2[i] = cArr[(b2 >>> 4) & 15];
            i = i2 + 1;
            cArr2[i2] = cArr[b2 & 15];
        }
        return new String(cArr2);
    }

    public static byte[] c(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA256);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }

    public static String b(String str) {
        return b(c(str.getBytes()));
    }
}

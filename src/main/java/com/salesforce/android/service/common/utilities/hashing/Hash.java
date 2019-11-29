package com.salesforce.android.service.common.utilities.hashing;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.MessageDigest;

public class Hash {
    public static final String ALGORITHM_MD5 = "MD5";
    public static final String ALGORITHM_SHA1 = "SHA-1";
    public static final String ALGORITHM_SHA256 = "SHA-256";
    public static final String ALGORITHM_SHA512 = "SHA-512";
    private static final char[] hexArray = "0123456789abcdef".toCharArray();

    @Retention(RetentionPolicy.SOURCE)
    public @interface HashAlgorithm {
    }

    public static String sha1(String str) {
        return compute(str, ALGORITHM_SHA1);
    }

    public static String compute(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            byte[] bytes = str.getBytes("UTF-8");
            instance.update(bytes, 0, bytes.length);
            return bytesToHex(instance.digest());
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = hexArray;
            cArr[i2] = cArr2[b2 >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }
}

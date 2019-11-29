package com.litesuits.orm.db.assit;

import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Encrypt {
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String getMD2EncString(String str) {
        return getEncodeString(str, "MD2");
    }

    public static String getMD5EncString(String str) {
        return getEncodeString(str, Hash.ALGORITHM_MD5);
    }

    public static String getSHA1EncString(String str) {
        return getEncodeString(str, Hash.ALGORITHM_SHA1);
    }

    public static String getSHA256EncString(String str) {
        return getEncodeString(str, Hash.ALGORITHM_SHA256);
    }

    public static String getSHA384EncString(String str) {
        return getEncodeString(str, "SHA-384");
    }

    public static String getSHA512EncString(String str) {
        return getEncodeString(str, Hash.ALGORITHM_SHA512);
    }

    public static String getEncodeString(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(str.getBytes());
            char[] cArr = new char[(r8 * 2)];
            int i = 0;
            for (byte b2 : instance.digest()) {
                int i2 = i + 1;
                cArr[i] = hexDigits[(b2 >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = hexDigits[b2 & 15];
            }
            return new String(cArr);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static byte[] getEncodeBytes(String str, String str2) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            instance.update(str.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

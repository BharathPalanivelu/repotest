package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.g.a.a.g;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.security.MessageDigest;
import java.util.Formatter;

public final class y {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static String m213(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA1);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m212(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA1");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static String m210(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.reset();
            instance.update(str.getBytes("UTF-8"));
            return m212(instance.digest());
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to MD5");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static String m211(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA256);
            instance.update(str.getBytes());
            byte[] digest = instance.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b2 : digest) {
                stringBuffer.append(Integer.toString((b2 & 255) + g.BYTE, 16).substring(1));
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("Error turning ");
            sb.append(str.substring(0, 6));
            sb.append(".. to SHA-256");
            AFLogger.afErrorLog(sb.toString(), e2);
            return null;
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    private static String m212(byte[] bArr) {
        Formatter formatter = new Formatter();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            formatter.format("%02x", new Object[]{Byte.valueOf(bArr[i])});
        }
        String obj = formatter.toString();
        formatter.close();
        return obj;
    }
}

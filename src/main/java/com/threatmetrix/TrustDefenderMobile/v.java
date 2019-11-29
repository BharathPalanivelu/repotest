package com.threatmetrix.TrustDefenderMobile;

import android.util.Log;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

class v {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32622a = "v";

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f32623b = "0123456789abcdef".toCharArray();

    /* renamed from: c  reason: collision with root package name */
    private static final MessageDigest f32624c;

    /* renamed from: d  reason: collision with root package name */
    private static final MessageDigest f32625d;

    v() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    static {
        /*
            java.lang.String r0 = "0123456789abcdef"
            char[] r0 = r0.toCharArray()
            f32623b = r0
            com.threatmetrix.TrustDefenderMobile.NativeGatherer r0 = com.threatmetrix.TrustDefenderMobile.NativeGatherer.INSTANCE
            boolean r0 = r0.isAvailable()
            r1 = 0
            if (r0 != 0) goto L_0x0027
            java.lang.String r0 = f32622a
            java.lang.String r2 = "Getting SHA1 digest"
            android.util.Log.d(r0, r2)
            java.lang.String r0 = "SHA1"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x001f }
            goto L_0x0028
        L_0x001f:
            r0 = move-exception
            java.lang.String r2 = f32622a
            java.lang.String r3 = "SHA1 digest failed"
            android.util.Log.v(r2, r3, r0)
        L_0x0027:
            r0 = r1
        L_0x0028:
            f32625d = r0
            com.threatmetrix.TrustDefenderMobile.NativeGatherer r0 = com.threatmetrix.TrustDefenderMobile.NativeGatherer.INSTANCE
            boolean r0 = r0.isAvailable()
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = f32622a
            java.lang.String r2 = "Getting MD5 digest"
            android.util.Log.d(r0, r2)
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r1 = java.security.MessageDigest.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0040 }
            goto L_0x0048
        L_0x0040:
            r0 = move-exception
            java.lang.String r2 = f32622a
            java.lang.String r3 = "MD5 digest failed"
            android.util.Log.v(r2, r3, r0)
        L_0x0048:
            f32624c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.threatmetrix.TrustDefenderMobile.v.<clinit>():void");
    }

    static String a(String str) {
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.urlEncode(str);
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            Log.e(f32622a, "Failed url encoding", e2);
            return null;
        }
    }

    static String b(String str) {
        String a2;
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.md5(str);
        }
        MessageDigest messageDigest = f32624c;
        if (messageDigest == null) {
            return "";
        }
        synchronized (messageDigest) {
            f32624c.update(str.getBytes());
            byte[] digest = f32624c.digest();
            f32624c.reset();
            a2 = a(digest);
        }
        return a2;
    }

    static String c(String str) {
        String a2;
        if (str == null || str.isEmpty()) {
            return "";
        }
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.sha1(str);
        }
        MessageDigest messageDigest = f32625d;
        if (messageDigest == null) {
            return "";
        }
        synchronized (messageDigest) {
            f32625d.update(str.getBytes());
            byte[] digest = f32625d.digest();
            f32625d.reset();
            a2 = a(digest);
        }
        return a2;
    }

    static String a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b2 = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = f32623b;
            cArr[i2] = cArr2[b2 >>> 4];
            cArr[i2 + 1] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    static String a(String str, String str2) {
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.xor(str, str2);
        }
        String str3 = str.length() + "&";
        byte[] bArr = new byte[(str.length() + str3.length())];
        int length = str2.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < str3.length()) {
            int i4 = i2 + 1;
            int i5 = i3 + 1;
            bArr[i2] = (byte) ((((byte) str2.charAt(i3)) & 10) ^ ((byte) str3.charAt(i)));
            i3 = i5 >= length ? 0 : i5;
            i++;
            i2 = i4;
        }
        int i6 = 0;
        while (i6 < str.length()) {
            int i7 = i2 + 1;
            int i8 = i3 + 1;
            bArr[i2] = (byte) ((((byte) str2.charAt(i3)) & 10) ^ ((byte) str.charAt(i6)));
            i3 = i8 >= length ? 0 : i8;
            i6++;
            i2 = i7;
        }
        return a(bArr);
    }

    static String a() {
        Log.d(f32622a, "getting UUID");
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.getRandomString(32);
        }
        return UUID.randomUUID().toString().toLowerCase(Locale.US).replaceAll("-", "");
    }

    static List<String> b(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            int indexOf = str.indexOf(str2);
            if (indexOf == -1) {
                break;
            }
            if (indexOf > 1) {
                arrayList.add(str.substring(0, indexOf));
            }
            str = str.substring(indexOf + str2.length());
        }
        if (!str.isEmpty()) {
            arrayList.add(str);
        }
        return arrayList;
    }

    static Map<String, String> d(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String next : b(str, "&")) {
            int indexOf = next.indexOf(SimpleComparison.EQUAL_TO_OPERATION);
            try {
                linkedHashMap.put(URLDecoder.decode(next.substring(0, indexOf), "UTF-8"), URLDecoder.decode(next.substring(indexOf + 1), "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                Log.d(f32622a, "Unsupported encoding", e2);
            }
        }
        return linkedHashMap;
    }

    static String a(List<String> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (String next : list) {
            if (!next.isEmpty()) {
                if (sb.length() > 0) {
                    sb.append(str);
                }
                sb.append(next);
            }
        }
        return sb.toString();
    }
}

package com.shopee.app.util;

import android.util.Base64;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class bd {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f26238a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    private static String f26239b = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsI6Vs7jeoVElCiJQW3+rK9kI4\nwFf15ZhnhXrsoR0VAuwCERtDFvBExvWdR/TNgByyXHeExBEp/UIYAYSdui/W/2/i\nbhf/IvW647UMFwrTZXZPNCQR4+sU3iBt7dJacHo40OL33mb78uMy6jEkYk03uwbo\nGQmi1G4m+EjXjQbvDwIDAQAB";

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            instance.update(str.getBytes());
            return a(instance.digest());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static String a(byte[] bArr) {
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

    public static String b(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA256);
            instance.update(bArr);
            return a(instance.digest());
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String a() {
        return f26239b.replaceAll("\\n", "").replace("-----BEGIN PUBLIC KEY-----", "").replace("-----END PUBLIC KEY-----", "");
    }

    public static String c(byte[] bArr) {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(a(), 0)));
            Cipher instance = Cipher.getInstance("RSA/NONE/OAEPPadding");
            instance.init(1, generatePublic);
            return Base64.encodeToString(instance.doFinal(bArr), 2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static byte[] a(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance("AES/GCM/NoPadding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return instance.doFinal(bArr2);
    }

    public static SecretKeySpec b(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_SHA256);
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), "AES");
    }
}

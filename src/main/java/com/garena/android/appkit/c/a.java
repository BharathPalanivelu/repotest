package com.garena.android.appkit.c;

import java.io.UnsupportedEncodingException;

public class a {
    public static String a(byte[] bArr) {
        return b(bArr);
    }

    public static String b(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "Encoding Error - Unsupported String";
        }
    }
}

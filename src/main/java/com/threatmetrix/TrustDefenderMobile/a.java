package com.threatmetrix.TrustDefenderMobile;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32522a = "a";

    a() {
    }

    private static String a(String str) {
        if (NativeGatherer.INSTANCE.isAvailable()) {
            return NativeGatherer.INSTANCE.hashFile(str);
        }
        Log.d(f32522a, "Falling back to managed code for hashing");
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(Hash.ALGORITHM_MD5);
            try {
                FileInputStream fileInputStream = new FileInputStream(str);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (IOException e2) {
                        Log.e(f32522a, "Unable to process file for MD5", e2);
                        fileInputStream.close();
                    } catch (Throwable th) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            Log.e(f32522a, "Exception on closing MD5 input stream", e3);
                        }
                        throw th;
                    }
                }
                str2 = String.format("%32s", new Object[]{new BigInteger(1, instance.digest()).toString(16)}).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    Log.e(f32522a, "Exception on closing MD5 input stream", e4);
                }
                String str3 = f32522a;
                Log.d(str3, "Got : " + str2);
                return str2;
            } catch (FileNotFoundException e5) {
                Log.e(f32522a, "Exception while getting FileInputStream", e5);
                return null;
            }
        } catch (NoSuchAlgorithmException e6) {
            Log.e(f32522a, "Exception while getting digest", e6);
            return null;
        }
    }

    static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            return null;
        }
        String str = applicationInfo.sourceDir;
        String str2 = f32522a;
        Log.d(str2, "sourceDir: " + str);
        return a(str);
    }
}

package com.beetalk.sdk.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class b {
    public static Integer a(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                return Integer.valueOf(applicationInfo.metaData.getInt("com.garena.sdk.applicationId"));
            }
        } catch (Exception e2) {
            a.a(e2);
        }
        return -1;
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 64);
            if (packageInfo != null) {
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr != null && signatureArr.length > 0) {
                    try {
                        byte[] digest = MessageDigest.getInstance("SHA1").digest(signatureArr[0].toByteArray());
                        StringBuffer stringBuffer = new StringBuffer();
                        for (byte b2 : digest) {
                            String hexString = Integer.toHexString(b2 & 255);
                            if (stringBuffer.length() > 0) {
                                stringBuffer.append(":");
                            }
                            if (hexString.length() == 1) {
                                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            stringBuffer.append(hexString);
                        }
                        return stringBuffer.toString().toUpperCase();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                    }
                }
            }
            return null;
        } catch (PackageManager.NameNotFoundException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public static String c(Context context) {
        g.a(context, "context");
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getString(FacebookSdk.APPLICATION_ID_PROPERTY);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static int a() {
        return (int) (System.currentTimeMillis() / 1000);
    }

    public static String b() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        return replace.length() > 32 ? replace.substring(0, 32) : replace;
    }

    public static boolean d(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean e(Context context) {
        return context != null && context.checkCallingOrSelfPermission("android.permission.SEND_SMS") == 0;
    }
}

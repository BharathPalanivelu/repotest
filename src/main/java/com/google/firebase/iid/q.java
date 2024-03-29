package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.firebase.b;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Context f14170a;

    /* renamed from: b  reason: collision with root package name */
    private String f14171b;

    /* renamed from: c  reason: collision with root package name */
    private String f14172c;

    /* renamed from: d  reason: collision with root package name */
    private int f14173d;

    /* renamed from: e  reason: collision with root package name */
    private int f14174e = 0;

    public q(Context context) {
        this.f14170a = context;
    }

    public final synchronized int a() {
        if (this.f14174e != 0) {
            return this.f14174e;
        }
        PackageManager packageManager = this.f14170a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!PlatformVersion.isAtLeastO()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f14174e = 1;
                return this.f14174e;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (PlatformVersion.isAtLeastO()) {
                this.f14174e = 2;
            } else {
                this.f14174e = 1;
            }
            return this.f14174e;
        }
        this.f14174e = 2;
        return this.f14174e;
    }

    public static String a(b bVar) {
        String c2 = bVar.c().c();
        if (c2 != null) {
            return c2;
        }
        String b2 = bVar.c().b();
        if (!b2.startsWith("1:")) {
            return b2;
        }
        String[] split = b2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String a(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public final synchronized String b() {
        if (this.f14171b == null) {
            e();
        }
        return this.f14171b;
    }

    public final synchronized String c() {
        if (this.f14172c == null) {
            e();
        }
        return this.f14172c;
    }

    public final synchronized int d() {
        if (this.f14173d == 0) {
            PackageInfo a2 = a("com.google.android.gms");
            if (a2 != null) {
                this.f14173d = a2.versionCode;
            }
        }
        return this.f14173d;
    }

    private final synchronized void e() {
        PackageInfo a2 = a(this.f14170a.getPackageName());
        if (a2 != null) {
            this.f14171b = Integer.toString(a2.versionCode);
            this.f14172c = a2.versionName;
        }
    }

    private final PackageInfo a(String str) {
        try {
            return this.f14170a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }
}

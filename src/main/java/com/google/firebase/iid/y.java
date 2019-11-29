package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.b.a;
import androidx.core.content.b;
import java.io.File;
import java.io.IOException;
import java.util.Map;

final class y {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f14189a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f14190b;

    /* renamed from: c  reason: collision with root package name */
    private final bb f14191c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, ba> f14192d;

    public y(Context context) {
        this(context, new bb());
    }

    private y(Context context, bb bbVar) {
        this.f14192d = new a();
        this.f14190b = context;
        this.f14189a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f14191c = bbVar;
        File file = new File(b.b(this.f14190b), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !c()) {
                    Log.i("FirebaseInstanceId", "App restored, clearing state");
                    b();
                    FirebaseInstanceId.getInstance().e();
                }
            } catch (IOException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(valueOf) : new String("Error creating file in no backup dir: "));
                }
            }
        }
    }

    public final synchronized String a() {
        return this.f14189a.getString("topic_operation_queue", "");
    }

    public final synchronized void a(String str) {
        this.f14189a.edit().putString("topic_operation_queue", str).apply();
    }

    private final synchronized boolean c() {
        return this.f14189a.getAll().isEmpty();
    }

    private static String c(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("|S|");
        sb.append(str2);
        return sb.toString();
    }

    public final synchronized void b() {
        this.f14192d.clear();
        bb.a(this.f14190b);
        this.f14189a.edit().clear().commit();
    }

    public final synchronized ab a(String str, String str2, String str3) {
        return ab.a(this.f14189a.getString(c(str, str2, str3), (String) null));
    }

    public final synchronized void a(String str, String str2, String str3, String str4, String str5) {
        String a2 = ab.a(str4, str5, System.currentTimeMillis());
        if (a2 != null) {
            SharedPreferences.Editor edit = this.f14189a.edit();
            edit.putString(c(str, str2, str3), a2);
            edit.commit();
        }
    }

    public final synchronized void b(String str, String str2, String str3) {
        String c2 = c(str, str2, str3);
        SharedPreferences.Editor edit = this.f14189a.edit();
        edit.remove(c2);
        edit.commit();
    }

    public final synchronized ba b(String str) {
        ba baVar;
        ba baVar2 = this.f14192d.get(str);
        if (baVar2 != null) {
            return baVar2;
        }
        try {
            baVar = this.f14191c.a(this.f14190b, str);
        } catch (d unused) {
            Log.w("FirebaseInstanceId", "Stored data is corrupt, generating new identity");
            FirebaseInstanceId.getInstance().e();
            baVar = this.f14191c.b(this.f14190b, str);
        }
        this.f14192d.put(str, baVar);
        return baVar;
    }

    public final synchronized void c(String str) {
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.f14189a.edit();
        for (String next : this.f14189a.getAll().keySet()) {
            if (next.startsWith(concat)) {
                edit.remove(next);
            }
        }
        edit.commit();
    }
}

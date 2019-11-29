package com.google.firebase.iid;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

final class ab {

    /* renamed from: b  reason: collision with root package name */
    private static final long f14092b = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a  reason: collision with root package name */
    final String f14093a;

    /* renamed from: c  reason: collision with root package name */
    private final String f14094c;

    /* renamed from: d  reason: collision with root package name */
    private final long f14095d;

    private ab(String str, String str2, long j) {
        this.f14093a = str;
        this.f14094c = str2;
        this.f14095d = j;
    }

    static ab a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new ab(str, (String) null, 0);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new ab(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String a(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    static String a(ab abVar) {
        if (abVar == null) {
            return null;
        }
        return abVar.f14093a;
    }

    /* access modifiers changed from: package-private */
    public final boolean b(String str) {
        return System.currentTimeMillis() > this.f14095d + f14092b || !str.equals(this.f14094c);
    }
}

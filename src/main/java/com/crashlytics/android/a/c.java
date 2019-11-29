package com.crashlytics.android.a;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

class c {

    /* renamed from: a  reason: collision with root package name */
    final e f6310a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, Object> f6311b = new ConcurrentHashMap();

    public c(e eVar) {
        this.f6310a = eVar;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (!this.f6310a.a((Object) str, "key") && !this.f6310a.a((Object) str2, AppMeasurementSdk.ConditionalUserProperty.VALUE)) {
            a(this.f6310a.a(str), (Object) this.f6310a.a(str2));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, Object obj) {
        if (!this.f6310a.a(this.f6311b, str)) {
            this.f6311b.put(str, obj);
        }
    }

    public String toString() {
        return new JSONObject(this.f6311b).toString();
    }
}

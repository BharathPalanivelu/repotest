package com.shopee.app.util;

import android.content.SharedPreferences;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import d.d.b.j;
import java.util.LinkedHashSet;
import java.util.Set;

public final class bf {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f26241a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26242b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<String> f26243c;

    public bf(SharedPreferences sharedPreferences, String str) {
        this(sharedPreferences, str, (Set) null, 4, (g) null);
    }

    public bf(SharedPreferences sharedPreferences, String str, Set<String> set) {
        j.b(sharedPreferences, "preferences");
        j.b(str, "key");
        j.b(set, "defaultValue");
        this.f26241a = sharedPreferences;
        this.f26242b = str;
        this.f26243c = set;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ bf(SharedPreferences sharedPreferences, String str, Set set, int i, g gVar) {
        this(sharedPreferences, str, (i & 4) != 0 ? new LinkedHashSet() : set);
    }

    public final Set<String> a() {
        Set<String> stringSet = this.f26241a.getStringSet(this.f26242b, this.f26243c);
        return stringSet != null ? stringSet : this.f26243c;
    }

    public final void a(Set<String> set) {
        j.b(set, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        this.f26241a.edit().putStringSet(this.f26242b, set).apply();
    }

    public final void a(String str) {
        if (str != null) {
            Set<String> a2 = a();
            a2.add(str);
            a(a2);
        }
    }
}

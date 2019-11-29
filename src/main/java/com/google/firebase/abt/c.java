package com.google.firebase.abt;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f6753a = {"experimentId", "experimentStartTime", "timeToLiveMillis", "triggerTimeoutMillis", "variantId"};

    /* renamed from: b  reason: collision with root package name */
    private static final DateFormat f6754b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    /* renamed from: c  reason: collision with root package name */
    private final String f6755c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6756d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6757e;

    /* renamed from: f  reason: collision with root package name */
    private final Date f6758f;

    /* renamed from: g  reason: collision with root package name */
    private final long f6759g;
    private final long h;

    private c(String str, String str2, String str3, Date date, long j, long j2) {
        this.f6755c = str;
        this.f6756d = str2;
        this.f6757e = str3;
        this.f6758f = date;
        this.f6759g = j;
        this.h = j2;
    }

    static c a(Map<String, String> map) throws a {
        ArrayList arrayList = new ArrayList();
        for (String str : f6753a) {
            if (!map.containsKey(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            try {
                return new c(map.get("experimentId"), map.get("variantId"), map.containsKey("triggerEvent") ? map.get("triggerEvent") : "", f6754b.parse(map.get("experimentStartTime")), Long.parseLong(map.get("triggerTimeoutMillis")), Long.parseLong(map.get("timeToLiveMillis")));
            } catch (ParseException e2) {
                throw new a("Could not process experiment: parsing experiment start time failed.", e2);
            } catch (NumberFormatException e3) {
                throw new a("Could not process experiment: one of the durations could not be converted into a long.", e3);
            }
        } else {
            throw new a(String.format("The following keys are missing from the experiment info map: %s", new Object[]{arrayList}));
        }
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f6755c;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f6756d;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.f6757e;
    }

    /* access modifiers changed from: package-private */
    public final long d() {
        return this.f6758f.getTime();
    }

    /* access modifiers changed from: package-private */
    public final long e() {
        return this.f6759g;
    }

    /* access modifiers changed from: package-private */
    public final long f() {
        return this.h;
    }
}

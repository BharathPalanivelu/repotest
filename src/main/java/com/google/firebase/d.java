package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.StringResourceValueReader;
import com.google.android.gms.common.util.Strings;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f6891a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6892b;

    /* renamed from: c  reason: collision with root package name */
    private final String f6893c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6894d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6895e;

    /* renamed from: f  reason: collision with root package name */
    private final String f6896f;

    /* renamed from: g  reason: collision with root package name */
    private final String f6897g;

    private d(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        Preconditions.checkState(!Strings.isEmptyOrWhitespace(str), "ApplicationId must be set.");
        this.f6892b = str;
        this.f6891a = str2;
        this.f6893c = str3;
        this.f6894d = str4;
        this.f6895e = str5;
        this.f6896f = str6;
        this.f6897g = str7;
    }

    public static d a(Context context) {
        StringResourceValueReader stringResourceValueReader = new StringResourceValueReader(context);
        String string = stringResourceValueReader.getString("google_app_id");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return new d(string, stringResourceValueReader.getString("google_api_key"), stringResourceValueReader.getString("firebase_database_url"), stringResourceValueReader.getString("ga_trackingId"), stringResourceValueReader.getString("gcm_defaultSenderId"), stringResourceValueReader.getString("google_storage_bucket"), stringResourceValueReader.getString("project_id"));
    }

    public String a() {
        return this.f6891a;
    }

    public String b() {
        return this.f6892b;
    }

    public String c() {
        return this.f6895e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!Objects.equal(this.f6892b, dVar.f6892b) || !Objects.equal(this.f6891a, dVar.f6891a) || !Objects.equal(this.f6893c, dVar.f6893c) || !Objects.equal(this.f6894d, dVar.f6894d) || !Objects.equal(this.f6895e, dVar.f6895e) || !Objects.equal(this.f6896f, dVar.f6896f) || !Objects.equal(this.f6897g, dVar.f6897g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.f6892b, this.f6891a, this.f6893c, this.f6894d, this.f6895e, this.f6896f, this.f6897g);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("applicationId", this.f6892b).add("apiKey", this.f6891a).add("databaseUrl", this.f6893c).add("gcmSenderId", this.f6895e).add("storageBucket", this.f6896f).add("projectId", this.f6897g).toString();
    }
}

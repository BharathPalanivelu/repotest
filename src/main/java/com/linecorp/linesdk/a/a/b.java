package com.linecorp.linesdk.a.a;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.AccessToken;
import com.linecorp.linesdk.a.e;
import com.linecorp.linesdk.a.f;
import com.linecorp.linesdk.a.g;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final com.linecorp.linesdk.a.a.a.c<f> f15012a = new C0245b((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    public static final com.linecorp.linesdk.a.a.a.c<e> f15013b = new a((byte) 0);

    /* renamed from: c  reason: collision with root package name */
    public static final com.linecorp.linesdk.a.a.a.c<com.linecorp.linesdk.a.b> f15014c = new d((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    public static final com.linecorp.linesdk.a.a.a.c<g> f15015d = new c((byte) 0);

    /* renamed from: e  reason: collision with root package name */
    public static final com.linecorp.linesdk.a.a.a.c<?> f15016e = new c();

    /* renamed from: f  reason: collision with root package name */
    public final Uri f15017f;

    /* renamed from: g  reason: collision with root package name */
    public final com.linecorp.linesdk.a.a.a.a f15018g;

    public b(Context context, Uri uri) {
        this(uri, new com.linecorp.linesdk.a.a.a.a(context, "4.0.8"));
    }

    private b(Uri uri, com.linecorp.linesdk.a.a.a.a aVar) {
        this.f15017f = uri;
        this.f15018g = aVar;
    }

    /* renamed from: com.linecorp.linesdk.a.a.b$b  reason: collision with other inner class name */
    private static class C0245b extends a<f> {
        private C0245b() {
        }

        /* synthetic */ C0245b(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ Object a(JSONObject jSONObject) {
            return new f(jSONObject.getString("otpId"), jSONObject.getString("otp"));
        }
    }

    private static class a extends a<e> {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ Object a(JSONObject jSONObject) {
            List list;
            String string = jSONObject.getString("token_type");
            if ("Bearer".equals(string)) {
                String optString = jSONObject.optString("scope");
                com.linecorp.linesdk.a.d dVar = new com.linecorp.linesdk.a.d(jSONObject.getString("access_token"), jSONObject.getLong(AccessToken.EXPIRES_IN_KEY) * 1000, System.currentTimeMillis(), jSONObject.getString("refresh_token"));
                if (TextUtils.isEmpty(optString)) {
                    list = Collections.emptyList();
                } else {
                    list = Arrays.asList(optString.split(SQLBuilder.BLANK));
                }
                return new e(dVar, list);
            }
            throw new JSONException("Illegal token type. token_type=" + string);
        }
    }

    private static class d extends a<com.linecorp.linesdk.a.b> {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ Object a(JSONObject jSONObject) {
            List list;
            String optString = jSONObject.optString("scope");
            String string = jSONObject.getString("client_id");
            long j = jSONObject.getLong(AccessToken.EXPIRES_IN_KEY) * 1000;
            if (TextUtils.isEmpty(optString)) {
                list = Collections.emptyList();
            } else {
                list = Arrays.asList(optString.split(SQLBuilder.BLANK));
            }
            return new com.linecorp.linesdk.a.b(string, j, list);
        }
    }

    private static class c extends a<g> {
        private c() {
        }

        /* synthetic */ c(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ Object a(JSONObject jSONObject) {
            String string = jSONObject.getString("token_type");
            if ("Bearer".equals(string)) {
                return new g(jSONObject.getString("access_token"), jSONObject.getLong(AccessToken.EXPIRES_IN_KEY) * 1000, jSONObject.optString("refresh_token"));
            }
            throw new JSONException("Illegal token type. token_type=" + string);
        }
    }
}

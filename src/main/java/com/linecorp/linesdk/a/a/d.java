package com.linecorp.linesdk.a.a;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.common.Scopes;
import com.linecorp.linesdk.LineProfile;
import com.linecorp.linesdk.a.a.a.c;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.Collections;
import java.util.HashMap;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final c<LineProfile> f15020a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final Uri f15021b;

    /* renamed from: c  reason: collision with root package name */
    private final com.linecorp.linesdk.a.a.a.a f15022c;

    public d(Context context, Uri uri) {
        this(uri, new com.linecorp.linesdk.a.a.a.a(context, "4.0.8"));
    }

    private d(Uri uri, com.linecorp.linesdk.a.a.a.a aVar) {
        this.f15021b = uri;
        this.f15022c = aVar;
    }

    public final com.linecorp.linesdk.a<LineProfile> a(com.linecorp.linesdk.a.d dVar) {
        Uri build = this.f15021b.buildUpon().appendPath(Scopes.PROFILE).build();
        HashMap hashMap = new HashMap(1);
        hashMap.put(HttpConstants.Header.AUTHORIZATION, "Bearer " + dVar.f15029a);
        return this.f15022c.b(build, hashMap, Collections.emptyMap(), f15020a);
    }

    static class a extends a<LineProfile> {
        a() {
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ Object a(JSONObject jSONObject) {
            Uri uri;
            String optString = jSONObject.optString("pictureUrl", (String) null);
            String string = jSONObject.getString("userId");
            String string2 = jSONObject.getString("displayName");
            if (optString == null) {
                uri = null;
            } else {
                uri = Uri.parse(optString);
            }
            return new LineProfile(string, string2, uri, jSONObject.optString("statusMessage", (String) null));
        }
    }
}

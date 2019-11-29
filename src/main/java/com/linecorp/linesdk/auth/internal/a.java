package com.linecorp.linesdk.auth.internal;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.linecorp.linesdk.LineApiError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

final class a {

    /* renamed from: a  reason: collision with root package name */
    static final b f15060a = new b(6, 9, 0);

    /* renamed from: b  reason: collision with root package name */
    final d f15061b;

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final Intent f15065a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f15066b;

        /* renamed from: c  reason: collision with root package name */
        final String f15067c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f15068d;

        b(Intent intent, Bundle bundle, String str, boolean z) {
            this.f15065a = intent;
            this.f15066b = bundle;
            this.f15067c = str;
            this.f15068d = z;
        }
    }

    a(d dVar) {
        this.f15061b = dVar;
    }

    static List<Intent> a(Uri uri, Collection<ResolveInfo> collection, Bundle bundle) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (ResolveInfo resolveInfo : collection) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setPackage(resolveInfo.activityInfo.packageName);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            arrayList.add(intent);
        }
        return arrayList;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        final String f15069a;

        /* renamed from: b  reason: collision with root package name */
        private final String f15070b;

        /* renamed from: c  reason: collision with root package name */
        private final String f15071c;

        /* renamed from: d  reason: collision with root package name */
        private final String f15072d;

        c(String str, String str2, String str3, String str4) {
            this.f15069a = str;
            this.f15070b = str2;
            this.f15071c = str3;
            this.f15072d = str4;
        }

        static c a(String str) {
            return new c((String) null, (String) null, (String) null, str);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return !TextUtils.isEmpty(this.f15069a);
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return TextUtils.isEmpty(this.f15072d) && !a();
        }

        /* access modifiers changed from: package-private */
        public final LineApiError c() {
            if (!b()) {
                return new LineApiError(this.f15072d);
            }
            try {
                return new LineApiError(new JSONObject().putOpt("error", this.f15070b).putOpt(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION, this.f15071c).toString());
            } catch (JSONException e2) {
                return new LineApiError((Exception) e2);
            }
        }
    }

    /* renamed from: com.linecorp.linesdk.auth.internal.a$a  reason: collision with other inner class name */
    static class C0246a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f15062a;

        /* renamed from: b  reason: collision with root package name */
        final Bundle f15063b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f15064c;

        C0246a(Intent intent, Bundle bundle, boolean z) {
            this.f15062a = intent;
            this.f15063b = bundle;
            this.f15064c = z;
        }
    }
}

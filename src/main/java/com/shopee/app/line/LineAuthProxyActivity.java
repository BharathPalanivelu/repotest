package com.shopee.app.line;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.shopee.app.util.e;
import com.shopee.app.util.i;
import d.d.b.j;

public final class LineAuthProxyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    public static final a f17768a = new a((g) null);

    /* renamed from: b  reason: collision with root package name */
    private static final String f17769b;

    public static final void a(Activity activity) {
        f17768a.a(activity);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent a2 = com.linecorp.linesdk.auth.a.a(this, f17769b);
        j.a((Object) a2, "LineLoginApi.getLoginIntent(this, LINE_CHANNEL_ID)");
        startActivityForResult(a2, 1912);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004f, code lost:
        if (r1 != null) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            super.onActivityResult(r4, r5, r6)
            com.linecorp.linesdk.auth.LineLoginResult r4 = com.linecorp.linesdk.auth.a.a(r6)
            java.lang.String r5 = "LineLoginApi.getLoginResultFromIntent(data)"
            d.d.b.j.a((java.lang.Object) r4, (java.lang.String) r5)
            com.linecorp.linesdk.b r5 = r4.a()
            int[] r6 = com.shopee.app.line.b.f17770a
            int r5 = r5.ordinal()
            r5 = r6[r5]
            r6 = 1
            if (r5 == r6) goto L_0x001c
            goto L_0x0070
        L_0x001c:
            com.linecorp.linesdk.LineCredential r5 = r4.c()
            com.linecorp.linesdk.LineProfile r4 = r4.b()
            if (r5 == 0) goto L_0x0070
            if (r4 == 0) goto L_0x0070
            com.shopee.app.line.a r6 = new com.shopee.app.line.a
            com.linecorp.linesdk.LineAccessToken r5 = r5.a()
            java.lang.String r0 = "lineCredential.accessToken"
            d.d.b.j.a((java.lang.Object) r5, (java.lang.String) r0)
            java.lang.String r5 = r5.a()
            java.lang.String r0 = "lineCredential.accessToken.accessToken"
            d.d.b.j.a((java.lang.Object) r5, (java.lang.String) r0)
            java.lang.String r0 = r4.b()
            java.lang.String r1 = "lineProfile.userId"
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            android.net.Uri r1 = r4.c()
            if (r1 == 0) goto L_0x0052
            java.lang.String r1 = r1.toString()
            if (r1 == 0) goto L_0x0052
            goto L_0x0054
        L_0x0052:
            java.lang.String r1 = ""
        L_0x0054:
            java.lang.String r4 = r4.a()
            java.lang.String r2 = "lineProfile.displayName"
            d.d.b.j.a((java.lang.Object) r4, (java.lang.String) r2)
            r6.<init>(r5, r0, r1, r4)
            android.content.Intent r4 = new android.content.Intent
            r4.<init>()
            java.io.Serializable r6 = (java.io.Serializable) r6
            java.lang.String r5 = "data"
            r4.putExtra(r5, r6)
            r5 = -1
            r3.setResult(r5, r4)
        L_0x0070:
            r3.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.line.LineAuthProxyActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Activity activity) {
            j.b(activity, "activity");
            activity.startActivityForResult(new Intent(activity, LineAuthProxyActivity.class), 30);
        }
    }

    static {
        String str;
        if (e.c()) {
            str = i.h;
        } else {
            str = e.a() ? "1624137833" : "1624209101";
        }
        f17769b = str;
    }
}

package com.shopee.app.react.debug;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import com.garena.android.appkit.tools.a.b;
import com.garena.reactpush.data.ReactBundle;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.react.a.a;
import com.shopee.app.react.b.c;
import com.shopee.app.react.g;
import com.shopee.app.ui.a.b;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.util.af;
import com.shopee.app.util.x;
import io.b.q;
import io.b.r;
import io.b.t;
import java.util.List;

public class ReactDebugActivity extends b implements x<c> {

    /* renamed from: a  reason: collision with root package name */
    g f18643a;

    /* renamed from: b  reason: collision with root package name */
    a f18644b;

    /* renamed from: c  reason: collision with root package name */
    com.garena.reactpush.b.b f18645c;

    /* renamed from: d  reason: collision with root package name */
    c f18646d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f18647e = "undefined";

    /* renamed from: f  reason: collision with root package name */
    private TextView f18648f;

    /* renamed from: g  reason: collision with root package name */
    private io.b.b.a f18649g = new io.b.b.a();

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        this.f18648f = new TextView(this);
        this.f18648f.setPadding(b.a.k, b.a.k, b.a.k, b.a.k);
        this.f18648f.setMovementMethod(LinkMovementMethod.getInstance());
        this.f18648f.setHorizontallyScrolling(true);
        this.f18648f.setTypeface(Typeface.MONOSPACE);
        this.f18648f.setAutoLinkMask(1);
        a((View) this.f18648f);
        c();
        p();
    }

    /* access modifiers changed from: private */
    public void c() {
        TextView textView = this.f18648f;
        textView.setText("Local Manifest " + l() + " \n\n" + this.f18643a.toString() + "\n\n" + this.f18644b.toString());
    }

    private String l() {
        List<ReactBundle> bundles = this.f18645c.a().getBundles();
        if (af.a(bundles)) {
            return "NONE";
        }
        return "{\n\tname=" + bundles.get(0).getName() + "\n\tmd5=" + bundles.get(0).getMd5() + "\n\tbundleType=" + this.f18647e + "\n}";
    }

    @SuppressLint({"CheckResult"})
    private void p() {
        this.f18649g.a(q.a(new t() {
            public final void subscribe(r rVar) {
                ReactDebugActivity.this.a(rVar);
            }
        }).b(io.b.h.a.b()).a(io.b.a.b.a.a()).a(new io.b.d.b<Boolean, Throwable>() {
            public void a(Boolean bool, Throwable th) throws Exception {
                if (bool.booleanValue()) {
                    String unused = ReactDebugActivity.this.f18647e = "text-bundle";
                } else {
                    String unused2 = ReactDebugActivity.this.f18647e = "binary-bundle";
                }
                ReactDebugActivity.this.c();
            }
        }));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(io.b.r r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.shopee.app.react.g r0 = r8.f18643a
            com.shopee.app.react.b.d r0 = r0.e()
            com.garena.reactpush.e.c.a r0 = r0.d()
            java.lang.String r0 = r0.d()
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            r2 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            if (r0 != 0) goto L_0x0022
            r9.a(r3)
            return
        L_0x0022:
            r0 = 0
            r4 = 1
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0060, all -> 0x005c }
            r5.<init>(r1)     // Catch:{ Exception -> 0x0060, all -> 0x005c }
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0057, all -> 0x0054 }
        L_0x002e:
            r0 = 10
            if (r2 >= r0) goto L_0x0047
            int r0 = r1.read()     // Catch:{ Exception -> 0x0052 }
            r6 = 127(0x7f, float:1.78E-43)
            if (r0 <= r6) goto L_0x0044
            r9.a(r3)     // Catch:{ Exception -> 0x0052 }
            r1.close()
            r5.close()
            return
        L_0x0044:
            int r2 = r2 + 1
            goto L_0x002e
        L_0x0047:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)     // Catch:{ Exception -> 0x0052 }
            r9.a(r0)     // Catch:{ Exception -> 0x0052 }
            r1.close()
            goto L_0x0075
        L_0x0052:
            r0 = move-exception
            goto L_0x0064
        L_0x0054:
            r9 = move-exception
            r1 = r0
            goto L_0x007a
        L_0x0057:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0064
        L_0x005c:
            r9 = move-exception
            r1 = r0
            r5 = r1
            goto L_0x007a
        L_0x0060:
            r1 = move-exception
            r5 = r0
            r0 = r1
            r1 = r5
        L_0x0064:
            r0.printStackTrace()     // Catch:{ all -> 0x0079 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x0079 }
            r9.a(r0)     // Catch:{ all -> 0x0079 }
            if (r1 == 0) goto L_0x0073
            r1.close()
        L_0x0073:
            if (r5 == 0) goto L_0x0078
        L_0x0075:
            r5.close()
        L_0x0078:
            return
        L_0x0079:
            r9 = move-exception
        L_0x007a:
            if (r1 == 0) goto L_0x007f
            r1.close()
        L_0x007f:
            if (r5 == 0) goto L_0x0084
            r5.close()
        L_0x0084:
            goto L_0x0086
        L_0x0085:
            throw r9
        L_0x0086:
            goto L_0x0085
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.react.debug.ReactDebugActivity.a(io.b.r):void");
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f18649g.dispose();
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        super.a(aVar);
        aVar.f(1).a("React Bundle Info").e(0);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.f18646d = com.shopee.app.react.b.a.c().a(g.a().e()).a(new com.shopee.app.a.b(this)).a();
        this.f18646d.a(this);
    }

    /* renamed from: a */
    public c b() {
        return this.f18646d;
    }
}

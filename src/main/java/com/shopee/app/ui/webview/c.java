package com.shopee.app.ui.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.appuser.UserComponent;
import com.shopee.app.data.viewmodel.WebPageModel;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import com.shopee.app.tracking.b.d;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.a.q;
import com.shopee.app.ui.actionbar.a;
import com.shopee.app.ui.common.au;
import com.shopee.app.ui.common.ay;
import com.shopee.app.ui.dialog.a;
import com.shopee.app.util.bi;
import com.shopee.app.util.x;
import com.shopee.app.util.y;
import com.shopee.app.web.bridge.WebBridge;
import com.shopee.app.web.protocol.SearchConfig;
import com.shopee.app.web.protocol.ShowPopUpMessage;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class c extends com.shopee.app.ui.a.b implements com.shopee.a.b.b, x<e>, y {
    private static ConcurrentHashMap<String, b> Q = new ConcurrentHashMap<>();
    private ShowPopUpMessage.PopUp H;
    private d I;
    /* access modifiers changed from: private */
    public au J;
    private e K;
    private a L = null;
    private com.shopee.app.ui.home.d.d M = new com.shopee.app.ui.home.d.d();
    private com.shopee.app.util.a.b N = new com.shopee.app.util.a.b();
    private boolean O = false;
    private boolean P = false;

    /* renamed from: a  reason: collision with root package name */
    bi f7021a;

    /* renamed from: b  reason: collision with root package name */
    WebBridge f7022b;

    /* renamed from: c  reason: collision with root package name */
    String f7023c;

    /* renamed from: d  reason: collision with root package name */
    boolean f7024d;

    /* renamed from: e  reason: collision with root package name */
    String f7025e;

    /* renamed from: f  reason: collision with root package name */
    String f7026f;

    /* renamed from: g  reason: collision with root package name */
    String f7027g;
    String h;
    String i;
    String j;
    String k;
    int l;
    String m;
    private View n;

    public boolean b(int i2) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean k() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean u() {
        return true;
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public ViewGroup f25837a;

        /* renamed from: b  reason: collision with root package name */
        public int f25838b;

        /* renamed from: c  reason: collision with root package name */
        public int f25839c;

        /* renamed from: d  reason: collision with root package name */
        public ImageView f25840d;

        private a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f25841a;

        /* renamed from: b  reason: collision with root package name */
        public String f25842b;

        /* renamed from: c  reason: collision with root package name */
        public g f25843c;

        public b(String str, String str2, g gVar) {
            this.f25841a = str;
            this.f25842b = str2;
            this.f25843c = gVar;
        }
    }

    /* renamed from: com.shopee.app.ui.webview.c$c  reason: collision with other inner class name */
    public static class C0397c extends MutableContextWrapper implements x<e> {
        public C0397c(Context context) {
            super(context);
        }

        /* renamed from: a */
        public e b() {
            return (e) ((x) getBaseContext()).b();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        if (this.O) {
            this.O = false;
            H();
        }
        super.onResume();
        this.M.c();
        this.N.a();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.f7025e);
        bundle.putBoolean("plvNeedRestoreOnResume", this.O);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        String string = bundle.getString("url");
        if (!TextUtils.isEmpty(string)) {
            this.f7025e = string;
        }
        this.O = bundle.getBoolean("plvNeedRestoreOnResume");
    }

    public void onPause() {
        super.onPause();
        this.M.b();
        if (isFinishing() && this.f7024d) {
            overridePendingTransition(R.anim.not_move_ani, R.anim.slide_out_from_bottom_fast);
        }
        this.N.b();
    }

    /* access modifiers changed from: protected */
    public String c() {
        return String.valueOf(hashCode());
    }

    private void G() {
        au auVar = this.J;
        if (auVar instanceof g) {
            g gVar = (g) auVar;
            this.O = true;
            b((q) gVar.getPresenter());
            this.L = new a();
            this.L.f25840d = gVar.v;
            if (gVar.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) gVar.getParent();
                a aVar = this.L;
                aVar.f25837a = viewGroup;
                aVar.f25838b = viewGroup.indexOfChild(gVar);
                viewGroup.removeView(gVar);
            }
            this.L.f25839c = gVar.getScrollYPt();
            gVar.m();
            d(false);
        }
    }

    private static ViewGroup b(View view) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        viewGroup.removeView(view);
        return viewGroup;
    }

    private void H() {
        if (this.L != null) {
            au auVar = this.J;
            if (auVar instanceof g) {
                g gVar = (g) auVar;
                b((View) gVar);
                this.P = true;
                gVar.setVisibility(4);
                gVar.a(this, this.f7025e, this.L.f25839c);
                if (this.L.f25837a != null) {
                    this.L.f25837a.addView(gVar, this.L.f25838b);
                }
                gVar.v = this.L.f25840d;
            }
        }
    }

    private void d(boolean z) {
        au auVar = this.J;
        if ((auVar instanceof g) && ((g) auVar).getActivity() == this) {
            g gVar = (g) this.J;
            gVar.b(z);
            b((View) gVar);
            gVar.n();
            gVar.v = null;
        }
    }

    public void onDestroy() {
        au auVar = this.J;
        if (auVar != null) {
            auVar.e();
        }
        super.onDestroy();
        this.M.f();
        this.f7022b.onDestroy();
        d(true);
    }

    public void l() {
        if (this.P) {
            this.P = false;
            au auVar = this.J;
            if (auVar instanceof g) {
                final g gVar = (g) auVar;
                gVar.a((Runnable) new Runnable() {
                    public void run() {
                        gVar.setVisibility(0);
                    }
                });
            }
        }
    }

    public void a(String str) {
        this.f7025e = str;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A[Catch:{ Exception -> 0x00d0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.os.Bundle r8) {
        /*
            r7 = this;
            com.shopee.app.web.protocol.SearchConfig r8 = new com.shopee.app.web.protocol.SearchConfig     // Catch:{ Exception -> 0x00d0 }
            r8.<init>()     // Catch:{ Exception -> 0x00d0 }
            com.google.a.f r0 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x0012 }
            java.lang.String r1 = r7.f7023c     // Catch:{ Exception -> 0x0012 }
            java.lang.Class<com.shopee.app.web.protocol.NavbarMessage> r2 = com.shopee.app.web.protocol.NavbarMessage.class
            java.lang.Object r0 = r0.a((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x0012 }
            com.shopee.app.web.protocol.NavbarMessage r0 = (com.shopee.app.web.protocol.NavbarMessage) r0     // Catch:{ Exception -> 0x0012 }
            goto L_0x0017
        L_0x0012:
            com.shopee.app.web.protocol.NavbarMessage r0 = new com.shopee.app.web.protocol.NavbarMessage     // Catch:{ Exception -> 0x00d0 }
            r0.<init>()     // Catch:{ Exception -> 0x00d0 }
        L_0x0017:
            if (r0 == 0) goto L_0x001d
            com.shopee.app.web.protocol.SearchConfig r8 = r0.getSearchConfig()     // Catch:{ Exception -> 0x00d0 }
        L_0x001d:
            r4 = r8
            java.lang.String r8 = r7.f7027g     // Catch:{ Exception -> 0x00d0 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d0 }
            if (r8 == 0) goto L_0x0082
            java.lang.String r8 = r7.k     // Catch:{ Exception -> 0x00d0 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d0 }
            r0 = 0
            if (r8 != 0) goto L_0x0060
            java.lang.String r8 = r7.k     // Catch:{ Exception -> 0x00d0 }
            com.shopee.app.ui.webview.c$b r8 = b((java.lang.String) r8)     // Catch:{ Exception -> 0x00d0 }
            if (r8 == 0) goto L_0x0060
            com.shopee.app.ui.webview.g r8 = r8.f25843c     // Catch:{ Exception -> 0x00d0 }
            android.app.Activity r1 = r8.getActivity()     // Catch:{ Exception -> 0x00d0 }
            boolean r2 = r1 instanceof com.shopee.app.ui.webview.c     // Catch:{ Exception -> 0x00d0 }
            if (r2 == 0) goto L_0x0046
            com.shopee.app.ui.webview.c r1 = (com.shopee.app.ui.webview.c) r1     // Catch:{ Exception -> 0x00d0 }
            r1.G()     // Catch:{ Exception -> 0x00d0 }
        L_0x0046:
            r7.J = r8     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = r7.j     // Catch:{ Exception -> 0x00d0 }
            r8.setLastPageJs(r1)     // Catch:{ Exception -> 0x00d0 }
            r7.j = r0     // Catch:{ Exception -> 0x00d0 }
            r1 = 1
            r7.P = r1     // Catch:{ Exception -> 0x00d0 }
            r1 = 4
            r8.setVisibility(r1)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = r7.f7025e     // Catch:{ Exception -> 0x00d0 }
            r2 = 0
            r8.a((com.shopee.app.ui.webview.c) r7, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x00d0 }
            r7.a((android.view.View) r8)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x0061
        L_0x0060:
            r8 = r0
        L_0x0061:
            if (r8 != 0) goto L_0x00b9
            java.lang.String r8 = r7.f7026f     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = r7.i     // Catch:{ Exception -> 0x00d0 }
            com.shopee.app.ui.webview.g r8 = com.shopee.app.ui.webview.WebPageView_.a(r7, r8, r1, r4)     // Catch:{ Exception -> 0x00d0 }
            com.shopee.app.data.viewmodel.WebPageModel r1 = new com.shopee.app.data.viewmodel.WebPageModel     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r2 = r7.f7025e     // Catch:{ Exception -> 0x00d0 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00d0 }
            r8.b((com.shopee.app.data.viewmodel.WebPageModel) r1)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r1 = r7.j     // Catch:{ Exception -> 0x00d0 }
            r8.setLastPageJs(r1)     // Catch:{ Exception -> 0x00d0 }
            r7.j = r0     // Catch:{ Exception -> 0x00d0 }
            r7.J = r8     // Catch:{ Exception -> 0x00d0 }
            r7.a((android.view.View) r8)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00b9
        L_0x0082:
            com.google.a.q r8 = new com.google.a.q     // Catch:{ Exception -> 0x00d0 }
            r8.<init>()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = r7.f7027g     // Catch:{ Exception -> 0x00d0 }
            com.google.a.l r8 = r8.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
            com.google.a.o r8 = r8.m()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "tabs"
            com.google.a.l r1 = r8.c(r0)     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = "tabsConfig"
            com.google.a.l r2 = r8.c(r0)     // Catch:{ Exception -> 0x00d0 }
            com.google.a.q r8 = new com.google.a.q     // Catch:{ Exception -> 0x00d0 }
            r8.<init>()     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = r7.h     // Catch:{ Exception -> 0x00d0 }
            com.google.a.l r3 = r8.a((java.lang.String) r0)     // Catch:{ Exception -> 0x00d0 }
            int r5 = r7.l     // Catch:{ Exception -> 0x00d0 }
            r6 = 1
            r0 = r7
            com.shopee.app.ui.common.ay r8 = com.shopee.app.ui.common.az.a(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x00d0 }
            r7.J = r8     // Catch:{ Exception -> 0x00d0 }
            com.shopee.app.ui.common.au r8 = r7.J     // Catch:{ Exception -> 0x00d0 }
            android.view.View r8 = (android.view.View) r8     // Catch:{ Exception -> 0x00d0 }
            r7.a((android.view.View) r8)     // Catch:{ Exception -> 0x00d0 }
        L_0x00b9:
            java.lang.String r8 = r7.m     // Catch:{ Exception -> 0x00d0 }
            boolean r8 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x00d0 }
            if (r8 != 0) goto L_0x00e9
            com.google.a.f r8 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x00d0 }
            java.lang.String r0 = r7.m     // Catch:{ Exception -> 0x00d0 }
            java.lang.Class<com.shopee.app.web.protocol.ShowPopUpMessage$PopUp> r1 = com.shopee.app.web.protocol.ShowPopUpMessage.PopUp.class
            java.lang.Object r8 = r8.a((java.lang.String) r0, r1)     // Catch:{ Exception -> 0x00d0 }
            com.shopee.app.web.protocol.ShowPopUpMessage$PopUp r8 = (com.shopee.app.web.protocol.ShowPopUpMessage.PopUp) r8     // Catch:{ Exception -> 0x00d0 }
            r7.H = r8     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00e9
        L_0x00d0:
            android.view.View r8 = new android.view.View
            r8.<init>(r7)
            r7.a((android.view.View) r8)
            r1 = 0
            r2 = 2131888545(0x7f1209a1, float:1.9411728E38)
            r3 = 0
            r4 = 2131886407(0x7f120147, float:1.9407392E38)
            com.shopee.app.ui.webview.c$2 r5 = new com.shopee.app.ui.webview.c$2
            r5.<init>()
            r0 = r7
            com.shopee.app.ui.dialog.a.a((android.content.Context) r0, (int) r1, (int) r2, (int) r3, (int) r4, (com.afollestad.materialdialogs.f.b) r5)
        L_0x00e9:
            com.shopee.app.tracking.b.d r8 = new com.shopee.app.tracking.b.d
            java.lang.String r0 = r7.f7025e
            r8.<init>(r0)
            r7.I = r8
            com.shopee.app.ui.setting.b.a r8 = com.shopee.app.ui.setting.b.a.f25184a
            java.lang.String r0 = r7.f7025e
            r8.a(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.webview.c.a(android.os.Bundle):void");
    }

    private static b b(String str) {
        b bVar = Q.get(str);
        if (bVar != null && bVar.f25842b != null && bVar.f25843c != null && bVar.f25843c.A) {
            return bVar;
        }
        Q.remove(str);
        return null;
    }

    public static void a(Context context, String str, String str2) {
        if (!Q.containsKey(str) && context != null) {
            g a2 = WebPageView_.a(new C0397c(context), "", "", new SearchConfig());
            Q.put(str, new b(str, str2, a2));
            a2.b(new WebPageModel(str2));
            a2.setIsPlv(true);
            ((e) context).b((q) a2.getPresenter());
            a2.n();
        }
    }

    public static void p() {
        Q.clear();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        this.M.a(this, i2, i3, intent);
        this.f7022b.onActivityResult(this, i2, i3, intent);
        com.shopee.sdk.b.a().e().a((Activity) this, i2, i3, intent);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (this.J != null) {
            this.f7022b.onRequestPermissionsResult(this, i2, strArr, iArr);
            if (i2 != 228) {
                if (i2 != 256) {
                    if (i2 == 512 && iArr.length > 0 && iArr[0] == 0) {
                        this.J.b(512);
                    }
                } else if (iArr.length > 0 && iArr[0] == 0) {
                    this.J.b(256);
                }
            } else if (iArr.length <= 0 || iArr[0] != 0) {
                this.J.h();
            } else {
                this.J.g();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(a.C0296a aVar) {
        aVar.f(1).e(0).b(this.f7023c, this.f7025e);
    }

    /* access modifiers changed from: protected */
    public void a(UserComponent userComponent) {
        this.K = a.c().a(userComponent).a(new com.shopee.app.a.b(this)).a();
        this.K.a(this);
    }

    /* renamed from: q */
    public e b() {
        return this.K;
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i2) {
        if (i2 > 0) {
            Intent intent = new Intent();
            intent.putExtra("returnData", str);
            intent.putExtra("returnCountKey", i2 - 1);
            setResult(-1, intent);
            finish();
            return;
        }
        au auVar = this.J;
        if (auVar != null) {
            auVar.d(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Intent intent) {
        if (i2 == -1) {
            int intExtra = intent.getIntExtra("returnCountKey", 0);
            String stringExtra = intent.getStringExtra("returnData");
            if (intExtra > 0) {
                Intent intent2 = new Intent();
                intent2.putExtra("returnData", stringExtra);
                intent2.putExtra("returnCountKey", intExtra - 1);
                setResult(-1, intent2);
                finish();
            } else if (this.J != null && !TextUtils.isEmpty(stringExtra)) {
                this.J.d(stringExtra);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str) {
        if (i2 == -1) {
            au auVar = this.J;
            if (auVar != null) {
                auVar.d(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, Intent intent) {
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra(AbTestingModule.KEY_RESULT);
            au auVar = this.J;
            if (auVar != null) {
                auVar.f(stringExtra);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2, String str) {
        if (i2 == -1) {
            au auVar = this.J;
            if (auVar != null) {
                auVar.e(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, Intent intent) {
        if (i2 == -1) {
            final ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            if (this.J != null) {
                this.N.a(new com.shopee.app.util.a.a() {
                    public void run() {
                        c.this.J.a((List<String>) stringArrayListExtra);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z, int i4) {
        if (i2 == -1) {
            o oVar = new o();
            oVar.a("index", (Number) Integer.valueOf(i3));
            oVar.a("isPlaying", Boolean.valueOf(z));
            oVar.a("curTime", (Number) Integer.valueOf(i4));
            o oVar2 = new o();
            oVar2.a("curMedia", (l) oVar);
            au auVar = this.J;
            if (auVar != null) {
                auVar.a(oVar2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, long j2) {
        if (i2 == -1) {
            o oVar = new o();
            oVar.a("commentID", (Number) Long.valueOf(j2));
            au auVar = this.J;
            if (auVar != null) {
                auVar.a(oVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, String str, int i3, int i4, String str2, int i5, int i6, String str3, String str4) {
        if (i2 == -1) {
            au auVar = this.J;
            if (auVar != null) {
                auVar.a(str, i3, i4, str2, i5, i6, str3, str4);
                return;
            }
            return;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, Intent intent) {
        if (i2 == -1) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("add_product_image_uri_list");
            au auVar = this.J;
            if (auVar != null) {
                auVar.a(i2, (List<String>) stringArrayListExtra);
                return;
            }
            return;
        }
        au auVar2 = this.J;
        if (auVar2 != null) {
            auVar2.a(i2, (List<String>) new ArrayList());
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, Intent intent) {
        au auVar = this.J;
        if (auVar != null) {
            auVar.a(i2, intent);
        }
    }

    public void onBackPressed() {
        au auVar = this.J;
        if (auVar == null) {
            super.onBackPressed();
        } else if (this.H != null) {
            I();
        } else if (!auVar.a()) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.f7022b.onNewIntent(intent);
    }

    private void I() {
        String title = this.H.getTitle();
        String message = this.H.getMessage();
        String okText = this.H.getOkText();
        if (TextUtils.isEmpty(okText)) {
            okText = getString(R.string.sp_label_ok);
        }
        String str = okText;
        String cancelText = this.H.getCancelText();
        if (!isFinishing()) {
            com.shopee.app.ui.dialog.a.b(this, title, message, str, cancelText, new a.C0318a() {
                public void onNegative() {
                }

                public void onPositive() {
                    o oVar = new o();
                    oVar.a("buttonClicked", (Number) 0);
                    Intent intent = new Intent();
                    intent.putExtra("returnData", oVar.toString());
                    c.this.setResult(-1, intent);
                    c.this.finish();
                }
            });
        }
    }

    public String B() {
        if (this.l == 109) {
            au auVar = this.J;
            if (auVar instanceof ay) {
                return ((ay) auVar).getActiveTabUrl();
            }
        }
        return this.f7025e;
    }

    public void a(boolean z, int i2) {
        com.shopee.app.ui.actionbar.a actionBar = x().getActionBar();
        if (actionBar != null) {
            int measuredHeight = actionBar.getMeasuredHeight();
            au auVar = this.J;
            if (auVar != null && (auVar instanceof ay)) {
                measuredHeight += ((ay) auVar).getTabHeaderHeight();
            }
            FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
            if (frameLayout != null) {
                if (this.n == null) {
                    this.n = View.inflate(this, R.layout.dim_overlay_layout, (ViewGroup) null);
                    frameLayout.addView(this.n, new FrameLayout.LayoutParams(actionBar.getMeasuredWidth(), measuredHeight));
                }
                if (z) {
                    this.n.setBackgroundColor(i2);
                    this.n.setVisibility(0);
                    return;
                }
                this.n.setVisibility(8);
            }
        }
    }

    public au F() {
        return this.J;
    }

    public com.shopee.a.b.a r() {
        return this.I;
    }
}

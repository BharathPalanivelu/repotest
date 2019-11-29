package com.shopee.app.h;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.appsflyer.AppsFlyerLib;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.al;
import com.shopee.app.g.c;
import d.d.b.j;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final k f17668a = new k();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f17669b = {"http", "https"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f17670c = {"google", "bing", "yahoo", "baidu", "360.cn", "alice.com", "aol.com", "search.auone.jp", "isearch.avg.com", "search.babylon.com", "duckduckgo.com", "go.mail.ru", "msn.com", "search.smt.docomo", "yam.com", "voila.fr"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f17671d = {"shopee-co-id.cdn.ampproject.org", "shopee-com-my.cdn.ampproject.org", "shopee-ph.cdn.ampproject.org", "shopee-sg.cdn.ampproject.org", "shopee-co-th.cdn.ampproject.org", "shopee-tw.cdn.ampproject.org", "shopee-vn.cdn.ampproject.org"};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f17672e = {"utm_source", "utm_medium", "utm_campaign", "utm_term", "utm_content"};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f17673f = {"stm_source", "stm_medium"};

    private k() {
    }

    public static final void a(Context context) {
        j.b(context, "context");
        FirebaseAnalytics.getInstance(context).a(false);
    }

    public static final void a(Intent intent, Activity activity) {
        Uri uri;
        j.b(activity, "activity");
        if (intent != null) {
            try {
                uri = intent.getData();
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
                return;
            }
        } else {
            uri = null;
        }
        a(uri, activity);
    }

    public static final void a(Context context, String str, String str2, int i) {
        j.b(context, "context");
        j.b(str, "screenName");
        j.b(str2, "loginOption");
        String b2 = c.b(String.valueOf(i));
        j.a((Object) b2, "BBSecurityHelper.sha256(userId.toString())");
        String h = com.shopee.app.react.modules.app.appmanager.a.h();
        Bundle bundle = new Bundle();
        bundle.putString("screenName", str);
        bundle.putString("eventCategory", "login");
        bundle.putString("eventAction", str2);
        bundle.putString("eventLabel", b2);
        bundle.putString("dimension1", str2);
        bundle.putString("dimension2", h);
        bundle.putString("dimension3", b2);
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        j.a((Object) instance, "FirebaseInstanceId.getInstance()");
        bundle.putString("dimension4", instance.getId());
        bundle.putString("dimension5", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
        FirebaseAnalytics.getInstance(context).a("login_event", bundle);
    }

    public static final void b(Context context, String str, String str2, int i) {
        j.b(context, "context");
        j.b(str, "screenName");
        j.b(str2, "signupOption");
        String b2 = c.b(String.valueOf(i));
        j.a((Object) b2, "BBSecurityHelper.sha256(userId.toString())");
        String h = com.shopee.app.react.modules.app.appmanager.a.h();
        Bundle bundle = new Bundle();
        bundle.putString("screenName", str);
        bundle.putString("eventCategory", "register");
        bundle.putString("eventAction", str2);
        bundle.putString("eventLabel", b2);
        bundle.putString("dimension1", str2);
        bundle.putString("dimension2", h);
        bundle.putString("dimension3", b2);
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        j.a((Object) instance, "FirebaseInstanceId.getInstance()");
        bundle.putString("dimension4", instance.getId());
        bundle.putString("dimension5", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
        FirebaseAnalytics.getInstance(context).a("signup_event", bundle);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e0, code lost:
        if (r12 != null) goto L_0x00ec;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(android.net.Uri r12, android.app.Activity r13) throws java.lang.Exception {
        /*
            java.lang.String r0 = "activity"
            d.d.b.j.b(r13, r0)
            android.content.Context r0 = r13.getApplicationContext()
            com.google.firebase.analytics.FirebaseAnalytics r0 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(r0)
            r1 = 1
            r0.a((boolean) r1)
            com.shopee.app.h.k$a r0 = new com.shopee.app.h.k$a
            r0.<init>(r12)
            com.shopee.app.h.k r2 = f17668a
            android.net.Uri r2 = r2.a((android.app.Activity) r13)
            java.lang.String r3 = "campaign_details_paid"
            java.lang.String r4 = "gclid"
            if (r12 == 0) goto L_0x0038
            com.shopee.app.h.k r5 = f17668a
            boolean r5 = r5.b(r12, r4)
            if (r5 == 0) goto L_0x0038
            com.shopee.app.h.k r1 = f17668a
            java.lang.String r12 = r1.a((android.net.Uri) r12, (java.lang.String) r4)
            r0.a(r4, r12)
            r0.a(r3)
            goto L_0x01ac
        L_0x0038:
            if (r12 == 0) goto L_0x0052
            com.shopee.app.h.k r5 = f17668a
            java.lang.String r6 = "dclid"
            boolean r5 = r5.b(r12, r6)
            if (r5 == 0) goto L_0x0052
            com.shopee.app.h.k r1 = f17668a
            java.lang.String r12 = r1.a((android.net.Uri) r12, (java.lang.String) r6)
            r0.a(r4, r12)
            r0.a(r3)
            goto L_0x01ac
        L_0x0052:
            r3 = 0
            if (r12 == 0) goto L_0x008f
            java.lang.String[] r4 = f17672e
            int r5 = r4.length
            r6 = 0
        L_0x0059:
            if (r6 >= r5) goto L_0x006a
            r7 = r4[r6]
            com.shopee.app.h.k r8 = f17668a
            boolean r7 = r8.b(r12, r7)
            if (r7 == 0) goto L_0x0067
            r4 = 1
            goto L_0x006b
        L_0x0067:
            int r6 = r6 + 1
            goto L_0x0059
        L_0x006a:
            r4 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x008f
            java.lang.String[] r1 = f17672e
            int r2 = r1.length
        L_0x0070:
            if (r3 >= r2) goto L_0x0088
            r4 = r1[r3]
            com.shopee.app.h.k r5 = f17668a
            boolean r5 = r5.b(r12, r4)
            if (r5 == 0) goto L_0x0085
            com.shopee.app.h.k r5 = f17668a
            java.lang.String r5 = r5.a((android.net.Uri) r12, (java.lang.String) r4)
            r0.a(r4, r5)
        L_0x0085:
            int r3 = r3 + 1
            goto L_0x0070
        L_0x0088:
            java.lang.String r12 = "campaign_details_utm"
            r0.a(r12)
            goto L_0x01ac
        L_0x008f:
            if (r12 == 0) goto L_0x00cb
            java.lang.String[] r4 = f17673f
            int r5 = r4.length
            r6 = 0
        L_0x0095:
            if (r6 >= r5) goto L_0x00a6
            r7 = r4[r6]
            com.shopee.app.h.k r8 = f17668a
            boolean r7 = r8.b(r12, r7)
            if (r7 == 0) goto L_0x00a3
            r4 = 1
            goto L_0x00a7
        L_0x00a3:
            int r6 = r6 + 1
            goto L_0x0095
        L_0x00a6:
            r4 = 0
        L_0x00a7:
            if (r4 == 0) goto L_0x00cb
            java.lang.String[] r1 = f17673f
            int r2 = r1.length
        L_0x00ac:
            if (r3 >= r2) goto L_0x00c4
            r4 = r1[r3]
            com.shopee.app.h.k r5 = f17668a
            boolean r5 = r5.b(r12, r4)
            if (r5 == 0) goto L_0x00c1
            com.shopee.app.h.k r5 = f17668a
            java.lang.String r5 = r5.a((android.net.Uri) r12, (java.lang.String) r4)
            r0.a(r4, r5)
        L_0x00c1:
            int r3 = r3 + 1
            goto L_0x00ac
        L_0x00c4:
            java.lang.String r12 = "campaign_details_stm"
            r0.a(r12)
            goto L_0x01ac
        L_0x00cb:
            if (r2 == 0) goto L_0x01ac
            java.lang.String r12 = r2.getScheme()
            java.lang.String r4 = ""
            if (r12 == 0) goto L_0x00eb
            if (r12 == 0) goto L_0x00e3
            java.lang.String r12 = r12.toLowerCase()
            java.lang.String r5 = "(this as java.lang.String).toLowerCase()"
            d.d.b.j.a((java.lang.Object) r12, (java.lang.String) r5)
            if (r12 == 0) goto L_0x00eb
            goto L_0x00ec
        L_0x00e3:
            d.m r12 = new d.m
            java.lang.String r13 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r13)
            throw r12
        L_0x00eb:
            r12 = r4
        L_0x00ec:
            java.lang.String r5 = r2.getHost()
            if (r5 == 0) goto L_0x00f3
            r4 = r5
        L_0x00f3:
            java.lang.String[] r5 = f17669b
            boolean r5 = d.a.d.a((T[]) r5, r12)
            java.lang.String r6 = "referral"
            java.lang.String r7 = "organic"
            java.lang.String r8 = "utm_medium"
            java.lang.String r9 = "utm_source"
            if (r5 == 0) goto L_0x015d
            java.lang.String[] r12 = f17670c
            int r2 = r12.length
            r5 = 0
        L_0x0107:
            if (r5 >= r2) goto L_0x011b
            r10 = r12[r5]
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = d.h.m.c(r11, r10, r1)
            if (r10 == 0) goto L_0x0118
            r12 = 1
            goto L_0x011c
        L_0x0118:
            int r5 = r5 + 1
            goto L_0x0107
        L_0x011b:
            r12 = 0
        L_0x011c:
            if (r12 == 0) goto L_0x012b
            r0.a(r9, r4)
            r0.a(r8, r7)
            java.lang.String r12 = "campaign_details_organic"
            r0.a(r12)
            goto L_0x01ac
        L_0x012b:
            java.lang.String[] r12 = f17671d
            int r2 = r12.length
            r5 = 0
        L_0x012f:
            if (r5 >= r2) goto L_0x0142
            r10 = r12[r5]
            r11 = r4
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            boolean r10 = d.h.m.c(r11, r10, r1)
            if (r10 == 0) goto L_0x013f
            goto L_0x0143
        L_0x013f:
            int r5 = r5 + 1
            goto L_0x012f
        L_0x0142:
            r1 = 0
        L_0x0143:
            if (r1 == 0) goto L_0x0151
            r0.a(r9, r4)
            r0.a(r8, r7)
            java.lang.String r12 = "campaign_details_amp"
            r0.a(r12)
            goto L_0x01ac
        L_0x0151:
            r0.a(r9, r4)
            r0.a(r8, r6)
            java.lang.String r12 = "campaign_details_webreferral"
            r0.a(r12)
            goto L_0x01ac
        L_0x015d:
            java.lang.String r3 = "android-app"
            boolean r12 = d.d.b.j.a((java.lang.Object) r12, (java.lang.Object) r3)
            if (r12 == 0) goto L_0x01ac
            com.google.firebase.appindexing.a r12 = com.google.firebase.appindexing.a.a(r2)
            java.lang.String r2 = "appUri"
            d.d.b.j.a((java.lang.Object) r12, (java.lang.String) r2)
            java.lang.String r12 = r12.a()
            java.lang.String r2 = r13.getPackageName()
            java.lang.String r3 = "com.google.android.googlequicksearchbox"
            boolean r3 = d.d.b.j.a((java.lang.Object) r12, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x018c
            java.lang.String r12 = "google_app"
            r0.a(r9, r12)
            r0.a(r8, r7)
            java.lang.String r12 = "campaign_details_googleapp"
            r0.a(r12)
            goto L_0x01ac
        L_0x018c:
            java.lang.String r3 = "com.google.appcrawler"
            boolean r3 = d.d.b.j.a((java.lang.Object) r12, (java.lang.Object) r3)
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x01ac
            boolean r2 = d.d.b.j.a((java.lang.Object) r12, (java.lang.Object) r2)
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x01ac
            java.lang.String r1 = "referrerPackage"
            d.d.b.j.a((java.lang.Object) r12, (java.lang.String) r1)
            r0.a(r9, r12)
            r0.a(r8, r6)
            java.lang.String r12 = "campaign_details_appreferral"
            r0.a(r12)
        L_0x01ac:
            java.lang.String r12 = r0.a()
            if (r12 == 0) goto L_0x01c1
            android.content.Context r13 = r13.getApplicationContext()
            com.google.firebase.analytics.FirebaseAnalytics r13 = com.google.firebase.analytics.FirebaseAnalytics.getInstance(r13)
            android.os.Bundle r0 = r0.b()
            r13.a((java.lang.String) r12, (android.os.Bundle) r0)
        L_0x01c1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.k.a(android.net.Uri, android.app.Activity):void");
    }

    private final Uri a(Activity activity) {
        if (Build.VERSION.SDK_INT < 22) {
            return b(activity);
        }
        if (activity.getIntent() == null || !activity.getIntent().hasExtra("android.intent.extra.REFERRER_URI")) {
            return activity.getReferrer();
        }
        return (Uri) activity.getIntent().getParcelableExtra("android.intent.extra.REFERRER_URI");
    }

    private final Uri b(Activity activity) {
        Intent intent = activity.getIntent();
        Uri uri = intent != null ? (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER") : null;
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent != null ? intent.getStringExtra("android.intent.extra.REFERRER_NAME") : null;
        if (stringExtra != null) {
            try {
                return Uri.parse(stringExtra);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private final String a(Uri uri, String str) {
        String queryParameter = uri.getQueryParameter(str);
        return queryParameter != null ? queryParameter : "";
    }

    private final boolean b(Uri uri, String str) {
        CharSequence queryParameter = uri.getQueryParameter(str);
        return !(queryParameter == null || queryParameter.length() == 0);
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f17674a;

        /* renamed from: b  reason: collision with root package name */
        private final Bundle f17675b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f17676c;

        /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a(android.net.Uri r9) {
            /*
                r8 = this;
                r8.<init>()
                r8.f17676c = r9
                android.net.Uri r9 = r8.f17676c
                r0 = 0
                r1 = 0
                if (r9 == 0) goto L_0x0024
                java.lang.String r2 = "screen_url"
                java.lang.String r2 = r9.getQueryParameter(r2)
                if (r2 == 0) goto L_0x0024
                byte[] r2 = android.util.Base64.decode(r2, r1)
                java.lang.String r3 = "Base64.decode(this, Base64.DEFAULT)"
                d.d.b.j.a((java.lang.Object) r2, (java.lang.String) r3)
                java.lang.String r3 = new java.lang.String
                java.nio.charset.Charset r4 = d.h.d.f32688a
                r3.<init>(r2, r4)
                goto L_0x0025
            L_0x0024:
                r3 = r0
            L_0x0025:
                r2 = 1
                if (r3 == 0) goto L_0x003d
                r4 = r3
                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                if (r4 == 0) goto L_0x0036
                int r4 = r4.length()
                if (r4 != 0) goto L_0x0034
                goto L_0x0036
            L_0x0034:
                r4 = 0
                goto L_0x0037
            L_0x0036:
                r4 = 1
            L_0x0037:
                if (r4 != 0) goto L_0x003d
                android.net.Uri r9 = android.net.Uri.parse(r3)
            L_0x003d:
                if (r9 == 0) goto L_0x00c1
                android.net.Uri$Builder r0 = r9.buildUpon()
                android.net.Uri$Builder r0 = r0.clearQuery()
                java.util.Set r3 = r9.getQueryParameterNames()
                java.lang.String r4 = "queryParameterNames"
                d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r4)
                java.lang.Iterable r3 = (java.lang.Iterable) r3
                java.util.ArrayList r4 = new java.util.ArrayList
                r4.<init>()
                java.util.Collection r4 = (java.util.Collection) r4
                java.util.Iterator r3 = r3.iterator()
            L_0x005d:
                boolean r5 = r3.hasNext()
                if (r5 == 0) goto L_0x009d
                java.lang.Object r5 = r3.next()
                r6 = r5
                java.lang.String r6 = (java.lang.String) r6
                com.shopee.app.h.k r7 = com.shopee.app.h.k.f17668a
                java.lang.String[] r7 = com.shopee.app.h.k.f17672e
                boolean r7 = d.a.d.a((T[]) r7, r6)
                if (r7 != 0) goto L_0x0096
                com.shopee.app.h.k r7 = com.shopee.app.h.k.f17668a
                java.lang.String[] r7 = com.shopee.app.h.k.f17673f
                boolean r7 = d.a.d.a((T[]) r7, r6)
                if (r7 != 0) goto L_0x0096
                java.lang.String r7 = "gclid"
                boolean r7 = d.d.b.j.a((java.lang.Object) r7, (java.lang.Object) r6)
                r7 = r7 ^ r2
                if (r7 == 0) goto L_0x0096
                java.lang.String r7 = "dclid"
                boolean r6 = d.d.b.j.a((java.lang.Object) r7, (java.lang.Object) r6)
                r6 = r6 ^ r2
                if (r6 == 0) goto L_0x0096
                r6 = 1
                goto L_0x0097
            L_0x0096:
                r6 = 0
            L_0x0097:
                if (r6 == 0) goto L_0x005d
                r4.add(r5)
                goto L_0x005d
            L_0x009d:
                java.util.List r4 = (java.util.List) r4
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.Iterator r1 = r4.iterator()
            L_0x00a5:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x00b9
                java.lang.Object r2 = r1.next()
                java.lang.String r2 = (java.lang.String) r2
                java.lang.String r3 = r9.getQueryParameter(r2)
                r0.appendQueryParameter(r2, r3)
                goto L_0x00a5
            L_0x00b9:
                android.net.Uri r9 = r0.build()
                java.lang.String r0 = r9.toString()
            L_0x00c1:
                android.os.Bundle r9 = new android.os.Bundle
                r9.<init>()
                java.lang.String r1 = "screenUrl"
                r9.putString(r1, r0)
                com.shopee.app.h.k r0 = com.shopee.app.h.k.f17668a
                r0.a((android.os.Bundle) r9)
                r8.f17675b = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.h.k.a.<init>(android.net.Uri):void");
        }

        public final String a() {
            return this.f17674a;
        }

        public final void a(String str) {
            this.f17674a = str;
        }

        public final Bundle b() {
            return this.f17675b;
        }

        public final void a(String str, String str2) {
            j.b(str, "key");
            j.b(str2, AppMeasurementSdk.ConditionalUserProperty.VALUE);
            this.f17675b.putString(str, str2);
        }
    }

    /* access modifiers changed from: private */
    public final void a(Bundle bundle) {
        try {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            al loginStore = f2.e().loginStore();
            j.a((Object) loginStore, "ShopeeApplication.get().component.loginStore()");
            UserInfo a2 = loginStore.a();
            j.a((Object) a2, "ShopeeApplication.get().…ent.loginStore().userInfo");
            String b2 = c.b(String.valueOf(a2.getUserId()));
            j.a((Object) b2, "BBSecurityHelper.sha256(userId.toString())");
            bundle.putString("dimension3", b2);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a("cannot get userid", e2);
        }
        bundle.putString("dimension2", com.shopee.app.react.modules.app.appmanager.a.h());
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        j.a((Object) instance, "FirebaseInstanceId.getInstance()");
        bundle.putString("dimension4", instance.getId());
        bundle.putString("dimension5", AppsFlyerLib.getInstance().getAppsFlyerUID(ar.f()));
    }
}

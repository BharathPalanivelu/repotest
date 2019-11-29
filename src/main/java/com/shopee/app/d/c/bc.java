package com.shopee.app.d.c;

import com.google.a.l;
import com.google.a.o;
import com.shopee.app.data.store.al;
import com.shopee.app.network.http.a.i;
import com.shopee.app.network.http.data.JsonDataResponse;
import com.shopee.app.ui.home.me.v3.feature.MeFeature;
import com.shopee.app.util.n;
import com.shopee.app.util.s;
import com.shopee.id.R;
import d.d.b.j;
import f.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class bc extends a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f16552c = new a((g) null);

    /* renamed from: d  reason: collision with root package name */
    private long f16553d;

    /* renamed from: e  reason: collision with root package name */
    private final String f16554e = "me_page";

    /* renamed from: f  reason: collision with root package name */
    private final String f16555f = "selling_page";

    /* renamed from: g  reason: collision with root package name */
    private int f16556g = 3;
    private final al h;
    private final n i;
    private final s j;
    private final i k;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetMeFeaturesInteractor";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bc(al alVar, n nVar, s sVar, i iVar) {
        super(nVar);
        j.b(alVar, "loginStore");
        j.b(nVar, "dataEventBus");
        j.b(sVar, "featureToggleManager");
        j.b(iVar, "meApi");
        this.h = alVar;
        this.i = nVar;
        this.j = sVar;
        this.k = iVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public final void a(int i2) {
        this.f16556g = i2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        e();
        f();
    }

    public void a() {
        if (System.currentTimeMillis() - this.f16553d > 2000) {
            this.f16553d = System.currentTimeMillis();
            super.a();
        }
    }

    public final void e() {
        Collection C = this.h.C();
        if ((C == null || C.isEmpty()) || g()) {
            this.h.a((List<MeFeature>) b(R.raw.me_page_config));
            this.i.a("ME_BUYER_FEATURE_CHANGED", new com.garena.android.appkit.b.a());
        }
        if (!g() && (this.f16556g & 1) == 1) {
            com.garena.android.appkit.d.a.b("me feature, fetching buyer feature", new Object[0]);
            List<MeFeature> a2 = a(this.f16554e);
            if (a2 != null && (true ^ a2.isEmpty())) {
                com.garena.android.appkit.d.a.b("me feature, buyers : " + a2, new Object[0]);
                this.h.a(a2);
                this.i.a("ME_BUYER_FEATURE_CHANGED", new com.garena.android.appkit.b.a());
            }
        }
    }

    public final void f() {
        Collection D = this.h.D();
        if ((D == null || D.isEmpty()) || g()) {
            this.h.b((List<MeFeature>) b(R.raw.selling_page_config));
            this.i.a("ME_SELLER_FEATURE_CHANGED", new com.garena.android.appkit.b.a());
        }
        if (!g() && (this.f16556g & 2) == 2) {
            com.garena.android.appkit.d.a.b("me feature, fetching seller feature", new Object[0]);
            List<MeFeature> a2 = a(this.f16555f);
            if (a2 != null && (true ^ a2.isEmpty())) {
                com.garena.android.appkit.d.a.b("me feature, sellers : " + a2, new Object[0]);
                this.h.b(a2);
                this.i.a("ME_SELLER_FEATURE_CHANGED", new com.garena.android.appkit.b.a());
            }
        }
    }

    private final List<MeFeature> a(String str) {
        ArrayList<MeFeature> arrayList;
        try {
            m<JsonDataResponse> a2 = this.k.a(str).a();
            if (a2.d()) {
                JsonDataResponse e2 = a2.e();
                if (e2 != null) {
                    o data = e2.getData();
                    if (data != null) {
                        l c2 = data.c("groups");
                        if (c2 != null) {
                            arrayList = a(c2);
                            return arrayList;
                        }
                    }
                }
                arrayList = null;
                return arrayList;
            }
        } catch (Exception e3) {
            com.garena.android.appkit.d.a.a(e3);
        }
        return null;
    }

    private final boolean g() {
        if (!this.j.a("force_me_feature_cache")) {
            Boolean E = this.h.E();
            j.a((Object) E, "loginStore.isForcedMeCache");
            return E.booleanValue();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (r5 != null) goto L_0x0061;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<com.shopee.app.ui.home.me.v3.feature.MeFeature> a(com.google.a.l r14) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "me feature, parsing json: "
            r0.append(r1)
            r0.append(r14)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r2 = r14.i()
            if (r2 == 0) goto L_0x00e1
            com.google.a.i r14 = r14.n()
            java.lang.String r2 = "jsonElement.asJsonArray"
            d.d.b.j.a((java.lang.Object) r14, (java.lang.String) r2)
            java.lang.Iterable r14 = (java.lang.Iterable) r14
            java.util.Iterator r14 = r14.iterator()
            r2 = 0
        L_0x0032:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L_0x00e1
            java.lang.Object r3 = r14.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x0043
            d.a.j.b()
        L_0x0043:
            com.google.a.l r3 = (com.google.a.l) r3
            java.lang.String r5 = "group"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r5)
            com.google.a.o r3 = r3.m()
            if (r3 == 0) goto L_0x00de
            java.lang.String r5 = "name"
            com.google.a.l r5 = r3.c(r5)
            if (r5 == 0) goto L_0x005f
            java.lang.String r5 = r5.c()
            if (r5 == 0) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            java.lang.String r5 = ""
        L_0x0061:
            java.lang.String r6 = "features"
            com.google.a.l r3 = r3.c(r6)
            java.lang.String r6 = "get(\"features\")"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r6)
            com.google.a.i r3 = r3.n()
            if (r3 == 0) goto L_0x00de
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r6 = 0
        L_0x0079:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00de
            java.lang.Object r7 = r3.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x008a
            d.a.j.b()
        L_0x008a:
            com.google.a.l r7 = (com.google.a.l) r7
            com.google.a.f r9 = com.shopee.app.web.WebRegister.GSON     // Catch:{ Exception -> 0x00d6 }
            java.lang.Class<com.shopee.app.ui.home.me.v3.feature.MeFeature> r10 = com.shopee.app.ui.home.me.v3.feature.MeFeature.class
            java.lang.Object r7 = r9.a((com.google.a.l) r7, r10)     // Catch:{ Exception -> 0x00d6 }
            r9 = r7
            com.shopee.app.ui.home.me.v3.feature.MeFeature r9 = (com.shopee.app.ui.home.me.v3.feature.MeFeature) r9     // Catch:{ Exception -> 0x00d6 }
            r9.setGroup(r5)     // Catch:{ Exception -> 0x00d6 }
            r9.setGroupLocation(r2)     // Catch:{ Exception -> 0x00d6 }
            r9.setInGroupLocation(r6)     // Catch:{ Exception -> 0x00d6 }
            int r6 = r0.size()     // Catch:{ Exception -> 0x00d6 }
            r9.setSystemLocation(r6)     // Catch:{ Exception -> 0x00d6 }
            com.shopee.app.ui.home.me.v3.feature.MeFeature r7 = (com.shopee.app.ui.home.me.v3.feature.MeFeature) r7     // Catch:{ Exception -> 0x00d6 }
            com.shopee.app.ui.home.me.v3.feature.m r6 = r7.getSubFeatures()     // Catch:{ Exception -> 0x00d6 }
            if (r6 == 0) goto L_0x00d2
            java.util.List r6 = r6.b()     // Catch:{ Exception -> 0x00d6 }
            if (r6 == 0) goto L_0x00d2
            int r9 = r6.size()     // Catch:{ Exception -> 0x00d6 }
            r10 = 1
            int r9 = r9 - r10
            if (r9 < 0) goto L_0x00d2
            r11 = 0
        L_0x00be:
            java.lang.Object r12 = r6.get(r11)     // Catch:{ Exception -> 0x00d6 }
            com.shopee.app.ui.home.me.v3.feature.MeFeature r12 = (com.shopee.app.ui.home.me.v3.feature.MeFeature) r12     // Catch:{ Exception -> 0x00d6 }
            r12.setSubFeature(r10)     // Catch:{ Exception -> 0x00d6 }
            r12.setGroup(r5)     // Catch:{ Exception -> 0x00d6 }
            r12.setInGroupLocation(r11)     // Catch:{ Exception -> 0x00d6 }
            if (r11 == r9) goto L_0x00d2
            int r11 = r11 + 1
            goto L_0x00be
        L_0x00d2:
            r0.add(r7)     // Catch:{ Exception -> 0x00d6 }
            goto L_0x00dc
        L_0x00d6:
            r6 = move-exception
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            com.garena.android.appkit.d.a.a(r6)
        L_0x00dc:
            r6 = r8
            goto L_0x0079
        L_0x00de:
            r2 = r4
            goto L_0x0032
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.c.bc.a(com.google.a.l):java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007d, code lost:
        d.c.b.a(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0080, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0079, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.ArrayList<com.shopee.app.ui.home.me.v3.feature.MeFeature> b(int r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "me feature, readPredefinedData "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.garena.android.appkit.d.a.b(r0, r1)
            com.shopee.app.application.ar r0 = com.shopee.app.application.ar.f()
            java.lang.String r1 = "ShopeeApplication.get()"
            d.d.b.j.a((java.lang.Object) r0, (java.lang.String) r1)
            android.content.res.Resources r0 = r0.getResources()
            java.io.InputStream r3 = r0.openRawResource(r3)
            java.lang.String r0 = "ShopeeApplication.get().…rces.openRawResource(res)"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r0)
            java.nio.charset.Charset r0 = d.h.d.f32688a
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r3, r0)
            java.io.Reader r1 = (java.io.Reader) r1
            boolean r3 = r1 instanceof java.io.BufferedReader
            if (r3 == 0) goto L_0x003e
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            r3 = r1
            goto L_0x0045
        L_0x003e:
            java.io.BufferedReader r3 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r3.<init>(r1, r0)
        L_0x0045:
            java.io.Closeable r3 = (java.io.Closeable) r3
            r0 = 0
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1 = r3
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1     // Catch:{ Throwable -> 0x007b }
            java.io.Reader r1 = (java.io.Reader) r1     // Catch:{ Throwable -> 0x007b }
            java.lang.String r1 = d.c.l.a(r1)     // Catch:{ Throwable -> 0x007b }
            d.c.b.a(r3, r0)
            com.google.a.f r3 = com.shopee.app.web.WebRegister.GSON
            java.lang.Class<com.google.a.o> r0 = com.google.a.o.class
            java.lang.Object r3 = r3.a((java.lang.String) r1, r0)
            java.lang.String r0 = "WebRegister.GSON.fromJso…, JsonObject::class.java)"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r0)
            com.google.a.o r3 = (com.google.a.o) r3
            com.google.a.o r3 = r3.m()
            java.lang.String r0 = "groups"
            com.google.a.l r3 = r3.c(r0)
            java.lang.String r0 = "groupJson"
            d.d.b.j.a((java.lang.Object) r3, (java.lang.String) r0)
            java.util.ArrayList r3 = r2.a((com.google.a.l) r3)
            return r3
        L_0x0079:
            r1 = move-exception
            goto L_0x007d
        L_0x007b:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0079 }
        L_0x007d:
            d.c.b.a(r3, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.d.c.bc.b(int):java.util.ArrayList");
    }
}

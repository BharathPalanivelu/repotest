package com.garena.pay.android;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import com.beetalk.sdk.data.c;
import com.beetalk.sdk.e.f;
import com.beetalk.sdk.l;
import com.garena.d.a;
import com.garena.pay.android.a.a;
import com.garena.pay.android.a.b;
import com.garena.pay.android.c.a;
import com.garena.pay.android.f.a;
import com.garena.pay.android.f.h;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class b implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    transient Activity f8157a;

    /* renamed from: b  reason: collision with root package name */
    transient a f8158b;

    /* renamed from: c  reason: collision with root package name */
    private transient ProgressDialog f8159c;
    d currentHandler = null;
    LinkedHashMap<String, d> handlers = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public C0137b mPaymentState = C0137b.INIT;
    c pendingRequest;

    public interface a {
        void a(c cVar);
    }

    /* renamed from: com.garena.pay.android.b$b  reason: collision with other inner class name */
    private enum C0137b {
        INIT(0),
        CHOOSE_CHANNEL(1),
        CHOOSE_ITEM(2),
        READY_TO_PAY(3),
        DONE(4);
        
        private int mValue;

        private C0137b(int i) {
            this.mValue = i;
        }

        public int getIntValue() {
            return this.mValue;
        }

        public C0137b stateOfValue(int i) {
            if (i < 0 || i > 4) {
                return DONE;
            }
            return values()[i];
        }
    }

    public void a(Activity activity) {
        this.f8157a = activity;
    }

    public void a(a aVar) {
        this.f8158b = aVar;
    }

    public boolean a(int i, int i2, Intent intent) {
        return i == this.pendingRequest.e().intValue() && this.currentHandler.a(i, i2, intent, this.pendingRequest);
    }

    public void a(c cVar) {
        if (this.mPaymentState != C0137b.DONE) {
            if (this.mPaymentState != C0137b.INIT) {
                b(cVar);
                return;
            }
            this.mPaymentState = C0137b.CHOOSE_CHANNEL;
            c(cVar);
        }
    }

    /* access modifiers changed from: private */
    public void b(c cVar) {
        if (cVar.d() != this.pendingRequest.d()) {
            a(a.PAYMENT_REQUEST_ID_MISMATCH);
        }
        if (!f.a(cVar.g())) {
            this.currentHandler = this.handlers.get(String.valueOf(cVar.g()));
        }
        if (this.currentHandler == null && this.handlers.size() == 1 && this.mPaymentState == C0137b.CHOOSE_CHANNEL) {
            for (d dVar : this.handlers.values()) {
                this.currentHandler = dVar;
            }
        }
        if (this.currentHandler != null && cVar.i() == null) {
            if (this.currentHandler.d()) {
                this.mPaymentState = C0137b.READY_TO_PAY;
            } else {
                this.pendingRequest.a(this.currentHandler.c());
                this.mPaymentState = C0137b.CHOOSE_ITEM;
            }
        }
        if (!(this.currentHandler == null || cVar.i() == null)) {
            cVar.a(this.currentHandler.c());
            this.mPaymentState = C0137b.READY_TO_PAY;
        }
        int i = AnonymousClass4.f8164a[this.mPaymentState.ordinal()];
        if (i == 1) {
            e();
        } else if (i == 2) {
            d();
        } else if (i == 3) {
            boolean z = false;
            d dVar2 = this.currentHandler;
            if (dVar2 != null) {
                z = dVar2.a(this.pendingRequest);
            }
            if (!z) {
                a(a.PAYMENT_CANNOT_START_ACTIVITY);
            }
            this.mPaymentState = C0137b.DONE;
        }
    }

    /* renamed from: com.garena.pay.android.b$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8164a = new int[C0137b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.garena.pay.android.b$b[] r0 = com.garena.pay.android.b.C0137b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8164a = r0
                int[] r0 = f8164a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.garena.pay.android.b$b r1 = com.garena.pay.android.b.C0137b.CHOOSE_ITEM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f8164a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.garena.pay.android.b$b r1 = com.garena.pay.android.b.C0137b.CHOOSE_CHANNEL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f8164a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.garena.pay.android.b$b r1 = com.garena.pay.android.b.C0137b.READY_TO_PAY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.pay.android.b.AnonymousClass4.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        a(c.a(this.pendingRequest, aVar, aVar.getStringValue()));
    }

    public void a(c cVar) {
        a aVar = this.f8158b;
        if (aVar != null) {
            aVar.a(cVar);
        }
    }

    private void d() {
        h.a((h.a) new h.a() {
            public void a(d dVar) {
                C0137b unused = b.this.mPaymentState = C0137b.CHOOSE_ITEM;
                b bVar = b.this;
                bVar.currentHandler = dVar;
                if (!bVar.pendingRequest.a()) {
                    b.this.pendingRequest.a(b.this.currentHandler.c());
                }
                b bVar2 = b.this;
                bVar2.b(bVar2.pendingRequest);
            }

            public void a() {
                b.this.a(a.PAYMENT_USER_CANCELLED);
            }
        });
        h.a(b(), this.handlers);
        h.a(b().findViewById(a.d.main_layout));
    }

    private void e() {
        com.garena.pay.android.f.a.a((a.C0141a) new a.C0141a() {
            public void a(b.a aVar) {
                C0137b unused = b.this.mPaymentState = C0137b.READY_TO_PAY;
                b.this.pendingRequest.a(aVar);
                b bVar = b.this;
                bVar.b(bVar.pendingRequest);
                com.beetalk.sdk.e.a.b("We have a denomination chosen %s Continue with payment next step", aVar.d());
            }

            public void a() {
                com.beetalk.sdk.e.a.b("User Dismissed the Dialog Box. Therefore invoking failed to pay", new Object[0]);
                b.this.a(a.PAYMENT_USER_CANCELLED);
            }
        });
        com.garena.pay.android.f.a.a(b(), this.pendingRequest.f(), this.pendingRequest.h());
        com.garena.pay.android.f.a.a(b().findViewById(a.d.main_layout));
    }

    private void a(boolean z) {
        if (this.f8159c == null) {
            this.f8159c = new ProgressDialog(b());
        }
        this.f8159c.setProgressStyle(0);
        this.f8159c.setIndeterminate(true);
        this.f8159c.setCancelable(z);
        this.f8159c.show();
    }

    /* access modifiers changed from: private */
    public void f() {
        ProgressDialog progressDialog = this.f8159c;
        if (progressDialog != null) {
            progressDialog.hide();
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, c cVar) {
        com.beetalk.sdk.e.a.b("Response Recd from Server: %s", str);
        try {
            f();
            if (cVar != null) {
                if (com.garena.pay.android.c.f.a(str)) {
                    a(a.PAYMENT_NETWORK_CONNECTION_EXCEPTION);
                } else if (com.garena.pay.android.c.f.c(str)) {
                    a(a.PAYMENT_ERROR_IN_PARAMS);
                } else {
                    this.pendingRequest = cVar;
                    this.handlers = a(cVar, str);
                    b(cVar);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
            com.beetalk.sdk.e.a.a((Exception) e2);
            f();
            a(a.PAYMENT_INVALID_SERVER_RESPONSE);
        }
    }

    private List<b.a> a(String str) {
        try {
            return com.garena.pay.android.c.c.a(new JSONObject(str));
        } catch (JSONException e2) {
            com.beetalk.sdk.e.a.a((Exception) e2);
            a(a.PAYMENT_INVALID_SERVER_RESPONSE);
            return null;
        }
    }

    private void c(final c cVar) {
        a(false);
        com.beetalk.sdk.a.c.a().a(cVar.c(), false, new a.C0135a().a(cVar.b().e()).a(cVar.b().g()).b(cVar.b().f()).a(cVar.b().h()).c(cVar.b().d()).a(cVar.b().b().intValue()).b(cVar.b().c().intValue()).a(), new a.C0138a.C0139a() {
            public void a(String str) {
                b.this.a(str, cVar);
            }

            public void a() {
                b.this.f();
                b.this.a(a.PAYMENT_NETWORK_CONNECTION_EXCEPTION);
            }
        });
    }

    private LinkedHashMap<String, d> a(c cVar, String str) throws JSONException {
        com.beetalk.sdk.e.a.b("JSON From Payment Server %s", str);
        List<b.C0136b> a2 = com.garena.pay.android.c.c.a(str, cVar.b().a());
        List<b.a> a3 = a(str);
        if (cVar.a()) {
            cVar.a(a3);
        }
        return a(cVar, a2);
    }

    public LinkedHashMap<String, d> a(c cVar, List<b.C0136b> list) throws JSONException {
        LinkedHashMap<String, d> linkedHashMap = new LinkedHashMap<>();
        if (list != null) {
            for (b.C0136b next : list) {
                if (next.c().equalsIgnoreCase(String.valueOf(l.b.f5470a))) {
                    Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
                    intent.setPackage("com.android.vending");
                    try {
                        if (!b().getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
                            f fVar = new f(this, cVar);
                            fVar.a(next);
                            fVar.a(next.c());
                            linkedHashMap.put(String.valueOf(l.b.f5470a), fVar);
                        }
                    } catch (NullPointerException unused) {
                    }
                } else {
                    e eVar = new e(this);
                    eVar.b(next.d());
                    eVar.c(next.e());
                    eVar.a(next.c());
                    eVar.a(next);
                    linkedHashMap.put(eVar.a(), eVar);
                }
            }
        }
        return linkedHashMap;
    }

    public void a() {
        C0137b bVar = this.mPaymentState;
        this.mPaymentState = bVar.stateOfValue(bVar.getIntValue() - 1);
        if (this.mPaymentState == C0137b.INIT) {
            this.f8157a.finish();
        } else {
            b(this.pendingRequest);
        }
    }

    public Activity b() {
        return this.f8157a;
    }

    public void c() {
        for (d h : this.handlers.values()) {
            h.h();
        }
        ProgressDialog progressDialog = this.f8159c;
        if (progressDialog != null) {
            progressDialog.dismiss();
            this.f8159c = null;
        }
    }
}

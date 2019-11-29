package com.garena.pay.android;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.beetalk.sdk.l;
import com.facebook.GraphResponse;
import com.garena.d.a;
import com.garena.pay.android.c.a;
import com.garena.pay.android.d.b;
import com.garena.pay.android.d.c;
import com.garena.pay.android.d.d;
import com.garena.pay.android.d.e;
import com.shopee.app.react.modules.ui.abtesting.AbTestingModule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends d {
    private static final long serialVersionUID = 3;

    /* renamed from: a  reason: collision with root package name */
    final transient Runnable f8239a = new Runnable() {
        public void run() {
            f.this.d("Failed to obtain result in the required time: 10 seconds");
        }
    };

    /* renamed from: b  reason: collision with root package name */
    transient b f8240b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public transient b.c f8241c = new b.c() {
        public void a(c cVar, e eVar) {
            com.beetalk.sdk.e.a.c("Purchase finished: " + cVar + ", purchase: " + eVar, new Object[0]);
            if (f.this.f8240b != null) {
                if (cVar.a() == -1005) {
                    f.this.a("User Cancelled", a.PAYMENT_USER_CANCELLED);
                } else if (cVar.d()) {
                    f fVar = f.this;
                    fVar.d("Error purchasing: " + cVar);
                } else if (!f.this.b(eVar)) {
                    f.this.d("Error purchasing. Authenticity verification failed.");
                } else {
                    com.beetalk.sdk.e.a.c("Purchase successful. Now delegating to the server for Verification", new Object[0]);
                    f.this.a(eVar);
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public transient b.a f8242d = new b.a() {
        public void a(e eVar, c cVar) {
            com.beetalk.sdk.e.a.c("Finished Consumption.", new Object[0]);
            com.beetalk.sdk.e.a.a("payment-gp", "finish consumption.", new Object[0]);
            if (f.this.mustNotify) {
                com.garena.pay.android.c.e.a().a(f.this.f8239a);
                Intent intent = new Intent();
                intent.putExtra("app_point_amount", f.this.pendingRequest.i().c());
                com.beetalk.sdk.e.a.c("OnConsumeFinished get developer payload %s", eVar.d());
                com.beetalk.sdk.e.a.a("payment-gp", "onConsumeFinished sku %s , payload %s", eVar.c(), eVar.d());
                if (TextUtils.isEmpty(f.this.mCurrentCommitTxnId)) {
                    intent.putExtra("txn_id", eVar.b());
                } else {
                    intent.putExtra("txn_id", f.this.mCurrentCommitTxnId);
                    String unused = f.this.mCurrentCommitTxnId = null;
                }
                intent.putExtra("rebate_card_id", f.this.mRebateCardId);
                intent.putExtra("remaining_days", f.this.mRemainingDays);
                f fVar = f.this;
                boolean unused2 = f.super.a(fVar.pendingRequest.e().intValue(), f.this.notifyResultCode.intValue(), intent, f.this.pendingRequest);
                boolean unused3 = f.this.mustNotify = false;
            }
        }
    };
    private Intent dataNotify = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public transient b.e f8243e = new b.e() {
        public void a(c cVar, d dVar) {
            com.beetalk.sdk.e.a.c("Query inventory finished.", new Object[0]);
            com.beetalk.sdk.e.a.a("payment-gp", "query inventory Finished", new Object[0]);
            if (f.this.f8240b != null) {
                if (cVar.d()) {
                    f fVar = f.this;
                    fVar.d("Failed to query inventory: " + cVar);
                    return;
                }
                com.beetalk.sdk.e.a.c("Query inventory was successful.", new Object[0]);
                com.beetalk.sdk.e.a.a("payment-gp", "query inventory successful", new Object[0]);
                List<String> a2 = dVar.a();
                if (a2 != null) {
                    for (String next : a2) {
                        e a3 = dVar.a(next);
                        com.beetalk.sdk.e.a.a("payment-gp", "user own, sku %s, orderid %s, token %s, payload %s", next, a3.b(), a3.e(), a3.d());
                    }
                }
                if (a2.size() > 0) {
                    String str = a2.get(0);
                    e a4 = dVar.a(str);
                    f.this.pendingRequest.a(f.this.b().a(str));
                    com.beetalk.sdk.e.a.c("We have skuId %s. Consuming it", str);
                    com.beetalk.sdk.e.a.a("payment-gp", "verify and consume sku %s.", str);
                    if (a4 != null && f.this.b(a4)) {
                        boolean unused = f.this.mustNotify = true;
                        Integer unused2 = f.this.notifyResultCode = -1;
                        com.garena.pay.android.c.e.a().a(f.this.f8239a, 10000);
                        f.this.a(a4);
                    }
                }
                com.beetalk.sdk.e.a.c("Initial inventory query finished.", new Object[0]);
            }
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private transient b.d f8244f = new b.d() {
        public void a(c cVar) {
            com.beetalk.sdk.e.a.c("Setup finished.", new Object[0]);
            com.beetalk.sdk.e.a.a("payment-gp", "Setup finished", new Object[0]);
            if (cVar.a() == 3) {
                boolean unused = f.this.v3BillingSupported = false;
            } else if (!cVar.c()) {
                f fVar = f.this;
                fVar.d("Problem setting up in-app billing: " + cVar);
            } else if (f.this.f8240b != null) {
                com.beetalk.sdk.e.a.c("Setup successful. Querying inventory.", new Object[0]);
                f.this.f8240b.a(f.this.f8243e);
            }
        }
    };
    /* access modifiers changed from: private */
    public String mCurrentCommitTxnId;
    /* access modifiers changed from: private */
    public long mRebateCardId = 0;
    /* access modifiers changed from: private */
    public int mRemainingDays = 0;
    /* access modifiers changed from: private */
    public boolean mustNotify = false;
    /* access modifiers changed from: private */
    public Integer notifyResultCode = 0;
    /* access modifiers changed from: private */
    public c pendingRequest = null;
    /* access modifiers changed from: private */
    public boolean v3BillingSupported = true;

    /* access modifiers changed from: private */
    public boolean b(e eVar) {
        return true;
    }

    protected f(b bVar, c cVar) {
        super(bVar);
        this.pendingRequest = cVar;
        i();
    }

    /* access modifiers changed from: private */
    public void a(final e eVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("purchase_data", eVar.f());
        hashMap.put("data_signature", eVar.g());
        if (TextUtils.isEmpty(eVar.g()) && eVar.f().contains("android.test.purchased")) {
            hashMap.put("purchase_data", eVar.f().replace("android.test.purchased", "9999").replace("transactionId.9999", eVar.d()));
            c cVar = this.pendingRequest;
            cVar.a(cVar.a("9999"));
            hashMap.put("data_signature", "test_signature");
        }
        com.beetalk.sdk.e.a.a("payment-gp", "gop commit sku %s", eVar.c());
        com.garena.pay.android.c.a.b(new a.C0138a.C0139a() {
            public void a(String str) {
                com.beetalk.sdk.e.a.c("Google commit response from Server: %s", str);
                com.beetalk.sdk.e.a.a("payment-gp", "gop commit response for sku %s: %s", eVar.c(), str);
                a aVar = new a(str);
                if (aVar.f8256c) {
                    f.this.d(aVar.f8257d);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String unused = f.this.mCurrentCommitTxnId = jSONObject.getString("txn_id");
                    long unused2 = f.this.mRebateCardId = jSONObject.optLong("rebate_card_id");
                    int unused3 = f.this.mRemainingDays = jSONObject.optInt("remaining_days");
                } catch (JSONException e2) {
                    long unused4 = f.this.mRebateCardId = 0;
                    int unused5 = f.this.mRemainingDays = 0;
                    String unused6 = f.this.mCurrentCommitTxnId = null;
                    com.beetalk.sdk.e.a.a((Exception) e2);
                }
                if (eVar.c().equals("android.test.purchased") || eVar.c().equals(f.this.pendingRequest.i().b())) {
                    com.beetalk.sdk.e.a.c("Purchase is test sku. start consumption.", new Object[0]);
                    com.beetalk.sdk.e.a.a("payment-gp", "In commit callback, start consume", new Object[0]);
                    f.this.f8240b.a(eVar, f.this.f8242d);
                    return;
                }
                com.beetalk.sdk.e.a.c("Purchase does not match test SKU %s %s", eVar.c(), f.this.pendingRequest.i().b());
            }

            public void a() {
                Toast.makeText(f.this.client.b(), a.f.hud_network_error, 0).show();
            }
        }, hashMap);
    }

    private void i() {
        com.beetalk.sdk.e.a.a("payment-gp", "__init()", new Object[0]);
        this.f8240b = new b(this.client.b());
        this.f8240b.a(true);
        com.beetalk.sdk.e.a.c("Starting setup.", new Object[0]);
        this.f8240b.a(this.f8244f);
    }

    public int e() {
        return a.c.googleplay_icon;
    }

    public String f() {
        return com.garena.pay.android.c.f.a(this.client.b(), a.f.text_google_in_app_purchases);
    }

    /* access modifiers changed from: private */
    public void a(String str, a aVar) {
        com.beetalk.sdk.e.a.a(str, new Object[0]);
        this.client.a(com.beetalk.sdk.data.c.a(this.pendingRequest, aVar, str));
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        com.beetalk.sdk.e.a.a(str, new Object[0]);
        this.client.a(com.beetalk.sdk.data.c.a(this.pendingRequest, a.PAYMENT_GENERAL_ERROR, str));
    }

    public boolean a(final c cVar) {
        if (!this.v3BillingSupported) {
            Toast.makeText(this.client.b(), a.f.hud_billing_not_supported, 1).show();
            return false;
        }
        this.pendingRequest = cVar;
        com.garena.pay.android.c.a.a(new a.C0138a.C0139a() {
            public void a(String str) {
                com.beetalk.sdk.e.a.c("initGooglePayment Recd Reply from Server %s", str);
                try {
                    String string = new JSONObject(str).getString("txn_id");
                    if (cVar.i().b().equals("9999")) {
                        f.this.f8240b.a(f.this.client.b(), "android.test.purchased", cVar.e().intValue(), f.this.f8241c, string);
                    } else {
                        f.this.f8240b.a(f.this.client.b(), cVar.i().b(), cVar.e().intValue(), f.this.f8241c, string);
                    }
                } catch (JSONException e2) {
                    com.beetalk.sdk.e.a.a((Exception) e2);
                    f.this.d("Server did not reply correctly.");
                }
            }

            public void a() {
                Toast.makeText(f.this.client.b(), a.f.hud_network_error, 0).show();
            }
        }, j());
        return true;
    }

    private Map<String, String> j() {
        HashMap hashMap = new HashMap();
        com.garena.pay.android.a.b b2 = this.pendingRequest.b();
        hashMap.put("app_id", b2.e());
        hashMap.put("platform", String.valueOf(b2.h()));
        hashMap.put("open_id", b2.f());
        hashMap.put("client_type", String.valueOf(l.c.f5472b));
        hashMap.put("app_server_id", String.valueOf(b2.b()));
        hashMap.put("app_role_id", String.valueOf(b2.c()));
        hashMap.put("access_token", b2.d());
        hashMap.put("id", com.beetalk.sdk.e.b.b());
        com.beetalk.sdk.e.a.c("Init Request Data %s", hashMap.toString());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public boolean a(int i, int i2, Intent intent, c cVar) {
        com.beetalk.sdk.e.a.c("onActivityResult(" + i + "," + i2 + "," + intent, new Object[0]);
        if (this.f8240b == null) {
            return true;
        }
        this.mustNotify = true;
        this.notifyResultCode = Integer.valueOf(i2);
        this.dataNotify = intent;
        com.garena.pay.android.c.e.a().a(this.f8239a, 10000);
        if (i != cVar.e().intValue() || !this.f8240b.a(i, i2, intent)) {
            return false;
        }
        return true;
    }

    public void h() {
        b bVar = this.f8240b;
        if (bVar != null) {
            bVar.a();
        }
        this.f8240b = null;
        com.garena.pay.android.c.e.a().a(this.f8239a);
    }

    private class a {

        /* renamed from: b  reason: collision with root package name */
        private String f8255b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f8256c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f8257d;

        public a(String str) {
            this.f8255b = str;
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has(AbTestingModule.KEY_RESULT) && jSONObject.getString(AbTestingModule.KEY_RESULT).equals(GraphResponse.SUCCESS_KEY)) {
                    this.f8256c = false;
                    this.f8257d = "";
                } else if (jSONObject.has("error")) {
                    this.f8256c = true;
                    this.f8257d = jSONObject.getString("error");
                }
            } catch (JSONException unused) {
                this.f8256c = true;
                this.f8257d = "Cannot Parse Data from the Server";
            }
        }
    }
}

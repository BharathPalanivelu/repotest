package com.shopee.app.ui.bca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.al;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import d.d.b.j;
import d.m;

public final class BCARegisterActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    public static final a f19979c = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    public com.bca.xco.widget.b f19980a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f19981b;

    /* renamed from: d  reason: collision with root package name */
    private String f19982d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f19983e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f19984f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f19985g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private int k;
    private final Runnable l = new c(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, int i2) {
            Activity activity2 = activity;
            String str9 = str;
            String str10 = str2;
            String str11 = str3;
            String str12 = str4;
            String str13 = str5;
            String str14 = str6;
            j.b(activity2, "activity");
            j.b(str9, "requestID");
            j.b(str10, "type");
            j.b(str11, "redirectTo");
            j.b(str12, "accessToken");
            j.b(str13, "apiKey");
            j.b(str14, "apiSeed");
            j.b(str7, "customerIDMerchant");
            j.b(str8, "merchantID");
            Intent intent = new Intent(activity2, BCARegisterActivity.class);
            intent.putExtra("requestID", str9);
            intent.putExtra("type", str10);
            intent.putExtra("redirectTo", str11);
            intent.putExtra("accessToken", str12);
            intent.putExtra("apiKey", str13);
            intent.putExtra("apiSeed", str14);
            intent.putExtra("customerIDMerchant", str7);
            intent.putExtra("merchantID", str8);
            intent.putExtra("timeout", i);
            intent.putExtra("environment", i2);
            activity.startActivityForResult(intent, 1923);
        }
    }

    public final void a(String str) {
        this.f19984f = str;
    }

    public final void b(String str) {
        this.f19985g = str;
    }

    public final String a() {
        return this.h;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final String b() {
        return this.i;
    }

    public final void d(String str) {
        this.i = str;
    }

    public final void e(String str) {
        this.j = str;
    }

    public final void a(int i2) {
        this.k = i2;
    }

    public final int c() {
        return this.k;
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BCARegisterActivity f19987a;

        c(BCARegisterActivity bCARegisterActivity) {
            this.f19987a = bCARegisterActivity;
        }

        public final void run() {
            this.f19987a.a(5);
            this.f19987a.e();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bca_register);
        this.f19982d = getIntent().getStringExtra("requestID");
        this.f19983e = getIntent().getStringExtra("redirectTo");
        String stringExtra = getIntent().getStringExtra("accessToken");
        String stringExtra2 = getIntent().getStringExtra("apiKey");
        String stringExtra3 = getIntent().getStringExtra("apiSeed");
        String stringExtra4 = getIntent().getStringExtra("customerIDMerchant");
        String stringExtra5 = getIntent().getStringExtra("merchantID");
        long intExtra = 1000 * ((long) getIntent().getIntExtra("timeout", IjkMediaCodecInfo.RANK_LAST_CHANCE));
        int intExtra2 = getIntent().getIntExtra("environment", -1);
        com.garena.android.appkit.d.a.b("BCARegisterActivity " + getIntent().toUri(0), new Object[0]);
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        al loginStore = f2.e().loginStore();
        j.a((Object) loginStore, "ShopeeApplication.get().component.loginStore()");
        this.f19980a = new com.bca.xco.widget.b(this, (loginStore.e() || intExtra2 == 2) ? "PRODUCTION" : "DEV");
        com.bca.xco.widget.b bVar = this.f19980a;
        if (bVar == null) {
            j.b("bcaRegisterWidget");
        }
        bVar.setListener(new b(this));
        com.bca.xco.widget.b bVar2 = this.f19980a;
        if (bVar2 == null) {
            j.b("bcaRegisterWidget");
        }
        bVar2.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5);
        com.bca.xco.widget.b bVar3 = this.f19980a;
        if (bVar3 == null) {
            j.b("bcaRegisterWidget");
        }
        bVar3.postDelayed(this.l, intExtra);
        View findViewById = findViewById(R.id.bcaLayout);
        j.a((Object) findViewById, "findViewById(R.id.bcaLayout)");
        this.f19981b = (ViewGroup) findViewById;
        ViewGroup viewGroup = this.f19981b;
        if (viewGroup == null) {
            j.b("bcaLayout");
        }
        com.bca.xco.widget.b bVar4 = this.f19980a;
        if (bVar4 == null) {
            j.b("bcaRegisterWidget");
        }
        viewGroup.addView(bVar4);
    }

    public static final class b implements com.bca.xco.widget.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BCARegisterActivity f19986a;

        b(BCARegisterActivity bCARegisterActivity) {
            this.f19986a = bCARegisterActivity;
        }

        public void b(String str) {
            com.garena.android.appkit.d.a.b("onBCARegistered xcoID = " + str, new Object[0]);
            this.f19986a.a(str);
            this.f19986a.a(3);
        }

        public void a() {
            com.garena.android.appkit.d.a.b("onBCACloseWidget", new Object[0]);
            if (this.f19986a.c() == -1) {
                this.f19986a.a(4);
            }
            this.f19986a.e();
        }

        public void a(String str, String str2, String str3, String str4) {
            com.garena.android.appkit.d.a.b("onBCASuccess xcoID = " + str + ", credentialType = " + str2 + ", credentialNo = " + str3 + ", maxLimit = " + this.f19986a.a(), new Object[0]);
            this.f19986a.a(str);
            this.f19986a.c(str4);
            BCARegisterActivity bCARegisterActivity = this.f19986a;
            bCARegisterActivity.d(bCARegisterActivity.b());
            this.f19986a.e(str3);
            this.f19986a.a(1);
        }

        public void a(String str) {
            com.garena.android.appkit.d.a.b("onBCATokenExpired tokenStatus = " + str, new Object[0]);
            this.f19986a.b(str);
            this.f19986a.a(2);
        }
    }

    /* access modifiers changed from: private */
    public final void e() {
        com.bca.xco.widget.b bVar = this.f19980a;
        if (bVar == null) {
            j.b("bcaRegisterWidget");
        }
        bVar.removeCallbacks(this.l);
        o oVar = new o();
        o oVar2 = new o();
        oVar2.a("status", (Number) Integer.valueOf(this.k));
        oVar2.a("tokenStatus", this.f19985g);
        oVar2.a("XCOID", this.f19984f);
        oVar2.a("maxLimit", this.h);
        oVar2.a("credentialType", this.i);
        oVar2.a("credentialNo", this.j);
        oVar.a("requestID", this.f19982d);
        oVar.a("type", (Number) 0);
        oVar.a("externalReply", (l) oVar2);
        oVar.a("redirectTo", this.f19983e);
        oVar.a("BCAXOWidgetDeviceID", d());
        Intent intent = new Intent();
        o oVar3 = new o();
        oVar3.a("data", oVar.toString());
        intent.putExtra("returnData", oVar3.toString());
        intent.putExtra("returnCountKey", 0);
        setResult(-1, intent);
        finish();
    }

    public final String d() {
        try {
            Object systemService = ar.f().getSystemService("phone");
            if (systemService != null) {
                String deviceId = ((TelephonyManager) systemService).getDeviceId();
                j.a((Object) deviceId, "tm.deviceId");
                return deviceId;
            }
            throw new m("null cannot be cast to non-null type android.telephony.TelephonyManager");
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        com.bca.xco.widget.b bVar = this.f19980a;
        if (bVar == null) {
            j.b("bcaRegisterWidget");
        }
        bVar.removeCallbacks(this.l);
    }
}

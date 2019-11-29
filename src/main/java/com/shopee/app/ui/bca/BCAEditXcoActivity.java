package com.shopee.app.ui.bca;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.application.ar;
import com.shopee.app.data.store.al;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaCodecInfo;
import d.d.b.j;

public final class BCAEditXcoActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    public static final a f19970c = new a((g) null);

    /* renamed from: a  reason: collision with root package name */
    public com.bca.xco.widget.a f19971a;

    /* renamed from: b  reason: collision with root package name */
    public ViewGroup f19972b;

    /* renamed from: d  reason: collision with root package name */
    private String f19973d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f19974e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f19975f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f19976g = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private int k = -1;
    private final Runnable l = new c(this);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final void a(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, int i2) {
            Activity activity2 = activity;
            String str10 = str;
            String str11 = str2;
            String str12 = str3;
            String str13 = str4;
            String str14 = str5;
            String str15 = str7;
            String str16 = str8;
            j.b(activity2, "activity");
            j.b(str10, "requestID");
            j.b(str11, "type");
            j.b(str12, "redirectTo");
            j.b(str13, "accessToken");
            j.b(str14, "apiKey");
            j.b(str6, "apiSeed");
            j.b(str15, "customerIDMerchant");
            j.b(str16, "merchantID");
            j.b(str9, "xcoID");
            Intent intent = new Intent(activity2, BCAEditXcoActivity.class);
            intent.putExtra("requestID", str10);
            intent.putExtra("type", str11);
            intent.putExtra("redirectTo", str12);
            intent.putExtra("accessToken", str13);
            intent.putExtra("apiKey", str14);
            intent.putExtra("apiSeed", str6);
            intent.putExtra("customerIDMerchant", str15);
            intent.putExtra("merchantID", str16);
            intent.putExtra("xcoID", str9);
            intent.putExtra("timeout", i);
            intent.putExtra("environment", i2);
            activity.startActivityForResult(intent, 1923);
        }
    }

    public final void a(String str) {
        this.f19975f = str;
    }

    public final void b(String str) {
        this.f19976g = str;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final void d(String str) {
        this.i = str;
    }

    public final void e(String str) {
        this.j = str;
    }

    public final int a() {
        return this.k;
    }

    public final void a(int i2) {
        this.k = i2;
    }

    static final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BCAEditXcoActivity f19978a;

        c(BCAEditXcoActivity bCAEditXcoActivity) {
            this.f19978a = bCAEditXcoActivity;
        }

        public final void run() {
            this.f19978a.a(5);
            this.f19978a.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_bca_edit_xco);
        String stringExtra = getIntent().getStringExtra("accessToken");
        String stringExtra2 = getIntent().getStringExtra("apiKey");
        String stringExtra3 = getIntent().getStringExtra("apiSeed");
        String stringExtra4 = getIntent().getStringExtra("customerIDMerchant");
        String stringExtra5 = getIntent().getStringExtra("merchantID");
        long intExtra = ((long) getIntent().getIntExtra("timeout", IjkMediaCodecInfo.RANK_LAST_CHANCE)) * 1000;
        this.f19974e = getIntent().getStringExtra("redirectTo");
        this.f19975f = getIntent().getStringExtra("xcoID");
        this.f19973d = getIntent().getStringExtra("requestID");
        int intExtra2 = getIntent().getIntExtra("environment", -1);
        com.garena.android.appkit.d.a.b("BCARegisterActivity " + getIntent().toUri(0), new Object[0]);
        ar f2 = ar.f();
        j.a((Object) f2, "ShopeeApplication.get()");
        al loginStore = f2.e().loginStore();
        j.a((Object) loginStore, "ShopeeApplication.get().component.loginStore()");
        this.f19971a = new com.bca.xco.widget.a(this, (loginStore.e() || intExtra2 == 2) ? "PRODUCTION" : "DEV");
        com.bca.xco.widget.a aVar = this.f19971a;
        if (aVar == null) {
            j.b("bcaEditWidget");
        }
        aVar.setListener(new b(this));
        com.bca.xco.widget.a aVar2 = this.f19971a;
        if (aVar2 == null) {
            j.b("bcaEditWidget");
        }
        aVar2.a(stringExtra, stringExtra2, stringExtra3, stringExtra4, stringExtra5, this.f19975f);
        com.bca.xco.widget.a aVar3 = this.f19971a;
        if (aVar3 == null) {
            j.b("bcaEditWidget");
        }
        aVar3.postDelayed(this.l, intExtra);
        View findViewById = findViewById(R.id.bcaLayout);
        j.a((Object) findViewById, "findViewById(R.id.bcaLayout)");
        this.f19972b = (ViewGroup) findViewById;
        ViewGroup viewGroup = this.f19972b;
        if (viewGroup == null) {
            j.b("bcaLayout");
        }
        com.bca.xco.widget.a aVar4 = this.f19971a;
        if (aVar4 == null) {
            j.b("bcaEditWidget");
        }
        viewGroup.addView(aVar4);
    }

    public static final class b implements com.bca.xco.widget.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BCAEditXcoActivity f19977a;

        b(BCAEditXcoActivity bCAEditXcoActivity) {
            this.f19977a = bCAEditXcoActivity;
        }

        public void b(String str) {
            com.garena.android.appkit.d.a.b("onBCARegistered xcoID = " + str, new Object[0]);
            this.f19977a.a(str);
            this.f19977a.a(3);
        }

        public void a() {
            com.garena.android.appkit.d.a.b("onBCACloseWidget", new Object[0]);
            if (this.f19977a.a() == -1) {
                this.f19977a.a(4);
            }
            this.f19977a.b();
        }

        public void a(String str, String str2, String str3, String str4) {
            com.garena.android.appkit.d.a.b("onBCASuccess xcoID = " + str + ", credentialType = " + str2 + ", credentialNo = " + str3 + ", maxLimit = " + str4, new Object[0]);
            this.f19977a.a(str);
            this.f19977a.c(str4);
            this.f19977a.d(str2);
            this.f19977a.e(str3);
            this.f19977a.a(1);
        }

        public void a(String str) {
            com.garena.android.appkit.d.a.b("onBCATokenExpired tokenStatus = " + str, new Object[0]);
            this.f19977a.b(str);
            this.f19977a.a(2);
        }
    }

    /* access modifiers changed from: private */
    public final void b() {
        com.bca.xco.widget.a aVar = this.f19971a;
        if (aVar == null) {
            j.b("bcaEditWidget");
        }
        aVar.removeCallbacks(this.l);
        o oVar = new o();
        o oVar2 = new o();
        oVar2.a("status", (Number) Integer.valueOf(this.k));
        oVar2.a("tokenStatus", this.f19976g);
        oVar2.a("XCOID", this.f19975f);
        oVar2.a("maxLimit", this.h);
        oVar2.a("credentialType", this.i);
        oVar2.a("credentialNo", this.j);
        oVar.a("requestID", this.f19973d);
        oVar.a("type", (Number) 1);
        oVar.a("externalReply", (l) oVar2);
        oVar.a("redirectTo", this.f19974e);
        Intent intent = new Intent();
        o oVar3 = new o();
        oVar3.a("data", oVar.toString());
        intent.putExtra("returnData", oVar3.toString());
        intent.putExtra("returnCountKey", 0);
        setResult(-1, intent);
        finish();
    }
}

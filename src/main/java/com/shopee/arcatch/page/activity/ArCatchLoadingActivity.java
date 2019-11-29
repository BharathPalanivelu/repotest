package com.shopee.arcatch.page.activity;

import android.os.Bundle;
import android.view.View;
import com.shopee.arcatch.a;
import com.shopee.arcatch.b.c.b;
import com.shopee.arcatch.b.c.g;
import com.shopee.arcatch.c.a.d;
import com.shopee.arcatch.c.b.c;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import com.shopee.arcatch.data.h5_bean.ArCatchH5BeginBean;
import com.shopee.arcatch.data.h5_bean.H5ConfigParseUtil;
import com.shopee.arcatch.page.view.ArCatchDotsLoadingView;
import com.shopee.arcatch.page.view.ArCatchTitleBar;
import io.b.o;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;

public class ArCatchLoadingActivity extends com.shopee.arcatch.b.a.a {

    /* renamed from: a  reason: collision with root package name */
    private static final DecimalFormat f26943a = new DecimalFormat("0.0");

    /* renamed from: b  reason: collision with root package name */
    private ArCatchTitleBar f26944b;

    /* renamed from: c  reason: collision with root package name */
    private ArCatchDotsLoadingView f26945c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26946d = false;

    public String a() {
        return "ShopeeARCatchGame";
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.d.arcatch_activity_loading);
        com.shopee.e.a.a.a((Object) "---------------start logging----------------");
        String e2 = b.e(this);
        com.shopee.sdk.modules.app.e.b d2 = com.shopee.sdk.b.a().d();
        boolean z = false;
        int a2 = d2 != null ? d2.a().a() : 0;
        com.shopee.e.a.a.a((Object) e2);
        com.shopee.e.a.a.a((Object) "userId " + a2);
        this.f26944b = (ArCatchTitleBar) findViewById(a.c.arcatch_loading_titlebar);
        this.f26944b.setBackOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ArCatchLoadingActivity.this.finish();
            }
        });
        g.a(getWindow());
        g.a((View) this.f26944b);
        this.f26945c = (ArCatchDotsLoadingView) findViewById(a.c.arcatch_loading);
        this.f26945c.a();
        String stringExtra = getIntent().getStringExtra("PUSH_DATA_KEY");
        com.shopee.e.a.a.a((Object) "params " + stringExtra);
        ArCatchH5BeginBean parseArCatchH5BeginBean = H5ConfigParseUtil.parseArCatchH5BeginBean(stringExtra);
        if (parseArCatchH5BeginBean == null) {
            com.shopee.e.a.a.a((Object) "arCatchH5BeginBean is null");
            c.b("parse H5 params error");
            finish();
            return;
        }
        com.shopee.e.a.a.a((Object) "eventId:" + parseArCatchH5BeginBean.getEventId() + " sessionId: " + parseArCatchH5BeginBean.getSessionId());
        ConfigBean configBean = new ConfigBean();
        boolean a3 = d.a(parseArCatchH5BeginBean, configBean);
        com.shopee.e.a.a.a((Object) "paramsSuccess " + a3);
        if (!a3) {
            b();
            return;
        }
        this.f26944b.a(configBean.textConfigBean.title);
        if ((com.shopee.arcatch.c.c.a.f26755g && com.shopee.arcatch.c.c.a.h) || com.shopee.arcatch.c.d.d.a().b(configBean.paramsConfigBean.eventId).booleanValue()) {
            z = true;
        }
        com.shopee.arcatch.c.a.b.a().a(configBean);
        com.shopee.arcatch.c.a.b.a().a(z).a(io.b.a.b.a.a()).a(new a(this, System.currentTimeMillis()));
    }

    private static class a implements o<com.shopee.arcatch.c.a.c> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ArCatchLoadingActivity> f26948a;

        /* renamed from: b  reason: collision with root package name */
        private final long f26949b;

        public void a() {
        }

        public void a(io.b.b.b bVar) {
        }

        protected a(ArCatchLoadingActivity arCatchLoadingActivity, long j) {
            this.f26948a = new WeakReference<>(arCatchLoadingActivity);
            this.f26949b = j;
        }

        public void a(com.shopee.arcatch.c.a.c cVar) {
            ArCatchLoadingActivity arCatchLoadingActivity = (ArCatchLoadingActivity) this.f26948a.get();
            if (arCatchLoadingActivity != null && !arCatchLoadingActivity.isFinishing()) {
                arCatchLoadingActivity.a(this.f26949b);
                arCatchLoadingActivity.a(cVar);
            }
        }

        public void a(Throwable th) {
            th.printStackTrace();
            com.shopee.e.a.a.a(th, "ConfigureSubscriber - onError", new Object[0]);
            ArCatchLoadingActivity arCatchLoadingActivity = (ArCatchLoadingActivity) this.f26948a.get();
            if (arCatchLoadingActivity != null && !arCatchLoadingActivity.isFinishing()) {
                arCatchLoadingActivity.a(this.f26949b);
                arCatchLoadingActivity.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!this.f26946d) {
            this.f26946d = true;
            com.shopee.arcatch.c.b.a.a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f26945c.b();
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void a(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        com.shopee.e.a.a.a((Object) "loadingTime " + currentTimeMillis);
        c.a(currentTimeMillis);
    }

    /* access modifiers changed from: private */
    public void a(com.shopee.arcatch.c.a.c cVar) {
        boolean z = cVar.f26728c;
        boolean z2 = cVar.f26726a;
        if (!z) {
            com.shopee.e.a.a.a((Object) "config download fail " + cVar);
            b();
        } else if (com.shopee.arcatch.c.c.a.f26755g) {
            if (!com.shopee.arcatch.c.c.a.h || !z2) {
                com.shopee.arcatch.c.f.d.b(this);
            } else {
                com.shopee.arcatch.c.f.d.a(this);
            }
            finish();
        } else {
            ConfigBean b2 = com.shopee.arcatch.c.a.b.a().b();
            if (b2 == null || b2.paramsConfigBean == null) {
                b();
                return;
            }
            String str = b2.paramsConfigBean.eventId;
            if (!z2 || com.shopee.arcatch.c.d.d.a().b(str).booleanValue()) {
                com.shopee.arcatch.c.f.d.b(this);
            } else {
                com.shopee.arcatch.c.f.d.a(this);
            }
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        com.shopee.arcatch.c.f.d.c(this);
        finish();
    }
}

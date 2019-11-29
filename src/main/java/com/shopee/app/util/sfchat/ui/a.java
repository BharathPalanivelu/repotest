package com.shopee.app.util.sfchat.ui;

import android.os.Bundle;
import androidx.appcompat.app.d;
import androidx.fragment.app.c;
import com.salesforce.android.service.common.ui.internal.minimize.Minimizer;
import com.shopee.app.ui.common.r;
import com.shopee.app.util.sfchat.b;
import com.shopee.app.web.protocol.SalesforceChatData;
import d.d.b.j;
import d.m;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public String f26526a;

    /* renamed from: b  reason: collision with root package name */
    private r f26527b;

    /* renamed from: c  reason: collision with root package name */
    private final C0411a f26528c = new C0411a(this);

    public String a() {
        String str = this.f26526a;
        if (str == null) {
            j.b("chatData");
        }
        return str;
    }

    /* renamed from: com.shopee.app.util.sfchat.ui.a$a  reason: collision with other inner class name */
    public static final class C0411a implements com.shopee.app.util.sfchat.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f26529a;

        C0411a(a aVar) {
            this.f26529a = aVar;
        }

        public void a() {
            if (!this.f26529a.isFinishing()) {
                this.f26529a.onBackPressed();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        r rVar = new r(this);
        rVar.a();
        this.f26527b = rVar;
        Minimizer.addIgnoredActivity(getClass());
        try {
            Object a2 = com.shopee.web.sdk.bridge.internal.a.f30470a.a(a(), SalesforceChatData.class);
            if (a2 != null) {
                b.f26507a.a((c) this, (SalesforceChatData) a2, (com.shopee.app.util.sfchat.a) this.f26528c);
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.web.protocol.SalesforceChatData");
        } catch (Exception unused) {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}

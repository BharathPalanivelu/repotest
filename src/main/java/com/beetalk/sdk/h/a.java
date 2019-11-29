package com.beetalk.sdk.h;

import com.beetalk.sdk.data.b;
import com.beetalk.sdk.l;
import com.facebook.share.internal.ShareConstants;
import com.garena.e.a;
import com.garena.e.d;
import java.net.MalformedURLException;
import java.net.URL;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private b f5452a;

    public a(b bVar) {
        this.f5452a = bVar;
    }

    public void a(a.b bVar) {
        d.a aVar = new d.a();
        try {
            aVar.a("POST").a(a()).a("password", this.f5452a.f5393a).a("client_type", String.valueOf(c.f5457a)).a("app_id", String.valueOf(this.f5452a.f5396d)).a(ShareConstants.FEED_SOURCE_PARAM, String.valueOf(this.f5452a.f5397e));
            com.garena.e.a.a().a(aVar.a(), bVar);
        } catch (MalformedURLException e2) {
            com.beetalk.sdk.e.a.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public URL a() throws MalformedURLException {
        return new URL(l.b());
    }
}

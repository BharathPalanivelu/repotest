package com.beetalk.sdk.h;

import com.beetalk.sdk.l;
import com.facebook.internal.ServerProtocol;
import com.garena.e.a;
import com.garena.e.d;
import java.net.MalformedURLException;
import java.net.URL;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private long f5453a;

    /* renamed from: b  reason: collision with root package name */
    private String f5454b;

    /* renamed from: c  reason: collision with root package name */
    private String f5455c;

    /* renamed from: d  reason: collision with root package name */
    private String f5456d;

    public b(long j, String str, d dVar, String str2) {
        this.f5453a = j;
        this.f5454b = str;
        this.f5455c = dVar.getStringValue();
        this.f5456d = str2;
    }

    public void a(a.b bVar) {
        d.a aVar = new d.a();
        try {
            aVar.a("POST").a(a()).a("uid", String.valueOf(this.f5453a)).a("password", String.valueOf(this.f5454b)).a(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, this.f5455c).a("client_type", String.valueOf(c.f5457a)).a("client_id", String.valueOf(this.f5456d));
            a.a().a(aVar.a(), bVar);
        } catch (MalformedURLException e2) {
            com.beetalk.sdk.e.a.a((Exception) e2);
        }
    }

    /* access modifiers changed from: protected */
    public URL a() throws MalformedURLException {
        return new URL(l.c());
    }
}

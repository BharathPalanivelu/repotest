package com.shopee.app.d.c;

import com.shopee.app.data.store.bh;
import com.shopee.app.data.store.setting.ImageConfig;
import com.shopee.app.g.g;
import com.shopee.app.util.n;
import com.shopee.app.web.protocol.ShareMessage;

public class de extends a {

    /* renamed from: c  reason: collision with root package name */
    private final bh f16791c;

    /* renamed from: d  reason: collision with root package name */
    private final n f16792d;

    /* renamed from: e  reason: collision with root package name */
    private String f16793e;

    /* renamed from: f  reason: collision with root package name */
    private ShareMessage f16794f;

    /* renamed from: g  reason: collision with root package name */
    private ImageConfig f16795g;
    private String h;
    private int i;

    /* access modifiers changed from: protected */
    public String d() {
        return "ProcessSharingImageInteractor";
    }

    protected de(n nVar, bh bhVar) {
        super(nVar);
        this.f16792d = nVar;
        this.f16791c = bhVar;
    }

    public void a(String str, ShareMessage shareMessage, ImageConfig imageConfig, int i2, String str2) {
        this.f16793e = str;
        this.f16794f = shareMessage;
        this.f16795g = imageConfig;
        this.i = i2;
        this.h = str2;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (this.f16794f.getAvatar() != null && this.f16794f.getAvatar().endsWith("_tn")) {
            ShareMessage shareMessage = this.f16794f;
            shareMessage.setAvatar(shareMessage.getAvatar().substring(0, this.f16794f.getAvatar().length() - 3));
        }
        g.a(this.f16793e, this.f16794f, this.f16795g, this.i, this.h);
    }
}

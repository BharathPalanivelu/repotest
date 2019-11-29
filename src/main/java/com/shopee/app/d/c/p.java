package com.shopee.app.d.c;

import b.a;
import com.garena.sticker.b;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.List;

public class p extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a<be> f17109c;

    /* renamed from: d  reason: collision with root package name */
    private final a<b> f17110d;

    /* renamed from: e  reason: collision with root package name */
    private String f17111e;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetStickerInfoInteractor";
    }

    protected p(n nVar, a<be> aVar, a<b> aVar2) {
        super(nVar);
        this.f17109c = aVar;
        this.f17110d = aVar2;
    }

    public void a(String str) {
        this.f17111e = str;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        this.f17109c.get().a(this.f17111e);
        final List<String> B = this.f17109c.get().B();
        this.f16402a.a().bC.a(af.a(this.f17110d.get().b().i().a(), new af.b<StickerPack, com.garena.sticker.e.a>() {
            /* renamed from: a */
            public StickerPack map(com.garena.sticker.e.a aVar) {
                return new StickerPack(aVar, B.contains(aVar.d()));
            }
        })).a();
    }
}

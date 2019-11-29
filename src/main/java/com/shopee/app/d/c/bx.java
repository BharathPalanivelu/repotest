package com.shopee.app.d.c;

import b.a;
import com.garena.sticker.b;
import com.shopee.app.data.store.be;
import com.shopee.app.data.viewmodel.StickerPack;
import com.shopee.app.util.af;
import com.shopee.app.util.n;
import java.util.List;

public class bx extends a {

    /* renamed from: c  reason: collision with root package name */
    private final a<b> f16641c;

    /* renamed from: d  reason: collision with root package name */
    private final a<be> f16642d;

    /* access modifiers changed from: protected */
    public String d() {
        return "GetStickerInfoInteractor";
    }

    protected bx(n nVar, a<be> aVar, a<b> aVar2) {
        super(nVar);
        this.f16641c = aVar2;
        this.f16642d = aVar;
    }

    /* access modifiers changed from: protected */
    public void c() {
        final List<String> B = this.f16642d.get().B();
        this.f16402a.a().bC.a(af.a(this.f16641c.get().b().i().a(), new af.b<StickerPack, com.garena.sticker.e.a>() {
            /* renamed from: a */
            public StickerPack map(com.garena.sticker.e.a aVar) {
                return new StickerPack(aVar, B.contains(aVar.d()));
            }
        })).a();
    }
}

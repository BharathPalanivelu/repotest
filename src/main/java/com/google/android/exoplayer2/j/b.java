package com.google.android.exoplayer2.j;

import com.google.android.exoplayer2.d.g;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.nio.ByteBuffer;

public abstract class b extends g<h, i, f> implements e {

    /* renamed from: a  reason: collision with root package name */
    private final String f10478a;

    /* access modifiers changed from: protected */
    public abstract d a(byte[] bArr, int i, boolean z) throws f;

    public void a(long j) {
    }

    protected b(String str) {
        super(new h[2], new i[2]);
        this.f10478a = str;
        a(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final h g() {
        return new h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final i h() {
        return new c(this);
    }

    /* access modifiers changed from: protected */
    public final void a(i iVar) {
        super.a(iVar);
    }

    /* access modifiers changed from: protected */
    public final f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.f9280b;
            i iVar2 = iVar;
            iVar2.a(hVar.f9281c, a(byteBuffer.array(), byteBuffer.limit(), z), hVar.f10621d);
            iVar.c(RNCartPanelDataEntity.NULL_VALUE);
            return null;
        } catch (f e2) {
            return e2;
        }
    }
}

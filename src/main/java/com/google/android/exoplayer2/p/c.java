package com.google.android.exoplayer2.p;

import com.google.android.exoplayer2.g.g;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.nio.ByteBuffer;

public abstract class c extends g<i, j, g> implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f11124a;

    /* access modifiers changed from: protected */
    public abstract e a(byte[] bArr, int i, boolean z) throws g;

    public void a(long j) {
    }

    protected c(String str) {
        super(new i[2], new j[2]);
        this.f11124a = str;
        a(1024);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final i g() {
        return new i();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final j h() {
        return new d(this);
    }

    /* access modifiers changed from: protected */
    public final void a(j jVar) {
        super.a(jVar);
    }

    /* access modifiers changed from: protected */
    public final g a(i iVar, j jVar, boolean z) {
        try {
            ByteBuffer byteBuffer = iVar.f9881b;
            j jVar2 = jVar;
            jVar2.a(iVar.f9882c, a(byteBuffer.array(), byteBuffer.limit(), z), iVar.f11226d);
            jVar.c(RNCartPanelDataEntity.NULL_VALUE);
            return null;
        } catch (g e2) {
            return e2;
        }
    }
}

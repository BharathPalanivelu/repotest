package com.google.android.exoplayer2.source.a;

import com.google.android.exoplayer2.m.f;
import com.google.android.exoplayer2.m.i;
import com.google.android.exoplayer2.n.t;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.Arrays;

public abstract class j extends c {
    private byte[] i;
    private int j;
    private volatile boolean k;

    /* access modifiers changed from: protected */
    public abstract void a(byte[] bArr, int i2) throws IOException;

    public j(f fVar, i iVar, int i2, com.google.android.exoplayer2.j jVar, int i3, Object obj, byte[] bArr) {
        super(fVar, iVar, i2, jVar, i3, obj, -9223372036854775807L, -9223372036854775807L);
        this.i = bArr;
    }

    public byte[] d() {
        return this.i;
    }

    public long e() {
        return (long) this.j;
    }

    public final void a() {
        this.k = true;
    }

    public final boolean b() {
        return this.k;
    }

    public final void c() throws IOException, InterruptedException {
        try {
            this.h.a(this.f11496a);
            int i2 = 0;
            this.j = 0;
            while (i2 != -1 && !this.k) {
                f();
                i2 = this.h.a(this.i, this.j, TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
                if (i2 != -1) {
                    this.j += i2;
                }
            }
            if (!this.k) {
                a(this.i, this.j);
            }
        } finally {
            t.a(this.h);
        }
    }

    private void f() {
        byte[] bArr = this.i;
        if (bArr == null) {
            this.i = new byte[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];
        } else if (bArr.length < this.j + TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE) {
            this.i = Arrays.copyOf(bArr, bArr.length + TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
        }
    }
}

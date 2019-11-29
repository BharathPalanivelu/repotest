package com.google.android.exoplayer2.i.a;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.a.d;
import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.s.c;
import com.google.android.exoplayer2.s.l;
import com.tencent.ugc.TXRecordCommon;
import java.util.Collections;
import java.util.List;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9946b = {5512, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f9947c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9948d;

    /* renamed from: e  reason: collision with root package name */
    private int f9949e;

    public a(m mVar) {
        super(mVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(l lVar) throws d.a {
        if (!this.f9947c) {
            int g2 = lVar.g();
            this.f9949e = (g2 >> 4) & 15;
            int i = this.f9949e;
            if (i == 2) {
                this.f9958a.a(Format.a((String) null, "audio/mpeg", (String) null, -1, -1, 1, f9946b[(g2 >> 2) & 3], (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.f9948d = true;
            } else if (i == 7 || i == 8) {
                this.f9958a.a(Format.a((String) null, this.f9949e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, (int) TXRecordCommon.AUDIO_SAMPLERATE_8000, (g2 & 1) == 1 ? 2 : 3, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
                this.f9948d = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.f9949e);
            }
            this.f9947c = true;
        } else {
            lVar.d(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(l lVar, long j) {
        l lVar2 = lVar;
        if (this.f9949e == 2) {
            int b2 = lVar.b();
            this.f9958a.a(lVar2, b2);
            this.f9958a.a(j, 1, b2, 0, (m.a) null);
            return;
        }
        int g2 = lVar.g();
        if (g2 == 0 && !this.f9948d) {
            byte[] bArr = new byte[lVar.b()];
            lVar2.a(bArr, 0, bArr.length);
            Pair<Integer, Integer> a2 = c.a(bArr);
            this.f9958a.a(Format.a((String) null, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(bArr), (DrmInitData) null, 0, (String) null));
            this.f9948d = true;
        } else if (this.f9949e != 10 || g2 == 1) {
            int b3 = lVar.b();
            this.f9958a.a(lVar2, b3);
            this.f9958a.a(j, 1, b3, 0, (m.a) null);
        }
    }
}

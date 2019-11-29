package com.google.android.exoplayer2.e.a;

import android.util.Pair;
import com.google.android.exoplayer2.e.a.d;
import com.google.android.exoplayer2.e.n;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.n.b;
import com.google.android.exoplayer2.n.k;
import com.tencent.ugc.TXRecordCommon;
import java.util.Collections;
import java.util.List;

final class a extends d {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9310b = {5512, 11025, 22050, TXRecordCommon.AUDIO_SAMPLERATE_44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f9311c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9312d;

    /* renamed from: e  reason: collision with root package name */
    private int f9313e;

    public a(n nVar) {
        super(nVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(k kVar) throws d.a {
        if (!this.f9311c) {
            int g2 = kVar.g();
            this.f9313e = (g2 >> 4) & 15;
            int i = this.f9313e;
            if (i == 2) {
                this.f9322a.a(j.a((String) null, "audio/mpeg", (String) null, -1, -1, 1, f9310b[(g2 >> 2) & 3], (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, 0, (String) null));
                this.f9312d = true;
            } else if (i == 7 || i == 8) {
                this.f9322a.a(j.a((String) null, this.f9313e == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, (int) TXRecordCommon.AUDIO_SAMPLERATE_8000, (g2 & 1) == 1 ? 2 : 3, (List<byte[]>) null, (com.google.android.exoplayer2.c.a) null, 0, (String) null));
                this.f9312d = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.f9313e);
            }
            this.f9311c = true;
        } else {
            kVar.d(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(k kVar, long j) {
        k kVar2 = kVar;
        if (this.f9313e == 2) {
            int b2 = kVar.b();
            this.f9322a.a(kVar2, b2);
            this.f9322a.a(j, 1, b2, 0, (byte[]) null);
            return;
        }
        int g2 = kVar.g();
        if (g2 == 0 && !this.f9312d) {
            byte[] bArr = new byte[kVar.b()];
            kVar2.a(bArr, 0, bArr.length);
            Pair<Integer, Integer> a2 = b.a(bArr);
            this.f9322a.a(j.a((String) null, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), Collections.singletonList(bArr), (com.google.android.exoplayer2.c.a) null, 0, (String) null));
            this.f9312d = true;
        } else if (this.f9313e != 10 || g2 == 1) {
            int b3 = kVar.b();
            this.f9322a.a(kVar2, b3);
            this.f9322a.a(j, 1, b3, 0, (byte[]) null);
        }
    }
}

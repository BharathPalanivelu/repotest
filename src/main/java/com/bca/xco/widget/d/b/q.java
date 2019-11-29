package com.bca.xco.widget.d.b;

import com.tencent.ijk.media.player.IjkMediaMeta;

final class q {

    /* renamed from: a  reason: collision with root package name */
    static p f5251a;

    /* renamed from: b  reason: collision with root package name */
    static long f5252b;

    private q() {
    }

    static p a() {
        synchronized (q.class) {
            if (f5251a == null) {
                return new p();
            }
            p pVar = f5251a;
            f5251a = pVar.f5249f;
            pVar.f5249f = null;
            f5252b -= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            return pVar;
        }
    }

    static void a(p pVar) {
        if (pVar.f5249f != null || pVar.f5250g != null) {
            throw new IllegalArgumentException();
        } else if (!pVar.f5247d) {
            synchronized (q.class) {
                if (f5252b + IjkMediaMeta.AV_CH_TOP_FRONT_CENTER <= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                    f5252b += IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
                    pVar.f5249f = f5251a;
                    pVar.f5246c = 0;
                    pVar.f5245b = 0;
                    f5251a = pVar;
                }
            }
        }
    }
}

package e;

import com.tencent.ijk.media.player.IjkMediaMeta;

final class s {

    /* renamed from: a  reason: collision with root package name */
    static r f32788a;

    /* renamed from: b  reason: collision with root package name */
    static long f32789b;

    private s() {
    }

    static r a() {
        synchronized (s.class) {
            if (f32788a == null) {
                return new r();
            }
            r rVar = f32788a;
            f32788a = rVar.f32786f;
            rVar.f32786f = null;
            f32789b -= IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
            return rVar;
        }
    }

    static void a(r rVar) {
        if (rVar.f32786f != null || rVar.f32787g != null) {
            throw new IllegalArgumentException();
        } else if (!rVar.f32784d) {
            synchronized (s.class) {
                if (f32789b + IjkMediaMeta.AV_CH_TOP_FRONT_CENTER <= IjkMediaMeta.AV_CH_TOP_BACK_CENTER) {
                    f32789b += IjkMediaMeta.AV_CH_TOP_FRONT_CENTER;
                    rVar.f32786f = f32788a;
                    rVar.f32783c = 0;
                    rVar.f32782b = 0;
                    f32788a = rVar;
                }
            }
        }
    }
}

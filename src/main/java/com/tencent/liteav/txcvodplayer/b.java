package com.tencent.liteav.txcvodplayer;

import android.os.Handler;
import com.tencent.ijk.media.player.IMediaPlayer;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public IMediaPlayer f32063a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f32064b = new Handler() {
        /* JADX WARNING: type inference failed for: r9v26, types: [com.tencent.ijk.media.player.IMediaPlayer] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r9) {
            /*
                r8 = this;
                int r9 = r9.what
                r0 = 1
                if (r9 == r0) goto L_0x0007
                goto L_0x00b8
            L_0x0007:
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                r1 = 0
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.f32063a
                if (r9 != 0) goto L_0x0012
                goto L_0x00b8
            L_0x0012:
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.f32063a
                boolean r9 = r9 instanceof com.tencent.ijk.media.player.IjkMediaPlayer
                if (r9 == 0) goto L_0x0026
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.f32063a
                r1 = r9
                com.tencent.ijk.media.player.IjkMediaPlayer r1 = (com.tencent.ijk.media.player.IjkMediaPlayer) r1
                goto L_0x0045
            L_0x0026:
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.f32063a
                boolean r9 = r9 instanceof com.tencent.ijk.media.player.MediaPlayerProxy
                if (r9 == 0) goto L_0x0045
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.f32063a
                com.tencent.ijk.media.player.MediaPlayerProxy r9 = (com.tencent.ijk.media.player.MediaPlayerProxy) r9
                com.tencent.ijk.media.player.IMediaPlayer r9 = r9.getInternalMediaPlayer()
                if (r9 == 0) goto L_0x0045
                boolean r2 = r9 instanceof com.tencent.ijk.media.player.IjkMediaPlayer
                if (r2 == 0) goto L_0x0045
                r1 = r9
                com.tencent.ijk.media.player.IjkMediaPlayer r1 = (com.tencent.ijk.media.player.IjkMediaPlayer) r1
            L_0x0045:
                if (r1 != 0) goto L_0x0048
                goto L_0x00b8
            L_0x0048:
                float r9 = r1.getRate()
                float r2 = r1.getAVDiff()
                float r2 = java.lang.Math.abs(r2)
                r3 = 1056964608(0x3f000000, float:0.5)
                int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
                if (r2 <= 0) goto L_0x00a4
                r2 = 1065353216(0x3f800000, float:1.0)
                int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
                if (r2 <= 0) goto L_0x00a4
                double r2 = (double) r9
                r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
                java.lang.Double.isNaN(r2)
                double r4 = r2 - r4
                r6 = 4611686018427387904(0x4000000000000000, double:2.0)
                double r4 = r4 / r6
                r6 = 4598175219545276416(0x3fd0000000000000, double:0.25)
                double r4 = java.lang.Math.min(r4, r6)
                java.lang.Double.isNaN(r2)
                double r2 = r2 - r4
                float r9 = (float) r2
                r1.setRate(r9)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "downside rate "
                r1.append(r2)
                r1.append(r9)
                java.lang.String r9 = r1.toString()
                java.lang.String r1 = "RateHelper"
                android.util.Log.w(r1, r9)
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                android.os.Handler r9 = r9.f32064b
                r9.removeMessages(r0)
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                android.os.Handler r9 = r9.f32064b
                r1 = 3000(0xbb8, double:1.482E-320)
                r9.sendEmptyMessageDelayed(r0, r1)
                goto L_0x00b8
            L_0x00a4:
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                android.os.Handler r9 = r9.f32064b
                r9.removeMessages(r0)
                com.tencent.liteav.txcvodplayer.b r9 = com.tencent.liteav.txcvodplayer.b.this
                android.os.Handler r9 = r9.f32064b
                r1 = 500(0x1f4, double:2.47E-321)
                r9.sendEmptyMessageDelayed(r0, r1)
            L_0x00b8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.liteav.txcvodplayer.b.AnonymousClass1.handleMessage(android.os.Message):void");
        }
    };

    public void a(IMediaPlayer iMediaPlayer) {
        this.f32063a = iMediaPlayer;
        if (this.f32063a != null) {
            this.f32064b.sendEmptyMessageDelayed(1, 500);
        } else {
            this.f32064b.removeMessages(1);
        }
    }
}

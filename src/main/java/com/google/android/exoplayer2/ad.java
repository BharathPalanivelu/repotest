package com.google.android.exoplayer2;

import com.google.android.exoplayer2.l.g;
import com.google.android.exoplayer2.source.y;

public interface ad {

    public interface a {
        void onLoadingChanged(boolean z);

        void onPlaybackParametersChanged(al alVar);

        void onPlayerError(ac acVar);

        void onPlayerStateChanged(boolean z, int i);

        void onPositionDiscontinuity();

        void onTimelineChanged(ar arVar, Object obj);

        void onTracksChanged(com.google.android.exoplayer2.source.ad adVar, g gVar);
    }

    public interface b {
        void a(int i, Object obj) throws ac;
    }

    int a();

    void a(long j);

    void a(a aVar);

    void a(al alVar);

    void a(y yVar);

    void a(y yVar, boolean z, boolean z2);

    void a(boolean z);

    void a(c... cVarArr);

    void b(a aVar);

    void b(c... cVarArr);

    boolean b();

    al c();

    void d();

    long e();

    long f();

    int g();

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final b f9071a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9072b;

        /* renamed from: c  reason: collision with root package name */
        public final Object f9073c;

        public c(b bVar, int i, Object obj) {
            this.f9071a = bVar;
            this.f9072b = i;
            this.f9073c = obj;
        }
    }
}

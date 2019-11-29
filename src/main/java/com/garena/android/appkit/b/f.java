package com.garena.android.appkit.b;

import com.tencent.ijk.media.player.IjkMediaCodecInfo;

public abstract class f extends g {

    /* renamed from: a  reason: collision with root package name */
    private a f7624a = new a() {
        public void run() {
            f.this.a(this.f7626b);
            this.f7627c = false;
        }
    };

    public abstract void a(a aVar);

    public void onEvent(a aVar) {
        a aVar2 = this.f7624a;
        aVar2.f7626b = aVar;
        if (!aVar2.f7627c) {
            this.f7624a.f7627c = true;
            k.a().a(this.f7624a, IjkMediaCodecInfo.RANK_LAST_CHANCE);
        }
    }

    private static abstract class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public a f7626b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f7627c;

        private a() {
            this.f7627c = false;
        }
    }
}

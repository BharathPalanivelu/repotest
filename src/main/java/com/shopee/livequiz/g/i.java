package com.shopee.livequiz.g;

import android.media.MediaPlayer;
import android.net.Uri;
import com.garena.android.appkit.d.a;
import com.shopee.livequiz.b;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;

public class i {

    /* renamed from: e  reason: collision with root package name */
    private static i f29863e;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public MediaPlayer f29864a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public MediaPlayer f29865b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public MediaPlayer f29866c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public MediaPlayer f29867d;

    public static i a() {
        synchronized (i.class) {
            if (f29863e == null) {
                f29863e = new i();
            }
        }
        return f29863e;
    }

    public void b() {
        f.a((e) new e() {
            public void a() {
                MediaPlayer unused = i.this.f29865b = MediaPlayer.create(b.a().c(), Uri.parse(e.a().b("bgm_countdown")));
                i.this.f29865b.setLooping(true);
                MediaPlayer unused2 = i.this.f29866c = MediaPlayer.create(b.a().c(), Uri.parse(e.a().b("bgm_timeup")));
                i.this.f29866c.setLooping(false);
                MediaPlayer unused3 = i.this.f29864a = MediaPlayer.create(b.a().c(), Uri.parse(e.a().b("bgm_corroct_ans")));
                i.this.f29864a.setLooping(false);
                MediaPlayer unused4 = i.this.f29867d = MediaPlayer.create(b.a().c(), Uri.parse(e.a().b("bgm_wrong_ans")));
                i.this.f29867d.setLooping(false);
            }
        });
    }

    public void c() {
        try {
            if (this.f29865b != null) {
                this.f29865b.release();
            }
            if (this.f29866c != null) {
                this.f29866c.release();
            }
            if (this.f29867d != null) {
                this.f29867d.release();
            }
            if (this.f29864a != null) {
                this.f29864a.release();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: release error", new Object[0]);
        }
        f29863e = null;
    }

    public void d() {
        try {
            if (this.f29865b != null) {
                this.f29865b.start();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: startCountDown error", new Object[0]);
        }
    }

    public void e() {
        try {
            if (this.f29865b != null) {
                this.f29865b.pause();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: pauseCountDown error", new Object[0]);
        }
    }

    public void f() {
        try {
            if (this.f29866c != null) {
                this.f29866c.start();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: startTimeup error", new Object[0]);
        }
    }

    public void g() {
        try {
            if (this.f29864a != null) {
                this.f29864a.start();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: startCorrectAns error", new Object[0]);
        }
    }

    public void h() {
        try {
            if (this.f29867d != null) {
                this.f29867d.start();
            }
        } catch (Exception unused) {
            a.a("SoundUtil: startWrongAns error", new Object[0]);
        }
    }
}

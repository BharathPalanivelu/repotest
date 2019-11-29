package com.shopee.arcatch.c.d;

import android.annotation.TargetApi;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.shopee.arcatch.data.config_bean.AudioPathBean;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private int f26764a;

    /* renamed from: b  reason: collision with root package name */
    private int f26765b;

    /* renamed from: c  reason: collision with root package name */
    private int f26766c;

    /* renamed from: d  reason: collision with root package name */
    private int f26767d;

    /* renamed from: e  reason: collision with root package name */
    private int f26768e;

    /* renamed from: f  reason: collision with root package name */
    private SoundPool f26769f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26770g;
    private MediaPlayer h;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        static final b f26771a = new b();
    }

    private b() {
        this.f26764a = 0;
        this.f26765b = -1;
        this.f26766c = -1;
        this.f26767d = -1;
        this.f26768e = -1;
        this.f26770g = false;
    }

    public static b a() {
        return a.f26771a;
    }

    public void a(boolean z) {
        com.shopee.e.a.a.a((Object) "openMusic isMusicOpen " + z);
        this.f26770g = z;
        if (!this.f26770g) {
            try {
                if (this.h != null && this.h.isPlaying()) {
                    this.h.pause();
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "open music failed", new Object[0]);
            }
        } else if (this.h != null) {
            h();
        }
    }

    private void j() {
        AudioPathBean c2 = com.shopee.arcatch.c.a.b.a().c();
        if (c2 != null) {
            this.f26766c = a(c2.bombCaughtVoice);
            this.f26768e = a(c2.normalPropCaughtVoice);
            this.f26767d = a(c2.timesUpVoice);
            this.f26765b = a(c2.countDownVoice);
            try {
                this.h = MediaPlayer.create(com.shopee.arcatch.c.f.b.b().a(), Uri.parse(c2.gamePageBGM));
            } catch (Exception e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "load sounds failed", new Object[0]);
            }
            MediaPlayer mediaPlayer = this.h;
            if (mediaPlayer == null) {
                com.shopee.e.a.a.b("create mBgMediaPlayer fail", new Object[0]);
                return;
            }
            try {
                mediaPlayer.setLooping(true);
            } catch (Exception e3) {
                e3.printStackTrace();
                com.shopee.e.a.a.a(e3, "loadSounds setLooping failed", new Object[0]);
            }
        }
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        return this.f26769f.load(str, 1);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 21) {
            l();
        } else {
            m();
        }
    }

    @TargetApi(21)
    private void l() {
        this.f26769f = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(14).setContentType(4).build()).setMaxStreams(5).build();
    }

    private void m() {
        this.f26769f = new SoundPool(5, 3, 0);
    }

    public void b(boolean z) {
        com.shopee.e.a.a.a((Object) "ArCatchVoiceManager init mVoiceState " + this.f26764a + " isMusicOpen " + z);
        if (this.f26764a == 0) {
            this.f26764a = 1;
            this.f26770g = z;
            k();
            j();
        }
    }

    public void b() {
        if (this.f26764a == 3) {
            this.f26764a = 2;
            if (this.f26770g) {
                MediaPlayer mediaPlayer = this.h;
            }
        }
    }

    public void c() {
        int i = this.f26764a;
        if (i == 1 || i == 2) {
            this.f26764a = 3;
            try {
                if (this.h != null && this.h.isPlaying()) {
                    this.h.pause();
                }
            } catch (IllegalStateException e2) {
                e2.printStackTrace();
                com.shopee.e.a.a.a(e2, "ArCatchVoiceManager onPause failed", new Object[0]);
            }
        }
    }

    public void d() {
        com.shopee.e.a.a.a((Object) "ArCatchVoiceManager onDestroy mVoiceState " + this.f26764a + " mIsMusicOpen " + this.f26770g);
        int i = this.f26764a;
        if (i == 1 || i == 2 || i == 3) {
            this.f26764a = 0;
            SoundPool soundPool = this.f26769f;
            if (soundPool != null) {
                soundPool.release();
                this.f26769f = null;
            }
            MediaPlayer mediaPlayer = this.h;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.stop();
                    this.h.release();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    com.shopee.e.a.a.a(e2, "ArCatchVoiceManager onDestory failed", new Object[0]);
                }
            }
        }
    }

    public void e() {
        a(this.f26765b);
    }

    public void f() {
        a(this.f26767d);
    }

    public void g() {
        a(this.f26766c);
    }

    public void h() {
        com.shopee.e.a.a.a((Object) "playBGM mIsMusicOpen " + this.f26770g + " mVoiceState " + this.f26764a);
        if (this.f26770g) {
            int i = this.f26764a;
            if (i == 1 || i == 2) {
                try {
                    if (this.h != null) {
                        this.h.start();
                    }
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                    com.shopee.e.a.a.a(e2, "ArCatchVoiceManager playBGM failed", new Object[0]);
                }
            }
        }
    }

    public void i() {
        a(this.f26768e);
    }

    private void a(int i) {
        com.shopee.e.a.a.a((Object) "playAudio audioId " + i + " mVoiceState " + this.f26764a + " mIsMusicOpen " + this.f26770g);
        if (this.f26770g) {
            int i2 = this.f26764a;
            if (i2 == 1 || i2 == 2) {
                this.f26769f.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        }
    }
}

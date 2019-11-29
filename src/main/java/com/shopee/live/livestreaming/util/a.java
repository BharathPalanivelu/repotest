package com.shopee.live.livestreaming.util;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

public class a implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private AudioManager f29362a;

    /* renamed from: b  reason: collision with root package name */
    private AudioFocusRequest f29363b;

    /* renamed from: c  reason: collision with root package name */
    private Context f29364c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29365d;

    /* renamed from: e  reason: collision with root package name */
    private int f29366e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f29367f = 0;

    public a(Context context) {
        this.f29364c = context;
    }

    public void onAudioFocusChange(int i) {
        if (i == -3 || i == -2 || i == -1) {
            b();
        }
    }

    public int a() {
        if (this.f29365d) {
            return this.f29366e;
        }
        if (this.f29362a == null) {
            this.f29362a = (AudioManager) this.f29364c.getSystemService("audio");
        }
        if (this.f29362a != null) {
            if (Build.VERSION.SDK_INT < 26) {
                this.f29366e = this.f29362a.requestAudioFocus(this, 3, 2);
            } else {
                if (this.f29363b == null) {
                    this.f29363b = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(3).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this).build();
                }
                this.f29366e = this.f29362a.requestAudioFocus(this.f29363b);
            }
            this.f29365d = true;
        }
        return this.f29366e;
    }

    public int b() {
        if (this.f29362a == null) {
            this.f29362a = (AudioManager) this.f29364c.getSystemService("audio");
        }
        if (this.f29362a != null) {
            if (Build.VERSION.SDK_INT < 26) {
                this.f29367f = this.f29362a.abandonAudioFocus(this);
            } else {
                AudioFocusRequest audioFocusRequest = this.f29363b;
                if (audioFocusRequest != null) {
                    this.f29367f = this.f29362a.abandonAudioFocusRequest(audioFocusRequest);
                }
            }
            this.f29365d = false;
        }
        return this.f29367f;
    }
}

package com.shopee.arcatch.page.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.shopee.arcatch.c.a.b;
import com.shopee.arcatch.c.b.a;
import com.shopee.arcatch.data.config_bean.ConfigBean;
import java.io.File;

public class ArCatchMusicView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private MediaPlayer f27034a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f27035b;

    /* renamed from: c  reason: collision with root package name */
    private ConfigBean f27036c;

    public ArCatchMusicView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ArCatchMusicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ArCatchMusicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27035b = true;
        e();
    }

    private void e() {
        this.f27036c = b.a().b();
        this.f27035b = !this.f27036c.paramsConfigBean.mute;
        if (this.f27035b) {
            c();
        } else {
            d();
        }
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.b();
                if (ArCatchMusicView.this.f27035b) {
                    ArCatchMusicView.this.d();
                } else {
                    ArCatchMusicView.this.c();
                }
            }
        });
    }

    public void setMusicFile(String str) {
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            this.f27034a = MediaPlayer.create(getContext(), Uri.parse(str));
            this.f27034a.setLooping(true);
        }
    }

    public boolean a() {
        if (!this.f27035b) {
            return false;
        }
        MediaPlayer mediaPlayer = this.f27034a;
        if (mediaPlayer == null) {
            return false;
        }
        if (mediaPlayer.isPlaying()) {
            return true;
        }
        this.f27034a.start();
        return true;
    }

    public boolean b() {
        MediaPlayer mediaPlayer = this.f27034a;
        if (mediaPlayer == null) {
            return false;
        }
        if (!mediaPlayer.isPlaying()) {
            return true;
        }
        this.f27034a.pause();
        return true;
    }

    public void c() {
        this.f27035b = true;
        this.f27036c.paramsConfigBean.mute = false;
        setImageBitmap(b.a().d().bgmOnIcon);
        a();
    }

    public void d() {
        this.f27035b = false;
        this.f27036c.paramsConfigBean.mute = true;
        setImageBitmap(b.a().d().bgmOffIcon);
        b();
    }
}

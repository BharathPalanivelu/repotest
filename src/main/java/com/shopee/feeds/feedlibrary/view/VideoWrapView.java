package com.shopee.feeds.feedlibrary.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.util.d;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.q;
import com.shopee.feeds.feedlibrary.view.CommonCheckButton;
import com.shopee.feeds.feedlibrary.view.preview.TextureVideoView;
import com.shopee.feeds.feedlibrary.view.preview.g;
import com.squareup.a.w;

public class VideoWrapView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    RelativeLayout f28503a;

    /* renamed from: b  reason: collision with root package name */
    CommonCheckButton f28504b;

    /* renamed from: c  reason: collision with root package name */
    FrameLayout f28505c;

    /* renamed from: d  reason: collision with root package name */
    g f28506d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f28507e;

    /* renamed from: f  reason: collision with root package name */
    private int f28508f;

    /* renamed from: g  reason: collision with root package name */
    private int f28509g;

    public VideoWrapView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoWrapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoWrapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(Context context) {
        LayoutInflater.from(context).inflate(c.f.feeds_layout_wrap_videoview, this, true);
        this.f28503a = (RelativeLayout) findViewById(c.e.video_parent);
        this.f28505c = (FrameLayout) findViewById(c.e.video_container);
        this.f28504b = (CommonCheckButton) findViewById(c.e.checkbox_mute);
        this.f28507e = (ImageView) findViewById(c.e.iv_video_preview);
        this.f28504b.setCheckListener(new CommonCheckButton.a() {
            public void a(boolean z) {
                VideoWrapView.this.getVideoView().a(z);
            }
        });
        this.f28506d = new g(getContext(), true);
        this.f28506d.setCanScroll(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.f28505c.addView(this.f28506d, layoutParams);
        this.f28506d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VideoWrapView.this.getVideoView().isPlaying()) {
                    VideoWrapView.this.getVideoView().pause();
                } else {
                    VideoWrapView.this.getVideoView().start();
                }
            }
        });
    }

    public TextureVideoView getVideoView() {
        return this.f28506d.getmVideoView();
    }

    public void a() {
        if (j.a().t().isVideoSquare()) {
            this.f28506d.a();
        } else {
            this.f28506d.setRatioToVideo(true);
        }
        if (!d.a(j.a().r())) {
            this.f28506d.a(j.a().t().getOffsetX(), j.a().t().getOffsetY());
        }
    }

    public void b() {
        if (getVideoView() != null && getVideoView().isPlaying()) {
            getVideoView().pause();
        }
    }

    public void c() {
        if (getVideoView() != null) {
            getVideoView().b();
            getVideoView().start();
        }
    }

    public void a(boolean z) {
        CommonCheckButton commonCheckButton = this.f28504b;
        if (commonCheckButton != null) {
            commonCheckButton.setChecked(z);
        }
    }

    public void a(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f28508f = i;
            this.f28509g = i2;
            float f2 = (float) getContext().getResources().getDisplayMetrics().widthPixels;
            float f3 = (((float) i2) * f2) / ((float) i);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.width = (int) f2;
            layoutParams.height = (int) f3;
            setLayoutParams(layoutParams);
        }
    }

    public void d() {
        String r = j.a().r();
        if (!d.a(r)) {
            this.f28507e.setVisibility(0);
            if (this.f28508f <= 0 || this.f28509g <= 0) {
                w.a(getContext()).a(q.a(r)).a(this.f28507e);
                return;
            }
            int d2 = com.shopee.feeds.feedlibrary.view.preview.j.d(getContext());
            w.a(getContext()).a(q.a(r)).b(d2, (int) (((float) d2) * (((float) this.f28509g) / (((float) this.f28508f) * 1.0f)))).a(this.f28507e);
            return;
        }
        this.f28507e.setVisibility(8);
    }

    public void setVideoUrl(String str) {
        getVideoView().setVideoPath(str);
        getVideoView().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                if (VideoWrapView.this.getVideoView().isPlaying()) {
                    VideoWrapView.this.getVideoView().a();
                }
                VideoWrapView.this.getVideoView().start();
            }
        });
        getVideoView().start();
    }
}

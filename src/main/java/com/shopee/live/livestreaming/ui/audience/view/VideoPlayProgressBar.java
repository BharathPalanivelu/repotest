package com.shopee.live.livestreaming.ui.audience.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.shopee.live.livestreaming.c;
import com.shopee.live.livestreaming.util.d;

public class VideoPlayProgressBar extends LinearLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    ImageView f29049a;

    /* renamed from: b  reason: collision with root package name */
    TextView f29050b;

    /* renamed from: c  reason: collision with root package name */
    TextView f29051c;

    /* renamed from: d  reason: collision with root package name */
    SeekBar f29052d;

    /* renamed from: e  reason: collision with root package name */
    private int f29053e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f29054f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f29055g;
    /* access modifiers changed from: private */
    public a h;
    /* access modifiers changed from: private */
    public boolean i;

    public interface a {
        void a();

        void a(int i);

        void b();
    }

    public VideoPlayProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoPlayProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29055g = true;
        View inflate = LayoutInflater.from(context).inflate(c.f.live_streaming_layout_vod_player_progressbar, this, true);
        this.f29049a = (ImageView) inflate.findViewById(c.e.iv_player_control);
        this.f29050b = (TextView) inflate.findViewById(c.e.tv_start_time);
        this.f29051c = (TextView) inflate.findViewById(c.e.tv_end_time);
        this.f29052d = (SeekBar) inflate.findViewById(c.e.seek_bar_player_current_time);
        this.f29049a.setOnClickListener(this);
        this.f29052d.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (VideoPlayProgressBar.this.h != null && z) {
                    VideoPlayProgressBar.this.h.a(i);
                    VideoPlayProgressBar.this.setPlayStatus(true);
                }
                VideoPlayProgressBar.this.f29050b.setText(d.a((long) i));
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean unused = VideoPlayProgressBar.this.i = true;
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                boolean unused = VideoPlayProgressBar.this.i = false;
            }
        });
        setPlayStatus(false);
    }

    public void setPlayStatus(boolean z) {
        this.f29054f = z;
        this.f29049a.setImageResource(this.f29054f ? c.d.live_streaming_vod_player_stop : c.d.live_streaming_vod_player_start);
        a aVar = this.h;
        if (aVar == null) {
            return;
        }
        if (this.f29054f) {
            aVar.a();
        } else {
            aVar.b();
        }
    }

    public void setCanSeek(boolean z) {
        this.f29055g = z;
    }

    public void setEndTime(int i2) {
        this.f29053e = i2;
        this.f29052d.setMax(this.f29053e);
        this.f29051c.setText(d.a((long) i2));
    }

    public void a(int i2) {
        if (!this.i) {
            this.f29050b.setText(d.a((long) i2));
            this.f29052d.setProgress(i2);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f29055g;
    }

    public int getSeekProgress() {
        return this.f29052d.getProgress();
    }

    public void setPlayControlCallback(a aVar) {
        this.h = aVar;
    }

    public void onClick(View view) {
        setPlayStatus(!this.f29054f);
    }
}

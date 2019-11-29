package com.shopee.app.ui.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.webkit.URLUtil;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.garena.videolib.player.PlayerView;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.q.g;
import com.google.android.exoplayer2.r;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.x;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.id.R;
import java.io.File;

public class VideoViewerView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    PlayerView f25733a;

    /* renamed from: b  reason: collision with root package name */
    SeekBar f25734b;

    /* renamed from: c  reason: collision with root package name */
    TextView f25735c;

    /* renamed from: d  reason: collision with root package name */
    TextView f25736d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f25737e;

    /* renamed from: f  reason: collision with root package name */
    ViewGroup f25738f;

    /* renamed from: g  reason: collision with root package name */
    Animation f25739g;
    Animation h;
    CheckBox i;
    private String j;
    /* access modifiers changed from: private */
    public w k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public boolean n;
    /* access modifiers changed from: private */
    public long o;
    private Handler p;
    private b q;
    private int r;
    /* access modifiers changed from: private */
    public a s;
    /* access modifiers changed from: private */
    public Runnable t = new Runnable() {
        public void run() {
            if (!VideoViewerView.this.l) {
                long f2 = VideoViewerView.this.k.f();
                VideoViewerView.this.f25734b.setProgress((int) ((((float) f2) * 100.0f) / ((float) VideoViewerView.this.k.e())));
                VideoViewerView.this.f25735c.setText(com.garena.videolib.c.a.a(f2));
            }
            if (!VideoViewerView.this.m) {
                VideoViewerView videoViewerView = VideoViewerView.this;
                videoViewerView.postDelayed(videoViewerView.t, 500);
            }
        }
    };
    private Runnable u = new Runnable() {
        public void run() {
            VideoViewerView.this.h();
        }
    };

    public interface a {
        void a();

        void a(long j, long j2);
    }

    public VideoViewerView(Context context) {
        super(context);
        a(context);
    }

    public VideoViewerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public VideoViewerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @TargetApi(21)
    public VideoViewerView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context);
    }

    private void a(Context context) {
        this.p = new Handler(Looper.getMainLooper());
    }

    public void a(String str, boolean z, int i2) {
        this.j = str;
        a(z, i2);
    }

    public void a(String str, boolean z) {
        this.j = str;
        a(z, -1);
    }

    private void a(boolean z, int i2) {
        androidx.core.graphics.drawable.a.a(this.f25734b.getProgressDrawable(), -1);
        File file = new File(this.j);
        this.n = true;
        this.f25738f.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                VideoViewerView.this.a(5);
                if (motionEvent.getAction() == 1) {
                    VideoViewerView.this.a(5);
                }
                return true;
            }
        });
        if (file.exists()) {
            this.f25733a.a(Uri.fromFile(file).toString(), 3, z, i2);
        } else if (URLUtil.isNetworkUrl(this.j) && !this.j.startsWith(com.garena.videolib.a.f6703b)) {
            this.f25733a.a(this.j, com.shopee.app.util.r.a.a(this.j), z, i2);
        } else if (this.j.startsWith("/video")) {
            PlayerView playerView = this.f25733a;
            playerView.a(com.garena.videolib.a.f6703b + this.j + "?type=dash", 0, z, i2);
        } else {
            PlayerView playerView2 = this.f25733a;
            playerView2.a(com.garena.videolib.a.f6703b + "/video/" + this.j + "?type=dash", 0, z, i2);
        }
        this.f25733a.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 0) {
                    return true;
                }
                VideoViewerView videoViewerView = VideoViewerView.this;
                videoViewerView.a(videoViewerView.n ? 3 : 4);
                return true;
            }
        });
        this.k = this.f25733a.getPlayer();
        this.k.a((r.a) new r.a() {
            public void a() {
            }

            public void a(e eVar) {
            }

            public void a(q qVar) {
            }

            public void a(p pVar, g gVar) {
            }

            public void a(x xVar, Object obj) {
            }

            public void a(boolean z) {
            }

            public void a(boolean z, int i) {
                if (i == 3) {
                    VideoViewerView.this.f25736d.setText(com.garena.videolib.c.a.a(VideoViewerView.this.k.e()));
                }
            }
        });
        f();
        e();
        setControlIcon(z ? R.drawable.ic_preview_suspended : R.drawable.ic_profile_video);
        a(z ? 80 : 8);
    }

    public void setTopBarStatusListener(b bVar) {
        this.q = bVar;
    }

    private void e() {
        this.f25737e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (VideoViewerView.this.k.b()) {
                    VideoViewerView.this.c();
                } else if (VideoViewerView.this.k.a() == 4) {
                    VideoViewerView.this.k.a(0);
                    VideoViewerView.this.b();
                } else {
                    VideoViewerView.this.b();
                }
                VideoViewerView.this.a(5);
            }
        });
    }

    public boolean a() {
        return this.k.b();
    }

    public int getCurrentPosition() {
        return (int) this.k.f();
    }

    public int getDuration() {
        return (int) this.k.e();
    }

    public void b() {
        setControlIcon(R.drawable.ic_preview_suspended);
        this.k.a(true);
        this.k.a();
        this.o = this.k.f();
    }

    public void c() {
        setControlIcon(R.drawable.ic_profile_video);
        this.k.a(false);
        this.k.a();
        a aVar = this.s;
        if (aVar != null) {
            aVar.a(this.o, this.k.f());
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int unused = savedState.f25751a = this.r;
        long unused2 = savedState.f25752b = this.k.f();
        int unused3 = savedState.f25753c = this.k.b() ? 1 : 0;
        c();
        a(10);
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        int a2 = savedState.f25751a;
        long b2 = savedState.f25752b;
        boolean z = true;
        if (savedState.f25753c != 1) {
            z = false;
        }
        a(a2, b2, z);
        e();
    }

    private void a(int i2, long j2, boolean z) {
        setControlIcon(i2);
        this.k.a(j2);
        this.k.a(z);
        this.f25735c.setText(com.garena.videolib.c.a.a(j2));
        this.f25733a.setAutoPlay(z);
    }

    private void f() {
        this.f25734b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            /* renamed from: b  reason: collision with root package name */
            private boolean f25745b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f25746c;

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                long e2 = (long) ((((float) i) / 100.0f) * ((float) VideoViewerView.this.k.e()));
                if (z) {
                    VideoViewerView.this.f25735c.setText(com.garena.videolib.c.a.a(e2));
                }
                if (i >= 100) {
                    int i2 = 1;
                    this.f25746c = true;
                    VideoViewerView.this.setControlIcon(R.drawable.ic_preview_replay);
                    VideoViewerView.this.k.a(false);
                    VideoViewerView.this.k.a();
                    VideoViewerView videoViewerView = VideoViewerView.this;
                    if (!videoViewerView.n) {
                        i2 = 2;
                    }
                    videoViewerView.a(i2);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean z = true;
                boolean unused = VideoViewerView.this.l = true;
                this.f25745b = VideoViewerView.this.k.b();
                if (VideoViewerView.this.k.a() != 4) {
                    z = false;
                }
                this.f25746c = z;
                VideoViewerView.this.k.a(false);
                VideoViewerView.this.k.a();
                VideoViewerView.this.a(6);
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                boolean unused = VideoViewerView.this.l = false;
                int e2 = (int) VideoViewerView.this.k.e();
                int progress = (int) ((((float) seekBar.getProgress()) / 100.0f) * ((float) e2));
                long j = (long) progress;
                VideoViewerView.this.k.a(j);
                long unused2 = VideoViewerView.this.o = j;
                if (this.f25745b) {
                    VideoViewerView.this.k.a(true);
                    VideoViewerView.this.k.a();
                }
                if (this.f25746c && progress < e2) {
                    VideoViewerView.this.setControlIcon(R.drawable.ic_profile_video);
                }
                VideoViewerView.this.a(7);
                if (VideoViewerView.this.s != null) {
                    VideoViewerView.this.s.a();
                }
            }
        });
        this.t.run();
    }

    /* access modifiers changed from: private */
    public void setControlIcon(int i2) {
        this.f25737e.setImageResource(i2);
        this.r = i2;
    }

    public void d() {
        this.f25733a.a();
        this.m = true;
        a(9);
    }

    private void g() {
        this.n = true;
        this.f25738f.startAnimation(this.f25739g);
        this.f25738f.setVisibility(0);
        this.f25737e.setVisibility(0);
        b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.n);
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        this.n = false;
        b bVar = this.q;
        if (bVar != null) {
            bVar.a(this.n);
        }
        this.f25738f.startAnimation(this.h);
        this.f25738f.setVisibility(8);
        this.f25737e.setVisibility(8);
    }

    public void a(int i2) {
        boolean b2 = this.k.b();
        j();
        if (i2 == 2 || i2 == 4 || i2 == 10) {
            g();
        } else if (i2 == 3) {
            h();
            return;
        }
        if (this.n && b2) {
            i();
        } else if (i2 == 80) {
            i();
        }
    }

    public void setVideoStateListener(a aVar) {
        this.s = aVar;
    }

    private void i() {
        this.p.postDelayed(this.u, 2000);
    }

    private void j() {
        this.p.removeCallbacks(this.u);
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f25751a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public long f25752b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f25753c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f25751a = parcel.readInt();
            this.f25752b = parcel.readLong();
            this.f25753c = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f25751a);
            parcel.writeLong(this.f25752b);
            parcel.writeInt(this.f25753c);
        }
    }

    public void a(boolean z, boolean z2, final CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.i.setVisibility(z ? 0 : 8);
        if (z) {
            this.i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
                        VideoViewerView.this.k.a((float) BitmapDescriptorFactory.HUE_RED);
                    } else {
                        VideoViewerView.this.k.a(1.0f);
                    }
                    CompoundButton.OnCheckedChangeListener onCheckedChangeListener = onCheckedChangeListener;
                    if (onCheckedChangeListener != null) {
                        onCheckedChangeListener.onCheckedChanged(compoundButton, z);
                    }
                }
            });
            this.i.setChecked(z2);
        }
    }
}

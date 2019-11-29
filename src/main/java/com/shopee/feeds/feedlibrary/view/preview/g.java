package com.shopee.feeds.feedlibrary.view.preview;

import a.h;
import a.k;
import android.content.Context;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.view.MyTwoScrollView;
import java.util.concurrent.Callable;

public class g extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a  reason: collision with root package name */
    b f28668a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28669b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final MyTwoScrollView f28670c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextureVideoView f28671d;

    /* renamed from: e  reason: collision with root package name */
    private float f28672e = 1.0f;

    /* renamed from: f  reason: collision with root package name */
    private float f28673f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f28674g;
    private int h;
    private boolean i = false;
    /* access modifiers changed from: private */
    public String j;
    private boolean k;
    private boolean l = true;

    public interface b {
        void a(int i, int i2);

        void a(boolean z);
    }

    public g(Context context, boolean z) {
        super(context);
        inflate(context, c.f.feeds_video_player, this);
        this.f28671d = (TextureVideoView) findViewById(c.e.video_view);
        this.f28670c = (MyTwoScrollView) findViewById(c.e.panView);
        this.f28670c.setOnDownUpCallBack(new MyTwoScrollView.a() {
            public void a() {
                if (g.this.f28668a != null) {
                    g.this.f28668a.a(g.this.f28671d.isPlaying());
                }
            }
        });
        this.f28671d.setOnVideoSizeChangedListener(this);
        this.f28671d.setOnCompletionListener(this);
        this.f28669b = j.d(context);
        this.k = z;
    }

    public void a(Float f2, Float f3) {
        this.f28672e = f2.floatValue();
        this.f28673f = f3.floatValue();
        this.f28671d.invalidate();
        this.f28671d.requestLayout();
    }

    public void setRatioToVideo(boolean z) {
        this.i = true;
        int i2 = this.f28674g;
        if (i2 > 0) {
            int i3 = this.h;
            if (i3 > 0) {
                float f2 = ((float) i2) / (((float) i3) * 1.0f);
                if (f2 < 0.952f) {
                    this.f28672e = 1.0f;
                    this.f28673f = 1.05f;
                } else if (f2 > 1.91f) {
                    this.f28672e = 1.91f;
                    this.f28673f = 1.0f;
                } else {
                    this.f28672e = Float.valueOf((float) i2).floatValue();
                    this.f28673f = Float.valueOf((float) this.h).floatValue();
                }
                if (z) {
                    this.f28671d.invalidate();
                    this.f28671d.requestLayout();
                }
            }
        }
    }

    public void a() {
        this.i = false;
        this.f28672e = 1.0f;
        this.f28673f = 1.0f;
        this.f28671d.invalidate();
        this.f28671d.requestLayout();
    }

    public void b() {
        this.f28671d.a();
    }

    public void c() {
        this.f28671d.pause();
    }

    public void setCanScroll(boolean z) {
        this.l = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        float f2 = this.f28672e;
        float f3 = this.f28673f;
        if (f2 == f3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f28669b, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f28669b, 1073741824));
        } else if (f2 > f3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f28669b, 1073741824), View.MeasureSpec.makeMeasureSpec((int) ((((float) this.f28669b) * this.f28673f) / this.f28672e), 1073741824));
        } else if (f3 > f2) {
            if (this.k) {
                int i6 = this.f28669b;
                int i7 = i6;
                i5 = (int) (((float) i6) * (f3 / (f2 * 1.0f)));
                i4 = i7;
            } else {
                i5 = this.f28669b;
                i4 = (int) (((float) i5) * (f2 / (f3 * 1.0f)));
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
        }
    }

    public void setVideoPath(String str) {
        this.j = str;
        this.f28671d.setVideoPath(str);
    }

    public void d() {
        this.f28671d.start();
    }

    public void e() {
        this.f28671d.b();
        this.f28671d.start();
    }

    public int getmVideoWidth() {
        return this.f28674g;
    }

    public int getmVideoHeight() {
        return this.h;
    }

    public TextureVideoView getmVideoView() {
        return this.f28671d;
    }

    public void a(final int i2, final int i3) {
        f.a().a(new Runnable() {
            public void run() {
                if (g.this.f28670c != null) {
                    g.this.f28670c.scrollTo(i2, i3);
                }
            }
        }, 200);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        if (mediaPlayer.getVideoWidth() != this.f28674g || mediaPlayer.getVideoHeight() != this.h) {
            this.f28674g = mediaPlayer.getVideoWidth();
            this.h = mediaPlayer.getVideoHeight();
            b bVar = this.f28668a;
            if (bVar != null) {
                bVar.a(this.f28674g, this.h);
            }
            if (this.i) {
                setRatioToVideo(true);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.l) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void getCropVideoParam() {
        k.a(new Callable<a>() {
            /* JADX WARNING: Removed duplicated region for block: B:18:0x012d  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0133  */
            /* JADX WARNING: Removed duplicated region for block: B:24:0x0139  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x013f  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0176 A[Catch:{ Exception -> 0x0181 }] */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x0186  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0202  */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0207  */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0216  */
            /* renamed from: a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.shopee.feeds.feedlibrary.view.preview.a call() throws java.lang.Exception {
                /*
                    r17 = this;
                    r0 = r17
                    com.shopee.feeds.feedlibrary.view.preview.g$a r1 = new com.shopee.feeds.feedlibrary.view.preview.g$a
                    r2 = 0
                    r1.<init>()
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    java.lang.String r2 = r2.j
                    r1.f28681a = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    int r2 = r2.getMeasuredWidth()
                    r1.f28682b = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    int r2 = r2.getMeasuredHeight()
                    r1.f28683c = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    com.shopee.feeds.feedlibrary.view.MyTwoScrollView r2 = r2.f28670c
                    int r2 = r2.getScrollX()
                    r1.f28684d = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    com.shopee.feeds.feedlibrary.view.MyTwoScrollView r2 = r2.f28670c
                    int r2 = r2.getScrollY()
                    r1.f28685e = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    com.shopee.feeds.feedlibrary.view.preview.TextureVideoView r2 = r2.f28671d
                    int r2 = r2.getMeasuredWidth()
                    r1.f28686f = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    com.shopee.feeds.feedlibrary.view.preview.TextureVideoView r2 = r2.f28671d
                    int r2 = r2.getMeasuredHeight()
                    r1.f28687g = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    com.shopee.feeds.feedlibrary.view.preview.TextureVideoView r2 = r2.f28671d
                    int r2 = r2.getDuration()
                    r1.h = r2
                    com.shopee.feeds.feedlibrary.view.preview.g r2 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    android.content.Context r2 = r2.getContext()
                    java.lang.String r2 = com.shopee.feeds.feedlibrary.view.preview.j.b(r2)
                    r1.i = r2
                    com.shopee.feeds.feedlibrary.util.j r2 = com.shopee.feeds.feedlibrary.util.j.a()
                    com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam r2 = r2.s()
                    if (r2 == 0) goto L_0x0078
                    com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam$Platform r3 = r2.getAndroid()
                    if (r3 != 0) goto L_0x007c
                L_0x0078:
                    com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam r2 = com.shopee.feeds.feedlibrary.util.e.a()
                L_0x007c:
                    com.shopee.feeds.feedlibrary.data.entity.MediaCompressParam$Platform r2 = r2.getAndroid()
                    int r2 = r2.getMaxVideoWidth()
                    com.shopee.feeds.feedlibrary.util.j r3 = com.shopee.feeds.feedlibrary.util.j.a()
                    com.shopee.feeds.feedlibrary.data.entity.VideoCompressUploadEntity r3 = r3.j()
                    r3.setVideo_max_width(r2)
                    java.lang.String r3 = r1.f28681a
                    r4 = 2
                    android.graphics.Bitmap r3 = android.media.ThumbnailUtils.createVideoThumbnail(r3, r4)
                    int r4 = r3.getWidth()
                    int r5 = r3.getHeight()
                    r3.recycle()
                    com.shopee.feeds.feedlibrary.util.j r3 = com.shopee.feeds.feedlibrary.util.j.a()
                    com.shopee.feeds.feedlibrary.data.entity.VideoCompressUploadEntity r3 = r3.j()
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    r6.append(r4)
                    java.lang.String r7 = " * "
                    r6.append(r7)
                    r6.append(r5)
                    java.lang.String r6 = r6.toString()
                    r3.setVideo_original_resolution(r6)
                    int r3 = r1.f28682b
                    float r3 = (float) r3
                    int r6 = r1.f28683c
                    float r6 = (float) r6
                    r8 = 1065353216(0x3f800000, float:1.0)
                    float r6 = r6 * r8
                    float r3 = r3 / r6
                    double r9 = (double) r3
                    float r3 = (float) r4
                    float r6 = (float) r5
                    float r6 = r6 * r8
                    float r3 = r3 / r6
                    double r11 = (double) r3
                    int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
                    if (r3 <= 0) goto L_0x00e9
                    int r3 = r1.f28683c
                    int r3 = r3 * r4
                    int r6 = r1.f28682b
                    int r3 = r3 / r6
                    int r6 = r1.f28683c
                    int r6 = r6 * r4
                    int r9 = r1.f28682b
                    int r6 = r6 / r9
                    r10 = r3
                    r9 = r4
                    r3 = r6
                    r6 = r9
                    goto L_0x00fa
                L_0x00e9:
                    int r3 = r1.f28682b
                    int r3 = r3 * r5
                    int r6 = r1.f28683c
                    int r3 = r3 / r6
                    int r6 = r1.f28682b
                    int r6 = r6 * r5
                    int r9 = r1.f28683c
                    int r6 = r6 / r9
                    r9 = r3
                    r3 = r5
                    r10 = r3
                L_0x00fa:
                    int r11 = r1.f28684d
                    int r11 = r11 * r4
                    int r12 = r1.f28686f
                    int r11 = r11 / r12
                    int r12 = r1.f28685e
                    int r12 = r12 * r5
                    int r5 = r1.f28687g
                    int r5 = r12 / r5
                    if (r6 >= r3) goto L_0x011c
                    if (r3 <= r2) goto L_0x0128
                    float r4 = (float) r2
                    float r3 = (float) r3
                    float r3 = r3 * r8
                    float r4 = r4 / r3
                    float r3 = (float) r6
                    float r3 = r3 * r4
                    int r3 = (int) r3
                    r16 = r3
                    r3 = r2
                    r2 = r16
                    goto L_0x0129
                L_0x011c:
                    if (r4 <= r2) goto L_0x0128
                    float r4 = (float) r2
                    float r6 = (float) r6
                    float r6 = r6 * r8
                    float r4 = r4 / r6
                    float r3 = (float) r3
                    float r3 = r3 * r4
                    int r3 = (int) r3
                    goto L_0x0129
                L_0x0128:
                    r2 = r6
                L_0x0129:
                    int r4 = r2 % 2
                    if (r4 == 0) goto L_0x012f
                    int r2 = r2 + -1
                L_0x012f:
                    int r4 = r3 % 2
                    if (r4 == 0) goto L_0x0135
                    int r3 = r3 + -1
                L_0x0135:
                    int r4 = r9 % 2
                    if (r4 == 0) goto L_0x013b
                    int r9 = r9 + -1
                L_0x013b:
                    int r4 = r10 % 2
                    if (r4 == 0) goto L_0x0141
                    int r10 = r10 + -1
                L_0x0141:
                    org.b.a.a r4 = new org.b.a.a
                    java.lang.String r6 = r1.f28681a
                    r4.<init>(r6)
                    r6 = 0
                    java.lang.String r12 = java.lang.String.valueOf(r6)
                    r4.h = r12
                    int r12 = r1.h
                    int r12 = r12 / 1000
                    double r12 = (double) r12
                    r4.i = r12
                    r4.f33854a = r2
                    r4.f33855b = r3
                    r12 = 18
                    r4.l = r12
                    r13 = 20
                    r4.m = r13
                    java.lang.String r13 = "ultrafast"
                    r4.n = r13
                    android.media.MediaMetadataRetriever r13 = new android.media.MediaMetadataRetriever
                    r13.<init>()
                    java.lang.String r14 = r1.f28681a
                    r13.setDataSource(r14)
                    int r14 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0181 }
                    r15 = 17
                    if (r14 < r15) goto L_0x0181
                    r14 = 24
                    java.lang.String r13 = r13.extractMetadata(r14)     // Catch:{ Exception -> 0x0181 }
                    int r13 = java.lang.Integer.parseInt(r13)     // Catch:{ Exception -> 0x0181 }
                    goto L_0x0182
                L_0x0181:
                    r13 = 0
                L_0x0182:
                    r14 = 90
                    if (r13 == r14) goto L_0x0193
                    r14 = 270(0x10e, float:3.78E-43)
                    if (r13 != r14) goto L_0x018b
                    goto L_0x0193
                L_0x018b:
                    r13 = r2
                    r14 = r3
                    r16 = r11
                    r11 = r5
                    r5 = r16
                    goto L_0x019a
                L_0x0193:
                    r14 = r2
                    r13 = r3
                    r16 = r10
                    r10 = r9
                    r9 = r16
                L_0x019a:
                    android.graphics.Rect r15 = new android.graphics.Rect
                    int r9 = r9 + r5
                    int r10 = r10 + r11
                    r15.<init>(r5, r11, r9, r10)
                    r4.f33854a = r13
                    r4.f33855b = r14
                    java.lang.String r4 = r1.i
                    com.shopee.feeds.feedlibrary.view.preview.k$a r4 = com.shopee.feeds.feedlibrary.view.preview.k.a()
                    r4.a(r15)
                    com.shopee.feeds.feedlibrary.util.j r5 = com.shopee.feeds.feedlibrary.util.j.a()
                    r5.a((android.graphics.Rect) r15)
                    r4.a((int) r13, (int) r14)
                    com.shopee.feeds.feedlibrary.util.j r4 = com.shopee.feeds.feedlibrary.util.j.a()
                    r4.c((int) r14)
                    com.shopee.feeds.feedlibrary.util.j r4 = com.shopee.feeds.feedlibrary.util.j.a()
                    r4.b((int) r13)
                    com.shopee.feeds.feedlibrary.util.j r4 = com.shopee.feeds.feedlibrary.util.j.a()
                    com.shopee.feeds.feedlibrary.data.entity.VideoCompressUploadEntity r4 = r4.j()
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder
                    r5.<init>()
                    r5.append(r13)
                    r5.append(r7)
                    r5.append(r14)
                    java.lang.String r5 = r5.toString()
                    r4.setVideo_output_resolution(r5)
                    com.shopee.feeds.feedlibrary.view.preview.a r4 = new com.shopee.feeds.feedlibrary.view.preview.a
                    java.lang.String r5 = r1.f28681a
                    java.lang.String r7 = r1.f28681a
                    java.lang.String r9 = "video/mp4"
                    r4.<init>(r5, r9, r7)
                    java.lang.String r5 = r1.f28681a
                    r4.a((java.lang.String) r5)
                    int r5 = r1.h
                    long r9 = (long) r5
                    r4.a((long) r9)
                    r4.e(r12)
                    int r5 = r1.f28682b
                    int r7 = r1.f28683c
                    if (r5 != r7) goto L_0x0207
                    r5 = 1
                    r4.a((boolean) r5)
                    goto L_0x020a
                L_0x0207:
                    r4.a((boolean) r6)
                L_0x020a:
                    r4.c(r2)
                    r4.d(r3)
                    int r5 = r1.f28684d
                    int r6 = r1.f28685e
                    if (r2 >= r3) goto L_0x022c
                    int r2 = r1.f28685e
                    com.shopee.feeds.feedlibrary.view.preview.g r3 = com.shopee.feeds.feedlibrary.view.preview.g.this
                    android.content.Context r3 = r3.getContext()
                    int r3 = com.shopee.feeds.feedlibrary.util.w.a((android.content.Context) r3)
                    int r2 = r2 * r3
                    float r2 = (float) r2
                    int r1 = r1.f28682b
                    float r1 = (float) r1
                    float r1 = r1 * r8
                    float r2 = r2 / r1
                    int r6 = (int) r2
                L_0x022c:
                    r4.a((int) r5)
                    r4.b(r6)
                    return r4
                */
                throw new UnsupportedOperationException("Method not decompiled: com.shopee.feeds.feedlibrary.view.preview.g.AnonymousClass4.call():com.shopee.feeds.feedlibrary.view.preview.a");
            }
        }).a(new h<a, Object>() {
            public Object then(k<a> kVar) throws Exception {
                a f2 = kVar.f();
                if (f2 == null) {
                    return null;
                }
                org.greenrobot.eventbus.c.a().c(f2);
                return null;
            }
        }, k.f377b);
    }

    public boolean f() {
        TextureVideoView textureVideoView = this.f28671d;
        if (textureVideoView != null) {
            return textureVideoView.isPlaying();
        }
        return false;
    }

    public Float getRatioWidth() {
        return Float.valueOf(this.f28672e);
    }

    public Float getRatioHeight() {
        return Float.valueOf(this.f28673f);
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f28671d.isPlaying()) {
            this.f28671d.a();
        }
        this.f28671d.start();
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f28681a;

        /* renamed from: b  reason: collision with root package name */
        public int f28682b;

        /* renamed from: c  reason: collision with root package name */
        public int f28683c;

        /* renamed from: d  reason: collision with root package name */
        public int f28684d;

        /* renamed from: e  reason: collision with root package name */
        public int f28685e;

        /* renamed from: f  reason: collision with root package name */
        public int f28686f;

        /* renamed from: g  reason: collision with root package name */
        public int f28687g;
        public int h;
        public String i;

        private a() {
        }
    }

    public void setVideoSizeChangeCallBack(b bVar) {
        this.f28668a = bVar;
    }
}

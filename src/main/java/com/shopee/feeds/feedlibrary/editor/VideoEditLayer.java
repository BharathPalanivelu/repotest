package com.shopee.feeds.feedlibrary.editor;

import a.h;
import a.k;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.share.internal.ShareConstants;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.f.f;
import com.shopee.feeds.feedlibrary.activity.SelectProductActivity;
import com.shopee.feeds.feedlibrary.c;
import com.shopee.feeds.feedlibrary.data.entity.SaveProductEntity;
import com.shopee.feeds.feedlibrary.editor.a.b;
import com.shopee.feeds.feedlibrary.editor.b.d;
import com.shopee.feeds.feedlibrary.util.b.e;
import com.shopee.feeds.feedlibrary.util.j;
import com.shopee.feeds.feedlibrary.util.u;
import com.shopee.feeds.feedlibrary.view.preview.TextureVideoView;
import com.shopee.feeds.feedlibrary.view.preview.g;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class VideoEditLayer extends d<FrameLayout> {
    /* access modifiers changed from: private */
    public int m = 360;
    /* access modifiers changed from: private */
    public int n = 360;
    /* access modifiers changed from: private */
    public int o = 0;
    private int p;
    private boolean q;
    private ImageView r;
    private g s;
    /* access modifiers changed from: private */
    public String t;

    /* access modifiers changed from: protected */
    public void c() {
    }

    public int getSourceMode() {
        return 2;
    }

    public VideoEditLayer(Context context) {
        super(context);
    }

    public VideoEditLayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VideoEditLayer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.f27928c = findViewById(c.e.video_container);
        ((ImageView) findViewById(c.e.iv_picture)).setVisibility(8);
        this.f27926a.setVisibility(0);
        this.r = (ImageView) findViewById(c.e.iv_video_stop);
        this.s = new g(getContext(), true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        ((FrameLayout) this.f27928c).addView(this.s, layoutParams);
    }

    public FrameLayout getSourceView() {
        return (FrameLayout) this.f27928c;
    }

    public TextureVideoView getVideoView() {
        return this.s.getmVideoView();
    }

    public void b() {
        if (getVideoView() != null) {
            e.l(this.q);
            if (this.q) {
                j();
            } else {
                i();
            }
        }
    }

    public void d() {
        this.t = "";
    }

    public void e() {
        if (j.a().t().isVideoSquare()) {
            this.s.a();
        } else {
            this.s.setRatioToVideo(true);
        }
        this.s.a(j.a().t().getOffsetX(), j.a().t().getOffsetY());
    }

    public void a(String str, int i) {
        if (!TextUtils.isEmpty(str) && getVideoView() != null) {
            getVideoView().setVideoPath(str);
            getVideoView().setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (VideoEditLayer.this.getVideoView().isPlaying()) {
                        VideoEditLayer.this.getVideoView().a();
                    }
                    VideoEditLayer.this.getVideoView().start();
                }
            });
            getVideoView().start();
        }
        if (j.a().t() == null) {
            this.p = i;
        } else {
            this.p = j.a().t().getDuration();
        }
        this.i = str;
    }

    public void f() {
        this.m = j.a().t().getVideoWidth();
        this.n = j.a().t().getVideoHeight();
        if (this.m > 0 && this.n > 0) {
            float f2 = (float) getContext().getResources().getDisplayMetrics().widthPixels;
            float f3 = (((float) this.n) * f2) / ((float) this.m);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.width = (int) f2;
            layoutParams.height = (int) f3;
            setLayoutParams(layoutParams);
        }
    }

    public void setIfTagCanDelete(boolean z) {
        getTagEditor().a(z);
    }

    public void a(boolean z, b.C0428b bVar) {
        if (q() || r()) {
            if (!com.shopee.feeds.feedlibrary.util.d.a(this.t)) {
                bVar.a(this.t);
                return;
            }
            this.h.setVisibility(8);
            b(z, bVar);
            j.a().d(this.i);
            j.a().b(true);
        } else if (!com.shopee.feeds.feedlibrary.util.d.a(this.t) && !s()) {
            a(bVar, this.t);
        } else if (l()) {
            this.h.setVisibility(8);
            if (z) {
                g();
            }
            c(z, bVar);
            j.a().b(false);
        } else {
            bVar.a(this.i);
        }
    }

    private void b(final boolean z, final b.C0428b bVar) {
        k.a(new Callable<Object>() {
            public Object call() throws Exception {
                com.shopee.feeds.feedlibrary.view.preview.k.a();
                final String b2 = com.shopee.feeds.feedlibrary.view.preview.j.b(VideoEditLayer.this.getContext());
                j.a().f(false);
                f.a().a(new Runnable() {
                    public void run() {
                        String unused = VideoEditLayer.this.t = b2;
                        bVar.a(b2);
                        if (z) {
                            VideoEditLayer.this.h();
                        }
                    }
                });
                return null;
            }
        });
    }

    private void a(final b.C0428b bVar, final String str) {
        k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                File file = new File(com.shopee.feeds.feedlibrary.view.preview.j.b(VideoEditLayer.this.getContext()).replace(".mp4", "_cover.png"));
                if (file.createNewFile()) {
                    a.b("exit file", new Object[0]);
                }
                VideoEditLayer.this.setDrawingCacheEnabled(false);
                VideoEditLayer.this.f27927b.destroyDrawingCache();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                VideoEditLayer.this.setDrawingCacheEnabled(true);
                VideoEditLayer.this.f27927b.buildDrawingCache();
                VideoEditLayer.this.f27927b.getDrawingCache().compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                j.a().d(file.getAbsolutePath());
                return file.getAbsolutePath();
            }
        }).a(new h<String, Object>() {
            public Object then(k<String> kVar) throws Exception {
                bVar.a(str);
                return null;
            }
        }, k.f377b);
    }

    private void c(final boolean z, final b.C0428b bVar) {
        k.a(new Callable<String>() {
            /* renamed from: a */
            public String call() throws Exception {
                int unused = VideoEditLayer.this.o = 0;
                try {
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(VideoEditLayer.this.i);
                    if (Build.VERSION.SDK_INT >= 17) {
                        int unused2 = VideoEditLayer.this.o = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                    }
                } catch (Exception unused3) {
                    int unused4 = VideoEditLayer.this.o = 0;
                }
                File file = new File(com.shopee.feeds.feedlibrary.view.preview.j.b(VideoEditLayer.this.getContext()).replace(".mp4", z ? "_cover_clean.png" : "_cover.png"));
                if (file.createNewFile()) {
                    a.b("exit file", new Object[0]);
                }
                VideoEditLayer.this.setDrawingCacheEnabled(false);
                VideoEditLayer.this.f27927b.destroyDrawingCache();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                VideoEditLayer.this.setDrawingCacheEnabled(true);
                VideoEditLayer.this.f27927b.buildDrawingCache();
                Bitmap drawingCache = VideoEditLayer.this.f27927b.getDrawingCache();
                if (z) {
                    Matrix matrix = new Matrix();
                    float[] a2 = VideoEditLayer.b(drawingCache, VideoEditLayer.this.m, VideoEditLayer.this.n);
                    matrix.setScale(a2[0], a2[1]);
                    if (z && VideoEditLayer.this.o != 0) {
                        matrix.postRotate((float) (VideoEditLayer.this.o * -1));
                    }
                    drawingCache = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), drawingCache.getHeight(), matrix, true);
                }
                drawingCache.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                if (!z) {
                    j.a().d(file.getAbsolutePath());
                }
                if (z) {
                    j.a().c(file.getAbsolutePath());
                }
                return file.getAbsolutePath();
            }
        }).a(new h<String, Void>() {
            /* renamed from: a */
            public Void then(k<String> kVar) throws Exception {
                if (TextUtils.isEmpty(kVar.f())) {
                    f.a().a(new Runnable() {
                        public void run() {
                            VideoEditLayer.this.h();
                            bVar.a(VideoEditLayer.this.i);
                        }
                    });
                    return null;
                } else if (!z) {
                    f.a().a(new Runnable() {
                        public void run() {
                            bVar.a(VideoEditLayer.this.i);
                        }
                    });
                    return null;
                } else {
                    com.shopee.feeds.feedlibrary.view.preview.k.a();
                    final String b2 = com.shopee.feeds.feedlibrary.view.preview.j.b(VideoEditLayer.this.getContext());
                    j.a().f(true);
                    f.a().a(new Runnable() {
                        public void run() {
                            String unused = VideoEditLayer.this.t = b2;
                            bVar.a(b2);
                            if (z) {
                                VideoEditLayer.this.h();
                            }
                        }
                    });
                    return null;
                }
            }
        }, (Executor) k.f376a);
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        findViewById(c.e.checkbox_mute).setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void h() {
        super.h();
        this.h.setVisibility(0);
    }

    public void a(SaveProductEntity saveProductEntity) {
        if (this.j.e()) {
            Intent intent = new Intent(getContext(), SelectProductActivity.class);
            intent.putExtra(ShareConstants.FEED_SOURCE_PARAM, getSourceMode());
            intent.putExtra("select", 1);
            if (saveProductEntity != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("save", saveProductEntity);
                intent.putExtras(bundle);
            }
            getContext().startActivity(intent);
        } else if (this.j.d() == 5) {
            u.a(getContext(), com.garena.android.appkit.tools.b.a(c.g.feeds_max_tags_tips_video, 5));
        }
    }

    public void i() {
        if (!this.q) {
            if (getVideoView() != null) {
                getVideoView().pause();
            }
            this.q = true;
        }
    }

    public void j() {
        if (this.q) {
            if (getVideoView() != null) {
                getVideoView().start();
            }
            this.q = false;
        }
    }

    /* access modifiers changed from: private */
    public static float[] b(Bitmap bitmap, int i, int i2) {
        float[] fArr = {1.0f, 1.0f};
        fArr[1] = ((float) i2) / ((float) bitmap.getHeight());
        fArr[0] = ((float) i) / ((float) bitmap.getWidth());
        return fArr;
    }

    private boolean r() {
        return this.k.a().isEmpty() && this.l.a().isEmpty();
    }

    private boolean s() {
        return this.l.n();
    }
}

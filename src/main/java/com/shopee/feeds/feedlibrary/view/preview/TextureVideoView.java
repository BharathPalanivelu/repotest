package com.shopee.feeds.feedlibrary.view.preview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.opengl.GLES20;
import android.os.Build;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import java.io.IOException;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    private MediaPlayer.OnInfoListener A;
    private MediaPlayer.OnErrorListener B;
    private MediaPlayer.OnBufferingUpdateListener C;

    /* renamed from: a  reason: collision with root package name */
    MediaPlayer.OnVideoSizeChangedListener f28612a;

    /* renamed from: b  reason: collision with root package name */
    MediaPlayer.OnPreparedListener f28613b;

    /* renamed from: c  reason: collision with root package name */
    public a f28614c;

    /* renamed from: d  reason: collision with root package name */
    TextureView.SurfaceTextureListener f28615d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f28616e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, String> f28617f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f28618g;
    /* access modifiers changed from: private */
    public int h;
    /* access modifiers changed from: private */
    public Surface i;
    /* access modifiers changed from: private */
    public MediaPlayer j;
    private int k;
    /* access modifiers changed from: private */
    public int l;
    /* access modifiers changed from: private */
    public int m;
    /* access modifiers changed from: private */
    public MediaController n;
    /* access modifiers changed from: private */
    public MediaPlayer.OnCompletionListener o;
    /* access modifiers changed from: private */
    public MediaPlayer.OnPreparedListener p;
    /* access modifiers changed from: private */
    public int q;
    /* access modifiers changed from: private */
    public MediaPlayer.OnErrorListener r;
    /* access modifiers changed from: private */
    public MediaPlayer.OnInfoListener s;
    /* access modifiers changed from: private */
    public int t;
    /* access modifiers changed from: private */
    public boolean u;
    /* access modifiers changed from: private */
    public boolean v;
    /* access modifiers changed from: private */
    public boolean w;
    private boolean x;
    /* access modifiers changed from: private */
    public MediaPlayer.OnVideoSizeChangedListener y;
    private MediaPlayer.OnCompletionListener z;

    public interface a {
        void a();
    }

    public TextureVideoView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f28618g = 0;
        this.h = 0;
        this.i = null;
        this.j = null;
        this.x = true;
        this.f28612a = new MediaPlayer.OnVideoSizeChangedListener() {
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                if (TextureVideoView.this.y != null) {
                    TextureVideoView.this.y.onVideoSizeChanged(mediaPlayer, i, i2);
                }
                int unused = TextureVideoView.this.l = mediaPlayer.getVideoWidth();
                int unused2 = TextureVideoView.this.m = mediaPlayer.getVideoHeight();
                TextureVideoView.this.f();
                if (TextureVideoView.this.l != 0 && TextureVideoView.this.m != 0) {
                    TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.l, TextureVideoView.this.m);
                    TextureVideoView.this.requestLayout();
                }
            }
        };
        this.f28613b = new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                int unused = TextureVideoView.this.f28618g = 2;
                TextureVideoView textureVideoView = TextureVideoView.this;
                boolean unused2 = textureVideoView.u = textureVideoView.v = textureVideoView.w = true;
                if (TextureVideoView.this.p != null) {
                    TextureVideoView.this.p.onPrepared(TextureVideoView.this.j);
                }
                if (TextureVideoView.this.n != null) {
                    TextureVideoView.this.n.setEnabled(true);
                }
                if (TextureVideoView.this.y != null) {
                    TextureVideoView.this.y.onVideoSizeChanged(mediaPlayer, mediaPlayer.getVideoWidth(), mediaPlayer.getVideoHeight());
                }
                int unused3 = TextureVideoView.this.l = mediaPlayer.getVideoWidth();
                int unused4 = TextureVideoView.this.m = mediaPlayer.getVideoHeight();
                TextureVideoView.this.f();
                int h = TextureVideoView.this.t;
                if (h != 0) {
                    TextureVideoView.this.seekTo(h);
                }
                if (TextureVideoView.this.l != 0 && TextureVideoView.this.m != 0) {
                    TextureVideoView.this.getSurfaceTexture().setDefaultBufferSize(TextureVideoView.this.l, TextureVideoView.this.m);
                    if (TextureVideoView.this.h == 3) {
                        TextureVideoView.this.start();
                        if (TextureVideoView.this.n != null) {
                            TextureVideoView.this.n.show();
                        }
                    } else if (TextureVideoView.this.isPlaying()) {
                    } else {
                        if ((h != 0 || TextureVideoView.this.getCurrentPosition() > 0) && TextureVideoView.this.n != null) {
                            TextureVideoView.this.n.show(0);
                        }
                    }
                } else if (TextureVideoView.this.h == 3) {
                    TextureVideoView.this.start();
                }
            }
        };
        this.z = new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mediaPlayer) {
                int unused = TextureVideoView.this.f28618g = 5;
                int unused2 = TextureVideoView.this.h = 5;
                if (TextureVideoView.this.n != null) {
                    TextureVideoView.this.n.hide();
                }
                if (TextureVideoView.this.o != null) {
                    TextureVideoView.this.o.onCompletion(TextureVideoView.this.j);
                }
            }
        };
        this.A = new MediaPlayer.OnInfoListener() {
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (TextureVideoView.this.s == null) {
                    return true;
                }
                TextureVideoView.this.s.onInfo(mediaPlayer, i, i2);
                return true;
            }
        };
        this.B = new MediaPlayer.OnErrorListener() {
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                com.garena.android.appkit.d.a.b("TextureVideoView", "Error: " + i + "," + i2);
                int unused = TextureVideoView.this.f28618g = -1;
                int unused2 = TextureVideoView.this.h = -1;
                if (TextureVideoView.this.n != null) {
                    TextureVideoView.this.n.hide();
                }
                if ((TextureVideoView.this.r == null || !TextureVideoView.this.r.onError(TextureVideoView.this.j, i, i2)) && TextureVideoView.this.getWindowToken() != null) {
                    TextureVideoView.this.getContext().getResources();
                    new AlertDialog.Builder(TextureVideoView.this.getContext()).setMessage(i == 200 ? 17039381 : 17039377).setPositiveButton(17039376, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            if (TextureVideoView.this.o != null) {
                                TextureVideoView.this.o.onCompletion(TextureVideoView.this.j);
                            }
                        }
                    }).setCancelable(false).show();
                }
                return true;
            }
        };
        this.C = new MediaPlayer.OnBufferingUpdateListener() {
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                int unused = TextureVideoView.this.q = i;
            }
        };
        this.f28615d = new TextureView.SurfaceTextureListener() {
            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                boolean z = true;
                boolean z2 = TextureVideoView.this.h == 3;
                if (i <= 0 || i2 <= 0) {
                    z = false;
                }
                if (TextureVideoView.this.j != null && z2 && z) {
                    if (TextureVideoView.this.t != 0) {
                        TextureVideoView textureVideoView = TextureVideoView.this;
                        textureVideoView.seekTo(textureVideoView.t);
                    }
                    TextureVideoView.this.start();
                }
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                Surface unused = TextureVideoView.this.i = new Surface(surfaceTexture);
                TextureVideoView.this.d();
                if (TextureVideoView.this.f28614c != null) {
                    TextureVideoView.this.f28614c.a();
                }
            }

            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                if (TextureVideoView.this.i != null) {
                    TextureVideoView.this.i.release();
                    Surface unused = TextureVideoView.this.i = null;
                }
                if (TextureVideoView.this.n != null) {
                    TextureVideoView.this.n.hide();
                }
                TextureVideoView.this.b(true);
                return true;
            }
        };
        this.l = 0;
        this.m = 0;
        setSurfaceTextureListener(this.f28615d);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.f28618g = 0;
        this.h = 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int defaultSize = getDefaultSize(Math.max(this.l, 300), i2);
        int defaultSize2 = getDefaultSize(Math.max(this.l, 300), i3);
        if (this.l > 0 && this.m > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            i5 = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            i4 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = this.l;
                int i7 = i6 * i4;
                int i8 = this.m;
                if (i7 < i5 * i8) {
                    i5 = (i6 * i4) / i8;
                } else if (i6 * i4 > i5 * i8) {
                    defaultSize2 = (i8 * i5) / i6;
                    i4 = defaultSize2;
                }
                setMeasuredDimension(i5, i4);
            }
            if (mode == 1073741824) {
                int i9 = (this.m * i5) / this.l;
                if (mode2 != Integer.MIN_VALUE || i9 <= i4) {
                    i4 = i9;
                }
            } else if (mode2 == 1073741824) {
                int i10 = (this.l * i4) / this.m;
                if (mode != Integer.MIN_VALUE || i10 <= i5) {
                    i5 = i10;
                }
            } else {
                f();
                defaultSize = this.l;
                defaultSize2 = this.m;
            }
            setMeasuredDimension(i5, i4);
        }
        i5 = defaultSize;
        i4 = defaultSize2;
        setMeasuredDimension(i5, i4);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureVideoView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        a(uri, (Map<String, String>) null);
    }

    public void a(Uri uri, Map<String, String> map) {
        this.f28616e = uri;
        this.f28617f = map;
        this.t = 0;
        d();
        requestLayout();
        invalidate();
    }

    public void a() {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.j.release();
            this.j = null;
            this.f28618g = 0;
            this.h = 0;
            if (this.x) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        }
        c();
    }

    private void c() {
        if (this.i != null && Build.VERSION.SDK_INT >= 16) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, (int[]) null);
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL10 egl102 = egl10;
            EGLDisplay eGLDisplay = eglGetDisplay;
            EGLConfig[] eGLConfigArr2 = eGLConfigArr;
            egl102.eglChooseConfig(eGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr2, eGLConfigArr.length, new int[1]);
            EGLConfig eGLConfig = eGLConfigArr[0];
            EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, this.i, new int[]{12344});
            egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
            GLES20.glClearColor(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f);
            GLES20.glClear(TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE);
            egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
            egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
            egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
            egl10.eglTerminate(eglGetDisplay);
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f28616e != null && this.i != null) {
            b(false);
            if (this.x) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).requestAudioFocus((AudioManager.OnAudioFocusChangeListener) null, 3, 1);
            }
            try {
                this.j = new MediaPlayer();
                if (this.k != 0) {
                    this.j.setAudioSessionId(this.k);
                } else {
                    this.k = this.j.getAudioSessionId();
                }
                this.j.setOnPreparedListener(this.f28613b);
                this.j.setOnVideoSizeChangedListener(this.f28612a);
                this.j.setOnCompletionListener(this.z);
                this.j.setOnErrorListener(this.B);
                this.j.setOnInfoListener(this.A);
                this.j.setOnBufferingUpdateListener(this.C);
                this.q = 0;
                this.j.setDataSource(getContext().getApplicationContext(), this.f28616e, this.f28617f);
                this.j.setSurface(this.i);
                this.j.setAudioStreamType(3);
                this.j.setScreenOnWhilePlaying(true);
                this.j.prepareAsync();
                this.f28618g = 1;
                e();
            } catch (IOException e2) {
                com.garena.android.appkit.d.a.c("TextureVideoView", "Unable to open content: " + this.f28616e, e2);
                this.f28618g = -1;
                this.h = -1;
                this.B.onError(this.j, 1, 0);
            } catch (IllegalArgumentException e3) {
                com.garena.android.appkit.d.a.c("TextureVideoView", "Unable to open content: " + this.f28616e, e3);
                this.f28618g = -1;
                this.h = -1;
                this.B.onError(this.j, 1, 0);
            }
        }
    }

    public void setMediaController(MediaController mediaController) {
        MediaController mediaController2 = this.n;
        if (mediaController2 != null) {
            mediaController2.hide();
        }
        this.n = mediaController;
        e();
    }

    private void e() {
        if (this.j != null) {
            MediaController mediaController = this.n;
            if (mediaController != null) {
                mediaController.setMediaPlayer(this);
                this.n.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
                this.n.setEnabled(h());
            }
        }
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.y = onVideoSizeChangedListener;
    }

    /* access modifiers changed from: private */
    public void f() {
        int i2 = this.l;
        int i3 = this.m;
        if (i2 > i3) {
            double d2 = (double) (((float) i2) / (((float) i3) * 1.0f));
            this.m = ((View) getParent()).getMeasuredHeight();
            double d3 = (double) this.m;
            Double.isNaN(d3);
            Double.isNaN(d2);
            this.l = (int) (d3 * d2);
        }
        int i4 = this.m;
        int i5 = this.l;
        if (i4 > i5) {
            double d4 = (double) (((float) i4) / (((float) i5) * 1.0f));
            this.l = ((View) getParent()).getMeasuredWidth();
            double d5 = (double) this.l;
            Double.isNaN(d5);
            Double.isNaN(d4);
            this.m = (int) (d5 * d4);
        }
        int i6 = this.l;
        if (i6 == this.m && i6 < ((View) getParent()).getMeasuredWidth()) {
            this.l = ((View) getParent()).getMeasuredWidth();
            this.m = this.l;
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.p = onPreparedListener;
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.o = onCompletionListener;
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.r = onErrorListener;
    }

    public void setAvalibaleCallback(a aVar) {
        this.f28614c = aVar;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.s = onInfoListener;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.j.release();
            this.j = null;
            this.f28618g = 0;
            if (z2) {
                this.h = 0;
            }
            if (this.x) {
                ((AudioManager) getContext().getApplicationContext().getSystemService("audio")).abandonAudioFocus((AudioManager.OnAudioFocusChangeListener) null);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!h() || this.n == null) {
            return false;
        }
        g();
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!h() || this.n == null) {
            return false;
        }
        g();
        return false;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z2 = (i2 == 4 || i2 == 24 || i2 == 25 || i2 == 164 || i2 == 82 || i2 == 5 || i2 == 6) ? false : true;
        if (h() && z2 && this.n != null) {
            if (i2 == 79 || i2 == 85) {
                if (this.j.isPlaying()) {
                    pause();
                    this.n.show();
                } else {
                    start();
                    this.n.hide();
                }
                return true;
            } else if (i2 == 126) {
                if (!this.j.isPlaying()) {
                    start();
                    this.n.hide();
                }
                return true;
            } else if (i2 == 86 || i2 == 127) {
                if (this.j.isPlaying()) {
                    pause();
                    this.n.show();
                }
                return true;
            } else {
                g();
            }
        }
        return super.onKeyDown(i2, keyEvent);
    }

    private void g() {
        if (this.n.isShowing()) {
            this.n.hide();
        } else {
            this.n.show();
        }
    }

    public void start() {
        if (h()) {
            this.j.start();
            this.f28618g = 3;
        }
        this.h = 3;
    }

    public void pause() {
        if (h() && this.j.isPlaying()) {
            this.j.pause();
            this.f28618g = 4;
        }
        this.h = 4;
    }

    public void b() {
        d();
    }

    public int getDuration() {
        if (h()) {
            return this.j.getDuration();
        }
        return -1;
    }

    public int getCurrentPosition() {
        if (h()) {
            return this.j.getCurrentPosition();
        }
        return 0;
    }

    public void seekTo(int i2) {
        if (h()) {
            this.j.seekTo(i2);
            this.t = 0;
            return;
        }
        this.t = i2;
    }

    public boolean isPlaying() {
        return h() && this.j.isPlaying();
    }

    public int getBufferPercentage() {
        if (this.j != null) {
            return this.q;
        }
        return 0;
    }

    private boolean h() {
        if (this.j != null) {
            int i2 = this.f28618g;
            return (i2 == -1 || i2 == 0 || i2 == 1) ? false : true;
        }
    }

    public boolean canPause() {
        return this.u;
    }

    public boolean canSeekBackward() {
        return this.v;
    }

    public boolean canSeekForward() {
        return this.w;
    }

    public int getAudioSessionId() {
        if (this.k == 0) {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.k = mediaPlayer.getAudioSessionId();
            mediaPlayer.release();
        }
        return this.k;
    }

    public void setShouldRequestAudioFocus(boolean z2) {
        this.x = z2;
    }

    public void a(boolean z2) {
        MediaPlayer mediaPlayer = this.j;
        if (mediaPlayer != null) {
            float f2 = BitmapDescriptorFactory.HUE_RED;
            float f3 = z2 ? BitmapDescriptorFactory.HUE_RED : 1.0f;
            if (!z2) {
                f2 = 1.0f;
            }
            mediaPlayer.setVolume(f3, f2);
        }
    }
}

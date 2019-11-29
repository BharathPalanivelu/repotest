package com.tencent.liteav.txcvodplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.ISurfaceTextureHolder;
import com.tencent.ijk.media.player.ISurfaceTextureHost;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(14)
public class TextureRenderView extends TextureView implements a {
    private static final String TAG = "TextureRenderView";
    private c mMeasureHelper;
    /* access modifiers changed from: private */
    public b mSurfaceCallback;

    public View getView() {
        return this;
    }

    public boolean shouldWaitForResize() {
        return false;
    }

    public TextureRenderView(Context context) {
        super(context);
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public TextureRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    @TargetApi(21)
    public TextureRenderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(Context context) {
        this.mMeasureHelper = new c(this);
        this.mSurfaceCallback = new b(this);
        setSurfaceTextureListener(this.mSurfaceCallback);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        try {
            this.mSurfaceCallback.a();
            super.onDetachedFromWindow();
            this.mSurfaceCallback.b();
        } catch (Exception unused) {
        }
    }

    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mMeasureHelper.a(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.mMeasureHelper.b(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        this.mMeasureHelper.a(i);
        setRotation((float) i);
    }

    public void setAspectRatio(int i) {
        this.mMeasureHelper.b(i);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mMeasureHelper.c(i, i2);
        setMeasuredDimension(this.mMeasureHelper.a(), this.mMeasureHelper.b());
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.mSurfaceCallback.f32046a, this.mSurfaceCallback);
    }

    private static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private TextureRenderView f32042a;

        /* renamed from: b  reason: collision with root package name */
        private SurfaceTexture f32043b;

        /* renamed from: c  reason: collision with root package name */
        private ISurfaceTextureHost f32044c;

        /* renamed from: d  reason: collision with root package name */
        private Surface f32045d;

        public a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.f32042a = textureRenderView;
            this.f32043b = surfaceTexture;
            this.f32044c = iSurfaceTextureHost;
        }

        @TargetApi(16)
        public void a(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT < 16 || !(iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    this.f32045d = b();
                    iMediaPlayer.setSurface(this.f32045d);
                    return;
                }
                ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
                this.f32042a.mSurfaceCallback.a(false);
                if (this.f32042a.getSurfaceTexture() != null) {
                    this.f32043b = this.f32042a.getSurfaceTexture();
                }
                try {
                    SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
                    if (surfaceTexture != null) {
                        this.f32042a.setSurfaceTexture(surfaceTexture);
                        this.f32042a.mSurfaceCallback.a(surfaceTexture);
                    } else {
                        if (this.f32045d != null) {
                            iMediaPlayer.setSurface(this.f32045d);
                        }
                        iSurfaceTextureHolder.setSurfaceTexture(this.f32043b);
                        iSurfaceTextureHolder.setSurfaceTextureHost(this.f32042a.mSurfaceCallback);
                    }
                    this.f32045d = iMediaPlayer.getSurface();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        public a a() {
            return this.f32042a;
        }

        public Surface b() {
            SurfaceTexture surfaceTexture = this.f32043b;
            if (surfaceTexture == null) {
                return null;
            }
            if (this.f32045d == null) {
                this.f32045d = new Surface(surfaceTexture);
            }
            return this.f32045d;
        }
    }

    public void addRenderCallback(a.C0493a aVar) {
        this.mSurfaceCallback.a(aVar);
    }

    public void removeRenderCallback(a.C0493a aVar) {
        this.mSurfaceCallback.b(aVar);
    }

    private static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public SurfaceTexture f32046a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32047b;

        /* renamed from: c  reason: collision with root package name */
        private int f32048c;

        /* renamed from: d  reason: collision with root package name */
        private int f32049d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f32050e = true;

        /* renamed from: f  reason: collision with root package name */
        private boolean f32051f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f32052g = false;
        private WeakReference<TextureRenderView> h;
        private Map<a.C0493a, Object> i = new ConcurrentHashMap();

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public b(TextureRenderView textureRenderView) {
            this.h = new WeakReference<>(textureRenderView);
        }

        public void a(boolean z) {
            this.f32050e = z;
        }

        public void a(SurfaceTexture surfaceTexture) {
            this.f32046a = surfaceTexture;
        }

        public void a(a.C0493a aVar) {
            a aVar2;
            this.i.put(aVar, aVar);
            if (this.f32046a != null) {
                aVar2 = new a((TextureRenderView) this.h.get(), this.f32046a, this);
                aVar.a(aVar2, this.f32048c, this.f32049d);
            } else {
                aVar2 = null;
            }
            if (this.f32047b) {
                if (aVar2 == null) {
                    aVar2 = new a((TextureRenderView) this.h.get(), this.f32046a, this);
                }
                aVar.a(aVar2, 0, this.f32048c, this.f32049d);
            }
        }

        public void b(a.C0493a aVar) {
            this.i.remove(aVar);
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f32046a = surfaceTexture;
            this.f32047b = false;
            this.f32048c = 0;
            this.f32049d = 0;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            for (a.C0493a a2 : this.i.keySet()) {
                a2.a(aVar, 0, 0);
            }
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            this.f32046a = surfaceTexture;
            this.f32047b = true;
            this.f32048c = i2;
            this.f32049d = i3;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            for (a.C0493a a2 : this.i.keySet()) {
                a2.a(aVar, 0, i2, i3);
            }
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.f32046a = surfaceTexture;
            this.f32047b = false;
            this.f32048c = 0;
            this.f32049d = 0;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            for (a.C0493a a2 : this.i.keySet()) {
                a2.a(aVar);
            }
            TXCLog.d(TextureRenderView.TAG, "onSurfaceTextureDestroyed: destroy: " + this.f32050e);
            return this.f32050e;
        }

        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: null");
            } else if (this.f32052g) {
                if (surfaceTexture != this.f32046a) {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f32050e) {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                } else {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                }
            } else if (this.f32051f) {
                if (surfaceTexture != this.f32046a) {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                } else if (!this.f32050e) {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    a(true);
                } else {
                    TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                }
            } else if (surfaceTexture != this.f32046a) {
                TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (!this.f32050e) {
                TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                a(true);
            } else {
                TXCLog.d(TextureRenderView.TAG, "releaseSurfaceTexture: alive: will released by TextureView");
            }
        }

        public void a() {
            TXCLog.d(TextureRenderView.TAG, "willDetachFromWindow()");
            this.f32051f = true;
        }

        public void b() {
            TXCLog.d(TextureRenderView.TAG, "didDetachFromWindow()");
            this.f32052g = true;
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }
}

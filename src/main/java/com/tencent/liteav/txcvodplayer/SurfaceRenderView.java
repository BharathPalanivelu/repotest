package com.tencent.liteav.txcvodplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.ISurfaceTextureHolder;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.txcvodplayer.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SurfaceRenderView extends SurfaceView implements a {

    /* renamed from: a  reason: collision with root package name */
    private c f32005a;

    /* renamed from: b  reason: collision with root package name */
    private b f32006b;

    public View getView() {
        return this;
    }

    public boolean shouldWaitForResize() {
        return true;
    }

    public SurfaceRenderView(Context context) {
        super(context);
        a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public SurfaceRenderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context);
    }

    private void a(Context context) {
        this.f32005a = new c(this);
        this.f32006b = new b(this);
        getHolder().addCallback(this.f32006b);
        getHolder().setType(0);
    }

    public void setVideoSize(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f32005a.a(i, i2);
            getHolder().setFixedSize(i, i2);
            requestLayout();
        }
    }

    public void setVideoSampleAspectRatio(int i, int i2) {
        if (i > 0 && i2 > 0) {
            this.f32005a.b(i, i2);
            requestLayout();
        }
    }

    public void setVideoRotation(int i) {
        TXCLog.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }

    public void setAspectRatio(int i) {
        this.f32005a.b(i);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.f32005a.c(i, i2);
        setMeasuredDimension(this.f32005a.a(), this.f32005a.b());
    }

    private static final class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceRenderView f32007a;

        /* renamed from: b  reason: collision with root package name */
        private SurfaceHolder f32008b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.f32007a = surfaceRenderView;
            this.f32008b = surfaceHolder;
        }

        public void a(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (Build.VERSION.SDK_INT >= 16 && (iMediaPlayer instanceof ISurfaceTextureHolder)) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture((SurfaceTexture) null);
                }
                iMediaPlayer.setDisplay(this.f32008b);
            }
        }

        public a a() {
            return this.f32007a;
        }
    }

    public void addRenderCallback(a.C0493a aVar) {
        this.f32006b.a(aVar);
    }

    public void removeRenderCallback(a.C0493a aVar) {
        this.f32006b.b(aVar);
    }

    private static final class b implements SurfaceHolder.Callback {

        /* renamed from: a  reason: collision with root package name */
        private SurfaceHolder f32009a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f32010b;

        /* renamed from: c  reason: collision with root package name */
        private int f32011c;

        /* renamed from: d  reason: collision with root package name */
        private int f32012d;

        /* renamed from: e  reason: collision with root package name */
        private int f32013e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<SurfaceRenderView> f32014f;

        /* renamed from: g  reason: collision with root package name */
        private Map<a.C0493a, Object> f32015g = new ConcurrentHashMap();

        public b(SurfaceRenderView surfaceRenderView) {
            this.f32014f = new WeakReference<>(surfaceRenderView);
        }

        public void a(a.C0493a aVar) {
            a aVar2;
            this.f32015g.put(aVar, aVar);
            if (this.f32009a != null) {
                aVar2 = new a((SurfaceRenderView) this.f32014f.get(), this.f32009a);
                aVar.a(aVar2, this.f32012d, this.f32013e);
            } else {
                aVar2 = null;
            }
            if (this.f32010b) {
                if (aVar2 == null) {
                    aVar2 = new a((SurfaceRenderView) this.f32014f.get(), this.f32009a);
                }
                aVar.a(aVar2, this.f32011c, this.f32012d, this.f32013e);
            }
        }

        public void b(a.C0493a aVar) {
            this.f32015g.remove(aVar);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.f32009a = surfaceHolder;
            this.f32010b = false;
            this.f32011c = 0;
            this.f32012d = 0;
            this.f32013e = 0;
            a aVar = new a((SurfaceRenderView) this.f32014f.get(), this.f32009a);
            for (a.C0493a a2 : this.f32015g.keySet()) {
                a2.a(aVar, 0, 0);
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.f32009a = null;
            this.f32010b = false;
            this.f32011c = 0;
            this.f32012d = 0;
            this.f32013e = 0;
            a aVar = new a((SurfaceRenderView) this.f32014f.get(), this.f32009a);
            for (a.C0493a a2 : this.f32015g.keySet()) {
                a2.a(aVar);
            }
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.f32009a = surfaceHolder;
            this.f32010b = true;
            this.f32011c = i;
            this.f32012d = i2;
            this.f32013e = i3;
            a aVar = new a((SurfaceRenderView) this.f32014f.get(), this.f32009a);
            for (a.C0493a a2 : this.f32015g.keySet()) {
                a2.a(aVar, i, i2, i3);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (Build.VERSION.SDK_INT >= 14) {
            accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
        }
    }
}

package com.shopee.app.react.view.sketchview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.app.react.view.sketchview.d;
import com.tencent.ijk.media.player.IjkMediaMeta;
import d.d.b.j;
import io.b.d.f;
import io.b.g;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.concurrent.Callable;

@SuppressLint({"ViewConstructor"})
public final class c extends View implements d {

    /* renamed from: a  reason: collision with root package name */
    public static final a f19100a = new a((g) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f19101c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f19102d;

    /* renamed from: e  reason: collision with root package name */
    private final Path f19103e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f19104f;

    /* renamed from: g  reason: collision with root package name */
    private final EventDispatcher f19105g;
    private final Paint h;
    private float i;
    private float j;
    private boolean k;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, themedReactContext, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, ThemedReactContext themedReactContext, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        j.b(context, "context");
        j.b(themedReactContext, "reactContext");
        this.f19103e = new Path();
        this.f19104f = new Paint();
        NativeModule nativeModule = themedReactContext.getNativeModule(UIManagerModule.class);
        j.a((Object) nativeModule, "(reactContext as ReactCo…anagerModule::class.java)");
        this.f19105g = ((UIManagerModule) nativeModule).getEventDispatcher();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(a("#000000"));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(12.0f);
        this.h = paint;
        this.k = true;
    }

    public void setPenSize(float f2) {
        this.h.setStrokeWidth(f2);
    }

    public void setPenColor(String str) {
        j.b(str, ViewProps.COLOR);
        this.h.setColor(a(str));
    }

    public void a() {
        this.f19105g.dispatchEvent(new a(getId()));
    }

    public void b() {
        this.k = true;
        Bitmap bitmap = this.f19101c;
        if (bitmap != null) {
            bitmap.eraseColor(a("#ffffff"));
        }
        this.f19103e.reset();
        invalidate();
    }

    public void a(int i2, String str) {
        j.b(str, IjkMediaMeta.IJKM_KEY_FORMAT);
        b(i2, str).b(io.b.h.a.b()).a(io.b.a.b.a.a()).b(new C0292c(this)).a((f<? super Throwable>) new d(this)).a();
    }

    /* renamed from: com.shopee.app.react.view.sketchview.c$c  reason: collision with other inner class name */
    static final class C0292c<T> implements f<d.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19109a;

        C0292c(c cVar) {
            this.f19109a = cVar;
        }

        /* renamed from: a */
        public final void accept(d.b bVar) {
            this.f19109a.a(bVar);
        }
    }

    static final class d<T> implements f<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19110a;

        d(c cVar) {
            this.f19110a = cVar;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            this.f19110a.a((d.b) null);
        }
    }

    public void a(d.b bVar) {
        this.f19105g.dispatchEvent(new b(getId(), bVar));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.f19101c;
        if (!(bitmap == null || canvas == null)) {
            canvas.drawBitmap(bitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, this.f19104f);
        }
        if (canvas != null) {
            canvas.drawPath(this.f19103e, this.h);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            j.a();
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f2 = (float) 0;
        if (x < f2 || x > ((float) getWidth()) || y < f2 || y > ((float) getHeight())) {
            c();
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    b(x, y);
                } else if (action != 3) {
                    return false;
                }
            }
            c(x, y);
        } else {
            a(x, y);
        }
        invalidate();
        return true;
    }

    private final void a(float f2, float f3) {
        this.i = f2;
        this.j = f3;
        this.f19103e.moveTo(f2, f3);
    }

    private final void b(float f2, float f3) {
        float f4 = (float) 5;
        if (Math.abs(this.i - f2) >= f4 || Math.abs(this.j - f3) >= f4) {
            if (this.k) {
                this.k = false;
                a();
            }
            Path path = this.f19103e;
            float f5 = this.i;
            float f6 = this.j;
            float f7 = (float) 2;
            path.quadTo(f5, f6, (f5 + f2) / f7, (f6 + f3) / f7);
            this.i = f2;
            this.j = f3;
        }
    }

    private final void c(float f2, float f3) {
        this.f19103e.lineTo(f2, f3);
        d();
        Canvas canvas = this.f19102d;
        if (canvas == null) {
            j.a();
        }
        canvas.drawPath(this.f19103e, this.h);
        this.f19103e.reset();
    }

    private final void c() {
        d();
        Canvas canvas = this.f19102d;
        if (canvas == null) {
            j.a();
        }
        canvas.drawPath(this.f19103e, this.h);
    }

    private final void d() {
        if (this.f19101c == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            createBitmap.eraseColor(a("#ffffff"));
            this.f19101c = createBitmap;
        }
        if (this.f19102d == null) {
            this.f19102d = new Canvas(this.f19101c);
        }
    }

    static final class b<V> implements Callable<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f19106a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f19107b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f19108c;

        b(c cVar, int i, String str) {
            this.f19106a = cVar;
            this.f19107b = i;
            this.f19108c = str;
        }

        /* renamed from: a */
        public final d.b call() {
            int i;
            if (this.f19106a.getWidth() > this.f19106a.getHeight()) {
                i = this.f19106a.getWidth();
            } else {
                i = this.f19106a.getHeight();
            }
            float f2 = (((float) this.f19107b) * 1.0f) / ((float) i);
            Bitmap a2 = this.f19106a.f19101c;
            if (a2 == null) {
                j.a();
            }
            int width = (int) (((float) a2.getWidth()) * f2);
            Bitmap a3 = this.f19106a.f19101c;
            if (a3 == null) {
                j.a();
            }
            int height = (int) (f2 * ((float) a3.getHeight()));
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.f19106a.f19101c, width, height, false);
            String b2 = this.f19106a.getFilePath();
            FileOutputStream fileOutputStream = new FileOutputStream(b2);
            String str = this.f19108c;
            int hashCode = str.hashCode();
            if (hashCode != 105441) {
                if (hashCode == 111145 && str.equals("png")) {
                    createScaledBitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                }
                throw new IllegalStateException("Invalid image format");
            }
            if (str.equals("jpg")) {
                createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            }
            throw new IllegalStateException("Invalid image format");
            fileOutputStream.flush();
            fileOutputStream.close();
            String uri = Uri.fromFile(new File(b2)).toString();
            j.a((Object) uri, "Uri.fromFile(File(filePath)).toString()");
            return new d.b(width, height, uri);
        }
    }

    private final g<d.b> b(int i2, String str) {
        g<d.b> a2 = g.a(new b(this, i2, str));
        j.a((Object) a2, "Maybe.fromCallable {\n   …)\n            )\n        }");
        return a2;
    }

    /* access modifiers changed from: private */
    public final String getFilePath() {
        com.shopee.app.h.f a2 = com.shopee.app.h.f.a();
        j.a((Object) a2, "BBPathManager.getInstance()");
        for (File delete : new File(a2.h()).listFiles()) {
            delete.delete();
        }
        long time = new Date().getTime();
        StringBuilder sb = new StringBuilder();
        com.shopee.app.h.f a3 = com.shopee.app.h.f.a();
        j.a((Object) a3, "BBPathManager.getInstance()");
        sb.append(a3.h());
        sb.append(File.separator);
        sb.append("signature_");
        sb.append(time);
        sb.append(".png");
        return sb.toString();
    }

    private final int a(String str) {
        try {
            return Color.parseColor(str);
        } catch (Exception unused) {
            return -16777216;
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }
}

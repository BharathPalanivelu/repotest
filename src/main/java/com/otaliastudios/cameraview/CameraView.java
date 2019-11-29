package com.otaliastudios.cameraview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.location.Location;
import android.media.MediaActionSound;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.e;
import androidx.lifecycle.g;
import androidx.lifecycle.h;
import androidx.lifecycle.o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.otaliastudios.cameraview.ab;
import com.otaliastudios.cameraview.i;
import com.otaliastudios.cameraview.z;
import com.shopee.live.livestreaming.data.entity.RNCartPanelDataEntity;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CameraView extends FrameLayout implements g {
    private static final String h = "CameraView";
    private static final g i = g.a(h);

    /* renamed from: a  reason: collision with root package name */
    b f6901a;

    /* renamed from: b  reason: collision with root package name */
    List<f> f6902b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    List<r> f6903c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    w f6904d;

    /* renamed from: e  reason: collision with root package name */
    aa f6905e;

    /* renamed from: f  reason: collision with root package name */
    aj f6906f;

    /* renamed from: g  reason: collision with root package name */
    ad f6907g;
    /* access modifiers changed from: private */
    public int j;
    /* access modifiers changed from: private */
    public boolean k;
    /* access modifiers changed from: private */
    public boolean l;
    /* access modifiers changed from: private */
    public HashMap<s, t> m = new HashMap<>(4);
    /* access modifiers changed from: private */
    public i n;
    /* access modifiers changed from: private */
    public z o;
    /* access modifiers changed from: private */
    public d p;
    private MediaActionSound q;
    private e r;
    /* access modifiers changed from: private */
    public Handler s;
    /* access modifiers changed from: private */
    public ap t;
    /* access modifiers changed from: private */
    public ap u;

    interface b extends z.a {
        void a();

        void a(float f2, float[] fArr, PointF[] pointFArr);

        void a(float f2, PointF[] pointFArr);

        void a(YuvImage yuvImage, boolean z, boolean z2);

        void a(e eVar);

        void a(h hVar);

        void a(p pVar);

        void a(s sVar, PointF pointF);

        void a(s sVar, boolean z, PointF pointF);

        void a(File file);

        void a(boolean z);

        void a(byte[] bArr, boolean z, boolean z2);

        void b();
    }

    private String a(int i2) {
        if (i2 == Integer.MIN_VALUE) {
            return "AT_MOST";
        }
        if (i2 == 0) {
            return "UNSPECIFIED";
        }
        if (i2 != 1073741824) {
            return null;
        }
        return "EXACTLY";
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public CameraView(Context context) {
        super(context, (AttributeSet) null);
        a(context, (AttributeSet) null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        int i2;
        int i3;
        ag agVar;
        Context context2 = context;
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, ab.c.CameraView, 0, 0);
        int integer = obtainStyledAttributes.getInteger(ab.c.CameraView_cameraJpegQuality, 100);
        boolean z = obtainStyledAttributes.getBoolean(ab.c.CameraView_cameraCropOutput, false);
        boolean z2 = obtainStyledAttributes.getBoolean(ab.c.CameraView_cameraPlaySounds, true);
        n a2 = n.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraFacing, n.f15660a.a()));
        o a3 = o.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraFlash, o.f15661a.a()));
        v a4 = v.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGrid, v.f15680a.a()));
        ao a5 = ao.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraWhiteBalance, ao.f15559a.a()));
        an a6 = an.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraVideoQuality, an.f15558a.a()));
        ae a7 = ae.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraSessionType, ae.f15527a.a()));
        x a8 = x.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraHdr, x.f15687a.a()));
        b a9 = b.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraAudio, b.f15564a.a()));
        am a10 = am.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraVideoCodec, am.f15557a.a()));
        b bVar = a9;
        long j2 = (long) obtainStyledAttributes.getFloat(ab.c.CameraView_cameraVideoMaxSize, BitmapDescriptorFactory.HUE_RED);
        int integer2 = obtainStyledAttributes.getInteger(ab.c.CameraView_cameraVideoMaxDuration, 0);
        ArrayList arrayList = new ArrayList(3);
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMinWidth)) {
            i2 = integer2;
            i3 = 0;
            arrayList.add(ah.b(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMinWidth, 0)));
        } else {
            i2 = integer2;
            i3 = 0;
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMaxWidth)) {
            arrayList.add(ah.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMaxWidth, i3)));
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMinHeight)) {
            arrayList.add(ah.d(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMinHeight, i3)));
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMaxHeight)) {
            arrayList.add(ah.c(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMaxHeight, i3)));
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMinArea)) {
            arrayList.add(ah.f(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMinArea, i3)));
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeMaxArea)) {
            arrayList.add(ah.e(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraPictureSizeMaxArea, i3)));
        }
        if (obtainStyledAttributes.hasValue(ab.c.CameraView_cameraPictureSizeAspectRatio)) {
            arrayList.add(ah.a(a.a(obtainStyledAttributes.getString(ab.c.CameraView_cameraPictureSizeAspectRatio)), BitmapDescriptorFactory.HUE_RED));
        }
        if (obtainStyledAttributes.getBoolean(ab.c.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(ah.b());
        }
        if (obtainStyledAttributes.getBoolean(ab.c.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(ah.a());
        }
        if (!arrayList.isEmpty()) {
            agVar = ah.a((ag[]) arrayList.toArray(new ag[0]));
        } else {
            agVar = ah.a();
        }
        t a11 = t.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGestureTap, t.f15673b.a()));
        t a12 = t.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGestureLongTap, t.f15674c.a()));
        t a13 = t.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGesturePinch, t.f15672a.a()));
        t a14 = t.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGestureScrollHorizontal, t.f15675d.a()));
        t a15 = t.a(obtainStyledAttributes.getInteger(ab.c.CameraView_cameraGestureScrollVertical, t.f15676e.a()));
        obtainStyledAttributes.recycle();
        this.f6901a = new a();
        this.p = a(this.f6901a);
        this.s = new Handler(Looper.getMainLooper());
        this.t = ap.a("CameraViewWorker");
        this.u = ap.a("FrameProcessorsWorker");
        this.f6904d = new w(context2);
        this.f6905e = new aa(context2);
        this.f6906f = new aj(context2);
        this.f6907g = new ad(context2);
        addView(this.f6904d);
        addView(this.f6905e);
        addView(this.f6906f);
        addView(this.f6907g);
        setCropOutput(z);
        setJpegQuality(integer);
        setPlaySounds(z2);
        setFacing(a2);
        setFlash(a3);
        setSessionType(a7);
        setVideoQuality(a6);
        setWhiteBalance(a5);
        setGrid(a4);
        setHdr(a8);
        setAudio(bVar);
        setPictureSize(agVar);
        setVideoCodec(a10);
        setVideoMaxSize(j2);
        setVideoMaxDuration(i2);
        a(s.TAP, a11);
        a(s.LONG_TAP, a12);
        a(s.PINCH, a13);
        a(s.SCROLL_HORIZONTAL, a14);
        a(s.SCROLL_VERTICAL, a15);
        if (!isInEditMode()) {
            this.o = new z(context2, this.f6901a);
        }
    }

    /* access modifiers changed from: protected */
    public d a(b bVar) {
        return new c(bVar);
    }

    /* access modifiers changed from: protected */
    public i a(Context context, ViewGroup viewGroup) {
        i.c("preview:", "isHardwareAccelerated:", Boolean.valueOf(isHardwareAccelerated()));
        return isHardwareAccelerated() ? new al(context, viewGroup, (i.a) null) : new ai(context, viewGroup, (i.a) null);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.n = a(getContext(), (ViewGroup) this);
        this.p.a(this.n);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.n == null) {
            a();
        }
        if (!isInEditMode()) {
            this.o.a(getContext());
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.o.a();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        af previewSize = getPreviewSize();
        if (previewSize == null) {
            i.c("onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean E = this.p.E();
        float b2 = (float) (E ? previewSize.b() : previewSize.a());
        float a2 = (float) (E ? previewSize.a() : previewSize.b());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (!this.n.g()) {
            if (mode == 1073741824) {
                mode = RNCartPanelDataEntity.NULL_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = RNCartPanelDataEntity.NULL_VALUE;
            }
        } else {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        }
        g gVar = i;
        gVar.b("onMeasure:", "requested dimensions are", SQLBuilder.PARENTHESES_LEFT + size + "[" + a(mode) + "]x" + size2 + "[" + a(mode2) + "])");
        g gVar2 = i;
        StringBuilder sb = new StringBuilder();
        sb.append(SQLBuilder.PARENTHESES_LEFT);
        sb.append(b2);
        sb.append("x");
        sb.append(a2);
        sb.append(SQLBuilder.PARENTHESES_RIGHT);
        gVar2.b("onMeasure:", "previewSize is", sb.toString());
        if (mode == 1073741824 && mode2 == 1073741824) {
            g gVar3 = i;
            gVar3.c("onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", SQLBuilder.PARENTHESES_LEFT + size + "x" + size2 + SQLBuilder.PARENTHESES_RIGHT);
            super.onMeasure(i2, i3);
        } else if (mode == 0 && mode2 == 0) {
            g gVar4 = i;
            gVar4.b("onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", SQLBuilder.PARENTHESES_LEFT + b2 + "x" + a2 + SQLBuilder.PARENTHESES_RIGHT);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) b2, 1073741824), View.MeasureSpec.makeMeasureSpec((int) a2, 1073741824));
        } else {
            float f2 = a2 / b2;
            if (mode == 0 || mode2 == 0) {
                if (mode == 0) {
                    size = (int) (((float) size2) / f2);
                } else {
                    size2 = (int) (((float) size) * f2);
                }
                g gVar5 = i;
                gVar5.b("onMeasure:", "one dimension was free, we adapted it to fit the aspect ratio.", SQLBuilder.PARENTHESES_LEFT + size + "x" + size2 + SQLBuilder.PARENTHESES_RIGHT);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else if (mode == 1073741824 || mode2 == 1073741824) {
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min((int) (((float) size2) / f2), size);
                } else {
                    size2 = Math.min((int) (((float) size) * f2), size2);
                }
                g gVar6 = i;
                gVar6.b("onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", SQLBuilder.PARENTHESES_LEFT + size + "x" + size2 + SQLBuilder.PARENTHESES_RIGHT);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            } else {
                float f3 = (float) size2;
                float f4 = (float) size;
                if (f3 / f4 >= f2) {
                    size2 = (int) (f4 * f2);
                } else {
                    size = (int) (f3 / f2);
                }
                g gVar7 = i;
                gVar7.b("onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", SQLBuilder.PARENTHESES_LEFT + size + "x" + size2 + SQLBuilder.PARENTHESES_RIGHT);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            }
        }
    }

    public boolean a(s sVar, t tVar) {
        t tVar2 = t.NONE;
        boolean z = false;
        if (sVar.a(tVar)) {
            this.m.put(sVar, tVar);
            int i2 = AnonymousClass1.f15475a[sVar.ordinal()];
            if (i2 == 1) {
                aa aaVar = this.f6905e;
                if (this.m.get(s.PINCH) != tVar2) {
                    z = true;
                }
                aaVar.a(z);
            } else if (i2 == 2 || i2 == 3) {
                aj ajVar = this.f6906f;
                if (!(this.m.get(s.TAP) == tVar2 && this.m.get(s.LONG_TAP) == tVar2)) {
                    z = true;
                }
                ajVar.a(z);
            } else if (i2 == 4 || i2 == 5) {
                ad adVar = this.f6907g;
                if (!(this.m.get(s.SCROLL_HORIZONTAL) == tVar2 && this.m.get(s.SCROLL_VERTICAL) == tVar2)) {
                    z = true;
                }
                adVar.a(z);
            }
            return true;
        }
        a(sVar, tVar2);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!b()) {
            return true;
        }
        h o2 = this.p.o();
        if (this.f6905e.onTouchEvent(motionEvent)) {
            i.b("onTouchEvent", "pinch!");
            a((u) this.f6905e, o2);
        } else if (this.f6907g.onTouchEvent(motionEvent)) {
            i.b("onTouchEvent", "scroll!");
            a((u) this.f6907g, o2);
        } else if (this.f6906f.onTouchEvent(motionEvent)) {
            i.b("onTouchEvent", "tap!");
            a((u) this.f6906f, o2);
        }
        return true;
    }

    private void a(u uVar, h hVar) {
        s a2 = uVar.a();
        PointF[] b2 = uVar.b();
        int i2 = AnonymousClass1.f15476b[this.m.get(a2).ordinal()];
        if (i2 == 1) {
            this.p.e();
        } else if (i2 == 2 || i2 == 3) {
            this.p.a(a2, b2[0]);
        } else if (i2 == 4) {
            float B = this.p.B();
            float a3 = uVar.a(B, BitmapDescriptorFactory.HUE_RED, 1.0f);
            if (a3 != B) {
                this.p.a(a3, b2, true);
            }
        } else if (i2 == 5) {
            float C = this.p.C();
            float j2 = hVar.j();
            float k2 = hVar.k();
            float a4 = uVar.a(C, j2, k2);
            if (a4 != C) {
                this.p.a(a4, new float[]{j2, k2}, b2, true);
            }
        }
    }

    public boolean b() {
        return this.p.m() >= 2;
    }

    private boolean f() {
        return this.p.m() == 0;
    }

    public void setLifecycleOwner(h hVar) {
        e eVar = this.r;
        if (eVar != null) {
            eVar.b(this);
        }
        this.r = hVar.getLifecycle();
        this.r.a(this);
    }

    @o(a = e.a.ON_RESUME)
    public void start() {
        if (isEnabled() && a(getSessionType(), getAudio())) {
            this.o.a(getContext());
            this.p.a(this.o.b());
            this.p.i();
        }
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public boolean a(ae aeVar, b bVar) {
        b(aeVar, bVar);
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        Context context = getContext();
        boolean z = aeVar == ae.VIDEO && bVar == b.ON;
        boolean z2 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z3 = z && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z2 && !z3) {
            return true;
        }
        a(z2, z3);
        return false;
    }

    private void b(ae aeVar, b bVar) {
        if (aeVar == ae.VIDEO && bVar == b.ON) {
            try {
                String[] strArr = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions;
                int length = strArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (!strArr[i2].equals("android.permission.RECORD_AUDIO")) {
                        i2++;
                    } else {
                        return;
                    }
                }
                i.d("Permission error:", "When the session type is set to video,", "the RECORD_AUDIO permission should be added to the app manifest file.");
                throw new IllegalStateException(g.f15631a);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    @o(a = e.a.ON_PAUSE)
    public void stop() {
        this.p.j();
    }

    @o(a = e.a.ON_DESTROY)
    public void destroy() {
        c();
        d();
        this.p.h();
    }

    public void set(k kVar) {
        if (kVar instanceof b) {
            setAudio((b) kVar);
        } else if (kVar instanceof n) {
            setFacing((n) kVar);
        } else if (kVar instanceof o) {
            setFlash((o) kVar);
        } else if (kVar instanceof v) {
            setGrid((v) kVar);
        } else if (kVar instanceof x) {
            setHdr((x) kVar);
        } else if (kVar instanceof ae) {
            setSessionType((ae) kVar);
        } else if (kVar instanceof an) {
            setVideoQuality((an) kVar);
        } else if (kVar instanceof ao) {
            setWhiteBalance((ao) kVar);
        } else if (kVar instanceof am) {
            setVideoCodec((am) kVar);
        }
    }

    public h getCameraOptions() {
        return this.p.o();
    }

    public m getExtraProperties() {
        return this.p.n();
    }

    public void setExposureCorrection(float f2) {
        h cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float j2 = cameraOptions.j();
            float k2 = cameraOptions.k();
            if (f2 < j2) {
                f2 = j2;
            }
            if (f2 > k2) {
                f2 = k2;
            }
            this.p.a(f2, (float[]) null, (PointF[]) null, false);
        }
    }

    public float getExposureCorrection() {
        return this.p.C();
    }

    public void setZoom(float f2) {
        if (f2 < BitmapDescriptorFactory.HUE_RED) {
            f2 = BitmapDescriptorFactory.HUE_RED;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.p.a(f2, (PointF[]) null, false);
    }

    public float getZoom() {
        return this.p.B();
    }

    public void setGrid(v vVar) {
        this.f6904d.a(vVar);
    }

    public v getGrid() {
        return this.f6904d.a();
    }

    public void setHdr(x xVar) {
        this.p.a(xVar);
    }

    public x getHdr() {
        return this.p.x();
    }

    public void setLocation(Location location) {
        this.p.a(location);
    }

    public Location getLocation() {
        return this.p.y();
    }

    public void setWhiteBalance(ao aoVar) {
        this.p.a(aoVar);
    }

    public ao getWhiteBalance() {
        return this.p.r();
    }

    public void setFacing(n nVar) {
        this.p.a(nVar);
    }

    public n getFacing() {
        return this.p.p();
    }

    public void setFlash(o oVar) {
        this.p.a(oVar);
    }

    public o getFlash() {
        return this.p.q();
    }

    public void setAudio(b bVar) {
        if (bVar == getAudio() || f()) {
            this.p.a(bVar);
        } else if (a(getSessionType(), bVar)) {
            this.p.a(bVar);
        } else {
            stop();
        }
    }

    public b getAudio() {
        return this.p.z();
    }

    public void setSessionType(ae aeVar) {
        if (aeVar == getSessionType() || f()) {
            this.p.a(aeVar);
        } else if (a(aeVar, getAudio())) {
            this.p.a(aeVar);
        } else {
            stop();
        }
    }

    public ae getSessionType() {
        return this.p.w();
    }

    public void setPictureSize(ag agVar) {
        this.p.a(agVar);
    }

    public void setVideoQuality(an anVar) {
        this.p.a(anVar);
    }

    public an getVideoQuality() {
        return this.p.s();
    }

    public void setJpegQuality(int i2) {
        if (i2 <= 0 || i2 > 100) {
            throw new IllegalArgumentException("JPEG quality should be > 0 and <= 100");
        }
        this.j = i2;
    }

    public int getJpegQuality() {
        return this.j;
    }

    public void setCropOutput(boolean z) {
        this.k = z;
    }

    public boolean getCropOutput() {
        return this.k;
    }

    @Deprecated
    public void setCameraListener(f fVar) {
        this.f6902b.clear();
        a(fVar);
    }

    public void a(f fVar) {
        if (fVar != null) {
            this.f6902b.add(fVar);
        }
    }

    public void c() {
        this.f6902b.clear();
    }

    public void d() {
        this.f6903c.clear();
    }

    public void e() {
        this.p.f();
    }

    public af getPreviewSize() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar.D();
        }
        return null;
    }

    public af getPictureSize() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar.A();
        }
        return null;
    }

    public af getSnapshotSize() {
        return getPreviewSize();
    }

    @TargetApi(23)
    private void a(boolean z, boolean z2) {
        Activity activity = null;
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                activity = (Activity) context;
            }
        }
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.add("android.permission.CAMERA");
        }
        if (z2) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        if (activity != null) {
            activity.requestPermissions((String[]) arrayList.toArray(new String[arrayList.size()]), 16);
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void b(int i2) {
        if (this.l) {
            if (this.q == null) {
                this.q = new MediaActionSound();
            }
            this.q.play(i2);
        }
    }

    public void setPlaySounds(boolean z) {
        this.l = z && Build.VERSION.SDK_INT >= 16;
        this.p.a(z);
    }

    public boolean getPlaySounds() {
        return this.l;
    }

    public void setVideoCodec(am amVar) {
        this.p.a(amVar);
    }

    public am getVideoCodec() {
        return this.p.t();
    }

    public void setVideoMaxSize(long j2) {
        this.p.a(j2);
    }

    public long getVideoMaxSize() {
        return this.p.u();
    }

    public void setVideoMaxDuration(int i2) {
        this.p.c(i2);
    }

    public int getVideoMaxDuration() {
        return this.p.v();
    }

    private class a implements b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public g f15480b = g.a(b.class.getSimpleName());

        a() {
        }

        public void a(final h hVar) {
            this.f15480b.b("dispatchOnCameraOpened", hVar);
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(hVar);
                    }
                }
            });
        }

        public void a() {
            this.f15480b.b("dispatchOnCameraClosed");
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a();
                    }
                }
            });
        }

        public void b() {
            this.f15480b.b("onCameraPreviewSizeChanged");
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    CameraView.this.requestLayout();
                }
            });
        }

        public void a(boolean z) {
            if (z && CameraView.this.l) {
                CameraView.this.b(0);
            }
        }

        public void a(final byte[] bArr, final boolean z, boolean z2) {
            this.f15480b.b("processImage");
            CameraView.this.t.b(new Runnable() {
                public void run() {
                    byte[] bArr = bArr;
                    if (CameraView.this.k && CameraView.this.n.h()) {
                        a a2 = a.a(z ? CameraView.this.getWidth() : CameraView.this.getHeight(), z ? CameraView.this.getHeight() : CameraView.this.getWidth());
                        a.this.f15480b.b("processImage", "is consistent?", Boolean.valueOf(z));
                        a.this.f15480b.b("processImage", "viewWidth?", Integer.valueOf(CameraView.this.getWidth()), "viewHeight?", Integer.valueOf(CameraView.this.getHeight()));
                        bArr = l.a(bArr, a2, CameraView.this.j);
                    }
                    a.this.a(bArr);
                }
            });
        }

        public void a(final YuvImage yuvImage, final boolean z, boolean z2) {
            this.f15480b.b("processSnapshot");
            CameraView.this.t.b(new Runnable() {
                public void run() {
                    byte[] bArr;
                    if (!CameraView.this.k || !CameraView.this.n.h()) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        YuvImage yuvImage = yuvImage;
                        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), CameraView.this.j, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                    } else {
                        a a2 = a.a(z ? CameraView.this.getWidth() : CameraView.this.getHeight(), z ? CameraView.this.getHeight() : CameraView.this.getWidth());
                        a.this.f15480b.b("processSnapshot", "is consistent?", Boolean.valueOf(z));
                        a.this.f15480b.b("processSnapshot", "viewWidth?", Integer.valueOf(CameraView.this.getWidth()), "viewHeight?", Integer.valueOf(CameraView.this.getHeight()));
                        bArr = l.a(yuvImage, a2, CameraView.this.j);
                    }
                    a.this.a(bArr);
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(final byte[] bArr) {
            this.f15480b.b("dispatchOnPictureTaken");
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(bArr);
                    }
                }
            });
        }

        public void a(final File file) {
            this.f15480b.b("dispatchOnVideoTaken", file);
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(file);
                    }
                }
            });
        }

        public void a(final s sVar, final PointF pointF) {
            this.f15480b.b("dispatchOnFocusStart", sVar, pointF);
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    if (sVar != null && CameraView.this.m.get(sVar) == t.FOCUS_WITH_MARKER) {
                        CameraView.this.f6906f.a(pointF);
                    }
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(pointF);
                    }
                }
            });
        }

        public void a(final s sVar, final boolean z, final PointF pointF) {
            this.f15480b.b("dispatchOnFocusEnd", sVar, Boolean.valueOf(z), pointF);
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    if (z && CameraView.this.l) {
                        CameraView.this.b(1);
                    }
                    if (sVar != null && CameraView.this.m.get(sVar) == t.FOCUS_WITH_MARKER) {
                        CameraView.this.f6906f.b(z);
                    }
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(z, pointF);
                    }
                }
            });
        }

        public void a(int i) {
            this.f15480b.b("onDeviceOrientationChanged", Integer.valueOf(i));
            CameraView.this.p.b(i);
            final int b2 = (i + CameraView.this.o.b()) % 360;
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(b2);
                    }
                }
            });
        }

        public void a(final float f2, final PointF[] pointFArr) {
            this.f15480b.b("dispatchOnZoomChanged", Float.valueOf(f2));
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(f2, new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f}, pointFArr);
                    }
                }
            });
        }

        public void a(final float f2, final float[] fArr, final PointF[] pointFArr) {
            this.f15480b.b("dispatchOnExposureCorrectionChanged", Float.valueOf(f2));
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f b2 : CameraView.this.f6902b) {
                        b2.b(f2, fArr, pointFArr);
                    }
                }
            });
        }

        public void a(final p pVar) {
            if (CameraView.this.f6903c.isEmpty()) {
                pVar.a();
                return;
            }
            this.f15480b.a("dispatchFrame:", Long.valueOf(pVar.d()), "processors:", Integer.valueOf(CameraView.this.f6903c.size()));
            CameraView.this.u.b(new Runnable() {
                public void run() {
                    for (r a2 : CameraView.this.f6903c) {
                        a2.a(pVar);
                    }
                    pVar.a();
                }
            });
        }

        public void a(final e eVar) {
            this.f15480b.b("dispatchError", eVar);
            CameraView.this.s.post(new Runnable() {
                public void run() {
                    for (f a2 : CameraView.this.f6902b) {
                        a2.a(eVar);
                    }
                }
            });
        }
    }

    @Deprecated
    public af getCaptureSize() {
        return getPictureSize();
    }

    /* renamed from: com.otaliastudios.cameraview.CameraView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f15475a = new int[s.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f15476b = new int[t.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f15477c = new int[n.values().length];

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f15478d = new int[o.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|28|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0079 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00bf */
        static {
            /*
                com.otaliastudios.cameraview.o[] r0 = com.otaliastudios.cameraview.o.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15478d = r0
                r0 = 1
                int[] r1 = f15478d     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.otaliastudios.cameraview.o r2 = com.otaliastudios.cameraview.o.OFF     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f15478d     // Catch:{ NoSuchFieldError -> 0x001f }
                com.otaliastudios.cameraview.o r3 = com.otaliastudios.cameraview.o.ON     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f15478d     // Catch:{ NoSuchFieldError -> 0x002a }
                com.otaliastudios.cameraview.o r4 = com.otaliastudios.cameraview.o.AUTO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f15478d     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.otaliastudios.cameraview.o r5 = com.otaliastudios.cameraview.o.TORCH     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.otaliastudios.cameraview.n[] r4 = com.otaliastudios.cameraview.n.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f15477c = r4
                int[] r4 = f15477c     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.otaliastudios.cameraview.n r5 = com.otaliastudios.cameraview.n.BACK     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r4 = f15477c     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.otaliastudios.cameraview.n r5 = com.otaliastudios.cameraview.n.FRONT     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                com.otaliastudios.cameraview.t[] r4 = com.otaliastudios.cameraview.t.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f15476b = r4
                int[] r4 = f15476b     // Catch:{ NoSuchFieldError -> 0x0065 }
                com.otaliastudios.cameraview.t r5 = com.otaliastudios.cameraview.t.CAPTURE     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                int[] r4 = f15476b     // Catch:{ NoSuchFieldError -> 0x006f }
                com.otaliastudios.cameraview.t r5 = com.otaliastudios.cameraview.t.FOCUS     // Catch:{ NoSuchFieldError -> 0x006f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006f }
                r4[r5] = r1     // Catch:{ NoSuchFieldError -> 0x006f }
            L_0x006f:
                int[] r4 = f15476b     // Catch:{ NoSuchFieldError -> 0x0079 }
                com.otaliastudios.cameraview.t r5 = com.otaliastudios.cameraview.t.FOCUS_WITH_MARKER     // Catch:{ NoSuchFieldError -> 0x0079 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0079 }
                r4[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0079 }
            L_0x0079:
                int[] r4 = f15476b     // Catch:{ NoSuchFieldError -> 0x0083 }
                com.otaliastudios.cameraview.t r5 = com.otaliastudios.cameraview.t.ZOOM     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                r4 = 5
                int[] r5 = f15476b     // Catch:{ NoSuchFieldError -> 0x008e }
                com.otaliastudios.cameraview.t r6 = com.otaliastudios.cameraview.t.EXPOSURE_CORRECTION     // Catch:{ NoSuchFieldError -> 0x008e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x008e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x008e }
            L_0x008e:
                com.otaliastudios.cameraview.s[] r5 = com.otaliastudios.cameraview.s.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                f15475a = r5
                int[] r5 = f15475a     // Catch:{ NoSuchFieldError -> 0x00a1 }
                com.otaliastudios.cameraview.s r6 = com.otaliastudios.cameraview.s.PINCH     // Catch:{ NoSuchFieldError -> 0x00a1 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a1 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x00a1 }
            L_0x00a1:
                int[] r0 = f15475a     // Catch:{ NoSuchFieldError -> 0x00ab }
                com.otaliastudios.cameraview.s r5 = com.otaliastudios.cameraview.s.TAP     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                int[] r0 = f15475a     // Catch:{ NoSuchFieldError -> 0x00b5 }
                com.otaliastudios.cameraview.s r1 = com.otaliastudios.cameraview.s.LONG_TAP     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = f15475a     // Catch:{ NoSuchFieldError -> 0x00bf }
                com.otaliastudios.cameraview.s r1 = com.otaliastudios.cameraview.s.SCROLL_HORIZONTAL     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                int[] r0 = f15475a     // Catch:{ NoSuchFieldError -> 0x00c9 }
                com.otaliastudios.cameraview.s r1 = com.otaliastudios.cameraview.s.SCROLL_VERTICAL     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.otaliastudios.cameraview.CameraView.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public int getCameraId() {
        return this.p.q;
    }
}

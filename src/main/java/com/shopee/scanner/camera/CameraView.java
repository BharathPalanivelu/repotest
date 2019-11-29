package com.shopee.scanner.camera;

import android.content.Context;
import android.content.res.TypedArray;
import android.hardware.Camera;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.core.g.w;
import com.shopee.scanner.c;
import com.shopee.scanner.camera.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class CameraView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f30282b = (!CameraView.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    b f30283a;

    /* renamed from: c  reason: collision with root package name */
    private final b f30284c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30285d;

    /* renamed from: e  reason: collision with root package name */
    private final d f30286e;

    public static abstract class a {
        public void a(CameraView cameraView) {
        }

        public void b(CameraView cameraView) {
        }
    }

    /* access modifiers changed from: protected */
    public Camera.PreviewCallback getCamera1PreviewCallback() {
        return null;
    }

    public CameraView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (isInEditMode()) {
            this.f30284c = null;
            this.f30286e = null;
            return;
        }
        e a2 = a(context);
        this.f30284c = new b();
        this.f30283a = new a(this.f30284c, a2);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.e.CameraView, i, c.d.Widget_CameraView);
        this.f30285d = obtainStyledAttributes.getBoolean(c.e.CameraView_android_adjustViewBounds, false);
        setFacing(obtainStyledAttributes.getInt(c.e.CameraView_facing, 0));
        String string = obtainStyledAttributes.getString(c.e.CameraView_aspectRatio);
        if (string != null) {
            setAspectRatio(AspectRatio.a(string));
        } else {
            setAspectRatio(c.f30303a);
        }
        setAutoFocus(obtainStyledAttributes.getBoolean(c.e.CameraView_autoFocus, true));
        setFlash(obtainStyledAttributes.getInt(c.e.CameraView_flash, 3));
        obtainStyledAttributes.recycle();
        this.f30286e = new d(context) {
            public void a(int i) {
                CameraView.this.f30283a.c(i);
            }
        };
    }

    private e a(Context context) {
        return new h(context, this);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            this.f30286e.a(w.F(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (!isInEditMode()) {
            this.f30286e.a();
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (isInEditMode()) {
            super.onMeasure(i, i2);
            return;
        }
        if (!this.f30285d) {
            super.onMeasure(i, i2);
        } else if (!c()) {
            this.f30284c.c();
            super.onMeasure(i, i2);
            return;
        } else {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            if (mode == 1073741824 && mode2 != 1073741824) {
                AspectRatio aspectRatio = getAspectRatio();
                if (f30282b || aspectRatio != null) {
                    int size = (int) (((float) View.MeasureSpec.getSize(i)) * aspectRatio.c());
                    if (mode2 == Integer.MIN_VALUE) {
                        size = Math.min(size, View.MeasureSpec.getSize(i2));
                    }
                    super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 1073741824));
                } else {
                    throw new AssertionError();
                }
            } else if (mode == 1073741824 || mode2 != 1073741824) {
                super.onMeasure(i, i2);
            } else {
                AspectRatio aspectRatio2 = getAspectRatio();
                if (f30282b || aspectRatio2 != null) {
                    int size2 = (int) (((float) View.MeasureSpec.getSize(i2)) * aspectRatio2.c());
                    if (mode == Integer.MIN_VALUE) {
                        size2 = Math.min(size2, View.MeasureSpec.getSize(i));
                    }
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, 1073741824), i2);
                } else {
                    throw new AssertionError();
                }
            }
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        AspectRatio aspectRatio3 = getAspectRatio();
        if (this.f30286e.b() % 180 == 0) {
            aspectRatio3 = aspectRatio3.d();
        }
        if (!f30282b && aspectRatio3 == null) {
            throw new AssertionError();
        } else if (measuredHeight < (aspectRatio3.b() * measuredWidth) / aspectRatio3.a()) {
            this.f30283a.i().measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec((measuredWidth * aspectRatio3.b()) / aspectRatio3.a(), 1073741824));
        } else {
            this.f30283a.i().measure(View.MeasureSpec.makeMeasureSpec((aspectRatio3.a() * measuredHeight) / aspectRatio3.b(), 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f30288a = getFacing();
        savedState.f30289b = getAspectRatio();
        savedState.f30290c = getAutoFocus();
        savedState.f30291d = getFlash();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setFacing(savedState.f30288a);
        setAspectRatio(savedState.f30289b);
        setAutoFocus(savedState.f30290c);
        setFlash(savedState.f30291d);
    }

    public void a() {
        Camera.PreviewCallback camera1PreviewCallback = getCamera1PreviewCallback();
        if (camera1PreviewCallback != null) {
            this.f30283a.a((Object) camera1PreviewCallback);
        }
        if (!this.f30283a.a()) {
            Parcelable onSaveInstanceState = onSaveInstanceState();
            this.f30283a.b();
            this.f30283a = new a(this.f30284c, a(getContext()), camera1PreviewCallback);
            onRestoreInstanceState(onSaveInstanceState);
            this.f30283a.a();
        }
    }

    public void b() {
        this.f30283a.b();
    }

    public boolean c() {
        return this.f30283a.c();
    }

    public void setAdjustViewBounds(boolean z) {
        if (this.f30285d != z) {
            this.f30285d = z;
            requestLayout();
        }
    }

    public boolean getAdjustViewBounds() {
        return this.f30285d;
    }

    public void setFacing(int i) {
        this.f30283a.a(i);
    }

    public int getFacing() {
        return this.f30283a.d();
    }

    public Set<AspectRatio> getSupportedAspectRatios() {
        return this.f30283a.e();
    }

    public void setAspectRatio(AspectRatio aspectRatio) {
        if (this.f30283a.a(aspectRatio)) {
            requestLayout();
        }
    }

    public AspectRatio getAspectRatio() {
        return this.f30283a.f();
    }

    public void setAutoFocus(boolean z) {
        this.f30283a.a(z);
    }

    public boolean getAutoFocus() {
        return this.f30283a.g();
    }

    public void setFlash(int i) {
        this.f30283a.b(i);
    }

    public int getFlash() {
        return this.f30283a.h();
    }

    private class b implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<a> f30293b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private boolean f30294c;

        b() {
        }

        public void a() {
            if (this.f30294c) {
                this.f30294c = false;
                CameraView.this.requestLayout();
            }
            Iterator<a> it = this.f30293b.iterator();
            while (it.hasNext()) {
                it.next().a(CameraView.this);
            }
        }

        public void b() {
            Iterator<a> it = this.f30293b.iterator();
            while (it.hasNext()) {
                it.next().b(CameraView.this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f30294c = true;
        }
    }

    private static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        int f30288a;

        /* renamed from: b  reason: collision with root package name */
        AspectRatio f30289b;

        /* renamed from: c  reason: collision with root package name */
        boolean f30290c;

        /* renamed from: d  reason: collision with root package name */
        int f30291d;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            this.f30288a = parcel.readInt();
            this.f30289b = (AspectRatio) parcel.readParcelable(classLoader);
            this.f30290c = parcel.readByte() != 0;
            this.f30291d = parcel.readInt();
        }

        SavedState(Parcel parcel) {
            super(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f30288a);
            parcel.writeParcelable(this.f30289b, 0);
            parcel.writeByte(this.f30290c ? (byte) 1 : 0);
            parcel.writeInt(this.f30291d);
        }
    }
}

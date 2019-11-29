package com.airbnb.lottie;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.c.e;
import com.airbnb.lottie.g.c;
import com.airbnb.lottie.n;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

public class LottieAnimationView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3359a = "LottieAnimationView";

    /* renamed from: b  reason: collision with root package name */
    private final h<d> f3360b = new h<d>() {
        public void a(d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final h<Throwable> f3361c = new h<Throwable>() {
        public void a(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final f f3362d = new f();

    /* renamed from: e  reason: collision with root package name */
    private String f3363e;

    /* renamed from: f  reason: collision with root package name */
    private int f3364f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3365g = false;
    private boolean h = false;
    private boolean i = false;
    private Set<i> j = new HashSet();
    private l<d> k;
    private d l;

    public LottieAnimationView(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, n.a.LottieAnimationView);
        if (!isInEditMode()) {
            boolean hasValue = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_rawRes);
            boolean hasValue2 = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_fileName);
            boolean hasValue3 = obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_url);
            if (hasValue && hasValue2) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            } else if (hasValue) {
                int resourceId = obtainStyledAttributes.getResourceId(n.a.LottieAnimationView_lottie_rawRes, 0);
                if (resourceId != 0) {
                    setAnimation(resourceId);
                }
            } else if (hasValue2) {
                String string = obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_fileName);
                if (string != null) {
                    setAnimation(string);
                }
            } else if (hasValue3) {
                String string2 = obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_url);
                if (string2 != null) {
                    setAnimationFromUrl(string2);
                }
            }
        }
        if (obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_autoPlay, false)) {
            this.f3365g = true;
            this.h = true;
        }
        if (obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_loop, false)) {
            this.f3362d.e(-1);
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_repeatMode)) {
            setRepeatMode(obtainStyledAttributes.getInt(n.a.LottieAnimationView_lottie_repeatMode, 1));
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_repeatCount)) {
            setRepeatCount(obtainStyledAttributes.getInt(n.a.LottieAnimationView_lottie_repeatCount, -1));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(n.a.LottieAnimationView_lottie_imageAssetsFolder));
        setProgress(obtainStyledAttributes.getFloat(n.a.LottieAnimationView_lottie_progress, BitmapDescriptorFactory.HUE_RED));
        a(obtainStyledAttributes.getBoolean(n.a.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove, false));
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_colorFilter)) {
            o oVar = new o(obtainStyledAttributes.getColor(n.a.LottieAnimationView_lottie_colorFilter, 0));
            a(new e("**"), j.x, new c(oVar));
        }
        if (obtainStyledAttributes.hasValue(n.a.LottieAnimationView_lottie_scale)) {
            this.f3362d.e(obtainStyledAttributes.getFloat(n.a.LottieAnimationView_lottie_scale, 1.0f));
        }
        obtainStyledAttributes.recycle();
        g();
    }

    public void setImageResource(int i2) {
        a();
        e();
        super.setImageResource(i2);
    }

    public void setImageDrawable(Drawable drawable) {
        a(drawable, true);
    }

    private void a(Drawable drawable, boolean z) {
        if (z && drawable != this.f3362d) {
            a();
        }
        e();
        super.setImageDrawable(drawable);
    }

    public void setImageBitmap(Bitmap bitmap) {
        a();
        e();
        super.setImageBitmap(bitmap);
    }

    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f3362d;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f3368a = this.f3363e;
        savedState.f3369b = this.f3364f;
        savedState.f3370c = this.f3362d.t();
        savedState.f3371d = this.f3362d.n();
        savedState.f3372e = this.f3362d.b();
        savedState.f3373f = this.f3362d.l();
        savedState.f3374g = this.f3362d.m();
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
        this.f3363e = savedState.f3368a;
        if (!TextUtils.isEmpty(this.f3363e)) {
            setAnimation(this.f3363e);
        }
        this.f3364f = savedState.f3369b;
        int i2 = this.f3364f;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(savedState.f3370c);
        if (savedState.f3371d) {
            b();
        }
        this.f3362d.a(savedState.f3372e);
        setRepeatMode(savedState.f3373f);
        setRepeatCount(savedState.f3374g);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && this.f3365g) {
            b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        if (c()) {
            d();
            this.f3365g = true;
        }
        a();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f3362d.c();
    }

    public void a(boolean z) {
        this.f3362d.a(z);
    }

    public boolean getUseHardwareAcceleration() {
        return this.i;
    }

    public void setAnimation(int i2) {
        this.f3364f = i2;
        this.f3363e = null;
        setCompositionTask(e.a(getContext(), i2));
    }

    public void setAnimation(String str) {
        this.f3363e = str;
        this.f3364f = 0;
        setCompositionTask(e.b(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        a(str, (String) null);
    }

    public void a(String str, String str2) {
        a(new JsonReader(new StringReader(str)), str2);
    }

    public void a(JsonReader jsonReader, String str) {
        setCompositionTask(e.a(jsonReader, str));
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(e.a(getContext(), str));
    }

    private void setCompositionTask(l<d> lVar) {
        f();
        e();
        this.k = lVar.a(this.f3360b).c((h<Throwable>) this.f3361c);
    }

    private void e() {
        l<d> lVar = this.k;
        if (lVar != null) {
            lVar.b(this.f3360b);
            this.k.d(this.f3361c);
        }
    }

    public void setComposition(d dVar) {
        if (c.f3502a) {
            String str = f3359a;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.f3362d.setCallback(this);
        this.l = dVar;
        boolean a2 = this.f3362d.a(dVar);
        g();
        if (getDrawable() != this.f3362d || a2) {
            setImageDrawable((Drawable) null);
            setImageDrawable(this.f3362d);
            requestLayout();
            for (i a3 : this.j) {
                a3.a(dVar);
            }
        }
    }

    public d getComposition() {
        return this.l;
    }

    public void b() {
        this.f3362d.f();
        g();
    }

    public void setMinFrame(int i2) {
        this.f3362d.a(i2);
    }

    public float getMinFrame() {
        return this.f3362d.h();
    }

    public void setMinProgress(float f2) {
        this.f3362d.a(f2);
    }

    public void setMaxFrame(int i2) {
        this.f3362d.b(i2);
    }

    public float getMaxFrame() {
        return this.f3362d.i();
    }

    public void setMaxProgress(float f2) {
        this.f3362d.b(f2);
    }

    public void setSpeed(float f2) {
        this.f3362d.c(f2);
    }

    public float getSpeed() {
        return this.f3362d.j();
    }

    public void a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f3362d.a(animatorUpdateListener);
    }

    public void setRepeatMode(int i2) {
        this.f3362d.d(i2);
    }

    public int getRepeatMode() {
        return this.f3362d.l();
    }

    public void setRepeatCount(int i2) {
        this.f3362d.e(i2);
    }

    public int getRepeatCount() {
        return this.f3362d.m();
    }

    public boolean c() {
        return this.f3362d.n();
    }

    public void setImageAssetsFolder(String str) {
        this.f3362d.a(str);
    }

    public String getImageAssetsFolder() {
        return this.f3362d.b();
    }

    public void setImageAssetDelegate(b bVar) {
        this.f3362d.a(bVar);
    }

    public void setFontAssetDelegate(a aVar) {
        this.f3362d.a(aVar);
    }

    public void setTextDelegate(p pVar) {
        this.f3362d.a(pVar);
    }

    public <T> void a(e eVar, T t, c<T> cVar) {
        this.f3362d.a(eVar, t, cVar);
    }

    public void setScale(float f2) {
        this.f3362d.e(f2);
        if (getDrawable() == this.f3362d) {
            a((Drawable) null, false);
            a((Drawable) this.f3362d, false);
        }
    }

    public float getScale() {
        return this.f3362d.q();
    }

    public void d() {
        this.f3362d.s();
        g();
    }

    public void setFrame(int i2) {
        this.f3362d.c(i2);
    }

    public int getFrame() {
        return this.f3362d.k();
    }

    public void setProgress(float f2) {
        this.f3362d.d(f2);
    }

    public float getProgress() {
        return this.f3362d.t();
    }

    public long getDuration() {
        d dVar = this.l;
        if (dVar != null) {
            return (long) dVar.c();
        }
        return 0;
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.f3362d.b(z);
    }

    public m getPerformanceTracker() {
        return this.f3362d.d();
    }

    private void f() {
        this.l = null;
        this.f3362d.e();
    }

    private void g() {
        int i2 = 1;
        if (this.i && this.f3362d.n()) {
            i2 = 2;
        }
        setLayerType(i2, (Paint) null);
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

        /* renamed from: a  reason: collision with root package name */
        String f3368a;

        /* renamed from: b  reason: collision with root package name */
        int f3369b;

        /* renamed from: c  reason: collision with root package name */
        float f3370c;

        /* renamed from: d  reason: collision with root package name */
        boolean f3371d;

        /* renamed from: e  reason: collision with root package name */
        String f3372e;

        /* renamed from: f  reason: collision with root package name */
        int f3373f;

        /* renamed from: g  reason: collision with root package name */
        int f3374g;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f3368a = parcel.readString();
            this.f3370c = parcel.readFloat();
            this.f3371d = parcel.readInt() != 1 ? false : true;
            this.f3372e = parcel.readString();
            this.f3373f = parcel.readInt();
            this.f3374g = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.f3368a);
            parcel.writeFloat(this.f3370c);
            parcel.writeInt(this.f3371d ? 1 : 0);
            parcel.writeString(this.f3372e);
            parcel.writeInt(this.f3373f);
            parcel.writeInt(this.f3374g);
        }
    }
}

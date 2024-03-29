package com.facebook.drawee.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.AspectRatioMeasure;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class DraweeView<DH extends DraweeHierarchy> extends ImageView {
    private static boolean sGlobalLegacyVisibilityHandlingEnabled = false;
    private float mAspectRatio = BitmapDescriptorFactory.HUE_RED;
    private DraweeHolder<DH> mDraweeHolder;
    private boolean mInitialised = false;
    private boolean mLegacyVisibilityHandlingEnabled = false;
    private final AspectRatioMeasure.Spec mMeasureSpec = new AspectRatioMeasure.Spec();

    public static void setGlobalLegacyVisibilityHandlingEnabled(boolean z) {
        sGlobalLegacyVisibilityHandlingEnabled = z;
    }

    public DraweeView(Context context) {
        super(context);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DraweeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(21)
    public DraweeView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("DraweeView#init");
            }
            if (!this.mInitialised) {
                boolean z = true;
                this.mInitialised = true;
                this.mDraweeHolder = DraweeHolder.create(null, context);
                if (Build.VERSION.SDK_INT >= 21) {
                    ColorStateList imageTintList = getImageTintList();
                    if (imageTintList != null) {
                        setColorFilter(imageTintList.getDefaultColor());
                    } else if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                        return;
                    } else {
                        return;
                    }
                }
                if (!sGlobalLegacyVisibilityHandlingEnabled || context.getApplicationInfo().targetSdkVersion < 24) {
                    z = false;
                }
                this.mLegacyVisibilityHandlingEnabled = z;
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } finally {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public void setHierarchy(DH dh) {
        this.mDraweeHolder.setHierarchy(dh);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DH getHierarchy() {
        return this.mDraweeHolder.getHierarchy();
    }

    public boolean hasHierarchy() {
        return this.mDraweeHolder.hasHierarchy();
    }

    public Drawable getTopLevelDrawable() {
        return this.mDraweeHolder.getTopLevelDrawable();
    }

    public void setController(DraweeController draweeController) {
        this.mDraweeHolder.setController(draweeController);
        super.setImageDrawable(this.mDraweeHolder.getTopLevelDrawable());
    }

    public DraweeController getController() {
        return this.mDraweeHolder.getController();
    }

    public boolean hasController() {
        return this.mDraweeHolder.getController() != null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        maybeOverrideVisibilityHandling();
        onAttach();
    }

    /* access modifiers changed from: protected */
    public void onAttach() {
        doAttach();
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
        doDetach();
    }

    /* access modifiers changed from: protected */
    public void doAttach() {
        this.mDraweeHolder.onAttach();
    }

    /* access modifiers changed from: protected */
    public void doDetach() {
        this.mDraweeHolder.onDetach();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mDraweeHolder.onTouchEvent(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Deprecated
    public void setImageDrawable(Drawable drawable) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageDrawable(drawable);
    }

    @Deprecated
    public void setImageBitmap(Bitmap bitmap) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageBitmap(bitmap);
    }

    @Deprecated
    public void setImageResource(int i) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageResource(i);
    }

    @Deprecated
    public void setImageURI(Uri uri) {
        init(getContext());
        this.mDraweeHolder.setController((DraweeController) null);
        super.setImageURI(uri);
    }

    public void setAspectRatio(float f2) {
        if (f2 != this.mAspectRatio) {
            this.mAspectRatio = f2;
            requestLayout();
        }
    }

    public float getAspectRatio() {
        return this.mAspectRatio;
    }

    public void setLegacyVisibilityHandlingEnabled(boolean z) {
        this.mLegacyVisibilityHandlingEnabled = z;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        AspectRatioMeasure.Spec spec = this.mMeasureSpec;
        spec.width = i;
        spec.height = i2;
        AspectRatioMeasure.updateMeasureSpec(spec, this.mAspectRatio, getLayoutParams(), getPaddingLeft() + getPaddingRight(), getPaddingTop() + getPaddingBottom());
        super.onMeasure(this.mMeasureSpec.width, this.mMeasureSpec.height);
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        maybeOverrideVisibilityHandling();
    }

    private void maybeOverrideVisibilityHandling() {
        if (this.mLegacyVisibilityHandlingEnabled) {
            Drawable drawable = getDrawable();
            if (drawable != null) {
                drawable.setVisible(getVisibility() == 0, false);
            }
        }
    }

    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper((Object) this);
        DraweeHolder<DH> draweeHolder = this.mDraweeHolder;
        return stringHelper.add("holder", (Object) draweeHolder != null ? draweeHolder.toString() : "<no holder set>").toString();
    }
}

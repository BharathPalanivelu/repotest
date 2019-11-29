package com.salesforce.android.service.common.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import androidx.f.a.a.b;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.DrawableUtils;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

class SalesforceFloatingActionButtonImpl {
    private static final long ANIMATION_DURATION_MS = 250;
    private int mButtonDiameter;
    GradientDrawable mButtonShape;
    Path mClipPath = new Path();
    Drawable mDisplayedIcon;
    int mDisplayedIconColor;
    private int mElevation;
    Drawable mIcon;
    int mIconColor;
    private int mIconSize;
    Interpolator mInterpolator;
    ValueAnimator mPressRippleAnimator;
    GradientDrawable mPressRippleShape;
    ValueAnimator mReleaseRippleAnimator;
    GradientDrawable mReleaseRippleShape;
    Drawable mRippleIcon;
    int mRippleIconColor;
    final View mView;

    SalesforceFloatingActionButtonImpl(Builder builder) {
        this.mView = builder.mView;
        this.mView.setWillNotDraw(false);
        this.mView.setBackgroundColor(0);
        this.mIconSize = this.mView.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_default_icon_size);
        this.mElevation = this.mView.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_elevation);
        this.mInterpolator = new b();
        this.mButtonShape = createCircle(builder.mButtonColor);
        this.mPressRippleShape = createCircle(builder.mRippleColor);
        this.mReleaseRippleShape = createCircle(builder.mButtonColor);
        this.mIconColor = builder.mIconColor;
        this.mRippleIconColor = builder.mRippleIconColor;
        this.mIcon = builder.mIcon;
        this.mRippleIcon = builder.mRippleIcon;
        setDisplayedIcon(this.mIcon, this.mIconColor);
    }

    /* access modifiers changed from: package-private */
    public void setButtonSize(int i, int i2) {
        this.mButtonDiameter = Math.min(i, i2);
        GradientDrawable gradientDrawable = this.mButtonShape;
        int i3 = this.mButtonDiameter;
        gradientDrawable.setBounds(0, 0, i3, i3);
        this.mIcon.setBounds(getIconBounds(this.mButtonDiameter, this.mIconSize));
        Path path = this.mClipPath;
        int i4 = this.mButtonDiameter;
        path.addOval(new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (float) i4, (float) i4), Path.Direction.CW);
        setElevation(this.mButtonDiameter);
        setDisplayedIcon(this.mDisplayedIcon, this.mDisplayedIconColor);
    }

    /* access modifiers changed from: package-private */
    public void setDisplayedIcon(Drawable drawable, int i) {
        this.mDisplayedIcon = drawable;
        this.mDisplayedIconColor = i;
        this.mDisplayedIcon.setBounds(getIconBounds(this.mButtonDiameter, this.mIconSize));
        DrawableUtils.colorize(this.mDisplayedIcon, this.mDisplayedIconColor);
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.clipPath(this.mClipPath);
        }
        this.mButtonShape.draw(canvas);
        this.mPressRippleShape.draw(canvas);
        this.mReleaseRippleShape.draw(canvas);
        this.mDisplayedIcon.draw(canvas);
    }

    /* access modifiers changed from: package-private */
    public Animator rippleOnPress(final Coordinate coordinate) {
        ValueAnimator valueAnimator = this.mPressRippleAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mPressRippleAnimator.cancel();
        }
        this.mPressRippleAnimator = createRippleAnimator();
        this.mPressRippleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) SalesforceFloatingActionButtonImpl.this.mPressRippleAnimator.getAnimatedValue()).floatValue();
                SalesforceFloatingActionButtonImpl salesforceFloatingActionButtonImpl = SalesforceFloatingActionButtonImpl.this;
                salesforceFloatingActionButtonImpl.scaleShape(salesforceFloatingActionButtonImpl.mPressRippleShape, SalesforceFloatingActionButtonImpl.this.wrapHotspot(coordinate), floatValue);
                SalesforceFloatingActionButtonImpl.this.mView.invalidate();
            }
        });
        this.mPressRippleAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                SalesforceFloatingActionButtonImpl salesforceFloatingActionButtonImpl = SalesforceFloatingActionButtonImpl.this;
                salesforceFloatingActionButtonImpl.setDisplayedIcon(salesforceFloatingActionButtonImpl.mRippleIcon, SalesforceFloatingActionButtonImpl.this.mRippleIconColor);
            }
        });
        return this.mPressRippleAnimator;
    }

    /* access modifiers changed from: package-private */
    public Animator rippleOnRelease(final Coordinate coordinate) {
        ValueAnimator valueAnimator = this.mReleaseRippleAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mReleaseRippleAnimator.cancel();
        }
        this.mReleaseRippleAnimator = createRippleAnimator();
        this.mReleaseRippleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SalesforceFloatingActionButtonImpl salesforceFloatingActionButtonImpl = SalesforceFloatingActionButtonImpl.this;
                salesforceFloatingActionButtonImpl.scaleShape(salesforceFloatingActionButtonImpl.mReleaseRippleShape, SalesforceFloatingActionButtonImpl.this.wrapHotspot(coordinate), floatValue);
                SalesforceFloatingActionButtonImpl.this.mView.invalidate();
            }
        });
        this.mReleaseRippleAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                SalesforceFloatingActionButtonImpl.this.mPressRippleShape.setBounds(0, 0, 0, 0);
                SalesforceFloatingActionButtonImpl.this.mReleaseRippleShape.setBounds(0, 0, 0, 0);
                SalesforceFloatingActionButtonImpl salesforceFloatingActionButtonImpl = SalesforceFloatingActionButtonImpl.this;
                salesforceFloatingActionButtonImpl.setDisplayedIcon(salesforceFloatingActionButtonImpl.mIcon, SalesforceFloatingActionButtonImpl.this.mIconColor);
                SalesforceFloatingActionButtonImpl.this.mView.invalidate();
            }
        });
        return this.mReleaseRippleAnimator;
    }

    private GradientDrawable createCircle(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    private ValueAnimator createRippleAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
        ofFloat.setDuration(ANIMATION_DURATION_MS).setInterpolator(this.mInterpolator);
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void scaleShape(Drawable drawable, Coordinate coordinate, float f2) {
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            i = Math.max(coordinate.getX(), coordinate.getY()) + Math.round(((float) this.mButtonDiameter) * 1.2f);
        } else {
            i = this.mButtonDiameter;
        }
        float f3 = ((float) i) * f2;
        int round = Math.round(f3);
        int round2 = Math.round(f3);
        drawable.setBounds(coordinate.getX() - (round / 2), coordinate.getY() - (round2 / 2), round, round2);
    }

    /* access modifiers changed from: package-private */
    public Coordinate wrapHotspot(Coordinate coordinate) {
        if (Build.VERSION.SDK_INT >= 21) {
            return coordinate;
        }
        int i = this.mButtonDiameter;
        return Coordinate.create(i / 2, i / 2);
    }

    private Rect getIconBounds(int i, int i2) {
        int i3 = i / 2;
        int i4 = i2 / 2;
        int i5 = i3 - i4;
        int i6 = i3 + i4;
        return new Rect(i5, i5, i6, i6);
    }

    @SuppressLint({"NewApi"})
    private void setElevation(final int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.mView.setOutlineProvider(new ViewOutlineProvider() {
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    int i = i;
                    outline.setOval(new Rect(0, 0, i, i));
                }
            });
            this.mView.setElevation((float) this.mElevation);
        }
    }

    static Builder builder(View view) {
        return new Builder(view);
    }

    static class Builder {
        int mButtonColor;
        Drawable mIcon;
        int mIconColor;
        int mRippleColor;
        Drawable mRippleIcon;
        int mRippleIconColor;
        final View mView;

        public Builder(View view) {
            this.mView = view;
        }

        public Builder setButtonColor(int i) {
            this.mButtonColor = i;
            return this;
        }

        public Builder setRippleColor(int i) {
            this.mRippleColor = i;
            return this;
        }

        public Builder setIconColor(int i) {
            this.mIconColor = i;
            return this;
        }

        public Builder setRippleIconColor(int i) {
            this.mRippleIconColor = i;
            return this;
        }

        public Builder setIcon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }

        public Builder setRippleIcon(Drawable drawable) {
            this.mRippleIcon = drawable;
            return this;
        }

        public SalesforceFloatingActionButtonImpl build() {
            if (this.mRippleIcon == null) {
                this.mRippleIcon = this.mIcon;
            }
            return new SalesforceFloatingActionButtonImpl(this);
        }
    }
}

package com.facebook.drawee.generic;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.FadeDrawable;
import com.facebook.drawee.drawable.ForwardingDrawable;
import com.facebook.drawee.drawable.MatrixDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class GenericDraweeHierarchy implements SettableDraweeHierarchy {
    private static final int ACTUAL_IMAGE_INDEX = 2;
    private static final int BACKGROUND_IMAGE_INDEX = 0;
    private static final int FAILURE_IMAGE_INDEX = 5;
    private static final int OVERLAY_IMAGES_INDEX = 6;
    private static final int PLACEHOLDER_IMAGE_INDEX = 1;
    private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
    private static final int RETRY_IMAGE_INDEX = 4;
    private final ForwardingDrawable mActualImageWrapper;
    private final Drawable mEmptyActualImageDrawable = new ColorDrawable(0);
    private final FadeDrawable mFadeDrawable;
    private final Resources mResources;
    private RoundingParams mRoundingParams;
    private final RootDrawable mTopLevelDrawable;

    GenericDraweeHierarchy(GenericDraweeHierarchyBuilder genericDraweeHierarchyBuilder) {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("GenericDraweeHierarchy()");
        }
        this.mResources = genericDraweeHierarchyBuilder.getResources();
        this.mRoundingParams = genericDraweeHierarchyBuilder.getRoundingParams();
        this.mActualImageWrapper = new ForwardingDrawable(this.mEmptyActualImageDrawable);
        int i = 1;
        int size = (genericDraweeHierarchyBuilder.getOverlays() != null ? genericDraweeHierarchyBuilder.getOverlays().size() : 1) + (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null ? 1 : 0);
        Drawable[] drawableArr = new Drawable[(size + 6)];
        drawableArr[0] = buildBranch(genericDraweeHierarchyBuilder.getBackground(), (ScalingUtils.ScaleType) null);
        drawableArr[1] = buildBranch(genericDraweeHierarchyBuilder.getPlaceholderImage(), genericDraweeHierarchyBuilder.getPlaceholderImageScaleType());
        drawableArr[2] = buildActualImageBranch(this.mActualImageWrapper, genericDraweeHierarchyBuilder.getActualImageScaleType(), genericDraweeHierarchyBuilder.getActualImageFocusPoint(), genericDraweeHierarchyBuilder.getActualImageColorFilter());
        drawableArr[3] = buildBranch(genericDraweeHierarchyBuilder.getProgressBarImage(), genericDraweeHierarchyBuilder.getProgressBarImageScaleType());
        drawableArr[4] = buildBranch(genericDraweeHierarchyBuilder.getRetryImage(), genericDraweeHierarchyBuilder.getRetryImageScaleType());
        drawableArr[5] = buildBranch(genericDraweeHierarchyBuilder.getFailureImage(), genericDraweeHierarchyBuilder.getFailureImageScaleType());
        if (size > 0) {
            if (genericDraweeHierarchyBuilder.getOverlays() != null) {
                i = 0;
                for (Drawable buildBranch : genericDraweeHierarchyBuilder.getOverlays()) {
                    drawableArr[i + 6] = buildBranch(buildBranch, (ScalingUtils.ScaleType) null);
                    i++;
                }
            }
            if (genericDraweeHierarchyBuilder.getPressedStateOverlay() != null) {
                drawableArr[i + 6] = buildBranch(genericDraweeHierarchyBuilder.getPressedStateOverlay(), (ScalingUtils.ScaleType) null);
            }
        }
        this.mFadeDrawable = new FadeDrawable(drawableArr);
        this.mFadeDrawable.setTransitionDuration(genericDraweeHierarchyBuilder.getFadeDuration());
        this.mTopLevelDrawable = new RootDrawable(WrappingUtils.maybeWrapWithRoundedOverlayColor(this.mFadeDrawable, this.mRoundingParams));
        this.mTopLevelDrawable.mutate();
        resetFade();
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    private Drawable buildActualImageBranch(Drawable drawable, ScalingUtils.ScaleType scaleType, PointF pointF, ColorFilter colorFilter) {
        drawable.setColorFilter(colorFilter);
        return WrappingUtils.maybeWrapWithScaleType(drawable, scaleType, pointF);
    }

    private Drawable buildBranch(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        return WrappingUtils.maybeWrapWithScaleType(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources), scaleType);
    }

    private void resetActualImages() {
        this.mActualImageWrapper.setDrawable(this.mEmptyActualImageDrawable);
    }

    private void resetFade() {
        FadeDrawable fadeDrawable = this.mFadeDrawable;
        if (fadeDrawable != null) {
            fadeDrawable.beginBatchMode();
            this.mFadeDrawable.fadeInAllLayers();
            fadeOutBranches();
            fadeInLayer(1);
            this.mFadeDrawable.finishTransitionImmediately();
            this.mFadeDrawable.endBatchMode();
        }
    }

    private void fadeOutBranches() {
        fadeOutLayer(1);
        fadeOutLayer(2);
        fadeOutLayer(3);
        fadeOutLayer(4);
        fadeOutLayer(5);
    }

    private void fadeInLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeInLayer(i);
        }
    }

    private void fadeOutLayer(int i) {
        if (i >= 0) {
            this.mFadeDrawable.fadeOutLayer(i);
        }
    }

    private void setProgress(float f2) {
        Drawable drawable = this.mFadeDrawable.getDrawable(3);
        if (drawable != null) {
            if (f2 >= 0.999f) {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).stop();
                }
                fadeOutLayer(3);
            } else {
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
                fadeInLayer(3);
            }
            drawable.setLevel(Math.round(f2 * 10000.0f));
        }
    }

    public Drawable getTopLevelDrawable() {
        return this.mTopLevelDrawable;
    }

    public void reset() {
        resetActualImages();
        resetFade();
    }

    public void setImage(Drawable drawable, float f2, boolean z) {
        Drawable maybeApplyLeafRounding = WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources);
        maybeApplyLeafRounding.mutate();
        this.mActualImageWrapper.setDrawable(maybeApplyLeafRounding);
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        fadeInLayer(2);
        setProgress(f2);
        if (z) {
            this.mFadeDrawable.finishTransitionImmediately();
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setProgress(float f2, boolean z) {
        if (this.mFadeDrawable.getDrawable(3) != null) {
            this.mFadeDrawable.beginBatchMode();
            setProgress(f2);
            if (z) {
                this.mFadeDrawable.finishTransitionImmediately();
            }
            this.mFadeDrawable.endBatchMode();
        }
    }

    public void setFailure(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(5) != null) {
            fadeInLayer(5);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setRetry(Throwable th) {
        this.mFadeDrawable.beginBatchMode();
        fadeOutBranches();
        if (this.mFadeDrawable.getDrawable(4) != null) {
            fadeInLayer(4);
        } else {
            fadeInLayer(1);
        }
        this.mFadeDrawable.endBatchMode();
    }

    public void setControllerOverlay(Drawable drawable) {
        this.mTopLevelDrawable.setControllerOverlay(drawable);
    }

    private DrawableParent getParentDrawableAtIndex(int i) {
        DrawableParent drawableParentForIndex = this.mFadeDrawable.getDrawableParentForIndex(i);
        if (drawableParentForIndex.getDrawable() instanceof MatrixDrawable) {
            drawableParentForIndex = (MatrixDrawable) drawableParentForIndex.getDrawable();
        }
        return drawableParentForIndex.getDrawable() instanceof ScaleTypeDrawable ? (ScaleTypeDrawable) drawableParentForIndex.getDrawable() : drawableParentForIndex;
    }

    private void setChildDrawableAtIndex(int i, Drawable drawable) {
        if (drawable == null) {
            this.mFadeDrawable.setDrawable(i, (Drawable) null);
            return;
        }
        getParentDrawableAtIndex(i).setDrawable(WrappingUtils.maybeApplyLeafRounding(drawable, this.mRoundingParams, this.mResources));
    }

    private ScaleTypeDrawable getScaleTypeDrawableAtIndex(int i) {
        DrawableParent parentDrawableAtIndex = getParentDrawableAtIndex(i);
        if (parentDrawableAtIndex instanceof ScaleTypeDrawable) {
            return (ScaleTypeDrawable) parentDrawableAtIndex;
        }
        return WrappingUtils.wrapChildWithScaleType(parentDrawableAtIndex, ScalingUtils.ScaleType.FIT_XY);
    }

    private boolean hasScaleTypeDrawableAtIndex(int i) {
        return getParentDrawableAtIndex(i) instanceof ScaleTypeDrawable;
    }

    public void setFadeDuration(int i) {
        this.mFadeDrawable.setTransitionDuration(i);
    }

    public int getFadeDuration() {
        return this.mFadeDrawable.getTransitionDuration();
    }

    public void setActualImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(2).setFocusPoint(pointF);
    }

    public void setActualImageScaleType(ScalingUtils.ScaleType scaleType) {
        Preconditions.checkNotNull(scaleType);
        getScaleTypeDrawableAtIndex(2).setScaleType(scaleType);
    }

    public ScalingUtils.ScaleType getActualImageScaleType() {
        if (!hasScaleTypeDrawableAtIndex(2)) {
            return null;
        }
        return getScaleTypeDrawableAtIndex(2).getScaleType();
    }

    public void setActualImageColorFilter(ColorFilter colorFilter) {
        this.mActualImageWrapper.setColorFilter(colorFilter);
    }

    public void getActualImageBounds(RectF rectF) {
        this.mActualImageWrapper.getTransformedBounds(rectF);
    }

    public void setPlaceholderImage(Drawable drawable) {
        setChildDrawableAtIndex(1, drawable);
    }

    public void setPlaceholderImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(1, drawable);
        getScaleTypeDrawableAtIndex(1).setScaleType(scaleType);
    }

    public boolean hasPlaceholderImage() {
        return this.mFadeDrawable.getDrawable(1) != null;
    }

    public void setPlaceholderImageFocusPoint(PointF pointF) {
        Preconditions.checkNotNull(pointF);
        getScaleTypeDrawableAtIndex(1).setFocusPoint(pointF);
    }

    public void setPlaceholderImage(int i) {
        setPlaceholderImage(this.mResources.getDrawable(i));
    }

    public void setPlaceholderImage(int i, ScalingUtils.ScaleType scaleType) {
        setPlaceholderImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setFailureImage(Drawable drawable) {
        setChildDrawableAtIndex(5, drawable);
    }

    public void setFailureImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(5, drawable);
        getScaleTypeDrawableAtIndex(5).setScaleType(scaleType);
    }

    public void setFailureImage(int i) {
        setFailureImage(this.mResources.getDrawable(i));
    }

    public void setFailureImage(int i, ScalingUtils.ScaleType scaleType) {
        setFailureImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setRetryImage(Drawable drawable) {
        setChildDrawableAtIndex(4, drawable);
    }

    public void setRetryImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(4, drawable);
        getScaleTypeDrawableAtIndex(4).setScaleType(scaleType);
    }

    public void setRetryImage(int i) {
        setRetryImage(this.mResources.getDrawable(i));
    }

    public void setRetryImage(int i, ScalingUtils.ScaleType scaleType) {
        setRetryImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setProgressBarImage(Drawable drawable) {
        setChildDrawableAtIndex(3, drawable);
    }

    public void setProgressBarImage(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        setChildDrawableAtIndex(3, drawable);
        getScaleTypeDrawableAtIndex(3).setScaleType(scaleType);
    }

    public void setProgressBarImage(int i) {
        setProgressBarImage(this.mResources.getDrawable(i));
    }

    public void setProgressBarImage(int i, ScalingUtils.ScaleType scaleType) {
        setProgressBarImage(this.mResources.getDrawable(i), scaleType);
    }

    public void setBackgroundImage(Drawable drawable) {
        setChildDrawableAtIndex(0, drawable);
    }

    public void setOverlayImage(int i, Drawable drawable) {
        Preconditions.checkArgument(i >= 0 && i + 6 < this.mFadeDrawable.getNumberOfLayers(), "The given index does not correspond to an overlay image.");
        setChildDrawableAtIndex(i + 6, drawable);
    }

    public void setOverlayImage(Drawable drawable) {
        setOverlayImage(0, drawable);
    }

    public void setRoundingParams(RoundingParams roundingParams) {
        this.mRoundingParams = roundingParams;
        WrappingUtils.updateOverlayColorRounding(this.mTopLevelDrawable, this.mRoundingParams);
        for (int i = 0; i < this.mFadeDrawable.getNumberOfLayers(); i++) {
            WrappingUtils.updateLeafRounding(getParentDrawableAtIndex(i), this.mRoundingParams, this.mResources);
        }
    }

    public RoundingParams getRoundingParams() {
        return this.mRoundingParams;
    }

    @VisibleForTesting
    public boolean hasImage() {
        return this.mActualImageWrapper.getDrawable() != this.mEmptyActualImageDrawable;
    }
}

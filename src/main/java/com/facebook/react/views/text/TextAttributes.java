package com.facebook.react.views.text;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.uimanager.PixelUtil;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class TextAttributes {
    public static final float DEFAULT_MAX_FONT_SIZE_MULTIPLIER = 0.0f;
    private boolean mAllowFontScaling = true;
    private float mFontSize = Float.NaN;
    private float mHeightOfTallestInlineViewOrImage = Float.NaN;
    private float mLetterSpacing = Float.NaN;
    private float mLineHeight = Float.NaN;
    private float mMaxFontSizeMultiplier = Float.NaN;
    private TextTransform mTextTransform = TextTransform.UNSET;

    public TextAttributes applyChild(TextAttributes textAttributes) {
        TextAttributes textAttributes2 = new TextAttributes();
        textAttributes2.mAllowFontScaling = this.mAllowFontScaling;
        textAttributes2.mFontSize = !Float.isNaN(textAttributes.mFontSize) ? textAttributes.mFontSize : this.mFontSize;
        textAttributes2.mLineHeight = !Float.isNaN(textAttributes.mLineHeight) ? textAttributes.mLineHeight : this.mLineHeight;
        textAttributes2.mLetterSpacing = !Float.isNaN(textAttributes.mLetterSpacing) ? textAttributes.mLetterSpacing : this.mLetterSpacing;
        textAttributes2.mMaxFontSizeMultiplier = !Float.isNaN(textAttributes.mMaxFontSizeMultiplier) ? textAttributes.mMaxFontSizeMultiplier : this.mMaxFontSizeMultiplier;
        textAttributes2.mHeightOfTallestInlineViewOrImage = !Float.isNaN(textAttributes.mHeightOfTallestInlineViewOrImage) ? textAttributes.mHeightOfTallestInlineViewOrImage : this.mHeightOfTallestInlineViewOrImage;
        textAttributes2.mTextTransform = textAttributes.mTextTransform != TextTransform.UNSET ? textAttributes.mTextTransform : this.mTextTransform;
        return textAttributes2;
    }

    public boolean getAllowFontScaling() {
        return this.mAllowFontScaling;
    }

    public void setAllowFontScaling(boolean z) {
        this.mAllowFontScaling = z;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public void setFontSize(float f2) {
        this.mFontSize = f2;
    }

    public float getLineHeight() {
        return this.mLineHeight;
    }

    public void setLineHeight(float f2) {
        this.mLineHeight = f2;
    }

    public float getLetterSpacing() {
        return this.mLetterSpacing;
    }

    public void setLetterSpacing(float f2) {
        this.mLetterSpacing = f2;
    }

    public float getMaxFontSizeMultiplier() {
        return this.mMaxFontSizeMultiplier;
    }

    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 == BitmapDescriptorFactory.HUE_RED || f2 >= 1.0f) {
            this.mMaxFontSizeMultiplier = f2;
            return;
        }
        throw new JSApplicationIllegalArgumentException("maxFontSizeMultiplier must be NaN, 0, or >= 1");
    }

    public float getHeightOfTallestInlineViewOrImage() {
        return this.mHeightOfTallestInlineViewOrImage;
    }

    public void setHeightOfTallestInlineViewOrImage(float f2) {
        this.mHeightOfTallestInlineViewOrImage = f2;
    }

    public TextTransform getTextTransform() {
        return this.mTextTransform;
    }

    public void setTextTransform(TextTransform textTransform) {
        this.mTextTransform = textTransform;
    }

    public int getEffectiveFontSize() {
        double d2;
        float f2 = !Float.isNaN(this.mFontSize) ? this.mFontSize : 14.0f;
        if (this.mAllowFontScaling) {
            d2 = Math.ceil((double) PixelUtil.toPixelFromSP(f2, getEffectiveMaxFontSizeMultiplier()));
        } else {
            d2 = Math.ceil((double) PixelUtil.toPixelFromDIP(f2));
        }
        return (int) d2;
    }

    public float getEffectiveLineHeight() {
        float f2;
        if (Float.isNaN(this.mLineHeight)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLineHeight, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLineHeight);
        }
        return !Float.isNaN(this.mHeightOfTallestInlineViewOrImage) && (this.mHeightOfTallestInlineViewOrImage > f2 ? 1 : (this.mHeightOfTallestInlineViewOrImage == f2 ? 0 : -1)) > 0 ? this.mHeightOfTallestInlineViewOrImage : f2;
    }

    public float getEffectiveLetterSpacing() {
        float f2;
        if (Float.isNaN(this.mLetterSpacing)) {
            return Float.NaN;
        }
        if (this.mAllowFontScaling) {
            f2 = PixelUtil.toPixelFromSP(this.mLetterSpacing, getEffectiveMaxFontSizeMultiplier());
        } else {
            f2 = PixelUtil.toPixelFromDIP(this.mLetterSpacing);
        }
        return f2 / ((float) getEffectiveFontSize());
    }

    public float getEffectiveMaxFontSizeMultiplier() {
        return !Float.isNaN(this.mMaxFontSizeMultiplier) ? this.mMaxFontSizeMultiplier : BitmapDescriptorFactory.HUE_RED;
    }

    public String toString() {
        return "TextAttributes {\n  getAllowFontScaling(): " + getAllowFontScaling() + "\n  getFontSize(): " + getFontSize() + "\n  getEffectiveFontSize(): " + getEffectiveFontSize() + "\n  getHeightOfTallestInlineViewOrImage(): " + getHeightOfTallestInlineViewOrImage() + "\n  getLetterSpacing(): " + getLetterSpacing() + "\n  getEffectiveLetterSpacing(): " + getEffectiveLetterSpacing() + "\n  getLineHeight(): " + getLineHeight() + "\n  getEffectiveLineHeight(): " + getEffectiveLineHeight() + "\n  getTextTransform(): " + getTextTransform() + "\n  getMaxFontSizeMultiplier(): " + getMaxFontSizeMultiplier() + "\n  getEffectiveMaxFontSizeMultiplier(): " + getEffectiveMaxFontSizeMultiplier() + "\n}";
    }
}

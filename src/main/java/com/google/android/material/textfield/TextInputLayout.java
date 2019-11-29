package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.ar;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.z;
import androidx.core.content.b;
import androidx.core.g.w;
import androidx.core.widget.i;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.a;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.c;
import com.google.android.material.internal.d;
import com.google.android.material.internal.e;
import com.google.android.material.internal.l;
import com.google.android.material.internal.m;

public class TextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = -1;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    final c collapsingTextHelper;
    boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final b indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    /* access modifiers changed from: private */
    public boolean restoringSavedState;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.indicatorViewController = new b(this);
        this.tmpRect = new Rect();
        this.tmpRectF = new RectF();
        this.collapsingTextHelper = new c(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.inputFrame = new FrameLayout(context);
        this.inputFrame.setAddStatesFromChildren(true);
        addView(this.inputFrame);
        this.collapsingTextHelper.a(com.google.android.material.a.a.f13098a);
        this.collapsingTextHelper.b(com.google.android.material.a.a.f13098a);
        this.collapsingTextHelper.b(8388659);
        ar b2 = l.b(context, attributeSet, a.k.TextInputLayout, i, a.j.Widget_Design_TextInputLayout, new int[0]);
        this.hintEnabled = b2.a(a.k.TextInputLayout_hintEnabled, true);
        setHint(b2.c(a.k.TextInputLayout_android_hint));
        this.hintAnimationEnabled = b2.a(a.k.TextInputLayout_hintAnimationEnabled, true);
        this.boxBottomOffsetPx = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_bottom_offset);
        this.boxLabelCutoutPaddingPx = context.getResources().getDimensionPixelOffset(a.d.mtrl_textinput_box_label_cutout_padding);
        this.boxCollapsedPaddingTopPx = b2.d(a.k.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.boxCornerRadiusTopStart = b2.b(a.k.TextInputLayout_boxCornerRadiusTopStart, (float) BitmapDescriptorFactory.HUE_RED);
        this.boxCornerRadiusTopEnd = b2.b(a.k.TextInputLayout_boxCornerRadiusTopEnd, (float) BitmapDescriptorFactory.HUE_RED);
        this.boxCornerRadiusBottomEnd = b2.b(a.k.TextInputLayout_boxCornerRadiusBottomEnd, (float) BitmapDescriptorFactory.HUE_RED);
        this.boxCornerRadiusBottomStart = b2.b(a.k.TextInputLayout_boxCornerRadiusBottomStart, (float) BitmapDescriptorFactory.HUE_RED);
        this.boxBackgroundColor = b2.b(a.k.TextInputLayout_boxBackgroundColor, 0);
        this.focusedStrokeColor = b2.b(a.k.TextInputLayout_boxStrokeColor, 0);
        this.boxStrokeWidthDefaultPx = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_default);
        this.boxStrokeWidthFocusedPx = context.getResources().getDimensionPixelSize(a.d.mtrl_textinput_box_stroke_width_focused);
        this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
        setBoxBackgroundMode(b2.a(a.k.TextInputLayout_boxBackgroundMode, 0));
        if (b2.g(a.k.TextInputLayout_android_textColorHint)) {
            ColorStateList e2 = b2.e(a.k.TextInputLayout_android_textColorHint);
            this.focusedTextColor = e2;
            this.defaultHintTextColor = e2;
        }
        this.defaultStrokeColor = b.c(context, a.c.mtrl_textinput_default_box_stroke_color);
        this.disabledColor = b.c(context, a.c.mtrl_textinput_disabled_color);
        this.hoveredStrokeColor = b.c(context, a.c.mtrl_textinput_hovered_box_stroke_color);
        if (b2.g(a.k.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(b2.g(a.k.TextInputLayout_hintTextAppearance, 0));
        }
        int g2 = b2.g(a.k.TextInputLayout_errorTextAppearance, 0);
        boolean a2 = b2.a(a.k.TextInputLayout_errorEnabled, false);
        int g3 = b2.g(a.k.TextInputLayout_helperTextTextAppearance, 0);
        boolean a3 = b2.a(a.k.TextInputLayout_helperTextEnabled, false);
        CharSequence c2 = b2.c(a.k.TextInputLayout_helperText);
        boolean a4 = b2.a(a.k.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(b2.a(a.k.TextInputLayout_counterMaxLength, -1));
        this.counterTextAppearance = b2.g(a.k.TextInputLayout_counterTextAppearance, 0);
        this.counterOverflowTextAppearance = b2.g(a.k.TextInputLayout_counterOverflowTextAppearance, 0);
        this.passwordToggleEnabled = b2.a(a.k.TextInputLayout_passwordToggleEnabled, false);
        this.passwordToggleDrawable = b2.a(a.k.TextInputLayout_passwordToggleDrawable);
        this.passwordToggleContentDesc = b2.c(a.k.TextInputLayout_passwordToggleContentDescription);
        if (b2.g(a.k.TextInputLayout_passwordToggleTint)) {
            this.hasPasswordToggleTintList = true;
            this.passwordToggleTintList = b2.e(a.k.TextInputLayout_passwordToggleTint);
        }
        if (b2.g(a.k.TextInputLayout_passwordToggleTintMode)) {
            this.hasPasswordToggleTintMode = true;
            this.passwordToggleTintMode = m.a(b2.a(a.k.TextInputLayout_passwordToggleTintMode, -1), (PorterDuff.Mode) null);
        }
        b2.a();
        setHelperTextEnabled(a3);
        setHelperText(c2);
        setHelperTextTextAppearance(g3);
        setErrorEnabled(a2);
        setErrorTextAppearance(g2);
        setCounterEnabled(a4);
        applyPasswordToggleTint();
        w.d((View) this, 2);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.inputFrame.addView(view, layoutParams2);
            this.inputFrame.setLayoutParams(layoutParams);
            updateInputLayoutMargins();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        int i = this.boxBackgroundMode;
        if (i == 1 || i == 2) {
            return this.boxBackground;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.boxBackgroundMode) {
            this.boxBackgroundMode = i;
            onApplyBoxBackgroundMode();
        }
    }

    private void onApplyBoxBackgroundMode() {
        assignBoxBackgroundByMode();
        if (this.boxBackgroundMode != 0) {
            updateInputLayoutMargins();
        }
        updateTextInputBoxBounds();
    }

    private void assignBoxBackgroundByMode() {
        int i = this.boxBackgroundMode;
        if (i == 0) {
            this.boxBackground = null;
        } else if (i == 2 && this.hintEnabled && !(this.boxBackground instanceof a)) {
            this.boxBackground = new a();
        } else if (!(this.boxBackground instanceof GradientDrawable)) {
            this.boxBackground = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.focusedStrokeColor != i) {
            this.focusedStrokeColor = i;
            updateTextInputBoxState();
        }
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(b.c(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.boxBackgroundColor != i) {
            this.boxBackgroundColor = i;
            applyBoxAttributes();
        }
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i4));
    }

    public void setBoxCornerRadii(float f2, float f3, float f4, float f5) {
        if (this.boxCornerRadiusTopStart != f2 || this.boxCornerRadiusTopEnd != f3 || this.boxCornerRadiusBottomEnd != f5 || this.boxCornerRadiusBottomStart != f4) {
            this.boxCornerRadiusTopStart = f2;
            this.boxCornerRadiusTopEnd = f3;
            this.boxCornerRadiusBottomEnd = f5;
            this.boxCornerRadiusBottomStart = f4;
            applyBoxAttributes();
        }
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    private float[] getCornerRadiiAsArray() {
        if (!m.a(this)) {
            float f2 = this.boxCornerRadiusTopStart;
            float f3 = this.boxCornerRadiusTopEnd;
            float f4 = this.boxCornerRadiusBottomEnd;
            float f5 = this.boxCornerRadiusBottomStart;
            return new float[]{f2, f2, f3, f3, f4, f4, f5, f5};
        }
        float f6 = this.boxCornerRadiusTopEnd;
        float f7 = this.boxCornerRadiusTopStart;
        float f8 = this.boxCornerRadiusBottomStart;
        float f9 = this.boxCornerRadiusBottomEnd;
        return new float[]{f6, f6, f7, f7, f8, f8, f9, f9};
    }

    public void setTypeface(Typeface typeface2) {
        if (typeface2 != this.typeface) {
            this.typeface = typeface2;
            this.collapsingTextHelper.a(typeface2);
            this.indicatorViewController.a(typeface2);
            TextView textView = this.counterView;
            if (textView != null) {
                textView.setTypeface(typeface2);
            }
        }
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.originalHint != null) {
            EditText editText2 = this.editText;
            if (editText2 != null) {
                boolean z = this.isProvidingHint;
                this.isProvidingHint = false;
                CharSequence hint2 = editText2.getHint();
                this.editText.setHint(this.originalHint);
                try {
                    super.dispatchProvideAutofillStructure(viewStructure, i);
                    return;
                } finally {
                    this.editText.setHint(hint2);
                    this.isProvidingHint = z;
                }
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, i);
    }

    private void setEditText(EditText editText2) {
        if (this.editText == null) {
            if (!(editText2 instanceof c)) {
                Log.i(LOG_TAG, "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.editText = editText2;
            onApplyBoxBackgroundMode();
            setTextInputAccessibilityDelegate(new a(this));
            if (!hasPasswordTransformation()) {
                this.collapsingTextHelper.a(this.editText.getTypeface());
            }
            this.collapsingTextHelper.a(this.editText.getTextSize());
            int gravity = this.editText.getGravity();
            this.collapsingTextHelper.b((gravity & -113) | 48);
            this.collapsingTextHelper.a(gravity);
            this.editText.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.updateLabelState(!textInputLayout.restoringSavedState);
                    if (TextInputLayout.this.counterEnabled) {
                        TextInputLayout.this.updateCounter(editable.length());
                    }
                }
            });
            if (this.defaultHintTextColor == null) {
                this.defaultHintTextColor = this.editText.getHintTextColors();
            }
            if (this.hintEnabled) {
                if (TextUtils.isEmpty(this.hint)) {
                    this.originalHint = this.editText.getHint();
                    setHint(this.originalHint);
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.counterView != null) {
                updateCounter(this.editText.getText().length());
            }
            this.indicatorViewController.d();
            updatePasswordToggleView();
            updateLabelState(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void updateInputLayoutMargins() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.inputFrame.getLayoutParams();
        int calculateLabelMarginTop = calculateLabelMarginTop();
        if (calculateLabelMarginTop != layoutParams.topMargin) {
            layoutParams.topMargin = calculateLabelMarginTop;
            this.inputFrame.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateLabelState(boolean z) {
        updateLabelState(z, false);
    }

    private void updateLabelState(boolean z, boolean z2) {
        boolean isEnabled = isEnabled();
        EditText editText2 = this.editText;
        boolean z3 = true;
        boolean z4 = editText2 != null && !TextUtils.isEmpty(editText2.getText());
        EditText editText3 = this.editText;
        if (editText3 == null || !editText3.hasFocus()) {
            z3 = false;
        }
        boolean g2 = this.indicatorViewController.g();
        ColorStateList colorStateList = this.defaultHintTextColor;
        if (colorStateList != null) {
            this.collapsingTextHelper.a(colorStateList);
            this.collapsingTextHelper.b(this.defaultHintTextColor);
        }
        if (!isEnabled) {
            this.collapsingTextHelper.a(ColorStateList.valueOf(this.disabledColor));
            this.collapsingTextHelper.b(ColorStateList.valueOf(this.disabledColor));
        } else if (g2) {
            this.collapsingTextHelper.a(this.indicatorViewController.l());
        } else {
            if (this.counterOverflowed) {
                TextView textView = this.counterView;
                if (textView != null) {
                    this.collapsingTextHelper.a(textView.getTextColors());
                }
            }
            if (z3) {
                ColorStateList colorStateList2 = this.focusedTextColor;
                if (colorStateList2 != null) {
                    this.collapsingTextHelper.a(colorStateList2);
                }
            }
        }
        if (z4 || (isEnabled() && (z3 || g2))) {
            if (z2 || this.hintExpanded) {
                collapseHint(z);
            }
        } else if (z2 || !this.hintExpanded) {
            expandHint(z);
        }
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setHint(CharSequence charSequence) {
        if (this.hintEnabled) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.hint)) {
            this.hint = charSequence;
            this.collapsingTextHelper.a(charSequence);
            if (!this.hintExpanded) {
                openCutout();
            }
        }
    }

    public CharSequence getHint() {
        if (this.hintEnabled) {
            return this.hint;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.hintEnabled) {
            this.hintEnabled = z;
            if (!this.hintEnabled) {
                this.isProvidingHint = false;
                if (!TextUtils.isEmpty(this.hint) && TextUtils.isEmpty(this.editText.getHint())) {
                    this.editText.setHint(this.hint);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint2 = this.editText.getHint();
                if (!TextUtils.isEmpty(hint2)) {
                    if (TextUtils.isEmpty(this.hint)) {
                        setHint(hint2);
                    }
                    this.editText.setHint((CharSequence) null);
                }
                this.isProvidingHint = true;
            }
            if (this.editText != null) {
                updateInputLayoutMargins();
            }
        }
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    /* access modifiers changed from: package-private */
    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    public void setHintTextAppearance(int i) {
        this.collapsingTextHelper.c(i);
        this.focusedTextColor = this.collapsingTextHelper.h();
        if (this.editText != null) {
            updateLabelState(false);
            updateInputLayoutMargins();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        if (this.editText != null) {
            updateLabelState(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public void setErrorEnabled(boolean z) {
        this.indicatorViewController.a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.indicatorViewController.b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.k();
    }

    public void setHelperTextTextAppearance(int i) {
        this.indicatorViewController.c(i);
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.e();
    }

    public void setHelperTextEnabled(boolean z) {
        this.indicatorViewController.b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.indicatorViewController.a(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.f();
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.b(colorStateList);
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.m();
    }

    public void setError(CharSequence charSequence) {
        if (!this.indicatorViewController.e()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.indicatorViewController.b(charSequence);
        } else {
            this.indicatorViewController.b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.counterEnabled != z) {
            if (z) {
                this.counterView = new AppCompatTextView(getContext());
                this.counterView.setId(a.f.textinput_counter);
                Typeface typeface2 = this.typeface;
                if (typeface2 != null) {
                    this.counterView.setTypeface(typeface2);
                }
                this.counterView.setMaxLines(1);
                setTextAppearanceCompatWithErrorFallback(this.counterView, this.counterTextAppearance);
                this.indicatorViewController.a(this.counterView, 2);
                EditText editText2 = this.editText;
                if (editText2 == null) {
                    updateCounter(0);
                } else {
                    updateCounter(editText2.getText().length());
                }
            } else {
                this.indicatorViewController.b(this.counterView, 2);
                this.counterView = null;
            }
            this.counterEnabled = z;
        }
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public void setCounterMaxLength(int i) {
        if (this.counterMaxLength != i) {
            if (i > 0) {
                this.counterMaxLength = i;
            } else {
                this.counterMaxLength = -1;
            }
            if (this.counterEnabled) {
                EditText editText2 = this.editText;
                updateCounter(editText2 == null ? 0 : editText2.getText().length());
            }
        }
    }

    public void setEnabled(boolean z) {
        recursiveSetEnabled(this, z);
        super.setEnabled(z);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                recursiveSetEnabled((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        if (!this.counterEnabled || !this.counterOverflowed) {
            return null;
        }
        TextView textView = this.counterView;
        if (textView != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void updateCounter(int i) {
        boolean z = this.counterOverflowed;
        if (this.counterMaxLength == -1) {
            this.counterView.setText(String.valueOf(i));
            this.counterView.setContentDescription((CharSequence) null);
            this.counterOverflowed = false;
        } else {
            if (w.i(this.counterView) == 1) {
                w.f(this.counterView, 0);
            }
            this.counterOverflowed = i > this.counterMaxLength;
            boolean z2 = this.counterOverflowed;
            if (z != z2) {
                setTextAppearanceCompatWithErrorFallback(this.counterView, z2 ? this.counterOverflowTextAppearance : this.counterTextAppearance);
                if (this.counterOverflowed) {
                    w.f(this.counterView, 1);
                }
            }
            this.counterView.setText(getContext().getString(a.i.character_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)}));
            this.counterView.setContentDescription(getContext().getString(a.i.character_counter_content_description, new Object[]{Integer.valueOf(i), Integer.valueOf(this.counterMaxLength)}));
        }
        if (this.editText != null && z != this.counterOverflowed) {
            updateLabelState(false);
            updateTextInputBoxState();
            updateEditTextBackground();
        }
    }

    /* access modifiers changed from: package-private */
    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int i) {
        boolean z = true;
        try {
            i.a(textView, i);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z = false;
            }
        } catch (Exception unused) {
        }
        if (z) {
            i.a(textView, a.j.TextAppearance_AppCompat_Caption);
            textView.setTextColor(b.c(getContext(), a.c.design_error));
        }
    }

    private void updateTextInputBoxBounds() {
        if (this.boxBackgroundMode != 0 && this.boxBackground != null && this.editText != null && getRight() != 0) {
            int left = this.editText.getLeft();
            int calculateBoxBackgroundTop = calculateBoxBackgroundTop();
            int right = this.editText.getRight();
            int bottom = this.editText.getBottom() + this.boxBottomOffsetPx;
            if (this.boxBackgroundMode == 2) {
                int i = this.boxStrokeWidthFocusedPx;
                left += i / 2;
                calculateBoxBackgroundTop -= i / 2;
                right -= i / 2;
                bottom += i / 2;
            }
            this.boxBackground.setBounds(left, calculateBoxBackgroundTop, right, bottom);
            applyBoxAttributes();
            updateEditTextBackgroundBounds();
        }
    }

    private int calculateBoxBackgroundTop() {
        EditText editText2 = this.editText;
        if (editText2 == null) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 1) {
            return editText2.getTop();
        }
        if (i != 2) {
            return 0;
        }
        return editText2.getTop() + calculateLabelMarginTop();
    }

    private int calculateLabelMarginTop() {
        float b2;
        if (!this.hintEnabled) {
            return 0;
        }
        int i = this.boxBackgroundMode;
        if (i == 0 || i == 1) {
            b2 = this.collapsingTextHelper.b();
        } else if (i != 2) {
            return 0;
        } else {
            b2 = this.collapsingTextHelper.b() / 2.0f;
        }
        return (int) b2;
    }

    private int calculateCollapsedTextTopBounds() {
        int i = this.boxBackgroundMode;
        if (i == 1) {
            return getBoxBackground().getBounds().top + this.boxCollapsedPaddingTopPx;
        }
        if (i != 2) {
            return getPaddingTop();
        }
        return getBoxBackground().getBounds().top - calculateLabelMarginTop();
    }

    private void updateEditTextBackgroundBounds() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Drawable background = editText2.getBackground();
            if (background != null) {
                if (z.c(background)) {
                    background = background.mutate();
                }
                d.b(this, this.editText, new Rect());
                Rect bounds = background.getBounds();
                if (bounds.left != bounds.right) {
                    Rect rect = new Rect();
                    background.getPadding(rect);
                    background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.editText.getBottom());
                }
            }
        }
    }

    private void setBoxAttributes() {
        int i = this.boxBackgroundMode;
        if (i == 1) {
            this.boxStrokeWidthPx = 0;
        } else if (i == 2 && this.focusedStrokeColor == 0) {
            this.focusedStrokeColor = this.focusedTextColor.getColorForState(getDrawableState(), this.focusedTextColor.getDefaultColor());
        }
    }

    private void applyBoxAttributes() {
        if (this.boxBackground != null) {
            setBoxAttributes();
            EditText editText2 = this.editText;
            if (editText2 != null && this.boxBackgroundMode == 2) {
                if (editText2.getBackground() != null) {
                    this.editTextOriginalDrawable = this.editText.getBackground();
                }
                w.a((View) this.editText, (Drawable) null);
            }
            EditText editText3 = this.editText;
            if (editText3 != null && this.boxBackgroundMode == 1) {
                Drawable drawable = this.editTextOriginalDrawable;
                if (drawable != null) {
                    w.a((View) editText3, drawable);
                }
            }
            int i = this.boxStrokeWidthPx;
            if (i > -1) {
                int i2 = this.boxStrokeColor;
                if (i2 != 0) {
                    this.boxBackground.setStroke(i, i2);
                }
            }
            this.boxBackground.setCornerRadii(getCornerRadiiAsArray());
            this.boxBackground.setColor(this.boxBackgroundColor);
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void updateEditTextBackground() {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            Drawable background = editText2.getBackground();
            if (background != null) {
                ensureBackgroundDrawableStateWorkaround();
                if (z.c(background)) {
                    background = background.mutate();
                }
                if (this.indicatorViewController.g()) {
                    background.setColorFilter(j.a(this.indicatorViewController.k(), PorterDuff.Mode.SRC_IN));
                    return;
                }
                if (this.counterOverflowed) {
                    TextView textView = this.counterView;
                    if (textView != null) {
                        background.setColorFilter(j.a(textView.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
                        return;
                    }
                }
                androidx.core.graphics.drawable.a.f(background);
                this.editText.refreshDrawableState();
            }
        }
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int i = Build.VERSION.SDK_INT;
        if (i == 21 || i == 22) {
            Drawable background = this.editText.getBackground();
            if (background != null && !this.hasReconstructedEditTextBackground) {
                Drawable newDrawable = background.getConstantState().newDrawable();
                if (background instanceof DrawableContainer) {
                    this.hasReconstructedEditTextBackground = e.a((DrawableContainer) background, newDrawable.getConstantState());
                }
                if (!this.hasReconstructedEditTextBackground) {
                    w.a((View) this.editText, newDrawable);
                    this.hasReconstructedEditTextBackground = true;
                    onApplyBoxBackgroundMode();
                }
            }
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        CharSequence f13521a;

        /* renamed from: b  reason: collision with root package name */
        boolean f13522b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f13521a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f13522b = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f13521a, parcel, i);
            parcel.writeInt(this.f13522b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f13521a + "}";
        }
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.indicatorViewController.g()) {
            savedState.f13521a = getError();
        }
        savedState.f13522b = this.passwordToggledVisible;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f13521a);
        if (savedState.f13522b) {
            passwordVisibilityToggleRequested(true);
        }
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public CharSequence getError() {
        if (this.indicatorViewController.e()) {
            return this.indicatorViewController.i();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.indicatorViewController.f()) {
            return this.indicatorViewController.j();
        }
        return null;
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.hintAnimationEnabled = z;
    }

    public void draw(Canvas canvas) {
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable != null) {
            gradientDrawable.draw(canvas);
        }
        super.draw(canvas);
        if (this.hintEnabled) {
            this.collapsingTextHelper.a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        updatePasswordToggleView();
        super.onMeasure(i, i2);
    }

    private void updatePasswordToggleView() {
        if (this.editText != null) {
            if (shouldShowPasswordIcon()) {
                if (this.passwordToggleView == null) {
                    this.passwordToggleView = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(a.h.design_text_input_password_icon, this.inputFrame, false);
                    this.passwordToggleView.setImageDrawable(this.passwordToggleDrawable);
                    this.passwordToggleView.setContentDescription(this.passwordToggleContentDesc);
                    this.inputFrame.addView(this.passwordToggleView);
                    this.passwordToggleView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            TextInputLayout.this.passwordVisibilityToggleRequested(false);
                        }
                    });
                }
                EditText editText2 = this.editText;
                if (editText2 != null && w.m(editText2) <= 0) {
                    this.editText.setMinimumHeight(w.m(this.passwordToggleView));
                }
                this.passwordToggleView.setVisibility(0);
                this.passwordToggleView.setChecked(this.passwordToggledVisible);
                if (this.passwordToggleDummyDrawable == null) {
                    this.passwordToggleDummyDrawable = new ColorDrawable();
                }
                this.passwordToggleDummyDrawable.setBounds(0, 0, this.passwordToggleView.getMeasuredWidth(), 1);
                Drawable[] b2 = i.b(this.editText);
                if (b2[2] != this.passwordToggleDummyDrawable) {
                    this.originalEditTextEndDrawable = b2[2];
                }
                i.a(this.editText, b2[0], b2[1], this.passwordToggleDummyDrawable, b2[3]);
                this.passwordToggleView.setPadding(this.editText.getPaddingLeft(), this.editText.getPaddingTop(), this.editText.getPaddingRight(), this.editText.getPaddingBottom());
                return;
            }
            CheckableImageButton checkableImageButton = this.passwordToggleView;
            if (checkableImageButton != null && checkableImageButton.getVisibility() == 0) {
                this.passwordToggleView.setVisibility(8);
            }
            if (this.passwordToggleDummyDrawable != null) {
                Drawable[] b3 = i.b(this.editText);
                if (b3[2] == this.passwordToggleDummyDrawable) {
                    i.a(this.editText, b3[0], b3[1], this.originalEditTextEndDrawable, b3[3]);
                    this.passwordToggleDummyDrawable = null;
                }
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? androidx.appcompat.a.a.a.b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.passwordToggleDrawable = drawable;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.passwordToggleEnabled != z) {
            this.passwordToggleEnabled = z;
            if (!z && this.passwordToggledVisible) {
                EditText editText2 = this.editText;
                if (editText2 != null) {
                    editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
            this.passwordToggledVisible = false;
            updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        applyPasswordToggleTint();
    }

    public void passwordVisibilityToggleRequested(boolean z) {
        if (this.passwordToggleEnabled) {
            int selectionEnd = this.editText.getSelectionEnd();
            if (hasPasswordTransformation()) {
                this.editText.setTransformationMethod((TransformationMethod) null);
                this.passwordToggledVisible = true;
            } else {
                this.editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.passwordToggledVisible = false;
            }
            this.passwordToggleView.setChecked(this.passwordToggledVisible);
            if (z) {
                this.passwordToggleView.jumpDrawablesToCurrentState();
            }
            this.editText.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText2 = this.editText;
        if (editText2 != null) {
            w.a((View) editText2, (androidx.core.g.a) aVar);
        }
    }

    private boolean hasPasswordTransformation() {
        EditText editText2 = this.editText;
        return editText2 != null && (editText2.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private boolean shouldShowPasswordIcon() {
        return this.passwordToggleEnabled && (hasPasswordTransformation() || this.passwordToggledVisible);
    }

    private void applyPasswordToggleTint() {
        if (this.passwordToggleDrawable == null) {
            return;
        }
        if (this.hasPasswordToggleTintList || this.hasPasswordToggleTintMode) {
            this.passwordToggleDrawable = androidx.core.graphics.drawable.a.g(this.passwordToggleDrawable).mutate();
            if (this.hasPasswordToggleTintList) {
                androidx.core.graphics.drawable.a.a(this.passwordToggleDrawable, this.passwordToggleTintList);
            }
            if (this.hasPasswordToggleTintMode) {
                androidx.core.graphics.drawable.a.a(this.passwordToggleDrawable, this.passwordToggleTintMode);
            }
            CheckableImageButton checkableImageButton = this.passwordToggleView;
            if (checkableImageButton != null) {
                Drawable drawable = checkableImageButton.getDrawable();
                Drawable drawable2 = this.passwordToggleDrawable;
                if (drawable != drawable2) {
                    this.passwordToggleView.setImageDrawable(drawable2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.boxBackground != null) {
            updateTextInputBoxBounds();
        }
        if (this.hintEnabled) {
            EditText editText2 = this.editText;
            if (editText2 != null) {
                Rect rect = this.tmpRect;
                d.b(this, editText2, rect);
                int compoundPaddingLeft = rect.left + this.editText.getCompoundPaddingLeft();
                int compoundPaddingRight = rect.right - this.editText.getCompoundPaddingRight();
                int calculateCollapsedTextTopBounds = calculateCollapsedTextTopBounds();
                this.collapsingTextHelper.a(compoundPaddingLeft, rect.top + this.editText.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.editText.getCompoundPaddingBottom());
                this.collapsingTextHelper.b(compoundPaddingLeft, calculateCollapsedTextTopBounds, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
                this.collapsingTextHelper.g();
                if (cutoutEnabled() && !this.hintExpanded) {
                    openCutout();
                }
            }
        }
    }

    private void collapseHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.b(1.0f);
        } else {
            animateToExpansionFraction(1.0f);
        }
        this.hintExpanded = false;
        if (cutoutEnabled()) {
            openCutout();
        }
    }

    private boolean cutoutEnabled() {
        return this.hintEnabled && !TextUtils.isEmpty(this.hint) && (this.boxBackground instanceof a);
    }

    private void openCutout() {
        if (cutoutEnabled()) {
            RectF rectF = this.tmpRectF;
            this.collapsingTextHelper.a(rectF);
            applyCutoutPadding(rectF);
            ((a) this.boxBackground).a(rectF);
        }
    }

    private void closeCutout() {
        if (cutoutEnabled()) {
            ((a) this.boxBackground).b();
        }
    }

    private void applyCutoutPadding(RectF rectF) {
        rectF.left -= (float) this.boxLabelCutoutPaddingPx;
        rectF.top -= (float) this.boxLabelCutoutPaddingPx;
        rectF.right += (float) this.boxLabelCutoutPaddingPx;
        rectF.bottom += (float) this.boxLabelCutoutPaddingPx;
    }

    /* access modifiers changed from: package-private */
    public boolean cutoutIsOpen() {
        return cutoutEnabled() && ((a) this.boxBackground).a();
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.inDrawableStateChanged) {
            boolean z = true;
            this.inDrawableStateChanged = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            if (!w.A(this) || !isEnabled()) {
                z = false;
            }
            updateLabelState(z);
            updateEditTextBackground();
            updateTextInputBoxBounds();
            updateTextInputBoxState();
            c cVar = this.collapsingTextHelper;
            if (cVar != null ? cVar.a(drawableState) | false : false) {
                invalidate();
            }
            this.inDrawableStateChanged = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void updateTextInputBoxState() {
        if (this.boxBackground != null && this.boxBackgroundMode != 0) {
            EditText editText2 = this.editText;
            boolean z = true;
            boolean z2 = editText2 != null && editText2.hasFocus();
            EditText editText3 = this.editText;
            if (editText3 == null || !editText3.isHovered()) {
                z = false;
            }
            if (this.boxBackgroundMode == 2) {
                if (!isEnabled()) {
                    this.boxStrokeColor = this.disabledColor;
                } else if (this.indicatorViewController.g()) {
                    this.boxStrokeColor = this.indicatorViewController.k();
                } else {
                    if (this.counterOverflowed) {
                        TextView textView = this.counterView;
                        if (textView != null) {
                            this.boxStrokeColor = textView.getCurrentTextColor();
                        }
                    }
                    if (z2) {
                        this.boxStrokeColor = this.focusedStrokeColor;
                    } else if (z) {
                        this.boxStrokeColor = this.hoveredStrokeColor;
                    } else {
                        this.boxStrokeColor = this.defaultStrokeColor;
                    }
                }
                if ((z || z2) && isEnabled()) {
                    this.boxStrokeWidthPx = this.boxStrokeWidthFocusedPx;
                } else {
                    this.boxStrokeWidthPx = this.boxStrokeWidthDefaultPx;
                }
                applyBoxAttributes();
            }
        }
    }

    private void expandHint(boolean z) {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.animator.cancel();
        }
        if (!z || !this.hintAnimationEnabled) {
            this.collapsingTextHelper.b((float) BitmapDescriptorFactory.HUE_RED);
        } else {
            animateToExpansionFraction(BitmapDescriptorFactory.HUE_RED);
        }
        if (cutoutEnabled() && ((a) this.boxBackground).a()) {
            closeCutout();
        }
        this.hintExpanded = true;
    }

    /* access modifiers changed from: package-private */
    public void animateToExpansionFraction(float f2) {
        if (this.collapsingTextHelper.e() != f2) {
            if (this.animator == null) {
                this.animator = new ValueAnimator();
                this.animator.setInterpolator(com.google.android.material.a.a.f13099b);
                this.animator.setDuration(167);
                this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.collapsingTextHelper.b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.animator.setFloatValues(new float[]{this.collapsingTextHelper.e(), f2});
            this.animator.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.h();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.f();
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.b();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.k();
    }

    public static class a extends androidx.core.g.a {

        /* renamed from: a  reason: collision with root package name */
        private final TextInputLayout f13523a;

        public a(TextInputLayout textInputLayout) {
            this.f13523a = textInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, androidx.core.g.a.d dVar) {
            super.onInitializeAccessibilityNodeInfo(view, dVar);
            EditText editText = this.f13523a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f13523a.getHint();
            CharSequence error = this.f13523a.getError();
            CharSequence counterOverflowDescription = this.f13523a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                dVar.c((CharSequence) text);
            } else if (z2) {
                dVar.c(hint);
            }
            if (z2) {
                dVar.f(hint);
                if (!z && z2) {
                    z4 = true;
                }
                dVar.p(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                dVar.g(error);
                dVar.l(true);
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.f13523a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f13523a.getHint();
            }
            if (!TextUtils.isEmpty(text)) {
                accessibilityEvent.getText().add(text);
            }
        }
    }
}

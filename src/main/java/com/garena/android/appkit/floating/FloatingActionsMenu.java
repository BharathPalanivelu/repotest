package com.garena.android.appkit.floating;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;
import com.garena.android.appkit.c;

public class FloatingActionsMenu extends ViewGroup {
    private static final int ANIMATION_DURATION = 300;
    private static final float COLLAPSED_PLUS_ROTATION = 0.0f;
    private static final float EXPANDED_PLUS_ROTATION = 135.0f;
    public static final int EXPAND_DOWN = 1;
    public static final int EXPAND_LEFT = 2;
    public static final int EXPAND_RIGHT = 3;
    public static final int EXPAND_UP = 0;
    /* access modifiers changed from: private */
    public static Interpolator sAlphaExpandInterpolator = new DecelerateInterpolator();
    /* access modifiers changed from: private */
    public static Interpolator sCollapseInterpolator = new DecelerateInterpolator(3.0f);
    /* access modifiers changed from: private */
    public static Interpolator sExpandInterpolator = new OvershootInterpolator();
    private AddFloatingActionButton mAddButton;
    /* access modifiers changed from: private */
    public int mAddButtonColorNormal;
    /* access modifiers changed from: private */
    public int mAddButtonColorPressed;
    /* access modifiers changed from: private */
    public int mAddButtonPlusColor;
    /* access modifiers changed from: private */
    public boolean mAddButtonStrokeVisible;
    private int mButtonSpacing;
    private int mButtonsCount;
    /* access modifiers changed from: private */
    public AnimatorSet mCollapseAnimation;
    /* access modifiers changed from: private */
    public AnimatorSet mExpandAnimation;
    /* access modifiers changed from: private */
    public int mExpandDirection;
    private boolean mExpanded;
    private int mLabelsMargin;
    private int mLabelsStyle;
    private int mLabelsVerticalOffset;
    private OnFloatingActionsMenuUpdateListener mListener;
    /* access modifiers changed from: private */
    public RotatingDrawable mRotatingDrawable;

    public interface OnFloatingActionsMenuUpdateListener {
        void onMenuCollapsed();

        void onMenuExpanded();
    }

    public FloatingActionsMenu(Context context) {
        this(context, (AttributeSet) null);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mExpandAnimation = new AnimatorSet().setDuration(300);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300);
        init(context, attributeSet);
    }

    public FloatingActionsMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mExpandAnimation = new AnimatorSet().setDuration(300);
        this.mCollapseAnimation = new AnimatorSet().setDuration(300);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mButtonSpacing = (int) ((getResources().getDimension(c.d.fab_actions_spacing) - getResources().getDimension(c.d.fab_shadow_radius)) - getResources().getDimension(c.d.fab_shadow_offset));
        this.mLabelsMargin = getResources().getDimensionPixelSize(c.d.fab_labels_margin);
        this.mLabelsVerticalOffset = getResources().getDimensionPixelSize(c.d.fab_shadow_offset);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.j.FloatingActionsMenu, 0, 0);
        this.mAddButtonPlusColor = obtainStyledAttributes.getColor(c.j.FloatingActionsMenu_fab_addButtonPlusIconColor, getColor(17170443));
        this.mAddButtonColorNormal = obtainStyledAttributes.getColor(c.j.FloatingActionsMenu_fab_addButtonColorNormal, getColor(17170451));
        this.mAddButtonColorPressed = obtainStyledAttributes.getColor(c.j.FloatingActionsMenu_fab_addButtonColorPressed, getColor(17170450));
        this.mAddButtonStrokeVisible = obtainStyledAttributes.getBoolean(c.j.FloatingActionsMenu_fab_addButtonStrokeVisible, true);
        this.mExpandDirection = obtainStyledAttributes.getInt(c.j.FloatingActionsMenu_fab_expandDirection, 0);
        this.mLabelsStyle = obtainStyledAttributes.getResourceId(c.j.FloatingActionsMenu_fab_labelStyle, 0);
        obtainStyledAttributes.recycle();
        if (this.mLabelsStyle == 0 || !expandsHorizontally()) {
            createAddButton(context);
            return;
        }
        throw new IllegalStateException("Action labels in horizontal expand orientation is not supported.");
    }

    public void setOnFloatingActionsMenuUpdateListener(OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener) {
        this.mListener = onFloatingActionsMenuUpdateListener;
    }

    private boolean expandsHorizontally() {
        int i = this.mExpandDirection;
        return i == 2 || i == 3;
    }

    private static class RotatingDrawable extends LayerDrawable {
        private float mRotation;

        public RotatingDrawable(Drawable drawable) {
            super(new Drawable[]{drawable});
        }

        public float getRotation() {
            return this.mRotation;
        }

        public void setRotation(float f2) {
            this.mRotation = f2;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            canvas.save();
            canvas.rotate(this.mRotation, (float) getBounds().centerX(), (float) getBounds().centerY());
            super.draw(canvas);
            canvas.restore();
        }
    }

    private void createAddButton(Context context) {
        this.mAddButton = new AddFloatingActionButton(context) {
            /* access modifiers changed from: package-private */
            public void updateBackground() {
                this.mPlusColor = FloatingActionsMenu.this.mAddButtonPlusColor;
                this.mColorNormal = FloatingActionsMenu.this.mAddButtonColorNormal;
                this.mColorPressed = FloatingActionsMenu.this.mAddButtonColorPressed;
                this.mStrokeVisible = FloatingActionsMenu.this.mAddButtonStrokeVisible;
                super.updateBackground();
            }

            /* access modifiers changed from: package-private */
            public Drawable getIconDrawable() {
                RotatingDrawable rotatingDrawable = new RotatingDrawable(super.getIconDrawable());
                RotatingDrawable unused = FloatingActionsMenu.this.mRotatingDrawable = rotatingDrawable;
                OvershootInterpolator overshootInterpolator = new OvershootInterpolator();
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[]{FloatingActionsMenu.EXPANDED_PLUS_ROTATION, 0.0f});
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(rotatingDrawable, "rotation", new float[]{0.0f, FloatingActionsMenu.EXPANDED_PLUS_ROTATION});
                ofFloat.setInterpolator(overshootInterpolator);
                ofFloat2.setInterpolator(overshootInterpolator);
                FloatingActionsMenu.this.mExpandAnimation.play(ofFloat2);
                FloatingActionsMenu.this.mCollapseAnimation.play(ofFloat);
                return rotatingDrawable;
            }
        };
        this.mAddButton.setId(c.f.fab_expand_menu_button);
        this.mAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FloatingActionsMenu.this.toggle();
            }
        });
        addView(this.mAddButton, super.generateDefaultLayoutParams());
    }

    public void addButton(FloatingActionButton floatingActionButton) {
        addView(floatingActionButton, this.mButtonsCount - 1);
        this.mButtonsCount++;
        if (this.mLabelsStyle != 0) {
            createLabels();
        }
    }

    private int getColor(int i) {
        return getResources().getColor(i);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        measureChildren(i, i2);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < this.mButtonsCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                int i7 = this.mExpandDirection;
                if (i7 == 0 || i7 == 1) {
                    i3 = Math.max(i3, childAt.getMeasuredWidth());
                    i5 += childAt.getMeasuredHeight();
                } else if (i7 == 2 || i7 == 3) {
                    i3 += childAt.getMeasuredWidth();
                    i5 = Math.max(i5, childAt.getMeasuredHeight());
                }
                if (!expandsHorizontally()) {
                    TextView textView = (TextView) childAt.getTag(c.f.fab_label);
                    if (textView != null) {
                        i4 = Math.max(i4, textView.getMeasuredWidth());
                    }
                }
            }
        }
        if (!expandsHorizontally()) {
            i3 += i4 + this.mLabelsMargin;
        }
        int i8 = this.mExpandDirection;
        if (i8 == 0 || i8 == 1) {
            i5 = adjustForOvershoot(i5 + (this.mButtonSpacing * (getChildCount() - 1)));
        } else if (i8 == 2 || i8 == 3) {
            i3 = adjustForOvershoot(i3 + (this.mButtonSpacing * (getChildCount() - 1)));
        }
        setMeasuredDimension(i3, i5);
    }

    private int adjustForOvershoot(int i) {
        return (i * 12) / 10;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = this.mExpandDirection;
        int i10 = 8;
        char c2 = 1;
        if (i9 == 0 || i9 == 1) {
            boolean z2 = this.mExpandDirection == 0;
            int measuredHeight = z2 ? (i4 - i2) - this.mAddButton.getMeasuredHeight() : 0;
            if (isRTL()) {
                i5 = 0;
            } else {
                i5 = (i3 - i) - this.mAddButton.getMeasuredWidth();
            }
            AddFloatingActionButton addFloatingActionButton = this.mAddButton;
            addFloatingActionButton.layout(i5, measuredHeight, addFloatingActionButton.getMeasuredWidth() + i5, this.mAddButton.getMeasuredHeight() + measuredHeight);
            int i11 = this.mLabelsMargin;
            int measuredWidth = this.mAddButton.getMeasuredWidth() + i5 + i11;
            int i12 = i5 - i11;
            if (z2) {
                i6 = measuredHeight - this.mButtonSpacing;
            } else {
                i6 = this.mAddButton.getMeasuredHeight() + measuredHeight + this.mButtonSpacing;
            }
            int i13 = this.mButtonsCount - 1;
            while (i13 >= 0) {
                View childAt = getChildAt(i13);
                if (childAt == this.mAddButton || childAt.getVisibility() == i10) {
                    i7 = measuredHeight;
                } else {
                    int measuredWidth2 = ((this.mAddButton.getMeasuredWidth() - childAt.getMeasuredWidth()) / 2) + i5;
                    if (z2) {
                        i6 -= childAt.getMeasuredHeight();
                    }
                    childAt.layout(measuredWidth2, i6, measuredWidth2 + childAt.getMeasuredWidth(), i6 + childAt.getMeasuredHeight());
                    float f2 = (float) (measuredHeight - i6);
                    childAt.setTranslationY(this.mExpanded ? 0.0f : f2);
                    childAt.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    ObjectAnimator access$700 = layoutParams.mCollapseDir;
                    i7 = measuredHeight;
                    float[] fArr = new float[2];
                    fArr[0] = 0.0f;
                    fArr[c2] = f2;
                    access$700.setFloatValues(fArr);
                    ObjectAnimator access$800 = layoutParams.mExpandDir;
                    float[] fArr2 = new float[2];
                    fArr2[0] = f2;
                    fArr2[c2] = 0.0f;
                    access$800.setFloatValues(fArr2);
                    layoutParams.setAnimationsTarget(childAt);
                    View view = (View) childAt.getTag(c.f.fab_label);
                    if (view != null) {
                        int measuredWidth3 = i12 - view.getMeasuredWidth();
                        int measuredWidth4 = view.getMeasuredWidth() + measuredWidth;
                        int measuredHeight2 = (i6 - this.mLabelsVerticalOffset) + ((childAt.getMeasuredHeight() - view.getMeasuredHeight()) / 2);
                        if (isRTL()) {
                            view.layout(measuredWidth, measuredHeight2, measuredWidth4, view.getMeasuredHeight() + measuredHeight2);
                        } else {
                            view.layout(measuredWidth3, measuredHeight2, i12, view.getMeasuredHeight() + measuredHeight2);
                        }
                        view.setTranslationY(this.mExpanded ? 0.0f : f2);
                        view.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                        layoutParams2.mCollapseDir.setFloatValues(new float[]{0.0f, f2});
                        layoutParams2.mExpandDir.setFloatValues(new float[]{f2, 0.0f});
                        layoutParams2.setAnimationsTarget(view);
                    }
                    if (z2) {
                        i6 -= this.mButtonSpacing;
                    } else {
                        i6 = i6 + childAt.getMeasuredHeight() + this.mButtonSpacing;
                    }
                }
                i13--;
                measuredHeight = i7;
                i10 = 8;
                c2 = 1;
            }
        } else if (i9 == 2 || i9 == 3) {
            boolean z3 = this.mExpandDirection == 2;
            int measuredWidth5 = z3 ? (i3 - i) - this.mAddButton.getMeasuredWidth() : 0;
            AddFloatingActionButton addFloatingActionButton2 = this.mAddButton;
            addFloatingActionButton2.layout(measuredWidth5, 0, addFloatingActionButton2.getMeasuredWidth() + measuredWidth5, this.mAddButton.getMeasuredHeight());
            if (z3) {
                i8 = measuredWidth5 - this.mButtonSpacing;
            } else {
                i8 = this.mAddButton.getMeasuredWidth() + measuredWidth5 + this.mButtonSpacing;
            }
            for (int i14 = this.mButtonsCount - 1; i14 >= 0; i14--) {
                View childAt2 = getChildAt(i14);
                if (!(childAt2 == this.mAddButton || childAt2.getVisibility() == 8)) {
                    if (z3) {
                        i8 -= childAt2.getMeasuredWidth();
                    }
                    int measuredHeight3 = (this.mAddButton.getMeasuredHeight() - childAt2.getMeasuredHeight()) / 2;
                    childAt2.layout(i8, measuredHeight3, childAt2.getMeasuredWidth() + i8, childAt2.getMeasuredHeight() + measuredHeight3);
                    float f3 = (float) (measuredWidth5 - i8);
                    childAt2.setTranslationX(this.mExpanded ? 0.0f : f3);
                    childAt2.setAlpha(this.mExpanded ? 1.0f : 0.0f);
                    LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
                    layoutParams3.mCollapseDir.setFloatValues(new float[]{0.0f, f3});
                    layoutParams3.mExpandDir.setFloatValues(new float[]{f3, 0.0f});
                    layoutParams3.setAnimationsTarget(childAt2);
                    if (z3) {
                        i8 -= this.mButtonSpacing;
                    } else {
                        i8 = i8 + childAt2.getMeasuredWidth() + this.mButtonSpacing;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(super.generateDefaultLayoutParams());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(super.generateLayoutParams(attributeSet));
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(super.generateLayoutParams(layoutParams));
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams);
    }

    private class LayoutParams extends ViewGroup.LayoutParams {
        private ObjectAnimator mCollapseAlpha = new ObjectAnimator();
        /* access modifiers changed from: private */
        public ObjectAnimator mCollapseDir = new ObjectAnimator();
        private ObjectAnimator mExpandAlpha = new ObjectAnimator();
        /* access modifiers changed from: private */
        public ObjectAnimator mExpandDir = new ObjectAnimator();

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mExpandDir.setInterpolator(FloatingActionsMenu.sExpandInterpolator);
            this.mExpandAlpha.setInterpolator(FloatingActionsMenu.sAlphaExpandInterpolator);
            this.mCollapseDir.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setInterpolator(FloatingActionsMenu.sCollapseInterpolator);
            this.mCollapseAlpha.setProperty(View.ALPHA);
            this.mCollapseAlpha.setFloatValues(new float[]{1.0f, 0.0f});
            this.mExpandAlpha.setProperty(View.ALPHA);
            this.mExpandAlpha.setFloatValues(new float[]{0.0f, 1.0f});
            int access$1200 = FloatingActionsMenu.this.mExpandDirection;
            if (access$1200 == 0 || access$1200 == 1) {
                this.mCollapseDir.setProperty(View.TRANSLATION_Y);
                this.mExpandDir.setProperty(View.TRANSLATION_Y);
            } else if (access$1200 == 2 || access$1200 == 3) {
                this.mCollapseDir.setProperty(View.TRANSLATION_X);
                this.mExpandDir.setProperty(View.TRANSLATION_X);
            }
            FloatingActionsMenu.this.mExpandAnimation.play(this.mExpandAlpha);
            FloatingActionsMenu.this.mExpandAnimation.play(this.mExpandDir);
            FloatingActionsMenu.this.mCollapseAnimation.play(this.mCollapseAlpha);
            FloatingActionsMenu.this.mCollapseAnimation.play(this.mCollapseDir);
        }

        public void setAnimationsTarget(View view) {
            this.mCollapseAlpha.setTarget(view);
            this.mCollapseDir.setTarget(view);
            this.mExpandAlpha.setTarget(view);
            this.mExpandDir.setTarget(view);
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        bringChildToFront(this.mAddButton);
        this.mButtonsCount = getChildCount();
        if (this.mLabelsStyle != 0) {
            createLabels();
        }
    }

    private void createLabels() {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.mLabelsStyle);
        for (int i = 0; i < this.mButtonsCount; i++) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) getChildAt(i);
            String title = floatingActionButton.getTitle();
            if (!(floatingActionButton == this.mAddButton || title == null || floatingActionButton.getTag(c.f.fab_label) != null)) {
                TextView textView = new TextView(contextThemeWrapper);
                textView.setText(floatingActionButton.getTitle());
                addView(textView);
                floatingActionButton.setTag(c.f.fab_label, textView);
            }
        }
    }

    public void collapse() {
        if (this.mExpanded) {
            this.mExpanded = false;
            this.mCollapseAnimation.start();
            this.mExpandAnimation.cancel();
            OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener = this.mListener;
            if (onFloatingActionsMenuUpdateListener != null) {
                onFloatingActionsMenuUpdateListener.onMenuCollapsed();
            }
        }
    }

    public void toggle() {
        if (this.mExpanded) {
            collapse();
        } else {
            expand();
        }
    }

    public void expand() {
        if (!this.mExpanded) {
            this.mExpanded = true;
            this.mCollapseAnimation.cancel();
            this.mExpandAnimation.start();
            OnFloatingActionsMenuUpdateListener onFloatingActionsMenuUpdateListener = this.mListener;
            if (onFloatingActionsMenuUpdateListener != null) {
                onFloatingActionsMenuUpdateListener.onMenuExpanded();
            }
        }
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.mExpanded = this.mExpanded;
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            this.mExpanded = savedState.mExpanded;
            RotatingDrawable rotatingDrawable = this.mRotatingDrawable;
            if (rotatingDrawable != null) {
                rotatingDrawable.setRotation(this.mExpanded ? EXPANDED_PLUS_ROTATION : 0.0f);
            }
            super.onRestoreInstanceState(savedState.getSuperState());
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        public boolean mExpanded;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.mExpanded = parcel.readInt() != 1 ? false : true;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mExpanded ? 1 : 0);
        }
    }

    public boolean isRTL() {
        return getContext().getResources().getBoolean(c.b.isRightToLeft);
    }
}

package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.a;
import androidx.core.g.u;
import androidx.core.widget.b;
import androidx.core.widget.i;

public class f extends Button implements u, b {
    private final e mBackgroundTintHelper;
    private final u mTextHelper;

    public f(Context context) {
        this(context, (AttributeSet) null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.buttonStyle);
    }

    public f(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new u(this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.b();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.mBackgroundTintHelper;
        if (eVar != null) {
            eVar.c();
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.b();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(z, i, i2, i3, i4);
        }
    }

    public void setTextSize(int i, float f2) {
        if (f1909d) {
            super.setTextSize(i, f2);
            return;
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(i, f2);
        }
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.mTextHelper != null && !f1909d && this.mTextHelper.d()) {
            this.mTextHelper.c();
        }
    }

    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (f1909d) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(i);
        }
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws IllegalArgumentException {
        if (f1909d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(i, i2, i3, i4);
        }
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) throws IllegalArgumentException {
        if (f1909d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(iArr, i);
        }
    }

    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (!f1909d) {
            u uVar = this.mTextHelper;
            if (uVar != null) {
                return uVar.e();
            }
            return 0;
        } else if (super.getAutoSizeTextType() == 1) {
            return 1;
        } else {
            return 0;
        }
    }

    public int getAutoSizeStepGranularity() {
        if (f1909d) {
            return super.getAutoSizeStepGranularity();
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            return uVar.f();
        }
        return -1;
    }

    public int getAutoSizeMinTextSize() {
        if (f1909d) {
            return super.getAutoSizeMinTextSize();
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            return uVar.g();
        }
        return -1;
    }

    public int getAutoSizeMaxTextSize() {
        if (f1909d) {
            return super.getAutoSizeMaxTextSize();
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            return uVar.h();
        }
        return -1;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        if (f1909d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        u uVar = this.mTextHelper;
        if (uVar != null) {
            return uVar.i();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(z);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }
}

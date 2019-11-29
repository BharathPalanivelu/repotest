package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.appcompat.a.a.a;
import androidx.core.f.b;
import androidx.core.g.u;
import androidx.core.graphics.d;
import androidx.core.widget.b;
import androidx.core.widget.i;
import androidx.core.widget.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AppCompatTextView extends TextView implements u, b, k {
    private final e mBackgroundTintHelper;
    private Future<androidx.core.f.b> mPrecomputedTextFuture;
    private final t mTextClassifierHelper;
    private final u mTextHelper;

    public AppCompatTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.mBackgroundTintHelper = new e(this);
        this.mBackgroundTintHelper.a(attributeSet, i);
        this.mTextHelper = new u(this);
        this.mTextHelper.a(attributeSet, i);
        this.mTextHelper.b();
        this.mTextClassifierHelper = new t(this);
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

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a(context, i);
        }
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

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            i.b(this, i);
        }
    }

    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            i.c(this, i);
        }
    }

    public int getFirstBaselineToTopHeight() {
        return i.c(this);
    }

    public int getLastBaselineToBottomHeight() {
        return i.d(this);
    }

    public void setLineHeight(int i) {
        i.d(this, i);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(i.a((TextView) this, callback));
    }

    public b.a getTextMetricsParamsCompat() {
        return i.e(this);
    }

    public void setTextMetricsParamsCompat(b.a aVar) {
        i.a((TextView) this, aVar);
    }

    public void setPrecomputedText(androidx.core.f.b bVar) {
        i.a((TextView) this, bVar);
    }

    private void consumeTextFutureAndSetBlocking() {
        Future<androidx.core.f.b> future = this.mPrecomputedTextFuture;
        if (future != null) {
            try {
                this.mPrecomputedTextFuture = null;
                i.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    public CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        if (Build.VERSION.SDK_INT < 28) {
            t tVar = this.mTextClassifierHelper;
            if (tVar != null) {
                tVar.a(textClassifier);
                return;
            }
        }
        super.setTextClassifier(textClassifier);
    }

    public TextClassifier getTextClassifier() {
        if (Build.VERSION.SDK_INT < 28) {
            t tVar = this.mTextClassifierHelper;
            if (tVar != null) {
                return tVar.a();
            }
        }
        return super.getTextClassifier();
    }

    public void setTextFuture(Future<androidx.core.f.b> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
    }

    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(b2, b3, b4, drawable);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        Drawable drawable = null;
        Drawable b2 = i != 0 ? a.b(context, i) : null;
        Drawable b3 = i2 != 0 ? a.b(context, i2) : null;
        Drawable b4 = i3 != 0 ? a.b(context, i3) : null;
        if (i4 != 0) {
            drawable = a.b(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(b2, b3, b4, drawable);
        u uVar = this.mTextHelper;
        if (uVar != null) {
            uVar.a();
        }
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.a(colorStateList);
        this.mTextHelper.b();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.mTextHelper.a(mode);
        this.mTextHelper.b();
    }

    public void setTypeface(Typeface typeface, int i) {
        Typeface a2 = (typeface == null || i <= 0) ? null : d.a(getContext(), typeface, i);
        if (a2 != null) {
            typeface = a2;
        }
        super.setTypeface(typeface, i);
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import androidx.appcompat.a;
import androidx.core.g.u;

public class n extends MultiAutoCompleteTextView implements u {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f1227a = {16843126};

    /* renamed from: b  reason: collision with root package name */
    private final e f1228b;

    /* renamed from: c  reason: collision with root package name */
    private final u f1229c;

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.autoCompleteTextViewStyle);
    }

    public n(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        ar a2 = ar.a(getContext(), attributeSet, f1227a, i, 0);
        if (a2.g(0)) {
            setDropDownBackgroundDrawable(a2.a(0));
        }
        a2.a();
        this.f1228b = new e(this);
        this.f1228b.a(attributeSet, i);
        this.f1229c = new u(this);
        this.f1229c.a(attributeSet, i);
        this.f1229c.b();
    }

    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f1228b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1228b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1228b;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1228b;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1228b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1228b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1228b;
        if (eVar != null) {
            eVar.c();
        }
        u uVar = this.f1229c;
        if (uVar != null) {
            uVar.b();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        u uVar = this.f1229c;
        if (uVar != null) {
            uVar.a(context, i);
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return l.a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}

package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.a;
import androidx.core.g.u;
import androidx.core.widget.j;

public class q extends RadioButton implements u, j {

    /* renamed from: a  reason: collision with root package name */
    private final i f1235a;

    /* renamed from: b  reason: collision with root package name */
    private final e f1236b;

    /* renamed from: c  reason: collision with root package name */
    private final u f1237c;

    public q(Context context) {
        this(context, (AttributeSet) null);
    }

    public q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.radioButtonStyle);
    }

    public q(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.f1235a = new i(this);
        this.f1235a.a(attributeSet, i);
        this.f1236b = new e(this);
        this.f1236b.a(attributeSet, i);
        this.f1237c = new u(this);
        this.f1237c.a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        i iVar = this.f1235a;
        if (iVar != null) {
            iVar.c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(androidx.appcompat.a.a.a.b(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        i iVar = this.f1235a;
        return iVar != null ? iVar.a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        i iVar = this.f1235a;
        if (iVar != null) {
            iVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        i iVar = this.f1235a;
        if (iVar != null) {
            return iVar.a();
        }
        return null;
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        i iVar = this.f1235a;
        if (iVar != null) {
            iVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        i iVar = this.f1235a;
        if (iVar != null) {
            return iVar.b();
        }
        return null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f1236b;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f1236b;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f1236b;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f1236b;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f1236b;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f1236b;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f1236b;
        if (eVar != null) {
            eVar.c();
        }
        u uVar = this.f1237c;
        if (uVar != null) {
            uVar.b();
        }
    }
}

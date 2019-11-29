package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.appcompat.a;
import androidx.core.g.u;
import androidx.core.widget.l;

public class AppCompatImageButton extends ImageButton implements u, l {

    /* renamed from: a  reason: collision with root package name */
    private final e f963a;

    /* renamed from: b  reason: collision with root package name */
    private final m f964b;

    public AppCompatImageButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0012a.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(ao.a(context), attributeSet, i);
        this.f963a = new e(this);
        this.f963a.a(attributeSet, i);
        this.f964b = new m(this);
        this.f964b.a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f964b.a(i);
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.d();
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        e eVar = this.f963a;
        if (eVar != null) {
            eVar.a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        e eVar = this.f963a;
        if (eVar != null) {
            eVar.a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        e eVar = this.f963a;
        if (eVar != null) {
            eVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        e eVar = this.f963a;
        if (eVar != null) {
            return eVar.a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        e eVar = this.f963a;
        if (eVar != null) {
            eVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        e eVar = this.f963a;
        if (eVar != null) {
            return eVar.b();
        }
        return null;
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.a(colorStateList);
        }
    }

    public ColorStateList getSupportImageTintList() {
        m mVar = this.f964b;
        if (mVar != null) {
            return mVar.b();
        }
        return null;
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.a(mode);
        }
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        m mVar = this.f964b;
        if (mVar != null) {
            return mVar.c();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        e eVar = this.f963a;
        if (eVar != null) {
            eVar.c();
        }
        m mVar = this.f964b;
        if (mVar != null) {
            mVar.d();
        }
    }

    public boolean hasOverlappingRendering() {
        return this.f964b.a() && super.hasOverlappingRendering();
    }
}

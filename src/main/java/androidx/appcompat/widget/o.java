package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.a;
import androidx.core.widget.h;

class o extends PopupWindow {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f1230a = (Build.VERSION.SDK_INT < 21);

    /* renamed from: b  reason: collision with root package name */
    private boolean f1231b;

    public o(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        ar a2 = ar.a(context, attributeSet, a.j.PopupWindow, i, i2);
        if (a2.g(a.j.PopupWindow_overlapAnchor)) {
            a(a2.a(a.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.a(a.j.PopupWindow_android_popupBackground));
        a2.a();
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        if (f1230a && this.f1231b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    private void a(boolean z) {
        if (f1230a) {
            this.f1231b = z;
        } else {
            h.a((PopupWindow) this, z);
        }
    }
}

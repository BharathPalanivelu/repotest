package com.shopee.app.ui.image.bound;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.garena.android.appkit.d.a;
import com.garena.android.appkit.tools.b;
import com.shopee.app.ui.image.editor.d.d;
import com.shopee.id.R;
import d.m;

public class j extends ConstraintLayout {

    /* renamed from: g  reason: collision with root package name */
    public View f22788g;
    public View h;
    public View i;

    public j(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        d.d.b.j.b(context, "context");
    }

    public View getCroppingView() {
        View view = this.f22788g;
        if (view == null) {
            d.d.b.j.b("croppingView");
        }
        return view;
    }

    public void setCroppingView(View view) {
        d.d.b.j.b(view, "<set-?>");
        this.f22788g = view;
    }

    public View getTopBar() {
        View view = this.h;
        if (view == null) {
            d.d.b.j.b("topBar");
        }
        return view;
    }

    public void setTopBar(View view) {
        d.d.b.j.b(view, "<set-?>");
        this.h = view;
    }

    public View getBottomBar() {
        View view = this.i;
        if (view == null) {
            d.d.b.j.b("bottomBar");
        }
        return view;
    }

    public void setBottomBar(View view) {
        d.d.b.j.b(view, "<set-?>");
        this.i = view;
    }

    public void a(float f2, int i2) {
        if (f2 > ((float) 0)) {
            int a2 = d.a(i2, getContext());
            try {
                ViewGroup.LayoutParams layoutParams = getCroppingView().getLayoutParams();
                if (layoutParams != null) {
                    ConstraintLayout.a aVar = (ConstraintLayout.a) layoutParams;
                    ViewGroup.LayoutParams layoutParams2 = getTopBar().getLayoutParams();
                    if (layoutParams2 != null) {
                        ConstraintLayout.a aVar2 = (ConstraintLayout.a) layoutParams2;
                        ViewGroup.LayoutParams layoutParams3 = getBottomBar().getLayoutParams();
                        if (layoutParams3 != null) {
                            ConstraintLayout.a aVar3 = (ConstraintLayout.a) layoutParams3;
                            int d2 = b.d(R.dimen.dp5);
                            if (a2 > 0) {
                                int i3 = a2 + d2;
                                aVar.setMargins(i3, 0, i3, 0);
                                aVar2.setMargins(a2, 0, a2, 0);
                                aVar3.setMargins(a2, 0, a2, 0);
                            }
                            aVar.height = Math.min((int) (((float) ((b.b() - (a2 * 2)) - (d2 * 2))) / f2), b.d() - (b.d(R.dimen.dp10) * 2));
                            return;
                        }
                        throw new m("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    throw new m("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                }
                throw new m("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            } catch (Exception e2) {
                a.a(e2);
            }
        }
    }

    public Rect getBoundRect() {
        int[] iArr = new int[2];
        getCroppingView().getLocationOnScreen(iArr);
        return new Rect(iArr[0], iArr[1], iArr[0] + getCroppingView().getWidth(), iArr[1] + getCroppingView().getHeight());
    }
}

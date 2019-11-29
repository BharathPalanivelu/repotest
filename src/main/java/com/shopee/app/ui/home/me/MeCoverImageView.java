package com.shopee.app.ui.home.me;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.garena.android.appkit.tools.b;
import com.shopee.app.util.o.d;
import com.shopee.app.util.z;
import com.shopee.id.R;
import d.d.b.j;
import d.h.m;

public final class MeCoverImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f22281a;

    /* renamed from: b  reason: collision with root package name */
    private String f22282b;

    public MeCoverImageView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public MeCoverImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MeCoverImageView(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public MeCoverImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setScaleType(ImageView.ScaleType.CENTER_CROP);
        setImageResource(R.drawable.action_bar_bg);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            int size = View.MeasureSpec.getSize(i);
            setMeasuredDimension(size, (((int) (((float) size) * 0.328f)) - this.f22281a) + d.a().a(getContext()));
            return;
        }
        super.onMeasure(i, i2);
    }

    public final void a() {
        setImageDrawable(new ColorDrawable(-1));
        this.f22281a = b.d(R.dimen.action_bar_height);
        requestLayout();
    }

    public static /* synthetic */ void a(MeCoverImageView meCoverImageView, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        meCoverImageView.a(str, z, z2);
    }

    public final void a(String str, boolean z, boolean z2) {
        if (!j.a((Object) this.f22282b, (Object) str)) {
            this.f22282b = str;
            CharSequence charSequence = str;
            if (charSequence == null || m.a(charSequence)) {
                setScaleType(ImageView.ScaleType.CENTER_CROP);
                setImageResource(R.drawable.action_bar_bg);
                return;
            }
            z.b a2 = z.c(getContext()).a(str);
            if (z) {
                a2.a(b.a(R.color.black40));
            }
            a2.a(z2).a((ImageView) this);
        }
    }
}

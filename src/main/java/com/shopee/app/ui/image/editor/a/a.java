package com.shopee.app.ui.image.editor.a;

import android.content.Context;
import android.view.View;
import com.garena.imageeditor.a.d;
import com.shopee.app.ui.image.editor.b;
import com.shopee.app.ui.image.editor.c.a.b;
import com.shopee.app.ui.image.editor.c.b.c;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class a implements b.C0357b<com.shopee.app.ui.image.editor.c.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private List<com.shopee.app.ui.image.editor.c.a.b> f22867a = new ArrayList();

    public a() {
        this.f22867a.add(new b.a().a((int) R.drawable.ic_crop).a(d.CROP).a("Crop").a(false).a());
        this.f22867a.add(new b.a().a((int) R.drawable.ic_brightness).a(d.BRIGHTNESS).a("Brightness").a(true).a());
        this.f22867a.add(new b.a().a((int) R.drawable.ic_contrast).a(d.CONTRAST).a("Contrast").a(true).a());
        this.f22867a.add(new b.a().a((int) R.drawable.ic_saturation).a(d.SATURATION).a("Saturation").a(true).a());
        this.f22867a.add(new b.a().a((int) R.drawable.ic_blur).a(d.FOCUS_BLUR).a("Blur").a(false).a());
        this.f22867a.add(new b.a().a((int) R.drawable.ic_rotate).a(false).a("Rotation").b(true).a());
    }

    public int a() {
        return this.f22867a.size();
    }

    public View a(int i, Context context) {
        c a2 = com.shopee.app.ui.image.editor.c.b.d.a(context);
        a2.setData(a(i, a2));
        return a2;
    }

    /* renamed from: b */
    public com.shopee.app.ui.image.editor.c.a.b a(int i, View view) {
        return this.f22867a.get(i);
    }
}

package com.shopee.app.ui.image.editor.a;

import android.content.Context;
import android.view.View;
import com.garena.imageeditor.a.d;
import com.shopee.app.ui.image.editor.c.a.a;
import com.shopee.app.ui.image.editor.c.a.b;
import com.shopee.app.ui.image.editor.c.b.c;
import com.shopee.app.ui.image.editor.i;
import com.shopee.id.R;
import java.util.ArrayList;
import java.util.List;

public class b implements i.b<com.shopee.app.ui.image.editor.c.a.b> {

    /* renamed from: a  reason: collision with root package name */
    private List<com.shopee.app.ui.image.editor.c.a.b> f22869a = new ArrayList();

    public b() {
        this.f22869a.add(new b.a().a((int) R.drawable.ic_rotate_left).a(d.ROTATE).a((Object) new a.C0358a().d(true).a()).a());
        this.f22869a.add(new b.a().a((int) R.drawable.ic_rotate_right).a(d.ROTATE).a((Object) new a.C0358a().c(true).a()).a());
        this.f22869a.add(new b.a().a((int) R.drawable.ic_flip_h).a(d.ROTATE).a((Object) new a.C0358a().b(true).a()).a());
        this.f22869a.add(new b.a().a((int) R.drawable.ic_flip_v).a(d.ROTATE).a((Object) new a.C0358a().a(true).a()).a());
    }

    public int a() {
        return this.f22869a.size();
    }

    public View a(int i, Context context) {
        c a2 = com.shopee.app.ui.image.editor.c.b.d.a(context);
        a2.setData(a(i, a2));
        return a2;
    }

    /* renamed from: b */
    public com.shopee.app.ui.image.editor.c.a.b a(int i, View view) {
        return this.f22869a.get(i);
    }
}

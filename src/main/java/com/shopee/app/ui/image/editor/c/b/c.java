package com.shopee.app.ui.image.editor.c.b;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.app.ui.image.editor.c.a.b;

public class c extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    ImageView f22908a;

    /* renamed from: b  reason: collision with root package name */
    TextView f22909b;

    /* renamed from: c  reason: collision with root package name */
    private b f22910c;

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public c(Context context) {
        super(context);
    }

    public void setData(b bVar) {
        this.f22910c = bVar;
        this.f22908a.setImageResource(this.f22910c.a());
    }

    public b getData() {
        return this.f22910c;
    }
}

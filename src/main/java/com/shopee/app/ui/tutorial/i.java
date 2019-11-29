package com.shopee.app.ui.tutorial;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f25718c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f25719d = new c();

    public i(Context context) {
        super(context);
        d();
    }

    public static h a(Context context) {
        i iVar = new i(context);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.f25718c) {
            this.f25718c = true;
            inflate(getContext(), R.layout.tutorial_item_layout, this);
            this.f25719d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.f25719d);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25716a = (ImageView) aVar.internalFindViewById(R.id.image);
        this.f25717b = (Button) aVar.internalFindViewById(R.id.btn);
        if (this.f25717b != null) {
            this.f25717b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.c();
                }
            });
        }
        a();
    }
}

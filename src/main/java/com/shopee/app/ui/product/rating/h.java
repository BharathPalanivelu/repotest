package com.shopee.app.ui.product.rating;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class h extends g implements a, b {
    private boolean i = false;
    private final c j = new c();

    public h(Context context, int i2, long j2, int i3, boolean z, int i4, int i5, String str) {
        super(context, i2, j2, i3, z, i4, i5, str);
        h();
    }

    public static g a(Context context, int i2, long j2, int i3, boolean z, int i4, int i5, String str) {
        h hVar = new h(context, i2, j2, i3, z, i4, i5, str);
        hVar.onFinishInflate();
        return hVar;
    }

    public void onFinishInflate() {
        if (!this.i) {
            this.i = true;
            inflate(getContext(), R.layout.rating_full_image_layout, this);
            this.j.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.j);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f24757a = (GImageBrowserView) aVar.internalFindViewById(R.id.browser);
        this.f24758b = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        this.f24759c = (TextView) aVar.internalFindViewById(R.id.count_display);
        if (this.f24758b != null) {
            this.f24758b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    h.this.f();
                }
            });
        }
        a();
    }
}

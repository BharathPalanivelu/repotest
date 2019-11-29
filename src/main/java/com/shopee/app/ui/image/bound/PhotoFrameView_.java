package com.shopee.app.ui.image.bound;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class PhotoFrameView_ extends j implements a, b {
    private boolean j = false;
    private final c k = new c();

    public PhotoFrameView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public PhotoFrameView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public PhotoFrameView_(Context context) {
        super(context);
        b();
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.camera_cropping_view_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22788g = aVar.internalFindViewById(R.id.cropping_view);
        this.h = aVar.internalFindViewById(R.id.cropping_view_top_space);
        this.i = aVar.internalFindViewById(R.id.cropping_view_bottom_space);
    }
}

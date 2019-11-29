package com.shopee.app.ui.image.crop;

import android.content.Context;
import android.view.View;
import com.garena.cropimage.library.CropImageView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean h = false;
    private final c i = new c();

    public e(Context context, String str, int i2, int i3, boolean z) {
        super(context, str, i2, i3, z);
        b();
    }

    public static d a(Context context, String str, int i2, int i3, boolean z) {
        e eVar = new e(context, str, i2, i3, z);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.crop_view_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f22799a = (CropImageView) aVar.internalFindViewById(R.id.crop_image_view);
        a();
    }
}

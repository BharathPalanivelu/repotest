package com.shopee.app.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.shopee.id.R;
import java.util.List;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean j = false;
    private final c k = new c();

    public k(Context context, List<GalleryData> list, long j2, int i, GalleryData galleryData, int i2, String str) {
        super(context, list, j2, i, galleryData, i2, str);
        f();
    }

    public static j a(Context context, List<GalleryData> list, long j2, int i, GalleryData galleryData, int i2, String str) {
        k kVar = new k(context, list, j2, i, galleryData, i2, str);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.image_browser_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.k);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f21968c = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f21969d = resources.getDimensionPixelSize(R.dimen.dp8);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21966a = (GImageBrowserView) aVar.internalFindViewById(R.id.browser);
        this.f21967b = (ImageButton) aVar.internalFindViewById(R.id.done_button);
        View internalFindViewById = aVar.internalFindViewById(R.id.back_button);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.b();
                }
            });
        }
        if (this.f21967b != null) {
            this.f21967b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.c();
                }
            });
        }
        a();
    }
}

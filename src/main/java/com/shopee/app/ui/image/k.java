package com.shopee.app.ui.image;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageButton;
import com.garena.android.uikit.image.browser.GImageBrowserView;
import com.shopee.app.ui.image.indicator.PageIndicatorView;
import com.shopee.id.R;
import java.util.List;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean k = false;
    private final c l = new c();

    public k(Context context, List<MediaData> list, boolean z, int i, boolean z2) {
        super(context, list, z, i, z2);
        g();
    }

    public static j a(Context context, List<MediaData> list, boolean z, int i, boolean z2) {
        k kVar = new k(context, list, z, i, z2);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.image_browser_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.l);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f23025e = resources.getDimensionPixelSize(R.dimen.dp16);
        this.f23026f = resources.getDimensionPixelSize(R.dimen.dp8);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23022b = (GImageBrowserView) aVar.internalFindViewById(R.id.browser);
        this.f23023c = (ImageButton) aVar.internalFindViewById(R.id.back_button);
        this.f23024d = (PageIndicatorView) aVar.internalFindViewById(R.id.page_indicator);
        if (this.f23023c != null) {
            this.f23023c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.b();
                }
            });
        }
        a();
    }
}

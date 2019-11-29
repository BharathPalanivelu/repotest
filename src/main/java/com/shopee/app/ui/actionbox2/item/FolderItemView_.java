package com.shopee.app.ui.actionbox2.item;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.app.ui.common.f;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class FolderItemView_ extends d implements a, b {
    private boolean j = false;
    private final c k = new c();

    public FolderItemView_(Context context) {
        super(context);
        b();
    }

    public FolderItemView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public FolderItemView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public FolderItemView_(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        b();
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.action_box_folder_view, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.k);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.f19447g = resources.getDimensionPixelSize(R.dimen.dp16);
        this.h = resources.getDimensionPixelSize(R.dimen.dp8);
        this.i = resources.getDimensionPixelSize(R.dimen.dp64);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19441a = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f19442b = (TextView) aVar.internalFindViewById(R.id.title);
        this.f19443c = (TextView) aVar.internalFindViewById(R.id.sub_title);
        this.f19444d = (f) aVar.internalFindViewById(R.id.badge);
        this.f19445e = aVar.internalFindViewById(R.id.divider);
        this.f19446f = aVar.internalFindViewById(R.id.parent_container);
        a();
    }
}

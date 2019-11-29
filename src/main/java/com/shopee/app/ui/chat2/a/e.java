package com.shopee.app.ui.chat2.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean s = false;
    private final c t = new c();

    public e(Context context, a aVar) {
        super(context, aVar);
        j();
    }

    public static d a(Context context, a aVar) {
        e eVar = new e(context, aVar);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.s) {
            this.s = true;
            inflate(getContext(), R.layout.offer_popup_view, this);
            this.t.a((a) this);
        }
        super.onFinishInflate();
    }

    private void j() {
        c a2 = c.a(this.t);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.j = resources.getDimensionPixelOffset(R.dimen.font_size_12);
        this.k = resources.getDimensionPixelOffset(R.dimen.font_size_24);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f20237a = (TextView) aVar.internalFindViewById(R.id.title);
        this.f20238b = (ImageView) aVar.internalFindViewById(R.id.icon);
        this.f20239c = (TextView) aVar.internalFindViewById(R.id.name);
        this.f20240d = (TextView) aVar.internalFindViewById(R.id.variation);
        this.f20241e = (TextView) aVar.internalFindViewById(R.id.price);
        this.f20242f = (TextView) aVar.internalFindViewById(R.id.offer);
        this.f20243g = (Button) aVar.internalFindViewById(R.id.button_left);
        this.h = (Button) aVar.internalFindViewById(R.id.button_right);
        this.i = aVar.internalFindViewById(R.id.buttonContainer);
        a();
    }
}

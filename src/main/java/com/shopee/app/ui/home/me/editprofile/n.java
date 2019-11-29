package com.shopee.app.ui.home.me.editprofile;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f22418g = false;
    private final c h = new c();

    public n(Context context) {
        super(context);
        c();
    }

    public static m a(Context context) {
        n nVar = new n(context);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.f22418g) {
            this.f22418g = true;
            inflate(getContext(), R.layout.shop_location_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22410a = (EditText) aVar.internalFindViewById(R.id.label_country);
        this.f22411b = (EditText) aVar.internalFindViewById(R.id.label_city);
        this.f22412c = (EditText) aVar.internalFindViewById(R.id.label_post_code);
        this.f22413d = (EditText) aVar.internalFindViewById(R.id.label_address);
        this.f22414e = (Button) aVar.internalFindViewById(R.id.continue_button);
        if (this.f22414e != null) {
            this.f22414e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.a();
                }
            });
        }
        b();
    }
}

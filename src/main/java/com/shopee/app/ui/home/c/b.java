package com.shopee.app.ui.home.c;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {

    /* renamed from: c  reason: collision with root package name */
    private boolean f22138c = false;

    /* renamed from: d  reason: collision with root package name */
    private final c f22139d = new c();

    public b(Context context) {
        super(context);
        f();
    }

    public static a a(Context context) {
        b bVar = new b(context);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.f22138c) {
            this.f22138c = true;
            inflate(getContext(), R.layout.web_view_error_tab, this);
            this.f22139d.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.f22139d);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f22134a = (Button) aVar.internalFindViewById(R.id.button);
        if (this.f22134a != null) {
            this.f22134a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.e();
                }
            });
        }
        d();
    }
}

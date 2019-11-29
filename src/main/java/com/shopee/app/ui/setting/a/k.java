package com.shopee.app.ui.setting.a;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoButton;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f25149g = false;
    private final c h = new c();

    public k(Context context) {
        super(context);
        d();
    }

    public static j a(Context context) {
        k kVar = new k(context);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.f25149g) {
            this.f25149g = true;
            inflate(getContext(), R.layout.theme_preview_view_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25144d = (RobotoButton) aVar.internalFindViewById(R.id.roBtnReset);
        this.f25145e = (RobotoButton) aVar.internalFindViewById(R.id.roBtnSave);
        this.f25146f = (LinearLayout) aVar.internalFindViewById(R.id.container);
        if (this.f25144d != null) {
            this.f25144d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.b();
                }
            });
        }
        if (this.f25145e != null) {
            this.f25145e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.c();
                }
            });
        }
        a();
    }
}

package com.shopee.app.ui.common;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class AskLoginView_ extends b implements a, b {

    /* renamed from: d  reason: collision with root package name */
    private boolean f20972d = false;

    /* renamed from: e  reason: collision with root package name */
    private final c f20973e = new c();

    public AskLoginView_(Context context) {
        super(context);
        b();
    }

    public AskLoginView_(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public AskLoginView_(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    public void onFinishInflate() {
        if (!this.f20972d) {
            this.f20972d = true;
            inflate(getContext(), R.layout.ask_login_layout, this);
            this.f20973e.a((a) this);
        }
        super.onFinishInflate();
    }

    private void b() {
        c a2 = c.a(this.f20973e);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f21224a = (TextView) aVar.internalFindViewById(R.id.label);
        this.f21225b = (ImageView) aVar.internalFindViewById(R.id.circle_icon);
        this.f21226c = (Button) aVar.internalFindViewById(R.id.ask_login_btn);
        if (this.f21226c != null) {
            this.f21226c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AskLoginView_.this.a();
                }
            });
        }
    }
}

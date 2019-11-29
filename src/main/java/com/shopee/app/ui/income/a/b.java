package com.shopee.app.ui.income.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.c;

public final class b extends a implements a, org.a.a.b.b {
    private boolean o = false;
    private final c p = new c();

    public b(Context context, int i) {
        super(context, i);
        f();
    }

    public static a a(Context context, int i) {
        b bVar = new b(context, i);
        bVar.onFinishInflate();
        return bVar;
    }

    public void onFinishInflate() {
        if (!this.o) {
            this.o = true;
            inflate(getContext(), R.layout.income_banner_layout, this);
            this.p.a((a) this);
        }
        super.onFinishInflate();
    }

    private void f() {
        c a2 = c.a(this.p);
        c.a((org.a.a.b.b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23094a = (TextView) aVar.internalFindViewById(R.id.title);
        this.f23095b = (TextView) aVar.internalFindViewById(R.id.subtitle);
        this.f23096c = (TextView) aVar.internalFindViewById(R.id.price);
        this.f23097d = (TextView) aVar.internalFindViewById(R.id.time_label);
        this.f23098e = (TextView) aVar.internalFindViewById(R.id.bottom_header);
        this.f23100g = (TextView) aVar.internalFindViewById(R.id.released_income_box);
        this.h = (TextView) aVar.internalFindViewById(R.id.released_income_amount);
        this.i = (TextView) aVar.internalFindViewById(R.id.add_btn);
        this.j = (RelativeLayout) aVar.internalFindViewById(R.id.released_income_layout);
        this.k = (RelativeLayout) aVar.internalFindViewById(R.id.add_btn_layout);
        this.l = (ImageView) aVar.internalFindViewById(R.id.help);
        if (this.l != null) {
            this.l.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.c();
                }
            });
        }
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.d();
                }
            });
        }
        if (this.k != null) {
            this.k.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    b.this.e();
                }
            });
        }
        a();
    }
}

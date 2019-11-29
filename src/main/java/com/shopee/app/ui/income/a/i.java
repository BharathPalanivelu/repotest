package com.shopee.app.ui.income.a;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class i extends h implements a, b {
    private boolean v = false;
    private final c w = new c();

    public i(Context context, int i) {
        super(context, i);
        h();
    }

    public static h a(Context context, int i) {
        i iVar = new i(context, i);
        iVar.onFinishInflate();
        return iVar;
    }

    public void onFinishInflate() {
        if (!this.v) {
            this.v = true;
            inflate(getContext(), R.layout.released_banner_layout, this);
            this.w.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.w);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23118a = (TextView) aVar.internalFindViewById(R.id.title);
        this.f23119b = (TextView) aVar.internalFindViewById(R.id.price);
        this.f23121d = (TextView) aVar.internalFindViewById(R.id.released_income_box);
        this.f23122e = (TextView) aVar.internalFindViewById(R.id.released_income_amount);
        this.f23123f = (RelativeLayout) aVar.internalFindViewById(R.id.released_income_layout);
        this.f23124g = (ImageView) aVar.internalFindViewById(R.id.help);
        this.h = (EditText) aVar.internalFindViewById(R.id.from);
        this.i = (TextView) aVar.internalFindViewById(R.id.from_date);
        this.j = (TextView) aVar.internalFindViewById(R.id.to_date);
        this.k = aVar.internalFindViewById(R.id.dummy);
        this.l = aVar.internalFindViewById(R.id.divider);
        this.m = (TextView) aVar.internalFindViewById(R.id.release_info);
        this.n = aVar.internalFindViewById(R.id.date_select_section);
        this.o = aVar.internalFindViewById(R.id.new_filter);
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.c();
                }
            });
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.d();
                }
            });
        }
        if (this.j != null) {
            this.j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.e();
                }
            });
        }
        if (this.f23124g != null) {
            this.f23124g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    i.this.f();
                }
            });
        }
        a();
    }
}

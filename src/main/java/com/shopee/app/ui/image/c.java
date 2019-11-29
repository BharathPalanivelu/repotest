package com.shopee.app.ui.image;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import com.shopee.app.ui.image.a;

public class c extends a implements AdapterView.OnItemClickListener, a.C0354a {
    private int r;
    private View.OnClickListener s;
    private AdapterView.OnItemClickListener t;
    private a u;

    public interface a {
        void a(int i, int i2);
    }

    public void i_(int i) {
    }

    public c(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setOnRearrangeListener(this);
    }

    /* access modifiers changed from: protected */
    public void e() {
        this.r = this.q.b();
        this.f22730b = this.q.a();
        for (int i = 0; i < this.r; i++) {
            addView(this.q.a(i, 0, i, this));
        }
    }

    public void a(int i, int i2) {
        a aVar = this.u;
        if (aVar != null) {
            aVar.a(i, i2);
        }
    }

    private boolean d(int i) {
        if (this.p) {
            int i2 = this.r;
            return i == i2 && i2 < this.q.c();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (d(i)) {
            View.OnClickListener onClickListener = this.s;
            if (onClickListener != null) {
                onClickListener.onClick(view);
                return;
            }
            return;
        }
        AdapterView.OnItemClickListener onItemClickListener = this.t;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(adapterView, view, i, j);
        }
    }

    public void setOnAddClickListener(View.OnClickListener onClickListener) {
        this.s = onClickListener;
    }

    public void setItemOnRearrangeListener(a aVar) {
        this.u = aVar;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.t = onItemClickListener;
        super.setOnItemClickListener(this);
    }
}

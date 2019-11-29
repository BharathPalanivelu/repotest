package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.ui.view.a.b;

public class d extends b implements View.OnClickListener {
    private TextView h;
    private TextView i;
    private Button j;
    private Button k;
    private a l;

    public interface a {
        void a();

        void b();
    }

    public d(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_leave, (ViewGroup) null, false);
        this.h = (TextView) inflate.findViewById(c.d.title);
        this.i = (TextView) inflate.findViewById(c.d.content);
        this.j = (Button) inflate.findViewById(c.d.btn_1);
        this.k = (Button) inflate.findViewById(c.d.btn_2);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f30002c.findViewById(c.d.window_view);
    }

    /* access modifiers changed from: protected */
    public View e() {
        return this.f30002c.findViewById(c.d.shadow_view);
    }

    /* access modifiers changed from: protected */
    public View g() {
        return this.f30004e;
    }

    public void onClick(View view) {
        if (this.l == null) {
            return;
        }
        if (view.getId() == c.d.btn_1) {
            this.l.a();
        } else if (view.getId() == c.d.btn_2) {
            this.l.b();
        }
    }

    public void a() {
        e.a(this.h, "t_ls_quit_title");
        e.a(this.i, "t_ls_quit_desc");
        e.a((TextView) this.j, "t_ls_quit_btn");
        e.a((TextView) this.k, "t_ls_quit_cancel_btn");
        super.a();
        com.shopee.livequiz.b.e.c();
    }

    public void a(a aVar) {
        this.l = aVar;
    }
}

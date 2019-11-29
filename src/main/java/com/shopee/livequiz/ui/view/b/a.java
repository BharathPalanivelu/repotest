package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.a.o;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.c.c;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.g.g;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.ui.view.a.b;
import com.shopee.livequiz.ui.view.share.ShareContainer;
import com.shopee.sdk.modules.ui.navigator.NavigationPath;

public class a extends b implements View.OnClickListener {
    private ImageView h;
    private ImageView i;
    private TextView j;
    /* access modifiers changed from: private */
    public TextView k;
    /* access modifiers changed from: private */
    public TextView l;
    private ImageView m;
    private TextView n;
    private View o;
    private ShareContainer p;
    private c q = com.shopee.livequiz.d.b.a.f();

    public a(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_clearance, (ViewGroup) null, false);
        this.o = inflate.findViewById(c.d.container);
        this.p = (ShareContainer) inflate.findViewById(c.d.share_container);
        this.h = (ImageView) inflate.findViewById(c.d.image_bg);
        this.i = (ImageView) inflate.findViewById(c.d.user_image);
        this.j = (TextView) inflate.findViewById(c.d.text_user_name);
        this.k = (TextView) inflate.findViewById(c.d.text_coins_number);
        this.n = (TextView) inflate.findViewById(c.d.t_ls_check_leaderboard);
        this.m = (ImageView) inflate.findViewById(c.d.image_close);
        this.l = (TextView) inflate.findViewById(c.d.t_ls_won_coins);
        this.n.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.n.getPaint().setFlags(8);
        this.p.a(this.f30001b).a(this.o).a(com.shopee.livequiz.data.b.a().b().universalLink).a(true, com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId);
        this.k.setTypeface(Typeface.createFromAsset(com.shopee.livequiz.b.a().c().getAssets(), "fonts/Neuzeit Grotesk Black.otf"));
        this.j.setText(g.e());
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
        return this.h;
    }

    public void onClick(View view) {
        if (view.getId() == c.d.image_close) {
            c();
        } else if (view.getId() == c.d.t_ls_check_leaderboard) {
            NavigationPath a2 = NavigationPath.a((com.shopee.livequiz.data.a.a.a() + "livequiz/event/{event_id}/rank").replace("{event_id}", com.shopee.livequiz.data.b.a().b().eventId + ""));
            com.shopee.livequiz.a.a aVar = (com.shopee.livequiz.a.a) this.f30001b;
            if (aVar != null) {
                aVar.c().a((Activity) aVar, a2, (o) null);
                c();
            }
        }
    }

    public void a() {
        e.b(this.h, "ls_winner_result_bg", c.g.livequiz_bg_popup_clearance);
        e.a(this.m, "ls_close_btn_bg", c.g.livequiz_ic_close);
        e.a(this.n, "t_ls_check_leaderboard");
        String g2 = g.g();
        if (!j.a(g2)) {
            com.shopee.livequiz.g.b.b(com.shopee.livequiz.data.a.b.a() + g2 + "_tn", this.i, c.b.livequiz_user_image_size, c.b.livequiz_user_image_size, c.g.livequiz_ic_user_header);
        }
        this.l.setVisibility(4);
        this.k.setText(com.garena.android.appkit.tools.b.e(c.h.popup_default_number));
        super.a();
        c(true);
        com.shopee.livequiz.b.e.b();
    }

    /* access modifiers changed from: private */
    public void c(final boolean z) {
        this.q.b(new c.a(com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), new d<com.shopee.livequiz.d.a.a.b>() {
            public void a(com.shopee.livequiz.d.a.a.b bVar) {
                a.this.k.setText(j.d(String.valueOf(bVar.f29721a)));
                int i = (int) bVar.f29721a;
                a.this.l.setVisibility(0);
                if (i == 0 || i == 1) {
                    e.a(a.this.l, "t_ls_won_coin");
                } else {
                    e.a(a.this.l, "t_ls_won_coins");
                }
            }

            public void a(int i, String str) {
                if (z) {
                    a.this.c(false);
                }
            }
        });
    }
}

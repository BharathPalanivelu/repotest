package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.d.c.a;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.ui.view.CountDownProgressView;
import com.shopee.livequiz.ui.view.a.b;

public class c extends b {
    private ImageView h;
    private TextView i;
    private CountDownProgressView j;
    private TextView k;
    /* access modifiers changed from: private */
    public a l;
    /* access modifiers changed from: private */
    public boolean m;
    /* access modifiers changed from: private */
    public com.shopee.livequiz.d.c.a n = com.shopee.livequiz.d.b.a.i();

    public interface a {
        void a();

        void a(boolean z);

        void b();
    }

    public c(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_extra_life, (ViewGroup) null, false);
        this.h = (ImageView) inflate.findViewById(c.d.iv_bg);
        this.i = (TextView) inflate.findViewById(c.d.tv_extra_life_notify);
        this.j = (CountDownProgressView) inflate.findViewById(c.d.count_down_progress);
        this.k = (TextView) inflate.findViewById(c.d.tv_not_now);
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
        return this.f30002c.findViewById(c.d.ll_content);
    }

    public void a() {
        e.a(this.h, "ls_life_popup_bg", c.b.livequiz_extra_life_popup_width, c.b.livequiz_extra_life_popup_height, c.g.livequiz_bg_popup_extra_life);
        this.j.a(e.a().d("color_text_F"), e.a().d("color_text_C"));
        this.i.setTextColor(e.a().d("color_text_C"));
        this.k.setTextColor(e.a().a("color_text_F", 128));
        this.k.setText(e.a().a("t_ls_use_life_cxl"));
        super.a();
    }

    public void a(GameModel gameModel, a aVar) {
        int d2 = com.shopee.livequiz.data.a.d(gameModel);
        String a2 = e.a().a(d2 > 1 ? "t_ls_lives_avl" : "t_ls_life_avl");
        int i2 = 0;
        if (!j.a(a2)) {
            this.i.setText(String.format(a2.replace("{Available extra life}", "%1$d").replace("{available extra life}", "%1$d"), new Object[]{Integer.valueOf(d2)}));
        }
        this.m = false;
        b(false);
        this.l = aVar;
        GameData b2 = com.shopee.livequiz.data.a.b(gameModel);
        final int i3 = b2 != null ? b2.msg_body.question_id : 0;
        if (b2 != null) {
            i2 = b2.msg_body.sn;
        }
        final int e2 = com.shopee.livequiz.data.a.e(gameModel, i2);
        com.shopee.livequiz.b.e.c(i3, e2);
        this.k.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (c.this.l != null) {
                    c.this.l.b();
                    boolean unused = c.this.m = false;
                }
                c.this.n.b(new a.C0456a("extra_life_not_now_use", com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), null);
                c.this.c();
                com.shopee.livequiz.b.e.e(i3, e2);
            }
        });
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (c.this.l != null) {
                    c.this.l.a();
                    boolean unused = c.this.m = true;
                }
                c.this.n.b(new a.C0456a("extra_life_confirm_use", com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), null);
                c.this.c();
                com.shopee.livequiz.b.e.d(i3, e2);
            }
        });
        this.j.a((long) (com.shopee.livequiz.data.b.a().b().extraLifeReviveCountdown * 1000), (CountDownProgressView.a) new CountDownProgressView.a() {
            public void a() {
            }

            public void b() {
                if (c.this.l != null) {
                    c.this.l.a();
                    boolean unused = c.this.m = true;
                }
                c.this.c();
                com.shopee.livequiz.b.e.f(i3, e2);
            }
        });
        this.n.b(new a.C0456a("extra_life_panel_show", com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), null);
        a();
    }

    public void c() {
        super.c();
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.m);
            this.l = null;
        }
    }
}

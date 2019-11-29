package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.livequiz.c;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.ui.view.a.b;

public class g extends b {
    private ImageView h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private TextView m;
    private ImageView n;

    public g(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_session_result, (ViewGroup) null, false);
        this.i = (TextView) inflate.findViewById(c.d.t_ls_winners);
        this.j = (TextView) inflate.findViewById(c.d.t_ls_winner_won_coins);
        this.h = (ImageView) inflate.findViewById(c.d.image_bg);
        this.m = (TextView) inflate.findViewById(c.d.t_ls_each_winner);
        this.k = (TextView) inflate.findViewById(c.d.text_coins_number);
        this.l = (TextView) inflate.findViewById(c.d.text_winner_number);
        this.n = (ImageView) inflate.findViewById(c.d.image_close);
        Typeface createFromAsset = Typeface.createFromAsset(com.shopee.livequiz.b.a().c().getAssets(), "fonts/Neuzeit Grotesk Black.otf");
        this.k.setTypeface(createFromAsset, 2);
        this.j.setTypeface(createFromAsset, 2);
        this.n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                g.this.c();
            }
        });
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

    public void a() {
        e.a(this.h, "ls_session_result_bg", c.b.livequiz_dialog_session_result_bg_width, c.b.livequiz_dialog_session_result_bg_height, c.g.livequiz_bg_popup_session_result);
        e.a(this.m, "t_ls_each_winner");
        e.a(this.n, "ls_close_btn_bg", c.g.livequiz_ic_close);
        this.k.setTextColor(e.a().d("color_text_D"));
        this.j.setTextColor(e.a().d("color_text_D"));
        super.a();
    }

    public void a(int i2, float f2) {
        this.l.setText(j.c(String.valueOf(i2)));
        this.k.setText(j.d(String.valueOf(f2)) + SQLBuilder.BLANK);
        String str = (String) this.l.getText();
        String a2 = e.a().a((AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "1".equals(str)) ? "t_ls_winner" : "t_ls_winners");
        if (a2 != null) {
            this.i.setText(a2.replace("{total winner} ", "").replace("{total winners} ", "").replace("{total winner}", "").replace("{total winners}", ""));
        }
        int i3 = (int) f2;
        String a3 = e.a().a((i3 == 0 || i3 == 1) ? "t_ls_winner_won_coin" : "t_ls_winner_won_coins");
        if (a3 != null) {
            this.j.setText(a3.replace("{coins per winner} ", "").replace("{coin per winner} ", "").replace("{coins per winner}", "").replace("{coin per winner}", ""));
        }
        a();
    }
}

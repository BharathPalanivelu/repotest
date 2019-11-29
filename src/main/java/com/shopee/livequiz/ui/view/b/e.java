package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.net.Uri;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.ui.view.a.b;
import com.shopee.sdk.modules.ui.c.a;

public class e extends b implements View.OnClickListener {
    private ImageView h;
    private TextView i;
    private ImageView j;
    private ImageView k;

    public e(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_login, (ViewGroup) null);
        this.i = (TextView) inflate.findViewById(c.d.t_ls_login_reminder_started);
        this.h = (ImageView) inflate.findViewById(c.d.image_bg);
        this.k = (ImageView) inflate.findViewById(c.d.image_close);
        this.j = (ImageView) inflate.findViewById(c.d.image_login);
        this.k.setOnClickListener(this);
        this.j.setOnClickListener(this);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public View f() {
        return this.f30002c.findViewById(c.d.window_view);
    }

    /* access modifiers changed from: protected */
    public View g() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public View e() {
        return this.f30002c.findViewById(c.d.shadow_view);
    }

    public void onClick(View view) {
        if (view.getId() == c.d.image_close) {
            c();
        } else if (view.getId() == c.d.image_login) {
            String replace = com.shopee.livequiz.data.b.a().b().landingPageUrl.replace("?s=app", "");
            String encode = Uri.encode(Base64.encodeToString(("{\"paths\":[{\"webNav\": {url: \"" + replace + "\"}}]}").getBytes(), 2));
            com.shopee.sdk.modules.ui.c.b b2 = com.shopee.sdk.b.a().b();
            Activity activity = this.f30001b;
            a.C0473a aVar = new a.C0473a();
            b2.a(activity, aVar.a("home?navRoute=" + encode).a());
            c();
        }
    }

    public void a() {
        com.shopee.livequiz.g.e.a(this.h, "ls_login_popup_bg", c.b.livequiz_dialog_login_bg_width, c.b.livequiz_dialog_login_bg_height, c.g.livequiz_bg_popup_login);
        com.shopee.livequiz.g.e.a(this.j, "ls_login_popup_btn_bg", c.b.livequiz_dialog_login_btn_width, c.b.livequiz_dialog_login_btn_height, c.g.livequiz_ic_login_button);
        com.shopee.livequiz.g.e.a(this.k, "ls_close_btn_bg", c.g.livequiz_ic_close);
        com.shopee.livequiz.g.e.a(this.i, "t_ls_login_reminder_started");
        this.i.setTextColor(com.shopee.livequiz.g.e.a().d("color_text_D"));
        super.a();
    }
}

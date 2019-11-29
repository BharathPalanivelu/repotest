package com.shopee.app.ui.myaccount.SocialAccounts;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {
    private boolean w = false;
    private final c x = new c();

    public g(Context context) {
        super(context);
        q();
    }

    public static f a(Context context) {
        g gVar = new g(context);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.w) {
            this.w = true;
            inflate(getContext(), R.layout.social_accounts_setting_layout, this);
            this.x.a((a) this);
        }
        super.onFinishInflate();
    }

    private void q() {
        c a2 = c.a(this.x);
        Resources resources = getContext().getResources();
        c.a((b) this);
        this.v = resources.getString(R.string.sp_label_unverified);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f23311g = (TextView) aVar.internalFindViewById(R.id.unlink_fb_button);
        this.h = (TextView) aVar.internalFindViewById(R.id.unlink_twitter_button);
        this.i = (TextView) aVar.internalFindViewById(R.id.unlink_instagram_button);
        this.j = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.link_facebook_view);
        this.k = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.link_twitter_view);
        this.l = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.link_instagram_view);
        this.m = (TextView) aVar.internalFindViewById(R.id.unlink_line_button);
        this.n = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.link_line_view);
        this.o = aVar.internalFindViewById(R.id.line_panel);
        View internalFindViewById = aVar.internalFindViewById(R.id.facebook_panel);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.twitter_panel);
        View internalFindViewById3 = aVar.internalFindViewById(R.id.instagram_panel);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.b();
                }
            });
        }
        if (this.o != null) {
            this.o.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.c();
                }
            });
        }
        if (this.f23311g != null) {
            this.f23311g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.e();
                }
            });
        }
        if (this.i != null) {
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.f();
                }
            });
        }
        if (this.h != null) {
            this.h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.g();
                }
            });
        }
        if (this.m != null) {
            this.m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.h();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.i();
                }
            });
        }
        if (internalFindViewById3 != null) {
            internalFindViewById3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    g.this.j();
                }
            });
        }
        a();
    }
}

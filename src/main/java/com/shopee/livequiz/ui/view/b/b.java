package com.shopee.livequiz.ui.view.b;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.appsflyer.share.Constants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.d;
import com.shopee.livequiz.d.b.a;
import com.shopee.livequiz.d.c.b;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.g.e;
import com.shopee.livequiz.g.j;
import com.shopee.livequiz.ui.view.share.ShareContainer;
import org.slf4j.Marker;

public class b extends com.shopee.livequiz.ui.view.a.b {
    private ImageView h;
    private ImageView i;
    private ShareContainer j;
    private View k;
    /* access modifiers changed from: private */
    public TextView l;
    /* access modifiers changed from: private */
    public TextView m;
    private TextView n;
    /* access modifiers changed from: private */
    public TextView o;
    private TextView p;
    private com.shopee.livequiz.d.c.b q = a.e();

    public b(Activity activity) {
        super(activity);
    }

    /* access modifiers changed from: protected */
    public View d() {
        View inflate = LayoutInflater.from(this.f30001b).inflate(c.f.livesdk_shopee_popup_elimination, (ViewGroup) null, false);
        this.j = (ShareContainer) inflate.findViewById(c.d.share_container);
        this.k = inflate.findViewById(c.d.container);
        this.h = (ImageView) inflate.findViewById(c.d.image_bg);
        this.l = (TextView) inflate.findViewById(c.d.t_ls_failed_msg);
        this.n = (TextView) inflate.findViewById(c.d.t_ls_correct_anses);
        this.m = (TextView) inflate.findViewById(c.d.text_correct_num);
        this.p = (TextView) inflate.findViewById(c.d.t_ls_rank);
        this.o = (TextView) inflate.findViewById(c.d.text_rank);
        this.i = (ImageView) inflate.findViewById(c.d.image_close);
        this.i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.c();
            }
        });
        this.j.a(this.f30001b).a(this.k).a(com.shopee.livequiz.data.b.a().b().universalLink).a(false, com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId);
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
        e.a(this.h, "ls_loser_result_bg", c.b.livequiz_dialog_elimination_bg_width, c.b.livequiz_dialog_elimination_bg_height, c.g.livequiz_bg_popup_elimination);
        e.a(this.i, "ls_close_btn_bg", c.g.livequiz_ic_close);
        e.a(this.n, "t_ls_correct_anses");
        e.a(this.p, "t_ls_rank");
        this.l.setTextColor(e.a().d("color_text_D"));
        this.l.setText(com.garena.android.appkit.tools.b.e(c.h.popup_default_number));
        this.m.setText(com.garena.android.appkit.tools.b.e(c.h.popup_default_number));
        this.o.setText(com.garena.android.appkit.tools.b.e(c.h.popup_default_number));
        super.a();
    }

    public void a(GameModel gameModel) {
        a();
        b(gameModel);
    }

    private void b(GameModel gameModel) {
        String str;
        final int i2 = com.shopee.livequiz.data.b.a().b().questionNum;
        final String str2 = com.shopee.livequiz.data.a.f(gameModel) + Constants.URL_PATH_DELIMITER + i2;
        GameData b2 = com.shopee.livequiz.data.a.b(gameModel);
        int i3 = 0;
        int i4 = 0;
        for (GameData.MSgBody.AnswerBean next : b2.msg_body.answers) {
            if (next.answer_id == b2.msg_body.correct_answer_id) {
                i4 = next.users + 1;
            }
        }
        if (i4 > 99999) {
            str = j.c(String.valueOf(99999)) + Marker.ANY_NON_NULL_MARKER;
        } else {
            str = j.c(i4 + "");
        }
        if (com.shopee.livequiz.data.b.a().b().bonus <= BitmapDescriptorFactory.HUE_RED || gameModel.sn < 2) {
            String a2 = e.a().a("t_ls_failed_msg");
            if (a2 != null) {
                this.l.setText(String.format(a2.replace("{wrong question}", "%1$d"), new Object[]{Integer.valueOf(gameModel.sn)}));
                this.m.setText(str2);
                this.o.setText(str);
            } else {
                return;
            }
        } else {
            final GameModel gameModel2 = gameModel;
            final String str3 = str;
            this.q.b(new b.a(com.shopee.livequiz.data.b.a().b().eventId, com.shopee.livequiz.data.b.a().b().sessionId), new d<com.shopee.livequiz.d.a.a.a>() {
                public void a(com.shopee.livequiz.d.a.a.a aVar) {
                    int i = aVar.f29719a;
                    float f2 = aVar.f29720b;
                    String a2 = e.a().a(f2 > 1.0f ? "t_ls_bonus_coins" : "t_ls_bonus_coin");
                    if (a2 != null) {
                        String str = i + Constants.URL_PATH_DELIMITER + i2;
                        if (j.e(f2 + "")) {
                            b.this.l.setText(String.format(e.a().a("t_ls_failed_msg").replace("{wrong question}", "%1$d"), new Object[]{Integer.valueOf(gameModel2.sn)}));
                        } else {
                            b.this.l.setText(a2.replace("{bonus coins}", j.d(f2 + "")));
                        }
                        b.this.m.setText(str);
                        b.this.o.setText(str3);
                    }
                }

                public void a(int i, String str) {
                    String a2 = e.a().a("t_ls_failed_msg");
                    if (a2 != null) {
                        String replace = a2.replace("{wrong question}", "%1$d");
                        b.this.l.setText(String.format(replace, new Object[]{Integer.valueOf(gameModel2.sn)}));
                        b.this.m.setText(str2);
                        b.this.o.setText(str3);
                    }
                }
            });
        }
        GameData c2 = com.shopee.livequiz.data.a.c(gameModel, gameModel.sn);
        if (c2 != null) {
            i3 = c2.msg_body.question_id;
        }
        com.shopee.livequiz.b.e.a(i3);
    }
}

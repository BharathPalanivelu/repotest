package com.shopee.livequiz.ui.view.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;
import com.shopee.livequiz.data.b;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.g.i;
import com.shopee.livequiz.g.m;
import com.shopee.livequiz.ui.view.AnswerResultProgressView;
import java.util.ArrayList;
import java.util.List;

public class GameResultPanel extends com.shopee.livequiz.ui.view.a.a {

    /* renamed from: c  reason: collision with root package name */
    private TextView f30070c;

    /* renamed from: d  reason: collision with root package name */
    private List<AnswerResultProgressView> f30071d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f30072e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f30073f;

    /* renamed from: g  reason: collision with root package name */
    private e f30074g;
    private e h;
    private e i;
    private e j;
    /* access modifiers changed from: private */
    public int k;
    /* access modifiers changed from: private */
    public a l;
    private boolean m;

    public interface a {
        void a();

        void a(int i);

        void b();
    }

    public GameResultPanel(Context context) {
        this(context, (AttributeSet) null);
    }

    public GameResultPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameResultPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30070c = (TextView) this.f29998a.findViewById(c.d.text_question);
        this.f30071d = new ArrayList();
        this.f30071d.add((AnswerResultProgressView) this.f29998a.findViewById(c.d.answer_1));
        this.f30071d.add((AnswerResultProgressView) this.f29998a.findViewById(c.d.answer_2));
        this.f30071d.add((AnswerResultProgressView) this.f29998a.findViewById(c.d.answer_3));
        this.f30071d.add((AnswerResultProgressView) this.f29998a.findViewById(c.d.answer_4));
        this.f30072e = (ImageView) this.f29998a.findViewById(c.d.status_image);
        this.f30073f = (TextView) this.f29998a.findViewById(c.d.t_ls_spectating);
        this.f30074g = new e() {
            public void a() {
                GameResultPanel.this.b();
            }
        };
        this.h = new e() {
            public void a() {
                if (GameResultPanel.this.l != null) {
                    GameResultPanel.this.l.b();
                }
            }
        };
        this.i = new e() {
            public void a() {
                if (GameResultPanel.this.l != null) {
                    GameResultPanel.this.l.a();
                }
            }
        };
        this.j = new e() {
            public void a() {
                if (GameResultPanel.this.l != null) {
                    GameResultPanel.this.l.a(GameResultPanel.this.k);
                }
            }
        };
        if (d()) {
            f();
        }
    }

    /* access modifiers changed from: protected */
    public int getContentId() {
        return c.f.livesdk_shopee_layout_answer_result_panel;
    }

    public void a(a aVar) {
        b(aVar);
        super.a();
        com.shopee.livequiz.g.e.a(this.f30073f, "t_ls_spectating");
        if (!this.m) {
            if (aVar.f30083e) {
                i.a().h();
            } else if (this.f30073f.getVisibility() == 8) {
                i.a().g();
            }
        }
        GameData b2 = com.shopee.livequiz.data.a.b(aVar.f30080b);
        if (b2 != null) {
            boolean z = false;
            boolean z2 = aVar.f30083e && aVar.f30080b.state != 4;
            boolean z3 = aVar.f30083e && aVar.f30080b.state == 4;
            if (aVar.f30082d && b2.msg_body.sn == b.a().b().questionNum) {
                z = true;
            }
            f.b(this.f30074g, (long) (b.a().b().showAnswerTime * 1000));
            if (z2) {
                f.b(this.h, (long) ((b.a().b().showAnswerTime - 1) * 1000));
            }
            if (z) {
                f.b(this.i, (long) ((b.a().b().showAnswerTime - 1) * 1000));
            }
            if (z3) {
                f.b(this.j, 1500);
            }
            com.shopee.livequiz.b.e.b(b2.msg_body.question_id, b2.msg_body.sn);
        }
    }

    private void b(a aVar) {
        int i2 = 0;
        this.f30073f.setVisibility(aVar.f30081c ? 0 : 8);
        this.f30072e.setVisibility((aVar.f30082d || aVar.f30083e) ? 0 : 8);
        this.f30072e.setImageResource(aVar.f30082d ? c.g.livequiz_ic_answer_correct : c.g.livequiz_ic_answer_wrong);
        GameModel gameModel = aVar.f30080b;
        if (gameModel != null) {
            GameData b2 = com.shopee.livequiz.data.a.b(gameModel);
            if (b2 != null) {
                this.k = b2.msg_body.sn;
                this.f30070c.setText(b2.msg_body.sn + "." + b2.msg_body.question_text);
                if (b2.msg_body.answers.size() <= this.f30071d.size()) {
                    for (AnswerResultProgressView visibility : this.f30071d) {
                        visibility.setVisibility(8);
                    }
                    List<GameData.MSgBody.AnswerBean> list = b2.msg_body.answers;
                    int i3 = 0;
                    int i4 = 0;
                    for (GameData.MSgBody.AnswerBean next : list) {
                        AnswerResultProgressView answerResultProgressView = this.f30071d.get(i3);
                        answerResultProgressView.setNum(next.users + "");
                        answerResultProgressView.setAnswer(next.answer_text);
                        answerResultProgressView.setVisibility(0);
                        i4 += next.users;
                        i3++;
                    }
                    int i5 = b2.msg_body.correct_answer_id;
                    int e2 = com.shopee.livequiz.data.a.e(gameModel, gameModel.sn);
                    for (GameData.MSgBody.AnswerBean next2 : list) {
                        AnswerResultProgressView answerResultProgressView2 = this.f30071d.get(i2);
                        answerResultProgressView2.setProgress((int) ((((float) next2.users) / ((float) i4)) * 100.0f));
                        if (i5 == next2.answer_id) {
                            answerResultProgressView2.setProgressBarDrawable(c.C0454c.livequiz_bg_progress_bar_correct);
                        } else if (e2 == next2.answer_id) {
                            answerResultProgressView2.setProgressBarDrawable(c.C0454c.livequiz_bg_progress_bar_wrong);
                        } else {
                            answerResultProgressView2.setProgressBarDrawable(c.C0454c.livequiz_bg_answer_result_progress_bar);
                        }
                        i2++;
                    }
                }
            }
        }
    }

    public void b() {
        super.b();
        f.d(this.f30074g);
        f.d(this.j);
        f.d(this.i);
        f.d(this.h);
    }

    public void a(boolean z) {
        this.m = z;
    }

    public void e() {
        f.d(this.f30074g);
        f.d(this.j);
        f.d(this.i);
        f.d(this.h);
    }

    public void setCallback(a aVar) {
        this.l = aVar;
    }

    private void f() {
        b bVar = new b();
        int e2 = m.e();
        a((RelativeLayout) this.f29998a.findViewById(c.d.rl_status_image), -1, bVar.a(c.e.land_panel_timer_top_margin) - e2, -1, -1);
        LinearLayout linearLayout = (LinearLayout) this.f29998a.findViewById(c.d.qa_container);
        int a2 = bVar.a(c.e.land_panel_content_padding_horizontal);
        linearLayout.setPadding(a2, -1, a2, -1);
        a(linearLayout, -1, bVar.a(c.e.land_panel_content_top_margin) - e2, -1, bVar.a(c.e.land_panel_items_bottom_margin));
        b((LinearLayout) this.f29998a.findViewById(c.d.ll_title), -1, bVar.a(c.e.land_panel_spectating_top_margin), -1, -1);
        this.f30073f.setHeight(bVar.a(c.e.land_panel_spectating_height));
        b(this.f30073f, -1, -1, -1, bVar.a(c.e.land_panel_spectating_bottom_margin));
        this.f30070c.setMaxHeight(bVar.a(c.e.land_panel_title_max_height));
        b((LinearLayout) this.f29998a.findViewById(c.d.answer_container), -1, bVar.a(c.e.land_panel_items_top_margin), -1, bVar.a(c.e.land_panel_items_bottom_margin));
        int a3 = bVar.a(c.e.land_panel_item_margin);
        int a4 = bVar.a(c.e.land_panel_item_height);
        for (int i2 = 0; i2 < this.f30071d.size(); i2++) {
            a(this.f30071d.get(i2), -1, a4);
            if (i2 != 0) {
                b(this.f30071d.get(i2), -1, a3, -1, -1);
            }
        }
    }
}

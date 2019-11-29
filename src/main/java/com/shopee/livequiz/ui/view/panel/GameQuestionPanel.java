package com.shopee.livequiz.ui.view.panel;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.shopee.livequiz.c;
import com.shopee.livequiz.c.e;
import com.shopee.livequiz.c.f;
import com.shopee.livequiz.data.b;
import com.shopee.livequiz.data.bean.GameData;
import com.shopee.livequiz.data.bean.GameModel;
import com.shopee.livequiz.g.l;
import com.shopee.livequiz.g.m;
import com.shopee.livequiz.ui.view.CountDownTimerView;
import java.util.ArrayList;
import java.util.List;

public class GameQuestionPanel extends com.shopee.livequiz.ui.view.a.a {

    /* renamed from: c  reason: collision with root package name */
    private CountDownTimerView f30060c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30061d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public RadioGroup f30062e;

    /* renamed from: f  reason: collision with root package name */
    private List<RadioButton> f30063f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f30064g;
    /* access modifiers changed from: private */
    public a h;
    /* access modifiers changed from: private */
    public boolean i;
    /* access modifiers changed from: private */
    public boolean j;
    private a k;

    public interface a {
        void a();

        void a(int i, int i2, int i3);
    }

    public GameQuestionPanel(Context context) {
        this(context, (AttributeSet) null);
    }

    public GameQuestionPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameQuestionPanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30060c = (CountDownTimerView) this.f29998a.findViewById(c.d.count_down_timer);
        this.f30061d = (TextView) this.f29998a.findViewById(c.d.text_question);
        this.f30062e = (RadioGroup) this.f29998a.findViewById(c.d.answer_group);
        this.f30063f = new ArrayList();
        this.f30063f.add((RadioButton) this.f29998a.findViewById(c.d.answer_check_1));
        this.f30063f.add((RadioButton) this.f29998a.findViewById(c.d.answer_check_2));
        this.f30063f.add((RadioButton) this.f29998a.findViewById(c.d.answer_check_3));
        this.f30063f.add((RadioButton) this.f29998a.findViewById(c.d.answer_check_4));
        this.f30064g = (TextView) this.f29998a.findViewById(c.d.t_ls_spectating);
        if (d()) {
            f();
        }
    }

    /* access modifiers changed from: protected */
    public int getContentId() {
        return c.f.livesdk_shopee_layout_question_panel;
    }

    public void b() {
        super.b();
        this.f30060c.a();
        a aVar = this.h;
        if (aVar == null) {
            return;
        }
        if (!this.j) {
            aVar.a(d(this.k), c(this.k), -1);
            f.c(new e() {
                public void a() {
                    GameQuestionPanel.this.h.a();
                }
            });
            return;
        }
        aVar.a();
    }

    public void a(boolean z) {
        this.f30060c.a(z);
    }

    public void e() {
        this.f30060c.b();
    }

    public void setCallback(a aVar) {
        this.h = aVar;
    }

    public void a(a aVar) {
        this.j = false;
        b(aVar);
        super.a();
        com.shopee.livequiz.g.e.a(this.f30064g, "t_ls_spectating");
        this.f30060c.a(b.a().b().showQuizTime, new CountDownTimerView.a() {
            public void a() {
                GameQuestionPanel.this.b();
            }
        });
    }

    private void b(a aVar) {
        final GameModel gameModel = aVar.f30080b;
        if (gameModel != null) {
            a(gameModel);
            this.k = aVar;
            this.f30064g.setVisibility(aVar.f30081c ? 0 : 8);
            if (aVar.f30081c) {
                this.f30062e.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        if (!GameQuestionPanel.this.i) {
                            l.a(com.shopee.livequiz.g.e.a().a("t_ls_spectating_desc"));
                            boolean unused = GameQuestionPanel.this.i = true;
                        }
                    }
                });
            }
            this.f30062e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    GameQuestionPanel.this.f30062e.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) null);
                    int i2 = 0;
                    GameQuestionPanel.this.a(radioGroup, false);
                    if (i != c.d.answer_check_1) {
                        if (i == c.d.answer_check_2) {
                            i2 = 1;
                        } else if (i == c.d.answer_check_3) {
                            i2 = 2;
                        } else {
                            i2 = i == c.d.answer_check_4 ? 3 : -1;
                        }
                    }
                    GameData a2 = com.shopee.livequiz.data.a.a(gameModel);
                    if (a2 != null) {
                        List<GameData.MSgBody.AnswerBean> list = a2.msg_body.answers;
                        if (list.size() >= i2 && i2 >= 0 && GameQuestionPanel.this.h != null) {
                            GameQuestionPanel.this.h.a(a2.msg_body.sn, a2.msg_body.question_id, list.get(i2).answer_id);
                            boolean unused = GameQuestionPanel.this.j = true;
                        }
                    }
                }
            });
        }
    }

    private void a(GameModel gameModel) {
        GameData a2 = com.shopee.livequiz.data.a.a(gameModel);
        if (a2 != null) {
            this.f30062e.clearCheck();
            this.f30061d.setText(a2.msg_body.sn + "." + a2.msg_body.question_text);
            for (RadioButton visibility : this.f30063f) {
                visibility.setVisibility(8);
            }
            if (a2.msg_body != null && a2.msg_body.answers != null && a2.msg_body.answers.size() <= this.f30063f.size()) {
                boolean z = true;
                if (gameModel.state != 1) {
                    z = false;
                }
                int i2 = z ? c.a.radio_button_text_color : c.a.livequiz_text_color_unavailable;
                int i3 = z ? c.C0454c.livequiz_bg_radio_button : c.C0454c.livequiz_bg_radio_button_unavailable;
                ColorStateList colorStateList = getResources().getColorStateList(i2);
                a(this.f30062e, z);
                List<GameData.MSgBody.AnswerBean> list = a2.msg_body.answers;
                if (list != null) {
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        RadioButton radioButton = this.f30063f.get(i4);
                        radioButton.setTextColor(colorStateList);
                        radioButton.setBackgroundResource(i3);
                        radioButton.setText(list.get(i4).answer_text);
                        radioButton.setVisibility(0);
                    }
                    com.shopee.livequiz.b.e.a(a2.msg_body.question_id, a2.msg_body.sn);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(RadioGroup radioGroup, boolean z) {
        for (int i2 = 0; i2 < radioGroup.getChildCount(); i2++) {
            radioGroup.getChildAt(i2).setClickable(z);
        }
    }

    private int c(a aVar) {
        if (aVar == null) {
            return 0;
        }
        GameData a2 = com.shopee.livequiz.data.a.a(aVar.f30080b);
        if (a2 == null) {
            return 0;
        }
        return a2.msg_body.question_id;
    }

    private int d(a aVar) {
        if (aVar == null) {
            return 0;
        }
        GameData a2 = com.shopee.livequiz.data.a.a(aVar.f30080b);
        if (a2 == null) {
            return 0;
        }
        return a2.msg_body.sn;
    }

    private void f() {
        b bVar = new b();
        int e2 = m.e();
        a((RelativeLayout) this.f29998a.findViewById(c.d.rl_timer), -1, bVar.a(c.e.land_panel_timer_top_margin) - e2, -1, -1);
        LinearLayout linearLayout = (LinearLayout) this.f29998a.findViewById(c.d.qa_container);
        int a2 = bVar.a(c.e.land_panel_content_padding_horizontal);
        linearLayout.setPadding(a2, -1, a2, -1);
        a(linearLayout, -1, bVar.a(c.e.land_panel_content_top_margin) - e2, -1, bVar.a(c.e.land_panel_items_bottom_margin));
        b((LinearLayout) this.f29998a.findViewById(c.d.ll_title), -1, bVar.a(c.e.land_panel_spectating_top_margin), -1, -1);
        this.f30064g.setHeight(bVar.a(c.e.land_panel_spectating_height));
        b(this.f30064g, -1, -1, -1, bVar.a(c.e.land_panel_spectating_bottom_margin));
        this.f30061d.setMaxHeight(bVar.a(c.e.land_panel_title_max_height));
        b((RelativeLayout) this.f29998a.findViewById(c.d.answer_container), -1, bVar.a(c.e.land_panel_items_top_margin), -1, bVar.a(c.e.land_panel_items_bottom_margin));
        int a3 = bVar.a(c.e.land_panel_item_margin);
        int a4 = bVar.a(c.e.land_panel_item_height);
        for (int i2 = 0; i2 < this.f30063f.size(); i2++) {
            a(this.f30063f.get(i2), -1, a4);
            if (i2 != 0) {
                b(this.f30063f.get(i2), -1, a3, -1, -1);
            }
        }
    }
}

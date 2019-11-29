package com.airpay.paysdk.base.ui.weidget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airpay.paysdk.base.d.d;
import com.airpay.paysdk.base.d.l;
import com.airpay.paysdk.base.ui.weidget.BBSearchView;
import com.airpay.paysdk.c;

public class a extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f3903a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f3904b;

    /* renamed from: c  reason: collision with root package name */
    private View f3905c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f3906d;

    /* renamed from: e  reason: collision with root package name */
    private h f3907e;

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater f3908f;

    /* renamed from: g  reason: collision with root package name */
    private LinearLayout f3909g;
    private LinearLayout h;
    private LinearLayout i;
    private LinearLayout j;
    private BBSearchView k;
    private String l = "";

    /* renamed from: com.airpay.paysdk.base.ui.weidget.a$a  reason: collision with other inner class name */
    public interface C0073a {
        void a(View view);
    }

    public interface b extends C0073a {
        int a();

        int b();
    }

    public a(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        this.f3908f = LayoutInflater.from(context);
        this.f3909g = (LinearLayout) this.f3908f.inflate(c.h.com_garena_beepay_action_bar, (ViewGroup) null);
        addView(this.f3909g, new LinearLayout.LayoutParams(-1, -1));
        this.h = (LinearLayout) this.f3909g.findViewById(c.f.actionbar_actions);
        this.f3903a = (TextView) findViewById(c.f.actionbar_title_lab);
        this.f3906d = (ImageView) findViewById(c.f.back_arrow);
        setArrowIcon(c.d.icon_action_bar_navigation);
        this.f3903a.setMaxWidth((((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth() * 4) / 5);
        this.i = (LinearLayout) findViewById(c.f.actionbar_home_btn);
        this.j = (LinearLayout) findViewById(c.f.actionbar_title_bg);
        if (l.a(context) <= 240.0f) {
            this.f3903a.setTextSize(2, 18.0f);
        }
    }

    public void setHomeAction(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public void setHomeActionEnabled(boolean z) {
        this.i.setEnabled(z);
        for (int i2 = 0; i2 < this.i.getChildCount(); i2++) {
            this.i.getChildAt(i2).setEnabled(z);
        }
    }

    public void setArrowIcon(int i2) {
        if (this.f3906d != null) {
            Context context = getContext();
            this.f3907e = new h(context, i2);
            this.f3907e.a(context, 3);
            this.f3906d.setImageDrawable(this.f3907e);
        }
    }

    public void setArrowTheme(int i2) {
        this.f3907e.a(getContext(), i2);
    }

    public void setTitle(CharSequence charSequence) {
        if (this.f3903a == null) {
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            this.f3903a.setVisibility(8);
            return;
        }
        this.f3903a.setVisibility(0);
        this.f3903a.setText(charSequence);
    }

    public void setBackground(int i2) {
        this.f3909g.setBackground(getResources().getDrawable(i2));
    }

    public void setHomeBtnText(CharSequence charSequence) {
        this.i.removeAllViews();
        Context context = getContext();
        TextView textView = new TextView(context);
        textView.setTextColor(context.getResources().getColorStateList(c.b.com_garena_beepay_txt_color_action_home_button));
        textView.setTextSize(2, 17.0f);
        textView.setSingleLine(true);
        textView.setText(charSequence);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(l.a(context, 8.0f), 0, 0, 0);
        textView.setGravity(17);
        this.i.addView(textView, layoutParams);
    }

    public void setHomeBtnVisibility(boolean z) {
        this.i.setVisibility(z ? 0 : 8);
    }

    public void setTitleFontColor(int i2) {
        this.f3903a.setTextColor(i2);
    }

    public void a() {
        View view = this.f3905c;
        if (view != null) {
            this.j.removeView(view);
            this.f3905c = null;
        }
    }

    public void setTitleViewOrientation(int i2) {
        this.j.setOrientation(i2);
        if (1 == i2) {
            this.f3903a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        } else {
            this.f3903a.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        }
    }

    public void a(C0073a aVar) {
        a(aVar, this.h.getChildCount());
    }

    public void a(C0073a aVar, int i2) {
        this.h.addView(b(aVar), i2);
    }

    private View b(C0073a aVar) {
        if (aVar instanceof b) {
            return a((b) aVar);
        }
        throw new RuntimeException("No such IItemAction");
    }

    public void b() {
        this.h.removeAllViews();
        a();
        c();
    }

    private View a(b bVar) {
        View inflate = this.f3908f.inflate(c.h.com_garena_beepay_bbactionbar_item, this.h, false);
        Context context = getContext();
        h hVar = new h(context, bVar.a());
        hVar.a(context, bVar.b());
        ((ImageButton) inflate.findViewById(c.f.myactionbar_item_btn)).setImageDrawable(hVar);
        inflate.setTag(bVar);
        com.airpay.paysdk.common.d.a.a(inflate).a((View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                Object tag = view.getTag();
                if (tag instanceof C0073a) {
                    ((C0073a) tag).a(view);
                }
            }
        });
        return inflate;
    }

    public void c() {
        if (this.k != null) {
            ((FrameLayout) this.f3909g.findViewById(c.f.actionbar_bg)).removeView(this.k);
            this.k.c();
            this.k = null;
        }
    }

    public void setQueryChangedListener(BBSearchView.a aVar) {
        BBSearchView bBSearchView = this.k;
        if (bBSearchView != null) {
            bBSearchView.setQueryChangedListener(aVar);
        }
    }

    public void d() {
        d.b(this, c.f.com_garena_beepay_bottom_divider, 8);
    }

    private void e() {
        this.f3904b = new TextView(getContext());
        this.f3904b.setTextAppearance(getContext(), c.j.com_garena_beepay_connection_status_text_style);
        if (l.a(getContext()) <= 240.0f) {
            this.f3904b.setTextSize(2, 12.0f);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = l.a(getContext(), 5.0f);
        this.f3904b.setLayoutParams(layoutParams);
        this.f3904b.setPadding(0, 0, 0, 0);
        this.j.addView(this.f3904b);
    }

    public void setSubtitleString(String str) {
        this.l = str;
        f();
    }

    private void f() {
        if (this.f3904b == null) {
            e();
        }
        if (!this.l.isEmpty()) {
            this.f3904b.setText(this.l);
            this.f3904b.setVisibility(0);
            return;
        }
        this.f3904b.setText("");
        this.f3904b.setVisibility(8);
    }
}

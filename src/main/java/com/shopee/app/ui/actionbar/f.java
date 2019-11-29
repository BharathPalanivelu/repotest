package com.shopee.app.ui.actionbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.a.b;
import com.shopee.app.a;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.common.IconImageView_;
import com.shopee.id.R;
import com.squareup.a.w;
import d.d.b.j;
import java.util.HashMap;

public final class f extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f19311a;

    public f(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public View b(int i) {
        if (this.f19311a == null) {
            this.f19311a = new HashMap();
        }
        View view = (View) this.f19311a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f19311a.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i, int i2, g gVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        j.b(context, "context");
        View.inflate(context, R.layout.action_drop_down_item_layout, this);
        a();
    }

    private final void a() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        setOrientation(0);
        setClickable(true);
        setPadding(b.a.k, 0, 0, 0);
        IconImageView_ iconImageView_ = (IconImageView_) b(a.C0250a.action_icon);
        j.a((Object) iconImageView_, "action_icon");
        iconImageView_.setVisibility(8);
    }

    public final void a(e.b bVar) {
        j.b(bVar, "menuItem");
        IconImageView_ iconImageView_ = (IconImageView_) b(a.C0250a.action_icon);
        j.a((Object) iconImageView_, "action_icon");
        iconImageView_.setVisibility(bVar.a() ? 0 : 8);
        RobotoTextView robotoTextView = (RobotoTextView) b(a.C0250a.text);
        j.a((Object) robotoTextView, "text");
        robotoTextView.setText(bVar.b());
    }

    public final void a(int i) {
        ((IconImageView_) b(a.C0250a.action_icon)).setImageResource(i);
        IconImageView_ iconImageView_ = (IconImageView_) b(a.C0250a.action_icon);
        j.a((Object) iconImageView_, "action_icon");
        iconImageView_.setVisibility(0);
    }

    public final void a(String str) {
        j.b(str, "url");
        w.a(getContext()).a(str).b(b.a.f7696g * 2, b.a.f7696g * 2).e().a((ImageView) (IconImageView_) b(a.C0250a.action_icon));
        IconImageView_ iconImageView_ = (IconImageView_) b(a.C0250a.action_icon);
        j.a((Object) iconImageView_, "action_icon");
        iconImageView_.setVisibility(0);
    }

    public final void setDividerVisibility(boolean z) {
        setBackgroundResource(z ? R.drawable.popup_menu_background_highlight : R.drawable.common_gray_background_highlight);
    }

    public final void a(int i, int i2, int i3, int i4) {
        ((RobotoTextView) b(a.C0250a.text)).setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }
}

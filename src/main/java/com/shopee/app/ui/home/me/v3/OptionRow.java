package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.devspark.robototextview.widget.RobotoTextView;
import com.garena.android.appkit.tools.c;
import com.google.a.o;
import com.shopee.app.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.e;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import d.p;
import java.util.HashMap;

public class OptionRow extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public UserInfo f22470a;

    /* renamed from: b  reason: collision with root package name */
    private String f22471b;

    /* renamed from: c  reason: collision with root package name */
    private String f22472c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f22473d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22474e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f22475f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22476g;
    private boolean h;
    private int i;
    private String j;
    private String k;
    private String l;
    private boolean m;
    private String n;
    private String o;
    private String p;
    private HashMap q;

    public interface a {
        void a(OptionRow optionRow);
    }

    public OptionRow(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public OptionRow(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i2) {
        if (this.q == null) {
            this.q = new HashMap();
        }
        View view = (View) this.q.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.q.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public OptionRow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LinearLayout.inflate(context, R.layout.view_option_row, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setMinimumHeight(c.a().a(48));
        setGravity(16);
        int a2 = c.a().a(12);
        setPadding(a2, a2, a2, a2);
        int[] iArr = a.b.OptionRow;
        j.a((Object) iArr, "R.styleable.OptionRow");
        com.shopee.app.e.b.a(this, iArr, attributeSet, new d.d.a.b<TypedArray, p>(this) {
            final /* synthetic */ OptionRow this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((TypedArray) obj);
                return p.f32714a;
            }

            public final void a(TypedArray typedArray) {
                j.b(typedArray, "$receiver");
                this.this$0.setText(typedArray.getString(9));
                this.this$0.setValue(typedArray.getString(13));
                this.this$0.setIcon(typedArray.getDrawable(0));
                this.this$0.setTrackTarget(typedArray.getString(8));
                this.this$0.setTrackSection(typedArray.getString(10));
                this.this$0.setTrackTabName(typedArray.getString(11));
                this.this$0.setPageSection(typedArray.getString(4));
                this.this$0.setPageType(typedArray.getString(5));
                this.this$0.setValueColor(typedArray.getInt(14, 0));
                this.this$0.setHidden(typedArray.getBoolean(2, false));
                this.this$0.setBorderHidden(typedArray.getBoolean(1, false));
                this.this$0.setShowTitleDrawable(typedArray.getBoolean(7, false));
                this.this$0.setShowNewLabel(typedArray.getBoolean(6, false));
            }
        });
        if (context != null) {
            RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.text_view);
            j.a((Object) robotoTextView, "text_view");
            Resources resources = context.getResources();
            j.a((Object) resources, "resources");
            double d2 = (double) resources.getDisplayMetrics().widthPixels;
            Double.isNaN(d2);
            robotoTextView.setMaxWidth((int) (d2 * 0.67d));
        }
        if (isInEditMode()) {
            return;
        }
        if (context != null) {
            Object b2 = ((x) context).b();
            if (b2 != null) {
                ((a) b2).a(this);
                a();
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.me.v3.OptionRow.Injector");
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.util.HasComponent<*>");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OptionRow(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final String getText() {
        return this.f22471b;
    }

    public final void setText(String str) {
        this.f22471b = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.text_view);
        j.a((Object) robotoTextView, "text_view");
        robotoTextView.setText(this.f22471b);
    }

    public final String getValue() {
        return this.f22472c;
    }

    public final void setValue(String str) {
        this.f22472c = str;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.value_view);
        j.a((Object) robotoTextView, "value_view");
        robotoTextView.setText(str);
        RobotoTextView robotoTextView2 = (RobotoTextView) a(a.C0250a.value_view);
        j.a((Object) robotoTextView2, "value_view");
        TextView textView = robotoTextView2;
        int i2 = this.i;
        if (i2 == 0) {
            i2 = getResources().getColor(R.color.black65);
        }
        org.c.a.b.a(textView, i2);
    }

    public final Drawable getIcon() {
        return this.f22473d;
    }

    public final void setIcon(Drawable drawable) {
        this.f22473d = drawable;
        ImageView imageView = (ImageView) a(a.C0250a.icon_view);
        j.a((Object) imageView, "icon_view");
        com.shopee.app.e.b.a(imageView);
        Drawable drawable2 = this.f22473d;
        if (drawable2 != null) {
            ImageView imageView2 = (ImageView) a(a.C0250a.icon_view);
            j.a((Object) imageView2, "icon_view");
            com.shopee.app.e.b.b(imageView2);
            ((ImageView) a(a.C0250a.icon_view)).setImageDrawable(drawable2);
        }
    }

    public final void setHidden(boolean z) {
        this.f22474e = z;
        if (this.f22474e) {
            com.shopee.app.e.b.a(this);
        } else {
            com.shopee.app.e.b.b(this);
        }
    }

    public final void setBorderHidden(boolean z) {
        this.f22475f = z;
        if (this.f22475f) {
            setBackgroundResource(R.drawable.white_background_highlight);
        } else {
            setBackgroundResource(R.drawable.bottom_right_margin_border_white_background_highlight);
        }
    }

    public final boolean getShowTitleDrawable() {
        return this.f22476g;
    }

    public final void setShowTitleDrawable(boolean z) {
        this.f22476g = z;
        ImageView imageView = (ImageView) a(a.C0250a.red_dot_view);
        j.a((Object) imageView, "red_dot_view");
        com.shopee.app.e.b.a((View) imageView, this.f22476g);
    }

    public final boolean getShowNewLabel() {
        return this.h;
    }

    public final void setShowNewLabel(boolean z) {
        this.h = z;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.new_label_view);
        j.a((Object) robotoTextView, "new_label_view");
        com.shopee.app.e.b.a((View) robotoTextView, this.h);
    }

    public final int getValueColor() {
        return this.i;
    }

    public final void setValueColor(int i2) {
        this.i = i2;
        RobotoTextView robotoTextView = (RobotoTextView) a(a.C0250a.value_view);
        j.a((Object) robotoTextView, "value_view");
        TextView textView = robotoTextView;
        int i3 = this.i;
        if (i3 == 0) {
            i3 = getResources().getColor(R.color.black65);
        }
        org.c.a.b.a(textView, i3);
    }

    public final String getTrackTarget() {
        return this.j;
    }

    public final void setTrackTarget(String str) {
        this.j = str;
    }

    public final String getTrackSection() {
        return this.k;
    }

    public final void setTrackSection(String str) {
        this.k = str;
    }

    public final String getTrackTabName() {
        return this.l;
    }

    public final void setTrackTabName(String str) {
        this.l = str;
    }

    public final boolean getTrackEnabled() {
        return this.m;
    }

    public final void setTrackEnabled(boolean z) {
        this.m = z;
    }

    public final String getTargetType() {
        return this.n;
    }

    public final void setTargetType(String str) {
        this.n = str;
    }

    public final String getPageSection() {
        return this.o;
    }

    public final void setPageSection(String str) {
        this.o = str;
    }

    public final String getPageType() {
        return this.p;
    }

    public final void setPageType(String str) {
        this.p = str;
    }

    public final UserInfo getUser() {
        UserInfo userInfo = this.f22470a;
        if (userInfo == null) {
            j.b("user");
        }
        return userInfo;
    }

    public final void setUser(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.f22470a = userInfo;
    }

    private final void a() {
        UserInfo userInfo = this.f22470a;
        if (userInfo == null) {
            j.b("user");
        }
        this.m = userInfo.isLoggedIn();
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OptionRow f22477a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f22478b;

        b(OptionRow optionRow, View.OnClickListener onClickListener) {
            this.f22477a = optionRow;
            this.f22478b = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.f22478b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.f22477a.b();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(new b(this, onClickListener));
    }

    /* access modifiers changed from: private */
    public final void b() {
        if (this.m && !TextUtils.isEmpty(this.l) && !TextUtils.isEmpty(this.k) && !TextUtils.isEmpty(this.j)) {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            f2.e().actionTracker().c(this.l, this.k, this.j);
        }
        String str = this.n;
        if (str != null && (getContext() instanceof e) && !TextUtils.isEmpty(str)) {
            Context context = getContext();
            if (context != null) {
                com.shopee.app.tracking.trackingv3.b z = ((e) context).z();
                String str2 = "";
                if (TextUtils.isEmpty(this.p)) {
                    String str3 = this.o;
                    com.shopee.app.tracking.trackingv3.b.a(z, str, str3 != null ? str3 : str2, (o) null, (String) null, 12, (Object) null);
                    return;
                }
                String str4 = this.o;
                if (str4 == null) {
                    str4 = str2;
                }
                o oVar = com.shopee.app.tracking.trackingv3.b.f19172a;
                String str5 = this.p;
                if (str5 != null) {
                    str2 = str5;
                }
                z.a(str, str4, oVar, str2);
                return;
            }
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.base.BaseActivity");
        }
    }
}

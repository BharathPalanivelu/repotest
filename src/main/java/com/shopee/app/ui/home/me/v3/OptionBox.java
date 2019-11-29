package com.shopee.app.ui.home.me.v3;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.a.o;
import com.shopee.app.a;
import com.shopee.app.application.ar;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.ui.a.e;
import com.shopee.app.ui.common.BadgeView_;
import com.shopee.app.util.x;
import com.shopee.id.R;
import d.d.b.j;
import d.m;
import d.p;
import java.util.HashMap;

public final class OptionBox extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public UserInfo f22461a;

    /* renamed from: b  reason: collision with root package name */
    private String f22462b;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f22463c;

    /* renamed from: d  reason: collision with root package name */
    private int f22464d;

    /* renamed from: e  reason: collision with root package name */
    private String f22465e;

    /* renamed from: f  reason: collision with root package name */
    private String f22466f;

    /* renamed from: g  reason: collision with root package name */
    private String f22467g;
    private boolean h;
    private String i;
    private String j;
    private String k;
    private View.OnClickListener l;
    private HashMap m;

    public interface a {
        void a(OptionBox optionBox);
    }

    public OptionBox(Context context) {
        this(context, (AttributeSet) null, 0, 6, (g) null);
    }

    public OptionBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (g) null);
    }

    public View a(int i2) {
        if (this.m == null) {
            this.m = new HashMap();
        }
        View view = (View) this.m.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.m.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public OptionBox(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        RelativeLayout.inflate(context, R.layout.view_option_box, this);
        int[] iArr = a.b.OptionBox;
        j.a((Object) iArr, "R.styleable.OptionBox");
        com.shopee.app.e.b.a(this, iArr, attributeSet, new d.d.a.b<TypedArray, p>(this) {
            final /* synthetic */ OptionBox this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object a(Object obj) {
                a((TypedArray) obj);
                return p.f32714a;
            }

            public final void a(TypedArray typedArray) {
                j.b(typedArray, "$receiver");
                this.this$0.setText(typedArray.getString(5));
                this.this$0.setIcon(typedArray.getDrawable(0));
                this.this$0.setTrackTarget(typedArray.getString(4));
                this.this$0.setTrackSection(typedArray.getString(6));
                this.this$0.setTrackTabName(typedArray.getString(7));
                this.this$0.setPageSection(typedArray.getString(2));
                this.this$0.setPageType(typedArray.getString(3));
                this.this$0.setNumber(typedArray.getInt(1, 0));
            }
        });
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
            throw new m("null cannot be cast to non-null type com.shopee.app.ui.home.me.v3.OptionBox.Injector");
        }
        throw new m("null cannot be cast to non-null type com.shopee.app.util.HasComponent<*>");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OptionBox(Context context, AttributeSet attributeSet, int i2, int i3, g gVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final String getText() {
        return this.f22462b;
    }

    public final void setText(String str) {
        this.f22462b = str;
        TextView textView = (TextView) a(a.C0250a.text_view);
        j.a((Object) textView, "text_view");
        textView.setText(this.f22462b);
    }

    public final Drawable getIcon() {
        return this.f22463c;
    }

    public final void setIcon(Drawable drawable) {
        this.f22463c = drawable;
        ((ImageView) a(a.C0250a.icon_view)).setImageDrawable(this.f22463c);
    }

    public final int getNumber() {
        return this.f22464d;
    }

    /* access modifiers changed from: private */
    public final void setNumber(int i2) {
        this.f22464d = i2;
        if (this.f22464d > 0) {
            ((BadgeView_) a(a.C0250a.badge_view)).setNumber(Integer.valueOf(this.f22464d));
            ((BadgeView_) a(a.C0250a.badge_view)).setBadgeType(0);
            BadgeView_ badgeView_ = (BadgeView_) a(a.C0250a.badge_view);
            j.a((Object) badgeView_, "badge_view");
            com.shopee.app.e.b.b(badgeView_);
            return;
        }
        BadgeView_ badgeView_2 = (BadgeView_) a(a.C0250a.badge_view);
        j.a((Object) badgeView_2, "badge_view");
        com.shopee.app.e.b.a(badgeView_2);
    }

    public final String getTrackTarget() {
        return this.f22465e;
    }

    public final void setTrackTarget(String str) {
        this.f22465e = str;
    }

    public final String getTrackSection() {
        return this.f22466f;
    }

    public final void setTrackSection(String str) {
        this.f22466f = str;
    }

    public final String getTrackTabName() {
        return this.f22467g;
    }

    public final void setTrackTabName(String str) {
        this.f22467g = str;
    }

    public final boolean getTrackEnabled() {
        return this.h;
    }

    public final void setTrackEnabled(boolean z) {
        this.h = z;
    }

    public final String getTargetType() {
        return this.i;
    }

    public final void setTargetType(String str) {
        this.i = str;
    }

    public final String getPageSection() {
        return this.j;
    }

    public final void setPageSection(String str) {
        this.j = str;
    }

    public final String getPageType() {
        return this.k;
    }

    public final void setPageType(String str) {
        this.k = str;
    }

    public final View.OnClickListener getOnClick() {
        return this.l;
    }

    public final void setOnClick(View.OnClickListener onClickListener) {
        this.l = onClickListener;
    }

    public final UserInfo getUser() {
        UserInfo userInfo = this.f22461a;
        if (userInfo == null) {
            j.b("user");
        }
        return userInfo;
    }

    public final void setUser(UserInfo userInfo) {
        j.b(userInfo, "<set-?>");
        this.f22461a = userInfo;
    }

    public final void a() {
        UserInfo userInfo = this.f22461a;
        if (userInfo == null) {
            j.b("user");
        }
        this.h = userInfo.isLoggedIn();
    }

    public final void setNumber(Integer num) {
        setNumber(num != null ? num.intValue() : 0);
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OptionBox f22468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f22469b;

        b(OptionBox optionBox, View.OnClickListener onClickListener) {
            this.f22468a = optionBox;
            this.f22469b = onClickListener;
        }

        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.f22469b;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            this.f22468a.b();
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(new b(this, onClickListener));
    }

    /* access modifiers changed from: private */
    public final void b() {
        if (this.h && !TextUtils.isEmpty(this.f22467g) && !TextUtils.isEmpty(this.f22466f) && !TextUtils.isEmpty(this.f22465e)) {
            ar f2 = ar.f();
            j.a((Object) f2, "ShopeeApplication.get()");
            f2.e().actionTracker().c(this.f22467g, this.f22466f, this.f22465e);
        }
        String str = this.i;
        if (str != null && (getContext() instanceof e) && !TextUtils.isEmpty(str)) {
            Context context = getContext();
            if (context != null) {
                com.shopee.app.tracking.trackingv3.b z = ((e) context).z();
                String str2 = "";
                if (TextUtils.isEmpty(this.k)) {
                    String str3 = this.j;
                    com.shopee.app.tracking.trackingv3.b.a(z, str, str3 != null ? str3 : str2, (o) null, (String) null, 12, (Object) null);
                    return;
                }
                String str4 = this.j;
                if (str4 == null) {
                    str4 = str2;
                }
                o oVar = com.shopee.app.tracking.trackingv3.b.f19172a;
                String str5 = this.k;
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

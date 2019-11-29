package com.shopee.app.ui.actionbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.share.widget.ShareDialog;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.tools.a.b;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.shopee.app.tracking.trackingv3.model.Info;
import com.shopee.app.tracking.trackingv3.model.TrackingEvent;
import com.shopee.app.tracking.trackingv3.model.UserActionV3;
import com.shopee.app.ui.actionbar.e;
import com.shopee.app.ui.common.f;
import com.shopee.app.ui.common.m;
import com.shopee.app.util.av;
import com.shopee.app.web.WebRegister;
import com.shopee.app.web.protocol.NavbarMessage;
import com.shopee.app.web.protocol.RightItemMessage;
import com.shopee.app.web.protocol.TrackingMessageModel;
import com.shopee.id.R;
import com.squareup.a.af;
import com.squareup.a.w;
import java.util.ArrayList;
import java.util.List;

public class a extends LinearLayout implements View.OnClickListener, af {

    /* renamed from: a  reason: collision with root package name */
    protected C0296a f19260a;

    /* renamed from: b  reason: collision with root package name */
    ImageButton f19261b;

    /* renamed from: c  reason: collision with root package name */
    LinearLayout f19262c;

    /* renamed from: d  reason: collision with root package name */
    RelativeLayout f19263d;

    /* renamed from: e  reason: collision with root package name */
    ImageView f19264e;

    /* renamed from: f  reason: collision with root package name */
    TextView f19265f;

    /* renamed from: g  reason: collision with root package name */
    TextView f19266g;
    k h;
    m i;
    ViewGroup j;
    ViewGroup k;
    int l;
    int m;
    int n;
    int o;
    private int p;
    private e q;
    private View r;

    private void h() {
    }

    public void a(Drawable drawable) {
    }

    public void a(boolean z) {
    }

    public a(Context context, C0296a aVar) {
        super(context);
        this.f19260a = aVar;
    }

    public void a(e eVar) {
        this.q = eVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        if (this.f19260a.p != 2) {
            this.f19264e.setVisibility(0);
            this.f19265f.setVisibility(0);
            this.f19262c.setVisibility(0);
            this.h.setVisibility(8);
            if (this.f19260a.f19279a != -1) {
                setBackgroundResource(this.f19260a.f19279a);
            }
        } else {
            this.f19264e.setVisibility(8);
            this.f19265f.setVisibility(8);
            this.f19262c.setVisibility(8);
            this.h.setVisibility(0);
            this.h.setText(this.f19260a.r);
            if (this.f19260a.i != null) {
                this.h.setSearchPlaceHolder(this.f19260a.i);
            }
            setBackgroundResource(R.drawable.action_bar_secondary_background);
            this.h.a(this.f19260a.z);
        }
        if (!TextUtils.isEmpty(this.f19260a.A)) {
            w.a(getContext()).a(this.f19260a.A).b(getResources().getDisplayMetrics().widthPixels, 0).a((af) this);
        }
    }

    /* access modifiers changed from: package-private */
    public void b() {
        av.a(this.f19261b);
        a();
        if (this.f19260a.f19279a != -1) {
            setBackgroundResource(this.f19260a.f19279a);
        }
        this.f19261b.setVisibility(this.f19260a.c());
        this.f19261b.setImageDrawable(com.garena.android.appkit.tools.b.f(this.f19260a.f19281c != -1 ? this.f19260a.f19281c : R.drawable.com_garena_shopee_ic_back));
        if (this.f19260a.f19282d != -1) {
            this.f19261b.setBackgroundResource(this.f19260a.f19282d);
        }
        if (this.f19260a.f19284f == 1) {
            ImageButton imageButton = this.f19261b;
            imageButton.setImageDrawable(c(imageButton.getDrawable()));
        }
        this.f19261b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.i();
            }
        });
        if (this.f19260a.k != -1) {
            this.f19264e.setImageResource(this.f19260a.k);
            this.f19264e.setVisibility(0);
        } else {
            this.f19264e.setVisibility(8);
        }
        if (this.f19260a.f19283e != -1) {
            this.f19265f.setText(this.f19260a.f19283e);
        }
        if (this.f19260a.f19285g != null) {
            this.f19265f.setText(this.f19260a.f19285g);
        }
        this.f19265f.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                com.garena.android.appkit.b.b.a("ICON_BAR_ICON_ON_LONG_CLICK", (com.garena.android.appkit.b.a) null, b.a.UI_BUS);
                return false;
            }
        });
        if (this.f19260a.p != 0) {
            this.f19265f.setTextColor(com.garena.android.appkit.tools.b.a(this.f19260a.s));
        } else {
            this.f19265f.setTextColor(com.garena.android.appkit.tools.b.a(this.f19260a.s));
            if (this.f19260a.c() == 8) {
                this.f19265f.setPadding(b.a.k, 0, b.a.k, 0);
            } else {
                this.f19265f.setPadding(0, 0, 0, 0);
            }
        }
        if (this.f19260a.f19284f == 1) {
            this.f19265f.setTextColor(com.garena.android.appkit.tools.b.a(R.color.white));
        }
        for (b a2 : this.f19260a.m) {
            a(a2);
        }
        if (this.f19260a.n != null) {
            this.q = this.f19260a.n.a(getContext());
        }
        if (this.f19260a.o != null) {
            this.f19265f.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.com_garena_shopee_ic_dropdown, 0);
            this.f19265f.setCompoundDrawablePadding(b.a.f7694e);
            this.f19265f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    a.this.f19260a.o.a(a.this.getContext()).a(view);
                }
            });
        } else if (this.f19260a.w) {
            if (this.f19260a.p != 0) {
                g();
            } else {
                this.f19265f.setTextColor(com.garena.android.appkit.tools.b.a(this.f19260a.s));
                this.f19265f.setText("");
                this.f19265f.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
                this.i.setVisibility(0);
                this.j.setVisibility(0);
                this.j.setBackgroundResource(R.drawable.search_box_primary);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                layoutParams.topMargin = b.a.f7696g;
                layoutParams.bottomMargin = b.a.f7696g;
                this.j.setLayoutParams(layoutParams);
                this.f19264e.setVisibility(0);
                this.f19264e.setImageResource(this.f19260a.y ? R.drawable.ic_mall_logo : R.drawable.ic_search_shopee);
            }
            this.f19265f.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.garena.android.appkit.b.b.a("SEARCH", new com.garena.android.appkit.b.a(Boolean.valueOf(a.this.f19260a.y)), b.a.UI_BUS);
                }
            });
        } else {
            this.i.setVisibility(8);
            this.j.setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
            this.f19265f.setOnClickListener((View.OnClickListener) null);
        }
        this.p = this.f19260a.p;
        if (e()) {
            setBackgroundColor(com.garena.android.appkit.tools.b.a(R.color.transparent));
        } else {
            setBackgroundColor(-1);
        }
        if (!TextUtils.isEmpty(this.f19260a.x)) {
            try {
                setBackgroundColor(Color.parseColor(this.f19260a.x));
            } catch (IllegalArgumentException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
        if (this.f19260a.u) {
            this.f19261b.setVisibility(8);
            this.f19265f.setPadding(b.a.h / 2, 0, b.a.h / 2, 0);
            a((b) new i((Activity) getContext()));
        }
        if (!e() || !TextUtils.isEmpty(this.f19260a.f19285g)) {
            this.f19265f.setVisibility(0);
        } else {
            this.f19265f.setVisibility(8);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!this.f19260a.w) {
            this.f19265f.setText(charSequence);
        }
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f19266g.setText(str);
            this.f19266g.setVisibility(8);
            return;
        }
        this.f19266g.setText(str);
        this.f19266g.setVisibility(0);
    }

    public void setTitleForSearch(String str) {
        if (this.f19260a.p != 0) {
            String replaceAll = str.replaceAll("\"", "");
            int unused = this.f19260a.s = R.color.black87;
            this.f19265f.setText(replaceAll);
            String unused2 = this.f19260a.r = replaceAll;
            g();
        }
    }

    private void g() {
        this.f19263d.removeAllViews();
        com.shopee.app.ui.d.a a2 = com.shopee.app.ui.d.b.a(getContext());
        a2.a(1);
        a2.setTitle(this.f19260a.h);
        a2.setTitleColor(this.f19260a.j);
        a2.setStyle(this.f19260a.f19284f);
        a2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                com.garena.android.appkit.b.b.a("SEARCH", new com.garena.android.appkit.b.a(), b.a.UI_BUS);
            }
        });
        this.f19265f = (TextView) a2.findViewById(R.id.title_text);
        if (!TextUtils.isEmpty(this.f19260a.r)) {
            a2.setSearchText(this.f19260a.r);
        }
        this.f19263d.addView(a2, new RelativeLayout.LayoutParams(-1, -1));
    }

    public void a(b bVar) {
        View b2 = b(bVar);
        this.f19262c.addView(b2, new LinearLayout.LayoutParams(-2, this.l));
        if (bVar.f19295g == R.drawable.ic_nav_cart_orange) {
            this.r = b2;
            h();
        }
    }

    public View getCartView() {
        return this.r;
    }

    public int[] getCartLocation() {
        int[] iArr = {-1, -1};
        View view = this.r;
        if (view != null) {
            view.getLocationOnScreen(iArr);
            iArr[1] = iArr[1] + (this.r.getHeight() / 2) + b.a.f7695f;
            iArr[0] = (iArr[0] - (this.r.getWidth() / 2)) + b.a.f7695f;
        }
        return iArr;
    }

    public void c() {
        this.f19262c.removeAllViews();
    }

    public void a(String str, int i2) {
        f fVar = (f) findViewWithTag(str);
        if (fVar != null) {
            fVar.setNumber(Integer.valueOf(i2));
        }
    }

    private Drawable c(Drawable drawable) {
        Drawable g2 = androidx.core.graphics.drawable.a.g(drawable.mutate());
        androidx.core.graphics.drawable.a.a(g2, com.garena.android.appkit.tools.b.a(R.color.white));
        return g2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: android.widget.RelativeLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: android.widget.ImageButton} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v32, resolved type: android.widget.ImageButton} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x023c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0240  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View b(com.shopee.app.ui.actionbar.a.b r14) {
        /*
            r13 = this;
            android.widget.RelativeLayout r0 = new android.widget.RelativeLayout
            android.content.Context r1 = r13.getContext()
            r0.<init>(r1)
            boolean r1 = r14.d()
            r2 = 2131100585(0x7f0603a9, float:1.7813556E38)
            r3 = 0
            r4 = 2131361842(0x7f0a0032, float:1.8343448E38)
            r5 = 1
            r6 = 0
            if (r1 != 0) goto L_0x00e4
            android.graphics.drawable.Drawable r1 = r14.f()
            if (r1 == 0) goto L_0x0020
            goto L_0x00e4
        L_0x0020:
            java.lang.String r1 = r14.c()
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0090
            android.widget.ImageButton r1 = new android.widget.ImageButton
            android.content.Context r7 = r13.getContext()
            r1.<init>(r7)
            r1.setId(r4)
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a
            int r7 = r7.f19282d
            r1.setBackgroundResource(r7)
            android.content.Context r7 = r13.getContext()     // Catch:{ Exception -> 0x0088 }
            com.squareup.a.w r7 = com.squareup.a.w.a((android.content.Context) r7)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r8 = r14.c()     // Catch:{ Exception -> 0x0088 }
            com.squareup.a.aa r7 = r7.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0088 }
            int r8 = r13.n     // Catch:{ Exception -> 0x0088 }
            int r9 = r13.n     // Catch:{ Exception -> 0x0088 }
            com.squareup.a.aa r7 = r7.b(r8, r9)     // Catch:{ Exception -> 0x0088 }
            com.squareup.a.aa r7 = r7.e()     // Catch:{ Exception -> 0x0088 }
            r7.a((android.widget.ImageView) r1)     // Catch:{ Exception -> 0x0088 }
            r1.setTag(r14)     // Catch:{ Exception -> 0x0088 }
            com.shopee.app.util.bj.a((android.view.View) r1, (android.view.View.OnClickListener) r13)     // Catch:{ Exception -> 0x0088 }
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x0088 }
            int r8 = r13.m     // Catch:{ Exception -> 0x0088 }
            int r9 = r13.l     // Catch:{ Exception -> 0x0088 }
            r7.<init>(r8, r9)     // Catch:{ Exception -> 0x0088 }
            r0.addView(r1, r7)     // Catch:{ Exception -> 0x0088 }
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a     // Catch:{ Exception -> 0x0085 }
            int r7 = r7.f19284f     // Catch:{ Exception -> 0x0085 }
            if (r7 != r5) goto L_0x0133
            android.graphics.drawable.Drawable r7 = r1.getDrawable()     // Catch:{ Exception -> 0x0085 }
            android.graphics.drawable.Drawable r7 = r13.c(r7)     // Catch:{ Exception -> 0x0085 }
            r1.setImageDrawable(r7)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0133
        L_0x0085:
            r7 = move-exception
            r8 = 1
            goto L_0x008b
        L_0x0088:
            r7 = move-exception
            r1 = r3
            r8 = 0
        L_0x008b:
            com.garena.android.appkit.d.a.a(r7)
            goto L_0x0134
        L_0x0090:
            com.shopee.app.ui.common.m r1 = r14.g()
            if (r1 == 0) goto L_0x00e1
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r7 = r13.getContext()
            r1.<init>(r7)
            r1.setId(r4)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = r13.n
            r7.<init>(r8, r8)
            r8 = 13
            r9 = -1
            r7.addRule(r8, r9)
            com.shopee.app.ui.common.m r8 = r14.g()
            r1.addView(r8, r7)
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a
            int r7 = r7.f19282d
            r1.setBackgroundResource(r7)
            r1.setTag(r14)
            com.shopee.app.util.bj.a((android.view.View) r1, (android.view.View.OnClickListener) r13)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r9 = r13.m
            int r10 = r13.l
            r7.<init>(r9, r10)
            r0.addView(r1, r7)
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a
            int r7 = r7.f19284f
            if (r7 != r5) goto L_0x0133
            int r7 = com.garena.android.appkit.tools.b.a(r2)
            r8.setColor(r7)
            goto L_0x0133
        L_0x00e1:
            r1 = r3
            r8 = 0
            goto L_0x0134
        L_0x00e4:
            android.widget.ImageButton r1 = new android.widget.ImageButton
            android.content.Context r7 = r13.getContext()
            r1.<init>(r7)
            r1.setId(r4)
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a
            int r7 = r7.f19282d
            r1.setBackgroundResource(r7)
            boolean r7 = r14.d()
            if (r7 == 0) goto L_0x0107
            int r7 = r14.e()
            r1.setImageResource(r7)
            goto L_0x010e
        L_0x0107:
            android.graphics.drawable.Drawable r7 = r14.f()
            r1.setImageDrawable(r7)
        L_0x010e:
            r1.setTag(r14)
            com.shopee.app.util.bj.a((android.view.View) r1, (android.view.View.OnClickListener) r13)
            android.widget.RelativeLayout$LayoutParams r7 = new android.widget.RelativeLayout$LayoutParams
            int r8 = r13.m
            int r9 = r13.l
            r7.<init>(r8, r9)
            r0.addView(r1, r7)
            com.shopee.app.ui.actionbar.a$a r7 = r13.f19260a
            int r7 = r7.f19284f
            if (r7 != r5) goto L_0x0133
            android.graphics.drawable.Drawable r7 = r1.getDrawable()
            android.graphics.drawable.Drawable r7 = r13.c(r7)
            r1.setImageDrawable(r7)
        L_0x0133:
            r8 = 1
        L_0x0134:
            r7 = 16
            r9 = -2
            if (r1 == 0) goto L_0x01da
            if (r8 == 0) goto L_0x01da
            java.lang.String r10 = r14.f19289a
            boolean r10 = android.text.TextUtils.isEmpty(r10)
            if (r10 != 0) goto L_0x01da
            r0.removeAllViews()
            android.widget.TextView r10 = new android.widget.TextView
            android.content.Context r11 = r13.getContext()
            r10.<init>(r11)
            java.lang.String r11 = r14.f19289a
            r10.setText(r11)
            r10.setGravity(r7)
            r11 = 1092616192(0x41200000, float:10.0)
            r10.setTextSize(r11)
            com.shopee.app.ui.actionbar.a$a r11 = r13.f19260a
            int r11 = r11.f19284f
            if (r11 != r5) goto L_0x0169
            goto L_0x016c
        L_0x0169:
            r2 = 2131100133(0x7f0601e5, float:1.7812639E38)
        L_0x016c:
            int r2 = com.garena.android.appkit.tools.b.a(r2)
            r10.setTextColor(r2)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            int r11 = r13.l
            r2.<init>(r9, r11)
            com.garena.android.appkit.tools.c r11 = com.garena.android.appkit.tools.c.a()
            r12 = 30
            int r11 = r11.a((int) r12)
            r2.leftMargin = r11
            com.garena.android.appkit.tools.c r11 = com.garena.android.appkit.tools.c.a()
            r12 = 10
            int r11 = r11.a((int) r12)
            r2.topMargin = r11
            android.widget.RelativeLayout$LayoutParams r11 = new android.widget.RelativeLayout$LayoutParams
            int r12 = r13.l
            r11.<init>(r9, r12)
            r0.addView(r1, r11)
            r0.addView(r10, r2)
            r0.setTag(r14)
            r1.setOnClickListener(r3)
            r1.setClickable(r6)
            r1.setFocusable(r6)
            r1.setBackgroundResource(r6)
            r1 = 2131230814(0x7f08005e, float:1.8077691E38)
            r0.setBackgroundResource(r1)
            com.shopee.app.ui.actionbar.a$a r1 = r13.f19260a
            java.util.List r1 = r1.m
            if (r1 == 0) goto L_0x01d0
            com.shopee.app.ui.actionbar.a$a r1 = r13.f19260a
            java.util.List r1 = r1.m
            int r1 = r1.size()
            if (r1 <= r5) goto L_0x01d0
            int r1 = com.garena.android.appkit.tools.a.b.a.f7695f
            int r2 = com.garena.android.appkit.tools.a.b.a.f7692c
            r0.setPadding(r1, r6, r2, r6)
            goto L_0x01d7
        L_0x01d0:
            int r1 = com.garena.android.appkit.tools.a.b.a.f7695f
            int r2 = com.garena.android.appkit.tools.a.b.a.h
            r0.setPadding(r1, r6, r2, r6)
        L_0x01d7:
            com.shopee.app.util.bj.a((android.view.View) r0, (android.view.View.OnClickListener) r13)
        L_0x01da:
            if (r8 != 0) goto L_0x0225
            android.widget.TextView r1 = new android.widget.TextView
            android.content.Context r2 = r13.getContext()
            r1.<init>(r2)
            r1.setId(r4)
            int r2 = r13.o
            r1.setPadding(r2, r6, r2, r6)
            com.shopee.app.ui.actionbar.a$a r2 = r13.f19260a
            int r2 = r2.f19282d
            r1.setBackgroundResource(r2)
            int r2 = r14.f19290b
            r1.setTextColor(r2)
            r1.setGravity(r7)
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r2, r5)
            r1.setTypeface(r2)
            java.lang.String r2 = r14.b()
            r1.setText(r2)
            r2 = 1094713344(0x41400000, float:12.0)
            r1.setTextSize(r2)
            r1.setTag(r14)
            com.shopee.app.util.bj.a((android.view.View) r1, (android.view.View.OnClickListener) r13)
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams
            int r3 = r13.l
            r2.<init>(r9, r3)
            r0.addView(r1, r2)
        L_0x0225:
            android.content.Context r1 = r13.getContext()
            com.shopee.app.ui.common.f r1 = com.shopee.app.ui.common.BadgeView_.a(r1)
            java.lang.String r14 = r14.h()
            r1.setTag(r14)
            com.shopee.app.ui.actionbar.a$a r14 = r13.f19260a
            boolean r14 = r14.y
            if (r14 == 0) goto L_0x0240
            r1.e()
            goto L_0x0243
        L_0x0240:
            r1.c()
        L_0x0243:
            android.widget.RelativeLayout$LayoutParams r14 = new android.widget.RelativeLayout$LayoutParams
            r14.<init>(r9, r9)
            r2 = 7
            r14.addRule(r2, r4)
            int r2 = com.garena.android.appkit.tools.a.b.a.f7694e
            r14.rightMargin = r2
            int r2 = com.garena.android.appkit.tools.a.b.a.f7696g
            r14.topMargin = r2
            r0.addView(r1, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shopee.app.ui.actionbar.a.b(com.shopee.app.ui.actionbar.a$b):android.view.View");
    }

    /* access modifiers changed from: private */
    public void i() {
        if (!this.f19260a.l) {
            ((Activity) getContext()).onBackPressed();
        } else {
            com.garena.android.appkit.b.b.a("ACTION_BAR_HOME_ACTION", (com.garena.android.appkit.b.a) null, b.a.UI_BUS);
        }
    }

    public void onClick(View view) {
        b bVar = (b) view.getTag();
        bVar.a(view);
        if (this.q != null && bVar.h().equals("more")) {
            this.q.a(view);
        }
        if (bVar.h().equals("ACTION_BAR_GENERIC")) {
            com.garena.android.appkit.b.b.a(bVar.h(), new com.garena.android.appkit.b.a(bVar.i()), b.a.UI_BUS);
        } else {
            com.garena.android.appkit.b.b.a(bVar.h(), new com.garena.android.appkit.b.a(bVar.h()), b.a.UI_BUS);
        }
    }

    public void d() {
        a("");
    }

    public void a(String str) {
        this.p = this.f19260a.p;
        int unused = this.f19260a.p = 2;
        a();
        if (this.f19260a.i != null) {
            this.h.setSearchPlaceHolder(this.f19260a.i);
        }
        k kVar = this.h;
        if (TextUtils.isEmpty(str)) {
            str = this.f19260a.r;
        }
        kVar.setText(str);
        this.h.b();
    }

    public int getType() {
        return this.f19260a.p;
    }

    public boolean e() {
        return this.f19260a.t == 1;
    }

    public void f() {
        this.f19262c.removeAllViews();
        b();
    }

    public void setBuilder(C0296a aVar) {
        this.f19260a = aVar;
    }

    public void setSearchPlaceholder(String str) {
        this.h.setSearchPlaceHolder(str);
    }

    public String getSearchPlaceholderActive() {
        return this.f19260a.i;
    }

    public String getSearchText() {
        return this.f19260a.r;
    }

    public void setSearchText(String str) {
        String unused = this.f19260a.r = str;
    }

    public void b(String str, int i2) {
        for (int i3 = 0; i3 < this.f19262c.getChildCount(); i3++) {
            View childAt = this.f19262c.getChildAt(i3);
            if (childAt != null && (childAt.getTag() instanceof b) && ((b) childAt.getTag()).i().equals(str) && (childAt instanceof RelativeLayout)) {
                View findViewById = childAt.findViewById(R.id.action);
                if (findViewById instanceof ImageButton) {
                    ((ImageButton) findViewById).setImageResource(i2);
                }
            }
        }
    }

    public k getSearchView() {
        return this.h;
    }

    public void a(Bitmap bitmap, w.d dVar) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        bitmapDrawable.setGravity(80);
        setBackground(bitmapDrawable);
    }

    public void b(Drawable drawable) {
        setBackgroundColor(getResources().getColor(R.color.background_light));
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f19289a = null;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f19290b = com.garena.android.appkit.tools.b.a(R.color.primary);

        /* renamed from: c  reason: collision with root package name */
        private String f19291c;

        /* renamed from: d  reason: collision with root package name */
        private String f19292d;

        /* renamed from: e  reason: collision with root package name */
        private String f19293e;

        /* renamed from: f  reason: collision with root package name */
        private String f19294f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f19295g = -1;
        private Drawable h;
        private m i;
        private Info.InfoBuilder j;
        private View.OnClickListener k;

        public void a() {
        }

        public b(String str, int i2, String str2, String str3, String str4, String str5, int i3, Drawable drawable, m mVar, Info.InfoBuilder infoBuilder, View.OnClickListener onClickListener) {
            this.f19289a = str;
            this.f19290b = i2;
            this.f19291c = str2;
            this.f19292d = str3;
            this.f19293e = str4;
            this.f19294f = str5;
            this.f19295g = i3;
            this.h = drawable;
            this.i = mVar;
            this.j = infoBuilder;
            this.k = onClickListener;
        }

        public b(String str, int i2) {
            this.f19291c = str;
            this.f19295g = i2;
        }

        public b(String str, Drawable drawable) {
            this.f19291c = str;
            this.h = drawable;
        }

        public b(String str, m mVar) {
            this.f19291c = str;
            this.i = mVar;
        }

        public b(String str, String str2) {
            this.f19291c = str;
            this.f19292d = str2;
        }

        public b(String str, String str2, int i2) {
            this.f19291c = str;
            this.f19292d = str2;
            this.f19290b = com.garena.android.appkit.tools.b.a(i2);
        }

        public void a(Info.InfoBuilder infoBuilder) {
            this.j = infoBuilder;
        }

        public String b() {
            return this.f19292d;
        }

        public String c() {
            return this.f19293e;
        }

        public boolean d() {
            return this.f19295g != -1;
        }

        public int e() {
            return this.f19295g;
        }

        public Drawable f() {
            return this.h;
        }

        public m g() {
            return this.i;
        }

        public String h() {
            return this.f19291c;
        }

        public String i() {
            return this.f19294f;
        }

        public void a(View view) {
            a();
            View.OnClickListener onClickListener = this.k;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            if (this.j != null) {
                UserActionV3.Companion.create(new TrackingEvent(Info.Companion.click(this.j, com.shopee.app.tracking.trackingv3.b.f19172a))).log();
            }
        }
    }

    /* renamed from: com.shopee.app.ui.actionbar.a$a  reason: collision with other inner class name */
    public static class C0296a implements e.c {
        /* access modifiers changed from: private */
        public String A;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public int f19279a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f19280b = 8;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public int f19281c = -1;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public int f19282d = -1;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f19283e = -1;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f19284f = 0;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String f19285g = null;
        /* access modifiers changed from: private */
        public String h = null;
        /* access modifiers changed from: private */
        public String i = null;
        /* access modifiers changed from: private */
        public String j = null;
        /* access modifiers changed from: private */
        public int k = -1;
        /* access modifiers changed from: private */
        public boolean l = false;
        /* access modifiers changed from: private */
        public List<b> m = new ArrayList();
        /* access modifiers changed from: private */
        public e.a n;
        /* access modifiers changed from: private */
        public e.a o;
        /* access modifiers changed from: private */
        public int p;
        private Integer q = null;
        /* access modifiers changed from: private */
        public String r = null;
        /* access modifiers changed from: private */
        public int s = R.color.black87;
        /* access modifiers changed from: private */
        public int t = 0;
        /* access modifiers changed from: private */
        public boolean u = false;
        private boolean v = false;
        /* access modifiers changed from: private */
        public boolean w;
        /* access modifiers changed from: private */
        public String x;
        /* access modifiers changed from: private */
        public boolean y;
        /* access modifiers changed from: private */
        public boolean z;

        public C0296a a(boolean z2) {
            this.z = z2;
            return this;
        }

        public C0296a a(int i2) {
            this.f19279a = i2;
            return this;
        }

        public boolean a() {
            return this.t == 1;
        }

        public boolean b() {
            return this.v;
        }

        public int c() {
            if (b()) {
                return 8;
            }
            return this.f19280b;
        }

        public int d() {
            return this.f19284f;
        }

        public String e() {
            return this.A;
        }

        public C0296a f() {
            this.t = 1;
            return this;
        }

        public C0296a a(String str) {
            this.f19285g = str;
            return this;
        }

        public C0296a b(String str) {
            this.i = str;
            return this;
        }

        public C0296a g() {
            this.l = true;
            return this;
        }

        public C0296a b(int i2) {
            this.f19283e = i2;
            return this;
        }

        public C0296a a(e.a aVar) {
            this.n = aVar;
            aVar.a((e.c) new e.c() {
                public void a(int i, Object obj) {
                    com.garena.android.appkit.b.b.a("CLICK", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(i), obj)), b.a.UI_BUS);
                }
            });
            a("more", (int) R.drawable.com_garena_shopee_ic_more);
            return this;
        }

        public C0296a c(int i2) {
            this.s = i2;
            return this;
        }

        public C0296a d(int i2) {
            this.f19282d = i2;
            return this;
        }

        public C0296a a(String str, int i2) {
            this.m.add(new b(str, i2) {
                public void a() {
                }
            });
            return this;
        }

        public C0296a a(String str, String str2) {
            this.m.add(new b(str, str2) {
                public void a() {
                }
            });
            return this;
        }

        public C0296a a(b bVar) {
            this.m.add(bVar);
            return this;
        }

        public a a(Context context) {
            return c.a(context, this);
        }

        public void c(String str) {
            if (str != null) {
                str = str.replace("\"", "");
            }
            this.r = str;
        }

        public C0296a e(int i2) {
            this.f19280b = i2;
            return this;
        }

        public C0296a f(int i2) {
            if (i2 == 0) {
                a((int) R.drawable.action_bar_primary_background);
                d((int) R.drawable.action_bar_button_background);
                e(8);
            } else if (i2 == 1) {
                a((int) R.drawable.action_bar_secondary_background);
                d((int) R.drawable.md_selector);
                e(4);
            } else if (i2 == 2) {
                a((int) R.drawable.action_bar_secondary_background);
                d((int) R.drawable.md_selector);
                e(0);
            }
            this.p = i2;
            return this;
        }

        public C0296a g(int i2) {
            this.f19284f = i2;
            return this;
        }

        public C0296a d(String str) {
            this.A = str;
            return this;
        }

        public void b(String str, String str2) {
            try {
                com.garena.android.appkit.d.a.b("ACTION_BAR: " + str, new Object[0]);
                NavbarMessage navbarMessage = (NavbarMessage) WebRegister.GSON.a(str, NavbarMessage.class);
                if (navbarMessage != null) {
                    this.f19284f = navbarMessage.getNavbarStyle();
                    this.f19285g = navbarMessage.getTitle();
                    this.h = navbarMessage.getSearchPlaceholder();
                    this.i = navbarMessage.getSearchPlaceholderActive();
                    this.j = navbarMessage.getSearchPlaceholderColor();
                    this.r = navbarMessage.getSearchText();
                    this.t = navbarMessage.getIsTransparent();
                    this.u = navbarMessage.showCloseIcon();
                    this.v = navbarMessage.hideBackButton();
                    this.w = navbarMessage.getShowSearch() == 1;
                    this.x = navbarMessage.getNavbarBackgroundColor();
                    if (this.w) {
                        if (!TextUtils.isEmpty(navbarMessage.getSearchPlaceholder())) {
                            this.f19285g = navbarMessage.getSearchPlaceholder();
                        }
                        this.s = R.color.primary;
                    }
                    if (this.f19284f == 1) {
                        this.s = R.color.white;
                    }
                    RightItemMessage rightItemsConfig = navbarMessage.getRightItemsConfig();
                    if (rightItemsConfig != null) {
                        List<RightItemMessage> items = rightItemsConfig.getItems();
                        if (items != null) {
                            for (RightItemMessage next : items) {
                                TrackingMessageModel trackingMessageModel = next.getTrackingMessageModel();
                                b bVar = null;
                                if (next.getType().equals("search") && !this.w) {
                                    bVar = new com.shopee.app.ui.actionbar.a.a().b("SEARCH").b((int) R.drawable.com_garena_shopee_ic_search).a();
                                } else if (next.getType().equals("cart")) {
                                    bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_CART").b((int) R.drawable.ic_nav_cart_orange).a();
                                } else if (next.getType().equals(BaseEvent.SDK_CHAT)) {
                                    bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_ACTION_BOX").b((int) R.drawable.ic_chat_andriod).a();
                                } else if (next.getType().equals("button")) {
                                    if (next.getKey().equals("submit")) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_DONE").b((int) R.drawable.com_garena_shopee_ic_done).a();
                                    } else if (next.getKey().equals("edit")) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_EDIT").b((int) R.drawable.ic_edit).a();
                                    } else if (next.getKey().equals("skip")) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_SKIP").c(next.getText()).a();
                                    } else if (next.getKey().equals(ShareDialog.WEB_SHARE_DIALOG)) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_GENERIC").b((int) R.drawable.ic_collections_share).e(next.getKey()).a(next.getIconText()).a();
                                    } else if (next.getIconType().equals("filter")) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_GENERIC").b((int) R.drawable.com_garena_shopee_ic_filter).e(next.getKey()).a(next.getIconText()).a();
                                    } else if (next.getIconType().equals("filterApplied")) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_GENERIC").b((int) R.drawable.com_garena_shopee_ic_filtered).e(next.getKey()).a(next.getIconText()).a();
                                    } else if (!TextUtils.isEmpty(next.getIconUrl())) {
                                        bVar = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_GENERIC").d(next.getIconUrl()).e(next.getKey()).a();
                                    } else if (!TextUtils.isEmpty(next.getText())) {
                                        com.shopee.app.ui.actionbar.a.a e2 = new com.shopee.app.ui.actionbar.a.a().b("ACTION_BAR_GENERIC").c(next.getText()).e(next.getKey());
                                        if (!TextUtils.isEmpty(next.getTextColor())) {
                                            try {
                                                e2.a(Color.parseColor(next.getTextColor()));
                                            } catch (Exception e3) {
                                                com.garena.android.appkit.d.a.a(e3);
                                            }
                                        }
                                        bVar = e2.a();
                                    }
                                } else if (next.getType().equals("more")) {
                                    List<RightItemMessage> items2 = next.getItems();
                                    e.a aVar = new e.a();
                                    for (RightItemMessage next2 : items2) {
                                        e.b bVar2 = NavbarMessage.mMap.get(next2.getType());
                                        if (bVar2 != null) {
                                            bVar2.f19308d = next2;
                                        } else if (!TextUtils.isEmpty(next.getText())) {
                                            bVar2 = new e.b(0, next.getText(), (Object) next.getKey(), next2.getIconUrl());
                                        } else if (next2.getType().equals("button")) {
                                            bVar2 = new e.b(4, next2.getText(), (Object) next2, next2.getIconUrl());
                                        }
                                        if (bVar2 != null) {
                                            aVar.a(bVar2);
                                        }
                                    }
                                    aVar.a((e.c) this);
                                    this.n = aVar;
                                    bVar = new com.shopee.app.ui.actionbar.a.a().b("more").b((int) R.drawable.com_garena_shopee_ic_more).a();
                                }
                                if (bVar != null) {
                                    if (trackingMessageModel != null) {
                                        bVar.a(Info.InfoBuilder.Companion.builder().withPageType(trackingMessageModel.getPageType()).withPageSection(trackingMessageModel.getPageSection()).withTargetType(trackingMessageModel.getTargetType()));
                                    }
                                    a(bVar);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e4) {
                com.garena.android.appkit.d.a.a(e4);
            }
        }

        public void a(int i2, Object obj) {
            com.garena.android.appkit.b.b.a("CLICK", new com.garena.android.appkit.b.a(new Pair(Integer.valueOf(i2), obj)), b.a.UI_BUS);
        }
    }
}

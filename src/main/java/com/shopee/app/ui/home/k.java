package com.shopee.app.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.garena.android.uikit.a.a;
import com.garena.android.uikit.a.a.b;
import com.google.a.o;
import com.shopee.app.ui.common.ao;
import com.shopee.app.ui.home.q;
import com.shopee.app.ui.home.react.ReactTabView;
import com.shopee.app.ui.home.web.WebTabView;
import com.shopee.app.util.s;

public class k extends a {

    /* renamed from: c  reason: collision with root package name */
    private final s f22256c;

    /* renamed from: d  reason: collision with root package name */
    private final l f22257d;

    /* renamed from: e  reason: collision with root package name */
    private p f22258e;

    /* renamed from: f  reason: collision with root package name */
    private ReactTabView f22259f;

    /* renamed from: g  reason: collision with root package name */
    private ReactTabView f22260g;
    private ReactTabView h;
    private int i = -1;

    public View a(Context context) {
        return null;
    }

    public int b() {
        return 5;
    }

    public k(s sVar, l lVar) {
        this.f22256c = sVar;
        this.f22257d = lVar;
    }

    public b d(Context context, int i2) {
        ao aoVar = new ao(context, "TAB:" + i2);
        aoVar.setVisibility(8);
        return aoVar;
    }

    public com.garena.android.uikit.a.a.a e(Context context, int i2) {
        p pVar;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    q a2 = this.f22257d.a(i2);
                    if (a2 instanceof q.b) {
                        return new WebTabView(context, ((q.b) a2).a(), i2);
                    }
                    q.a aVar = (q.a) a2;
                    this.f22260g = new ReactTabView(context, aVar.a(), aVar.b());
                    return this.f22260g;
                } else if (i2 == 3) {
                    pVar = new p(context, 3);
                } else if (i2 != 4) {
                    try {
                        return com.shopee.app.ui.home.b.b.a(context);
                    } catch (Exception e2) {
                        com.garena.android.appkit.d.a.a(e2);
                        return com.shopee.app.ui.home.c.b.a(context);
                    }
                } else {
                    this.f22258e = new p(context, 4, this.i);
                    return this.f22258e;
                }
            } else if (this.f22257d.a()) {
                o oVar = new o();
                oVar.a("is_tab", (Boolean) true);
                this.h = new ReactTabView(context, "@shopee-rn/feed/HOME", oVar.toString());
                return this.h;
            } else {
                pVar = new p(context, 1);
            }
            return pVar;
        }
        this.f22259f = new ReactTabView(context, "HOME_PAGE", "");
        return this.f22259f;
    }

    public void a(int i2) {
        this.i = i2;
        p pVar = this.f22258e;
        if (pVar != null) {
            pVar.setSubIndex(i2);
        }
    }

    public LinearLayout.LayoutParams b(Context context, int i2) {
        return new LinearLayout.LayoutParams(-2, -2);
    }

    public int b(int i2) {
        if (i2 == 0) {
            ReactTabView reactTabView = this.f22259f;
            if (reactTabView != null) {
                return reactTabView.getReactTag();
            }
        }
        if (i2 == 1) {
            ReactTabView reactTabView2 = this.h;
            if (reactTabView2 != null) {
                return reactTabView2.getReactTag();
            }
        }
        if (i2 == 2) {
            ReactTabView reactTabView3 = this.f22260g;
            if (reactTabView3 != null) {
                return reactTabView3.getReactTag();
            }
        }
        if (i2 != 4) {
            return 0;
        }
        p pVar = this.f22258e;
        if (pVar != null) {
            return pVar.getReactTag();
        }
        return 0;
    }
}

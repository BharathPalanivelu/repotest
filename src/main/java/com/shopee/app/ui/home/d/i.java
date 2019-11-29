package com.shopee.app.ui.home.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.garena.a.a.a.b;
import com.shopee.app.data.viewmodel.ToolTipHomeViewItem;
import com.shopee.app.ui.common.ar;
import com.shopee.app.ui.common.as;
import com.shopee.app.ui.home.c;
import com.shopee.app.ui.home.m;
import com.shopee.id.R;

public class i extends b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ar f22181a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final c f22182b;

    /* renamed from: c  reason: collision with root package name */
    private com.garena.android.appkit.b.i f22183c = b.a(this);

    public i(c cVar) {
        this.f22182b = cVar;
        this.f22183c.a();
    }

    public void a(String str, ToolTipHomeViewItem.ToolTipStyle toolTipStyle) {
        final m p = this.f22182b.p();
        if (p != null) {
            p.A = this;
            if (this.f22181a == null) {
                View inflate = LayoutInflater.from(this.f22182b).inflate(R.layout.tool_tip_mall_tab, (ViewGroup) null);
                ((TextView) inflate.findViewById(R.id.mallTooltipText)).setText(str);
                as asVar = new as(this.f22182b, p);
                asVar.a(inflate).c(com.garena.android.appkit.tools.c.a().a(25)).d(12).d(14).e(81).a(toolTipStyle.backgroundResId).b(toolTipStyle.triangleResId);
                asVar.a((View.OnClickListener) new View.OnClickListener() {
                    public void onClick(View view) {
                        if (i.this.f22181a != null) {
                            i.this.f22181a.a();
                        }
                        p.setSelectedIndex(2);
                    }
                });
                asVar.a((ar.a) new ar.a() {
                    public void a() {
                        i.this.f22182b.l.a().v.a();
                    }
                });
                this.f22181a = asVar.a();
            }
        }
    }

    public void a() {
        ar arVar = this.f22181a;
        if (arVar != null) {
            arVar.a();
        }
    }

    public void a(boolean z) {
        if (z) {
            ar arVar = this.f22181a;
            if (arVar != null) {
                arVar.b();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ToolTipHomeViewItem toolTipHomeViewItem) {
        if (!this.f22182b.F()) {
            if (toolTipHomeViewItem.isShowMallTabPopup()) {
                a(toolTipHomeViewItem.getText(), toolTipHomeViewItem.getStyle());
            } else {
                a();
            }
            m p = this.f22182b.p();
            if (p != null) {
                p.setShowMeTabBadge(toolTipHomeViewItem.isShowMeTabBadge());
            }
        }
    }

    public void b() {
        super.b();
        a();
    }

    public void f() {
        super.f();
        this.f22183c.b();
    }
}

package com.shopee.app.ui.home.d;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.garena.android.appkit.b.e;
import com.garena.android.appkit.b.g;
import com.garena.android.appkit.b.i;
import com.shopee.app.data.viewmodel.ToolTipHomeViewItem;

public final class j implements i {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final i f22187a;

    /* renamed from: b  reason: collision with root package name */
    private final g f22188b = new g() {
        public void onEvent(a aVar) {
            j.this.f22187a.a((ToolTipHomeViewItem) aVar.data);
        }
    };

    public void c() {
    }

    public void d() {
    }

    public j(i iVar) {
        this.f22187a = iVar;
    }

    public void a() {
        b.a("TOOL_TIP_HOME_VIEW", (e) this.f22188b, b.a.NETWORK_BUS);
    }

    public void b() {
        b.b("TOOL_TIP_HOME_VIEW", this.f22188b, b.a.NETWORK_BUS);
    }
}

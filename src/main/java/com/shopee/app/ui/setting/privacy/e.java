package com.shopee.app.ui.setting.privacy;

import android.content.Context;
import android.view.View;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean k = false;
    private final c l = new c();

    public e(Context context) {
        super(context);
        d();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.privacy_setting_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void d() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25328d = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.private_activity);
        this.f25329e = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.private_likes);
        this.f25330f = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.access_to_contacts);
        this.f25331g = (com.shopee.app.ui.setting.cell.a) aVar.internalFindViewById(R.id.invisible_to_contacts);
        a();
    }
}

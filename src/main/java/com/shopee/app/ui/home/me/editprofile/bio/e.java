package com.shopee.app.ui.home.me.editprofile.bio;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.shopee.app.ui.common.RobotoClearableEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean h = false;
    private final c i = new c();

    public e(Context context, String str, int i2, int i3, int i4, int i5) {
        super(context, str, i2, i3, i4, i5);
        e();
    }

    public static d a(Context context, String str, int i2, int i3, int i4, int i5) {
        e eVar = new e(context, str, i2, i3, i4, i5);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.sp_edit_bio_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void e() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f22339a = (RobotoClearableEditText) aVar.internalFindViewById(R.id.text);
        this.f22340b = (TextView) aVar.internalFindViewById(R.id.hint);
        a();
    }
}

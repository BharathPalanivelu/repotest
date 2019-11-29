package com.shopee.app.ui.auth.signup.email;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean k = false;
    private final c l = new c();

    public e(Context context) {
        super(context);
        h();
    }

    public static d a(Context context) {
        e eVar = new e(context);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.k) {
            this.k = true;
            inflate(getContext(), R.layout.signup_email_captcha_layout, this);
            this.l.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.l);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19847g = (MaterialEditText) aVar.internalFindViewById(R.id.email);
        this.h = (MaterialEditText) aVar.internalFindViewById(R.id.captcha);
        this.i = (ImageView) aVar.internalFindViewById(R.id.captcha_image);
        this.j = (Button) aVar.internalFindViewById(R.id.continue_btn);
        a();
    }
}

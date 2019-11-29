package com.shopee.app.ui.auth.signup.thirdparty;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean q = false;
    private final c r = new c();

    public e(Context context, c cVar, String str, String str2, String str3) {
        super(context, cVar, str, str2, str3);
        c();
    }

    public static d a(Context context, c cVar, String str, String str2, String str3) {
        e eVar = new e(context, cVar, str, str2, str3);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.q) {
            this.q = true;
            inflate(getContext(), R.layout.facebook_registration_view, this);
            this.r.a((a) this);
        }
        super.onFinishInflate();
    }

    private void c() {
        c a2 = c.a(this.r);
        c.a((b) this);
        this.i = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19939d = (ImageView) aVar.internalFindViewById(R.id.profile_avatar);
        this.f19940e = (MaterialEditText) aVar.internalFindViewById(R.id.phone);
        this.f19941f = (EditText) aVar.internalFindViewById(R.id.user_name);
        this.f19942g = (MaterialEditText) aVar.internalFindViewById(R.id.email);
        this.h = (TextView) aVar.internalFindViewById(R.id.terms_label);
        this.j = (Button) aVar.internalFindViewById(R.id.done_btn);
        View internalFindViewById = aVar.internalFindViewById(R.id.profile_image);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b();
                }
            });
        }
        a();
    }
}

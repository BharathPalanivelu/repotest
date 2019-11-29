package com.shopee.app.ui.auth.signup.phone;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class e extends d implements a, b {
    private boolean p = false;
    private final c q = new c();

    public e(Context context, String str, String str2) {
        super(context, str, str2);
        h();
    }

    public static d a(Context context, String str, String str2) {
        e eVar = new e(context, str, str2);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.p) {
            this.p = true;
            inflate(getContext(), R.layout.phone_detail_layout, this);
            this.q.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.q);
        c.a((b) this);
        this.f19913g = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19907a = (MaterialEditText) aVar.internalFindViewById(R.id.username);
        this.f19908b = (MaterialEditText) aVar.internalFindViewById(R.id.phone_number);
        this.f19909c = (MaterialEditText) aVar.internalFindViewById(R.id.password);
        this.f19910d = (MaterialEditText) aVar.internalFindViewById(R.id.password_confirm);
        this.f19911e = (TextView) aVar.internalFindViewById(R.id.terms_label);
        this.f19912f = (ImageView) aVar.internalFindViewById(R.id.profile_avatar);
        View internalFindViewById = aVar.internalFindViewById(R.id.profile_image);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.continue_btn);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.c();
                }
            });
        }
        a();
    }
}

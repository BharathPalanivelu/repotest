package com.shopee.app.ui.auth.signup.email;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean r = false;
    private final c s = new c();

    public k(Context context, String str, String str2) {
        super(context, str, str2);
        h();
    }

    public static j a(Context context, String str, String str2) {
        k kVar = new k(context, str, str2);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.r) {
            this.r = true;
            inflate(getContext(), R.layout.signup_email_layout, this);
            this.s.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.s);
        c.a((b) this);
        this.f19874g = androidx.core.content.b.c(getContext(), R.color.primary);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19868a = (MaterialEditText) aVar.internalFindViewById(R.id.username);
        this.f19869b = (MaterialEditText) aVar.internalFindViewById(R.id.email);
        this.f19870c = (MaterialEditText) aVar.internalFindViewById(R.id.password);
        this.f19871d = (MaterialEditText) aVar.internalFindViewById(R.id.password_confirm);
        this.f19872e = (TextView) aVar.internalFindViewById(R.id.terms_label);
        this.f19873f = (ImageView) aVar.internalFindViewById(R.id.profile_avatar);
        this.m = (Button) aVar.internalFindViewById(R.id.continue_btn);
        View internalFindViewById = aVar.internalFindViewById(R.id.profile_image);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.b();
                }
            });
        }
        if (this.f19869b != null) {
            this.f19869b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    k.this.a(view, z);
                }
            });
        }
        a();
    }
}

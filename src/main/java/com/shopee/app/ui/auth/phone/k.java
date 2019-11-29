package com.shopee.app.ui.auth.phone;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class k extends j implements a, b {
    private boolean o = false;
    private final c p = new c();

    public k(Context context, String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, int i4) {
        super(context, str, i, i2, i3, str2, str3, str4, str5, z, z2, str6, i4);
        m();
    }

    public static j a(Context context, String str, int i, int i2, int i3, String str2, String str3, String str4, String str5, boolean z, boolean z2, String str6, int i4) {
        k kVar = new k(context, str, i, i2, i3, str2, str3, str4, str5, z, z2, str6, i4);
        kVar.onFinishInflate();
        return kVar;
    }

    public void onFinishInflate() {
        if (!this.o) {
            this.o = true;
            inflate(getContext(), R.layout.phone_verify_layout, this);
            this.p.a((a) this);
        }
        super.onFinishInflate();
    }

    private void m() {
        c a2 = c.a(this.p);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19743a = (MaterialEditText) aVar.internalFindViewById(R.id.verification_code);
        this.f19744b = (TextView) aVar.internalFindViewById(R.id.tipView);
        this.f19745c = (Button) aVar.internalFindViewById(R.id.resend_btn);
        this.f19746d = aVar.internalFindViewById(R.id.group_mobile_change);
        this.k = (Button) aVar.internalFindViewById(R.id.continue_btn);
        View internalFindViewById = aVar.internalFindViewById(R.id.help_btn);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.mobile_change_btn);
        if (this.f19745c != null) {
            this.f19745c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.g();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.h();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    k.this.i();
                }
            });
        }
        a();
    }
}

package com.shopee.app.ui.auth;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class n extends m implements a, b {
    private boolean r = false;
    private final c s = new c();

    public n(Context context, String str, String str2, g gVar, k kVar) {
        super(context, str, str2, gVar, kVar);
        q();
    }

    public static m a(Context context, String str, String str2, g gVar, k kVar) {
        n nVar = new n(context, str, str2, gVar, kVar);
        nVar.onFinishInflate();
        return nVar;
    }

    public void onFinishInflate() {
        if (!this.r) {
            this.r = true;
            inflate(getContext(), R.layout.login_tab_layout, this);
            this.s.a((a) this);
        }
        super.onFinishInflate();
    }

    private void q() {
        c a2 = c.a(this.s);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19563b = (MaterialEditText) aVar.internalFindViewById(R.id.login_id);
        this.f19564c = (MaterialEditText) aVar.internalFindViewById(R.id.password);
        this.f19565d = aVar.internalFindViewById(R.id.facebook_btn);
        this.f19566e = (Button) aVar.internalFindViewById(R.id.qa_login_btn);
        this.f19567f = aVar.internalFindViewById(R.id.line_panel);
        View internalFindViewById = aVar.internalFindViewById(R.id.login_btn);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.forgot_password_btn);
        View internalFindViewById3 = aVar.internalFindViewById(R.id.line_btn);
        View internalFindViewById4 = aVar.internalFindViewById(R.id.sms_btn);
        View internalFindViewById5 = aVar.internalFindViewById(R.id.help_btn);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.e();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.h();
                }
            });
        }
        if (internalFindViewById3 != null) {
            internalFindViewById3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.i();
                }
            });
        }
        if (this.f19565d != null) {
            this.f19565d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.j();
                }
            });
        }
        if (internalFindViewById4 != null) {
            internalFindViewById4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.k();
                }
            });
        }
        if (internalFindViewById5 != null) {
            internalFindViewById5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.l();
                }
            });
        }
        if (this.f19566e != null) {
            this.f19566e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    n.this.m();
                }
            });
        }
        if (this.f19563b != null) {
            this.f19563b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View view, boolean z) {
                    n.this.a(view, z);
                }
            });
        }
        d();
    }
}

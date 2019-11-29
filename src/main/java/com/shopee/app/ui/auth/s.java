package com.shopee.app.ui.auth;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class s extends r implements a, b {
    private boolean r = false;
    private final c s = new c();

    public s(Context context, String str, g gVar, k kVar) {
        super(context, str, gVar, kVar);
        n();
    }

    public static r a(Context context, String str, g gVar, k kVar) {
        s sVar = new s(context, str, gVar, kVar);
        sVar.onFinishInflate();
        return sVar;
    }

    public void onFinishInflate() {
        if (!this.r) {
            this.r = true;
            inflate(getContext(), R.layout.signup_tab_layout, this);
            this.s.a((a) this);
        }
        super.onFinishInflate();
    }

    private void n() {
        c a2 = c.a(this.s);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19769b = (MaterialEditText) aVar.internalFindViewById(R.id.phone_number);
        this.f19770c = (TextView) aVar.internalFindViewById(R.id.signup_btn);
        this.f19771d = aVar.internalFindViewById(R.id.continue_btn);
        this.f19772e = aVar.internalFindViewById(R.id.line_panel);
        View internalFindViewById = aVar.internalFindViewById(R.id.facebook_btn);
        View internalFindViewById2 = aVar.internalFindViewById(R.id.line_btn);
        if (this.f19771d != null) {
            this.f19771d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    s.this.e();
                }
            });
        }
        if (this.f19770c != null) {
            this.f19770c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    s.this.f();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    s.this.l();
                }
            });
        }
        if (internalFindViewById2 != null) {
            internalFindViewById2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    s.this.m();
                }
            });
        }
        TextView textView = (TextView) aVar.internalFindViewById(R.id.phone_number);
        if (textView != null) {
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    s.this.a(editable);
                }
            });
        }
        d();
    }
}

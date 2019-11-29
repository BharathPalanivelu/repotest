package com.shopee.app.ui.auth.password;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class p extends o implements a, b {
    private boolean h = false;
    private final c i = new c();

    public p(Context context, String str) {
        super(context, str);
        i();
    }

    public static o a(Context context, String str) {
        p pVar = new p(context, str);
        pVar.onFinishInflate();
        return pVar;
    }

    public void onFinishInflate() {
        if (!this.h) {
            this.h = true;
            inflate(getContext(), R.layout.reset_password_view_layout, this);
            this.i.a((a) this);
        }
        super.onFinishInflate();
    }

    private void i() {
        c a2 = c.a(this.i);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i2) {
        return findViewById(i2);
    }

    public void onViewChanged(a aVar) {
        this.f19640a = (MaterialEditText) aVar.internalFindViewById(R.id.login_id);
        this.f19641b = (Button) aVar.internalFindViewById(R.id.continue_btn);
        View internalFindViewById = aVar.internalFindViewById(R.id.forgot_mobile_number_btn);
        if (this.f19641b != null) {
            this.f19641b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    p.this.e();
                }
            });
        }
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    p.this.f();
                }
            });
        }
        final TextView textView = (TextView) aVar.internalFindViewById(R.id.login_id);
        if (textView != null) {
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    p.this.a(textView, editable);
                }
            });
        }
        a();
    }
}

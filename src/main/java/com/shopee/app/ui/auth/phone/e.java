package com.shopee.app.ui.auth.phone;

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

public final class e extends d implements a, b {
    private boolean j = false;
    private final c k = new c();

    public e(Context context, int i, int i2, int i3, String str, String str2) {
        super(context, i, i2, i3, str, str2);
        h();
    }

    public static d a(Context context, int i, int i2, int i3, String str, String str2) {
        e eVar = new e(context, i, i2, i3, str, str2);
        eVar.onFinishInflate();
        return eVar;
    }

    public void onFinishInflate() {
        if (!this.j) {
            this.j = true;
            inflate(getContext(), R.layout.ask_phone_layout, this);
            this.k.a((a) this);
        }
        super.onFinishInflate();
    }

    private void h() {
        c a2 = c.a(this.k);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f19704a = (MaterialEditText) aVar.internalFindViewById(R.id.phone_number);
        this.f19705b = (TextView) aVar.internalFindViewById(R.id.tipView);
        View internalFindViewById = aVar.internalFindViewById(R.id.continue_btn);
        if (internalFindViewById != null) {
            internalFindViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    e.this.b();
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
                    e.this.a(editable);
                }
            });
        }
        a();
    }
}

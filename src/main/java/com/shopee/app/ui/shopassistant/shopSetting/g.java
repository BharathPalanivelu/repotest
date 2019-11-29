package com.shopee.app.ui.shopassistant.shopSetting;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.shopee.id.R;
import org.a.a.b.a;
import org.a.a.b.b;
import org.a.a.b.c;

public final class g extends f implements a, b {

    /* renamed from: g  reason: collision with root package name */
    private boolean f25577g = false;
    private final c h = new c();

    public g(Context context, String str) {
        super(context, str);
        g();
    }

    public static f a(Context context, String str) {
        g gVar = new g(context, str);
        gVar.onFinishInflate();
        return gVar;
    }

    public void onFinishInflate() {
        if (!this.f25577g) {
            this.f25577g = true;
            inflate(getContext(), R.layout.auto_reply_layout, this);
            this.h.a((a) this);
        }
        super.onFinishInflate();
    }

    private void g() {
        c a2 = c.a(this.h);
        c.a((b) this);
        c.a(a2);
    }

    public <T extends View> T internalFindViewById(int i) {
        return findViewById(i);
    }

    public void onViewChanged(a aVar) {
        this.f25564a = (EditText) aVar.internalFindViewById(R.id.auto_reply_text);
        final TextView textView = (TextView) aVar.internalFindViewById(R.id.auto_reply_text);
        if (textView != null) {
            textView.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    g.this.a(textView);
                }
            });
        }
        a();
    }
}

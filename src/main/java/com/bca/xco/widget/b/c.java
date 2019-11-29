package com.bca.xco.widget.b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class c implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f4692a;

    /* renamed from: b  reason: collision with root package name */
    private final a f4693b;

    public interface a {
        void a(EditText editText, String str);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public c(EditText editText, a aVar) {
        this.f4692a = editText;
        this.f4693b = aVar;
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f4693b.a(this.f4692a, charSequence.toString());
    }
}

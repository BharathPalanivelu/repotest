package com.shopee.app.ui.product.add.wholesale;

import android.view.View;
import android.widget.EditText;

public class b {
    public static View.OnFocusChangeListener a() {
        return new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z && (view instanceof EditText)) {
                    EditText editText = (EditText) view;
                    editText.setText(b.a(editText.getText().toString()));
                }
            }
        };
    }

    public static String a(String str) {
        try {
            return String.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return str;
        }
    }
}

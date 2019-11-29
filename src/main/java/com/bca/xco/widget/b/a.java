package com.bca.xco.widget.b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class a implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final String f4684a = "#### #### #### ####";

    /* renamed from: b  reason: collision with root package name */
    private boolean f4685b;

    /* renamed from: c  reason: collision with root package name */
    private String f4686c = "";

    /* renamed from: d  reason: collision with root package name */
    private EditText f4687d;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public a(EditText editText) {
        this.f4687d = editText;
    }

    public static String a(String str) {
        return str.replaceAll("[^0-9]*", "");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String a2 = a(charSequence.toString());
        if (this.f4685b) {
            this.f4686c = a2;
            this.f4685b = false;
            return;
        }
        String str = "";
        int i4 = 0;
        for (char c2 : "#### #### #### ####".toCharArray()) {
            if ((c2 == '#' || a2.length() <= this.f4686c.length()) && (c2 == '#' || a2.length() >= this.f4686c.length() || a2.length() == i4)) {
                try {
                    str = str + a2.charAt(i4);
                    i4++;
                } catch (Exception unused) {
                }
            } else {
                str = str + c2;
            }
        }
        this.f4685b = true;
        this.f4687d.setText(str);
        this.f4687d.setSelection(str.length());
    }
}

package com.bca.xco.widget.b;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class b implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private String[] f4688a = {"#.###", "##.###", "###.###", "#.###.###", "##.###.###", "###.###.###", "#.###.###.###", "##.###.###.###", "###.###.###.###", "#.###.###.###.###"};

    /* renamed from: b  reason: collision with root package name */
    private boolean f4689b;

    /* renamed from: c  reason: collision with root package name */
    private String f4690c = "";

    /* renamed from: d  reason: collision with root package name */
    private EditText f4691d;

    private static String b(String str) {
        return "###";
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public b(EditText editText) {
        this.f4691d = editText;
    }

    public static String a(String str) {
        return str.replaceAll("[^0-9]*", "");
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        String a2 = a(charSequence.toString());
        String b2 = b(a2);
        if (a2.length() >= 4) {
            b2 = this.f4688a[a2.length() - 4];
        }
        if (this.f4689b) {
            this.f4690c = a2;
            this.f4689b = false;
            return;
        }
        String str = "";
        int i4 = 0;
        for (char c2 : b2.toCharArray()) {
            if ((c2 == '#' || a2.length() <= this.f4690c.length()) && (c2 == '#' || a2.length() >= this.f4690c.length() || a2.length() == i4)) {
                try {
                    str = str + a2.charAt(i4);
                    i4++;
                } catch (Exception unused) {
                }
            } else {
                str = str + c2;
            }
        }
        this.f4689b = true;
        this.f4691d.setText(str);
        this.f4691d.setSelection(str.length());
    }
}

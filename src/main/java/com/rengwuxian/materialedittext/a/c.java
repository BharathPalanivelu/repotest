package com.rengwuxian.materialedittext.a;

import java.util.regex.Pattern;

public class c extends b {

    /* renamed from: b  reason: collision with root package name */
    private Pattern f15723b;

    public c(String str, String str2) {
        super(str);
        this.f15723b = Pattern.compile(str2);
    }

    public boolean a(CharSequence charSequence, boolean z) {
        return this.f15723b.matcher(charSequence).matches();
    }
}

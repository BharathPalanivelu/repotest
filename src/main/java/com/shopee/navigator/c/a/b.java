package com.shopee.navigator.c.a;

import com.shopee.navigator.c.a;
import java.util.regex.Pattern;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private Pattern f30126a;

    public b(String str) {
        this.f30126a = Pattern.compile(str);
    }

    public boolean a(a aVar) {
        return this.f30126a.matcher(aVar.a()).matches();
    }
}

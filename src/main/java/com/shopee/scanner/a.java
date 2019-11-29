package com.shopee.scanner;

import com.yanzhenjie.zbar.Symbol;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f30272a;

    /* renamed from: b  reason: collision with root package name */
    private String f30273b;

    static a a(Symbol symbol) {
        return new a(symbol.getType() == 64 ? 2 : 1, symbol.getData());
    }

    private a(int i, String str) {
        this.f30272a = i;
        this.f30273b = str;
    }

    public int a() {
        return this.f30272a;
    }

    public String b() {
        return this.f30273b;
    }

    public String toString() {
        return "Code{type=" + this.f30272a + ", value=" + this.f30273b + "}";
    }
}

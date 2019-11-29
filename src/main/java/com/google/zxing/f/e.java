package com.google.zxing.f;

import java.util.Map;

public final class e extends k {

    /* renamed from: a  reason: collision with root package name */
    private final String f14719a;

    /* renamed from: b  reason: collision with root package name */
    private final String f14720b;

    /* renamed from: c  reason: collision with root package name */
    private final String f14721c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14722d;

    /* renamed from: e  reason: collision with root package name */
    private final String f14723e;

    /* renamed from: f  reason: collision with root package name */
    private final String f14724f;

    /* renamed from: g  reason: collision with root package name */
    private final String f14725g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final String m;
    private final String n;
    private final Map<String, String> o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(l.PRODUCT);
        this.f14719a = str;
        this.f14720b = str2;
        this.f14721c = str3;
        this.f14722d = str4;
        this.f14723e = str5;
        this.f14724f = str6;
        this.f14725g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
        this.k = str11;
        this.l = str12;
        this.m = str13;
        this.n = str14;
        this.o = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (!a(this.f14720b, eVar.f14720b) || !a(this.f14721c, eVar.f14721c) || !a(this.f14722d, eVar.f14722d) || !a(this.f14723e, eVar.f14723e) || !a(this.f14725g, eVar.f14725g) || !a(this.h, eVar.h) || !a(this.i, eVar.i) || !a(this.j, eVar.j) || !a(this.k, eVar.k) || !a(this.l, eVar.l) || !a(this.m, eVar.m) || !a(this.n, eVar.n) || !a(this.o, eVar.o)) {
            return false;
        }
        return true;
    }

    private static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public int hashCode() {
        return ((((((((((((a(this.f14720b) ^ 0) ^ a(this.f14721c)) ^ a(this.f14722d)) ^ a(this.f14723e)) ^ a(this.f14725g)) ^ a(this.h)) ^ a(this.i)) ^ a(this.j)) ^ a(this.k)) ^ a(this.l)) ^ a(this.m)) ^ a(this.n)) ^ a(this.o);
    }

    private static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String a() {
        return String.valueOf(this.f14719a);
    }
}

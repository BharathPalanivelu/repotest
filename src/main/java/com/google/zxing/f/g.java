package com.google.zxing.f;

public final class g extends k {

    /* renamed from: a  reason: collision with root package name */
    private final double f14726a;

    /* renamed from: b  reason: collision with root package name */
    private final double f14727b;

    /* renamed from: c  reason: collision with root package name */
    private final double f14728c;

    /* renamed from: d  reason: collision with root package name */
    private final String f14729d;

    g(double d2, double d3, double d4, String str) {
        super(l.GEO);
        this.f14726a = d2;
        this.f14727b = d3;
        this.f14728c = d4;
        this.f14729d = str;
    }

    public String a() {
        StringBuilder sb = new StringBuilder(20);
        sb.append(this.f14726a);
        sb.append(", ");
        sb.append(this.f14727b);
        if (this.f14728c > 0.0d) {
            sb.append(", ");
            sb.append(this.f14728c);
            sb.append('m');
        }
        if (this.f14729d != null) {
            sb.append(" (");
            sb.append(this.f14729d);
            sb.append(')');
        }
        return sb.toString();
    }
}

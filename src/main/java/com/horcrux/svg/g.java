package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.ViewProps;
import com.horcrux.svg.z;

class g {
    static final g m = new g();

    /* renamed from: a  reason: collision with root package name */
    final double f14841a;

    /* renamed from: b  reason: collision with root package name */
    final String f14842b;

    /* renamed from: c  reason: collision with root package name */
    final z.b f14843c;

    /* renamed from: d  reason: collision with root package name */
    final ReadableMap f14844d;

    /* renamed from: e  reason: collision with root package name */
    final z.d f14845e;

    /* renamed from: f  reason: collision with root package name */
    final String f14846f;

    /* renamed from: g  reason: collision with root package name */
    final z.c f14847g;
    final z.e h;
    final double i;
    final double j;
    final double k;
    final boolean l;
    private final z.f n;

    private g() {
        this.f14844d = null;
        this.f14842b = "";
        this.f14843c = z.b.normal;
        this.f14845e = z.d.Normal;
        this.f14846f = "";
        this.f14847g = z.c.normal;
        this.h = z.e.start;
        this.n = z.f.None;
        this.l = false;
        this.i = 0.0d;
        this.f14841a = 12.0d;
        this.j = 0.0d;
        this.k = 0.0d;
    }

    private double a(String str, double d2, double d3) {
        return q.a(str, 0.0d, d2, d3);
    }

    g(ReadableMap readableMap, g gVar, double d2) {
        double d3 = gVar.f14841a;
        if (!readableMap.hasKey(ViewProps.FONT_SIZE)) {
            this.f14841a = d3;
        } else if (readableMap.getType(ViewProps.FONT_SIZE) == ReadableType.Number) {
            this.f14841a = readableMap.getDouble(ViewProps.FONT_SIZE);
        } else {
            this.f14841a = q.a(readableMap.getString(ViewProps.FONT_SIZE), d3, 1.0d, d3);
        }
        this.f14844d = readableMap.hasKey("fontData") ? readableMap.getMap("fontData") : gVar.f14844d;
        this.f14842b = readableMap.hasKey(ViewProps.FONT_FAMILY) ? readableMap.getString(ViewProps.FONT_FAMILY) : gVar.f14842b;
        this.f14843c = readableMap.hasKey(ViewProps.FONT_STYLE) ? z.b.valueOf(readableMap.getString(ViewProps.FONT_STYLE)) : gVar.f14843c;
        this.f14845e = readableMap.hasKey(ViewProps.FONT_WEIGHT) ? z.d.a(readableMap.getString(ViewProps.FONT_WEIGHT)) : gVar.f14845e;
        this.f14846f = readableMap.hasKey("fontFeatureSettings") ? readableMap.getString("fontFeatureSettings") : gVar.f14846f;
        this.f14847g = readableMap.hasKey("fontVariantLigatures") ? z.c.valueOf(readableMap.getString("fontVariantLigatures")) : gVar.f14847g;
        this.h = readableMap.hasKey("textAnchor") ? z.e.valueOf(readableMap.getString("textAnchor")) : gVar.h;
        this.n = readableMap.hasKey("textDecoration") ? z.f.a(readableMap.getString("textDecoration")) : gVar.n;
        boolean hasKey = readableMap.hasKey("kerning");
        this.l = hasKey || gVar.l;
        this.i = hasKey ? a(readableMap.getString("kerning"), d2, this.f14841a) : gVar.i;
        this.j = readableMap.hasKey("wordSpacing") ? a(readableMap.getString("wordSpacing"), d2, this.f14841a) : gVar.j;
        this.k = readableMap.hasKey(ViewProps.LETTER_SPACING) ? a(readableMap.getString(ViewProps.LETTER_SPACING), d2, this.f14841a) : gVar.k;
    }
}

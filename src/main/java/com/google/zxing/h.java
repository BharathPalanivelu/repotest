package com.google.zxing;

import java.util.Collection;
import java.util.EnumSet;
import java.util.regex.Pattern;

final class h {

    /* renamed from: a  reason: collision with root package name */
    static final Collection<c> f14757a = EnumSet.of(c.UPC_A, new c[]{c.UPC_E, c.EAN_13, c.EAN_8, c.RSS_14, c.RSS_EXPANDED});

    /* renamed from: b  reason: collision with root package name */
    static final Collection<c> f14758b = EnumSet.of(c.CODE_39, c.CODE_93, c.CODE_128, c.ITF, c.CODABAR);

    /* renamed from: c  reason: collision with root package name */
    static final Collection<c> f14759c = EnumSet.of(c.QR_CODE);

    /* renamed from: d  reason: collision with root package name */
    static final Collection<c> f14760d = EnumSet.of(c.DATA_MATRIX);

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f14761e = Pattern.compile(",");

    static {
        f14758b.addAll(f14757a);
    }
}

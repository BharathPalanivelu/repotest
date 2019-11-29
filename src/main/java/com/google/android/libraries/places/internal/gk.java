package com.google.android.libraries.places.internal;

import com.tencent.qcloud.core.util.IOUtils;

public final class gk extends gj {

    /* renamed from: a  reason: collision with root package name */
    private final char f12625a;

    public gk(char c2) {
        super((byte) 0);
        this.f12625a = c2;
    }

    public final boolean a(char c2) {
        return c2 == this.f12625a;
    }

    public final String toString() {
        char c2 = this.f12625a;
        char[] cArr = {IOUtils.DIR_SEPARATOR_WINDOWS, 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        String copyValueOf = String.copyValueOf(cArr);
        StringBuilder sb = new StringBuilder(String.valueOf(copyValueOf).length() + 18);
        sb.append("CharMatcher.is('");
        sb.append(copyValueOf);
        sb.append("')");
        return sb.toString();
    }
}

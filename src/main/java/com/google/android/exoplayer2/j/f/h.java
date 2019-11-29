package com.google.android.exoplayer2.j.f;

import com.google.android.exoplayer2.j.f;
import com.google.android.exoplayer2.n.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10614a = Pattern.compile("^NOTE(( |\t).*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f10615b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void a(k kVar) throws f {
        String y = kVar.y();
        if (y == null || !f10615b.matcher(y).matches()) {
            throw new f("Expected WEBVTT. Got " + y);
        }
    }

    public static long a(String str) throws NumberFormatException {
        String[] split = str.split("\\.", 2);
        long j = 0;
        for (String parseLong : split[0].split(":")) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        return ((j * 1000) + Long.parseLong(split[1])) * 1000;
    }

    public static float b(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static Matcher b(k kVar) {
        String y;
        while (true) {
            String y2 = kVar.y();
            if (y2 == null) {
                return null;
            }
            if (f10614a.matcher(y2).matches()) {
                do {
                    y = kVar.y();
                    if (y == null) {
                        break;
                    }
                } while (!y.isEmpty());
            } else {
                Matcher matcher = f.f10599a.matcher(y2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}

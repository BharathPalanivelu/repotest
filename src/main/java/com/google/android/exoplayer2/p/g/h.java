package com.google.android.exoplayer2.p.g;

import com.google.android.exoplayer2.p.g;
import com.google.android.exoplayer2.s.l;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11219a = Pattern.compile("^NOTE(( |\t).*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f11220b = Pattern.compile("^﻿?WEBVTT(( |\t).*)?$");

    public static void a(l lVar) throws g {
        String y = lVar.y();
        if (y == null || !f11220b.matcher(y).matches()) {
            throw new g("Expected WEBVTT. Got " + y);
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

    public static Matcher b(l lVar) {
        String y;
        while (true) {
            String y2 = lVar.y();
            if (y2 == null) {
                return null;
            }
            if (f11219a.matcher(y2).matches()) {
                do {
                    y = lVar.y();
                    if (y == null) {
                        break;
                    }
                } while (!y.isEmpty());
            } else {
                Matcher matcher = f.f11204a.matcher(y2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}

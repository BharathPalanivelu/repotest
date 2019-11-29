package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.b.e;
import com.google.android.exoplayer2.f.b.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public static final g.a f9768a = new g.a() {
        public boolean a(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f9769d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: b  reason: collision with root package name */
    public int f9770b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f9771c = -1;

    public boolean a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f9770b = i2;
        this.f9771c = i3;
        return true;
    }

    public boolean a(a aVar) {
        for (int i = 0; i < aVar.a(); i++) {
            a.C0166a a2 = aVar.a(i);
            if (a2 instanceof e) {
                e eVar = (e) a2;
                if (a(eVar.f9808b, eVar.f9809c)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean a(String str, String str2) {
        if (!"iTunSMPB".equals(str)) {
            return false;
        }
        Matcher matcher = f9769d.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f9770b = parseInt;
                    this.f9771c = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public boolean a() {
        return (this.f9770b == -1 || this.f9771c == -1) ? false : true;
    }
}

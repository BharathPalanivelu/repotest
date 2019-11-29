package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final a.C0178a f10405a = new a.C0178a() {
        public boolean a(int i, int i2, int i3, int i4, int i5) {
            return i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f10406d = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* renamed from: b  reason: collision with root package name */
    public int f10407b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f10408c = -1;

    public boolean a(int i) {
        int i2 = i >> 12;
        int i3 = i & 4095;
        if (i2 <= 0 && i3 <= 0) {
            return false;
        }
        this.f10407b = i2;
        this.f10408c = i3;
        return true;
    }

    public boolean a(Metadata metadata) {
        for (int i = 0; i < metadata.a(); i++) {
            Metadata.Entry a2 = metadata.a(i);
            if (a2 instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) a2;
                if (a(commentFrame.f10867b, commentFrame.f10868c)) {
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
        Matcher matcher = f10406d.matcher(str2);
        if (matcher.find()) {
            try {
                int parseInt = Integer.parseInt(matcher.group(1), 16);
                int parseInt2 = Integer.parseInt(matcher.group(2), 16);
                if (parseInt > 0 || parseInt2 > 0) {
                    this.f10407b = parseInt;
                    this.f10408c = parseInt2;
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    public boolean a() {
        return (this.f10407b == -1 || this.f10408c == -1) ? false : true;
    }
}

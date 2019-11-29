package com.google.android.exoplayer2.p.d;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.c;
import com.google.android.exoplayer2.s.g;
import com.google.android.exoplayer2.s.l;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11134a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f11135b = new StringBuilder();

    public a() {
        super("SubripDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        while (true) {
            String y = lVar.y();
            if (y == null) {
                b[] bVarArr = new b[arrayList.size()];
                arrayList.toArray(bVarArr);
                return new b(bVarArr, gVar.b());
            } else if (y.length() != 0) {
                try {
                    Integer.parseInt(y);
                    String y2 = lVar.y();
                    Matcher matcher = f11134a.matcher(y2);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        gVar.a(a(matcher, 1));
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            gVar.a(a(matcher, 6));
                        } else {
                            z2 = false;
                        }
                        this.f11135b.setLength(0);
                        while (true) {
                            String y3 = lVar.y();
                            if (TextUtils.isEmpty(y3)) {
                                break;
                            }
                            if (this.f11135b.length() > 0) {
                                this.f11135b.append("<br>");
                            }
                            this.f11135b.append(y3.trim());
                        }
                        arrayList.add(new b(Html.fromHtml(this.f11135b.toString())));
                        if (z2) {
                            arrayList.add((Object) null);
                        }
                    } else {
                        Log.w("SubripDecoder", "Skipping invalid timing: " + y2);
                    }
                } catch (NumberFormatException unused) {
                    Log.w("SubripDecoder", "Skipping invalid index: " + y);
                }
            }
        }
    }

    private static long a(Matcher matcher, int i) {
        return ((Long.parseLong(matcher.group(i + 1)) * 60 * 60 * 1000) + (Long.parseLong(matcher.group(i + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i + 3)) * 1000) + Long.parseLong(matcher.group(i + 4))) * 1000;
    }
}

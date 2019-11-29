package com.google.android.exoplayer2.j.c;

import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.j.b;
import com.google.android.exoplayer2.n.f;
import com.google.android.exoplayer2.n.k;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f10529a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+),(\\d+))?\\s*");

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f10530b = new StringBuilder();

    public a() {
        super("SubripDecoder");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        f fVar = new f();
        k kVar = new k(bArr, i);
        while (true) {
            String y = kVar.y();
            if (y == null) {
                com.google.android.exoplayer2.j.a[] aVarArr = new com.google.android.exoplayer2.j.a[arrayList.size()];
                arrayList.toArray(aVarArr);
                return new b(aVarArr, fVar.b());
            } else if (y.length() != 0) {
                try {
                    Integer.parseInt(y);
                    String y2 = kVar.y();
                    Matcher matcher = f10529a.matcher(y2);
                    if (matcher.matches()) {
                        boolean z2 = true;
                        fVar.a(a(matcher, 1));
                        if (!TextUtils.isEmpty(matcher.group(6))) {
                            fVar.a(a(matcher, 6));
                        } else {
                            z2 = false;
                        }
                        this.f10530b.setLength(0);
                        while (true) {
                            String y3 = kVar.y();
                            if (TextUtils.isEmpty(y3)) {
                                break;
                            }
                            if (this.f10530b.length() > 0) {
                                this.f10530b.append("<br>");
                            }
                            this.f10530b.append(y3.trim());
                        }
                        arrayList.add(new com.google.android.exoplayer2.j.a(Html.fromHtml(this.f10530b.toString())));
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

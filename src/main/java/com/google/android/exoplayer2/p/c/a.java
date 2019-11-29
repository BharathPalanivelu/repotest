package com.google.android.exoplayer2.p.c;

import android.util.Log;
import com.google.android.exoplayer2.p.b;
import com.google.android.exoplayer2.p.c;
import com.google.android.exoplayer2.s.g;
import com.google.android.exoplayer2.s.l;
import com.path.android.jobqueue.JobManager;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f11125a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    private final boolean f11126b;

    /* renamed from: c  reason: collision with root package name */
    private int f11127c;

    /* renamed from: d  reason: collision with root package name */
    private int f11128d;

    /* renamed from: e  reason: collision with root package name */
    private int f11129e;

    /* renamed from: f  reason: collision with root package name */
    private int f11130f;

    public a() {
        this((List<byte[]>) null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null) {
            this.f11126b = true;
            String str = new String(list.get(0));
            com.google.android.exoplayer2.s.a.a(str.startsWith("Format: "));
            b(str);
            a(new l(list.get(1)));
            return;
        }
        this.f11126b = false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public b a(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        l lVar = new l(bArr, i);
        if (!this.f11126b) {
            a(lVar);
        }
        a(lVar, (List<b>) arrayList, gVar);
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, gVar.b());
    }

    private void a(l lVar) {
        String y;
        do {
            y = lVar.y();
            if (y == null) {
                return;
            }
        } while (!y.startsWith("[Events]"));
    }

    private void a(l lVar, List<b> list, g gVar) {
        while (true) {
            String y = lVar.y();
            if (y == null) {
                return;
            }
            if (!this.f11126b && y.startsWith("Format: ")) {
                b(y);
            } else if (y.startsWith("Dialogue: ")) {
                a(y, list, gVar);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 8
            java.lang.String r9 = r9.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r9 = android.text.TextUtils.split(r9, r0)
            int r0 = r9.length
            r8.f11127c = r0
            r0 = -1
            r8.f11128d = r0
            r8.f11129e = r0
            r8.f11130f = r0
            r1 = 0
            r2 = 0
        L_0x0018:
            int r3 = r8.f11127c
            if (r2 >= r3) goto L_0x006d
            r3 = r9[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.google.android.exoplayer2.s.v.d((java.lang.String) r3)
            int r4 = r3.hashCode()
            r5 = 100571(0x188db, float:1.4093E-40)
            r6 = 2
            r7 = 1
            if (r4 == r5) goto L_0x0050
            r5 = 3556653(0x36452d, float:4.983932E-39)
            if (r4 == r5) goto L_0x0046
            r5 = 109757538(0x68ac462, float:5.219839E-35)
            if (r4 == r5) goto L_0x003c
            goto L_0x005a
        L_0x003c:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005a
            r3 = 0
            goto L_0x005b
        L_0x0046:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005a
            r3 = 2
            goto L_0x005b
        L_0x0050:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = -1
        L_0x005b:
            if (r3 == 0) goto L_0x0068
            if (r3 == r7) goto L_0x0065
            if (r3 == r6) goto L_0x0062
            goto L_0x006a
        L_0x0062:
            r8.f11130f = r2
            goto L_0x006a
        L_0x0065:
            r8.f11129e = r2
            goto L_0x006a
        L_0x0068:
            r8.f11128d = r2
        L_0x006a:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p.c.a.b(java.lang.String):void");
    }

    private void a(String str, List<b> list, g gVar) {
        long j;
        if (this.f11127c == 0) {
            Log.w("SsaDecoder", "Skipping dialogue line before format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.f11127c);
        long a2 = a(split[this.f11128d]);
        if (a2 == -9223372036854775807L) {
            Log.w("SsaDecoder", "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.f11129e];
        if (!str2.trim().isEmpty()) {
            j = a(str2);
            if (j == -9223372036854775807L) {
                Log.w("SsaDecoder", "Skipping invalid timing: " + str);
                return;
            }
        } else {
            j = -9223372036854775807L;
        }
        list.add(new b(split[this.f11130f].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        gVar.a(a2);
        if (j != -9223372036854775807L) {
            list.add((Object) null);
            gVar.a(j);
        }
    }

    public static long a(String str) {
        Matcher matcher = f11125a.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * JobManager.NS_PER_MS) + (Long.parseLong(matcher.group(2)) * 60 * JobManager.NS_PER_MS) + (Long.parseLong(matcher.group(3)) * JobManager.NS_PER_MS) + (Long.parseLong(matcher.group(4)) * 10000);
    }
}

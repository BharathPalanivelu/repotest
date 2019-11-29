package com.tencent.qalsdk.core;

import com.tencent.qalsdk.base.CloseConnReason;
import com.tencent.qalsdk.config.a;
import com.tencent.ugc.TXRecordCommon;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public boolean f32169a = false;

    /* renamed from: b  reason: collision with root package name */
    public byte f32170b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f32171c = "";

    /* renamed from: d  reason: collision with root package name */
    private byte f32172d = 1;

    /* renamed from: e  reason: collision with root package name */
    private AtomicInteger f32173e = new AtomicInteger();

    /* renamed from: f  reason: collision with root package name */
    private long f32174f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f32175g = "socket";
    private String h;
    private int i;
    private int j = TXRecordCommon.AUDIO_SAMPLERATE_8000;
    private boolean k = false;

    public static c a(a aVar, int i2) {
        c cVar = new c();
        cVar.f32175g = "socket";
        cVar.h = aVar.f32158a;
        cVar.i = aVar.f32159b;
        cVar.f32171c = "";
        boolean z = false;
        cVar.f32172d = 0;
        cVar.f32170b = 0;
        if (aVar.f32162e > 20) {
            cVar.j = 20000;
        } else if (aVar.f32162e < 5) {
            cVar.j = 5000;
        } else {
            cVar.j = aVar.f32162e * 1000;
        }
        if (i2 == 0) {
            cVar.f32171c = "00000";
        }
        if (aVar.f32164g != 0) {
            z = true;
        }
        cVar.f32169a = z;
        return cVar;
    }

    public static c a(String str) {
        String lowerCase = str.toLowerCase();
        c cVar = new c();
        Matcher matcher = Pattern.compile("([a-zA-Z]+)://([a-zA-Z0-9.]+)(:([0-9]+))?(#([0-9_]*))?(:([0-9]+))?(:([0-9]+))?(:([0-9]+))?(:([a-zA-Z]+))?(:([a-zA-Z]+))?").matcher(lowerCase);
        if (matcher.matches()) {
            if (matcher.group(1) != null) {
                cVar.f32175g = matcher.group(1);
            }
            if (matcher.group(2) != null) {
                cVar.h = matcher.group(2);
            }
            if (matcher.group(4) != null) {
                cVar.i = Integer.parseInt(matcher.group(4));
            } else {
                cVar.i = 80;
            }
            if (matcher.group(6) != null) {
                cVar.f32171c = matcher.group(6);
            }
            if (matcher.group(8) != null) {
                cVar.f32172d = Byte.parseByte(matcher.group(8));
            }
            if (matcher.group(10) != null) {
                cVar.f32170b = Byte.parseByte(matcher.group(10));
            }
            if (matcher.group(12) != null) {
                cVar.j = Integer.parseInt(matcher.group(12)) * 1000;
            }
            if (matcher.group(14) != null) {
                cVar.k = Boolean.parseBoolean(matcher.group(14));
            }
            if (matcher.group(16) != null) {
                cVar.f32169a = Boolean.parseBoolean(matcher.group(16));
            }
            cVar.f32171c.equals("00000");
        }
        return cVar;
    }

    public final String toString() {
        return this.f32175g + "://" + this.h + ":" + this.i + "#" + this.f32171c + ":" + this.f32172d + ":" + this.f32170b + ":" + (this.j / 1000) + ":" + this.k + ":" + this.f32169a;
    }

    public final String a() {
        return this.h + ":" + this.i;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).toString().equals(toString());
    }

    public final String b() {
        return this.f32175g;
    }

    public final void b(String str) {
        this.f32175g = str;
    }

    public final String c() {
        return this.h;
    }

    public final void c(String str) {
        this.h = str;
    }

    public final int d() {
        return this.i;
    }

    public final void a(int i2) {
        this.i = i2;
    }

    public final int e() {
        return this.j;
    }

    public final void b(int i2) {
        this.j = i2;
    }

    public final void f() {
        this.f32174f = System.currentTimeMillis();
    }

    public final boolean a(CloseConnReason closeConnReason) {
        long currentTimeMillis = System.currentTimeMillis();
        if (closeConnReason == CloseConnReason.writeError || closeConnReason == CloseConnReason.readError) {
            long j2 = this.f32174f;
            if (j2 == 0 || currentTimeMillis - j2 > 600000) {
                this.f32174f = currentTimeMillis;
                this.f32173e.incrementAndGet();
            } else {
                this.f32173e.addAndGet(10);
            }
        } else if (closeConnReason == CloseConnReason.continueWaitRspTimeout) {
            this.f32173e.addAndGet(10);
        } else if (closeConnReason == CloseConnReason.closeByNetDetectFailed) {
            this.f32173e.addAndGet(20);
        } else if (closeConnReason == CloseConnReason.invalidData || closeConnReason == CloseConnReason.connFull) {
            this.f32173e.addAndGet(20);
        }
        if (this.f32173e.get() <= 19) {
            return false;
        }
        this.f32173e.set(0);
        return true;
    }

    public final void a(boolean z) {
        this.k = false;
    }
}

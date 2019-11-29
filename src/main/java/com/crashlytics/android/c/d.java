package com.crashlytics.android.c;

import android.os.Process;
import io.a.a.a.a.b.i;
import io.a.a.a.a.b.p;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

class d {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f6460a = new AtomicLong(0);

    /* renamed from: b  reason: collision with root package name */
    private static String f6461b;

    public d(p pVar) {
        byte[] bArr = new byte[10];
        a(bArr);
        b(bArr);
        c(bArr);
        String a2 = i.a(pVar.b());
        String a3 = i.a(bArr);
        f6461b = String.format(Locale.US, "%s-%s-%s-%s", new Object[]{a3.substring(0, 12), a3.substring(12, 16), a3.subSequence(16, 20), a2.substring(0, 12)}).toUpperCase(Locale.US);
    }

    private void a(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a2 = a(time / 1000);
        bArr[0] = a2[0];
        bArr[1] = a2[1];
        bArr[2] = a2[2];
        bArr[3] = a2[3];
        byte[] b2 = b(time % 1000);
        bArr[4] = b2[0];
        bArr[5] = b2[1];
    }

    private void b(byte[] bArr) {
        byte[] b2 = b(f6460a.incrementAndGet());
        bArr[6] = b2[0];
        bArr[7] = b2[1];
    }

    private void c(byte[] bArr) {
        byte[] b2 = b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b2[0];
        bArr[9] = b2[1];
    }

    private static byte[] a(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    public String toString() {
        return f6461b;
    }
}

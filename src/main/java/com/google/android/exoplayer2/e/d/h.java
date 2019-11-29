package com.google.android.exoplayer2.e.d;

import android.util.Log;
import android.util.Pair;
import com.google.android.exoplayer2.n.k;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class h {
    public static byte[] a(UUID uuid, byte[] bArr) {
        int length = bArr.length + 32;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(a.U);
        allocate.putInt(0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        allocate.putInt(bArr.length);
        allocate.put(bArr);
        return allocate.array();
    }

    public static UUID a(byte[] bArr) {
        Pair<UUID, byte[]> b2 = b(bArr);
        if (b2 == null) {
            return null;
        }
        return (UUID) b2.first;
    }

    private static Pair<UUID, byte[]> b(byte[] bArr) {
        k kVar = new k(bArr);
        if (kVar.c() < 32) {
            return null;
        }
        kVar.c(0);
        if (kVar.n() != kVar.b() + 4 || kVar.n() != a.U) {
            return null;
        }
        int a2 = a.a(kVar.n());
        if (a2 > 1) {
            Log.w("PsshAtomUtil", "Unsupported pssh version: " + a2);
            return null;
        }
        UUID uuid = new UUID(kVar.p(), kVar.p());
        if (a2 == 1) {
            kVar.d(kVar.t() * 16);
        }
        int t = kVar.t();
        if (t != kVar.b()) {
            return null;
        }
        byte[] bArr2 = new byte[t];
        kVar.a(bArr2, 0, t);
        return Pair.create(uuid, bArr2);
    }
}

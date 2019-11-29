package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class zzcl implements Serializable, Iterable<Byte> {
    public static final zzcl zzfy = new zzcv(zzdq.zzkp);
    private static final zzcr zzfz = (zzcg.zzae() ? new zzcu((zzck) null) : new zzcp((zzck) null));
    private static final Comparator<zzcl> zzgb = new zzcn();
    private int zzga = 0;

    zzcl() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzcl zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzci zzci) throws IOException;

    public abstract boolean zzal();

    public abstract byte zzk(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzl(int i);

    public static zzcl zzp(String str) {
        return new zzcv(str.getBytes(zzdq.UTF_8));
    }

    public final String zzak() {
        return size() == 0 ? "" : zza(zzdq.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzga;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzga = i;
        }
        return i;
    }

    static zzct zzm(int i) {
        return new zzct(i, (zzck) null);
    }

    /* access modifiers changed from: protected */
    public final int zzam() {
        return this.zzga;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzck(this);
    }
}

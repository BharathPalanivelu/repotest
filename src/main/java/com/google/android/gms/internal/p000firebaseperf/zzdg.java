package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzdg;
import com.google.android.gms.internal.p000firebaseperf.zzdi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdg  reason: invalid package */
public abstract class zzdg<MessageType extends zzdg<MessageType, BuilderType>, BuilderType extends zzdi<MessageType, BuilderType>> implements zzga {
    protected int zzmo = 0;

    public final zzdl zzfz() {
        try {
            zzdt zzs = zzdl.zzs(zzhh());
            zzb(zzs.zzgm());
            return zzs.zzgl();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzhh()];
            zzec zzb = zzec.zzb(bArr);
            zzb(zzb);
            zzb.zzgp();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzga() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzp(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzer.checkNotNull(iterable);
        if (iterable instanceof zzfh) {
            List<?> zzhx = ((zzfh) iterable).zzhx();
            zzfh zzfh = (zzfh) list;
            int size = list.size();
            for (Object next : zzhx) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzfh.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzfh.size() - 1; size2 >= size; size2--) {
                        zzfh.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzdl) {
                    zzfh.zzc((zzdl) next);
                } else {
                    zzfh.add((String) next);
                }
            }
        } else if (iterable instanceof zzgj) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}

package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzcd;
import com.google.android.gms.internal.icing.zzcf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzcd<MessageType extends zzcd<MessageType, BuilderType>, BuilderType extends zzcf<MessageType, BuilderType>> implements zzex {
    private static boolean zzfq = false;
    protected int zzfp = 0;

    public final zzcl zzab() {
        try {
            zzct zzm = zzcl.zzm(zzbl());
            zzb(zzm.zzap());
            return zzm.zzao();
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
            byte[] bArr = new byte[zzbl()];
            zzcy zzb = zzcy.zzb(bArr);
            zzb(zzb);
            zzb.zzas();
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
    public int zzac() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzg(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzdq.checkNotNull(iterable);
        if (iterable instanceof zzeh) {
            List<?> zzcd = ((zzeh) iterable).zzcd();
            zzeh zzeh = (zzeh) list;
            int size = list.size();
            for (Object next : zzcd) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzeh.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzeh.size() - 1; size2 >= size; size2--) {
                        zzeh.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzcl) {
                    zzeh.zzc((zzcl) next);
                } else {
                    zzeh.add((String) next);
                }
            }
        } else if (iterable instanceof zzfg) {
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

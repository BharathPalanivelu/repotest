package com.google.android.gms.internal.p000firebaseperf;

import com.google.android.gms.internal.p000firebaseperf.zzep;
import com.google.android.gms.internal.p000firebaseperf.zzep.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzep  reason: invalid package */
public abstract class zzep<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdg<MessageType, BuilderType> {
    private static Map<Object, zzep<?, ?>> zzqn = new ConcurrentHashMap();
    protected zzhi zzql = zzhi.zzjh();
    private int zzqm = -1;

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzep$zza */
    public static class zza<T extends zzep<T, ?>> extends zzdh<T> {
        private final T zzqp;

        public zza(T t) {
            this.zzqp = t;
        }
    }

    /* 'enum' modifier removed */
    /* renamed from: com.google.android.gms.internal.firebase-perf.zzep$zzc */
    public static final class zzc {
        public static final int zzqs = 1;
        public static final int zzqt = 2;
        public static final int zzqu = 3;
        public static final int zzqv = 4;
        public static final int zzqw = 5;
        public static final int zzqx = 6;
        public static final int zzqy = 7;
        private static final /* synthetic */ int[] zzqz = {zzqs, zzqt, zzqu, zzqv, zzqw, zzqx, zzqy};
        public static final int zzra = 1;
        public static final int zzrb = 2;
        private static final /* synthetic */ int[] zzrc = {zzra, zzrb};
        public static final int zzrd = 1;
        public static final int zzre = 2;
        private static final /* synthetic */ int[] zzrf = {zzrd, zzre};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzqz.clone();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzep$zzd */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzep<MessageType, BuilderType> implements zzgc {
        protected zzek<Object> zzrg = zzek.zzgz();
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzgb.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzmo != 0) {
            return this.zzmo;
        }
        this.zzmo = zzgm.zzir().zzn(this).hashCode(this);
        return this.zzmo;
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzep$zzb */
    public static abstract class zzb<MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzdi<MessageType, BuilderType> {
        private final MessageType zzqp;
        protected MessageType zzqq;
        private boolean zzqr = false;

        protected zzb(MessageType messagetype) {
            this.zzqp = messagetype;
            this.zzqq = (zzep) messagetype.zza(zzc.zzqv, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzhn() {
            if (this.zzqr) {
                MessageType messagetype = (zzep) this.zzqq.zza(zzc.zzqv, (Object) null, (Object) null);
                zza(messagetype, this.zzqq);
                this.zzqq = messagetype;
                this.zzqr = false;
            }
        }

        public final boolean isInitialized() {
            return zzep.zza(this.zzqq, false);
        }

        /* renamed from: zzho */
        public MessageType zzhq() {
            if (this.zzqr) {
                return this.zzqq;
            }
            MessageType messagetype = this.zzqq;
            zzgm.zzir().zzn(messagetype).zze(messagetype);
            this.zzqr = true;
            return this.zzqq;
        }

        /* renamed from: zzhp */
        public final MessageType zzhr() {
            MessageType messagetype = (zzep) zzhq();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhg(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzhn();
            zza(this.zzqq, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgm.zzir().zzn(messagetype).zze(messagetype, messagetype2);
        }

        public final /* synthetic */ zzdi zzgb() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzga zzhl() {
            return this.zzqp;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) ((zzep) this.zzqp).zza(zzc.zzqw, (Object) null, (Object) null);
            zzb.zza((zzep) zzhq());
            return zzb;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzep) zza(zzc.zzqx, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzgm.zzir().zzn(this).equals(this, (zzep) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzep<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzhf() {
        return (zzb) zza(zzc.zzqw, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzhg() {
        BuilderType buildertype = (zzb) zza(zzc.zzqw, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzga() {
        return this.zzqm;
    }

    /* access modifiers changed from: package-private */
    public final void zzp(int i) {
        this.zzqm = i;
    }

    public final void zzb(zzec zzec) throws IOException {
        zzgm.zzir().zzn(this).zza(this, zzee.zza(zzec));
    }

    public final int zzhh() {
        if (this.zzqm == -1) {
            this.zzqm = zzgm.zzir().zzn(this).zzm(this);
        }
        return this.zzqm;
    }

    static <T extends zzep<?, ?>> T zza(Class<T> cls) {
        T t = (zzep) zzqn.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzep) zzqn.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (zzep) ((zzep) zzhl.zzg(cls)).zza(zzc.zzqx, (Object) null, (Object) null);
            if (t != null) {
                zzqn.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzep<?, ?>> void zza(Class<T> cls, T t) {
        zzqn.put(cls, t);
    }

    protected static Object zza(zzga zzga, String str, Object[] objArr) {
        return new zzgo(zzga, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzep<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzc.zzqs, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzl = zzgm.zzir().zzn(t).zzl(t);
        if (z) {
            t.zza(zzc.zzqt, (Object) zzl ? t : null, (Object) null);
        }
        return zzl;
    }

    protected static zzev zzhi() {
        return zzes.zzhs();
    }

    protected static <E> zzex<E> zzhj() {
        return zzgl.zziq();
    }

    protected static <E> zzex<E> zza(zzex<E> zzex) {
        int size = zzex.size();
        return zzex.zzao(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzfz zzhk() {
        zzb zzb2 = (zzb) zza(zzc.zzqw, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzga zzhl() {
        return (zzep) zza(zzc.zzqx, (Object) null, (Object) null);
    }
}

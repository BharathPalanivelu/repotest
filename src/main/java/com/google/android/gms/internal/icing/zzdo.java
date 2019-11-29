package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzdo;
import com.google.android.gms.internal.icing.zzdo.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdo<MessageType extends zzdo<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzcd<MessageType, BuilderType> {
    private static Map<Object, zzdo<?, ?>> zzjv = new ConcurrentHashMap();
    protected zzgf zzjt = zzgf.zzdm();
    private int zzju = -1;

    public static class zza<T extends zzdo<T, ?>> extends zzce<T> {
        private final T zzjx;

        public zza(T t) {
            this.zzjx = t;
        }
    }

    /* 'enum' modifier removed */
    public static final class zzc {
        public static final int zzka = 1;
        public static final int zzkb = 2;
        public static final int zzkc = 3;
        public static final int zzkd = 4;
        public static final int zzke = 5;
        public static final int zzkf = 6;
        public static final int zzkg = 7;
        private static final /* synthetic */ int[] zzkh = {zzka, zzkb, zzkc, zzkd, zzke, zzkf, zzkg};
        public static final int zzki = 1;
        public static final int zzkj = 2;
        private static final /* synthetic */ int[] zzkk = {zzki, zzkj};
        public static final int zzkl = 1;
        public static final int zzkm = 2;
        private static final /* synthetic */ int[] zzkn = {zzkl, zzkm};

        public static int[] zzby() {
            return (int[]) zzkh.clone();
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzdo<MessageType, BuilderType> implements zzez {
        protected zzdj<Object> zzko = zzdj.zzbd();
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public String toString() {
        return zzey.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzfp != 0) {
            return this.zzfp;
        }
        this.zzfp = zzfj.zzcw().zzo(this).hashCode(this);
        return this.zzfp;
    }

    public static abstract class zzb<MessageType extends zzdo<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzcf<MessageType, BuilderType> {
        private final MessageType zzjx;
        protected MessageType zzjy;
        private boolean zzjz = false;

        protected zzb(MessageType messagetype) {
            this.zzjx = messagetype;
            this.zzjy = (zzdo) messagetype.zza(zzc.zzkd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzbt() {
            if (this.zzjz) {
                MessageType messagetype = (zzdo) this.zzjy.zza(zzc.zzkd, (Object) null, (Object) null);
                zza(messagetype, this.zzjy);
                this.zzjy = messagetype;
                this.zzjz = false;
            }
        }

        public final boolean isInitialized() {
            return zzdo.zza(this.zzjy, false);
        }

        /* renamed from: zzbu */
        public MessageType zzbw() {
            if (this.zzjz) {
                return this.zzjy;
            }
            MessageType messagetype = this.zzjy;
            zzfj.zzcw().zzo(messagetype).zzf(messagetype);
            this.zzjz = true;
            return this.zzjy;
        }

        /* renamed from: zzbv */
        public final MessageType zzbx() {
            MessageType messagetype = (zzdo) zzbw();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzgd(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzbt();
            zza(this.zzjy, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzfj.zzcw().zzo(messagetype).zzc(messagetype, messagetype2);
        }

        public final /* synthetic */ zzcf zzad() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzex zzbr() {
            return this.zzjx;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb = (zzb) ((zzdo) this.zzjx).zza(zzc.zzke, (Object) null, (Object) null);
            zzb.zza((zzdo) zzbw());
            return zzb;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzdo) zza(zzc.zzkf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzfj.zzcw().zzo(this).equals(this, (zzdo) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzdo<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzbk() {
        return (zzb) zza(zzc.zzke, (Object) null, (Object) null);
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzac() {
        return this.zzju;
    }

    /* access modifiers changed from: package-private */
    public final void zzg(int i) {
        this.zzju = i;
    }

    public final void zzb(zzcy zzcy) throws IOException {
        zzfj.zzcw().zze(getClass()).zza(this, zzdb.zza(zzcy));
    }

    public final int zzbl() {
        if (this.zzju == -1) {
            this.zzju = zzfj.zzcw().zzo(this).zzn(this);
        }
        return this.zzju;
    }

    static <T extends zzdo<?, ?>> T zza(Class<T> cls) {
        T t = (zzdo) zzjv.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzdo) zzjv.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t == null) {
            t = (zzdo) ((zzdo) zzgi.zzg(cls)).zza(zzc.zzkf, (Object) null, (Object) null);
            if (t != null) {
                zzjv.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzdo<?, ?>> void zza(Class<T> cls, T t) {
        zzjv.put(cls, t);
    }

    protected static Object zza(zzex zzex, String str, Object[] objArr) {
        return new zzfl(zzex, str, objArr);
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

    protected static final <T extends zzdo<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzc.zzka, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzm = zzfj.zzcw().zzo(t).zzm(t);
        if (z) {
            t.zza(zzc.zzkb, (Object) zzm ? t : null, (Object) null);
        }
        return zzm;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.icing.zzek, com.google.android.gms.internal.icing.zzdu] */
    protected static zzdu zzbm() {
        return zzek.zzch();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.icing.zzds, com.google.android.gms.internal.icing.zzdd] */
    protected static zzds zzbn() {
        return zzdd.zzax();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.icing.zzdt, com.google.android.gms.internal.icing.zzcj] */
    protected static zzdt zzbo() {
        return zzcj.zzaj();
    }

    protected static <E> zzdx<E> zzbp() {
        return zzfi.zzcv();
    }

    protected static <E> zzdx<E> zza(zzdx<E> zzdx) {
        int size = zzdx.size();
        return zzdx.zzj(size == 0 ? 10 : size << 1);
    }

    public final /* synthetic */ zzew zzbq() {
        zzb zzb2 = (zzb) zza(zzc.zzke, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzex zzbr() {
        return (zzdo) zza(zzc.zzkf, (Object) null, (Object) null);
    }
}

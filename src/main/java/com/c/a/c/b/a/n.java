package com.c.a.c.b.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import com.c.a.i.i;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
public class n implements l {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config[] f5712a = {Bitmap.Config.ARGB_8888, null};

    /* renamed from: b  reason: collision with root package name */
    private static final Bitmap.Config[] f5713b = {Bitmap.Config.RGB_565};

    /* renamed from: c  reason: collision with root package name */
    private static final Bitmap.Config[] f5714c = {Bitmap.Config.ARGB_4444};

    /* renamed from: d  reason: collision with root package name */
    private static final Bitmap.Config[] f5715d = {Bitmap.Config.ALPHA_8};

    /* renamed from: e  reason: collision with root package name */
    private final b f5716e = new b();

    /* renamed from: f  reason: collision with root package name */
    private final h<a, Bitmap> f5717f = new h<>();

    /* renamed from: g  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f5718g = new HashMap();

    public void a(Bitmap bitmap) {
        a a2 = this.f5716e.a(i.a(bitmap), bitmap.getConfig());
        this.f5717f.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.f5720a));
        Integer valueOf = Integer.valueOf(a2.f5720a);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        a3.put(valueOf, Integer.valueOf(i));
    }

    public Bitmap a(int i, int i2, Bitmap.Config config) {
        a b2 = b(i.a(i, i2, config), config);
        Bitmap a2 = this.f5717f.a(b2);
        if (a2 != null) {
            a(Integer.valueOf(b2.f5720a), a2);
            a2.reconfigure(i, i2, a2.getConfig() != null ? a2.getConfig() : Bitmap.Config.ARGB_8888);
        }
        return a2;
    }

    private a b(int i, Bitmap.Config config) {
        a a2 = this.f5716e.a(i, config);
        Bitmap.Config[] b2 = b(config);
        int length = b2.length;
        int i2 = 0;
        while (i2 < length) {
            Bitmap.Config config2 = b2[i2];
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey == null || ceilingKey.intValue() > i * 8) {
                i2++;
            } else {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return a2;
                        }
                    } else if (config2.equals(config)) {
                        return a2;
                    }
                }
                this.f5716e.a(a2);
                return this.f5716e.a(ceilingKey.intValue(), config2);
            }
        }
        return a2;
    }

    public Bitmap a() {
        Bitmap a2 = this.f5717f.a();
        if (a2 != null) {
            a(Integer.valueOf(i.a(a2)), a2);
        }
        return a2;
    }

    private void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 == null) {
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        } else if (num2.intValue() == 1) {
            a2.remove(num);
        } else {
            a2.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f5718g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f5718g.put(config, treeMap);
        return treeMap;
    }

    public String b(Bitmap bitmap) {
        return a(i.a(bitmap), bitmap.getConfig());
    }

    public String b(int i, int i2, Bitmap.Config config) {
        return a(i.a(i, i2, config), config);
    }

    public int c(Bitmap bitmap) {
        return i.a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f5717f);
        sb.append(", sortedSizes=(");
        for (Map.Entry next : this.f5718g.entrySet()) {
            sb.append(next.getKey());
            sb.append('[');
            sb.append(next.getValue());
            sb.append("], ");
        }
        if (!this.f5718g.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    static class b extends d<a> {
        b() {
        }

        public a a(int i, Bitmap.Config config) {
            a aVar = (a) c();
            aVar.a(i, config);
            return aVar;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }
    }

    static final class a implements m {

        /* renamed from: a  reason: collision with root package name */
        int f5720a;

        /* renamed from: b  reason: collision with root package name */
        private final b f5721b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f5722c;

        public a(b bVar) {
            this.f5721b = bVar;
        }

        public void a(int i, Bitmap.Config config) {
            this.f5720a = i;
            this.f5722c = config;
        }

        public void a() {
            this.f5721b.a(this);
        }

        public String toString() {
            return n.a(this.f5720a, this.f5722c);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f5720a != aVar.f5720a || !i.a((Object) this.f5722c, (Object) aVar.f5722c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i = this.f5720a * 31;
            Bitmap.Config config = this.f5722c;
            return i + (config != null ? config.hashCode() : 0);
        }
    }

    static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + SQLBuilder.PARENTHESES_RIGHT;
    }

    /* renamed from: com.c.a.c.b.a.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5719a = new int[Bitmap.Config.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                android.graphics.Bitmap$Config[] r0 = android.graphics.Bitmap.Config.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5719a = r0
                int[] r0 = f5719a     // Catch:{ NoSuchFieldError -> 0x0014 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5719a     // Catch:{ NoSuchFieldError -> 0x001f }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f5719a     // Catch:{ NoSuchFieldError -> 0x002a }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_4444     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f5719a     // Catch:{ NoSuchFieldError -> 0x0035 }
                android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ALPHA_8     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.c.a.c.b.a.n.AnonymousClass1.<clinit>():void");
        }
    }

    private static Bitmap.Config[] b(Bitmap.Config config) {
        int i = AnonymousClass1.f5719a[config.ordinal()];
        if (i == 1) {
            return f5712a;
        }
        if (i == 2) {
            return f5713b;
        }
        if (i == 3) {
            return f5714c;
        }
        if (i == 4) {
            return f5715d;
        }
        return new Bitmap.Config[]{config};
    }
}

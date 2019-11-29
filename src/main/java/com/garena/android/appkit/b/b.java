package com.garena.android.appkit.b;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f7614a;

    /* renamed from: b  reason: collision with root package name */
    private static b f7615b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, ArrayList<WeakReference<e>>> f7616c = new HashMap<>();

    public enum a {
        NETWORK_BUS,
        UI_BUS
    }

    /* renamed from: com.garena.android.appkit.b.b$b  reason: collision with other inner class name */
    public enum C0122b {
        MAIN_THREAD,
        ANY_THREAD
    }

    public static void a(String str, e eVar, a aVar) {
        int i = AnonymousClass2.f7620a[aVar.ordinal()];
        if (i == 1) {
            a().a(str, eVar);
        } else if (i == 2) {
            b().a(str, eVar);
        }
    }

    public static void b(String str, e eVar, a aVar) {
        int i = AnonymousClass2.f7620a[aVar.ordinal()];
        if (i == 1) {
            a().b(str, eVar);
        } else if (i == 2) {
            b().b(str, eVar);
        }
    }

    public static void a(String str, a aVar, a aVar2) {
        int i = AnonymousClass2.f7620a[aVar2.ordinal()];
        if (i == 1) {
            a().a(str, aVar);
        } else if (i == 2) {
            b().a(str, aVar);
        }
    }

    private synchronized void a(String str, e eVar) {
        if (this.f7616c.containsKey(str)) {
            ArrayList arrayList = this.f7616c.get(str);
            if (a((ArrayList<WeakReference<e>>) arrayList, eVar) == -1) {
                arrayList.add(new WeakReference(eVar));
                eVar.onRegister();
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(new WeakReference(eVar));
            eVar.onRegister();
            this.f7616c.put(str, arrayList2);
        }
    }

    private static int a(ArrayList<WeakReference<e>> arrayList, e eVar) {
        Iterator<WeakReference<e>> it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            e eVar2 = (e) it.next().get();
            if (eVar2 != null && eVar2 == eVar) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private synchronized void b(String str, e eVar) {
        if (this.f7616c.containsKey(str)) {
            ArrayList arrayList = this.f7616c.get(str);
            int a2 = a((ArrayList<WeakReference<e>>) arrayList, eVar);
            if (a2 != -1) {
                arrayList.remove(a2);
                eVar.onDismiss();
            }
            if (arrayList.size() == 0) {
                this.f7616c.remove(str);
            }
        }
    }

    public synchronized void a(String str, a aVar) {
        if (this.f7616c.containsKey(str)) {
            ArrayList arrayList = this.f7616c.get(str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                e eVar = (e) ((WeakReference) arrayList.get(size)).get();
                if (eVar != null) {
                    int i = AnonymousClass2.f7621b[eVar.getOption().ordinal()];
                    if (i == 1) {
                        a(eVar, aVar);
                    } else if (i == 2) {
                        b(eVar, aVar);
                    }
                }
            }
        }
    }

    /* renamed from: com.garena.android.appkit.b.b$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7620a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7621b = new int[C0122b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|(2:5|6)|7|9|10|11|12|14) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        static {
            /*
                com.garena.android.appkit.b.b$b[] r0 = com.garena.android.appkit.b.b.C0122b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7621b = r0
                r0 = 1
                int[] r1 = f7621b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.garena.android.appkit.b.b$b r2 = com.garena.android.appkit.b.b.C0122b.MAIN_THREAD     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f7621b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.garena.android.appkit.b.b$b r3 = com.garena.android.appkit.b.b.C0122b.ANY_THREAD     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.garena.android.appkit.b.b$a[] r2 = com.garena.android.appkit.b.b.a.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f7620a = r2
                int[] r2 = f7620a     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.garena.android.appkit.b.b$a r3 = com.garena.android.appkit.b.b.a.NETWORK_BUS     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r0 = f7620a     // Catch:{ NoSuchFieldError -> 0x003c }
                com.garena.android.appkit.b.b$a r2 = com.garena.android.appkit.b.b.a.UI_BUS     // Catch:{ NoSuchFieldError -> 0x003c }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.garena.android.appkit.b.b.AnonymousClass2.<clinit>():void");
        }
    }

    public void a(final e eVar, final a aVar) {
        k.a().a(new Runnable() {
            public void run() {
                if (eVar.isValid()) {
                    eVar.onEvent(aVar);
                }
            }
        });
    }

    public void b(e eVar, a aVar) {
        if (eVar.isValid()) {
            eVar.onEvent(aVar);
        }
    }

    private static b a() {
        if (f7614a == null) {
            synchronized (b.class) {
                if (f7614a == null) {
                    f7614a = new b();
                }
            }
        }
        return f7614a;
    }

    private static b b() {
        if (f7615b == null) {
            synchronized (b.class) {
                if (f7615b == null) {
                    f7615b = new b();
                }
            }
        }
        return f7615b;
    }
}

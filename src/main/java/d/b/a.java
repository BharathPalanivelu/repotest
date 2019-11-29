package d.b;

import com.tencent.qcloud.core.http.HttpMetric;
import d.d.b.j;
import java.lang.reflect.Method;

public class a {

    /* renamed from: d.b.a$a  reason: collision with other inner class name */
    private static final class C0497a {

        /* renamed from: a  reason: collision with root package name */
        public static final Method f32654a;

        /* renamed from: b  reason: collision with root package name */
        public static final C0497a f32655b = new C0497a();

        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[EDGE_INSN: B:13:0x0049->B:11:0x0049 ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0045 A[LOOP:0: B:1:0x0015->B:9:0x0045, LOOP_END] */
        static {
            /*
                d.b.a$a r0 = new d.b.a$a
                r0.<init>()
                f32655b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                d.d.b.j.a((java.lang.Object) r1, (java.lang.String) r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L_0x0015:
                if (r4 >= r2) goto L_0x0048
                r5 = r1[r4]
                java.lang.String r6 = "it"
                d.d.b.j.a((java.lang.Object) r5, (java.lang.String) r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = d.d.b.j.a((java.lang.Object) r6, (java.lang.Object) r7)
                if (r6 == 0) goto L_0x0041
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                d.d.b.j.a((java.lang.Object) r6, (java.lang.String) r7)
                java.lang.Object r6 = d.a.d.b(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = d.d.b.j.a((java.lang.Object) r6, (java.lang.Object) r0)
                if (r6 == 0) goto L_0x0041
                r6 = 1
                goto L_0x0042
            L_0x0041:
                r6 = 0
            L_0x0042:
                if (r6 == 0) goto L_0x0045
                goto L_0x0049
            L_0x0045:
                int r4 = r4 + 1
                goto L_0x0015
            L_0x0048:
                r5 = 0
            L_0x0049:
                f32654a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.b.a.C0497a.<clinit>():void");
        }

        private C0497a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        j.b(th, "cause");
        j.b(th2, HttpMetric.ATTR_EXCEPTION);
        Method method = C0497a.f32654a;
        if (method != null) {
            method.invoke(th, new Object[]{th2});
        }
    }
}

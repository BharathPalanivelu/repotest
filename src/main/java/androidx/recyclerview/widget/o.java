package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

class o {

    /* renamed from: a  reason: collision with root package name */
    final a f2964a;

    interface a {
        a.b a(int i, int i2, int i3, Object obj);

        void a(a.b bVar);
    }

    o(a aVar) {
        this.f2964a = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(List<a.b> list) {
        while (true) {
            int b2 = b(list);
            if (b2 != -1) {
                a(list, b2, b2 + 1);
            } else {
                return;
            }
        }
    }

    private void a(List<a.b> list, int i, int i2) {
        a.b bVar = list.get(i);
        a.b bVar2 = list.get(i2);
        int i3 = bVar2.f2821a;
        if (i3 == 1) {
            c(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            a(list, i, bVar, i2, bVar2);
        } else if (i3 == 4) {
            b(list, i, bVar, i2, bVar2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f2822b
            int r1 = r11.f2824d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001b
            int r0 = r13.f2822b
            int r1 = r11.f2822b
            if (r0 != r1) goto L_0x0019
            int r0 = r13.f2824d
            int r1 = r11.f2824d
            int r4 = r11.f2822b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x0019
            r0 = 0
            goto L_0x002c
        L_0x0019:
            r0 = 0
            goto L_0x002f
        L_0x001b:
            int r0 = r13.f2822b
            int r1 = r11.f2824d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.f2824d
            int r1 = r11.f2822b
            int r4 = r11.f2824d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
        L_0x002c:
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.f2824d
            int r4 = r13.f2822b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f2822b
            int r1 = r1 - r3
            r13.f2822b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.f2824d
            int r4 = r13.f2822b
            int r6 = r13.f2824d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.f2824d
            int r10 = r10 - r3
            r13.f2824d = r10
            r11.f2821a = r5
            r11.f2824d = r3
            int r10 = r13.f2824d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            androidx.recyclerview.widget.o$a r9 = r8.f2964a
            r9.a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f2822b
            int r4 = r13.f2822b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f2822b
            int r1 = r1 + r3
            r13.f2822b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f2822b
            int r4 = r13.f2822b
            int r7 = r13.f2824d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f2822b
            int r4 = r13.f2824d
            int r1 = r1 + r4
            int r4 = r11.f2822b
            int r1 = r1 - r4
            androidx.recyclerview.widget.o$a r4 = r8.f2964a
            int r7 = r11.f2822b
            int r7 = r7 + r3
            androidx.recyclerview.widget.a$b r6 = r4.a(r5, r7, r1, r6)
            int r1 = r11.f2822b
            int r3 = r13.f2822b
            int r1 = r1 - r3
            r13.f2824d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            androidx.recyclerview.widget.o$a r9 = r8.f2964a
            r9.a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00d0
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f2822b
            int r1 = r6.f2822b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f2822b
            int r1 = r6.f2824d
            int r0 = r0 - r1
            r11.f2822b = r0
        L_0x00a8:
            int r0 = r11.f2824d
            int r1 = r6.f2822b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.f2824d
            int r1 = r6.f2824d
            int r0 = r0 - r1
            r11.f2824d = r0
        L_0x00b5:
            int r0 = r11.f2822b
            int r1 = r13.f2822b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f2822b
            int r1 = r13.f2824d
            int r0 = r0 - r1
            r11.f2822b = r0
        L_0x00c2:
            int r0 = r11.f2824d
            int r1 = r13.f2822b
            if (r0 <= r1) goto L_0x0106
            int r0 = r11.f2824d
            int r1 = r13.f2824d
            int r0 = r0 - r1
            r11.f2824d = r0
            goto L_0x0106
        L_0x00d0:
            if (r6 == 0) goto L_0x00ec
            int r0 = r11.f2822b
            int r1 = r6.f2822b
            if (r0 < r1) goto L_0x00df
            int r0 = r11.f2822b
            int r1 = r6.f2824d
            int r0 = r0 - r1
            r11.f2822b = r0
        L_0x00df:
            int r0 = r11.f2824d
            int r1 = r6.f2822b
            if (r0 < r1) goto L_0x00ec
            int r0 = r11.f2824d
            int r1 = r6.f2824d
            int r0 = r0 - r1
            r11.f2824d = r0
        L_0x00ec:
            int r0 = r11.f2822b
            int r1 = r13.f2822b
            if (r0 < r1) goto L_0x00f9
            int r0 = r11.f2822b
            int r1 = r13.f2824d
            int r0 = r0 - r1
            r11.f2822b = r0
        L_0x00f9:
            int r0 = r11.f2824d
            int r1 = r13.f2822b
            if (r0 < r1) goto L_0x0106
            int r0 = r11.f2824d
            int r1 = r13.f2824d
            int r0 = r0 - r1
            r11.f2824d = r0
        L_0x0106:
            r9.set(r10, r13)
            int r13 = r11.f2822b
            int r0 = r11.f2824d
            if (r13 == r0) goto L_0x0113
            r9.set(r12, r11)
            goto L_0x0116
        L_0x0113:
            r9.remove(r12)
        L_0x0116:
            if (r6 == 0) goto L_0x011b
            r9.add(r10, r6)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.o.a(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    private void c(List<a.b> list, int i, a.b bVar, int i2, a.b bVar2) {
        int i3 = bVar.f2824d < bVar2.f2822b ? -1 : 0;
        if (bVar.f2822b < bVar2.f2822b) {
            i3++;
        }
        if (bVar2.f2822b <= bVar.f2822b) {
            bVar.f2822b += bVar2.f2824d;
        }
        if (bVar2.f2822b <= bVar.f2824d) {
            bVar.f2824d += bVar2.f2824d;
        }
        bVar2.f2822b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(java.util.List<androidx.recyclerview.widget.a.b> r8, int r9, androidx.recyclerview.widget.a.b r10, int r11, androidx.recyclerview.widget.a.b r12) {
        /*
            r7 = this;
            int r0 = r10.f2824d
            int r1 = r12.f2822b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f2822b
            int r0 = r0 - r4
            r12.f2822b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.f2824d
            int r1 = r12.f2822b
            int r5 = r12.f2824d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.f2824d
            int r0 = r0 - r4
            r12.f2824d = r0
            androidx.recyclerview.widget.o$a r0 = r7.f2964a
            int r1 = r10.f2822b
            java.lang.Object r5 = r12.f2823c
            androidx.recyclerview.widget.a$b r0 = r0.a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f2822b
            int r5 = r12.f2822b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f2822b
            int r1 = r1 + r4
            r12.f2822b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f2822b
            int r5 = r12.f2822b
            int r6 = r12.f2824d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f2822b
            int r3 = r12.f2824d
            int r1 = r1 + r3
            int r3 = r10.f2822b
            int r1 = r1 - r3
            androidx.recyclerview.widget.o$a r3 = r7.f2964a
            int r5 = r10.f2822b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f2823c
            androidx.recyclerview.widget.a$b r3 = r3.a(r2, r5, r1, r4)
            int r2 = r12.f2824d
            int r2 = r2 - r1
            r12.f2824d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.f2824d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            androidx.recyclerview.widget.o$a r10 = r7.f2964a
            r10.a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.o.b(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    private int b(List<a.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f2821a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }
}

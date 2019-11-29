package androidx.emoji.b;

import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji.b.a;
import androidx.emoji.b.f;
import java.util.Arrays;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final a.h f2051a;

    /* renamed from: b  reason: collision with root package name */
    private final f f2052b;

    /* renamed from: c  reason: collision with root package name */
    private b f2053c = new b();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f2054d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f2055e;

    private static boolean a(int i, int i2) {
        return i == -1 || i2 == -1 || i != i2;
    }

    c(f fVar, a.h hVar, boolean z, int[] iArr) {
        this.f2051a = hVar;
        this.f2052b = fVar;
        this.f2054d = z;
        this.f2055e = iArr;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: android.text.Spannable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: android.text.Spannable} */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.lang.CharSequence] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062 A[Catch:{ all -> 0x0117 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.CharSequence a(java.lang.CharSequence r10, int r11, int r12, int r13, boolean r14) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.emoji.widget.k
            if (r0 == 0) goto L_0x000a
            r1 = r10
            androidx.emoji.widget.k r1 = (androidx.emoji.widget.k) r1
            r1.a()
        L_0x000a:
            r1 = 0
            if (r0 != 0) goto L_0x002b
            boolean r2 = r10 instanceof android.text.Spannable     // Catch:{ all -> 0x0117 }
            if (r2 == 0) goto L_0x0012
            goto L_0x002b
        L_0x0012:
            boolean r2 = r10 instanceof android.text.Spanned     // Catch:{ all -> 0x0117 }
            if (r2 == 0) goto L_0x002e
            r2 = r10
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch:{ all -> 0x0117 }
            int r3 = r11 + -1
            int r4 = r12 + 1
            java.lang.Class<androidx.emoji.b.d> r5 = androidx.emoji.b.d.class
            int r2 = r2.nextSpanTransition(r3, r4, r5)     // Catch:{ all -> 0x0117 }
            if (r2 > r12) goto L_0x002e
            android.text.SpannableString r1 = new android.text.SpannableString     // Catch:{ all -> 0x0117 }
            r1.<init>(r10)     // Catch:{ all -> 0x0117 }
            goto L_0x002e
        L_0x002b:
            r1 = r10
            android.text.Spannable r1 = (android.text.Spannable) r1     // Catch:{ all -> 0x0117 }
        L_0x002e:
            r2 = 0
            if (r1 == 0) goto L_0x0060
            java.lang.Class<androidx.emoji.b.d> r3 = androidx.emoji.b.d.class
            java.lang.Object[] r3 = r1.getSpans(r11, r12, r3)     // Catch:{ all -> 0x0117 }
            androidx.emoji.b.d[] r3 = (androidx.emoji.b.d[]) r3     // Catch:{ all -> 0x0117 }
            if (r3 == 0) goto L_0x0060
            int r4 = r3.length     // Catch:{ all -> 0x0117 }
            if (r4 <= 0) goto L_0x0060
            int r4 = r3.length     // Catch:{ all -> 0x0117 }
            r5 = r12
            r12 = r11
            r11 = 0
        L_0x0042:
            if (r11 >= r4) goto L_0x005e
            r6 = r3[r11]     // Catch:{ all -> 0x0117 }
            int r7 = r1.getSpanStart(r6)     // Catch:{ all -> 0x0117 }
            int r8 = r1.getSpanEnd(r6)     // Catch:{ all -> 0x0117 }
            if (r7 == r5) goto L_0x0053
            r1.removeSpan(r6)     // Catch:{ all -> 0x0117 }
        L_0x0053:
            int r12 = java.lang.Math.min(r7, r12)     // Catch:{ all -> 0x0117 }
            int r5 = java.lang.Math.max(r8, r5)     // Catch:{ all -> 0x0117 }
            int r11 = r11 + 1
            goto L_0x0042
        L_0x005e:
            r11 = r12
            r12 = r5
        L_0x0060:
            if (r11 == r12) goto L_0x010e
            int r3 = r10.length()     // Catch:{ all -> 0x0117 }
            if (r11 < r3) goto L_0x006a
            goto L_0x010e
        L_0x006a:
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r13 == r3) goto L_0x007f
            if (r1 == 0) goto L_0x007f
            int r3 = r1.length()     // Catch:{ all -> 0x0117 }
            java.lang.Class<androidx.emoji.b.d> r4 = androidx.emoji.b.d.class
            java.lang.Object[] r3 = r1.getSpans(r2, r3, r4)     // Catch:{ all -> 0x0117 }
            androidx.emoji.b.d[] r3 = (androidx.emoji.b.d[]) r3     // Catch:{ all -> 0x0117 }
            int r3 = r3.length     // Catch:{ all -> 0x0117 }
            int r13 = r13 - r3
        L_0x007f:
            androidx.emoji.b.c$c r3 = new androidx.emoji.b.c$c     // Catch:{ all -> 0x0117 }
            androidx.emoji.b.f r4 = r9.f2052b     // Catch:{ all -> 0x0117 }
            androidx.emoji.b.f$a r4 = r4.c()     // Catch:{ all -> 0x0117 }
            boolean r5 = r9.f2054d     // Catch:{ all -> 0x0117 }
            int[] r6 = r9.f2055e     // Catch:{ all -> 0x0117 }
            r3.<init>(r4, r5, r6)     // Catch:{ all -> 0x0117 }
            int r4 = java.lang.Character.codePointAt(r10, r11)     // Catch:{ all -> 0x0117 }
            r5 = r1
        L_0x0093:
            r1 = r11
        L_0x0094:
            if (r11 >= r12) goto L_0x00e1
            if (r2 >= r13) goto L_0x00e1
            int r6 = r3.a(r4)     // Catch:{ all -> 0x0117 }
            r7 = 1
            if (r6 == r7) goto L_0x00cf
            r7 = 2
            if (r6 == r7) goto L_0x00c3
            r7 = 3
            if (r6 == r7) goto L_0x00a6
            goto L_0x0094
        L_0x00a6:
            if (r14 != 0) goto L_0x00b2
            androidx.emoji.b.b r6 = r3.a()     // Catch:{ all -> 0x0117 }
            boolean r6 = r9.a((java.lang.CharSequence) r10, (int) r1, (int) r11, (androidx.emoji.b.b) r6)     // Catch:{ all -> 0x0117 }
            if (r6 != 0) goto L_0x0093
        L_0x00b2:
            if (r5 != 0) goto L_0x00b9
            android.text.SpannableString r5 = new android.text.SpannableString     // Catch:{ all -> 0x0117 }
            r5.<init>(r10)     // Catch:{ all -> 0x0117 }
        L_0x00b9:
            androidx.emoji.b.b r6 = r3.a()     // Catch:{ all -> 0x0117 }
            r9.a((android.text.Spannable) r5, (androidx.emoji.b.b) r6, (int) r1, (int) r11)     // Catch:{ all -> 0x0117 }
            int r2 = r2 + 1
            goto L_0x0093
        L_0x00c3:
            int r6 = java.lang.Character.charCount(r4)     // Catch:{ all -> 0x0117 }
            int r11 = r11 + r6
            if (r11 >= r12) goto L_0x0094
            int r4 = java.lang.Character.codePointAt(r10, r11)     // Catch:{ all -> 0x0117 }
            goto L_0x0094
        L_0x00cf:
            int r11 = java.lang.Character.codePointAt(r10, r1)     // Catch:{ all -> 0x0117 }
            int r11 = java.lang.Character.charCount(r11)     // Catch:{ all -> 0x0117 }
            int r1 = r1 + r11
            if (r1 >= r12) goto L_0x00df
            int r11 = java.lang.Character.codePointAt(r10, r1)     // Catch:{ all -> 0x0117 }
            r4 = r11
        L_0x00df:
            r11 = r1
            goto L_0x0094
        L_0x00e1:
            boolean r12 = r3.c()     // Catch:{ all -> 0x0117 }
            if (r12 == 0) goto L_0x0103
            if (r2 >= r13) goto L_0x0103
            if (r14 != 0) goto L_0x00f5
            androidx.emoji.b.b r12 = r3.b()     // Catch:{ all -> 0x0117 }
            boolean r12 = r9.a((java.lang.CharSequence) r10, (int) r1, (int) r11, (androidx.emoji.b.b) r12)     // Catch:{ all -> 0x0117 }
            if (r12 != 0) goto L_0x0103
        L_0x00f5:
            if (r5 != 0) goto L_0x00fc
            android.text.SpannableString r5 = new android.text.SpannableString     // Catch:{ all -> 0x0117 }
            r5.<init>(r10)     // Catch:{ all -> 0x0117 }
        L_0x00fc:
            androidx.emoji.b.b r12 = r3.b()     // Catch:{ all -> 0x0117 }
            r9.a((android.text.Spannable) r5, (androidx.emoji.b.b) r12, (int) r1, (int) r11)     // Catch:{ all -> 0x0117 }
        L_0x0103:
            if (r5 != 0) goto L_0x0106
            r5 = r10
        L_0x0106:
            if (r0 == 0) goto L_0x010d
            androidx.emoji.widget.k r10 = (androidx.emoji.widget.k) r10
            r10.b()
        L_0x010d:
            return r5
        L_0x010e:
            if (r0 == 0) goto L_0x0116
            r11 = r10
            androidx.emoji.widget.k r11 = (androidx.emoji.widget.k) r11
            r11.b()
        L_0x0116:
            return r10
        L_0x0117:
            r11 = move-exception
            if (r0 == 0) goto L_0x011f
            androidx.emoji.widget.k r10 = (androidx.emoji.widget.k) r10
            r10.b()
        L_0x011f:
            goto L_0x0121
        L_0x0120:
            throw r11
        L_0x0121:
            goto L_0x0120
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji.b.c.a(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    static boolean a(Editable editable, int i, KeyEvent keyEvent) {
        boolean z;
        if (i != 67) {
            z = i != 112 ? false : a(editable, keyEvent, true);
        } else {
            z = a(editable, keyEvent, false);
        }
        if (!z) {
            return false;
        }
        MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
        return true;
    }

    private static boolean a(Editable editable, KeyEvent keyEvent, boolean z) {
        if (a(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (a(selectionStart, selectionEnd)) {
            return false;
        }
        d[] dVarArr = (d[]) editable.getSpans(selectionStart, selectionEnd, d.class);
        if (dVarArr != null && dVarArr.length > 0) {
            int length = dVarArr.length;
            int i = 0;
            while (i < length) {
                d dVar = dVarArr[i];
                int spanStart = editable.getSpanStart(dVar);
                int spanEnd = editable.getSpanEnd(dVar);
                if ((!z || spanStart != selectionStart) && ((z || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    static boolean a(InputConnection inputConnection, Editable editable, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (editable != null && inputConnection != null && i >= 0 && i2 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (a(selectionStart, selectionEnd)) {
                return false;
            }
            if (z) {
                i4 = a.a(editable, selectionStart, Math.max(i, 0));
                i3 = a.b(editable, selectionEnd, Math.max(i2, 0));
                if (i4 == -1 || i3 == -1) {
                    return false;
                }
            } else {
                i4 = Math.max(selectionStart - i, 0);
                i3 = Math.min(selectionEnd + i2, editable.length());
            }
            d[] dVarArr = (d[]) editable.getSpans(i4, i3, d.class);
            if (dVarArr != null && dVarArr.length > 0) {
                int i5 = i3;
                int i6 = i4;
                for (d dVar : dVarArr) {
                    int spanStart = editable.getSpanStart(dVar);
                    int spanEnd = editable.getSpanEnd(dVar);
                    i6 = Math.min(spanStart, i6);
                    i5 = Math.max(spanEnd, i5);
                }
                int max = Math.max(i6, 0);
                int min = Math.min(i5, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max, min);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    private static boolean a(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    private void a(Spannable spannable, b bVar, int i, int i2) {
        spannable.setSpan(this.f2051a.a(bVar), i, i2, 33);
    }

    private boolean a(CharSequence charSequence, int i, int i2, b bVar) {
        if (Build.VERSION.SDK_INT < 23 && bVar.d() > Build.VERSION.SDK_INT) {
            return false;
        }
        if (bVar.e() == 0) {
            bVar.a(this.f2053c.a(charSequence, i, i2));
        }
        if (bVar.e() == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: androidx.emoji.b.c$c  reason: collision with other inner class name */
    static final class C0047c {

        /* renamed from: a  reason: collision with root package name */
        private int f2058a = 1;

        /* renamed from: b  reason: collision with root package name */
        private final f.a f2059b;

        /* renamed from: c  reason: collision with root package name */
        private f.a f2060c;

        /* renamed from: d  reason: collision with root package name */
        private f.a f2061d;

        /* renamed from: e  reason: collision with root package name */
        private int f2062e;

        /* renamed from: f  reason: collision with root package name */
        private int f2063f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f2064g;
        private final int[] h;

        private static boolean b(int i) {
            return i == 65039;
        }

        private static boolean c(int i) {
            return i == 65038;
        }

        C0047c(f.a aVar, boolean z, int[] iArr) {
            this.f2059b = aVar;
            this.f2060c = aVar;
            this.f2064g = z;
            this.h = iArr;
        }

        /* access modifiers changed from: package-private */
        public int a(int i) {
            f.a a2 = this.f2060c.a(i);
            int i2 = 3;
            if (this.f2058a != 2) {
                if (a2 == null) {
                    i2 = d();
                    this.f2062e = i;
                    return i2;
                }
                this.f2058a = 2;
                this.f2060c = a2;
                this.f2063f = 1;
            } else if (a2 != null) {
                this.f2060c = a2;
                this.f2063f++;
            } else {
                if (c(i)) {
                    i2 = d();
                } else if (!b(i)) {
                    if (this.f2060c.a() == null) {
                        i2 = d();
                    } else if (this.f2063f != 1) {
                        this.f2061d = this.f2060c;
                        d();
                    } else if (e()) {
                        this.f2061d = this.f2060c;
                        d();
                    } else {
                        i2 = d();
                    }
                }
                this.f2062e = i;
                return i2;
            }
            i2 = 2;
            this.f2062e = i;
            return i2;
        }

        private int d() {
            this.f2058a = 1;
            this.f2060c = this.f2059b;
            this.f2063f = 0;
            return 1;
        }

        /* access modifiers changed from: package-private */
        public b a() {
            return this.f2061d.a();
        }

        /* access modifiers changed from: package-private */
        public b b() {
            return this.f2060c.a();
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f2058a != 2 || this.f2060c.a() == null || (this.f2063f <= 1 && !e())) {
                return false;
            }
            return true;
        }

        private boolean e() {
            if (this.f2060c.a().f() || b(this.f2062e)) {
                return true;
            }
            if (this.f2064g) {
                if (this.h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.h, this.f2060c.a().a(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    private static final class a {
        static int a(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    i--;
                    if (i < 0) {
                        return z ? -1 : 0;
                    }
                    char charAt = charSequence.charAt(i);
                    if (z) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i2--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i2--;
                    } else if (Character.isHighSurrogate(charAt)) {
                        return -1;
                    } else {
                        z = true;
                    }
                }
                return i;
            }
        }

        static int b(CharSequence charSequence, int i, int i2) {
            int length = charSequence.length();
            if (i < 0 || length < i || i2 < 0) {
                return -1;
            }
            while (true) {
                boolean z = false;
                while (i2 != 0) {
                    if (r7 < length) {
                        char charAt = charSequence.charAt(r7);
                        if (z) {
                            if (!Character.isLowSurrogate(charAt)) {
                                return -1;
                            }
                            i2--;
                            i = r7 + 1;
                        } else if (!Character.isSurrogate(charAt)) {
                            i2--;
                            r7++;
                        } else if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        } else {
                            r7++;
                            z = true;
                        }
                    } else if (z) {
                        return -1;
                    } else {
                        return length;
                    }
                }
                return r7;
            }
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final ThreadLocal<StringBuilder> f2056a = new ThreadLocal<>();

        /* renamed from: b  reason: collision with root package name */
        private final TextPaint f2057b = new TextPaint();

        b() {
            this.f2057b.setTextSize(10.0f);
        }

        public boolean a(CharSequence charSequence, int i, int i2) {
            StringBuilder a2 = a();
            a2.setLength(0);
            while (i < i2) {
                a2.append(charSequence.charAt(i));
                i++;
            }
            return androidx.core.graphics.b.a(this.f2057b, a2.toString());
        }

        private static StringBuilder a() {
            if (f2056a.get() == null) {
                f2056a.set(new StringBuilder());
            }
            return f2056a.get();
        }
    }
}

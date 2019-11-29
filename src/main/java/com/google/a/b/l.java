package com.google.a.b;

import com.google.a.b.a.n;
import com.google.a.d.c;
import java.io.IOException;
import java.io.Writer;

public final class l {
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        throw new com.google.a.m((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        throw new com.google.a.u((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0025, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x002a, code lost:
        return com.google.a.n.f8933a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
        throw new com.google.a.u((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0015, code lost:
        throw new com.google.a.u((java.lang.Throwable) r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016 A[ExcHandler: IOException (r2v5 'e' java.io.IOException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d A[ExcHandler: d (r2v4 'e' com.google.a.d.d A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x000f A[ExcHandler: NumberFormatException (r2v6 'e' java.lang.NumberFormatException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.a.l a(com.google.a.d.a r2) throws com.google.a.p {
        /*
            r2.f()     // Catch:{ EOFException -> 0x0024, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            r0 = 0
            com.google.a.w<com.google.a.l> r1 = com.google.a.b.a.n.X     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            java.lang.Object r2 = r1.read(r2)     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            com.google.a.l r2 = (com.google.a.l) r2     // Catch:{ EOFException -> 0x000d, d -> 0x001d, IOException -> 0x0016, NumberFormatException -> 0x000f }
            return r2
        L_0x000d:
            r2 = move-exception
            goto L_0x0026
        L_0x000f:
            r2 = move-exception
            com.google.a.u r0 = new com.google.a.u
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0016:
            r2 = move-exception
            com.google.a.m r0 = new com.google.a.m
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x001d:
            r2 = move-exception
            com.google.a.u r0 = new com.google.a.u
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        L_0x0024:
            r2 = move-exception
            r0 = 1
        L_0x0026:
            if (r0 == 0) goto L_0x002b
            com.google.a.n r2 = com.google.a.n.f8933a
            return r2
        L_0x002b:
            com.google.a.u r0 = new com.google.a.u
            r0.<init>((java.lang.Throwable) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.a.b.l.a(com.google.a.d.a):com.google.a.l");
    }

    public static void a(com.google.a.l lVar, c cVar) throws IOException {
        n.X.write(cVar, lVar);
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new a(appendable);
    }

    private static final class a extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private final Appendable f8890a;

        /* renamed from: b  reason: collision with root package name */
        private final C0152a f8891b = new C0152a();

        public void close() {
        }

        public void flush() {
        }

        a(Appendable appendable) {
            this.f8890a = appendable;
        }

        public void write(char[] cArr, int i, int i2) throws IOException {
            C0152a aVar = this.f8891b;
            aVar.f8892a = cArr;
            this.f8890a.append(aVar, i, i2 + i);
        }

        public void write(int i) throws IOException {
            this.f8890a.append((char) i);
        }

        /* renamed from: com.google.a.b.l$a$a  reason: collision with other inner class name */
        static class C0152a implements CharSequence {

            /* renamed from: a  reason: collision with root package name */
            char[] f8892a;

            C0152a() {
            }

            public int length() {
                return this.f8892a.length;
            }

            public char charAt(int i) {
                return this.f8892a[i];
            }

            public CharSequence subSequence(int i, int i2) {
                return new String(this.f8892a, i, i2 - i);
            }
        }
    }
}

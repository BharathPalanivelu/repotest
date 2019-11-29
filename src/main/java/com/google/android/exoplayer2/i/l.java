package com.google.android.exoplayer2.i;

public interface l {
    boolean a();

    long b();

    long b(long j);

    public static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private final long f10417a;

        public boolean a() {
            return false;
        }

        public long b(long j) {
            return 0;
        }

        public a(long j) {
            this.f10417a = j;
        }

        public long b() {
            return this.f10417a;
        }
    }
}

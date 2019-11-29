package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.s.l;
import java.io.IOException;
import java.util.Arrays;

public interface m {
    int a(f fVar, int i, boolean z) throws IOException, InterruptedException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(Format format);

    void a(l lVar, int i);

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f10418a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f10419b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10420c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10421d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.f10418a = i;
            this.f10419b = bArr;
            this.f10420c = i2;
            this.f10421d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f10418a == aVar.f10418a && this.f10420c == aVar.f10420c && this.f10421d == aVar.f10421d && Arrays.equals(this.f10419b, aVar.f10419b)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.f10418a * 31) + Arrays.hashCode(this.f10419b)) * 31) + this.f10420c) * 31) + this.f10421d;
        }
    }
}

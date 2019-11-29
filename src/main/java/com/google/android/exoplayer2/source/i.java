package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.x;
import java.io.IOException;

public interface i {

    public interface a {
        void a(x xVar, Object obj);
    }

    h a(b bVar, com.google.android.exoplayer2.r.b bVar2);

    void a() throws IOException;

    void a(f fVar, boolean z, a aVar);

    void a(h hVar);

    void b();

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f12082a = new b(-1, -1, -1);

        /* renamed from: b  reason: collision with root package name */
        public final int f12083b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12084c;

        /* renamed from: d  reason: collision with root package name */
        public final int f12085d;

        public b(int i) {
            this(i, -1, -1);
        }

        public b(int i, int i2, int i3) {
            this.f12083b = i;
            this.f12084c = i2;
            this.f12085d = i3;
        }

        public b a(int i) {
            return this.f12083b == i ? this : new b(i, this.f12084c, this.f12085d);
        }

        public boolean a() {
            return this.f12084c != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f12083b == bVar.f12083b && this.f12084c == bVar.f12084c && this.f12085d == bVar.f12085d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f12083b) * 31) + this.f12084c) * 31) + this.f12085d;
        }
    }
}

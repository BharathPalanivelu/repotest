package com.google.android.exoplayer2.d;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.nio.ByteBuffer;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f9279a = new b();

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f9280b;

    /* renamed from: c  reason: collision with root package name */
    public long f9281c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9282d;

    public static e e() {
        return new e(0);
    }

    public e(int i) {
        this.f9282d = i;
    }

    public void e(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.f9280b;
        if (byteBuffer == null) {
            this.f9280b = f(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f9280b.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer f2 = f(i2);
            if (position > 0) {
                this.f9280b.position(0);
                this.f9280b.limit(position);
                f2.put(this.f9280b);
            }
            this.f9280b = f2;
        }
    }

    public final boolean f() {
        return this.f9280b == null && this.f9282d == 0;
    }

    public final boolean g() {
        return d(1073741824);
    }

    public final void h() {
        this.f9280b.flip();
    }

    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.f9280b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private ByteBuffer f(int i) {
        int i2 = this.f9282d;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f9280b;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i + SQLBuilder.PARENTHESES_RIGHT);
    }
}

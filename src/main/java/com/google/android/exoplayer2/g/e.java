package com.google.android.exoplayer2.g;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.nio.ByteBuffer;

public class e extends a {

    /* renamed from: a  reason: collision with root package name */
    public final b f9880a = new b();

    /* renamed from: b  reason: collision with root package name */
    public ByteBuffer f9881b;

    /* renamed from: c  reason: collision with root package name */
    public long f9882c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9883d;

    public static e e() {
        return new e(0);
    }

    public e(int i) {
        this.f9883d = i;
    }

    public void e(int i) throws IllegalStateException {
        ByteBuffer byteBuffer = this.f9881b;
        if (byteBuffer == null) {
            this.f9881b = f(i);
            return;
        }
        int capacity = byteBuffer.capacity();
        int position = this.f9881b.position();
        int i2 = i + position;
        if (capacity < i2) {
            ByteBuffer f2 = f(i2);
            if (position > 0) {
                this.f9881b.position(0);
                this.f9881b.limit(position);
                f2.put(this.f9881b);
            }
            this.f9881b = f2;
        }
    }

    public final boolean f() {
        return this.f9881b == null && this.f9883d == 0;
    }

    public final boolean g() {
        return d(1073741824);
    }

    public final void h() {
        this.f9881b.flip();
    }

    public void a() {
        super.a();
        ByteBuffer byteBuffer = this.f9881b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
    }

    private ByteBuffer f(int i) {
        int i2 = this.f9883d;
        if (i2 == 1) {
            return ByteBuffer.allocate(i);
        }
        if (i2 == 2) {
            return ByteBuffer.allocateDirect(i);
        }
        ByteBuffer byteBuffer = this.f9881b;
        int capacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        throw new IllegalStateException("Buffer too small (" + capacity + " < " + i + SQLBuilder.PARENTHESES_RIGHT);
    }
}

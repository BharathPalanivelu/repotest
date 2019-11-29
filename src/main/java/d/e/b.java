package d.e;

import d.a.y;
import java.util.NoSuchElementException;

public final class b extends y {

    /* renamed from: a  reason: collision with root package name */
    private final int f32677a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f32678b;

    /* renamed from: c  reason: collision with root package name */
    private int f32679c;

    /* renamed from: d  reason: collision with root package name */
    private final int f32680d;

    public b(int i, int i2, int i3) {
        this.f32680d = i3;
        this.f32677a = i2;
        boolean z = true;
        if (this.f32680d <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f32678b = z;
        this.f32679c = !this.f32678b ? this.f32677a : i;
    }

    public boolean hasNext() {
        return this.f32678b;
    }

    public int b() {
        int i = this.f32679c;
        if (i != this.f32677a) {
            this.f32679c = this.f32680d + i;
        } else if (this.f32678b) {
            this.f32678b = false;
        } else {
            throw new NoSuchElementException();
        }
        return i;
    }
}

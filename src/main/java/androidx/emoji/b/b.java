package androidx.emoji.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.k.a.a.a;
import com.litesuits.orm.db.assit.SQLBuilder;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<a> f2047a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private final int f2048b;

    /* renamed from: c  reason: collision with root package name */
    private final f f2049c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f2050d = 0;

    b(f fVar, int i) {
        this.f2049c = fVar;
        this.f2048b = i;
    }

    public void a(Canvas canvas, float f2, float f3, Paint paint) {
        Typeface a2 = this.f2049c.a();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(a2);
        Canvas canvas2 = canvas;
        canvas2.drawText(this.f2049c.d(), this.f2048b * 2, 2, f2, f3, paint);
        paint.setTypeface(typeface);
    }

    private a h() {
        a aVar = f2047a.get();
        if (aVar == null) {
            aVar = new a();
            f2047a.set(aVar);
        }
        this.f2049c.e().a(aVar, this.f2048b);
        return aVar;
    }

    public int a() {
        return h().a();
    }

    public short b() {
        return h().d();
    }

    public short c() {
        return h().e();
    }

    public short d() {
        return h().c();
    }

    public int e() {
        return this.f2050d;
    }

    public void a(boolean z) {
        this.f2050d = z ? 2 : 1;
    }

    public boolean f() {
        return h().b();
    }

    public int a(int i) {
        return h().a(i);
    }

    public int g() {
        return h().f();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", id:");
        sb.append(Integer.toHexString(a()));
        sb.append(", codepoints:");
        int g2 = g();
        for (int i = 0; i < g2; i++) {
            sb.append(Integer.toHexString(a(i)));
            sb.append(SQLBuilder.BLANK);
        }
        return sb.toString();
    }
}

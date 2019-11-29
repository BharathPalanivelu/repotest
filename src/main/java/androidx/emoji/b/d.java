package androidx.emoji.b;

import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.core.util.e;

public abstract class d extends ReplacementSpan {

    /* renamed from: a  reason: collision with root package name */
    private final Paint.FontMetricsInt f2065a = new Paint.FontMetricsInt();

    /* renamed from: b  reason: collision with root package name */
    private final b f2066b;

    /* renamed from: c  reason: collision with root package name */
    private short f2067c = -1;

    /* renamed from: d  reason: collision with root package name */
    private short f2068d = -1;

    /* renamed from: e  reason: collision with root package name */
    private float f2069e = 1.0f;

    d(b bVar) {
        e.a(bVar, (Object) "metadata cannot be null");
        this.f2066b = bVar;
    }

    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        paint.getFontMetricsInt(this.f2065a);
        this.f2069e = (((float) Math.abs(this.f2065a.descent - this.f2065a.ascent)) * 1.0f) / ((float) this.f2066b.c());
        this.f2068d = (short) ((int) (((float) this.f2066b.c()) * this.f2069e));
        this.f2067c = (short) ((int) (((float) this.f2066b.b()) * this.f2069e));
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = this.f2065a.ascent;
            fontMetricsInt.descent = this.f2065a.descent;
            fontMetricsInt.top = this.f2065a.top;
            fontMetricsInt.bottom = this.f2065a.bottom;
        }
        return this.f2067c;
    }

    /* access modifiers changed from: package-private */
    public final b a() {
        return this.f2066b;
    }

    /* access modifiers changed from: package-private */
    public final int b() {
        return this.f2067c;
    }
}

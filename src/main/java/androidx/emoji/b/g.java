package androidx.emoji.b;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;

public final class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private static Paint f2082a;

    public g(b bVar) {
        super(bVar);
    }

    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f2, int i3, int i4, int i5, Paint paint) {
        if (a.a().d()) {
            canvas.drawRect(f2, (float) i3, f2 + ((float) b()), (float) i5, c());
        }
        a().a(canvas, f2, (float) i4, paint);
    }

    private static Paint c() {
        if (f2082a == null) {
            f2082a = new TextPaint();
            f2082a.setColor(a.a().e());
            f2082a.setStyle(Paint.Style.FILL);
        }
        return f2082a;
    }
}

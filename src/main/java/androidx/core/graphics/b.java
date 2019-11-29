package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.d;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<d<Rect, Rect>> f1821a = new ThreadLocal<>();

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("󟿽");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f2 = BitmapDescriptorFactory.HUE_RED;
        if (measureText3 == BitmapDescriptorFactory.HUE_RED) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f2 += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f2) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        d<Rect, Rect> a2 = a();
        paint.getTextBounds("󟿽", 0, 2, (Rect) a2.f1882a);
        paint.getTextBounds(str, 0, length, (Rect) a2.f1883b);
        return !((Rect) a2.f1882a).equals(a2.f1883b);
    }

    private static d<Rect, Rect> a() {
        d<Rect, Rect> dVar = f1821a.get();
        if (dVar == null) {
            d<Rect, Rect> dVar2 = new d<>(new Rect(), new Rect());
            f1821a.set(dVar2);
            return dVar2;
        }
        ((Rect) dVar.f1882a).setEmpty();
        ((Rect) dVar.f1883b).setEmpty();
        return dVar;
    }
}

package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.g.w;
import androidx.recyclerview.a;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class k implements j {

    /* renamed from: a  reason: collision with root package name */
    static final j f2950a = new k();

    public void b(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i, boolean z) {
    }

    public void b(View view) {
    }

    k() {
    }

    public void a(Canvas canvas, RecyclerView recyclerView, View view, float f2, float f3, int i, boolean z) {
        if (Build.VERSION.SDK_INT >= 21 && z && view.getTag(a.b.item_touch_helper_previous_elevation) == null) {
            Float valueOf = Float.valueOf(w.o(view));
            w.b(view, a(recyclerView, view) + 1.0f);
            view.setTag(a.b.item_touch_helper_previous_elevation, valueOf);
        }
        view.setTranslationX(f2);
        view.setTranslationY(f3);
    }

    private static float a(RecyclerView recyclerView, View view) {
        int childCount = recyclerView.getChildCount();
        float f2 = BitmapDescriptorFactory.HUE_RED;
        for (int i = 0; i < childCount; i++) {
            View childAt = recyclerView.getChildAt(i);
            if (childAt != view) {
                float o = w.o(childAt);
                if (o > f2) {
                    f2 = o;
                }
            }
        }
        return f2;
    }

    public void a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            Object tag = view.getTag(a.b.item_touch_helper_previous_elevation);
            if (tag != null && (tag instanceof Float)) {
                w.b(view, ((Float) tag).floatValue());
            }
            view.setTag(a.b.item_touch_helper_previous_elevation, (Object) null);
        }
        view.setTranslationX(BitmapDescriptorFactory.HUE_RED);
        view.setTranslationY(BitmapDescriptorFactory.HUE_RED);
    }
}

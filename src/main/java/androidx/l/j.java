package androidx.l;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

class j {
    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
        return PropertyValuesHolder.ofFloat(new i(property, path), new float[]{BitmapDescriptorFactory.HUE_RED, 1.0f});
    }
}

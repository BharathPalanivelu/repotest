package androidx.l;

import android.os.Build;
import android.view.ViewGroup;

class y {
    static x a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new w(viewGroup);
        }
        return v.a(viewGroup);
    }

    static void a(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 18) {
            aa.a(viewGroup, z);
        } else {
            z.a(viewGroup, z);
        }
    }
}

package com.airbnb.lottie;

import androidx.b.b;
import com.airbnb.lottie.f.d;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class m {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3772a = false;

    /* renamed from: b  reason: collision with root package name */
    private final Set<a> f3773b = new b();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, d> f3774c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Comparator<androidx.core.util.d<String, Float>> f3775d = new Comparator<androidx.core.util.d<String, Float>>() {
        /* renamed from: a */
        public int compare(androidx.core.util.d<String, Float> dVar, androidx.core.util.d<String, Float> dVar2) {
            float floatValue = ((Float) dVar.f1883b).floatValue();
            float floatValue2 = ((Float) dVar2.f1883b).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    public interface a {
        void a(float f2);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
        this.f3772a = z;
    }

    public void a(String str, float f2) {
        if (this.f3772a) {
            d dVar = this.f3774c.get(str);
            if (dVar == null) {
                dVar = new d();
                this.f3774c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                for (a a2 : this.f3773b) {
                    a2.a(f2);
                }
            }
        }
    }
}

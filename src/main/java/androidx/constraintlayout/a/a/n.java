package androidx.constraintlayout.a.a;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class n extends o {

    /* renamed from: a  reason: collision with root package name */
    float f1410a = BitmapDescriptorFactory.HUE_RED;

    public void b() {
        super.b();
        this.f1410a = BitmapDescriptorFactory.HUE_RED;
    }

    public void a(int i) {
        if (this.i == 0 || this.f1410a != ((float) i)) {
            this.f1410a = (float) i;
            if (this.i == 1) {
                e();
            }
            f();
        }
    }

    public void c() {
        this.i = 2;
    }
}

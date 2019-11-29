package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.b.a.d;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

public class b implements DrawerLayout.c {

    /* renamed from: a  reason: collision with root package name */
    boolean f633a;

    /* renamed from: b  reason: collision with root package name */
    private final a f634b;

    /* renamed from: c  reason: collision with root package name */
    private d f635c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f636d;

    /* renamed from: e  reason: collision with root package name */
    private final int f637e;

    /* renamed from: f  reason: collision with root package name */
    private final int f638f;

    public interface a {
        void a(int i);
    }

    public void onDrawerStateChanged(int i) {
    }

    public void onDrawerSlide(View view, float f2) {
        if (this.f636d) {
            a(Math.min(1.0f, Math.max(BitmapDescriptorFactory.HUE_RED, f2)));
        } else {
            a((float) BitmapDescriptorFactory.HUE_RED);
        }
    }

    public void onDrawerOpened(View view) {
        a(1.0f);
        if (this.f633a) {
            a(this.f638f);
        }
    }

    public void onDrawerClosed(View view) {
        a((float) BitmapDescriptorFactory.HUE_RED);
        if (this.f633a) {
            a(this.f637e);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        this.f634b.a(i);
    }

    private void a(float f2) {
        if (f2 == 1.0f) {
            this.f635c.a(true);
        } else if (f2 == BitmapDescriptorFactory.HUE_RED) {
            this.f635c.a(false);
        }
        this.f635c.a(f2);
    }
}

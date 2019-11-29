package life.knowledge4.videotrimmer.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;
import java.util.Vector;
import life.knowledge4.videotrimmer.a;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f33796a;

    /* renamed from: b  reason: collision with root package name */
    private float f33797b = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: c  reason: collision with root package name */
    private float f33798c = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f33799d;

    /* renamed from: e  reason: collision with root package name */
    private int f33800e;

    /* renamed from: f  reason: collision with root package name */
    private int f33801f;

    /* renamed from: g  reason: collision with root package name */
    private float f33802g;

    private a() {
    }

    public int a() {
        return this.f33796a;
    }

    private void a(int i) {
        this.f33796a = i;
    }

    public float b() {
        return this.f33797b;
    }

    public void a(float f2) {
        this.f33797b = f2;
    }

    public float c() {
        return this.f33798c;
    }

    public void b(float f2) {
        this.f33798c = f2;
    }

    public Bitmap d() {
        return this.f33799d;
    }

    private void a(Bitmap bitmap) {
        this.f33799d = bitmap;
        this.f33800e = bitmap.getWidth();
        this.f33801f = bitmap.getHeight();
    }

    public static List<a> a(Resources resources) {
        Vector vector = new Vector();
        for (int i = 0; i < 2; i++) {
            a aVar = new a();
            aVar.a(i);
            if (i == 0) {
                aVar.a(BitmapFactory.decodeResource(resources, a.c.ic_video_sliders));
            } else {
                aVar.a(BitmapFactory.decodeResource(resources, a.c.ic_video_sliders));
            }
            vector.add(aVar);
        }
        return vector;
    }

    public static int a(List<a> list) {
        return list.get(0).f();
    }

    public static int b(List<a> list) {
        return list.get(0).g();
    }

    public float e() {
        return this.f33802g;
    }

    public void c(float f2) {
        this.f33802g = f2;
    }

    public int f() {
        return this.f33800e;
    }

    private int g() {
        return this.f33801f;
    }
}

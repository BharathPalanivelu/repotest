package com.google.maps.android.a.b;

import android.graphics.Color;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.a.i;
import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class n extends i {

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, String> f14415d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashSet<String> f14416e = new HashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private boolean f14417f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14418g = true;
    private String h;
    private double i = 1.0d;
    private String j = null;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private float n = BitmapDescriptorFactory.HUE_RED;

    n() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.f14415d.put("text", str);
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        this.j = str;
    }

    public boolean c(String str) {
        return this.f14416e.contains(str);
    }

    public boolean c() {
        return this.f14417f;
    }

    public void a(boolean z) {
        this.f14417f = z;
    }

    /* access modifiers changed from: package-private */
    public double d() {
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public void a(double d2) {
        this.i = d2;
        this.f14416e.add("iconScale");
    }

    public boolean e() {
        return this.f14418g;
    }

    public boolean f() {
        return this.f14415d.size() > 0;
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z) {
        this.f14418g = z;
        this.f14416e.add("outline");
    }

    public String g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        this.h = str;
        this.f14416e.add("iconUrl");
    }

    /* access modifiers changed from: package-private */
    public void e(String str) {
        a(Color.parseColor("#" + k(str)));
        this.f14416e.add("fillColor");
    }

    /* access modifiers changed from: package-private */
    public void f(String str) {
        this.n = c(Color.parseColor("#" + k(str)));
        this.f14432a.icon(BitmapDescriptorFactory.defaultMarker(this.n));
        this.f14416e.add("markerColor");
    }

    private static float c(int i2) {
        float[] fArr = new float[3];
        Color.colorToHSV(i2, fArr);
        return fArr[0];
    }

    private static String k(String str) {
        String str2;
        if (str.length() > 6) {
            str2 = str.substring(0, 2) + str.substring(6, 8) + str.substring(4, 6) + str.substring(2, 4);
        } else {
            str2 = str.substring(4, 6) + str.substring(2, 4) + str.substring(0, 2);
        }
        if (!str2.substring(0, 1).equals(SQLBuilder.BLANK)) {
            return str2;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + str2.substring(1, str2.length());
    }

    /* access modifiers changed from: package-private */
    public void d(float f2) {
        a(f2);
        this.f14416e.add("heading");
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, float f3, String str, String str2) {
        a(f2, f3, str, str2);
        this.f14416e.add("hotSpot");
    }

    /* access modifiers changed from: package-private */
    public void g(String str) {
        this.k = str.equals("random");
        this.f14416e.add("iconColorMode");
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public void h(String str) {
        this.l = str.equals("random");
        this.f14416e.add("lineColorMode");
    }

    public boolean i() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void i(String str) {
        this.m = str.equals("random");
        this.f14416e.add("polyColorMode");
    }

    public boolean j() {
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public void j(String str) {
        PolylineOptions polylineOptions = this.f14433b;
        polylineOptions.color(Color.parseColor("#" + k(str)));
        PolygonOptions polygonOptions = this.f14434c;
        polygonOptions.strokeColor(Color.parseColor("#" + str));
        this.f14416e.add("outlineColor");
    }

    /* access modifiers changed from: package-private */
    public void a(Float f2) {
        b(f2.floatValue());
        c(f2.floatValue());
        this.f14416e.add("width");
    }

    public HashMap<String, String> k() {
        return this.f14415d;
    }

    private static MarkerOptions a(MarkerOptions markerOptions, boolean z, float f2) {
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.rotation(markerOptions.getRotation());
        markerOptions2.anchor(markerOptions.getAnchorU(), markerOptions.getAnchorV());
        if (z) {
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(c(b((int) f2))));
        }
        markerOptions2.icon(markerOptions.getIcon());
        return markerOptions2;
    }

    private static PolylineOptions a(PolylineOptions polylineOptions) {
        PolylineOptions polylineOptions2 = new PolylineOptions();
        polylineOptions2.color(polylineOptions.getColor());
        polylineOptions2.width(polylineOptions.getWidth());
        return polylineOptions2;
    }

    private static PolygonOptions a(PolygonOptions polygonOptions, boolean z, boolean z2) {
        PolygonOptions polygonOptions2 = new PolygonOptions();
        if (z) {
            polygonOptions2.fillColor(polygonOptions.getFillColor());
        }
        if (z2) {
            polygonOptions2.strokeColor(polygonOptions.getStrokeColor());
            polygonOptions2.strokeWidth(polygonOptions.getStrokeWidth());
        }
        return polygonOptions2;
    }

    public MarkerOptions l() {
        return a(this.f14432a, h(), this.n);
    }

    public PolylineOptions m() {
        return a(this.f14433b);
    }

    public PolygonOptions n() {
        return a(this.f14434c, this.f14417f, this.f14418g);
    }

    public static int b(int i2) {
        Random random = new Random();
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        if (red != 0) {
            red = random.nextInt(red);
        }
        if (blue != 0) {
            blue = random.nextInt(blue);
        }
        if (green != 0) {
            green = random.nextInt(green);
        }
        return Color.rgb(red, green, blue);
    }

    public String toString() {
        return "Style" + "{" + "\n balloon options=" + this.f14415d + ",\n fill=" + this.f14417f + ",\n outline=" + this.f14418g + ",\n icon url=" + this.h + ",\n scale=" + this.i + ",\n style id=" + this.j + "\n}\n";
    }
}

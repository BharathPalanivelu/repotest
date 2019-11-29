package com.google.maps.android.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.a;
import com.google.maps.android.a.a.a;
import com.google.maps.android.a.a.d;
import com.google.maps.android.a.a.f;
import com.google.maps.android.a.a.g;
import com.google.maps.android.a.a.i;
import com.google.maps.android.a.a.j;
import com.google.maps.android.a.a.l;
import com.google.maps.android.a.b.b;
import com.google.maps.android.a.b.e;
import com.google.maps.android.a.b.k;
import com.google.maps.android.a.b.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f14424a = null;

    /* renamed from: b  reason: collision with root package name */
    private GoogleMap f14425b;

    /* renamed from: c  reason: collision with root package name */
    private final a<b> f14426c = new a<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, n> f14427d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, n> f14428e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, String> f14429f;

    /* renamed from: g  reason: collision with root package name */
    private a<b> f14430g;
    private HashMap<e, GroundOverlay> h;
    private final ArrayList<String> i;
    private final androidx.b.e<String, Bitmap> j;
    private boolean k;
    /* access modifiers changed from: private */
    public Context l;
    private ArrayList<b> m;
    private final j n;
    private final com.google.maps.android.a.a.e o;
    private final l p;

    public h(GoogleMap googleMap, Context context) {
        this.f14425b = googleMap;
        this.l = context;
        this.k = false;
        this.j = new androidx.b.e<>(50);
        this.i = new ArrayList<>();
        this.f14428e = new HashMap<>();
        this.n = null;
        this.o = null;
        this.p = null;
        this.f14430g = new a<>();
    }

    public boolean a() {
        return this.k;
    }

    /* access modifiers changed from: protected */
    public void a(boolean z) {
        this.k = z;
    }

    /* access modifiers changed from: protected */
    public void a(Object obj, b bVar) {
        this.f14430g.put(bVar, obj);
    }

    /* access modifiers changed from: protected */
    public HashMap<? extends b, Object> b() {
        return this.f14426c;
    }

    public ArrayList<String> c() {
        return this.i;
    }

    public HashMap<String, n> d() {
        return this.f14428e;
    }

    public HashMap<String, String> e() {
        return this.f14429f;
    }

    public androidx.b.e<String, Bitmap> f() {
        return this.j;
    }

    public HashMap<e, GroundOverlay> g() {
        return this.h;
    }

    public ArrayList<b> h() {
        return this.m;
    }

    /* access modifiers changed from: protected */
    public n a(String str) {
        return this.f14428e.get(str) != null ? this.f14428e.get(str) : this.f14428e.get((Object) null);
    }

    public void i() {
        this.f14428e.putAll(this.f14427d);
    }

    public void a(HashMap<String, n> hashMap) {
        this.f14428e.putAll(hashMap);
    }

    public void a(String str, Bitmap bitmap) {
        this.j.put(str, bitmap);
    }

    private void a(com.google.maps.android.a.a.b bVar) {
        if (bVar.e() == null) {
            bVar.a(this.n);
        }
        if (bVar.f() == null) {
            bVar.a(this.o);
        }
        if (bVar.g() == null) {
            bVar.a(this.p);
        }
    }

    /* access modifiers changed from: protected */
    public void a(HashMap<String, n> hashMap, HashMap<String, String> hashMap2, HashMap<com.google.maps.android.a.b.j, Object> hashMap3, ArrayList<b> arrayList, HashMap<e, GroundOverlay> hashMap4) {
        this.f14427d = hashMap;
        this.f14429f = hashMap2;
        this.f14426c.putAll(hashMap3);
        this.m = arrayList;
        this.h = hashMap4;
    }

    public void a(b bVar) {
        Object obj = f14424a;
        if (bVar instanceof com.google.maps.android.a.a.b) {
            a((com.google.maps.android.a.a.b) bVar);
        }
        if (this.k) {
            if (this.f14426c.containsKey(bVar)) {
                a(this.f14426c.get(bVar));
            }
            if (bVar.d()) {
                if (bVar instanceof com.google.maps.android.a.b.j) {
                    com.google.maps.android.a.b.j jVar = (com.google.maps.android.a.b.j) bVar;
                    obj = a(jVar, bVar.c(), a(bVar.b()), jVar.f(), b(bVar));
                } else {
                    obj = a(bVar, bVar.c());
                }
            }
        }
        this.f14426c.put(bVar, obj);
    }

    public static void a(Object obj) {
        if (obj instanceof Marker) {
            ((Marker) obj).remove();
        } else if (obj instanceof Polyline) {
            ((Polyline) obj).remove();
        } else if (obj instanceof Polygon) {
            ((Polygon) obj).remove();
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                a(it.next());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.google.android.gms.maps.model.MarkerOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: com.google.android.gms.maps.model.PolylineOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.google.android.gms.maps.model.PolygonOptions} */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v18 */
    /* JADX WARNING: type inference failed for: r1v19 */
    /* JADX WARNING: type inference failed for: r1v20 */
    /* JADX WARNING: type inference failed for: r1v21 */
    /* JADX WARNING: type inference failed for: r1v22 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(com.google.maps.android.a.b r3, com.google.maps.android.a.c r4) {
        /*
            r2 = this;
            java.lang.String r0 = r4.c()
            int r1 = r0.hashCode()
            switch(r1) {
                case -2116761119: goto L_0x0048;
                case -1065891849: goto L_0x003e;
                case -627102946: goto L_0x0034;
                case 77292912: goto L_0x002a;
                case 1267133722: goto L_0x0020;
                case 1806700869: goto L_0x0016;
                case 1950410960: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x0052
        L_0x000c:
            java.lang.String r1 = "GeometryCollection"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 6
            goto L_0x0053
        L_0x0016:
            java.lang.String r1 = "LineString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 1
            goto L_0x0053
        L_0x0020:
            java.lang.String r1 = "Polygon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 2
            goto L_0x0053
        L_0x002a:
            java.lang.String r1 = "Point"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 0
            goto L_0x0053
        L_0x0034:
            java.lang.String r1 = "MultiLineString"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 4
            goto L_0x0053
        L_0x003e:
            java.lang.String r1 = "MultiPoint"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 3
            goto L_0x0053
        L_0x0048:
            java.lang.String r1 = "MultiPolygon"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0052
            r0 = 5
            goto L_0x0053
        L_0x0052:
            r0 = -1
        L_0x0053:
            r1 = 0
            switch(r0) {
                case 0: goto L_0x00c4;
                case 1: goto L_0x00a8;
                case 2: goto L_0x008c;
                case 3: goto L_0x007f;
                case 4: goto L_0x0072;
                case 5: goto L_0x0065;
                case 6: goto L_0x0058;
                default: goto L_0x0057;
            }
        L_0x0057:
            return r1
        L_0x0058:
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.maps.android.a.a.c r4 = (com.google.maps.android.a.a.c) r4
            java.util.List r4 = r4.b()
            java.util.ArrayList r3 = r2.a((com.google.maps.android.a.a.b) r3, (java.util.List<com.google.maps.android.a.c>) r4)
            return r3
        L_0x0065:
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.maps.android.a.a.l r3 = r3.g()
            com.google.maps.android.a.a.h r4 = (com.google.maps.android.a.a.h) r4
            java.util.ArrayList r3 = r2.a((com.google.maps.android.a.a.l) r3, (com.google.maps.android.a.a.h) r4)
            return r3
        L_0x0072:
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.maps.android.a.a.e r3 = r3.f()
            com.google.maps.android.a.a.f r4 = (com.google.maps.android.a.a.f) r4
            java.util.ArrayList r3 = r2.a((com.google.maps.android.a.a.e) r3, (com.google.maps.android.a.a.f) r4)
            return r3
        L_0x007f:
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.maps.android.a.a.j r3 = r3.e()
            com.google.maps.android.a.a.g r4 = (com.google.maps.android.a.a.g) r4
            java.util.ArrayList r3 = r2.a((com.google.maps.android.a.a.j) r3, (com.google.maps.android.a.a.g) r4)
            return r3
        L_0x008c:
            boolean r0 = r3 instanceof com.google.maps.android.a.a.b
            if (r0 == 0) goto L_0x0097
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.android.gms.maps.model.PolygonOptions r1 = r3.h()
            goto L_0x00a1
        L_0x0097:
            boolean r0 = r3 instanceof com.google.maps.android.a.b.j
            if (r0 == 0) goto L_0x00a1
            com.google.maps.android.a.b.j r3 = (com.google.maps.android.a.b.j) r3
            com.google.android.gms.maps.model.PolygonOptions r1 = r3.g()
        L_0x00a1:
            com.google.maps.android.a.a r4 = (com.google.maps.android.a.a) r4
            com.google.android.gms.maps.model.Polygon r3 = r2.a((com.google.android.gms.maps.model.PolygonOptions) r1, (com.google.maps.android.a.a) r4)
            return r3
        L_0x00a8:
            boolean r0 = r3 instanceof com.google.maps.android.a.a.b
            if (r0 == 0) goto L_0x00b3
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.android.gms.maps.model.PolylineOptions r1 = r3.j()
            goto L_0x00bd
        L_0x00b3:
            boolean r0 = r3 instanceof com.google.maps.android.a.b.j
            if (r0 == 0) goto L_0x00bd
            com.google.maps.android.a.b.j r3 = (com.google.maps.android.a.b.j) r3
            com.google.android.gms.maps.model.PolylineOptions r1 = r3.i()
        L_0x00bd:
            com.google.maps.android.a.a.d r4 = (com.google.maps.android.a.a.d) r4
            com.google.android.gms.maps.model.Polyline r3 = r2.a((com.google.android.gms.maps.model.PolylineOptions) r1, (com.google.maps.android.a.e) r4)
            return r3
        L_0x00c4:
            boolean r0 = r3 instanceof com.google.maps.android.a.a.b
            if (r0 == 0) goto L_0x00cf
            com.google.maps.android.a.a.b r3 = (com.google.maps.android.a.a.b) r3
            com.google.android.gms.maps.model.MarkerOptions r1 = r3.i()
            goto L_0x00d9
        L_0x00cf:
            boolean r0 = r3 instanceof com.google.maps.android.a.b.j
            if (r0 == 0) goto L_0x00d9
            com.google.maps.android.a.b.j r3 = (com.google.maps.android.a.b.j) r3
            com.google.android.gms.maps.model.MarkerOptions r1 = r3.h()
        L_0x00d9:
            com.google.maps.android.a.a.i r4 = (com.google.maps.android.a.a.i) r4
            com.google.android.gms.maps.model.Marker r3 = r2.a((com.google.android.gms.maps.model.MarkerOptions) r1, (com.google.maps.android.a.g) r4)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.a.h.a(com.google.maps.android.a.b, com.google.maps.android.a.c):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public Object a(com.google.maps.android.a.b.j jVar, c cVar, n nVar, n nVar2, boolean z) {
        String c2 = cVar.c();
        boolean b2 = jVar.b("drawOrder");
        float f2 = BitmapDescriptorFactory.HUE_RED;
        if (b2) {
            try {
                f2 = Float.parseFloat(jVar.a("drawOrder"));
            } catch (NumberFormatException unused) {
                b2 = false;
            }
        }
        char c3 = 65535;
        switch (c2.hashCode()) {
            case 77292912:
                if (c2.equals("Point")) {
                    c3 = 0;
                    break;
                }
                break;
            case 89139371:
                if (c2.equals("MultiGeometry")) {
                    c3 = 3;
                    break;
                }
                break;
            case 1267133722:
                if (c2.equals("Polygon")) {
                    c3 = 2;
                    break;
                }
                break;
            case 1806700869:
                if (c2.equals("LineString")) {
                    c3 = 1;
                    break;
                }
                break;
        }
        if (c3 == 0) {
            MarkerOptions l2 = nVar.l();
            if (nVar2 != null) {
                a(l2, nVar2, nVar.g());
            } else if (nVar.g() != null) {
                a(nVar.g(), l2);
            }
            Marker a2 = a(l2, (g) (k) cVar);
            a2.setVisible(z);
            a(nVar, a2, jVar);
            if (b2) {
                a2.setZIndex(f2);
            }
            return a2;
        } else if (c3 == 1) {
            PolylineOptions m2 = nVar.m();
            if (nVar2 != null) {
                a(m2, nVar2);
            } else if (nVar.i()) {
                m2.color(n.b(m2.getColor()));
            }
            Polyline a3 = a(m2, (e) cVar);
            a3.setVisible(z);
            if (b2) {
                a3.setZIndex(f2);
            }
            return a3;
        } else if (c3 == 2) {
            PolygonOptions n2 = nVar.n();
            if (nVar2 != null) {
                a(n2, nVar2);
            } else if (nVar.j()) {
                n2.fillColor(n.b(n2.getFillColor()));
            }
            Polygon a4 = a(n2, (a) cVar);
            a4.setVisible(z);
            if (b2) {
                a4.setZIndex(f2);
            }
            return a4;
        } else if (c3 != 3) {
            return null;
        } else {
            return a(jVar, (com.google.maps.android.a.b.h) cVar, nVar, nVar2, z);
        }
    }

    /* access modifiers changed from: protected */
    public Marker a(MarkerOptions markerOptions, g gVar) {
        markerOptions.position(gVar.d());
        return this.f14425b.addMarker(markerOptions);
    }

    private void a(MarkerOptions markerOptions, n nVar, String str) {
        MarkerOptions l2 = nVar.l();
        if (nVar.c("heading")) {
            markerOptions.rotation(l2.getRotation());
        }
        if (nVar.c("hotSpot")) {
            markerOptions.anchor(l2.getAnchorU(), l2.getAnchorV());
        }
        if (nVar.c("markerColor")) {
            markerOptions.icon(l2.getIcon());
        }
        if (nVar.c("iconUrl")) {
            a(nVar.g(), markerOptions);
        } else if (str != null) {
            a(str, markerOptions);
        }
    }

    /* access modifiers changed from: protected */
    public Polyline a(PolylineOptions polylineOptions, e eVar) {
        polylineOptions.addAll(eVar.d());
        Polyline addPolyline = this.f14425b.addPolyline(polylineOptions);
        addPolyline.setClickable(true);
        return addPolyline;
    }

    private void a(PolylineOptions polylineOptions, n nVar) {
        PolylineOptions m2 = nVar.m();
        if (nVar.c("outlineColor")) {
            polylineOptions.color(m2.getColor());
        }
        if (nVar.c("width")) {
            polylineOptions.width(m2.getWidth());
        }
        if (nVar.i()) {
            polylineOptions.color(n.b(m2.getColor()));
        }
    }

    /* access modifiers changed from: protected */
    public Polygon a(PolygonOptions polygonOptions, a aVar) {
        polygonOptions.addAll(aVar.a());
        for (List<LatLng> addHole : aVar.b()) {
            polygonOptions.addHole(addHole);
        }
        Polygon addPolygon = this.f14425b.addPolygon(polygonOptions);
        addPolygon.setClickable(true);
        return addPolygon;
    }

    private void a(PolygonOptions polygonOptions, n nVar) {
        PolygonOptions n2 = nVar.n();
        if (nVar.c() && nVar.c("fillColor")) {
            polygonOptions.fillColor(n2.getFillColor());
        }
        if (nVar.e()) {
            if (nVar.c("outlineColor")) {
                polygonOptions.strokeColor(n2.getStrokeColor());
            }
            if (nVar.c("width")) {
                polygonOptions.strokeWidth(n2.getStrokeWidth());
            }
        }
        if (nVar.j()) {
            polygonOptions.fillColor(n.b(n2.getFillColor()));
        }
    }

    private ArrayList<Object> a(com.google.maps.android.a.a.b bVar, List<c> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (c a2 : list) {
            arrayList.add(a((b) bVar, a2));
        }
        return arrayList;
    }

    protected static boolean b(b bVar) {
        return !bVar.b("visibility") || Integer.parseInt(bVar.a("visibility")) != 0;
    }

    public void a(HashMap<String, String> hashMap, HashMap<String, n> hashMap2) {
        for (String next : hashMap.keySet()) {
            String str = hashMap.get(next);
            if (hashMap2.containsKey(str)) {
                hashMap2.put(next, hashMap2.get(str));
            }
        }
    }

    private ArrayList<Object> a(com.google.maps.android.a.b.j jVar, com.google.maps.android.a.b.h hVar, n nVar, n nVar2, boolean z) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<c> it = hVar.d().iterator();
        while (it.hasNext()) {
            arrayList.add(a(jVar, it.next(), nVar, nVar2, z));
        }
        return arrayList;
    }

    private ArrayList<Marker> a(j jVar, g gVar) {
        ArrayList<Marker> arrayList = new ArrayList<>();
        for (i a2 : gVar.b()) {
            arrayList.add(a(jVar.m(), (g) a2));
        }
        return arrayList;
    }

    private ArrayList<Polyline> a(com.google.maps.android.a.a.e eVar, f fVar) {
        ArrayList<Polyline> arrayList = new ArrayList<>();
        for (d a2 : fVar.b()) {
            arrayList.add(a(eVar.i(), (e) a2));
        }
        return arrayList;
    }

    private ArrayList<Polygon> a(l lVar, com.google.maps.android.a.a.h hVar) {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (com.google.maps.android.a.a.k a2 : hVar.b()) {
            arrayList.add(a(lVar.i(), (a) a2));
        }
        return arrayList;
    }

    private void a(String str, MarkerOptions markerOptions) {
        if (this.j.get(str) != null) {
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(this.j.get(str)));
        } else if (!this.i.contains(str)) {
            this.i.add(str);
        }
    }

    public GroundOverlay a(GroundOverlayOptions groundOverlayOptions) {
        return this.f14425b.addGroundOverlay(groundOverlayOptions);
    }

    private void a(n nVar, Marker marker, com.google.maps.android.a.b.j jVar) {
        boolean b2 = jVar.b("name");
        boolean b3 = jVar.b("description");
        boolean f2 = nVar.f();
        boolean containsKey = nVar.k().containsKey("text");
        if (f2 && containsKey) {
            marker.setTitle(nVar.k().get("text"));
            j();
        } else if (f2 && b2) {
            marker.setTitle(jVar.a("name"));
            j();
        } else if (b2 && b3) {
            marker.setTitle(jVar.a("name"));
            marker.setSnippet(jVar.a("description"));
            j();
        } else if (b3) {
            marker.setTitle(jVar.a("description"));
            j();
        } else if (b2) {
            marker.setTitle(jVar.a("name"));
            j();
        }
    }

    private void j() {
        this.f14425b.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            public View getInfoWindow(Marker marker) {
                return null;
            }

            public View getInfoContents(Marker marker) {
                View inflate = LayoutInflater.from(h.this.l).inflate(a.b.amu_info_window, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(a.C0238a.window);
                if (marker.getSnippet() != null) {
                    textView.setText(Html.fromHtml(marker.getTitle() + "<br>" + marker.getSnippet()));
                } else {
                    textView.setText(Html.fromHtml(marker.getTitle()));
                }
                return inflate;
            }
        });
    }
}

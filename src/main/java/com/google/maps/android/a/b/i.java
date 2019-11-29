package com.google.maps.android.a.b;

import com.google.android.gms.maps.model.GroundOverlay;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class i {

    /* renamed from: a  reason: collision with root package name */
    private final XmlPullParser f14396a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<j, Object> f14397b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<b> f14398c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, n> f14399d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, String> f14400e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<e, GroundOverlay> f14401f = new HashMap<>();

    i(XmlPullParser xmlPullParser) {
        this.f14396a = xmlPullParser;
    }

    /* access modifiers changed from: package-private */
    public void a() throws XmlPullParserException, IOException {
        int eventType = this.f14396a.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                if (this.f14396a.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                    a(this.f14396a);
                }
                if (this.f14396a.getName().matches("Folder|Document")) {
                    this.f14398c.add(c.a(this.f14396a));
                }
                if (this.f14396a.getName().equals("Style")) {
                    n a2 = o.a(this.f14396a);
                    this.f14399d.put(a2.b(), a2);
                }
                if (this.f14396a.getName().equals("StyleMap")) {
                    this.f14400e.putAll(o.b(this.f14396a));
                }
                if (this.f14396a.getName().equals("Placemark")) {
                    this.f14397b.put(d.a(this.f14396a), (Object) null);
                }
                if (this.f14396a.getName().equals("GroundOverlay")) {
                    this.f14401f.put(d.b(this.f14396a), (Object) null);
                }
            }
            eventType = this.f14396a.next();
        }
        this.f14399d.put((Object) null, new n());
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, n> b() {
        return this.f14399d;
    }

    /* access modifiers changed from: package-private */
    public HashMap<j, Object> c() {
        return this.f14397b;
    }

    /* access modifiers changed from: package-private */
    public HashMap<String, String> d() {
        return this.f14400e;
    }

    /* access modifiers changed from: package-private */
    public ArrayList<b> e() {
        return this.f14398c;
    }

    /* access modifiers changed from: package-private */
    public HashMap<e, GroundOverlay> f() {
        return this.f14401f;
    }

    static void a(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (xmlPullParser.getEventType() == 2) {
            int i = 1;
            while (i != 0) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    i++;
                } else if (next == 3) {
                    i--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }
}

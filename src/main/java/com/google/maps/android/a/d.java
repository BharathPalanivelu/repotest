package com.google.maps.android.a;

import com.google.maps.android.a.b.b;
import com.google.maps.android.a.b.m;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    private h f14419a;

    /* access modifiers changed from: protected */
    public void a() throws IOException, XmlPullParserException {
        h hVar = this.f14419a;
        if (hVar instanceof m) {
            ((m) hVar).j();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        this.f14419a = hVar;
    }

    /* access modifiers changed from: protected */
    public Iterable<b> b() {
        h hVar = this.f14419a;
        if (hVar instanceof m) {
            return ((m) hVar).k();
        }
        return null;
    }
}

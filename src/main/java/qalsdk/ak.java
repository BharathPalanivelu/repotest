package qalsdk;

import com.g.a.a.c;
import com.g.a.a.e;
import com.g.a.a.f;
import com.g.a.a.g;
import com.g.a.a.h;

public final class ak extends g implements Cloneable {
    private static /* synthetic */ boolean h = (!ak.class.desiredAssertionStatus());

    /* renamed from: a  reason: collision with root package name */
    public String f34097a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f34098b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f34099c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f34100d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f34101e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f34102f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f34103g = 0;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        ak akVar = (ak) obj;
        if (!h.a((Object) this.f34097a, (Object) akVar.f34097a) || !h.a((Object) this.f34098b, (Object) akVar.f34098b) || !h.a((Object) this.f34099c, (Object) akVar.f34099c) || !h.a((Object) this.f34100d, (Object) akVar.f34100d) || !h.a(this.f34101e, akVar.f34101e) || !h.a(this.f34102f, akVar.f34102f) || !h.a(this.f34103g, akVar.f34103g)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (h) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final void writeTo(f fVar) {
        fVar.a(this.f34097a, 1);
        fVar.a(this.f34098b, 2);
        fVar.a(this.f34099c, 3);
        fVar.a(this.f34100d, 4);
        fVar.a(this.f34101e, 5);
        fVar.a(this.f34102f, 6);
        fVar.a(this.f34103g, 7);
    }

    public final void readFrom(e eVar) {
        this.f34097a = eVar.a(1, true);
        this.f34098b = eVar.a(2, true);
        this.f34099c = eVar.a(3, true);
        this.f34100d = eVar.a(4, true);
        this.f34101e = eVar.a(this.f34101e, 5, true);
        this.f34102f = eVar.a(this.f34102f, 6, true);
        this.f34103g = eVar.a(this.f34103g, 7, true);
    }

    public final void display(StringBuilder sb, int i) {
        c cVar = new c(sb, i);
        cVar.a(this.f34097a, "apn");
        cVar.a(this.f34098b, "wifi_supplicant_state");
        cVar.a(this.f34099c, "wifi_ssid");
        cVar.a(this.f34100d, "wifi_bssid");
        cVar.a(this.f34101e, "wifi_rssi");
        cVar.a(this.f34102f, "rat");
        cVar.a(this.f34103g, "rat_ss");
    }
}

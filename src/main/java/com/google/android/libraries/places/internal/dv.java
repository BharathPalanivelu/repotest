package com.google.android.libraries.places.internal;

import android.graphics.Bitmap;
import com.google.android.libraries.places.internal.ib;
import com.google.android.libraries.places.internal.ie;
import com.google.android.libraries.places.internal.iy;

public class dv implements ny {

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f12481a;

    public static iy.a a(dw dwVar) {
        iy.c cVar;
        MessageType messagetype;
        int ordinal = dwVar.c().ordinal();
        if (ordinal == 0) {
            cVar = iy.c.PROGRAMMATIC_API;
        } else if (ordinal != 1) {
            cVar = iy.c.UNKNOWN_SOURCE;
        } else {
            cVar = iy.c.AUTOCOMPLETE_WIDGET;
        }
        iy.a aVar = (iy.a) iy.o.f();
        ie.a aVar2 = (ie.a) ie.f12684d.f();
        String a2 = dwVar.a();
        aVar2.b();
        ie ieVar = (ie) aVar2.f12904a;
        if (a2 != null) {
            ieVar.f12686a |= 1;
            ieVar.f12687b = a2;
            int b2 = dwVar.b();
            aVar2.b();
            ie ieVar2 = (ie) aVar2.f12904a;
            ieVar2.f12686a |= 2;
            ieVar2.f12688c = b2;
            if (aVar2.f12905b) {
                messagetype = aVar2.f12904a;
            } else {
                aVar2.f12904a.e();
                aVar2.f12905b = true;
                messagetype = aVar2.f12904a;
            }
            kv kvVar = (kv) messagetype;
            if (kvVar.g()) {
                ie ieVar3 = (ie) kvVar;
                aVar.b();
                iy iyVar = (iy) aVar.f12904a;
                if (ieVar3 != null) {
                    iyVar.f12778c = ieVar3;
                    iyVar.f12776a |= 4;
                    aVar.b();
                    iy iyVar2 = (iy) aVar.f12904a;
                    iyVar2.f12776a |= 16777216;
                    iyVar2.k = true;
                    aVar.b();
                    iy iyVar3 = (iy) aVar.f12904a;
                    if (cVar != null) {
                        iyVar3.f12776a |= 536870912;
                        iyVar3.n = cVar.f12795d;
                        aVar.b();
                        iy iyVar4 = (iy) aVar.f12904a;
                        iyVar4.f12776a |= 134217728;
                        iyVar4.m = "1.1.0";
                        return aVar;
                    }
                    throw new NullPointerException();
                }
                throw new NullPointerException();
            }
            throw new ne();
        }
        throw new NullPointerException();
    }

    public static ib a(iy iyVar) {
        MessageType messagetype;
        ib.a aVar = (ib.a) ib.f12670d.f();
        ib.b bVar = ib.b.PLACES;
        aVar.b();
        ib ibVar = (ib) aVar.f12904a;
        if (bVar != null) {
            ibVar.f12672a |= 1;
            ibVar.f12673b = bVar.f12682b;
            aVar.b();
            ib ibVar2 = (ib) aVar.f12904a;
            if (iyVar != null) {
                ibVar2.f12674c = iyVar;
                ibVar2.f12672a |= 2;
                if (aVar.f12905b) {
                    messagetype = aVar.f12904a;
                } else {
                    aVar.f12904a.e();
                    aVar.f12905b = true;
                    messagetype = aVar.f12904a;
                }
                kv kvVar = (kv) messagetype;
                if (kvVar.g()) {
                    return (ib) kvVar;
                }
                throw new ne();
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }

    public static u a(fw fwVar, d dVar, j jVar, ds dsVar, a aVar) {
        return new u(fwVar, dVar, jVar, dsVar, aVar);
    }

    public /* synthetic */ Object b() {
        throw new NoSuchMethodError();
    }

    public dv a(Bitmap bitmap) {
        this.f12481a = bitmap;
        return this;
    }

    /* renamed from: c */
    public af a() {
        go.b(this.f12481a != null, (Object) "Photo must be set to non-null value.");
        return new af(this.f12481a);
    }
}

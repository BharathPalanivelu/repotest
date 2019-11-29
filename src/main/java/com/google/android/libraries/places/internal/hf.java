package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.util.Map;

final class hf implements Serializable {
    public static final long serialVersionUID = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f12648a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f12649b;

    hf(hd<?, ?> hdVar) {
        this.f12648a = new Object[hdVar.size()];
        this.f12649b = new Object[hdVar.size()];
        hu huVar = (hu) ((hg) hdVar.entrySet()).iterator();
        int i = 0;
        while (huVar.hasNext()) {
            Map.Entry entry = (Map.Entry) huVar.next();
            this.f12648a[i] = entry.getKey();
            this.f12649b[i] = entry.getValue();
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public final Object readResolve() {
        he heVar = new he(this.f12648a.length);
        int i = 0;
        while (true) {
            Object[] objArr = this.f12648a;
            if (i >= objArr.length) {
                return heVar.a();
            }
            heVar.a(objArr[i], this.f12649b[i]);
            i++;
        }
    }
}

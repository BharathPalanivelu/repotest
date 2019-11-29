package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AddressComponent;
import com.google.android.libraries.places.api.model.AddressComponents;
import java.util.List;

abstract class bc extends AddressComponents {

    /* renamed from: a  reason: collision with root package name */
    private final List<AddressComponent> f12361a;

    bc(List<AddressComponent> list) {
        if (list != null) {
            this.f12361a = list;
            return;
        }
        throw new NullPointerException("Null asList");
    }

    public List<AddressComponent> asList() {
        return this.f12361a;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f12361a);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 26);
        sb.append("AddressComponents{asList=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddressComponents) {
            return this.f12361a.equals(((AddressComponents) obj).asList());
        }
        return false;
    }

    public int hashCode() {
        return this.f12361a.hashCode() ^ 1000003;
    }
}

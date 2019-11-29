package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AddressComponent;
import java.util.List;

abstract class ba extends AddressComponent {

    /* renamed from: a  reason: collision with root package name */
    private final String f12355a;

    /* renamed from: b  reason: collision with root package name */
    private final String f12356b;

    /* renamed from: c  reason: collision with root package name */
    private final List<String> f12357c;

    ba(String str, String str2, List<String> list) {
        if (str != null) {
            this.f12355a = str;
            this.f12356b = str2;
            if (list != null) {
                this.f12357c = list;
                return;
            }
            throw new NullPointerException("Null types");
        }
        throw new NullPointerException("Null name");
    }

    public String getName() {
        return this.f12355a;
    }

    public String getShortName() {
        return this.f12356b;
    }

    public List<String> getTypes() {
        return this.f12357c;
    }

    public String toString() {
        String str = this.f12355a;
        String str2 = this.f12356b;
        String valueOf = String.valueOf(this.f12357c);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("AddressComponent{name=");
        sb.append(str);
        sb.append(", shortName=");
        sb.append(str2);
        sb.append(", types=");
        sb.append(valueOf);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddressComponent) {
            AddressComponent addressComponent = (AddressComponent) obj;
            if (this.f12355a.equals(addressComponent.getName())) {
                String str = this.f12356b;
                if (str != null ? str.equals(addressComponent.getShortName()) : addressComponent.getShortName() == null) {
                    if (this.f12357c.equals(addressComponent.getTypes())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.f12355a.hashCode() ^ 1000003) * 1000003;
        String str = this.f12356b;
        return ((hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f12357c.hashCode();
    }
}

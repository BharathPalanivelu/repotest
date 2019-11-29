package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

abstract class bd extends AutocompletePrediction {

    /* renamed from: a  reason: collision with root package name */
    private final String f12362a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Place.Type> f12363b;

    /* renamed from: c  reason: collision with root package name */
    private final String f12364c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12365d;

    /* renamed from: e  reason: collision with root package name */
    private final String f12366e;

    /* renamed from: f  reason: collision with root package name */
    private final List<AutocompletePrediction.a> f12367f;

    /* renamed from: g  reason: collision with root package name */
    private final List<AutocompletePrediction.a> f12368g;
    private final List<AutocompletePrediction.a> h;

    bd(String str, List<Place.Type> list, String str2, String str3, String str4, List<AutocompletePrediction.a> list2, List<AutocompletePrediction.a> list3, List<AutocompletePrediction.a> list4) {
        if (str != null) {
            this.f12362a = str;
            if (list != null) {
                this.f12363b = list;
                if (str2 != null) {
                    this.f12364c = str2;
                    if (str3 != null) {
                        this.f12365d = str3;
                        if (str4 != null) {
                            this.f12366e = str4;
                            this.f12367f = list2;
                            this.f12368g = list3;
                            this.h = list4;
                            return;
                        }
                        throw new NullPointerException("Null secondaryText");
                    }
                    throw new NullPointerException("Null primaryText");
                }
                throw new NullPointerException("Null fullText");
            }
            throw new NullPointerException("Null placeTypes");
        }
        throw new NullPointerException("Null placeId");
    }

    public String getPlaceId() {
        return this.f12362a;
    }

    public List<Place.Type> getPlaceTypes() {
        return this.f12363b;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f12364c;
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        return this.f12365d;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.f12366e;
    }

    /* access modifiers changed from: package-private */
    public final List<AutocompletePrediction.a> d() {
        return this.f12367f;
    }

    /* access modifiers changed from: package-private */
    public final List<AutocompletePrediction.a> e() {
        return this.f12368g;
    }

    /* access modifiers changed from: package-private */
    public final List<AutocompletePrediction.a> f() {
        return this.h;
    }

    public String toString() {
        String str = this.f12362a;
        String valueOf = String.valueOf(this.f12363b);
        String str2 = this.f12364c;
        String str3 = this.f12365d;
        String str4 = this.f12366e;
        String valueOf2 = String.valueOf(this.f12367f);
        String valueOf3 = String.valueOf(this.f12368g);
        String valueOf4 = String.valueOf(this.h);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 178 + String.valueOf(valueOf).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("AutocompletePrediction{placeId=");
        sb.append(str);
        sb.append(", placeTypes=");
        sb.append(valueOf);
        sb.append(", fullText=");
        sb.append(str2);
        sb.append(", primaryText=");
        sb.append(str3);
        sb.append(", secondaryText=");
        sb.append(str4);
        sb.append(", fullTextMatchedSubstrings=");
        sb.append(valueOf2);
        sb.append(", primaryTextMatchedSubstrings=");
        sb.append(valueOf3);
        sb.append(", secondaryTextMatchedSubstrings=");
        sb.append(valueOf4);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AutocompletePrediction) {
            AutocompletePrediction autocompletePrediction = (AutocompletePrediction) obj;
            if (this.f12362a.equals(autocompletePrediction.getPlaceId()) && this.f12363b.equals(autocompletePrediction.getPlaceTypes()) && this.f12364c.equals(autocompletePrediction.a()) && this.f12365d.equals(autocompletePrediction.b()) && this.f12366e.equals(autocompletePrediction.c())) {
                List<AutocompletePrediction.a> list = this.f12367f;
                if (list != null ? list.equals(autocompletePrediction.d()) : autocompletePrediction.d() == null) {
                    List<AutocompletePrediction.a> list2 = this.f12368g;
                    if (list2 != null ? list2.equals(autocompletePrediction.e()) : autocompletePrediction.e() == null) {
                        List<AutocompletePrediction.a> list3 = this.h;
                        return list3 != null ? list3.equals(autocompletePrediction.f()) : autocompletePrediction.f() == null;
                    }
                }
            }
        }
    }

    public int hashCode() {
        int hashCode = (((((((((this.f12362a.hashCode() ^ 1000003) * 1000003) ^ this.f12363b.hashCode()) * 1000003) ^ this.f12364c.hashCode()) * 1000003) ^ this.f12365d.hashCode()) * 1000003) ^ this.f12366e.hashCode()) * 1000003;
        List<AutocompletePrediction.a> list = this.f12367f;
        int i = 0;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<AutocompletePrediction.a> list2 = this.f12368g;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        List<AutocompletePrediction.a> list3 = this.h;
        if (list3 != null) {
            i = list3.hashCode();
        }
        return hashCode3 ^ i;
    }
}

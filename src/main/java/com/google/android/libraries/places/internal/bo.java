package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.PhotoMetadata;

abstract class bo extends PhotoMetadata {

    /* renamed from: a  reason: collision with root package name */
    private final String f12393a;

    /* renamed from: b  reason: collision with root package name */
    private final int f12394b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12395c;

    /* renamed from: d  reason: collision with root package name */
    private final String f12396d;

    bo(String str, int i, int i2, String str2) {
        if (str != null) {
            this.f12393a = str;
            this.f12394b = i;
            this.f12395c = i2;
            if (str2 != null) {
                this.f12396d = str2;
                return;
            }
            throw new NullPointerException("Null photoReference");
        }
        throw new NullPointerException("Null attributions");
    }

    public String getAttributions() {
        return this.f12393a;
    }

    public int getHeight() {
        return this.f12394b;
    }

    public int getWidth() {
        return this.f12395c;
    }

    public final String a() {
        return this.f12396d;
    }

    public String toString() {
        String str = this.f12393a;
        int i = this.f12394b;
        int i2 = this.f12395c;
        String str2 = this.f12396d;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 84 + String.valueOf(str2).length());
        sb.append("PhotoMetadata{attributions=");
        sb.append(str);
        sb.append(", height=");
        sb.append(i);
        sb.append(", width=");
        sb.append(i2);
        sb.append(", photoReference=");
        sb.append(str2);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PhotoMetadata) {
            PhotoMetadata photoMetadata = (PhotoMetadata) obj;
            return this.f12393a.equals(photoMetadata.getAttributions()) && this.f12394b == photoMetadata.getHeight() && this.f12395c == photoMetadata.getWidth() && this.f12396d.equals(photoMetadata.a());
        }
    }

    public int hashCode() {
        return ((((((this.f12393a.hashCode() ^ 1000003) * 1000003) ^ this.f12394b) * 1000003) ^ this.f12395c) * 1000003) ^ this.f12396d.hashCode();
    }
}

package androidx.media;

import android.annotation.TargetApi;
import android.media.AudioAttributes;

@TargetApi(21)
class b implements a {

    /* renamed from: a  reason: collision with root package name */
    AudioAttributes f2658a;

    /* renamed from: b  reason: collision with root package name */
    int f2659b = -1;

    b() {
    }

    public int hashCode() {
        return this.f2658a.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        return this.f2658a.equals(((b) obj).f2658a);
    }

    public String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f2658a;
    }
}

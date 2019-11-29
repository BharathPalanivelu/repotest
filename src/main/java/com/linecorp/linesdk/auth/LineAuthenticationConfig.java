package com.linecorp.linesdk.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class LineAuthenticationConfig implements Parcelable {
    public static final Parcelable.Creator<LineAuthenticationConfig> CREATOR = new Parcelable.Creator<LineAuthenticationConfig>() {
        /* renamed from: a */
        public final LineAuthenticationConfig createFromParcel(Parcel parcel) {
            return new LineAuthenticationConfig(parcel);
        }

        /* renamed from: a */
        public final LineAuthenticationConfig[] newArray(int i) {
            return new LineAuthenticationConfig[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private static int f15040a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static int f15041b = 2;

    /* renamed from: c  reason: collision with root package name */
    private final String f15042c;

    /* renamed from: d  reason: collision with root package name */
    private final Uri f15043d;

    /* renamed from: e  reason: collision with root package name */
    private final Uri f15044e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f15045f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15046g;

    public int describeContents() {
        return 0;
    }

    private LineAuthenticationConfig(a aVar) {
        this.f15042c = aVar.f15047a;
        this.f15043d = aVar.f15048b;
        this.f15044e = aVar.f15049c;
        this.f15045f = aVar.f15050d;
        this.f15046g = aVar.f15051e;
    }

    private LineAuthenticationConfig(Parcel parcel) {
        this.f15042c = parcel.readString();
        this.f15043d = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f15044e = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        int readInt = parcel.readInt();
        boolean z = true;
        this.f15045f = (f15040a & readInt) > 0;
        this.f15046g = (readInt & f15041b) <= 0 ? false : z;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f15042c);
        parcel.writeParcelable(this.f15043d, i);
        parcel.writeParcelable(this.f15044e, i);
        int i2 = 0;
        int i3 = (this.f15045f ? f15040a : 0) | 0;
        if (this.f15046g) {
            i2 = f15041b;
        }
        parcel.writeInt(i3 | i2);
    }

    public String a() {
        return this.f15042c;
    }

    public Uri b() {
        return this.f15043d;
    }

    public Uri c() {
        return this.f15044e;
    }

    public boolean d() {
        return this.f15045f;
    }

    public boolean e() {
        return this.f15046g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LineAuthenticationConfig lineAuthenticationConfig = (LineAuthenticationConfig) obj;
        if (this.f15045f == lineAuthenticationConfig.f15045f && this.f15046g == lineAuthenticationConfig.f15046g && this.f15042c.equals(lineAuthenticationConfig.f15042c) && this.f15043d.equals(lineAuthenticationConfig.f15043d)) {
            return this.f15044e.equals(lineAuthenticationConfig.f15044e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.f15042c.hashCode() * 31) + this.f15043d.hashCode()) * 31) + this.f15044e.hashCode()) * 31) + (this.f15045f ? 1 : 0)) * 31) + (this.f15046g ? 1 : 0);
    }

    public String toString() {
        return "LineAuthenticationConfig{channelId=" + this.f15042c + ", endPointBaseUrl=" + this.f15043d + ", webLoginPageUrl=" + this.f15044e + ", isLineAppAuthenticationDisabled=" + this.f15045f + ", isEncryptorPreparationDisabled=" + this.f15046g + '}';
    }

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f15047a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Uri f15048b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Uri f15049c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f15050d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f15051e;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f15047a = str;
                this.f15048b = Uri.parse("https://access.line.me/v2");
                this.f15049c = Uri.parse("https://access.line.me/dialog/oauth/weblogin");
                return;
            }
            throw new IllegalArgumentException("channelId is empty.");
        }

        public LineAuthenticationConfig a() {
            return new LineAuthenticationConfig(this);
        }
    }
}

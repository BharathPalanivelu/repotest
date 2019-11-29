package com.shopee.sdk.modules.ui.navigator;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public class NavigationPath implements Parcelable {
    public static final Parcelable.Creator<NavigationPath> CREATOR = new Parcelable.Creator<NavigationPath>() {
        /* renamed from: a */
        public NavigationPath createFromParcel(Parcel parcel) {
            return new NavigationPath(parcel);
        }

        /* renamed from: a */
        public NavigationPath[] newArray(int i) {
            return new NavigationPath[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f30437a;

    /* renamed from: b  reason: collision with root package name */
    private Class<? extends Activity> f30438b;

    /* renamed from: c  reason: collision with root package name */
    private String f30439c;

    /* renamed from: d  reason: collision with root package name */
    private String f30440d;

    public int describeContents() {
        return 0;
    }

    private NavigationPath(a aVar) {
        this.f30437a = aVar.f30441a;
        this.f30438b = aVar.f30442b;
        this.f30439c = aVar.f30443c;
        this.f30440d = aVar.f30444d;
    }

    public static NavigationPath a(String str) {
        return new a().a(str).a();
    }

    public static NavigationPath a(Class<? extends Activity> cls) {
        return new a().a(cls).a();
    }

    public static NavigationPath b(String str) {
        return new a().b(str).a();
    }

    public static NavigationPath c(String str) {
        return new a().c(str).a();
    }

    public String a() {
        return this.f30437a;
    }

    public Class<? extends Activity> b() {
        return this.f30438b;
    }

    public String c() {
        return this.f30439c;
    }

    public String d() {
        return this.f30440d;
    }

    public boolean e() {
        return !TextUtils.isEmpty(this.f30437a);
    }

    public boolean f() {
        return this.f30438b != null;
    }

    public boolean g() {
        return !TextUtils.isEmpty(this.f30439c);
    }

    public boolean h() {
        return !TextUtils.isEmpty(this.f30440d);
    }

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f30441a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Class f30442b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30443c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f30444d;

        public a a(String str) {
            this.f30441a = str;
            return this;
        }

        public a a(Class<? extends Activity> cls) {
            this.f30442b = cls;
            return this;
        }

        public a b(String str) {
            this.f30443c = str;
            return this;
        }

        public a c(String str) {
            this.f30444d = str;
            return this;
        }

        public NavigationPath a() {
            return new NavigationPath(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f30437a);
        parcel.writeSerializable(this.f30438b);
        parcel.writeString(this.f30439c);
        parcel.writeString(this.f30440d);
    }

    protected NavigationPath(Parcel parcel) {
        this.f30437a = parcel.readString();
        this.f30438b = (Class) parcel.readSerializable();
        this.f30439c = parcel.readString();
        this.f30440d = parcel.readString();
    }
}

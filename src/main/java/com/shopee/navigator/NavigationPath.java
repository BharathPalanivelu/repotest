package com.shopee.navigator;

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
    private Class<? extends Activity> f30096a;

    /* renamed from: b  reason: collision with root package name */
    private String f30097b;

    /* renamed from: c  reason: collision with root package name */
    private String f30098c;

    public int describeContents() {
        return 0;
    }

    private NavigationPath(a aVar) {
        this.f30096a = aVar.f30099a;
        this.f30097b = aVar.f30100b;
        this.f30098c = aVar.f30101c;
    }

    public static NavigationPath a(Class<? extends Activity> cls) {
        return new a().a(cls).a();
    }

    public static NavigationPath a(String str) {
        return new a().a(str).a();
    }

    public Class<? extends Activity> a() {
        return this.f30096a;
    }

    public String b() {
        return this.f30098c;
    }

    public boolean c() {
        return this.f30096a != null;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f30098c);
    }

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public Class<? extends Activity> f30099a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f30100b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f30101c;

        public a a(Class<? extends Activity> cls) {
            this.f30099a = cls;
            return this;
        }

        public a a(String str) {
            this.f30101c = str;
            return this;
        }

        public NavigationPath a() {
            return new NavigationPath(this);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(this.f30096a);
        parcel.writeString(this.f30097b);
        parcel.writeString(this.f30098c);
    }

    protected NavigationPath(Parcel parcel) {
        this.f30096a = (Class) parcel.readSerializable();
        this.f30097b = parcel.readString();
        this.f30098c = parcel.readString();
    }
}

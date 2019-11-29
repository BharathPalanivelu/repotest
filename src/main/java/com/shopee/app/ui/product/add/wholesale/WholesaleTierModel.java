package com.shopee.app.ui.product.add.wholesale;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class WholesaleTierModel implements Parcelable {
    public static final Parcelable.Creator<WholesaleTierModel> CREATOR = new Parcelable.Creator<WholesaleTierModel>() {
        /* renamed from: a */
        public WholesaleTierModel createFromParcel(Parcel parcel) {
            return new WholesaleTierModel(parcel);
        }

        /* renamed from: a */
        public WholesaleTierModel[] newArray(int i) {
            return new WholesaleTierModel[i];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public String f24170a;

    /* renamed from: b  reason: collision with root package name */
    public String f24171b;

    /* renamed from: c  reason: collision with root package name */
    public String f24172c;

    /* renamed from: d  reason: collision with root package name */
    public long f24173d;

    /* renamed from: e  reason: collision with root package name */
    private List<WholesaleTierModel> f24174e;

    public int describeContents() {
        return 0;
    }

    private WholesaleTierModel(List<WholesaleTierModel> list, String str, String str2, String str3, long j) {
        this.f24174e = list;
        this.f24170a = str;
        this.f24171b = str2;
        this.f24172c = str3;
        this.f24173d = j;
    }

    public boolean a() {
        if (!this.f24174e.contains(this)) {
            return false;
        }
        int indexOf = this.f24174e.indexOf(this);
        if (indexOf == 0) {
            return true;
        }
        return !TextUtils.isEmpty(this.f24174e.get(indexOf - 1).f24171b);
    }

    public boolean b() {
        return this.f24174e.indexOf(this) == 0;
    }

    public boolean a(WholesaleTierModel wholesaleTierModel) {
        return wholesaleTierModel.f24171b.equals(this.f24171b) && wholesaleTierModel.f24170a.equals(this.f24170a) && wholesaleTierModel.f24172c.equals(this.f24172c);
    }

    public void a(List<WholesaleTierModel> list) {
        this.f24174e = list;
    }

    public void a(long j) {
        this.f24173d = j;
    }

    public static a c() {
        return new a();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private List<WholesaleTierModel> f24175a;

        /* renamed from: b  reason: collision with root package name */
        private String f24176b;

        /* renamed from: c  reason: collision with root package name */
        private String f24177c;

        /* renamed from: d  reason: collision with root package name */
        private String f24178d;

        /* renamed from: e  reason: collision with root package name */
        private long f24179e;

        public a a(List<WholesaleTierModel> list) {
            this.f24175a = list;
            return this;
        }

        public a a(String str) {
            this.f24176b = str;
            return this;
        }

        public a b(String str) {
            this.f24177c = str;
            return this;
        }

        public a c(String str) {
            this.f24178d = str;
            return this;
        }

        public WholesaleTierModel a() {
            if (this.f24176b == null) {
                this.f24176b = "";
            }
            if (this.f24177c == null) {
                this.f24177c = "";
            }
            if (this.f24178d == null) {
                this.f24178d = "";
            }
            return new WholesaleTierModel(this.f24175a, this.f24176b, this.f24177c, this.f24178d, this.f24179e);
        }
    }

    protected WholesaleTierModel(Parcel parcel) {
        this.f24174e = new ArrayList();
        this.f24170a = parcel.readString();
        this.f24171b = parcel.readString();
        this.f24172c = parcel.readString();
        this.f24173d = parcel.readLong();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f24170a);
        parcel.writeString(this.f24171b);
        parcel.writeString(this.f24172c);
        parcel.writeLong(this.f24173d);
    }
}

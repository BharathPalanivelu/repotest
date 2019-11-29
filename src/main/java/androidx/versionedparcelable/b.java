package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.b.a;
import java.lang.reflect.Method;

class b extends a {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f3044d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f3045e;

    /* renamed from: f  reason: collision with root package name */
    private final int f3046f;

    /* renamed from: g  reason: collision with root package name */
    private final int f3047g;
    private final String h;
    private int i;
    private int j;
    private int k;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new a(), new a(), new a());
    }

    private b(Parcel parcel, int i2, int i3, String str, a<String, Method> aVar, a<String, Method> aVar2, a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f3044d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.f3045e = parcel;
        this.f3046f = i2;
        this.f3047g = i3;
        this.j = this.f3046f;
        this.h = str;
    }

    public boolean b(int i2) {
        while (this.j < this.f3047g) {
            int i3 = this.k;
            if (i3 == i2) {
                return true;
            }
            if (String.valueOf(i3).compareTo(String.valueOf(i2)) > 0) {
                return false;
            }
            this.f3045e.setDataPosition(this.j);
            int readInt = this.f3045e.readInt();
            this.k = this.f3045e.readInt();
            this.j += readInt;
        }
        if (this.k == i2) {
            return true;
        }
        return false;
    }

    public void c(int i2) {
        b();
        this.i = i2;
        this.f3044d.put(i2, this.f3045e.dataPosition());
        a(0);
        a(i2);
    }

    public void b() {
        int i2 = this.i;
        if (i2 >= 0) {
            int i3 = this.f3044d.get(i2);
            int dataPosition = this.f3045e.dataPosition();
            this.f3045e.setDataPosition(i3);
            this.f3045e.writeInt(dataPosition - i3);
            this.f3045e.setDataPosition(dataPosition);
        }
    }

    /* access modifiers changed from: protected */
    public a c() {
        Parcel parcel = this.f3045e;
        int dataPosition = parcel.dataPosition();
        int i2 = this.j;
        if (i2 == this.f3046f) {
            i2 = this.f3047g;
        }
        int i3 = i2;
        return new b(parcel, dataPosition, i3, this.h + "  ", this.f3041a, this.f3042b, this.f3043c);
    }

    public void a(byte[] bArr) {
        if (bArr != null) {
            this.f3045e.writeInt(bArr.length);
            this.f3045e.writeByteArray(bArr);
            return;
        }
        this.f3045e.writeInt(-1);
    }

    public void a(int i2) {
        this.f3045e.writeInt(i2);
    }

    public void a(String str) {
        this.f3045e.writeString(str);
    }

    public void a(Parcelable parcelable) {
        this.f3045e.writeParcelable(parcelable, 0);
    }

    public void a(boolean z) {
        this.f3045e.writeInt(z ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public void a(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f3045e, 0);
    }

    /* access modifiers changed from: protected */
    public CharSequence g() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f3045e);
    }

    public int d() {
        return this.f3045e.readInt();
    }

    public String e() {
        return this.f3045e.readString();
    }

    public byte[] f() {
        int readInt = this.f3045e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f3045e.readByteArray(bArr);
        return bArr;
    }

    public <T extends Parcelable> T h() {
        return this.f3045e.readParcelable(getClass().getClassLoader());
    }

    public boolean i() {
        return this.f3045e.readInt() != 0;
    }
}

package com.shopee.app.data.viewmodel.camera;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.litesuits.orm.db.assit.SQLBuilder;
import com.shopee.app.web.protocol.OpenICCamera3Message;
import d.d.b.j;

public final class IcCamera3Info implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    public static final int TYPE_IC = 2;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_SELFIE = 1;
    private final int type;

    public static /* synthetic */ IcCamera3Info copy$default(IcCamera3Info icCamera3Info, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = icCamera3Info.type;
        }
        return icCamera3Info.copy(i);
    }

    public final int component1() {
        return this.type;
    }

    public final IcCamera3Info copy(int i) {
        return new IcCamera3Info(i);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof IcCamera3Info) {
                if (this.type == ((IcCamera3Info) obj).type) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Integer.valueOf(this.type).hashCode();
    }

    public String toString() {
        return "IcCamera3Info(type=" + this.type + SQLBuilder.PARENTHESES_RIGHT;
    }

    public IcCamera3Info(int i) {
        this.type = i;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public IcCamera3Info(Parcel parcel) {
        this(parcel.readInt());
        j.b(parcel, "parcel");
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.b(parcel, "parcel");
        parcel.writeInt(this.type);
    }

    public static final class CREATOR implements Parcelable.Creator<IcCamera3Info> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public IcCamera3Info createFromParcel(Parcel parcel) {
            j.b(parcel, "parcel");
            return new IcCamera3Info(parcel);
        }

        public IcCamera3Info[] newArray(int i) {
            return new IcCamera3Info[i];
        }

        public final IcCamera3Info fromMessage(OpenICCamera3Message openICCamera3Message) {
            j.b(openICCamera3Message, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new IcCamera3Info(openICCamera3Message.getType());
        }
    }
}

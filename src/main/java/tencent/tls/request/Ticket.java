package tencent.tls.request;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import tencent.tls.tools.util;

public class Ticket implements Parcelable {
    public static final Parcelable.Creator<Ticket> CREATOR = new Parcelable.Creator<Ticket>() {
        public Ticket createFromParcel(Parcel parcel) {
            return new Ticket(parcel);
        }

        public Ticket[] newArray(int i) {
            return new Ticket[i];
        }
    };
    public long CreateTime;
    public long ExpireTime;
    public byte[] Sig;
    public byte[] SigKey;
    public int Type;
    protected Map<String, byte[]> _pskey_map;
    public int accountType;
    public String appidAt3rd;

    public int describeContents() {
        return 0;
    }

    public Ticket() {
        this._pskey_map = new HashMap();
    }

    public Ticket(int i, byte[] bArr, byte[] bArr2, long j, long j2) {
        this._pskey_map = new HashMap();
        this.Type = i;
        this.Sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this.SigKey = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this.CreateTime = j;
        this.ExpireTime = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Ticket(int i, int i2, String str, byte[] bArr, byte[] bArr2, long j, long j2) {
        this(i, bArr, bArr2, j, j2);
        this.accountType = i2;
        this.appidAt3rd = str;
    }

    protected Ticket(int i, byte[] bArr, byte[] bArr2, long j, long j2, byte[] bArr3) {
        this._pskey_map = new HashMap();
        this.Type = i;
        this.Sig = bArr == null ? new byte[0] : (byte[]) bArr.clone();
        this.SigKey = bArr2 == null ? new byte[0] : (byte[]) bArr2.clone();
        this.CreateTime = j;
        this.ExpireTime = j2;
        parsePsBuf(bArr3);
    }

    private void parsePsBuf(byte[] bArr) {
        if (bArr != null && bArr.length > 2) {
            int buf_to_int16 = util.buf_to_int16(bArr, 0);
            int i = 0;
            int i2 = 2;
            while (i < buf_to_int16) {
                int i3 = i2 + 2;
                if (bArr.length >= i3) {
                    int buf_to_int162 = util.buf_to_int16(bArr, i2);
                    int i4 = i3 + buf_to_int162;
                    if (bArr.length >= i4) {
                        String str = new String(bArr, i3, buf_to_int162);
                        int i5 = i4 + 2;
                        if (bArr.length >= i5) {
                            int buf_to_int163 = util.buf_to_int16(bArr, i4);
                            int i6 = i5 + buf_to_int163;
                            if (bArr.length >= i6) {
                                byte[] bArr2 = new byte[buf_to_int163];
                                System.arraycopy(bArr, i5, bArr2, 0, buf_to_int163);
                                this._pskey_map.put(str, bArr2);
                                i++;
                                i2 = i6;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Type);
        parcel.writeInt(this.accountType);
        parcel.writeString(this.appidAt3rd);
        parcel.writeByteArray(this.Sig);
        parcel.writeByteArray(this.SigKey);
        parcel.writeLong(this.CreateTime);
        parcel.writeLong(this.ExpireTime);
        parcel.writeMap(this._pskey_map);
    }

    public void readFromParcel(Parcel parcel) {
        this.Type = parcel.readInt();
        this.accountType = parcel.readInt();
        this.appidAt3rd = parcel.readString();
        this.Sig = parcel.createByteArray();
        this.SigKey = parcel.createByteArray();
        this.CreateTime = parcel.readLong();
        this.ExpireTime = parcel.readLong();
        this._pskey_map = parcel.readHashMap(Map.class.getClassLoader());
    }

    private Ticket(Parcel parcel) {
        this._pskey_map = new HashMap();
        readFromParcel(parcel);
    }
}

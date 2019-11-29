package tencent.tls.tlvs;

import tencent.tls.tools.MD5;
import tencent.tls.tools.util;

public class tlv_t184 extends tlv_t {
    byte[] _mS2 = new byte[0];

    public tlv_t184() {
        this._cmd = 388;
    }

    public boolean verify() {
        if (this._body_len < 16) {
            return false;
        }
        this._mS2 = new byte[16];
        System.arraycopy(this._buf, this._head_len, this._mS2, 0, 16);
        return true;
    }

    public byte[] getMS2() {
        return this._mS2;
    }

    public byte[] get_tlv_184(long j, String str) {
        byte[] mD5Byte = MD5.toMD5Byte(str);
        int length = mD5Byte.length;
        byte[] bArr = new byte[(length + 8)];
        System.arraycopy(mD5Byte, 0, bArr, 0, length);
        util.int64_to_buf(bArr, length + 0, j);
        byte[] mD5Byte2 = MD5.toMD5Byte(bArr);
        set_data(mD5Byte2, mD5Byte2.length);
        return get_buf();
    }
}

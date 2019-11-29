package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t141 extends tlv_t {
    int _version = 1;

    public tlv_t141() {
        this._cmd = 321;
    }

    public byte[] get_tlv_141(byte[] bArr, int i, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int length = bArr.length + 4 + 2 + 2 + bArr2.length;
        byte[] bArr3 = new byte[length];
        util.int16_to_buf(bArr3, 0, this._version);
        util.int16_to_buf(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length2 = 4 + bArr.length;
        util.int16_to_buf(bArr3, length2, i);
        int i2 = length2 + 2;
        util.int16_to_buf(bArr3, i2, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, i2 + 2, bArr2.length);
        int length3 = bArr2.length;
        set_data(bArr3, length);
        return get_buf();
    }
}

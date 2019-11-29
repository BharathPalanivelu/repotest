package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t2 extends tlv_t {
    int _sigVer = 0;
    int _t2_body_len = 0;

    public tlv_t2() {
        this._cmd = 2;
    }

    public byte[] get_tlv_2(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        this._t2_body_len = bArr.length + 6 + bArr2.length;
        byte[] bArr3 = new byte[this._t2_body_len];
        util.int16_to_buf(bArr3, 0, this._sigVer);
        util.int16_to_buf(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length = 4 + bArr.length;
        util.int16_to_buf(bArr3, length, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length + 2, bArr2.length);
        int length2 = bArr2.length;
        set_data(bArr3, this._t2_body_len);
        return get_buf();
    }
}

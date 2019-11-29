package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t127 extends tlv_t {
    int _t127_body_len = 0;
    int _version = 0;

    public tlv_t127() {
        this._cmd = 295;
    }

    public byte[] get_tlv_127(byte[] bArr, byte[] bArr2) {
        this._t127_body_len = bArr.length + 4 + 2 + bArr2.length;
        byte[] bArr3 = new byte[this._t127_body_len];
        util.int16_to_buf(bArr3, 0, this._version);
        util.int16_to_buf(bArr3, 2, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 4, bArr.length);
        int length = 4 + bArr.length;
        util.int16_to_buf(bArr3, length, bArr2.length);
        System.arraycopy(bArr2, 0, bArr3, length + 2, bArr2.length);
        int length2 = bArr2.length;
        set_data(bArr3, bArr3.length);
        return get_buf();
    }
}

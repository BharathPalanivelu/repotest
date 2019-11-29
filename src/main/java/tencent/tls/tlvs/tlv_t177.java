package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t177 extends tlv_t {
    int _t177_body_len = 0;

    public tlv_t177() {
        this._cmd = 375;
    }

    public byte[] get_tlv_177(long j, String str) {
        byte[] bArr = new byte[0];
        if (str != null) {
            bArr = str.getBytes();
        }
        this._t177_body_len = bArr.length + 7;
        byte[] bArr2 = new byte[this._t177_body_len];
        util.int8_to_buf(bArr2, 0, 1);
        util.int64_to_buf32(bArr2, 1, j);
        util.int16_to_buf(bArr2, 5, bArr.length);
        System.arraycopy(bArr, 0, bArr2, 7, bArr.length);
        int length = bArr.length;
        set_data(bArr2, this._t177_body_len);
        return get_buf();
    }
}

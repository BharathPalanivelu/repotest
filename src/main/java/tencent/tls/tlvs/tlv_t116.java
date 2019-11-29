package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t116 extends tlv_t {
    int _t116_body_len = 0;
    int _ver = 0;

    public tlv_t116() {
        this._cmd = 278;
    }

    public byte[] get_tlv_116(int i, int i2, long[] jArr) {
        if (jArr == null) {
            jArr = new long[0];
        }
        int i3 = 10;
        this._t116_body_len = (jArr.length * 4) + 10;
        byte[] bArr = new byte[this._t116_body_len];
        util.int8_to_buf(bArr, 0, this._ver);
        util.int32_to_buf(bArr, 1, i);
        util.int32_to_buf(bArr, 5, i2);
        util.int8_to_buf(bArr, 9, jArr.length);
        for (long j : jArr) {
            util.int32_to_buf(bArr, i3, (int) j);
            i3 += 4;
        }
        set_data(bArr, this._t116_body_len);
        return get_buf();
    }
}

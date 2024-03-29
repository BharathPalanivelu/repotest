package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t128 extends tlv_t {
    int _t128_body_len = 0;

    public tlv_t128() {
        this._cmd = 296;
    }

    public byte[] get_tlv_128(int i, int i2, int i3, int i4, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        int limit_len = limit_len(bArr, 32);
        int limit_len2 = limit_len(bArr2, 16);
        int limit_len3 = limit_len(bArr3, 16);
        this._t128_body_len = limit_len + 11 + 2 + limit_len2 + 2 + limit_len3;
        byte[] bArr4 = new byte[this._t128_body_len];
        util.int16_to_buf(bArr4, 0, 0);
        util.int8_to_buf(bArr4, 2, i);
        util.int8_to_buf(bArr4, 3, i2);
        util.int8_to_buf(bArr4, 4, i3);
        util.int32_to_buf(bArr4, 5, i4);
        util.int16_to_buf(bArr4, 9, limit_len);
        System.arraycopy(bArr, 0, bArr4, 11, limit_len);
        int i5 = 11 + limit_len;
        util.int16_to_buf(bArr4, i5, limit_len2);
        int i6 = i5 + 2;
        System.arraycopy(bArr2, 0, bArr4, i6, limit_len2);
        int i7 = i6 + limit_len2;
        util.int16_to_buf(bArr4, i7, limit_len3);
        System.arraycopy(bArr3, 0, bArr4, i7 + 2, limit_len3);
        set_data(bArr4, this._t128_body_len);
        return get_buf();
    }
}

package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t124 extends tlv_t {
    int _t124_body_len = 0;

    public tlv_t124() {
        this._cmd = 292;
    }

    public byte[] get_tlv_124(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        if (bArr3 == null) {
            bArr3 = new byte[0];
        }
        if (bArr4 == null) {
            bArr4 = new byte[0];
        }
        if (bArr5 == null) {
            bArr5 = new byte[0];
        }
        int limit_len = limit_len(bArr, 16);
        int limit_len2 = limit_len(bArr2, 16);
        int limit_len3 = limit_len(bArr3, 16);
        int limit_len4 = limit_len(bArr4, 32);
        int limit_len5 = limit_len(bArr5, 16);
        this._t124_body_len = limit_len + 2 + 2 + limit_len2 + 2 + 2 + limit_len3 + 2 + limit_len4 + 2 + limit_len5;
        byte[] bArr6 = new byte[this._t124_body_len];
        util.int16_to_buf(bArr6, 0, limit_len);
        System.arraycopy(bArr, 0, bArr6, 2, limit_len);
        int i2 = limit_len + 2;
        util.int16_to_buf(bArr6, i2, limit_len2);
        int i3 = i2 + 2;
        System.arraycopy(bArr2, 0, bArr6, i3, limit_len2);
        int i4 = i3 + limit_len2;
        util.int16_to_buf(bArr6, i4, i);
        int i5 = i4 + 2;
        util.int16_to_buf(bArr6, i5, limit_len3);
        int i6 = i5 + 2;
        System.arraycopy(bArr3, 0, bArr6, i6, limit_len3);
        int i7 = i6 + limit_len3;
        util.int16_to_buf(bArr6, i7, limit_len4);
        int i8 = i7 + 2;
        System.arraycopy(bArr4, 0, bArr6, i8, limit_len4);
        int i9 = i8 + limit_len4;
        util.int16_to_buf(bArr6, i9, limit_len5);
        System.arraycopy(bArr5, 0, bArr6, i9 + 2, limit_len5);
        set_data(bArr6, this._t124_body_len);
        return get_buf();
    }
}

package tencent.tls.tlvs;

import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class tlv_t106 extends tlv_t {
    int _SSoVer = 1;
    int _TGTGTVer = 4;
    int _t106_body_len = 90;

    public tlv_t106() {
        this._cmd = 262;
    }

    public byte[] get_tlv_106(long j, long j2, int i, byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, long j3, byte[] bArr4, int i3, byte[] bArr5, int i4, byte[] bArr6, int i5) {
        int i6;
        byte[] bArr7 = bArr == null ? new byte[0] : bArr;
        byte[] bArr8 = bArr2 == null ? new byte[0] : bArr2;
        byte[] bArr9 = bArr3 == null ? new byte[0] : bArr3;
        byte[] bArr10 = bArr4 == null ? new byte[0] : bArr4;
        byte[] bArr11 = bArr5 == null ? new byte[0] : bArr5;
        byte[] bArr12 = bArr6 == null ? new byte[0] : bArr6;
        this._t106_body_len += bArr12.length + 2 + 4;
        byte[] bArr13 = new byte[this._t106_body_len];
        util.int16_to_buf(bArr13, 0, this._TGTGTVer);
        util.int32_to_buf(bArr13, 2, util.get_rand_32());
        util.int32_to_buf(bArr13, 6, this._SSoVer);
        util.int64_to_buf32(bArr13, 10, j);
        util.int32_to_buf(bArr13, 14, i);
        System.arraycopy(bArr7, 0, bArr13, 18, bArr7.length);
        int length = 18 + bArr7.length;
        System.arraycopy(bArr8, 0, bArr13, length, bArr8.length);
        int length2 = length + bArr8.length;
        util.int8_to_buf(bArr13, length2, i2);
        int i7 = length2 + 1;
        System.arraycopy(bArr9, 0, bArr13, i7, bArr9.length);
        int length3 = i7 + bArr9.length;
        System.arraycopy(bArr10, 0, bArr13, length3, bArr10.length);
        int length4 = length3 + bArr10.length;
        util.int32_to_buf(bArr13, length4, 0);
        int i8 = length4 + 4;
        util.int8_to_buf(bArr13, i8, i3);
        int i9 = i8 + 1;
        if (bArr11.length == 0) {
            byte[] bArr14 = new byte[16];
            util.int32_to_buf(bArr14, 0, util.get_rand_32());
            util.int32_to_buf(bArr14, 4, util.get_rand_32());
            util.int32_to_buf(bArr14, 8, util.get_rand_32());
            util.int32_to_buf(bArr14, 12, util.get_rand_32());
            i6 = bArr14.length;
        } else {
            System.arraycopy(bArr11, 0, bArr13, i9, bArr11.length);
            i6 = bArr11.length;
        }
        int i10 = i9 + i6;
        util.int64_to_buf32(bArr13, i10, j2);
        int i11 = i10 + 4;
        util.int32_to_buf(bArr13, i11, i4);
        int i12 = i11 + 4;
        util.int16_to_buf(bArr13, i12, bArr12.length);
        int i13 = i12 + 2;
        System.arraycopy(bArr12, 0, bArr13, i13, bArr12.length);
        util.int32_to_buf(bArr13, i13 + bArr12.length, i5);
        byte[] encrypt = cryptor.encrypt(bArr13, 0, bArr13.length, util.getS2(bArr9, j3));
        this._t106_body_len = encrypt.length;
        set_data(encrypt, this._t106_body_len);
        return get_buf();
    }
}

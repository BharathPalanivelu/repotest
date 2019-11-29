package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t147 extends tlv_t {
    public tlv_t147() {
        this._cmd = 327;
    }

    public byte[] get_tlv_147(long j, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        int limit_len = limit_len(bArr, 32);
        int limit_len2 = limit_len(bArr2, 32);
        byte[] bArr3 = new byte[(limit_len + 6 + 2 + limit_len2)];
        util.int64_to_buf32(bArr3, 0, j);
        util.int16_to_buf(bArr3, 4, limit_len);
        System.arraycopy(bArr, 0, bArr3, 6, limit_len);
        int i = 6 + limit_len;
        util.int16_to_buf(bArr3, i, limit_len2);
        System.arraycopy(bArr2, 0, bArr3, i + 2, limit_len2);
        set_data(bArr3, bArr3.length);
        return get_buf();
    }
}

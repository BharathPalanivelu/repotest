package tencent.tls.tlvs;

import cn.tongdun.android.BuildConfig;
import tencent.tls.tools.util;

public class tlv_t142 extends tlv_t {
    int _t142_body_len = 0;
    int _version = 0;

    public tlv_t142() {
        this._cmd = BuildConfig.VERSION_CODE;
    }

    public byte[] get_tlv_142(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int limit_len = limit_len(bArr, 32);
        this._t142_body_len = limit_len + 4;
        byte[] bArr2 = new byte[this._t142_body_len];
        util.int16_to_buf(bArr2, 0, this._version);
        util.int16_to_buf(bArr2, 2, limit_len);
        System.arraycopy(bArr, 0, bArr2, 4, limit_len);
        set_data(bArr2, bArr2.length);
        return get_buf();
    }
}

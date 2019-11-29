package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t1 extends tlv_t {
    byte[] IP_KEY = new byte[2];
    int _ip_len = 4;
    int _ip_pos = 14;
    int _ip_ver = 1;
    int _t1_body_len = 24;

    public tlv_t1() {
        this._cmd = 1;
    }

    public boolean verify() {
        return this._body_len >= 24;
    }

    public byte[] get_ip() {
        byte[] bArr = new byte[this._ip_len];
        System.arraycopy(this._buf, this._ip_pos, bArr, 0, this._ip_len);
        return bArr;
    }

    public byte[] get_tlv_1(long j, byte[] bArr) {
        byte[] bArr2 = new byte[this._t1_body_len];
        util.int16_to_buf(bArr2, 0, this._ip_ver);
        util.int32_to_buf(bArr2, 2, util.get_rand_32());
        util.int64_to_buf(bArr2, 6, j);
        util.int64_to_buf32(bArr2, 14, util.get_server_cur_time());
        System.arraycopy(bArr, 0, bArr2, 18, bArr.length);
        util.int16_to_buf(bArr2, 18 + bArr.length, 0);
        set_data(bArr2, this._t1_body_len);
        return get_buf();
    }
}

package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t138 extends tlv_t {
    public int A2_Valid = 0;
    public int D2_Valid = 0;
    private int cnt = 0;

    public tlv_t138() {
        this._cmd = 312;
    }

    public boolean verify() {
        if (this._body_len < 4) {
            return false;
        }
        this.cnt = util.buf_to_int32(this._buf, this._head_len);
        if (this._body_len >= (this.cnt * 10) + 4) {
            return false;
        }
        for (int i = 0; i < this.cnt; i++) {
            int i2 = this._head_len + 4 + (i * 10);
            int buf_to_int16 = util.buf_to_int16(this._buf, i2);
            if (buf_to_int16 == 266) {
                this.A2_Valid = util.buf_to_int32(this._buf, i2 + 2);
            } else if (buf_to_int16 == 323) {
                this.D2_Valid = util.buf_to_int32(this._buf, i2 + 2);
            }
        }
        return true;
    }
}

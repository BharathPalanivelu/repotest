package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t105 extends tlv_t {
    int _en_pos = 0;
    int _enlen = 0;
    int _pic_pos = 0;
    int _piclen = 0;

    public tlv_t105() {
        this._cmd = 261;
    }

    public boolean verify() {
        if (this._body_len < 2) {
            return false;
        }
        this._enlen = util.buf_to_int16(this._buf, this._head_len);
        if (this._body_len < this._enlen + 2 + 2) {
            return false;
        }
        this._piclen = util.buf_to_int16(this._buf, this._head_len + 2 + this._enlen);
        if (this._body_len < this._enlen + 2 + 2 + this._piclen) {
            return false;
        }
        this._en_pos = this._head_len + 2;
        this._pic_pos = this._enlen + 2 + 2 + this._head_len;
        return true;
    }

    public byte[] get_pic() {
        int i = this._piclen;
        byte[] bArr = new byte[i];
        if (i <= 0) {
            return bArr;
        }
        System.arraycopy(this._buf, this._pic_pos, bArr, 0, this._piclen);
        return bArr;
    }

    public byte[] get_sign() {
        int i = this._enlen;
        byte[] bArr = new byte[i];
        if (i <= 0) {
            return bArr;
        }
        System.arraycopy(this._buf, this._en_pos, bArr, 0, this._enlen);
        return bArr;
    }
}

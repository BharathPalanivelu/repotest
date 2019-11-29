package tencent.tls.tlvs;

import tencent.tls.tools.util;

public class tlv_t146 extends tlv_t {
    public int _errorinfo_len = 0;
    public int _msg_len = 0;
    public int _title_len = 0;
    public String errMsg = "";
    public String errTitle = "";
    public int errType = 0;
    public String extraErrMsg = "";
    int ver = 0;

    public tlv_t146() {
        this._cmd = 326;
    }

    public boolean verify() {
        if (this._body_len < 4) {
            return false;
        }
        this.ver = util.buf_to_int16(this._buf, this._head_len);
        int i = this.ver;
        if (i == 0) {
            this.errType = util.buf_to_int16(this._buf, this._head_len + 2);
            int buf_to_int16 = util.buf_to_int16(this._buf, this._head_len + 4);
            this._title_len = buf_to_int16;
            if (this._body_len < buf_to_int16 + 12) {
                return false;
            }
            byte[] bArr = new byte[buf_to_int16];
            System.arraycopy(this._buf, this._head_len + 6, bArr, 0, buf_to_int16);
            this.errTitle = new String(bArr);
            int buf_to_int162 = util.buf_to_int16(this._buf, this._head_len + 6 + this._title_len);
            this._msg_len = buf_to_int162;
            if (this._body_len < this._title_len + 12 + buf_to_int162) {
                return false;
            }
            byte[] bArr2 = new byte[this._msg_len];
            System.arraycopy(this._buf, this._head_len + 8 + this._title_len, bArr2, 0, this._msg_len);
            this.errMsg = new String(bArr2);
            int buf_to_int163 = util.buf_to_int16(this._buf, this._head_len + 10 + this._title_len + this._msg_len);
            this._errorinfo_len = buf_to_int163;
            if (this._body_len < this._title_len + 12 + this._msg_len + buf_to_int163) {
                return false;
            }
            byte[] bArr3 = new byte[this._errorinfo_len];
            System.arraycopy(this._buf, this._head_len + 12 + this._title_len + this._msg_len, bArr3, 0, this._errorinfo_len);
            this.extraErrMsg = new String(bArr3);
        } else if (i == 1) {
            this.errType = util.buf_to_int32(this._buf, this._head_len + 2);
            this._msg_len = util.buf_to_int16(this._buf, this._head_len + 2 + 4);
            byte[] bArr4 = new byte[this._msg_len];
            System.arraycopy(this._buf, this._head_len + 2 + 4, bArr4, 0, this._msg_len);
            this.errMsg = new String(bArr4);
        }
        return true;
    }
}

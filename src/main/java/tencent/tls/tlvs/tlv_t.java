package tencent.tls.tlvs;

import tencent.tls.platform.TLSErrInfo;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class tlv_t {
    protected int _body_len = 0;
    protected byte[] _buf = new byte[this._max];
    protected int _cmd = 0;
    protected int _head_len = 4;
    protected int _max = 128;
    protected int _pos = 0;

    public boolean verify() {
        return true;
    }

    public tlv_t() {
    }

    public tlv_t(int i) {
        this._cmd = i;
    }

    public byte[] get_buf() {
        int i = this._pos;
        byte[] bArr = new byte[i];
        System.arraycopy(this._buf, 0, bArr, 0, i);
        return bArr;
    }

    public int getTLVSize() {
        return this._pos;
    }

    public byte[] get_data() {
        int i = this._body_len;
        byte[] bArr = new byte[i];
        System.arraycopy(this._buf, this._head_len, bArr, 0, i);
        return bArr;
    }

    public int get_data_len() {
        return this._body_len;
    }

    public void set_data(byte[] bArr, int i) {
        int i2 = this._head_len;
        if (i + i2 > this._max) {
            this._max = i + i2 + 128;
            byte[] bArr2 = new byte[this._max];
            System.arraycopy(this._buf, 0, bArr2, 0, i2);
            this._buf = bArr2;
        }
        int i3 = this._head_len;
        this._pos = i + i3;
        System.arraycopy(bArr, 0, this._buf, i3, i);
        this._body_len = i;
        util.int16_to_buf(this._buf, 0, this._cmd);
        util.int16_to_buf(this._buf, 2, this._body_len);
    }

    public byte[] build_tlv(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        set_data(bArr, bArr.length);
        return get_buf();
    }

    public void set_buf(byte[] bArr, int i, int i2) {
        if (i2 > this._max) {
            this._max = i2 + 128;
            this._buf = new byte[this._max];
        }
        this._pos = i2;
        System.arraycopy(bArr, i, this._buf, 0, i2);
        this._cmd = util.buf_to_int16(bArr, i);
        this._body_len = i2 - this._head_len;
    }

    /* access modifiers changed from: package-private */
    public int search_tlv(byte[] bArr, int i, int i2, int i3) {
        int length = bArr.length;
        while (i < length) {
            int i4 = i + 2;
            if (i4 > length) {
                break;
            } else if (util.buf_to_int16(bArr, i) == i3) {
                return i;
            } else {
                if (i4 + 2 > length) {
                    break;
                }
                i = util.buf_to_int16(bArr, i4) + 2 + i4;
            }
        }
        return -1;
    }

    public int get_tlv(byte[] bArr, int i, int i2) {
        int search_tlv = search_tlv(bArr, i, i2, this._cmd);
        if (search_tlv < 0) {
            return -1;
        }
        int i3 = i2 - (search_tlv - i);
        if (this._head_len >= i3) {
            return -1;
        }
        this._body_len = util.buf_to_int16(bArr, search_tlv + 2);
        int i4 = this._head_len;
        int i5 = this._body_len;
        if (i4 + i5 > i3) {
            return -1;
        }
        set_buf(bArr, search_tlv, i4 + i5);
        if (!verify()) {
            return TLSErrInfo.LOGIN_TLV_INVALID;
        }
        return search_tlv + this._head_len + this._body_len;
    }

    /* access modifiers changed from: package-private */
    public int get_tlv(byte[] bArr, int i, byte[] bArr2) {
        if (this._head_len >= i) {
            return -1;
        }
        this._body_len = util.buf_to_int16(bArr, 2);
        int i2 = this._head_len;
        int i3 = this._body_len;
        if (i2 + i3 > i) {
            return -1;
        }
        byte[] decrypt = cryptor.decrypt(bArr, i2, i3, bArr2);
        if (decrypt == null) {
            return TLSErrInfo.DECRYPT_FAILED;
        }
        int i4 = this._head_len;
        if (decrypt.length + i4 > this._max) {
            this._max = i4 + decrypt.length;
            this._buf = new byte[this._max];
        }
        this._pos = 0;
        System.arraycopy(bArr, 0, this._buf, 0, this._head_len);
        this._pos += this._head_len;
        System.arraycopy(decrypt, 0, this._buf, this._pos, decrypt.length);
        this._pos += decrypt.length;
        this._body_len = decrypt.length;
        if (!verify()) {
            return TLSErrInfo.LOGIN_TLV_INVALID;
        }
        return 0;
    }

    public int get_tlv(byte[] bArr, int i, int i2, byte[] bArr2) {
        int search_tlv = search_tlv(bArr, i, i2, this._cmd);
        if (search_tlv < 0) {
            return -1;
        }
        int i3 = i2 - (search_tlv - i);
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr, search_tlv, bArr3, 0, i3);
        return get_tlv(bArr3, i3, bArr2);
    }

    public int limit_len(byte[] bArr, int i) {
        if (bArr == null) {
            return 0;
        }
        if (bArr.length > i) {
            return i;
        }
        return bArr.length;
    }
}

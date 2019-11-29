package tencent.tls.tlvs;

public class tlv_t16e extends tlv_t {
    int _t16e_body_len = 0;

    public tlv_t16e() {
        this._cmd = 366;
    }

    public byte[] get_tlv_16e(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        int i = 64;
        if (bArr.length < 64) {
            i = bArr.length;
        }
        this._t16e_body_len = i;
        int i2 = this._t16e_body_len;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        set_data(bArr2, this._t16e_body_len);
        return get_buf();
    }
}

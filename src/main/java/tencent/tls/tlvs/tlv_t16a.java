package tencent.tls.tlvs;

public class tlv_t16a extends tlv_t {
    int _t16a_body_len = 0;

    public tlv_t16a() {
        this._cmd = 362;
    }

    public byte[] get_tlv_16a(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        this._t16a_body_len = bArr.length;
        byte[] bArr2 = new byte[this._t16a_body_len];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        set_data(bArr2, this._t16a_body_len);
        return get_buf();
    }
}

package tencent.tls.tlvs;

public class tlv_t104 extends tlv_t {
    int _t104_body_len = 0;

    public tlv_t104() {
        this._cmd = 260;
    }

    public byte[] get_tlv_104(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        this._t104_body_len = bArr.length;
        byte[] bArr2 = new byte[this._t104_body_len];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        set_data(bArr2, this._t104_body_len);
        return get_buf();
    }
}

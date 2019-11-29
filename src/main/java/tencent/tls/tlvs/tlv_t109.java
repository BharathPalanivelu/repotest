package tencent.tls.tlvs;

public class tlv_t109 extends tlv_t {
    int _t109_body_len = 0;

    public tlv_t109() {
        this._cmd = 265;
    }

    public byte[] get_tlv_109(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[16];
        }
        this._t109_body_len = bArr.length;
        byte[] bArr2 = new byte[this._t109_body_len];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        set_data(bArr2, this._t109_body_len);
        return get_buf();
    }
}

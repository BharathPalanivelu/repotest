package tencent.tls.tlvs;

public class tlv_t145 extends tlv_t {
    public tlv_t145() {
        this._cmd = 325;
    }

    public byte[] get_tlv_145(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        set_data(bArr, bArr.length);
        return get_buf();
    }
}

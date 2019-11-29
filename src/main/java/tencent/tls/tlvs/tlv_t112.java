package tencent.tls.tlvs;

public class tlv_t112 extends tlv_t {
    public tlv_t112() {
        this._cmd = TiffUtil.TIFF_TAG_ORIENTATION;
    }

    public byte[] get_tlv_112(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        set_data(bArr, bArr.length);
        return get_buf();
    }
}

package tencent.tls.tlvs;

import java.util.List;
import tencent.tls.tools.util;

public class tlv_t16b extends tlv_t {
    public tlv_t16b() {
        this._cmd = 363;
    }

    public byte[] get_tlv_16b(List<String> list) {
        int i;
        int i2;
        if (list != null) {
            i2 = list.size();
            i = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                i += 2;
                if (list.get(i3) != null) {
                    i += list.get(i3).length();
                }
            }
        } else {
            i2 = 0;
            i = 0;
        }
        byte[] bArr = new byte[(i + 2)];
        util.int16_to_buf(bArr, 0, i2);
        if (list != null) {
            int i4 = 2;
            for (int i5 = 0; i5 < i2; i5++) {
                if (list.get(i5) != null) {
                    byte[] bytes = list.get(i5).getBytes();
                    util.int16_to_buf(bArr, i4, bytes.length);
                    int i6 = i4 + 2;
                    System.arraycopy(bytes, 0, bArr, i6, bytes.length);
                    i4 = i6 + bytes.length;
                } else {
                    util.int16_to_buf(bArr, i4, 0);
                    i4 += 2;
                }
            }
        }
        set_data(bArr, bArr.length);
        return get_buf();
    }
}

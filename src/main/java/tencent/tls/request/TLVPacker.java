package tencent.tls.request;

import java.util.ArrayList;

public class TLVPacker {
    private int bodyLen = 0;
    private int tlvCnt = 0;
    private ArrayList<byte[]> tlvList = new ArrayList<>();
    private int[] tlvs;

    public TLVPacker(int[] iArr) {
        this.tlvs = iArr;
    }

    /* access modifiers changed from: protected */
    public byte[] loop(int i) {
        return new byte[0];
    }

    public byte[] doit() {
        for (int loop : this.tlvs) {
            byte[] loop2 = loop(loop);
            if (loop2.length > 4) {
                this.tlvCnt++;
                this.bodyLen += loop2.length;
                this.tlvList.add(loop2);
            }
        }
        byte[] bArr = new byte[this.bodyLen];
        int i = 0;
        for (int i2 = 0; i2 < this.tlvCnt; i2++) {
            byte[] bArr2 = this.tlvList.get(i2);
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            i += bArr2.length;
        }
        return bArr;
    }

    public int getTlvCnt() {
        return this.tlvCnt;
    }
}

package tencent.tls.oidb;

import java.nio.ByteBuffer;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0xa0b.Oidb0Xa0b;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;

public class Oidb0xa0b_response {
    private int dwBodyLen;
    private int dwHeadLen;
    private OidbHead.OIDBHead oidbHead;
    private int result = 0;
    private Oidb0Xa0b.RspBody rspBody;

    public Oidb0xa0b_response(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        try {
            wrap.get();
            this.dwHeadLen = wrap.getInt();
            this.dwBodyLen = wrap.getInt();
            byte[] bArr2 = new byte[this.dwHeadLen];
            wrap.get(bArr2);
            this.oidbHead = new OidbHead.OIDBHead();
            this.oidbHead.mergeFrom(bArr2);
            byte[] bArr3 = new byte[this.dwBodyLen];
            wrap.get(bArr3);
            this.rspBody = new Oidb0Xa0b.RspBody();
            this.rspBody.mergeFrom(bArr3);
            wrap.get();
        } catch (Exception e2) {
            QLog.e(e2);
            this.result = TLSErrInfo.PK_LEN;
        }
    }

    public int getResult() {
        return this.result;
    }

    public long getTinyID() {
        return this.rspBody.uint64_tinyid.get();
    }

    public byte[] getA2() {
        return this.rspBody.bytes_a2.get().toByteArray();
    }

    public byte[] getD2() {
        return this.rspBody.bytes_d2.get().toByteArray();
    }

    public byte[] getD2Key() {
        return this.rspBody.bytes_d2key.get().toByteArray();
    }

    public String getErrMsg() {
        return this.oidbHead.str_error_msg.get();
    }

    public int getAdminFlag() {
        return this.rspBody.uint32_adminflag.get();
    }

    public String getIdentifier() {
        return this.rspBody.str_identifier.get();
    }

    public String getUserSig() {
        return this.rspBody.str_tlssig.get();
    }

    public int getHeadResult() {
        OidbHead.OIDBHead oIDBHead = this.oidbHead;
        if (oIDBHead != null) {
            return oIDBHead.uint32_result.get();
        }
        return -1;
    }
}

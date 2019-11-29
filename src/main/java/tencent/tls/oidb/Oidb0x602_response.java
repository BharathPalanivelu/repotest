package tencent.tls.oidb;

import java.nio.ByteBuffer;
import tencent.tls.account.TLSOpenAccountInfo;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0x602.Oidb0X602;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;

public class Oidb0x602_response {
    private int dwBodyLen;
    private int dwHeadLen;
    private OidbHead.OIDBHead oidbHead;
    private int result = 0;
    private Oidb0X602.RspBody rspBody;

    public Oidb0x602_response(byte[] bArr) {
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
            this.rspBody = new Oidb0X602.RspBody();
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

    public int getHeadResult() {
        OidbHead.OIDBHead oIDBHead = this.oidbHead;
        if (oIDBHead != null) {
            return oIDBHead.uint32_result.get();
        }
        return -1;
    }

    public TLSOpenAccountInfo.OpenAccountStatus getOpenAccountStatus() {
        if (this.rspBody.rpt_open2userinfos.size() > 0) {
            int i = this.rspBody.rpt_open2userinfos.get(0).uint32_result_flg.get();
            if (i == 1) {
                return TLSOpenAccountInfo.OpenAccountStatus.USED_BINDED;
            }
            if (i == 2) {
                return TLSOpenAccountInfo.OpenAccountStatus.USED_UNBINDED;
            }
            if (i == 3) {
                return TLSOpenAccountInfo.OpenAccountStatus.UNUSED;
            }
        }
        return TLSOpenAccountInfo.OpenAccountStatus.UNKNOWN;
    }
}

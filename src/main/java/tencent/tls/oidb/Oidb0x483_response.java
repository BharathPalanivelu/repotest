package tencent.tls.oidb;

import java.nio.ByteBuffer;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0x483.Oidb0X483;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;

public class Oidb0x483_response {
    private int dwBodyLen;
    private int dwHeadLen;
    private OidbHead.OIDBHead oidbHead;
    private int result = 0;
    private Oidb0X483.RspBody rspBody;

    public Oidb0x483_response(byte[] bArr) {
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
            this.rspBody = new Oidb0X483.RspBody();
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

    public String getErrHint() {
        return this.rspBody.str_errhint.get();
    }

    public String getAccessToken() {
        return this.rspBody.st_token.str_access_token.get();
    }

    public long getExpireTime() {
        return (long) this.rspBody.st_token.uint32_expires_in.get();
    }

    public String getRefreshToken() {
        return this.rspBody.st_token.str_refresh_token.get();
    }

    public String getOpenid() {
        return this.rspBody.st_token.str_openid.get();
    }

    public String getScope() {
        return this.rspBody.st_token.str_scope.get();
    }

    public String getUnionid() {
        return this.rspBody.st_token.str_unionid.get();
    }
}

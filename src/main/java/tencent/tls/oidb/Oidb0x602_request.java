package tencent.tls.oidb;

import java.nio.ByteBuffer;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0x602.Oidb0X602;

public class Oidb0x602_request {
    public static final int CMD = 1538;
    public static final byte ETX_C = 41;
    public static final int ROLE = 6161;
    public static final byte STX_C = 40;
    protected int dwBodyLen;
    protected int dwHeadLen;
    protected int service_type = 2;

    public int getCmd() {
        return CMD;
    }

    public byte[] get_request(int i, int i2, String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        OidbHead.OIDBHead oIDBHead = new OidbHead.OIDBHead();
        oIDBHead.uint32_command.set(CMD);
        oIDBHead.uint32_service_type.set(this.service_type);
        Oidb0X602.OpenAccountInfo openAccountInfo = new Oidb0X602.OpenAccountInfo();
        openAccountInfo.uint32_openacctype.set(i2);
        openAccountInfo.str_openappid.set(str);
        openAccountInfo.str_openid.set(str2);
        openAccountInfo.uint32_sdkappid.set(i);
        openAccountInfo.str_access_token.set(str3);
        Oidb0X602.ReqBody reqBody = new Oidb0X602.ReqBody();
        reqBody.rpt_openaccinfos.add(openAccountInfo);
        this.dwHeadLen = oIDBHead.getSerializedSize();
        this.dwBodyLen = reqBody.getSerializedSize();
        ByteBuffer allocate = ByteBuffer.allocate(this.dwHeadLen + 9 + this.dwBodyLen + 1);
        allocate.put((byte) 40);
        allocate.putInt(this.dwHeadLen);
        allocate.putInt(this.dwBodyLen);
        allocate.put(oIDBHead.toByteArray());
        allocate.put(reqBody.toByteArray());
        allocate.put((byte) 41);
        return allocate.array();
    }
}

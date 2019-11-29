package tencent.tls.oidb;

import java.nio.ByteBuffer;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0x483.Oidb0X483;

public class Oidb0x483_request {
    public static final int CMD = 1155;
    public static final byte ETX_C = 41;
    public static final int ROLE = 5970;
    public static final byte STX_C = 40;
    protected int dwBodyLen;
    protected int dwHeadLen;
    protected int service_type = 0;

    public int getCmd() {
        return CMD;
    }

    public byte[] get_request(long j, int i, String str) {
        if (str == null) {
            str = "";
        }
        OidbHead.OIDBHead oIDBHead = new OidbHead.OIDBHead();
        oIDBHead.uint32_command.set(CMD);
        oIDBHead.uint32_service_type.set(this.service_type);
        Oidb0X483.ReqBody reqBody = new Oidb0X483.ReqBody();
        reqBody.uint32_appid.set((int) j);
        reqBody.uint32_account_type.set(i);
        reqBody.str_code.set(str);
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

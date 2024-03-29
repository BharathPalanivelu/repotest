package tencent.tls.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import java.nio.ByteBuffer;
import tencent.tls.oidb.OidbHead;
import tencent.tls.oidb.cmd0x601.Oidb0X601;

public class Oidb0x601_request {
    public static final int CMD = 1537;
    public static final byte ETX_C = 41;
    public static final int ROLE = 6161;
    public static final byte STX_C = 40;
    protected int dwBodyLen;
    protected int dwHeadLen;
    protected int service_type = 3;

    public int getCmd() {
        return CMD;
    }

    public byte[] get_request(int i, int i2, String str, String str2, int i3, String str3, String str4, String str5) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        if (str4 == null) {
            str4 = "";
        }
        if (str5 == null) {
            str5 = "";
        }
        OidbHead.OIDBHead oIDBHead = new OidbHead.OIDBHead();
        oIDBHead.uint32_command.set(CMD);
        oIDBHead.uint32_service_type.set(this.service_type);
        Oidb0X601.OpenAccountInfo openAccountInfo = new Oidb0X601.OpenAccountInfo();
        openAccountInfo.uint32_openacctype.set(i3);
        openAccountInfo.str_openappid.set(str3);
        openAccountInfo.str_openid.set(str4);
        Oidb0X601.UserAccountInfo userAccountInfo = new Oidb0X601.UserAccountInfo();
        userAccountInfo.uint32_useracctype.set(i2);
        userAccountInfo.str_useraccount.set(str);
        userAccountInfo.str_usersig.set(str2);
        Oidb0X601.OpenSigInfo openSigInfo = new Oidb0X601.OpenSigInfo();
        openSigInfo.str_openappid.set(str3);
        openSigInfo.bytes_opensig.set(ByteStringMicro.copyFrom(str5.getBytes()));
        Oidb0X601.ReqBody reqBody = new Oidb0X601.ReqBody();
        reqBody.openaccount.set(openAccountInfo);
        reqBody.useraccount.set(userAccountInfo);
        reqBody.opensig.set(openSigInfo);
        reqBody.uint32_sdkappid.set(i);
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

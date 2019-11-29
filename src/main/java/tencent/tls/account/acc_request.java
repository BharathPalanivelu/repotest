package tencent.tls.account;

import java.nio.ByteBuffer;
import tencent.tls.platform.TLSErrInfo;
import tencent.tls.report.QLog;
import tencent.tls.tools.MD5;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class acc_request {
    public static final int CMD_GUEST = 118;
    public static final int CMD_REG_AC = 49;
    public static final int CMD_REG_CM = 54;
    public static final int CMD_REG_RA = 52;
    public static final int CMD_REG_VC = 53;
    public static final int CMD_RST_AC = 64;
    public static final int CMD_RST_CM = 67;
    public static final int CMD_RST_RA = 65;
    public static final int CMD_RST_VC = 66;
    public static final int CMD_SMS_AC = 33;
    public static final int CMD_SMS_CM = 38;
    public static final int CMD_SMS_RA = 36;
    public static final int CMD_SMS_VC = 37;
    public static final int CMD_STR_CM = 102;
    public static final int CMD_STR_QRY = 97;
    protected int _body_len = 0;
    protected int _cmd = 0;
    protected int _head_len = 11;
    protected int _os_type = 5;
    protected int _version = 1;

    public int get_cmd() {
        return this._cmd;
    }

    /* access modifiers changed from: protected */
    public byte[] get_request(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(this._head_len + 2 + bArr.length);
        allocate.put((byte) 2);
        allocate.putShort((short) (this._head_len + 1 + bArr.length + 1));
        allocate.putShort((short) this._version);
        allocate.putShort((short) this._cmd);
        allocate.put((byte) 4);
        allocate.putInt(0);
        allocate.put(bArr);
        allocate.put((byte) 3);
        return allocate.array();
    }

    private static int check_header(byte[] bArr) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        try {
            wrap.get();
            if (wrap.getShort() != bArr.length) {
                return TLSErrInfo.PK_LEN;
            }
            wrap.getInt();
            return wrap.position() + wrap.get();
        } catch (Exception e2) {
            QLog.e(e2);
            return TLSErrInfo.PK_LEN;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        r6 = new byte[r0.getShort()];
        r0.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r8.msgcode == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
        if (r8.msgcode.length != 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        r7 = tencent.tls.tools.MD5.toMD5Byte(r8.msgcode);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
        r7 = tencent.tls.account.acc_status.STATIC_KEY.getBytes();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        r6 = tencent.tls.tools.cryptor.decrypt(r6, 0, r6.length, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r6 != null) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        return tencent.tls.platform.TLSErrInfo.DECRYPT_FAILED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        r6 = java.nio.ByteBuffer.wrap(r6);
        r7 = new byte[r6.get()];
        r6.get(r7);
        r8.nopicsig = new byte[r6.getShort()];
        r6.get(r8.nopicsig);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        tencent.tls.account.acc_status.msalt = r0.getLong();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int parse_checkvalid_rsp(int r6, byte[] r7, tencent.tls.account.acc_status r8) {
        /*
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r7)
            int r7 = check_header(r7)
            r1 = -1009(0xfffffffffffffc0f, float:NaN)
            if (r7 != r1) goto L_0x000d
            return r1
        L_0x000d:
            r0.position(r7)
            byte r7 = r0.get()
            r8.sec_ctrl_code = r7
            r7 = 0
            r1 = 33
            r2 = -1002(0xfffffffffffffc16, float:NaN)
            r3 = 0
            if (r6 == r1) goto L_0x00c9
            r1 = 49
            if (r6 == r1) goto L_0x00c9
            r1 = 97
            if (r6 == r1) goto L_0x00b4
            r1 = 102(0x66, float:1.43E-43)
            if (r6 == r1) goto L_0x00b0
            r1 = 118(0x76, float:1.65E-43)
            if (r6 == r1) goto L_0x0083
            switch(r6) {
                case 36: goto L_0x00c9;
                case 37: goto L_0x007c;
                case 38: goto L_0x0039;
                default: goto L_0x0031;
            }
        L_0x0031:
            switch(r6) {
                case 52: goto L_0x00c9;
                case 53: goto L_0x007c;
                case 54: goto L_0x0039;
                default: goto L_0x0034;
            }
        L_0x0034:
            switch(r6) {
                case 64: goto L_0x00c9;
                case 65: goto L_0x00c9;
                case 66: goto L_0x007c;
                case 67: goto L_0x0039;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x00d8
        L_0x0039:
            short r6 = r0.getShort()
            byte[] r6 = new byte[r6]
            r0.get(r6)
            byte[] r7 = r8.msgcode
            if (r7 == 0) goto L_0x0053
            byte[] r7 = r8.msgcode
            int r7 = r7.length
            if (r7 != 0) goto L_0x004c
            goto L_0x0053
        L_0x004c:
            byte[] r7 = r8.msgcode
            byte[] r7 = tencent.tls.tools.MD5.toMD5Byte((byte[]) r7)
            goto L_0x0059
        L_0x0053:
            java.lang.String r7 = tencent.tls.account.acc_status.STATIC_KEY
            byte[] r7 = r7.getBytes()
        L_0x0059:
            int r1 = r6.length
            byte[] r6 = tencent.tls.tools.cryptor.decrypt(r6, r3, r1, r7)
            if (r6 != 0) goto L_0x0061
            return r2
        L_0x0061:
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            byte r7 = r6.get()
            byte[] r7 = new byte[r7]
            r6.get(r7)
            short r1 = r6.getShort()
            byte[] r1 = new byte[r1]
            r8.nopicsig = r1
            byte[] r1 = r8.nopicsig
            r6.get(r1)
            goto L_0x00d8
        L_0x007c:
            long r4 = r0.getLong()
            tencent.tls.account.acc_status.msalt = r4
            goto L_0x00d8
        L_0x0083:
            long r1 = r0.getLong()
            tencent.tls.account.acc_status.msalt = r1
            long r1 = r0.getLong()
            tencent.tls.account.acc_status.regtime = r1
            byte r7 = r0.get()
            byte[] r7 = new byte[r7]
            r0.get(r7)
            java.lang.String r1 = new java.lang.String
            r1.<init>(r7)
            r8.userID = r1
            resolveTLV(r6, r0)
            short r6 = r0.getShort()
            byte[] r6 = new byte[r6]
            r8.promptinfo = r6
            byte[] r6 = r8.promptinfo
            r0.get(r6)
            return r3
        L_0x00b0:
            resolveTLV(r6, r0)
            goto L_0x00d8
        L_0x00b4:
            long r4 = r0.getLong()
            tencent.tls.account.acc_status.msalt = r4
            short r6 = r0.getShort()
            if (r6 <= 0) goto L_0x00d8
            int r1 = r0.position()
            int r1 = r1 + r6
            r0.position(r1)
            goto L_0x00d8
        L_0x00c9:
            r0.getShort()
            short r6 = r0.getShort()
            r8.next_resend_time = r6
            short r6 = r0.getShort()
            r8.total_time_over = r6
        L_0x00d8:
            byte r6 = r0.get()
            byte[] r6 = new byte[r6]
            r8.token = r6
            byte[] r6 = r8.token
            r0.get(r6)
            if (r7 == 0) goto L_0x00f0
            byte[] r6 = r8.token
            boolean r6 = java.util.Arrays.equals(r6, r7)
            if (r6 != 0) goto L_0x00f0
            return r2
        L_0x00f0:
            short r6 = r0.getShort()
            byte[] r6 = new byte[r6]
            r8.promptinfo = r6
            byte[] r6 = r8.promptinfo
            r0.get(r6)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tencent.tls.account.acc_request.parse_checkvalid_rsp(int, byte[], tencent.tls.account.acc_status):int");
    }

    private static void resolveTLV(int i, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 0) {
        }
    }

    /* access modifiers changed from: protected */
    public byte[] get_encrypt_token(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + 1)];
        util.int8_to_buf(bArr3, 0, bArr.length);
        System.arraycopy(bArr, 0, bArr3, 1, bArr.length);
        return cryptor.encrypt(bArr3, 0, bArr3.length, MD5.toMD5Byte(bArr2));
    }
}

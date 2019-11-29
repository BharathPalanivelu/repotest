package tencent.tls.account;

import android.os.Build;
import java.nio.ByteBuffer;
import tencent.tls.tools.util;

public class acc_ask_code extends acc_request {
    public acc_ask_code(int i) {
        this._cmd = i;
    }

    public byte[] get_request(int i, String str, byte[] bArr, String str2, int i2, long j, byte[] bArr2) {
        if (str == null || bArr == null) {
            return null;
        }
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        String str4 = Build.VERSION.RELEASE;
        if (str4 != null) {
            str3 = str4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.getBytes().length + 5 + 1 + str3.length() + 1 + bArr.length + 1 + str2.length() + 1 + 4 + 4 + 4 + 1 + bArr2.length + 1 + acc_status.apk_sig.length + 2 + 4 + acc_status.apk_id.length);
        allocate.putInt(i);
        allocate.put((byte) str.getBytes().length);
        allocate.put(str.getBytes());
        allocate.put((byte) this._os_type);
        allocate.put((byte) str3.length());
        allocate.put(str3.getBytes());
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        allocate.put((byte) str2.length());
        allocate.put(str2.getBytes());
        allocate.putInt(i2);
        allocate.putInt(acc_status.lang);
        allocate.putInt((int) j);
        allocate.put((byte) bArr2.length);
        allocate.put(bArr2);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        allocate.put((byte) (acc_status.apk_sig.length + 4 + acc_status.apk_id.length));
        allocate.put(acc_status.apk_sig);
        allocate.putInt(acc_status.apk_id.length);
        allocate.put(acc_status.apk_id);
        return super.get_request(allocate.array());
    }

    public byte[] get_request(int i, String str, byte[] bArr, String str2, int i2, long j, byte[] bArr2, TLSOpenAccountInfo tLSOpenAccountInfo) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        TLSOpenAccountInfo tLSOpenAccountInfo2 = tLSOpenAccountInfo;
        if (str == null || bArr3 == null || tLSOpenAccountInfo.checkInvalid()) {
            return null;
        }
        String str3 = str2 == null ? "" : str2;
        byte[] bytes = tLSOpenAccountInfo2.openappid.getBytes();
        byte[] bytes2 = tLSOpenAccountInfo2.openid.getBytes();
        byte[] bytes3 = tLSOpenAccountInfo2.access_token.getBytes();
        byte[] bArr5 = new byte[4];
        util.int32_to_buf(bArr5, 0, tLSOpenAccountInfo2.openAccountType);
        String str4 = Build.VERSION.RELEASE;
        if (str4 == null) {
            str4 = "";
        }
        ByteBuffer allocate = ByteBuffer.allocate(str.length() + 5 + 1 + str4.length() + 1 + bArr3.length + 1 + str3.length() + 1 + 4 + 4 + 4 + 1 + bArr4.length + 1 + acc_status.apk_sig.length + 2 + 4 + acc_status.apk_id.length + 6 + bytes.length + 2 + bytes2.length + 2 + bytes3.length + 2);
        allocate.putInt(i);
        allocate.put((byte) str.length());
        allocate.put(str.getBytes());
        allocate.put((byte) this._os_type);
        allocate.put((byte) str4.length());
        allocate.put(str4.getBytes());
        allocate.put((byte) bArr3.length);
        allocate.put(bArr3);
        allocate.put((byte) str3.length());
        allocate.put(str3.getBytes());
        allocate.putInt(i2);
        allocate.putInt(acc_status.lang);
        allocate.putInt((int) j);
        allocate.put((byte) bArr4.length);
        allocate.put(bArr4);
        allocate.put((byte) 5);
        allocate.put((byte) 1);
        allocate.put((byte) (acc_status.apk_sig.length + 4 + acc_status.apk_id.length));
        allocate.put(acc_status.apk_sig);
        allocate.putInt(acc_status.apk_id.length);
        allocate.put(acc_status.apk_id);
        allocate.put((byte) 2);
        allocate.put((byte) 4);
        allocate.put(bArr5);
        allocate.put((byte) 3);
        allocate.put((byte) bytes.length);
        allocate.put(bytes);
        allocate.put((byte) 4);
        allocate.put((byte) bytes2.length);
        allocate.put(bytes2);
        allocate.put((byte) 5);
        allocate.put((byte) bytes3.length);
        allocate.put(bytes3);
        return super.get_request(allocate.array());
    }
}

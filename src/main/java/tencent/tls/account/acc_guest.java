package tencent.tls.account;

import android.os.Build;
import java.nio.ByteBuffer;
import tencent.tls.tools.MD5;
import tencent.tls.tools.util;

public class acc_guest extends acc_request {
    public acc_guest() {
        this._cmd = 118;
    }

    public byte[] get_request(int i, byte[] bArr, String str, int i2, long j, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String str3 = Build.VERSION.RELEASE;
        if (str3 != null) {
            str2 = str3;
        }
        acc_status.mpasswd = util.get_mpasswd();
        byte[] mD5Byte = MD5.toMD5Byte(acc_status.mpasswd);
        ByteBuffer allocate = ByteBuffer.allocate(str2.length() + 1 + 5 + bArr.length + 1 + str.length() + 1 + 4 + 4 + 4 + 1 + bArr2.length + 1 + mD5Byte.length + 1 + acc_status.apk_sig.length + 2 + 4 + acc_status.apk_id.length);
        allocate.putInt(i);
        allocate.put((byte) this._os_type);
        allocate.put((byte) str2.length());
        allocate.put(str2.getBytes());
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        allocate.put((byte) str.length());
        allocate.put(str.getBytes());
        allocate.putInt(i2);
        allocate.putInt(acc_status.lang);
        allocate.putInt((int) j);
        allocate.put((byte) bArr2.length);
        allocate.put(bArr2);
        allocate.put((byte) mD5Byte.length);
        allocate.put(mD5Byte);
        allocate.put((byte) 1);
        allocate.put((byte) 1);
        allocate.put((byte) (acc_status.apk_sig.length + 4 + acc_status.apk_id.length));
        allocate.put(acc_status.apk_sig);
        allocate.putInt(acc_status.apk_id.length);
        allocate.put(acc_status.apk_id);
        return super.get_request(allocate.array());
    }
}

package tencent.tls.account;

import java.nio.ByteBuffer;
import tencent.tls.tools.MD5;
import tencent.tls.tools.cryptor;
import tencent.tls.tools.util;

public class acc_commit extends acc_request {
    public acc_commit(int i) {
        this._cmd = i;
    }

    public byte[] get_request(byte[] bArr, String str, byte[] bArr2) {
        ByteBuffer byteBuffer;
        byte[] s2 = util.getS2(MD5.toMD5Byte(str), acc_status.msalt);
        if (this._cmd == 102) {
            byteBuffer = ByteBuffer.allocate(bArr.length + 1 + 1 + s2.length + 1);
            byteBuffer.put((byte) bArr.length);
            byteBuffer.put(bArr);
            byteBuffer.put((byte) s2.length);
            byteBuffer.put(s2);
            byteBuffer.put((byte) 0);
        } else {
            byte[] bArr3 = get_encrypt_token(bArr, s2, bArr2);
            byteBuffer = ByteBuffer.allocate(bArr.length + 1 + 2 + bArr3.length);
            byteBuffer.put((byte) bArr.length);
            byteBuffer.put(bArr);
            byteBuffer.putShort((short) bArr3.length);
            byteBuffer.put(bArr3);
        }
        return super.get_request(byteBuffer.array());
    }

    public byte[] get_encrypt_token(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] bArr4;
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 1 + 1 + bArr2.length + 1);
        allocate.put((byte) bArr.length);
        allocate.put(bArr);
        allocate.put((byte) bArr2.length);
        allocate.put(bArr2);
        allocate.put((byte) 0);
        if (bArr3 == null || bArr3.length == 0) {
            bArr4 = acc_status.STATIC_KEY.getBytes();
        } else {
            bArr4 = MD5.toMD5Byte(bArr3);
        }
        return cryptor.encrypt(allocate.array(), 0, allocate.capacity(), bArr4);
    }
}

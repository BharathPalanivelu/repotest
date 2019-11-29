package tencent.tls.tools;

import com.salesforce.android.service.common.utilities.hashing.Hash;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static byte[] toMD5Byte(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Hash.ALGORITHM_MD5).digest(bArr);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static byte[] toMD5Byte(String str) {
        byte[] bArr;
        try {
            bArr = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException unused) {
            bArr = str.getBytes();
        }
        return toMD5Byte(bArr);
    }
}

package twitter4j;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.core.util.IOUtils;

public final class BASE64Encoder {
    private static final char[] encodeTable = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', IOUtils.DIR_SEPARATOR_UNIX};
    private static final char last2byte = ((char) Integer.parseInt("00000011", 2));
    private static final char last4byte = ((char) Integer.parseInt("00001111", 2));
    private static final char last6byte = ((char) Integer.parseInt("00111111", 2));
    private static final char lead2byte = ((char) Integer.parseInt("11000000", 2));
    private static final char lead4byte = ((char) Integer.parseInt("11110000", 2));
    private static final char lead6byte = ((char) Integer.parseInt("11111100", 2));

    private BASE64Encoder() {
    }

    public static String encode(byte[] bArr) {
        int i;
        int i2;
        double length = (double) bArr.length;
        Double.isNaN(length);
        StringBuilder sb = new StringBuilder(((int) (length * 1.34d)) + 3);
        int i3 = 0;
        char c2 = 0;
        for (int i4 = 0; i4 < bArr.length; i4++) {
            i3 %= 8;
            while (i3 < 8) {
                if (i3 == 0) {
                    i = ((char) (bArr[i4] & lead6byte)) >>> 2;
                } else if (i3 != 2) {
                    if (i3 != 4) {
                        if (i3 == 6) {
                            c2 = (char) (((char) (bArr[i4] & last2byte)) << 4);
                            int i5 = i4 + 1;
                            if (i5 < bArr.length) {
                                i2 = (bArr[i5] & lead4byte) >>> 4;
                            }
                        }
                        sb.append(encodeTable[c2]);
                        i3 += 6;
                    } else {
                        c2 = (char) (((char) (bArr[i4] & last4byte)) << 2);
                        int i6 = i4 + 1;
                        if (i6 < bArr.length) {
                            i2 = (bArr[i6] & lead2byte) >>> 6;
                        } else {
                            sb.append(encodeTable[c2]);
                            i3 += 6;
                        }
                    }
                    i = c2 | i2;
                } else {
                    i = bArr[i4] & last6byte;
                }
                c2 = (char) i;
                sb.append(encodeTable[c2]);
                i3 += 6;
            }
        }
        if (sb.length() % 4 != 0) {
            for (int length2 = 4 - (sb.length() % 4); length2 > 0; length2--) {
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
            }
        }
        return sb.toString();
    }
}

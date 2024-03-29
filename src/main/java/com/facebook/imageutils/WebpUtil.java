package com.facebook.imageutils;

import android.util.Pair;
import com.g.a.a.g;
import java.io.IOException;
import java.io.InputStream;

public class WebpUtil {
    private static final String VP8L_HEADER = "VP8L";
    private static final String VP8X_HEADER = "VP8X";
    private static final String VP8_HEADER = "VP8 ";

    private WebpUtil() {
    }

    public static Pair<Integer, Integer> getSize(InputStream inputStream) {
        byte[] bArr = new byte[4];
        try {
            inputStream.read(bArr);
            if (!compare(bArr, "RIFF")) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return null;
            }
            getInt(inputStream);
            inputStream.read(bArr);
            if (!compare(bArr, "WEBP")) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                return null;
            }
            inputStream.read(bArr);
            String header = getHeader(bArr);
            if (VP8_HEADER.equals(header)) {
                Pair<Integer, Integer> vP8Dimension = getVP8Dimension(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                return vP8Dimension;
            } else if (VP8L_HEADER.equals(header)) {
                Pair<Integer, Integer> vP8LDimension = getVP8LDimension(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                    }
                }
                return vP8LDimension;
            } else if (VP8X_HEADER.equals(header)) {
                Pair<Integer, Integer> vP8XDimension = getVP8XDimension(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return vP8XDimension;
            } else {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                return null;
            }
        } catch (IOException e8) {
            e8.printStackTrace();
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9) {
                    e9.printStackTrace();
                }
            }
            throw th;
        }
    }

    private static Pair<Integer, Integer> getVP8Dimension(InputStream inputStream) throws IOException {
        inputStream.skip(7);
        short s = getShort(inputStream);
        short s2 = getShort(inputStream);
        short s3 = getShort(inputStream);
        if (s == 157 && s2 == 1 && s3 == 42) {
            return new Pair<>(Integer.valueOf(get2BytesAsInt(inputStream)), Integer.valueOf(get2BytesAsInt(inputStream)));
        }
        return null;
    }

    private static Pair<Integer, Integer> getVP8LDimension(InputStream inputStream) throws IOException {
        getInt(inputStream);
        if (getByte(inputStream) != 47) {
            return null;
        }
        byte read = ((byte) inputStream.read()) & 255;
        return new Pair<>(Integer.valueOf(((((byte) inputStream.read()) & 255) | ((read & 63) << 8)) + 1), Integer.valueOf(((((((byte) inputStream.read()) & 255) & 15) << 10) | ((((byte) inputStream.read()) & 255) << 2) | ((read & 192) >> 6)) + 1));
    }

    private static Pair<Integer, Integer> getVP8XDimension(InputStream inputStream) throws IOException {
        inputStream.skip(8);
        return new Pair<>(Integer.valueOf(read3Bytes(inputStream) + 1), Integer.valueOf(read3Bytes(inputStream) + 1));
    }

    private static boolean compare(byte[] bArr, String str) {
        if (bArr.length != str.length()) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (str.charAt(i) != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    private static String getHeader(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append((char) b2);
        }
        return sb.toString();
    }

    private static int getInt(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 24) & g.BYTE) | ((((byte) inputStream.read()) << 16) & g.BYTE) | ((((byte) inputStream.read()) << 8) & g.BYTE) | (((byte) inputStream.read()) & 255);
    }

    public static int get2BytesAsInt(InputStream inputStream) throws IOException {
        return ((((byte) inputStream.read()) << 8) & g.BYTE) | (((byte) inputStream.read()) & 255);
    }

    private static int read3Bytes(InputStream inputStream) throws IOException {
        byte b2 = getByte(inputStream);
        return ((getByte(inputStream) << 16) & g.BYTE) | ((getByte(inputStream) << 8) & g.BYTE) | (b2 & 255);
    }

    private static short getShort(InputStream inputStream) throws IOException {
        return (short) (inputStream.read() & 255);
    }

    private static byte getByte(InputStream inputStream) throws IOException {
        return (byte) (inputStream.read() & 255);
    }

    private static boolean isBitOne(byte b2, int i) {
        return ((b2 >> (i % 8)) & 1) == 1;
    }
}

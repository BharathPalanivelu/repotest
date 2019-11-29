package com.tencent.liteav.network.a.a;

import com.facebook.imageutils.JfifUtil;
import com.tencent.liteav.network.a.b.a;
import com.tencent.liteav.network.a.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class b {
    public static byte[] a(String str, int i) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        a aVar = new a();
        aVar.a(8);
        try {
            dataOutputStream.writeShort((short) i);
            dataOutputStream.writeShort((short) aVar.a());
            dataOutputStream.writeShort(1);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.writeShort(0);
            dataOutputStream.flush();
            b((OutputStream) byteArrayOutputStream, str);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    private static void a(OutputStream outputStream, String str) throws IOException {
        for (String ascii : str.split("[.。．｡]")) {
            byte[] bytes = IDN.toASCII(ascii).getBytes();
            outputStream.write(bytes.length);
            outputStream.write(bytes, 0, bytes.length);
        }
        outputStream.write(0);
    }

    private static void b(OutputStream outputStream, String str) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        a(outputStream, str);
        dataOutputStream.writeShort(1);
        dataOutputStream.writeShort(1);
    }

    public static e[] a(byte[] bArr, int i, String str) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        if (readUnsignedShort == i) {
            int readUnsignedShort2 = dataInputStream.readUnsignedShort();
            boolean z = true;
            boolean z2 = ((readUnsignedShort2 >> 8) & 1) == 1;
            if (((readUnsignedShort2 >> 7) & 1) != 1) {
                z = false;
            }
            if (!z || !z2) {
                throw new com.tencent.liteav.network.a.a(str, "the dns server cant support recursion ");
            }
            int readUnsignedShort3 = dataInputStream.readUnsignedShort();
            int readUnsignedShort4 = dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            dataInputStream.readUnsignedShort();
            a(dataInputStream, bArr, readUnsignedShort3);
            return b(dataInputStream, bArr, readUnsignedShort4);
        }
        throw new com.tencent.liteav.network.a.a(str, "the answer id " + readUnsignedShort + " is not match " + i);
    }

    private static String a(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if ((readUnsignedByte & JfifUtil.MARKER_SOFn) == 192) {
            int readUnsignedByte2 = ((readUnsignedByte & 63) << 8) + dataInputStream.readUnsignedByte();
            HashSet hashSet = new HashSet();
            hashSet.add(Integer.valueOf(readUnsignedByte2));
            return a(bArr, readUnsignedByte2, (HashSet<Integer>) hashSet);
        } else if (readUnsignedByte == 0) {
            return "";
        } else {
            byte[] bArr2 = new byte[readUnsignedByte];
            dataInputStream.readFully(bArr2);
            String unicode = IDN.toUnicode(new String(bArr2));
            String a2 = a(dataInputStream, bArr);
            if (a2.length() <= 0) {
                return unicode;
            }
            return unicode + "." + a2;
        }
    }

    private static String a(byte[] bArr, int i, HashSet<Integer> hashSet) throws IOException {
        byte b2 = bArr[i] & 255;
        if ((b2 & 192) == 192) {
            int i2 = ((b2 & 63) << 8) + (bArr[i + 1] & 255);
            if (!hashSet.contains(Integer.valueOf(i2))) {
                hashSet.add(Integer.valueOf(i2));
                return a(bArr, i2, hashSet);
            }
            throw new com.tencent.liteav.network.a.a("", "Cyclic offsets detected.");
        } else if (b2 == 0) {
            return "";
        } else {
            int i3 = i + 1;
            String str = new String(bArr, i3, b2);
            String a2 = a(bArr, i3 + b2, hashSet);
            if (a2.length() <= 0) {
                return str;
            }
            return str + "." + a2;
        }
    }

    private static void a(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        while (true) {
            int i2 = i - 1;
            if (i > 0) {
                a(dataInputStream, bArr);
                dataInputStream.readUnsignedShort();
                dataInputStream.readUnsignedShort();
                i = i2;
            } else {
                return;
            }
        }
    }

    private static e[] b(DataInputStream dataInputStream, byte[] bArr, int i) throws IOException {
        e[] eVarArr = new e[i];
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                return eVarArr;
            }
            eVarArr[i2] = b(dataInputStream, bArr);
            i2++;
            i = i3;
        }
    }

    private static e b(DataInputStream dataInputStream, byte[] bArr) throws IOException {
        String str;
        a(dataInputStream, bArr);
        int readUnsignedShort = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        long readUnsignedShort2 = (((long) dataInputStream.readUnsignedShort()) << 16) + ((long) dataInputStream.readUnsignedShort());
        int readUnsignedShort3 = dataInputStream.readUnsignedShort();
        if (readUnsignedShort == 1) {
            byte[] bArr2 = new byte[4];
            dataInputStream.readFully(bArr2);
            str = InetAddress.getByAddress(bArr2).getHostAddress();
        } else if (readUnsignedShort != 5) {
            for (int i = 0; i < readUnsignedShort3; i++) {
                dataInputStream.readByte();
            }
            str = null;
        } else {
            str = a(dataInputStream, bArr);
        }
        if (str != null) {
            return new e(str, readUnsignedShort, (int) readUnsignedShort2, System.currentTimeMillis() / 1000);
        }
        throw new UnknownHostException("no record");
    }
}

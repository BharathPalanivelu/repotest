package tencent.tls.tools;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Random;

class CryptorImpl {
    private int contextStart;
    private int crypt;
    private boolean header = true;
    private byte[] key;
    private byte[] out;
    private int padding;
    private byte[] plain;
    private int pos;
    private int preCrypt;
    private byte[] prePlain;
    private Random random = new Random();

    CryptorImpl() {
    }

    private static long getUnsignedInt(byte[] bArr, int i, int i2) {
        int i3 = i2 > 4 ? i + 4 : i2 + i;
        long j = 0;
        while (i < i3) {
            j = (j << 8) | ((long) (bArr[i] & 255));
            i++;
        }
        return 4294967295L & j;
    }

    /* access modifiers changed from: protected */
    public byte[] decrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3 = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        byte[] bArr3 = new byte[(i + 8)];
        if (i2 % 8 != 0 || i2 < 16) {
            return null;
        }
        this.prePlain = decipher(bArr, i);
        this.pos = this.prePlain[0] & 7;
        int i4 = (i2 - this.pos) - 10;
        if (i4 < 0) {
            return null;
        }
        for (int i5 = i; i5 < bArr3.length; i5++) {
            bArr3[i5] = 0;
        }
        this.out = new byte[i4];
        this.preCrypt = 0;
        this.crypt = 8;
        this.contextStart = 8;
        this.pos++;
        this.padding = 1;
        while (true) {
            int i6 = this.padding;
            if (i6 <= 2) {
                int i7 = this.pos;
                if (i7 < 8) {
                    this.pos = i7 + 1;
                    this.padding = i6 + 1;
                }
                if (this.pos == 8) {
                    if (!decrypt8Bytes(bArr, i, i2)) {
                        return null;
                    }
                    bArr3 = bArr;
                }
            } else {
                while (i4 != 0) {
                    int i8 = this.pos;
                    if (i8 < 8) {
                        this.out[i3] = (byte) (bArr3[(this.preCrypt + i) + i8] ^ this.prePlain[i8]);
                        i3++;
                        i4--;
                        this.pos = i8 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt - 8;
                        if (!decrypt8Bytes(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                }
                this.padding = 1;
                while (this.padding < 8) {
                    int i9 = this.pos;
                    if (i9 < 8) {
                        if ((bArr3[(this.preCrypt + i) + i9] ^ this.prePlain[i9]) != 0) {
                            return null;
                        }
                        this.pos = i9 + 1;
                    }
                    if (this.pos == 8) {
                        this.preCrypt = this.crypt;
                        if (!decrypt8Bytes(bArr, i, i2)) {
                            return null;
                        }
                        bArr3 = bArr;
                    }
                    this.padding++;
                }
                return this.out;
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] decrypt(byte[] bArr, byte[] bArr2) {
        return decrypt(bArr, 0, bArr.length, bArr2);
    }

    private byte[] encrypt(byte[] bArr, int i, int i2, byte[] bArr2) {
        int i3;
        this.plain = new byte[8];
        this.prePlain = new byte[8];
        this.pos = 1;
        this.padding = 0;
        this.preCrypt = 0;
        this.crypt = 0;
        this.key = bArr2;
        this.header = true;
        this.pos = (i2 + 10) % 8;
        int i4 = this.pos;
        if (i4 != 0) {
            this.pos = 8 - i4;
        }
        this.out = new byte[(this.pos + i2 + 10)];
        this.plain[0] = (byte) ((rand() & 248) | this.pos);
        int i5 = 1;
        while (true) {
            i3 = this.pos;
            if (i5 > i3) {
                break;
            }
            this.plain[i5] = (byte) (rand() & 255);
            i5++;
        }
        this.pos = i3 + 1;
        for (int i6 = 0; i6 < 8; i6++) {
            this.prePlain[i6] = 0;
        }
        this.padding = 1;
        while (this.padding <= 2) {
            int i7 = this.pos;
            if (i7 < 8) {
                byte[] bArr3 = this.plain;
                this.pos = i7 + 1;
                bArr3[i7] = (byte) (rand() & 255);
                this.padding++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        while (i2 > 0) {
            int i8 = this.pos;
            if (i8 < 8) {
                byte[] bArr4 = this.plain;
                this.pos = i8 + 1;
                bArr4[i8] = bArr[i];
                i2--;
                i++;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
        this.padding = 1;
        while (true) {
            int i9 = this.padding;
            if (i9 > 7) {
                return this.out;
            }
            int i10 = this.pos;
            if (i10 < 8) {
                byte[] bArr5 = this.plain;
                this.pos = i10 + 1;
                bArr5[i10] = 0;
                this.padding = i9 + 1;
            }
            if (this.pos == 8) {
                encrypt8Bytes();
            }
        }
    }

    /* access modifiers changed from: protected */
    public byte[] encrypt(byte[] bArr, byte[] bArr2) {
        return encrypt(bArr, 0, bArr.length, bArr2);
    }

    private byte[] encipher(byte[] bArr) {
        byte[] bArr2 = bArr;
        int i = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr2, 0, 4);
            long unsignedInt2 = getUnsignedInt(bArr2, 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 0;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    j = (j + 2654435769L) & 4294967295L;
                    unsignedInt = (unsignedInt + ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                    unsignedInt2 = (unsignedInt2 + ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                    i = i2;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private byte[] decipher(byte[] bArr, int i) {
        byte[] bArr2 = bArr;
        int i2 = i;
        int i3 = 16;
        try {
            long unsignedInt = getUnsignedInt(bArr2, i2, 4);
            long unsignedInt2 = getUnsignedInt(bArr2, i2 + 4, 4);
            long unsignedInt3 = getUnsignedInt(this.key, 0, 4);
            long unsignedInt4 = getUnsignedInt(this.key, 4, 4);
            long unsignedInt5 = getUnsignedInt(this.key, 8, 4);
            long unsignedInt6 = getUnsignedInt(this.key, 12, 4);
            long j = 3816266640L;
            while (true) {
                int i4 = i3 - 1;
                if (i3 > 0) {
                    unsignedInt2 = (unsignedInt2 - ((((unsignedInt << 4) + unsignedInt5) ^ (unsignedInt + j)) ^ ((unsignedInt >>> 5) + unsignedInt6))) & 4294967295L;
                    unsignedInt = (unsignedInt - ((((unsignedInt2 << 4) + unsignedInt3) ^ (unsignedInt2 + j)) ^ ((unsignedInt2 >>> 5) + unsignedInt4))) & 4294967295L;
                    j = (j - 2654435769L) & 4294967295L;
                    i3 = i4;
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
                    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                    dataOutputStream.writeInt((int) unsignedInt);
                    dataOutputStream.writeInt((int) unsignedInt2);
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException unused) {
            return null;
        }
    }

    private byte[] decipher(byte[] bArr) {
        return decipher(bArr, 0);
    }

    private void encrypt8Bytes() {
        this.pos = 0;
        while (true) {
            int i = this.pos;
            if (i >= 8) {
                break;
            }
            if (this.header) {
                byte[] bArr = this.plain;
                bArr[i] = (byte) (bArr[i] ^ this.prePlain[i]);
            } else {
                byte[] bArr2 = this.plain;
                bArr2[i] = (byte) (bArr2[i] ^ this.out[this.preCrypt + i]);
            }
            this.pos++;
        }
        System.arraycopy(encipher(this.plain), 0, this.out, this.crypt, 8);
        this.pos = 0;
        while (true) {
            int i2 = this.pos;
            if (i2 < 8) {
                byte[] bArr3 = this.out;
                int i3 = this.crypt + i2;
                bArr3[i3] = (byte) (bArr3[i3] ^ this.prePlain[i2]);
                this.pos = i2 + 1;
            } else {
                System.arraycopy(this.plain, 0, this.prePlain, 0, 8);
                int i4 = this.crypt;
                this.preCrypt = i4;
                this.crypt = i4 + 8;
                this.pos = 0;
                this.header = false;
                return;
            }
        }
    }

    private boolean decrypt8Bytes(byte[] bArr, int i, int i2) {
        this.pos = 0;
        while (true) {
            int i3 = this.pos;
            if (i3 >= 8) {
                this.prePlain = decipher(this.prePlain);
                if (this.prePlain == null) {
                    return false;
                }
                this.contextStart += 8;
                this.crypt += 8;
                this.pos = 0;
                return true;
            } else if (this.contextStart + i3 >= i2) {
                return true;
            } else {
                byte[] bArr2 = this.prePlain;
                bArr2[i3] = (byte) (bArr2[i3] ^ bArr[(this.crypt + i) + i3]);
                this.pos = i3 + 1;
            }
        }
    }

    private int rand() {
        return this.random.nextInt();
    }
}

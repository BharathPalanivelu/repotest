package com.facebook.soloader;

import com.litesuits.orm.db.assit.SQLStatement;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;

    public enum ISA {
        NOT_SO("not_so"),
        X86("x86"),
        ARM("armeabi-v7a"),
        X86_64("x86_64"),
        AARCH64("arm64-v8a"),
        OTHERS("others");
        
        private final String value;

        private ISA(String str) {
            this.value = str;
        }

        public String toString() {
            return this.value;
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return extract_DT_NEEDED(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j;
        boolean z;
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        long j10;
        long j11;
        long j12;
        FileChannel fileChannel2 = fileChannel;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel2, allocate, 0) == 1179403647) {
            boolean z2 = true;
            if (getu8(fileChannel2, allocate, 4) != 1) {
                z2 = false;
            }
            if (getu8(fileChannel2, allocate, 5) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            long r15 = z2 ? getu32(fileChannel2, allocate, 28) : get64(fileChannel2, allocate, 32);
            long j13 = z2 ? (long) getu16(fileChannel2, allocate, 44) : (long) getu16(fileChannel2, allocate, 56);
            int i = getu16(fileChannel2, allocate, z2 ? 42 : 54);
            if (j13 == 65535) {
                long r3 = z2 ? getu32(fileChannel2, allocate, 32) : get64(fileChannel2, allocate, 40);
                if (z2) {
                    j12 = getu32(fileChannel2, allocate, r3 + 28);
                } else {
                    j12 = getu32(fileChannel2, allocate, r3 + 44);
                }
                j13 = j12;
            }
            long j14 = r15;
            long j15 = 0;
            while (true) {
                if (j15 >= j13) {
                    j = 0;
                    break;
                }
                if (z2) {
                    j11 = getu32(fileChannel2, allocate, j14 + 0);
                } else {
                    j11 = getu32(fileChannel2, allocate, j14 + 0);
                }
                if (j11 != 2) {
                    j14 += (long) i;
                    j15++;
                } else if (z2) {
                    j = getu32(fileChannel2, allocate, j14 + 4);
                } else {
                    j = get64(fileChannel2, allocate, j14 + 8);
                }
            }
            long j16 = 0;
            if (j != 0) {
                long j17 = j;
                long j18 = 0;
                int i2 = 0;
                while (true) {
                    if (z2) {
                        z = z2;
                        j2 = getu32(fileChannel2, allocate, j17 + j16);
                    } else {
                        z = z2;
                        j2 = get64(fileChannel2, allocate, j17 + j16);
                    }
                    if (j2 == 1) {
                        j3 = j;
                        if (i2 != Integer.MAX_VALUE) {
                            i2++;
                        } else {
                            throw new ElfError("malformed DT_NEEDED section");
                        }
                    } else {
                        j3 = j;
                        if (j2 == 5) {
                            if (z) {
                                j10 = getu32(fileChannel2, allocate, j17 + 4);
                            } else {
                                j10 = get64(fileChannel2, allocate, j17 + 8);
                            }
                            j18 = j10;
                        }
                    }
                    long j19 = 16;
                    j17 += z ? 8 : 16;
                    j16 = 0;
                    if (j2 != 0) {
                        z2 = z;
                        j = j3;
                    } else if (j18 != 0) {
                        int i3 = 0;
                        while (true) {
                            if (((long) i3) >= j13) {
                                j4 = 0;
                                break;
                            }
                            if (z) {
                                j5 = getu32(fileChannel2, allocate, r15 + j16);
                            } else {
                                j5 = getu32(fileChannel2, allocate, r15 + j16);
                            }
                            if (j5 == 1) {
                                if (z) {
                                    j7 = getu32(fileChannel2, allocate, r15 + 8);
                                } else {
                                    j7 = get64(fileChannel2, allocate, r15 + j19);
                                }
                                if (z) {
                                    j6 = j13;
                                    j8 = getu32(fileChannel2, allocate, r15 + 20);
                                } else {
                                    j6 = j13;
                                    j8 = get64(fileChannel2, allocate, r15 + 40);
                                }
                                if (j7 <= j18 && j18 < j8 + j7) {
                                    if (z) {
                                        j9 = getu32(fileChannel2, allocate, r15 + 4);
                                    } else {
                                        j9 = get64(fileChannel2, allocate, r15 + 8);
                                    }
                                    j4 = j9 + (j18 - j7);
                                }
                            } else {
                                j6 = j13;
                            }
                            r15 += (long) i;
                            i3++;
                            j13 = j6;
                            j19 = 16;
                            j16 = 0;
                        }
                        long j20 = 0;
                        if (j4 != 0) {
                            String[] strArr = new String[i2];
                            int i4 = 0;
                            while (true) {
                                long r9 = z ? getu32(fileChannel2, allocate, j3 + j20) : get64(fileChannel2, allocate, j3 + j20);
                                if (r9 == 1) {
                                    strArr[i4] = getSz(fileChannel2, allocate, (z ? getu32(fileChannel2, allocate, j3 + 4) : get64(fileChannel2, allocate, j3 + 8)) + j4);
                                    if (i4 != Integer.MAX_VALUE) {
                                        i4++;
                                    } else {
                                        throw new ElfError("malformed DT_NEEDED section");
                                    }
                                }
                                j3 += z ? 8 : 16;
                                if (r9 != 0) {
                                    j20 = 0;
                                } else if (i4 == strArr.length) {
                                    return strArr;
                                } else {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                            }
                        } else {
                            throw new ElfError("did not find file offset of DT_STRTAB table");
                        }
                    } else {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                }
            } else {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }

    private static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j2 = 1 + j;
            short u8Var = getu8(fileChannel, byteBuffer, j);
            if (u8Var == 0) {
                return sb.toString();
            }
            sb.append((char) u8Var);
            j = j2;
        }
    }

    private static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i, long j) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i);
        while (byteBuffer.remaining() > 0) {
            int read = fileChannel.read(byteBuffer, j);
            if (read == -1) {
                break;
            }
            j += (long) read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    private static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 8, j);
        return byteBuffer.getLong();
    }

    private static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 4, j);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    private static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 2, j);
        return byteBuffer.getShort() & SQLStatement.NONE;
    }

    private static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j) throws IOException {
        read(fileChannel, byteBuffer, 1, j);
        return (short) (byteBuffer.get() & 255);
    }

    private static class ElfError extends RuntimeException {
        ElfError(String str) {
            super(str);
        }
    }
}

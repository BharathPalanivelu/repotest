package com.google.c;

import com.tencent.qcloud.core.util.IOUtils;

final class aq {

    private interface a {
        byte a(int i);

        int a();
    }

    static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.a());
        for (int i = 0; i < aVar.a(); i++) {
            byte a2 = aVar.a(i);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            break;
                        } else {
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    static String a(final f fVar) {
        return a((a) new a() {
            public int a() {
                return fVar.b();
            }

            public byte a(int i) {
                return fVar.a(i);
            }
        });
    }

    static String a(final byte[] bArr) {
        return a((a) new a() {
            public int a() {
                return bArr.length;
            }

            public byte a(int i) {
                return bArr[i];
            }
        });
    }

    static String a(String str) {
        return a(f.a(str));
    }

    static String b(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}

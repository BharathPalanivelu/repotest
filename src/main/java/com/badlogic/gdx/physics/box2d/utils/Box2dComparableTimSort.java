package com.badlogic.gdx.physics.box2d.utils;

import com.litesuits.orm.db.assit.SQLBuilder;

public class Box2dComparableTimSort {
    private static final boolean DEBUG = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;

    /* renamed from: a  reason: collision with root package name */
    private Object[] f4667a;
    private int minGallop;
    private final int[] runBase;
    private final int[] runLen;
    private int stackSize;
    private Object[] tmp;
    private int tmpCount;

    private static int minRunLength(int i) {
        int i2 = 0;
        while (i >= 32) {
            i2 |= i & 1;
            i >>= 1;
        }
        return i + i2;
    }

    Box2dComparableTimSort() {
        this.minGallop = 7;
        this.stackSize = 0;
        this.tmp = new Object[256];
        this.runBase = new int[40];
        this.runLen = new int[40];
    }

    public void doSort(Object[] objArr, int i, int i2) {
        this.stackSize = 0;
        rangeCheck(objArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 >= 2) {
            if (i3 < 32) {
                binarySort(objArr, i, i2, countRunAndMakeAscending(objArr, i, i2) + i);
                return;
            }
            this.f4667a = objArr;
            this.tmpCount = 0;
            int minRunLength = minRunLength(i3);
            do {
                int countRunAndMakeAscending = countRunAndMakeAscending(objArr, i, i2);
                if (countRunAndMakeAscending < minRunLength) {
                    int i4 = i3 <= minRunLength ? i3 : minRunLength;
                    binarySort(objArr, i, i + i4, countRunAndMakeAscending + i);
                    countRunAndMakeAscending = i4;
                }
                pushRun(i, countRunAndMakeAscending);
                mergeCollapse();
                i += countRunAndMakeAscending;
                i3 -= countRunAndMakeAscending;
            } while (i3 != 0);
            mergeForceCollapse();
            this.f4667a = null;
            Object[] objArr2 = this.tmp;
            int i5 = this.tmpCount;
            for (int i6 = 0; i6 < i5; i6++) {
                objArr2[i6] = null;
            }
        }
    }

    private Box2dComparableTimSort(Object[] objArr) {
        this.minGallop = 7;
        this.stackSize = 0;
        this.f4667a = objArr;
        int length = objArr.length;
        this.tmp = new Object[(length < 512 ? length >>> 1 : 256)];
        int i = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.runBase = new int[i];
        this.runLen = new int[i];
    }

    static void sort(Object[] objArr) {
        sort(objArr, 0, objArr.length);
    }

    static void sort(Object[] objArr, int i, int i2) {
        rangeCheck(objArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 >= 2) {
            if (i3 < 32) {
                binarySort(objArr, i, i2, countRunAndMakeAscending(objArr, i, i2) + i);
                return;
            }
            Box2dComparableTimSort box2dComparableTimSort = new Box2dComparableTimSort(objArr);
            int minRunLength = minRunLength(i3);
            do {
                int countRunAndMakeAscending = countRunAndMakeAscending(objArr, i, i2);
                if (countRunAndMakeAscending < minRunLength) {
                    int i4 = i3 <= minRunLength ? i3 : minRunLength;
                    binarySort(objArr, i, i + i4, countRunAndMakeAscending + i);
                    countRunAndMakeAscending = i4;
                }
                box2dComparableTimSort.pushRun(i, countRunAndMakeAscending);
                box2dComparableTimSort.mergeCollapse();
                i += countRunAndMakeAscending;
                i3 -= countRunAndMakeAscending;
            } while (i3 != 0);
            box2dComparableTimSort.mergeForceCollapse();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:0:0x0000, code lost:
        if (r8 == r6) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0015, code lost:
        if (r2 == 2) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        java.lang.System.arraycopy(r5, r1, r5, r1 + 1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001d, code lost:
        r5[r1 + 2] = r5[r1 + 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        r5[r1 + 1] = r5[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002b, code lost:
        r5[r1] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        r3 = (r1 + r2) >>> 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0038, code lost:
        if (r0.compareTo(r5[r3]) >= 0) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r1 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        if (r8 < r7) goto L_0x0007;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0007, code lost:
        r0 = (java.lang.Comparable) r5[r8];
        r1 = r6;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r1 < r2) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        r2 = r8 - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r2 == 1) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void binarySort(java.lang.Object[] r5, int r6, int r7, int r8) {
        /*
            if (r8 != r6) goto L_0x0004
        L_0x0002:
            int r8 = r8 + 1
        L_0x0004:
            if (r8 < r7) goto L_0x0007
            return
        L_0x0007:
            r0 = r5[r8]
            java.lang.Comparable r0 = (java.lang.Comparable) r0
            r1 = r6
            r2 = r8
        L_0x000d:
            r3 = 1
            if (r1 < r2) goto L_0x002e
            int r2 = r8 - r1
            if (r2 == r3) goto L_0x0025
            r3 = 2
            if (r2 == r3) goto L_0x001d
            int r3 = r1 + 1
            java.lang.System.arraycopy(r5, r1, r5, r3, r2)
            goto L_0x002b
        L_0x001d:
            int r2 = r1 + 2
            int r3 = r1 + 1
            r3 = r5[r3]
            r5[r2] = r3
        L_0x0025:
            int r2 = r1 + 1
            r3 = r5[r1]
            r5[r2] = r3
        L_0x002b:
            r5[r1] = r0
            goto L_0x0002
        L_0x002e:
            int r4 = r1 + r2
            int r3 = r4 >>> 1
            r4 = r5[r3]
            int r4 = r0.compareTo(r4)
            if (r4 >= 0) goto L_0x003c
            r2 = r3
            goto L_0x000d
        L_0x003c:
            int r1 = r3 + 1
            goto L_0x000d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dComparableTimSort.binarySort(java.lang.Object[], int, int, int):void");
    }

    private static int countRunAndMakeAscending(Object[] objArr, int i, int i2) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (objArr[i3].compareTo(objArr[i]) < 0) {
            while (i4 < i2 && objArr[i4].compareTo(objArr[i4 - 1]) < 0) {
                i4++;
            }
            reverseRange(objArr, i, i4);
        } else {
            while (i4 < i2 && objArr[i4].compareTo(objArr[i4 - 1]) >= 0) {
                i4++;
            }
        }
        return i4 - i;
    }

    private static void reverseRange(Object[] objArr, int i, int i2) {
        int i3 = i2 - 1;
        while (i < i3) {
            Object obj = objArr[i];
            objArr[i] = objArr[i3];
            objArr[i3] = obj;
            i3--;
            i++;
        }
    }

    private void pushRun(int i, int i2) {
        int[] iArr = this.runBase;
        int i3 = this.stackSize;
        iArr[i3] = i;
        this.runLen[i3] = i2;
        this.stackSize = i3 + 1;
    }

    private void mergeCollapse() {
        while (true) {
            int i = this.stackSize;
            if (i > 1) {
                int i2 = i - 2;
                if (i2 > 0) {
                    int[] iArr = this.runLen;
                    int i3 = i2 - 1;
                    int i4 = i2 + 1;
                    if (iArr[i3] <= iArr[i2] + iArr[i4]) {
                        if (iArr[i3] < iArr[i4]) {
                            i2--;
                        }
                        mergeAt(i2);
                    }
                }
                int[] iArr2 = this.runLen;
                if (iArr2[i2] <= iArr2[i2 + 1]) {
                    mergeAt(i2);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    private void mergeForceCollapse() {
        while (true) {
            int i = this.stackSize;
            if (i > 1) {
                int i2 = i - 2;
                if (i2 > 0) {
                    int[] iArr = this.runLen;
                    if (iArr[i2 - 1] < iArr[i2 + 1]) {
                        i2--;
                    }
                }
                mergeAt(i2);
            } else {
                return;
            }
        }
    }

    private void mergeAt(int i) {
        int[] iArr = this.runBase;
        int i2 = iArr[i];
        int[] iArr2 = this.runLen;
        int i3 = iArr2[i];
        int i4 = i + 1;
        int i5 = iArr[i4];
        int i6 = iArr2[i4];
        iArr2[i] = i3 + i6;
        if (i == this.stackSize - 3) {
            int i7 = i + 2;
            iArr[i4] = iArr[i7];
            iArr2[i4] = iArr2[i7];
        }
        this.stackSize--;
        Object[] objArr = this.f4667a;
        int gallopRight = gallopRight((Comparable) objArr[i5], objArr, i2, i3, 0);
        int i8 = i2 + gallopRight;
        int i9 = i3 - gallopRight;
        if (i9 != 0) {
            Object[] objArr2 = this.f4667a;
            int gallopLeft = gallopLeft((Comparable) objArr2[(i8 + i9) - 1], objArr2, i5, i6, i6 - 1);
            if (gallopLeft != 0) {
                if (i9 <= gallopLeft) {
                    mergeLo(i8, i9, i5, gallopLeft);
                } else {
                    mergeHi(i8, i9, i5, gallopLeft);
                }
            }
        }
    }

    private static int gallopLeft(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparable.compareTo(objArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparable.compareTo(objArr[i6 + i9]) > 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            int i12 = i8 + i3;
            i4 = i7 + i3;
            i5 = i12;
        } else {
            int i13 = i3 + 1;
            int i14 = 0;
            int i15 = 1;
            while (i15 < i13 && comparable.compareTo(objArr[i6 - i15]) <= 0) {
                int i16 = (i15 << 1) + 1;
                if (i16 <= 0) {
                    i14 = i15;
                    i15 = i13;
                } else {
                    int i17 = i15;
                    i15 = i16;
                    i14 = i17;
                }
            }
            if (i15 <= i13) {
                i13 = i15;
            }
            i5 = i3 - i13;
            i4 = i3 - i14;
        }
        int i18 = i5 + 1;
        while (i18 < i4) {
            int i19 = ((i4 - i18) >>> 1) + i18;
            if (comparable.compareTo(objArr[i + i19]) > 0) {
                i18 = i19 + 1;
            } else {
                i4 = i19;
            }
        }
        return i4;
    }

    private static int gallopRight(Comparable<Object> comparable, Object[] objArr, int i, int i2, int i3) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparable.compareTo(objArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparable.compareTo(objArr[i6 - i9]) < 0) {
                int i10 = (i9 << 1) + 1;
                if (i10 <= 0) {
                    i8 = i9;
                    i9 = i7;
                } else {
                    int i11 = i9;
                    i9 = i10;
                    i8 = i11;
                }
            }
            if (i9 <= i7) {
                i7 = i9;
            }
            i5 = i3 - i7;
            i4 = i3 - i8;
        } else {
            int i12 = i2 - i3;
            int i13 = 0;
            int i14 = 1;
            while (i14 < i12 && comparable.compareTo(objArr[i6 + i14]) >= 0) {
                int i15 = (i14 << 1) + 1;
                if (i15 <= 0) {
                    i13 = i14;
                    i14 = i12;
                } else {
                    int i16 = i14;
                    i14 = i15;
                    i13 = i16;
                }
            }
            if (i14 <= i12) {
                i12 = i14;
            }
            int i17 = i13 + i3;
            i4 = i3 + i12;
            i5 = i17;
        }
        int i18 = i5 + 1;
        while (i18 < i4) {
            int i19 = ((i4 - i18) >>> 1) + i18;
            if (comparable.compareTo(objArr[i + i19]) < 0) {
                i4 = i19;
            } else {
                i18 = i19 + 1;
            }
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r4 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0064, code lost:
        r15 = gallopRight((java.lang.Comparable) r0[r4], r1, r13, r5, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        if (r15 == 0) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006e, code lost:
        java.lang.System.arraycopy(r1, r13, r0, r3, r15);
        r3 = r3 + r15;
        r13 = r13 + r15;
        r5 = r5 - r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        if (r5 > 1) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0076, code lost:
        r6 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0078, code lost:
        r6 = r3 + 1;
        r8 = r4 + 1;
        r0[r3] = r0[r4];
        r7 = r7 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0082, code lost:
        if (r7 != 0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0085, code lost:
        r3 = gallopLeft((java.lang.Comparable) r1[r13], r0, r8, r7, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        if (r3 == 0) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        java.lang.System.arraycopy(r0, r8, r0, r6, r3);
        r4 = r6 + r3;
        r6 = r8 + r3;
        r7 = r7 - r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0097, code lost:
        if (r7 != 0) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0099, code lost:
        r10 = r6;
        r6 = r4;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009d, code lost:
        r4 = r6;
        r6 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x009f, code lost:
        r8 = r4 + 1;
        r9 = r13 + 1;
        r0[r4] = r1[r13];
        r5 = r5 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a9, code lost:
        if (r5 != 1) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ab, code lost:
        r4 = r6;
        r6 = r8;
        r13 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00cc, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00cf, code lost:
        if (r15 < 7) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d1, code lost:
        r15 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d3, code lost:
        r15 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00d4, code lost:
        if (r3 < 7) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00d6, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00da, code lost:
        if ((r13 | r15) != false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00dc, code lost:
        if (r14 >= 0) goto L_0x00df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00de, code lost:
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00e7, code lost:
        r4 = r6;
        r3 = r8;
        r13 = r9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0064 A[EDGE_INSN: B:69:0x0064->B:23:0x0064 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeLo(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f4667a
            java.lang.Object[] r1 = r11.ensureCapacity(r13)
            r2 = 0
            java.lang.System.arraycopy(r0, r12, r1, r2, r13)
            int r3 = r12 + 1
            int r4 = r14 + 1
            r14 = r0[r14]
            r0[r12] = r14
            int r15 = r15 + -1
            if (r15 != 0) goto L_0x001a
            java.lang.System.arraycopy(r1, r2, r0, r3, r13)
            return
        L_0x001a:
            r12 = 1
            if (r13 != r12) goto L_0x0026
            java.lang.System.arraycopy(r0, r4, r0, r3, r15)
            int r3 = r3 + r15
            r12 = r1[r2]
            r0[r3] = r12
            return
        L_0x0026:
            int r14 = r11.minGallop
            r5 = r13
            r13 = 0
        L_0x002a:
            r7 = r15
            r15 = 0
            r6 = 0
        L_0x002d:
            r8 = r0[r4]
            java.lang.Comparable r8 = (java.lang.Comparable) r8
            r9 = r1[r13]
            int r8 = r8.compareTo(r9)
            if (r8 >= 0) goto L_0x004e
            int r15 = r3 + 1
            int r8 = r4 + 1
            r4 = r0[r4]
            r0[r3] = r4
            int r6 = r6 + r12
            int r7 = r7 + -1
            if (r7 != 0) goto L_0x004a
            r6 = r15
        L_0x0047:
            r4 = r8
            goto L_0x00ae
        L_0x004a:
            r3 = r15
            r4 = r8
            r15 = 0
            goto L_0x0060
        L_0x004e:
            int r6 = r3 + 1
            int r8 = r13 + 1
            r13 = r1[r13]
            r0[r3] = r13
            int r15 = r15 + r12
            int r5 = r5 + -1
            if (r5 != r12) goto L_0x005d
            r13 = r8
            goto L_0x00ae
        L_0x005d:
            r3 = r6
            r13 = r8
            r6 = 0
        L_0x0060:
            r8 = r15 | r6
            if (r8 < r14) goto L_0x002d
        L_0x0064:
            r15 = r0[r4]
            java.lang.Comparable r15 = (java.lang.Comparable) r15
            int r15 = gallopRight(r15, r1, r13, r5, r2)
            if (r15 == 0) goto L_0x0078
            java.lang.System.arraycopy(r1, r13, r0, r3, r15)
            int r3 = r3 + r15
            int r13 = r13 + r15
            int r5 = r5 - r15
            if (r5 > r12) goto L_0x0078
            r6 = r3
            goto L_0x00ae
        L_0x0078:
            int r6 = r3 + 1
            int r8 = r4 + 1
            r4 = r0[r4]
            r0[r3] = r4
            int r7 = r7 + -1
            if (r7 != 0) goto L_0x0085
            goto L_0x0047
        L_0x0085:
            r3 = r1[r13]
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = gallopLeft(r3, r0, r8, r7, r2)
            if (r3 == 0) goto L_0x009d
            java.lang.System.arraycopy(r0, r8, r0, r6, r3)
            int r4 = r6 + r3
            int r6 = r8 + r3
            int r7 = r7 - r3
            if (r7 != 0) goto L_0x009f
            r10 = r6
            r6 = r4
            r4 = r10
            goto L_0x00ae
        L_0x009d:
            r4 = r6
            r6 = r8
        L_0x009f:
            int r8 = r4 + 1
            int r9 = r13 + 1
            r13 = r1[r13]
            r0[r4] = r13
            int r5 = r5 + -1
            if (r5 != r12) goto L_0x00cc
            r4 = r6
            r6 = r8
            r13 = r9
        L_0x00ae:
            if (r14 >= r12) goto L_0x00b1
            r14 = 1
        L_0x00b1:
            r11.minGallop = r14
            if (r5 != r12) goto L_0x00be
            java.lang.System.arraycopy(r0, r4, r0, r6, r7)
            int r6 = r6 + r7
            r12 = r1[r13]
            r0[r6] = r12
            goto L_0x00c3
        L_0x00be:
            if (r5 == 0) goto L_0x00c4
            java.lang.System.arraycopy(r1, r13, r0, r6, r5)
        L_0x00c3:
            return
        L_0x00c4:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Comparison method violates its general contract!"
            r12.<init>(r13)
            throw r12
        L_0x00cc:
            int r14 = r14 + -1
            r13 = 7
            if (r15 < r13) goto L_0x00d3
            r15 = 1
            goto L_0x00d4
        L_0x00d3:
            r15 = 0
        L_0x00d4:
            if (r3 < r13) goto L_0x00d8
            r13 = 1
            goto L_0x00d9
        L_0x00d8:
            r13 = 0
        L_0x00d9:
            r13 = r13 | r15
            if (r13 != 0) goto L_0x00e7
            if (r14 >= 0) goto L_0x00df
            r14 = 0
        L_0x00df:
            int r14 = r14 + 2
            r4 = r6
            r15 = r7
            r3 = r8
            r13 = r9
            goto L_0x002a
        L_0x00e7:
            r4 = r6
            r3 = r8
            r13 = r9
            goto L_0x0064
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dComparableTimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0065, code lost:
        r5 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        r13 = r8 - gallopRight((java.lang.Comparable) r1[r5], r0, r12, r8, r8 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007b, code lost:
        if (r13 == 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        r3 = r6 - r13;
        r7 = r7 - r13;
        r8 = r8 - r13;
        java.lang.System.arraycopy(r0, r7 + 1, r0, r3 + 1, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r8 != 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008b, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        r6 = r3 - 1;
        r9 = r5 - 1;
        r0[r3] = r1[r5];
        r15 = r15 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0096, code lost:
        if (r15 != 1) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        r3 = r15 - gallopLeft((java.lang.Comparable) r0[r7], r1, 0, r15, r15 - 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        if (r3 == 0) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r5 = r6 - r3;
        r6 = r9 - r3;
        r15 = r15 - r3;
        java.lang.System.arraycopy(r1, r6 + 1, r0, r5 + 1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b4, code lost:
        if (r15 > 1) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b6, code lost:
        r3 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00b9, code lost:
        r5 = r6;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bb, code lost:
        r9 = r5 - 1;
        r10 = r7 - 1;
        r0[r5] = r0[r7];
        r8 = r8 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c5, code lost:
        if (r8 != 0) goto L_0x00ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c7, code lost:
        r5 = r6;
        r3 = r9;
        r7 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ef, code lost:
        r14 = r14 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00f2, code lost:
        if (r13 < 7) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00f4, code lost:
        r13 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f6, code lost:
        r13 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f7, code lost:
        if (r3 < 7) goto L_0x00fb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f9, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00fb, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00fd, code lost:
        if ((r13 | r3) != false) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ff, code lost:
        if (r14 >= 0) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0101, code lost:
        r14 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x010a, code lost:
        r5 = r6;
        r6 = r9;
        r7 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x006f A[EDGE_INSN: B:68:0x006f->B:21:0x006f ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeHi(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f4667a
            java.lang.Object[] r1 = r11.ensureCapacity(r15)
            r2 = 0
            java.lang.System.arraycopy(r0, r14, r1, r2, r15)
            int r3 = r12 + r13
            r4 = 1
            int r3 = r3 - r4
            int r5 = r15 + -1
            int r14 = r14 + r15
            int r14 = r14 - r4
            int r6 = r14 + -1
            int r7 = r3 + -1
            r3 = r0[r3]
            r0[r14] = r3
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x0023
            int r6 = r6 - r5
            java.lang.System.arraycopy(r1, r2, r0, r6, r15)
            return
        L_0x0023:
            if (r15 != r4) goto L_0x0032
            int r6 = r6 - r13
            int r7 = r7 - r13
            int r7 = r7 + r4
            int r12 = r6 + 1
            java.lang.System.arraycopy(r0, r7, r0, r12, r13)
            r12 = r1[r5]
            r0[r6] = r12
            return
        L_0x0032:
            int r14 = r11.minGallop
        L_0x0034:
            r8 = r13
            r13 = 0
            r3 = 0
        L_0x0037:
            r9 = r1[r5]
            java.lang.Comparable r9 = (java.lang.Comparable) r9
            r10 = r0[r7]
            int r9 = r9.compareTo(r10)
            if (r9 >= 0) goto L_0x0058
            int r13 = r6 + -1
            int r9 = r7 + -1
            r7 = r0[r7]
            r0[r6] = r7
            int r3 = r3 + r4
            int r8 = r8 + -1
            if (r8 != 0) goto L_0x0054
            r3 = r13
            r7 = r9
            goto L_0x00ca
        L_0x0054:
            r6 = r13
            r7 = r9
            r13 = 0
            goto L_0x006b
        L_0x0058:
            int r3 = r6 + -1
            int r9 = r5 + -1
            r5 = r1[r5]
            r0[r6] = r5
            int r13 = r13 + r4
            int r15 = r15 + -1
            if (r15 != r4) goto L_0x0068
        L_0x0065:
            r5 = r9
            goto L_0x00ca
        L_0x0068:
            r6 = r3
            r5 = r9
            r3 = 0
        L_0x006b:
            r9 = r3 | r13
            if (r9 < r14) goto L_0x0037
        L_0x006f:
            r13 = r1[r5]
            java.lang.Comparable r13 = (java.lang.Comparable) r13
            int r3 = r8 + -1
            int r13 = gallopRight(r13, r0, r12, r8, r3)
            int r13 = r8 - r13
            if (r13 == 0) goto L_0x008b
            int r3 = r6 - r13
            int r7 = r7 - r13
            int r8 = r8 - r13
            int r6 = r7 + 1
            int r9 = r3 + 1
            java.lang.System.arraycopy(r0, r6, r0, r9, r13)
            if (r8 != 0) goto L_0x008c
            goto L_0x00ca
        L_0x008b:
            r3 = r6
        L_0x008c:
            int r6 = r3 + -1
            int r9 = r5 + -1
            r5 = r1[r5]
            r0[r3] = r5
            int r15 = r15 + -1
            if (r15 != r4) goto L_0x009a
            r3 = r6
            goto L_0x0065
        L_0x009a:
            r3 = r0[r7]
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r5 = r15 + -1
            int r3 = gallopLeft(r3, r1, r2, r15, r5)
            int r3 = r15 - r3
            if (r3 == 0) goto L_0x00b9
            int r5 = r6 - r3
            int r6 = r9 - r3
            int r15 = r15 - r3
            int r9 = r6 + 1
            int r10 = r5 + 1
            java.lang.System.arraycopy(r1, r9, r0, r10, r3)
            if (r15 > r4) goto L_0x00bb
            r3 = r5
            r5 = r6
            goto L_0x00ca
        L_0x00b9:
            r5 = r6
            r6 = r9
        L_0x00bb:
            int r9 = r5 + -1
            int r10 = r7 + -1
            r7 = r0[r7]
            r0[r5] = r7
            int r8 = r8 + -1
            if (r8 != 0) goto L_0x00ef
            r5 = r6
            r3 = r9
            r7 = r10
        L_0x00ca:
            if (r14 >= r4) goto L_0x00cd
            r14 = 1
        L_0x00cd:
            r11.minGallop = r14
            if (r15 != r4) goto L_0x00de
            int r3 = r3 - r8
            int r7 = r7 - r8
            int r7 = r7 + r4
            int r12 = r3 + 1
            java.lang.System.arraycopy(r0, r7, r0, r12, r8)
            r12 = r1[r5]
            r0[r3] = r12
            goto L_0x00e6
        L_0x00de:
            if (r15 == 0) goto L_0x00e7
            int r12 = r15 + -1
            int r3 = r3 - r12
            java.lang.System.arraycopy(r1, r2, r0, r3, r15)
        L_0x00e6:
            return
        L_0x00e7:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r13 = "Comparison method violates its general contract!"
            r12.<init>(r13)
            throw r12
        L_0x00ef:
            int r14 = r14 + -1
            r5 = 7
            if (r13 < r5) goto L_0x00f6
            r13 = 1
            goto L_0x00f7
        L_0x00f6:
            r13 = 0
        L_0x00f7:
            if (r3 < r5) goto L_0x00fb
            r3 = 1
            goto L_0x00fc
        L_0x00fb:
            r3 = 0
        L_0x00fc:
            r13 = r13 | r3
            if (r13 != 0) goto L_0x010a
            if (r14 >= 0) goto L_0x0102
            r14 = 0
        L_0x0102:
            int r14 = r14 + 2
            r5 = r6
            r13 = r8
            r6 = r9
            r7 = r10
            goto L_0x0034
        L_0x010a:
            r5 = r6
            r6 = r9
            r7 = r10
            goto L_0x006f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dComparableTimSort.mergeHi(int, int, int, int):void");
    }

    private Object[] ensureCapacity(int i) {
        this.tmpCount = Math.max(this.tmpCount, i);
        if (this.tmp.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.f4667a.length >>> 1);
            }
            this.tmp = new Object[i];
        }
        return this.tmp;
    }

    private static void rangeCheck(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex(" + i2 + ") > toIndex(" + i3 + SQLBuilder.PARENTHESES_RIGHT);
        } else if (i2 < 0) {
            throw new ArrayIndexOutOfBoundsException(i2);
        } else if (i3 > i) {
            throw new ArrayIndexOutOfBoundsException(i3);
        }
    }
}

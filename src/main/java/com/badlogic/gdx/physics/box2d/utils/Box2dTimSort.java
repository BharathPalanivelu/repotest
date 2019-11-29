package com.badlogic.gdx.physics.box2d.utils;

import com.litesuits.orm.db.assit.SQLBuilder;
import java.util.Arrays;
import java.util.Comparator;

public class Box2dTimSort<T> {
    private static final boolean DEBUG = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;

    /* renamed from: a  reason: collision with root package name */
    private T[] f4668a;

    /* renamed from: c  reason: collision with root package name */
    private Comparator<? super T> f4669c;
    private int minGallop;
    private final int[] runBase;
    private final int[] runLen;
    private int stackSize;
    private T[] tmp;
    private int tmpCount;

    private static int minRunLength(int i) {
        int i2 = 0;
        while (i >= 32) {
            i2 |= i & 1;
            i >>= 1;
        }
        return i + i2;
    }

    Box2dTimSort() {
        this.minGallop = 7;
        this.stackSize = 0;
        this.tmp = new Object[256];
        this.runBase = new int[40];
        this.runLen = new int[40];
    }

    public void doSort(T[] tArr, Comparator<T> comparator, int i, int i2) {
        this.stackSize = 0;
        rangeCheck(tArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 >= 2) {
            if (i3 < 32) {
                binarySort(tArr, i, i2, countRunAndMakeAscending(tArr, i, i2, comparator) + i, comparator);
                return;
            }
            this.f4668a = tArr;
            this.f4669c = comparator;
            this.tmpCount = 0;
            int minRunLength = minRunLength(i3);
            do {
                int countRunAndMakeAscending = countRunAndMakeAscending(tArr, i, i2, comparator);
                if (countRunAndMakeAscending < minRunLength) {
                    int i4 = i3 <= minRunLength ? i3 : minRunLength;
                    binarySort(tArr, i, i + i4, countRunAndMakeAscending + i, comparator);
                    countRunAndMakeAscending = i4;
                }
                pushRun(i, countRunAndMakeAscending);
                mergeCollapse();
                i += countRunAndMakeAscending;
                i3 -= countRunAndMakeAscending;
            } while (i3 != 0);
            mergeForceCollapse();
            this.f4668a = null;
            this.f4669c = null;
            T[] tArr2 = this.tmp;
            int i5 = this.tmpCount;
            for (int i6 = 0; i6 < i5; i6++) {
                tArr2[i6] = null;
            }
        }
    }

    private Box2dTimSort(T[] tArr, Comparator<? super T> comparator) {
        this.minGallop = 7;
        this.stackSize = 0;
        this.f4668a = tArr;
        this.f4669c = comparator;
        int length = tArr.length;
        this.tmp = new Object[(length < 512 ? length >>> 1 : 256)];
        int i = length < 120 ? 5 : length < 1542 ? 10 : length < 119151 ? 19 : 40;
        this.runBase = new int[i];
        this.runLen = new int[i];
    }

    static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        sort(tArr, 0, tArr.length, comparator);
    }

    static <T> void sort(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        if (comparator == null) {
            Arrays.sort(tArr, i, i2);
            return;
        }
        rangeCheck(tArr.length, i, i2);
        int i3 = i2 - i;
        if (i3 >= 2) {
            if (i3 < 32) {
                binarySort(tArr, i, i2, countRunAndMakeAscending(tArr, i, i2, comparator) + i, comparator);
                return;
            }
            Box2dTimSort box2dTimSort = new Box2dTimSort(tArr, comparator);
            int minRunLength = minRunLength(i3);
            do {
                int countRunAndMakeAscending = countRunAndMakeAscending(tArr, i, i2, comparator);
                if (countRunAndMakeAscending < minRunLength) {
                    int i4 = i3 <= minRunLength ? i3 : minRunLength;
                    binarySort(tArr, i, i + i4, countRunAndMakeAscending + i, comparator);
                    countRunAndMakeAscending = i4;
                }
                box2dTimSort.pushRun(i, countRunAndMakeAscending);
                box2dTimSort.mergeCollapse();
                i += countRunAndMakeAscending;
                i3 -= countRunAndMakeAscending;
            } while (i3 != 0);
            box2dTimSort.mergeForceCollapse();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:0:0x0000, code lost:
        if (r8 == r6) goto L_0x0002;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r2 == 2) goto L_0x001b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        java.lang.System.arraycopy(r5, r1, r5, r1 + 1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r5[r1 + 2] = r5[r1 + 1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        r5[r1 + 1] = r5[r1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5[r1] = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002c, code lost:
        r3 = (r1 + r2) >>> 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        if (r9.compare(r0, r5[r3]) >= 0) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0038, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003a, code lost:
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
        r0 = r5[r8];
        r1 = r6;
        r2 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r1 < r2) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000e, code lost:
        r2 = r8 - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r2 == 1) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> void binarySort(T[] r5, int r6, int r7, int r8, java.util.Comparator<? super T> r9) {
        /*
            if (r8 != r6) goto L_0x0004
        L_0x0002:
            int r8 = r8 + 1
        L_0x0004:
            if (r8 < r7) goto L_0x0007
            return
        L_0x0007:
            r0 = r5[r8]
            r1 = r6
            r2 = r8
        L_0x000b:
            r3 = 1
            if (r1 < r2) goto L_0x002c
            int r2 = r8 - r1
            if (r2 == r3) goto L_0x0023
            r3 = 2
            if (r2 == r3) goto L_0x001b
            int r3 = r1 + 1
            java.lang.System.arraycopy(r5, r1, r5, r3, r2)
            goto L_0x0029
        L_0x001b:
            int r2 = r1 + 2
            int r3 = r1 + 1
            r3 = r5[r3]
            r5[r2] = r3
        L_0x0023:
            int r2 = r1 + 1
            r3 = r5[r1]
            r5[r2] = r3
        L_0x0029:
            r5[r1] = r0
            goto L_0x0002
        L_0x002c:
            int r4 = r1 + r2
            int r3 = r4 >>> 1
            r4 = r5[r3]
            int r4 = r9.compare(r0, r4)
            if (r4 >= 0) goto L_0x003a
            r2 = r3
            goto L_0x000b
        L_0x003a:
            int r1 = r3 + 1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dTimSort.binarySort(java.lang.Object[], int, int, int, java.util.Comparator):void");
    }

    private static <T> int countRunAndMakeAscending(T[] tArr, int i, int i2, Comparator<? super T> comparator) {
        int i3 = i + 1;
        if (i3 == i2) {
            return 1;
        }
        int i4 = i3 + 1;
        if (comparator.compare(tArr[i3], tArr[i]) < 0) {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) < 0) {
                i4++;
            }
            reverseRange(tArr, i, i4);
        } else {
            while (i4 < i2 && comparator.compare(tArr[i4], tArr[i4 - 1]) >= 0) {
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

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002b, code lost:
        r1 = r5.runLen;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0035, code lost:
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        r0 = r0 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0017, code lost:
        if (r1[r0 - 1] > (r1[r0] + r1[r0 + 1])) goto L_0x0019;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeCollapse() {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r5.stackSize
            r1 = 1
            if (r0 > r1) goto L_0x0006
            goto L_0x0044
        L_0x0006:
            int r0 = r0 + -2
            if (r0 < r1) goto L_0x0019
            int[] r1 = r5.runLen
            int r2 = r0 + -1
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + 1
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 <= r3) goto L_0x002b
        L_0x0019:
            r1 = 2
            if (r0 < r1) goto L_0x003a
            int[] r1 = r5.runLen
            int r2 = r0 + -2
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + -1
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 > r3) goto L_0x003a
        L_0x002b:
            int[] r1 = r5.runLen
            int r2 = r0 + -1
            r2 = r1[r2]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 >= r1) goto L_0x0045
            int r0 = r0 + -1
            goto L_0x0045
        L_0x003a:
            int[] r1 = r5.runLen
            r2 = r1[r0]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 <= r1) goto L_0x0045
        L_0x0044:
            return
        L_0x0045:
            r5.mergeAt(r0)
            goto L_0x0000
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dTimSort.mergeCollapse():void");
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
        int i2 = i;
        int[] iArr = this.runBase;
        int i3 = iArr[i2];
        int[] iArr2 = this.runLen;
        int i4 = iArr2[i2];
        int i5 = i2 + 1;
        int i6 = iArr[i5];
        int i7 = iArr2[i5];
        iArr2[i2] = i4 + i7;
        if (i2 == this.stackSize - 3) {
            int i8 = i2 + 2;
            iArr[i5] = iArr[i8];
            iArr2[i5] = iArr2[i8];
        }
        this.stackSize--;
        T[] tArr = this.f4668a;
        int gallopRight = gallopRight(tArr[i6], tArr, i3, i4, 0, this.f4669c);
        int i9 = i3 + gallopRight;
        int i10 = i4 - gallopRight;
        if (i10 != 0) {
            T[] tArr2 = this.f4668a;
            int i11 = i6;
            int gallopLeft = gallopLeft(tArr2[(i9 + i10) - 1], tArr2, i6, i7, i7 - 1, this.f4669c);
            if (gallopLeft != 0) {
                if (i10 <= gallopLeft) {
                    mergeLo(i9, i10, i11, gallopLeft);
                } else {
                    mergeHi(i9, i10, i11, gallopLeft);
                }
            }
        }
    }

    private static <T> int gallopLeft(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) > 0) {
            int i7 = i2 - i3;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 + i9]) > 0) {
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
            while (i15 < i13 && comparator.compare(t, tArr[i6 - i15]) <= 0) {
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
            if (comparator.compare(t, tArr[i + i19]) > 0) {
                i18 = i19 + 1;
            } else {
                i4 = i19;
            }
        }
        return i4;
    }

    private static <T> int gallopRight(T t, T[] tArr, int i, int i2, int i3, Comparator<? super T> comparator) {
        int i4;
        int i5;
        int i6 = i + i3;
        if (comparator.compare(t, tArr[i6]) < 0) {
            int i7 = i3 + 1;
            int i8 = 0;
            int i9 = 1;
            while (i9 < i7 && comparator.compare(t, tArr[i6 - i9]) < 0) {
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
            while (i14 < i12 && comparator.compare(t, tArr[i6 + i14]) >= 0) {
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
            if (comparator.compare(t, tArr[i + i19]) < 0) {
                i4 = i19;
            } else {
                i18 = i19 + 1;
            }
        }
        return i4;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0075, code lost:
        r14 = r2;
        r12 = r4;
        r15 = r5;
        r17 = r6;
        r16 = r13;
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007d, code lost:
        r6 = gallopRight(r7[r12], r8, r13, r14, 0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r6 == 0) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        java.lang.System.arraycopy(r8, r13, r7, r15, r6);
        r1 = r15 + r6;
        r3 = r13 + r6;
        r2 = r14 - r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0093, code lost:
        if (r2 > r10) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        r14 = r2;
        r13 = r3;
        r4 = r12;
        r12 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        r15 = r1;
        r14 = r2;
        r13 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009e, code lost:
        r5 = r15 + 1;
        r4 = r12 + 1;
        r7[r15] = r7[r12];
        r12 = r16 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a8, code lost:
        if (r12 != 0) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00aa, code lost:
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00af, code lost:
        r9 = r4;
        r10 = r5;
        r15 = r6;
        r1 = gallopLeft(r8[r13], r7, r4, r12, 0, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00be, code lost:
        if (r1 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c0, code lost:
        java.lang.System.arraycopy(r7, r9, r7, r10, r1);
        r2 = r10 + r1;
        r4 = r9 + r1;
        r3 = r12 - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c9, code lost:
        if (r3 != 0) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cb, code lost:
        r1 = r2;
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ce, code lost:
        r12 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d0, code lost:
        r4 = r9;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00d2, code lost:
        r3 = r2 + 1;
        r5 = r13 + 1;
        r7[r2] = r8[r13];
        r14 = r14 - 1;
        r9 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00dd, code lost:
        if (r14 != 1) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00df, code lost:
        r1 = r3;
        r13 = r5;
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0101, code lost:
        r17 = r17 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0104, code lost:
        if (r15 < 7) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0106, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0108, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0109, code lost:
        if (r1 < 7) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x010b, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x010d, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x010f, code lost:
        if ((r1 | r6) != false) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0111, code lost:
        if (r17 >= 0) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0113, code lost:
        r17 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0122, code lost:
        r15 = r3;
        r13 = r5;
        r16 = r12;
        r10 = 1;
        r12 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeLo(int r20, int r21, int r22, int r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            T[] r7 = r0.f4668a
            java.lang.Object[] r8 = r0.ensureCapacity(r2)
            r9 = 0
            java.lang.System.arraycopy(r7, r1, r8, r9, r2)
            int r3 = r1 + 1
            int r4 = r22 + 1
            r5 = r7[r22]
            r7[r1] = r5
            int r1 = r23 + -1
            if (r1 != 0) goto L_0x0020
            java.lang.System.arraycopy(r8, r9, r7, r3, r2)
            return
        L_0x0020:
            r10 = 1
            if (r2 != r10) goto L_0x002c
            java.lang.System.arraycopy(r7, r4, r7, r3, r1)
            int r3 = r3 + r1
            r1 = r8[r9]
            r7[r3] = r1
            return
        L_0x002c:
            java.util.Comparator<? super T> r11 = r0.f4669c
            int r5 = r0.minGallop
            r6 = r5
            r5 = r3
            r3 = 0
        L_0x0033:
            r13 = r1
            r1 = 0
            r12 = 0
        L_0x0036:
            r14 = r7[r4]
            r15 = r8[r3]
            int r14 = r11.compare(r14, r15)
            if (r14 >= 0) goto L_0x0059
            int r1 = r5 + 1
            int r14 = r4 + 1
            r4 = r7[r4]
            r7[r5] = r4
            int r12 = r12 + r10
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x0055
            r10 = r6
            r12 = r13
            r4 = r14
            r9 = 1
            r14 = r2
            r13 = r3
            goto L_0x00e3
        L_0x0055:
            r5 = r1
            r4 = r14
            r1 = 0
            goto L_0x0071
        L_0x0059:
            int r12 = r5 + 1
            int r14 = r3 + 1
            r3 = r8[r3]
            r7[r5] = r3
            int r1 = r1 + r10
            int r2 = r2 + -1
            if (r2 != r10) goto L_0x006e
            r10 = r6
            r1 = r12
            r12 = r13
            r13 = r14
            r9 = 1
            r14 = r2
            goto L_0x00e3
        L_0x006e:
            r5 = r12
            r3 = r14
            r12 = 0
        L_0x0071:
            r14 = r1 | r12
            if (r14 < r6) goto L_0x012b
            r14 = r2
            r12 = r4
            r15 = r5
            r17 = r6
            r16 = r13
            r13 = r3
        L_0x007d:
            r1 = r7[r12]
            r5 = 0
            r2 = r8
            r3 = r13
            r4 = r14
            r6 = r11
            int r6 = gallopRight(r1, r2, r3, r4, r5, r6)
            if (r6 == 0) goto L_0x009e
            java.lang.System.arraycopy(r8, r13, r7, r15, r6)
            int r1 = r15 + r6
            int r3 = r13 + r6
            int r2 = r14 - r6
            if (r2 > r10) goto L_0x009b
            r14 = r2
            r13 = r3
            r4 = r12
            r12 = r16
            goto L_0x00ab
        L_0x009b:
            r15 = r1
            r14 = r2
            r13 = r3
        L_0x009e:
            int r5 = r15 + 1
            int r4 = r12 + 1
            r1 = r7[r12]
            r7[r15] = r1
            int r12 = r16 + -1
            if (r12 != 0) goto L_0x00af
            r1 = r5
        L_0x00ab:
            r10 = r17
            r9 = 1
            goto L_0x00e3
        L_0x00af:
            r1 = r8[r13]
            r15 = 0
            r2 = r7
            r3 = r4
            r9 = r4
            r4 = r12
            r10 = r5
            r5 = r15
            r15 = r6
            r6 = r11
            int r1 = gallopLeft(r1, r2, r3, r4, r5, r6)
            if (r1 == 0) goto L_0x00d0
            java.lang.System.arraycopy(r7, r9, r7, r10, r1)
            int r2 = r10 + r1
            int r4 = r9 + r1
            int r3 = r12 - r1
            if (r3 != 0) goto L_0x00ce
            r1 = r2
            r12 = r3
            goto L_0x00ab
        L_0x00ce:
            r12 = r3
            goto L_0x00d2
        L_0x00d0:
            r4 = r9
            r2 = r10
        L_0x00d2:
            int r3 = r2 + 1
            int r5 = r13 + 1
            r6 = r8[r13]
            r7[r2] = r6
            int r14 = r14 + -1
            r9 = 1
            if (r14 != r9) goto L_0x0101
            r1 = r3
            r13 = r5
            r10 = r17
        L_0x00e3:
            if (r10 >= r9) goto L_0x00e6
            r10 = 1
        L_0x00e6:
            r0.minGallop = r10
            if (r14 != r9) goto L_0x00f3
            java.lang.System.arraycopy(r7, r4, r7, r1, r12)
            int r1 = r1 + r12
            r2 = r8[r13]
            r7[r1] = r2
            goto L_0x00f8
        L_0x00f3:
            if (r14 == 0) goto L_0x00f9
            java.lang.System.arraycopy(r8, r13, r7, r1, r14)
        L_0x00f8:
            return
        L_0x00f9:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Comparison method violates its general contract!"
            r1.<init>(r2)
            throw r1
        L_0x0101:
            int r17 = r17 + -1
            r2 = 7
            if (r15 < r2) goto L_0x0108
            r6 = 1
            goto L_0x0109
        L_0x0108:
            r6 = 0
        L_0x0109:
            if (r1 < r2) goto L_0x010d
            r1 = 1
            goto L_0x010e
        L_0x010d:
            r1 = 0
        L_0x010e:
            r1 = r1 | r6
            if (r1 != 0) goto L_0x0122
            if (r17 >= 0) goto L_0x0115
            r17 = 0
        L_0x0115:
            int r6 = r17 + 2
            r1 = r12
            r2 = r14
            r9 = 0
            r10 = 1
            r18 = r5
            r5 = r3
            r3 = r18
            goto L_0x0033
        L_0x0122:
            r15 = r3
            r13 = r5
            r16 = r12
            r9 = 0
            r10 = 1
            r12 = r4
            goto L_0x007d
        L_0x012b:
            r9 = 0
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dTimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0077, code lost:
        r16 = r2;
        r17 = r3;
        r12 = r4;
        r14 = r5;
        r15 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007e, code lost:
        r6 = r13 - gallopRight(r8[r12], r7, r21, r13, r13 - 1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008d, code lost:
        if (r6 == 0) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008f, code lost:
        r1 = r14 - r6;
        r2 = r15 - r6;
        r13 = r13 - r6;
        java.lang.System.arraycopy(r7, r2 + 1, r7, r1 + 1, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009b, code lost:
        if (r13 != 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009d, code lost:
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a4, code lost:
        r14 = r1;
        r15 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a6, code lost:
        r18 = r14 - 1;
        r19 = r12 - 1;
        r7[r14] = r8[r12];
        r12 = r16 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00b0, code lost:
        if (r12 != 1) goto L_0x00ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b2, code lost:
        r2 = r12;
        r3 = r17;
        r1 = r18;
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        r14 = r6;
        r1 = r12 - gallopLeft(r7[r15], r8, 0, r12, r12 - 1, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c9, code lost:
        if (r1 == 0) goto L_0x00e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cb, code lost:
        r2 = r18 - r1;
        r4 = r19 - r1;
        r3 = r12 - r1;
        java.lang.System.arraycopy(r8, r4 + 1, r7, r2 + 1, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d8, code lost:
        if (r3 > 1) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00da, code lost:
        r1 = r2;
        r2 = r3;
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00de, code lost:
        r18 = r2;
        r16 = r3;
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e4, code lost:
        r16 = r12;
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e8, code lost:
        r2 = r18 - 1;
        r3 = r15 - 1;
        r7[r18] = r7[r15];
        r13 = r13 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f2, code lost:
        if (r13 != 0) goto L_0x011c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        r1 = r2;
        r15 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x011c, code lost:
        r17 = r17 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x011f, code lost:
        if (r14 < 7) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0121, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0123, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0124, code lost:
        if (r1 < 7) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0126, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0128, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x012a, code lost:
        if ((r1 | r5) != false) goto L_0x013b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x012c, code lost:
        if (r17 >= 0) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012e, code lost:
        r17 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013b, code lost:
        r14 = r2;
        r15 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void mergeHi(int r21, int r22, int r23, int r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r23
            r2 = r24
            T[] r7 = r0.f4668a
            java.lang.Object[] r8 = r0.ensureCapacity(r2)
            r9 = 0
            java.lang.System.arraycopy(r7, r1, r8, r9, r2)
            int r3 = r21 + r22
            r10 = 1
            int r3 = r3 - r10
            int r4 = r2 + -1
            int r1 = r1 + r2
            int r1 = r1 - r10
            int r5 = r1 + -1
            int r6 = r3 + -1
            r3 = r7[r3]
            r7[r1] = r3
            int r1 = r22 + -1
            if (r1 != 0) goto L_0x0029
            int r5 = r5 - r4
            java.lang.System.arraycopy(r8, r9, r7, r5, r2)
            return
        L_0x0029:
            if (r2 != r10) goto L_0x0038
            int r5 = r5 - r1
            int r6 = r6 - r1
            int r6 = r6 + r10
            int r2 = r5 + 1
            java.lang.System.arraycopy(r7, r6, r7, r2, r1)
            r1 = r8[r4]
            r7[r5] = r1
            return
        L_0x0038:
            java.util.Comparator<? super T> r11 = r0.f4669c
            int r3 = r0.minGallop
        L_0x003c:
            r13 = r1
            r1 = 0
            r12 = 0
        L_0x003f:
            r14 = r8[r4]
            r15 = r7[r6]
            int r14 = r11.compare(r14, r15)
            if (r14 >= 0) goto L_0x005e
            int r1 = r5 + -1
            int r14 = r6 + -1
            r6 = r7[r6]
            r7[r5] = r6
            int r12 = r12 + r10
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x005a
            r12 = r4
            r15 = r14
            goto L_0x00f7
        L_0x005a:
            r5 = r1
            r6 = r14
            r1 = 0
            goto L_0x0073
        L_0x005e:
            int r12 = r5 + -1
            int r14 = r4 + -1
            r4 = r8[r4]
            r7[r5] = r4
            int r1 = r1 + r10
            int r2 = r2 + -1
            if (r2 != r10) goto L_0x0070
            r15 = r6
            r1 = r12
            r12 = r14
            goto L_0x00f7
        L_0x0070:
            r5 = r12
            r4 = r14
            r12 = 0
        L_0x0073:
            r14 = r12 | r1
            if (r14 < r3) goto L_0x003f
            r16 = r2
            r17 = r3
            r12 = r4
            r14 = r5
            r15 = r6
        L_0x007e:
            r1 = r8[r12]
            int r5 = r13 + -1
            r2 = r7
            r3 = r21
            r4 = r13
            r6 = r11
            int r1 = gallopRight(r1, r2, r3, r4, r5, r6)
            int r6 = r13 - r1
            if (r6 == 0) goto L_0x00a6
            int r1 = r14 - r6
            int r2 = r15 - r6
            int r13 = r13 - r6
            int r3 = r2 + 1
            int r4 = r1 + 1
            java.lang.System.arraycopy(r7, r3, r7, r4, r6)
            if (r13 != 0) goto L_0x00a4
            r15 = r2
        L_0x009e:
            r2 = r16
        L_0x00a0:
            r3 = r17
            goto L_0x00f7
        L_0x00a4:
            r14 = r1
            r15 = r2
        L_0x00a6:
            int r18 = r14 + -1
            int r19 = r12 + -1
            r1 = r8[r12]
            r7[r14] = r1
            int r12 = r16 + -1
            if (r12 != r10) goto L_0x00ba
            r2 = r12
            r3 = r17
            r1 = r18
            r12 = r19
            goto L_0x00f7
        L_0x00ba:
            r1 = r7[r15]
            r3 = 0
            int r5 = r12 + -1
            r2 = r8
            r4 = r12
            r14 = r6
            r6 = r11
            int r1 = gallopLeft(r1, r2, r3, r4, r5, r6)
            int r1 = r12 - r1
            if (r1 == 0) goto L_0x00e4
            int r2 = r18 - r1
            int r4 = r19 - r1
            int r3 = r12 - r1
            int r5 = r4 + 1
            int r6 = r2 + 1
            java.lang.System.arraycopy(r8, r5, r7, r6, r1)
            if (r3 > r10) goto L_0x00de
            r1 = r2
            r2 = r3
            r12 = r4
            goto L_0x00a0
        L_0x00de:
            r18 = r2
            r16 = r3
            r12 = r4
            goto L_0x00e8
        L_0x00e4:
            r16 = r12
            r12 = r19
        L_0x00e8:
            int r2 = r18 + -1
            int r3 = r15 + -1
            r4 = r7[r15]
            r7[r18] = r4
            int r13 = r13 + -1
            if (r13 != 0) goto L_0x011c
            r1 = r2
            r15 = r3
            goto L_0x009e
        L_0x00f7:
            if (r3 >= r10) goto L_0x00fa
            r3 = 1
        L_0x00fa:
            r0.minGallop = r3
            if (r2 != r10) goto L_0x010b
            int r1 = r1 - r13
            int r15 = r15 - r13
            int r15 = r15 + r10
            int r2 = r1 + 1
            java.lang.System.arraycopy(r7, r15, r7, r2, r13)
            r2 = r8[r12]
            r7[r1] = r2
            goto L_0x0113
        L_0x010b:
            if (r2 == 0) goto L_0x0114
            int r3 = r2 + -1
            int r1 = r1 - r3
            java.lang.System.arraycopy(r8, r9, r7, r1, r2)
        L_0x0113:
            return
        L_0x0114:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Comparison method violates its general contract!"
            r1.<init>(r2)
            throw r1
        L_0x011c:
            int r17 = r17 + -1
            r4 = 7
            if (r14 < r4) goto L_0x0123
            r5 = 1
            goto L_0x0124
        L_0x0123:
            r5 = 0
        L_0x0124:
            if (r1 < r4) goto L_0x0128
            r1 = 1
            goto L_0x0129
        L_0x0128:
            r1 = 0
        L_0x0129:
            r1 = r1 | r5
            if (r1 != 0) goto L_0x013b
            if (r17 >= 0) goto L_0x0130
            r17 = 0
        L_0x0130:
            int r1 = r17 + 2
            r5 = r2
            r6 = r3
            r4 = r12
            r2 = r16
            r3 = r1
            r1 = r13
            goto L_0x003c
        L_0x013b:
            r14 = r2
            r15 = r3
            goto L_0x007e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.badlogic.gdx.physics.box2d.utils.Box2dTimSort.mergeHi(int, int, int, int):void");
    }

    private T[] ensureCapacity(int i) {
        this.tmpCount = Math.max(this.tmpCount, i);
        if (this.tmp.length < i) {
            int i2 = (i >> 1) | i;
            int i3 = i2 | (i2 >> 2);
            int i4 = i3 | (i3 >> 4);
            int i5 = i4 | (i4 >> 8);
            int i6 = (i5 | (i5 >> 16)) + 1;
            if (i6 >= 0) {
                i = Math.min(i6, this.f4668a.length >>> 1);
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

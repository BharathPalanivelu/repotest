package com.facebook.yoga;

public class YogaMeasureOutput {
    public static long make(float f2, float f3) {
        int floatToRawIntBits = Float.floatToRawIntBits(f2);
        return ((long) Float.floatToRawIntBits(f3)) | (((long) floatToRawIntBits) << 32);
    }

    public static long make(int i, int i2) {
        return make((float) i, (float) i2);
    }

    public static float getWidth(long j) {
        return Float.intBitsToFloat((int) ((j >> 32) & -1));
    }

    public static float getHeight(long j) {
        return Float.intBitsToFloat((int) (j & -1));
    }
}

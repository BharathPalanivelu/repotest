package com.badlogic.gdx.physics.box2d.utils;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.tencent.imsdk.TIMGroupManager;
import java.util.Random;

public class Box2dMathUtils {
    private static final double BIG_ENOUGH_CEIL = 16384.999999999996d;
    private static final double BIG_ENOUGH_FLOOR = 16384.0d;
    private static final int BIG_ENOUGH_INT = 16384;
    private static final double BIG_ENOUGH_ROUND = 16384.5d;
    private static final double CEIL = 0.9999999d;
    public static final float E = 2.7182817f;
    public static final float FLOAT_ROUNDING_ERROR = 1.0E-6f;
    public static final float PI = 3.1415927f;
    public static final float PI2 = 6.2831855f;
    private static final int SIN_BITS = 14;
    private static final int SIN_COUNT = 16384;
    private static final int SIN_MASK = 16383;
    private static final float degFull = 360.0f;
    public static final float degRad = 0.017453292f;
    private static final float degToIndex = 45.511112f;
    public static final float degreesToRadians = 0.017453292f;
    public static final float nanoToSec = 1.0E-9f;
    public static final float radDeg = 57.295776f;
    private static final float radFull = 6.2831855f;
    private static final float radToIndex = 2607.5945f;
    public static final float radiansToDegrees = 57.295776f;
    public static Random random = new Random();

    public static double clamp(double d2, double d3, double d4) {
        return d2 < d3 ? d3 : d2 > d4 ? d4 : d2;
    }

    public static float clamp(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int clamp(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public static long clamp(long j, long j2, long j3) {
        return j < j2 ? j2 : j > j3 ? j3 : j;
    }

    public static short clamp(short s, short s2, short s3) {
        return s < s2 ? s2 : s > s3 ? s3 : s;
    }

    public static int floorPositive(float f2) {
        return (int) f2;
    }

    public static boolean isPowerOfTwo(int i) {
        return i != 0 && (i & (i + -1)) == 0;
    }

    public static float lerp(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public static float lerpAngle(float f2, float f3, float f4) {
        return ((f2 + ((((((f3 - f2) + 6.2831855f) + 3.1415927f) % 6.2831855f) - 3.1415927f) * f4)) + 6.2831855f) % 6.2831855f;
    }

    public static float lerpAngleDeg(float f2, float f3, float f4) {
        return ((f2 + ((((((f3 - f2) + degFull) + 180.0f) % degFull) - 180.0f) * f4)) + degFull) % degFull;
    }

    public static float map(float f2, float f3, float f4, float f5, float f6) {
        return f4 + (((f6 - f2) * (f5 - f4)) / (f3 - f2));
    }

    public static int nextPowerOfTwo(int i) {
        if (i == 0) {
            return 1;
        }
        int i2 = i - 1;
        int i3 = i2 | (i2 >> 1);
        int i4 = i3 | (i3 >> 2);
        int i5 = i4 | (i4 >> 4);
        int i6 = i5 | (i5 >> 8);
        return (i6 | (i6 >> 16)) + 1;
    }

    public static float norm(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public static int roundPositive(float f2) {
        return (int) (f2 + 0.5f);
    }

    private static class Sin {
        static final float[] table = new float[TIMGroupManager.TIM_GET_GROUP_BASE_INFO_FLAG_GROUP_TYPE];

        private Sin() {
        }

        static {
            for (int i = 0; i < 16384; i++) {
                table[i] = (float) Math.sin((double) (((((float) i) + 0.5f) / 16384.0f) * 6.2831855f));
            }
            for (int i2 = 0; i2 < 360; i2 += 90) {
                float f2 = (float) i2;
                table[((int) (Box2dMathUtils.degToIndex * f2)) & Box2dMathUtils.SIN_MASK] = (float) Math.sin((double) (f2 * 0.017453292f));
            }
        }
    }

    public static float sin(float f2) {
        return Sin.table[((int) (f2 * radToIndex)) & SIN_MASK];
    }

    public static float cos(float f2) {
        return Sin.table[((int) ((f2 + 1.5707964f) * radToIndex)) & SIN_MASK];
    }

    public static float sinDeg(float f2) {
        return Sin.table[((int) (f2 * degToIndex)) & SIN_MASK];
    }

    public static float cosDeg(float f2) {
        return Sin.table[((int) ((f2 + 90.0f) * degToIndex)) & SIN_MASK];
    }

    public static float atan2(float f2, float f3) {
        if (f3 != BitmapDescriptorFactory.HUE_RED) {
            float f4 = f2 / f3;
            float f5 = 3.1415927f;
            if (Math.abs(f4) < 1.0f) {
                float f6 = f4 / (((0.28f * f4) * f4) + 1.0f);
                if (f3 >= BitmapDescriptorFactory.HUE_RED) {
                    return f6;
                }
                if (f2 < BitmapDescriptorFactory.HUE_RED) {
                    f5 = -3.1415927f;
                }
                return f6 + f5;
            }
            float f7 = 1.5707964f - (f4 / ((f4 * f4) + 0.28f));
            return f2 < BitmapDescriptorFactory.HUE_RED ? f7 - 3.1415927f : f7;
        } else if (f2 > BitmapDescriptorFactory.HUE_RED) {
            return 1.5707964f;
        } else {
            if (f2 == BitmapDescriptorFactory.HUE_RED) {
                return BitmapDescriptorFactory.HUE_RED;
            }
            return -1.5707964f;
        }
    }

    public static int random(int i) {
        return random.nextInt(i + 1);
    }

    public static int random(int i, int i2) {
        return i + random.nextInt((i2 - i) + 1);
    }

    public static long random(long j) {
        double nextDouble = random.nextDouble();
        double d2 = (double) j;
        Double.isNaN(d2);
        return (long) (nextDouble * d2);
    }

    public static long random(long j, long j2) {
        double nextDouble = random.nextDouble();
        double d2 = (double) (j2 - j);
        Double.isNaN(d2);
        return j + ((long) (nextDouble * d2));
    }

    public static boolean randomBoolean() {
        return random.nextBoolean();
    }

    public static boolean randomBoolean(float f2) {
        return random() < f2;
    }

    public static float random() {
        return random.nextFloat();
    }

    public static float random(float f2) {
        return random.nextFloat() * f2;
    }

    public static float random(float f2, float f3) {
        return f2 + (random.nextFloat() * (f3 - f2));
    }

    public static int randomSign() {
        return (random.nextInt() >> 31) | 1;
    }

    public static float randomTriangular() {
        return random.nextFloat() - random.nextFloat();
    }

    public static float randomTriangular(float f2) {
        return (random.nextFloat() - random.nextFloat()) * f2;
    }

    public static float randomTriangular(float f2, float f3) {
        return randomTriangular(f2, f3, (f2 + f3) * 0.5f);
    }

    public static float randomTriangular(float f2, float f3, float f4) {
        float nextFloat = random.nextFloat();
        float f5 = f3 - f2;
        float f6 = f4 - f2;
        if (nextFloat <= f6 / f5) {
            return f2 + ((float) Math.sqrt((double) (nextFloat * f5 * f6)));
        }
        return f3 - ((float) Math.sqrt((double) (((1.0f - nextFloat) * f5) * (f3 - f4))));
    }

    public static int floor(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return ((int) (d2 + BIG_ENOUGH_FLOOR)) - 16384;
    }

    public static int ceil(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return 16384 - ((int) (BIG_ENOUGH_FLOOR - d2));
    }

    public static int ceilPositive(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return (int) (d2 + CEIL);
    }

    public static int round(float f2) {
        double d2 = (double) f2;
        Double.isNaN(d2);
        return ((int) (d2 + BIG_ENOUGH_ROUND)) - 16384;
    }

    public static boolean isZero(float f2) {
        return Math.abs(f2) <= 1.0E-6f;
    }

    public static boolean isZero(float f2, float f3) {
        return Math.abs(f2) <= f3;
    }

    public static boolean isEqual(float f2, float f3) {
        return Math.abs(f2 - f3) <= 1.0E-6f;
    }

    public static boolean isEqual(float f2, float f3, float f4) {
        return Math.abs(f2 - f3) <= f4;
    }

    public static float log(float f2, float f3) {
        return (float) (Math.log((double) f3) / Math.log((double) f2));
    }

    public static float log2(float f2) {
        return log(2.0f, f2);
    }
}

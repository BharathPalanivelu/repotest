package cn.tongdun.android.core.oo0ooo0o00o0xo;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class o0o0xxox implements SensorEventListener {
    private static long o00o0o0oo0oo0o000x00;
    private static final List o00xx0xx0ooooo0xx00 = new CopyOnWriteArrayList();
    public static String o00xxox0x0xoox = null;
    private static long o0oo0xx00ooo0oox0xx0;
    private static final List oo0ooo0o00o0xo = new CopyOnWriteArrayList();
    private static long ooxo0o0xxxooxo00;
    private static long ooxoxoooxooo0xx00;
    private static final List x0000xo0x0oooooo0 = new CopyOnWriteArrayList();
    private static final List x0ox00x0oooo0xxx = new CopyOnWriteArrayList();
    private static final List xo00x00xo00 = new CopyOnWriteArrayList();
    private static long xoo0xoo0oxo00x0o0;

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 4) {
                    if (type != 5) {
                        if (type == 9 && System.currentTimeMillis() - ooxoxoooxooo0xx00 > 80) {
                            double d2 = (double) sensorEvent.values[0];
                            double d3 = (double) sensorEvent.values[1];
                            double d4 = (double) sensorEvent.values[2];
                            if (oo0ooo0o00o0xo.size() < 5) {
                                oo0ooo0o00o0xo.add(String.format(o00xxox0x0xoox("3f61237b7131783a62682861237b7134", 87), new Object[]{Double.valueOf(d2), Double.valueOf(d3), Double.valueOf(d4)}));
                            }
                            ooxoxoooxooo0xx00 = System.currentTimeMillis();
                        }
                    } else if (System.currentTimeMillis() - ooxo0o0xxxooxo00 > 80) {
                        int i = (int) sensorEvent.values[0];
                        if (xo00x00xo00.size() < 5) {
                            xo00x00xo00.add(String.valueOf(i));
                        }
                        ooxo0o0xxxooxo00 = System.currentTimeMillis();
                    }
                } else if (System.currentTimeMillis() - o0oo0xx00ooo0oox0xx0 > 80) {
                    double d5 = (double) sensorEvent.values[0];
                    double d6 = (double) sensorEvent.values[1];
                    double d7 = (double) sensorEvent.values[2];
                    if (x0ox00x0oooo0xxx.size() < 5) {
                        x0ox00x0oooo0xxx.add(String.format(o00xxox0x0xoox("3f09231371597852620028092313715c", 63), new Object[]{Double.valueOf(d5), Double.valueOf(d6), Double.valueOf(d7)}));
                    }
                    o0oo0xx00ooo0oox0xx0 = System.currentTimeMillis();
                }
            } else if (System.currentTimeMillis() - xoo0xoo0oxo00x0o0 > 80) {
                double d8 = (double) sensorEvent.values[0];
                double d9 = (double) sensorEvent.values[1];
                double d10 = (double) sensorEvent.values[2];
                if (x0000xo0x0oooooo0.size() < 5) {
                    x0000xo0x0oooooo0.add(String.format(o00xxox0x0xoox("3f79236371297822627028792363712c", 79), new Object[]{Double.valueOf(d8), Double.valueOf(d9), Double.valueOf(d10)}));
                }
                xoo0xoo0oxo00x0o0 = System.currentTimeMillis();
            }
        } else if (System.currentTimeMillis() - o00o0o0oo0oo0o000x00 > 80) {
            double d11 = (double) sensorEvent.values[0];
            double d12 = (double) sensorEvent.values[1];
            double d13 = (double) sensorEvent.values[2];
            if (o00xx0xx0ooooo0xx00.size() < 5) {
                o00xx0xx0ooooo0xx00.add(String.format(o00xxox0x0xoox("3f7e2364712e78256277287e2364712b", 72), new Object[]{Double.valueOf(d11), Double.valueOf(d12), Double.valueOf(d13)}));
            }
            o00o0o0oo0oo0o000x00 = System.currentTimeMillis();
        }
    }

    public static synchronized String o00xxox0x0xoox() {
        String obj;
        synchronized (o0o0xxox.class) {
            obj = o00xx0xx0ooooo0xx00.toString();
        }
        return obj;
    }

    public static synchronized String oo0ooo0o00o0xo() {
        String obj;
        synchronized (o0o0xxox.class) {
            obj = oo0ooo0o00o0xo.toString();
        }
        return obj;
    }

    public static synchronized String o00xx0xx0ooooo0xx00() {
        String obj;
        synchronized (o0o0xxox.class) {
            obj = x0000xo0x0oooooo0.toString();
        }
        return obj;
    }

    public static synchronized String x0000xo0x0oooooo0() {
        String obj;
        synchronized (o0o0xxox.class) {
            obj = x0ox00x0oooo0xxx.toString();
        }
        return obj;
    }

    public static synchronized String x0ox00x0oooo0xxx() {
        String obj;
        synchronized (o0o0xxox.class) {
            obj = xo00x00xo00.toString();
        }
        return obj;
    }

    public static void xo00x00xo00() {
        o00xx0xx0ooooo0xx00.clear();
        oo0ooo0o00o0xo.clear();
        x0000xo0x0oooooo0.clear();
        x0ox00x0oooo0xxx.clear();
        xo00x00xo00.clear();
    }

    public static String o00xxox0x0xoox(String str, int i) {
        try {
            int length = str.length() / 2;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ("0123456789abcdef".indexOf(charArray[i3 + 1]) | ("0123456789abcdef".indexOf(charArray[i3]) << 4));
            }
            byte b2 = (byte) (i ^ 59);
            int length2 = bArr.length;
            bArr[0] = (byte) (bArr[0] ^ 23);
            byte b3 = bArr[0];
            int i4 = 1;
            while (i4 < length2) {
                byte b4 = bArr[i4];
                bArr[i4] = (byte) ((b3 ^ bArr[i4]) ^ b2);
                i4++;
                b3 = b4;
            }
            return new String(bArr, "utf-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

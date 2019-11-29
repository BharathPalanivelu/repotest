package com.garena.android.appkit.tools;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.WindowManager;
import com.garena.android.appkit.d.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Resources f6697a;

    private static void e() {
        if (f6697a == null) {
            f6697a = a.f6696a.getResources();
        }
    }

    public static void a() {
        if (a.f6696a != null) {
            f6697a = a.f6696a.getResources();
        }
    }

    public static int a(int i) {
        e();
        return f6697a.getColor(i);
    }

    public static boolean b(int i) {
        e();
        return f6697a.getBoolean(i);
    }

    public static float c(int i) {
        e();
        return f6697a.getDimension(i);
    }

    public static int d(int i) {
        e();
        return f6697a.getDimensionPixelOffset(i);
    }

    public static String e(int i) {
        e();
        return f6697a.getString(i);
    }

    public static String a(int i, Object... objArr) {
        e();
        return f6697a.getString(i, objArr);
    }

    public static Drawable f(int i) {
        e();
        return f6697a.getDrawable(i);
    }

    public static int g(int i) {
        e();
        return f6697a.getInteger(i);
    }

    public static int b() {
        WindowManager windowManager = (WindowManager) a.f6696a.getSystemService("window");
        if (Build.VERSION.SDK_INT < 13) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.x;
    }

    public static boolean c() {
        return b() < 600;
    }

    public static int d() {
        WindowManager windowManager = (WindowManager) a.f6696a.getSystemService("window");
        if (Build.VERSION.SDK_INT < 13) {
            return windowManager.getDefaultDisplay().getHeight();
        }
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return point.y;
    }

    public static Bitmap h(int i) {
        e();
        return BitmapFactory.decodeResource(f6697a, i);
    }

    public static String i(int i) {
        InputStream openRawResource;
        try {
            openRawResource = a.f6696a.getResources().openRawResource(i);
            StringWriter stringWriter = new StringWriter();
            char[] cArr = new char[1024];
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource, "UTF-8"));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read == -1) {
                    break;
                }
                stringWriter.write(cArr, 0, read);
            }
            if (openRawResource != null) {
                openRawResource.close();
            }
            return stringWriter.toString();
        } catch (IOException e2) {
            a.a(e2);
            return "";
        } catch (Throwable th) {
            if (openRawResource != null) {
                openRawResource.close();
            }
            throw th;
        }
    }
}

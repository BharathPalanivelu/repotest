package com.shopee.live.livestreaming.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.garena.android.appkit.tools.b;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static Toast f29505a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f29506b;

    /* renamed from: c  reason: collision with root package name */
    private static Handler f29507c = new a();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static Context f29508d;

    public static void a(Context context, String str) {
        if (context != null) {
            f29508d = context.getApplicationContext();
            c();
            Handler handler = f29507c;
            handler.sendMessageDelayed(Message.obtain(handler, 1, str), 50);
        }
    }

    /* access modifiers changed from: private */
    public static void e(Context context, String str) {
        if (context != null) {
            Toast toast = f29505a;
            if (toast == null) {
                f29505a = Toast.makeText(context.getApplicationContext(), str, 0);
            } else {
                toast.setDuration(0);
                f29505a.setText(str);
            }
            f29505a.show();
        }
    }

    public static void a(Context context, int i) {
        if (context != null) {
            f29508d = context.getApplicationContext();
            c();
            Handler handler = f29507c;
            handler.sendMessageDelayed(Message.obtain(handler, 2, i, i), 50);
        }
    }

    /* access modifiers changed from: private */
    public static void e(Context context, int i) {
        if (context != null) {
            Toast toast = f29505a;
            if (toast == null) {
                f29505a = Toast.makeText(context.getApplicationContext(), b.e(i), 0);
            } else {
                toast.setDuration(0);
                f29505a.setText(i);
            }
            f29505a.show();
        }
    }

    public static void b(Context context, String str) {
        if (context != null) {
            f29508d = context.getApplicationContext();
            c();
            Handler handler = f29507c;
            handler.sendMessageDelayed(Message.obtain(handler, 3, str), 50);
        }
    }

    /* access modifiers changed from: private */
    public static void f(Context context, String str) {
        if (context != null) {
            Toast toast = f29505a;
            if (toast == null) {
                f29505a = Toast.makeText(context.getApplicationContext(), str, 1);
            } else {
                toast.setDuration(1);
                f29505a.setText(str);
            }
            f29505a.show();
        }
    }

    public static void b(Context context, int i) {
        if (context != null) {
            f29508d = context.getApplicationContext();
            c();
            Handler handler = f29507c;
            handler.sendMessageDelayed(Message.obtain(handler, 4, i, i), 50);
        }
    }

    /* access modifiers changed from: private */
    public static void f(Context context, int i) {
        if (context != null) {
            Toast toast = f29505a;
            if (toast == null) {
                f29505a = Toast.makeText(context.getApplicationContext(), b.e(i), 1);
            } else {
                toast.setDuration(1);
                f29505a.setText(i);
            }
            f29505a.show();
        }
    }

    public static void a() {
        f29506b = true;
    }

    /* access modifiers changed from: private */
    public static void b(Context context, String str, boolean z) {
        if (context != null && f29506b) {
            Toast toast = f29505a;
            if (toast == null) {
                f29505a = Toast.makeText(context.getApplicationContext(), str, z);
            } else {
                toast.setDuration(z ? 1 : 0);
                f29505a.setText(str);
            }
            f29505a.show();
            f29506b = false;
        }
    }

    private static class a extends Handler {
        public a() {
            super(Looper.getMainLooper());
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                z.e(z.f29508d, (String) message.obj);
            } else if (i == 2) {
                z.e(z.f29508d, message.arg1);
            } else if (i == 3) {
                z.f(z.f29508d, (String) message.obj);
            } else if (i == 4) {
                z.f(z.f29508d, message.arg1);
            } else if (i == 5) {
                Context b2 = z.f29508d;
                String str = (String) message.obj;
                if (message.arg1 <= 0) {
                    z = false;
                }
                z.b(b2, str, z);
            }
        }
    }

    private static void c() {
        f29507c.removeMessages(1);
        f29507c.removeMessages(2);
        f29507c.removeMessages(3);
        f29507c.removeMessages(4);
        f29507c.removeMessages(5);
    }
}

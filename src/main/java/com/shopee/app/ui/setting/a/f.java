package com.shopee.app.ui.setting.a;

import android.app.ActivityManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Debug;
import android.os.IBinder;
import android.os.Process;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.facebook.react.bridge.UiThreadUtil;
import com.shopee.id.R;
import com.tencent.ijk.media.player.IjkMediaMeta;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class f extends Service {

    /* renamed from: a  reason: collision with root package name */
    private View f25121a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public TextView f25122b;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager f25123c;

    /* renamed from: d  reason: collision with root package name */
    private ActivityManager f25124d;

    /* renamed from: e  reason: collision with root package name */
    private Timer f25125e;

    /* renamed from: f  reason: collision with root package name */
    private TimerTask f25126f;

    /* renamed from: g  reason: collision with root package name */
    private int f25127g = 0;

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        this.f25123c = (WindowManager) getSystemService("window");
        this.f25124d = (ActivityManager) getSystemService("activity");
        this.f25127g = a();
        View view = this.f25121a;
        if (view != null) {
            this.f25123c.removeView(view);
        }
        this.f25121a = LayoutInflater.from(this).inflate(R.layout.layout_memory_usage, (ViewGroup) null);
        this.f25123c.addView(this.f25121a, new WindowManager.LayoutParams(-1, -1, 2005, 24, -3));
        this.f25122b = (TextView) this.f25121a.findViewById(R.id.text_info);
        this.f25125e = new Timer();
        this.f25126f = new TimerTask() {
            public void run() {
                f.this.b();
            }
        };
        this.f25125e.schedule(this.f25126f, 1000, 1000);
        return 2;
    }

    /* access modifiers changed from: private */
    public void b() {
        int i;
        int i2;
        Debug.MemoryInfo c2 = c();
        if (c2 != null) {
            int freeMemory = (int) (Runtime.getRuntime().freeMemory() / IjkMediaMeta.AV_CH_SIDE_RIGHT);
            final SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (Build.VERSION.SDK_INT >= 23) {
                i = Integer.parseInt(c2.getMemoryStat("summary.java-heap"));
                i2 = Integer.parseInt(c2.getMemoryStat("summary.native-heap"));
            } else {
                i = c2.dalvikPrivateDirty;
                i2 = c2.nativePrivateDirty;
            }
            float f2 = ((float) i) / ((float) this.f25127g);
            spannableStringBuilder.append("Java: ");
            if (f2 > 0.8f) {
                SpannableString spannableString = new SpannableString(a(Integer.valueOf(i)));
                spannableString.setSpan(new ForegroundColorSpan(-65536), 0, spannableString.length(), 33);
                spannableStringBuilder.append(spannableString);
            } else if (f2 > 0.6f) {
                SpannableString spannableString2 = new SpannableString(a(Integer.valueOf(i)));
                spannableString2.setSpan(new ForegroundColorSpan(-256), 0, spannableString2.length(), 33);
                spannableStringBuilder.append(spannableString2);
            } else {
                spannableStringBuilder.append(a(Integer.valueOf(i)));
            }
            spannableStringBuilder.append("\nNative: ").append(a(Integer.valueOf(i2))).append("\nRuntime Free: ").append(a(Integer.valueOf(freeMemory)));
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    f.this.f25122b.setText(spannableStringBuilder);
                }
            });
        }
    }

    private String a(Integer num) {
        return String.format(Locale.ENGLISH, "%.1f MB", new Object[]{Float.valueOf((((float) num.intValue()) * 1.0f) / 1024.0f)});
    }

    public void onDestroy() {
        super.onDestroy();
        this.f25125e.cancel();
        this.f25125e.purge();
        View view = this.f25121a;
        if (view != null) {
            this.f25123c.removeView(view);
            this.f25121a = null;
        }
    }

    public int a() {
        if (this.f25127g == 0) {
            this.f25127g = this.f25124d.getMemoryClass() * 1024;
        }
        return this.f25127g;
    }

    private Debug.MemoryInfo c() {
        return this.f25124d.getProcessMemoryInfo(new int[]{Process.myPid()})[0];
    }
}

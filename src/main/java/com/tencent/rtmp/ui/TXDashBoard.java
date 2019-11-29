package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import cn.tongdun.android.shell.settings.Constants;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.rtmp.TXLiveConstants;
import java.text.SimpleDateFormat;

public class TXDashBoard extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    protected TextView f32478a;

    /* renamed from: b  reason: collision with root package name */
    protected TextView f32479b;

    /* renamed from: c  reason: collision with root package name */
    protected ScrollView f32480c;

    /* renamed from: d  reason: collision with root package name */
    protected StringBuffer f32481d;

    /* renamed from: e  reason: collision with root package name */
    protected int f32482e;

    /* renamed from: f  reason: collision with root package name */
    private final SimpleDateFormat f32483f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32484g;

    public TXDashBoard(Context context) {
        this(context, (AttributeSet) null);
    }

    public TXDashBoard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f32481d = new StringBuffer("");
        this.f32482e = Constants.DEFAULT_WAIT_TIME;
        this.f32483f = new SimpleDateFormat("HH:mm:ss.SSS");
        this.f32484g = false;
        setOrientation(1);
        this.f32478a = new TextView(context);
        this.f32479b = new TextView(context);
        this.f32480c = new ScrollView(context);
        this.f32478a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f32478a.setTextColor(-49023);
        this.f32478a.setTypeface(Typeface.MONOSPACE);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.f32480c.setPadding(0, 10, 0, 0);
        this.f32480c.setLayoutParams(layoutParams);
        this.f32480c.setVerticalScrollBarEnabled(true);
        this.f32480c.setScrollbarFadingEnabled(true);
        this.f32479b.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f32479b.setTextColor(-49023);
        this.f32480c.addView(this.f32479b);
        addView(this.f32478a);
        addView(this.f32480c);
        setVisibility(4);
    }

    public void setStatusTextSize(float f2) {
        this.f32478a.setTextSize(f2);
    }

    public void a(int i, int i2, int i3, int i4) {
        this.f32478a.setPadding(i, i2, i3, 0);
        this.f32480c.setPadding(i, 0, i3, i4);
    }

    public void setEventTextSize(float f2) {
        this.f32479b.setTextSize(f2);
    }

    public void a(CharSequence charSequence) {
        this.f32478a.setText(charSequence);
    }

    public void setLogMsgLenLimit(int i) {
        this.f32482e = i;
    }

    public void setShowLevel(int i) {
        if (i == 0) {
            this.f32478a.setVisibility(4);
            this.f32480c.setVisibility(4);
            setVisibility(4);
        } else if (i != 1) {
            this.f32478a.setVisibility(0);
            this.f32480c.setVisibility(0);
            setVisibility(0);
        } else {
            this.f32478a.setVisibility(0);
            this.f32480c.setVisibility(4);
            setVisibility(0);
        }
    }

    public void a(String str) {
        String str2 = "[" + this.f32483f.format(Long.valueOf(System.currentTimeMillis())) + "]" + str + "\n";
        while (this.f32481d.length() > this.f32482e) {
            int indexOf = this.f32481d.indexOf("\n");
            if (indexOf == 0) {
                indexOf = 1;
            }
            this.f32481d = this.f32481d.delete(0, indexOf);
        }
        StringBuffer stringBuffer = this.f32481d;
        stringBuffer.append(str2);
        this.f32481d = stringBuffer;
        this.f32479b.setText("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr() + "\n" + this.f32481d.toString());
    }

    public void a(boolean z) {
        this.f32484g = z;
    }

    public void a() {
        this.f32481d.setLength(0);
        this.f32478a.setText("");
        this.f32479b.setText("");
    }

    public void a(Bundle bundle, Bundle bundle2, int i) {
        if (!this.f32484g && i != 2011 && i != 2012) {
            if (bundle != null) {
                this.f32478a.setText(a(bundle));
            }
            if (this.f32481d.length() <= 0) {
                StringBuffer stringBuffer = this.f32481d;
                stringBuffer.append("liteav sdk version:" + TXCCommonUtil.getSDKVersionStr());
            }
            if (bundle2 != null) {
                String string = bundle2.getString(TXLiveConstants.EVT_DESCRIPTION);
                if (string != null && !string.isEmpty()) {
                    a(i, string);
                    this.f32479b.setText(this.f32481d.toString());
                    if (getVisibility() == 0) {
                        a(this.f32480c, (View) this.f32479b);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(int i, String str) {
        if (i != 1020) {
            String format = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
            while (this.f32481d.length() > this.f32482e) {
                int indexOf = this.f32481d.indexOf("\n");
                if (indexOf == 0) {
                    indexOf = 1;
                }
                this.f32481d = this.f32481d.delete(0, indexOf);
            }
            StringBuffer stringBuffer = this.f32481d;
            stringBuffer.append("\n[" + format + "]" + str);
            this.f32481d = stringBuffer;
        }
    }

    /* access modifiers changed from: protected */
    public String a(Bundle bundle) {
        return String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", new Object[]{"CPU:" + bundle.getString(TXLiveConstants.NET_STATUS_CPU_USAGE), "RES:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH) + "*" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT), "SPD:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_SPEED) + "Kbps", "JIT:" + bundle.getInt(TXLiveConstants.NET_STATUS_NET_JITTER), "FPS:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_FPS), "GOP:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_GOP) + "s", "ARA:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE) + "Kbps", "QUE:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_CACHE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_SUM_CACHE_SIZE) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE) + " | " + bundle.getInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL) + "," + bundle.getInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL) + "," + String.format("%.1f", new Object[]{Float.valueOf(bundle.getFloat(TXLiveConstants.NET_STATUS_AUDIO_CACHE_THRESHOLD))}).toString(), "VRA:" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE) + "Kbps", "DRP:" + bundle.getInt(TXLiveConstants.NET_STATUS_AUDIO_DROP) + "|" + bundle.getInt(TXLiveConstants.NET_STATUS_VIDEO_DROP), "SVR:" + bundle.getString(TXLiveConstants.NET_STATUS_SERVER_IP), "AUDIO:" + bundle.getString(TXLiveConstants.NET_STATUS_AUDIO_INFO)});
    }

    private void a(ScrollView scrollView, View view) {
        if (scrollView != null && view != null) {
            int measuredHeight = view.getMeasuredHeight() - scrollView.getMeasuredHeight();
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            scrollView.scrollTo(0, measuredHeight);
        }
    }
}

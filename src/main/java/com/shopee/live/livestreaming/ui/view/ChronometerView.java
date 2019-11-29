package com.shopee.live.livestreaming.ui.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.appevents.AppEventsConstants;

public class ChronometerView extends AppCompatTextView {

    /* renamed from: a  reason: collision with root package name */
    Handler f29109a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public long f29110b;

    public ChronometerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ChronometerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChronometerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f29110b = 0;
        c();
    }

    private void c() {
        this.f29109a = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 19) {
                    ChronometerView chronometerView = ChronometerView.this;
                    long unused = chronometerView.f29110b = chronometerView.f29110b + 1000;
                    ChronometerView.this.d();
                    ChronometerView.this.f29109a.sendEmptyMessageDelayed(19, 1000);
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void d() {
        long j = this.f29110b;
        if (j > 0 && j < 360000000) {
            StringBuilder sb = new StringBuilder();
            long j2 = this.f29110b;
            sb.append(a((int) (j2 / 3600000)));
            sb.append(":");
            sb.append(a((int) (((j2 / 1000) / 60) % 60)));
            sb.append(":");
            sb.append(a((int) ((j2 / 1000) % 60)));
            setText(sb.toString());
        } else if (this.f29110b >= 360000000) {
            this.f29110b = 359999999;
            setText("99:59:59");
        }
    }

    private String a(int i) {
        if (i <= 0 || i >= 10) {
            return i >= 10 ? String.valueOf(i) : "00";
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + i;
    }

    public void a(long j) {
        b();
        this.f29110b = j;
        this.f29109a.sendEmptyMessageDelayed(19, 1000);
    }

    public void a() {
        b();
        this.f29109a.sendEmptyMessageDelayed(19, 1000);
    }

    public void b() {
        this.f29109a.removeCallbacksAndMessages((Object) null);
    }

    public long getRecordTime() {
        return this.f29110b;
    }
}

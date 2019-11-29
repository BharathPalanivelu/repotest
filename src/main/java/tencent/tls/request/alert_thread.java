package tencent.tls.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Timer;
import java.util.TimerTask;
import tencent.tls.platform.TLSErrInfo;

public class alert_thread extends Thread {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public TLSErrInfo errInfo;
    Runnable myRunnable = new Runnable() {
        public void run() {
            if (alert_thread.this.context != null && alert_thread.this.errInfo != null) {
                LinearLayout linearLayout = new LinearLayout(alert_thread.this.context);
                linearLayout.setOrientation(1);
                linearLayout.setBackgroundColor(-7829368);
                linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                TextView textView = new TextView(alert_thread.this.context);
                textView.getPaint().setFakeBoldText(true);
                textView.setText(alert_thread.this.errInfo.Title);
                linearLayout.addView(textView, 0, new LinearLayout.LayoutParams(-1, -2));
                TextView textView2 = new TextView(alert_thread.this.context);
                textView2.setText(alert_thread.this.errInfo.Msg);
                linearLayout.addView(textView2, 1, new LinearLayout.LayoutParams(-1, -2));
                Toast toast = new Toast(alert_thread.this.context);
                toast.setGravity(17, 0, 0);
                toast.setDuration(1);
                toast.setView(linearLayout);
                initToast(toast, 0);
            }
        }

        /* access modifiers changed from: private */
        public void initToast(Toast toast, int i) {
            if (i <= 5) {
                toast.show();
                execToast(toast, i);
            }
        }

        private void execToast(final Toast toast, final int i) {
            new Timer().schedule(new TimerTask() {
                public void run() {
                    AnonymousClass1.this.initToast(toast, i + 1);
                }
            }, 30);
        }
    };

    public alert_thread(Context context2) {
        this.context = context2;
    }

    public alert_thread(Context context2, TLSErrInfo tLSErrInfo) {
        this.context = context2;
        setErrMsg(tLSErrInfo);
    }

    public void setErrMsg(TLSErrInfo tLSErrInfo) {
        this.errInfo = tLSErrInfo;
    }

    public TLSErrInfo getErrMsg() {
        return this.errInfo;
    }

    public void run() {
        new Handler(Looper.getMainLooper()).post(this.myRunnable);
    }
}

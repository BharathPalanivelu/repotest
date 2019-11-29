package tencent.tls.request;

import android.os.Handler;
import android.os.Looper;
import tencent.tls.report.QLog;

public class WorkThread extends Thread {
    private static Thread loopThread;
    /* access modifiers changed from: private */
    public static Looper selfLooper;
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public int ret;
    /* access modifiers changed from: private */
    public When when;
    private Worker worker;

    public interface When {
        void done(int i);
    }

    public interface Worker {
        int work();
    }

    public WorkThread(Looper looper, Worker worker2, When when2) {
        this.worker = worker2;
        this.when = when2;
        if (looper == null) {
            synchronized (WorkThread.class) {
                if (loopThread == null || !loopThread.isAlive()) {
                    loopThread = new Thread(new Runnable() {
                        public void run() {
                            if (Looper.myLooper() == null) {
                                Looper.prepare();
                            }
                            Looper unused = WorkThread.selfLooper = Looper.myLooper();
                            Handler unused2 = WorkThread.this.handler = new Handler();
                            Looper.loop();
                        }
                    });
                    Thread thread = loopThread;
                    thread.setName("TLSLoopThread-" + loopThread.getId());
                    loopThread.setDaemon(true);
                    loopThread.start();
                    return;
                }
                this.handler = new Handler(selfLooper);
                return;
            }
        }
        this.handler = new Handler(looper);
    }

    public void run() {
        try {
            QLog.i("run at " + Thread.currentThread().getName());
            this.ret = this.worker.work();
            this.handler.post(new Runnable() {
                public void run() {
                    QLog.i("receive at " + Thread.currentThread().getName());
                    try {
                        WorkThread.this.when.done(WorkThread.this.ret);
                    } catch (Exception e2) {
                        QLog.e(e2);
                    }
                }
            });
        } catch (Exception e2) {
            QLog.e(e2);
        }
    }
}

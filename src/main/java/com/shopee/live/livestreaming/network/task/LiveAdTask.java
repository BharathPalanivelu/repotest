package com.shopee.live.livestreaming.network.task;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.data.entity.LiveAdDataEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import tencent.tls.platform.TLSErrInfo;

public class LiveAdTask extends AbstractInteractor<Data, Callback> {
    private static final String LOOP_THREAD = "get_ad_loop_";
    private static final String TAG = "LiveAdTask: %s";
    private final LiveStreamingService mCallService;
    private LoopRequestHandler mHandler;
    private HandlerThread mLoopThread;

    public interface Callback {
        void getAdInfoSucceed(LiveAdDataEntity liveAdDataEntity);

        void onError(int i, String str);

        void onPrepare();
    }

    public LiveAdTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        notify(new Runnable() {
            public void run() {
                callback.onPrepare();
            }
        });
        a.a(TAG, "get ad request");
        try {
            final NetworkData<ServerResult<LiveAdDataEntity>> networkData = Network.get(this.mCallService.getAdInfo(data.roomId, data.sessionId));
            if (!networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        a.a(LiveAdTask.TAG, "get add: " + ((LiveAdDataEntity) networkData.data).toJson());
                        callback.getAdInfoSucceed((LiveAdDataEntity) networkData.data);
                    }
                });
                if (!(networkData.data == null || this.mHandler == null)) {
                    int refresh_interval = ((LiveAdDataEntity) networkData.data).getRefresh_interval();
                    a.a(TAG, "set interval: " + refresh_interval);
                    this.mHandler.setInterval(refresh_interval);
                }
            } else {
                notify(new Runnable() {
                    public void run() {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    }
                });
            }
        } catch (Exception unused) {
            notify(new Runnable() {
                public void run() {
                    callback.onError(TLSErrInfo.TIMEOUT, "Unknown exception");
                }
            });
        }
        LoopRequestHandler loopRequestHandler = this.mHandler;
        if (loopRequestHandler != null) {
            loopRequestHandler.delaySend();
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public int roomId;
        /* access modifiers changed from: private */
        public int sessionId;

        public Data(int i, int i2) {
            this.roomId = i;
            this.sessionId = i2;
        }
    }

    public void startAdTask(Data data, Callback callback) {
        try {
            if (this.mLoopThread == null) {
                this.mLoopThread = new HandlerThread(LOOP_THREAD + (System.currentTimeMillis() % 1000), 10);
                this.mLoopThread.start();
            }
            this.mHandler = new LoopRequestHandler(this.mLoopThread.getLooper());
            this.mHandler.setAdTaskRunnable(new AdTaskRunnable(this, data, callback));
            this.mHandler.start();
        } catch (Exception e2) {
            a.a(e2, "", new Object[0]);
        }
    }

    public void shutDownAdTask() {
        try {
            if (this.mHandler != null) {
                this.mHandler.stop();
                this.mHandler = null;
            }
            if (this.mLoopThread != null) {
                if (Build.VERSION.SDK_INT >= 18) {
                    this.mLoopThread.quitSafely();
                } else {
                    this.mLoopThread.quit();
                }
                this.mLoopThread = null;
            }
        } catch (Exception e2) {
            a.a(e2, "", new Object[0]);
        }
    }

    private class LoopRequestHandler extends Handler {
        static final int DEFAULT_INTERVAL = 60;
        static final int MSG = 1;
        private AdTaskRunnable adTaskRunnable;
        private int interval;
        private boolean stop;

        LoopRequestHandler(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: package-private */
        public void setAdTaskRunnable(AdTaskRunnable adTaskRunnable2) {
            this.adTaskRunnable = adTaskRunnable2;
        }

        /* access modifiers changed from: package-private */
        public void setInterval(int i) {
            if (i > 0) {
                this.interval = i;
            }
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.stop = true;
            removeMessages(1);
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.stop = false;
            int i = this.interval;
            if (i <= 0) {
                i = 60;
            }
            this.interval = i;
            sendEmptyMessage(1);
        }

        /* access modifiers changed from: package-private */
        public void delaySend() {
            if (!this.stop) {
                sendEmptyMessageDelayed(1, (long) (this.interval * 1000));
            }
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (!this.stop && i == 1) {
                AdTaskRunnable adTaskRunnable2 = this.adTaskRunnable;
                if (adTaskRunnable2 != null) {
                    adTaskRunnable2.run();
                }
            }
        }
    }

    private class AdTaskRunnable implements Runnable {
        Callback callback;
        Data data;
        LiveAdTask liveAdTask;

        AdTaskRunnable(LiveAdTask liveAdTask2, Data data2, Callback callback2) {
            this.liveAdTask = liveAdTask2;
            this.callback = callback2;
            this.data = data2;
        }

        public void run() {
            this.liveAdTask.execute(this.data, this.callback);
            a.a(LiveAdTask.TAG, "AdTaskRunnable run");
        }
    }
}

package com.shopee.live.livestreaming.network.task;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.shopee.e.a.a;
import com.shopee.live.livestreaming.data.entity.AnchorCoinEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.CheckInCoinService;

public class GetCoinGiveOutTask extends AbstractInteractor<Data, Callback> {
    private static final String NAME_OF_COIN_LOOPHANDLER = "NAME_OF_COIN_LOOPHANDLER";
    private static final String TAG = "CoinGiveOutTask: %s";
    private CheckInCoinService mCheckInCoinService;
    private CoinHandler mCoinHandler;
    private HandlerThread mLoopCoinHandler;

    public interface Callback {
        void onCoinError(int i, String str);

        void onCoinSuccess(AnchorCoinEntity anchorCoinEntity);
    }

    public GetCoinGiveOutTask(Executor executor, CheckInCoinService checkInCoinService) {
        super(executor);
        this.mCheckInCoinService = checkInCoinService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        AnchorCoinEntity anchorCoinEntity = null;
        try {
            final NetworkData<ServerResult<AnchorCoinEntity>> networkData = Network.get(this.mCheckInCoinService.getCoinGiveOut(data.mSid));
            if (callback != null) {
                if (networkData.hasError()) {
                    notify(new Runnable() {
                        public void run() {
                            callback.onCoinError(networkData.err_code, networkData.err_msg);
                        }
                    });
                } else {
                    notify(new Runnable() {
                        public void run() {
                            callback.onCoinSuccess((AnchorCoinEntity) networkData.data);
                        }
                    });
                    anchorCoinEntity = (AnchorCoinEntity) networkData.data;
                }
                CoinHandler coinHandler = this.mCoinHandler;
                if (coinHandler == null) {
                    return;
                }
                if (anchorCoinEntity == null) {
                    coinHandler.setInterval(10);
                    this.mCoinHandler.delaySend();
                } else if (1 == anchorCoinEntity.getShown_coins()) {
                    this.mCoinHandler.setInterval(anchorCoinEntity.getInterval());
                    this.mCoinHandler.delaySend();
                } else {
                    shutGiveOutTask();
                }
            }
        } catch (Exception unused) {
            notify(new Runnable() {
                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onCoinError(-99, "Network error!");
                    }
                }
            });
        }
    }

    public void startGiveOutTask(Data data, Callback callback) {
        if (this.mLoopCoinHandler == null) {
            this.mLoopCoinHandler = new HandlerThread(NAME_OF_COIN_LOOPHANDLER + (System.currentTimeMillis() % 1000), 10);
            this.mLoopCoinHandler.start();
        }
        this.mCoinHandler = new CoinHandler(this.mLoopCoinHandler.getLooper());
        this.mCoinHandler.setGiveOutTaskRunnable(new GiveOutTaskRunnable(this, callback, data));
        this.mCoinHandler.start();
    }

    public void shutGiveOutTask() {
        CoinHandler coinHandler = this.mCoinHandler;
        if (coinHandler != null) {
            coinHandler.stop();
            this.mCoinHandler = null;
        }
        if (this.mLoopCoinHandler != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.mLoopCoinHandler.quitSafely();
            } else {
                this.mLoopCoinHandler.quit();
            }
            this.mLoopCoinHandler = null;
        }
    }

    public static class Data {
        int mSid;

        public Data(int i) {
            this.mSid = i;
        }
    }

    private class CoinHandler extends Handler {
        static final int DEFAULT_INTERVAL = 10;
        static final int MSG = 1;
        private int interval;
        private GiveOutTaskRunnable mGiveOutTaskRunnable;
        private boolean start = false;

        public CoinHandler(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: package-private */
        public void setGiveOutTaskRunnable(GiveOutTaskRunnable giveOutTaskRunnable) {
            this.mGiveOutTaskRunnable = giveOutTaskRunnable;
        }

        /* access modifiers changed from: package-private */
        public void start() {
            this.start = true;
            int i = this.interval;
            if (i <= 0) {
                i = 10;
            }
            this.interval = i;
            sendEmptyMessage(1);
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.start = false;
            removeMessages(1);
        }

        /* access modifiers changed from: package-private */
        public void delaySend() {
            if (this.start) {
                sendEmptyMessageDelayed(1, (long) (this.interval * 1000));
            }
        }

        public void setInterval(int i) {
            this.interval = i;
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (this.start && i == 1) {
                GiveOutTaskRunnable giveOutTaskRunnable = this.mGiveOutTaskRunnable;
                if (giveOutTaskRunnable != null) {
                    giveOutTaskRunnable.run();
                }
            }
        }
    }

    private class GiveOutTaskRunnable implements Runnable {
        Callback mCallback;
        Data mData;
        GetCoinGiveOutTask mGetCoinGiveOutTask;

        public GiveOutTaskRunnable(GetCoinGiveOutTask getCoinGiveOutTask, Callback callback, Data data) {
            this.mGetCoinGiveOutTask = getCoinGiveOutTask;
            this.mCallback = callback;
            this.mData = data;
        }

        public void run() {
            this.mGetCoinGiveOutTask.execute(this.mData, this.mCallback);
            a.a(GetCoinGiveOutTask.TAG, "GetCoinGiveOutTask run");
        }
    }
}

package com.shopee.live.livestreaming.sztracking;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class SZTrackingLoopManager {
    private static final String NAME_HANDLER_THREAD = ("SZTrackingLoopManager%" + System.currentTimeMillis());
    public static final int WHAT_HEART_BEAT_EVENT = 1;
    private HandlerThread mHandlerThread;
    private SZTrackingHandler mSZTrackingHandler;
    private SZTrackingLoopListener mSZTrackingLoopListener;

    public interface SZTrackingLoopListener {
        void loopCallback(int i);
    }

    public SZTrackingLoopManager(SZTrackingLoopListener sZTrackingLoopListener) {
        this.mSZTrackingLoopListener = sZTrackingLoopListener;
    }

    public void start() {
        if (!isAvailable()) {
            this.mHandlerThread = new HandlerThread(NAME_HANDLER_THREAD, 10);
            this.mHandlerThread.start();
            this.mSZTrackingHandler = new SZTrackingHandler(this.mHandlerThread.getLooper(), this.mSZTrackingLoopListener);
        }
    }

    public boolean isAvailable() {
        HandlerThread handlerThread = this.mHandlerThread;
        return handlerThread != null && handlerThread.isAlive();
    }

    public void stop() {
        if (isAvailable()) {
            this.mSZTrackingHandler.removeCallbacksAndMessages((Object) null);
            this.mSZTrackingHandler = null;
            if (Build.VERSION.SDK_INT >= 18) {
                this.mHandlerThread.quitSafely();
            } else {
                this.mHandlerThread.quit();
            }
            this.mHandlerThread = null;
        }
    }

    public void executeLoop(int i, long j) {
        if (isAvailable() && this.mSZTrackingHandler != null) {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = Long.valueOf(j * 1000);
            this.mSZTrackingHandler.sendMessage(obtain);
        }
    }

    private class SZTrackingHandler extends Handler {
        private SZTrackingLoopListener mSZTrackingLoopListener;

        public SZTrackingHandler(Looper looper, SZTrackingLoopListener sZTrackingLoopListener) {
            super(looper);
            this.mSZTrackingLoopListener = sZTrackingLoopListener;
        }

        public void handleMessage(Message message) {
            SZTrackingLoopListener sZTrackingLoopListener = this.mSZTrackingLoopListener;
            if (sZTrackingLoopListener != null) {
                sZTrackingLoopListener.loopCallback(message.what);
            }
            if (message.obj instanceof Long) {
                Message obtain = Message.obtain();
                obtain.what = message.what;
                obtain.obj = message.obj;
                sendMessageDelayed(obtain, ((Long) message.obj).longValue());
            }
        }
    }
}

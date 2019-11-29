package com.garena.android.gpns.network.tcp;

import android.os.Handler;

public class TCPPacketTimer {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public OnTimeoutListener mOnTimeoutListener;
    private Runnable mOnTimeoutRunnable = new Runnable() {
        public void run() {
            if (TCPPacketTimer.this.mOnTimeoutListener != null) {
                TCPPacketTimer.this.mOnTimeoutListener.onTimeout(TCPPacketTimer.this.mPacket);
            }
        }
    };
    /* access modifiers changed from: private */
    public final TCPPacket mPacket;

    public interface OnTimeoutListener {
        void onTimeout(TCPPacket tCPPacket);
    }

    public boolean isWaitingFor(TCPPacket tCPPacket) {
        return true;
    }

    public TCPPacketTimer(TCPPacket tCPPacket) {
        this.mPacket = tCPPacket;
        this.mHandler = new Handler();
    }

    public void setOnTimeoutListener(OnTimeoutListener onTimeoutListener) {
        this.mOnTimeoutListener = onTimeoutListener;
    }

    public synchronized void start() {
        if (this.mOnTimeoutListener != null) {
            this.mHandler.postDelayed(this.mOnTimeoutRunnable, (long) this.mPacket.getTimeout());
        }
    }

    public synchronized void stop() {
        if (this.mOnTimeoutListener != null) {
            this.mHandler.removeCallbacks(this.mOnTimeoutRunnable);
        }
    }
}

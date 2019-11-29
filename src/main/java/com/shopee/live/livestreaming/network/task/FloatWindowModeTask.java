package com.shopee.live.livestreaming.network.task;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

import androidx.annotation.NonNull;

import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.util.t;

public class FloatWindowModeTask extends AbstractInteractor<FloatWindowModeTask.Data, FloatWindowModeTask.Callback> {
    public static final int START_SERVICE = 3;
    public static final int STEP_1 = 1;
    public static final int STEP_2 = 2;
    private Activity activity;

    public interface Callback {
        void onCheckedPermissionStep1(boolean z);

        void onCheckedPermissionStep2(boolean z);

        void onGotPermission();
    }

    public interface Promise {
        void onResolve();
    }

    public FloatWindowModeTask(Executor executor, Activity activity2) {
        super(executor);
        this.activity = activity2;
    }

    /* access modifiers changed from: protected */
    public void run(Data data,  final Callback callback) {
        int access$000 = data.step;
        if (access$000 != 1) {
            if (access$000 != 2) {
                if (access$000 == 3) {
                    notify(new Runnable() {
                        public void run() {
                            if (callback != null) {
                                callback.onGotPermission();
                            }
                        }
                    });
                }
            } else if (t.a((Context) this.activity)) {
                notify(new Runnable() {
                    public void run() {
                        if (callback != null) {
                            callback.onCheckedPermissionStep2(true);
                        }
                    }
                });
            } else if (Build.VERSION.SDK_INT <= 26) {
                try {
                    Thread.sleep(1000);
                    if (t.a((Context) this.activity)) {
                        notify(new Runnable() {
                            public void run() {
                                if (callback != null) {
                                    callback.onCheckedPermissionStep2(true);
                                }
                            }
                        });
                    } else {
                        callback.onCheckedPermissionStep2(false);
                    }
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            } else {
                notify(new Runnable() {
                    public void run() {
                        if (callback != null) {
                            callback.onCheckedPermissionStep2(false);
                        }
                    }
                });
            }
        } else if (t.a((Context) this.activity)) {
            notify(new Runnable() {
                public void run() {
                    if (callback != null) {
                        callback.onCheckedPermissionStep1(true);
                    }
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    if (callback != null) {
                        callback.onCheckedPermissionStep1(false);
                    }
                }
            });
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public int step;

        public Data(int i) {
            this.step = i;
        }
    }
}

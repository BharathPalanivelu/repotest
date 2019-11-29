package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.CommendBanStatusEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class CommendBanCheckTask extends AbstractInteractor<CommendBanCheckTask.Data, CommendBanCheckTask.Callback> {
    private final LiveStreamingService mCallService;

    public interface Callback {
        void onGeBanStatus(boolean z);
    }

    public CommendBanCheckTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<CommendBanStatusEntity>> networkData = Network.get(this.mCallService.checkDanmakuBanStatus(data.session_id));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onGeBanStatus(false);
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        callback.onGeBanStatus(((CommendBanStatusEntity) networkData.data).isBan());
                    }
                });
            }
        }
    }

    public static class Data {
        int session_id;

        public Data(int i) {
            this.session_id = i;
        }
    }
}

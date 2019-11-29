package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.ReplayRecordEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class GetReplayRecordTask extends AbstractInteractor<Data, Callback> {
    private LiveStreamingService mCallService;

    public interface Callback {
        void onFailed();

        void onSuccess(ReplayRecordEntity replayRecordEntity);
    }

    public GetReplayRecordTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<ReplayRecordEntity>> networkData = Network.get(this.mCallService.getReplayRecord(data.record_id));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed();
                    }
                });
            } else if (networkData.err_code == 0) {
                notify(new Runnable() {
                    public void run() {
                        callback.onSuccess((ReplayRecordEntity) networkData.data);
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed();
                    }
                });
            }
        }
    }

    public static class Data {
        int record_id;

        public Data(int i) {
            this.record_id = i;
        }
    }
}

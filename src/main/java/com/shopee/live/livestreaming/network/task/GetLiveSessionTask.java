package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class GetLiveSessionTask extends AbstractInteractor<Data, Callback> {
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i);

        void returnSessionInfo(LiveStreamingSessionEntity liveStreamingSessionEntity);
    }

    public GetLiveSessionTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<LiveStreamingSessionEntity>> networkData = Network.get(this.mLiveStreamingService.getSessionInfo(data.session_id));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.returnSessionInfo((LiveStreamingSessionEntity) networkData.data);
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    callback.onError(networkData.err_code);
                }
            });
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public int session_id;

        public Data(int i) {
            this.session_id = i;
        }
    }
}

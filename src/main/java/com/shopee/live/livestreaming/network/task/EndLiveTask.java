package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class EndLiveTask extends AbstractInteractor<Data, Callback> {
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void endSuccess();

        void onError(int i, String str);
    }

    public EndLiveTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mLiveStreamingService.endLiveStreaming(data.session_id));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.endSuccess();
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    callback.onError(networkData.err_code, networkData.err_msg);
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

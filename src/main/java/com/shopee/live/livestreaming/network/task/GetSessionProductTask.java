package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import f.b;

public class GetSessionProductTask extends AbstractInteractor<Data, Callback> {
    b<ServerResult<SessionProductEntity>> mCall;
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);

        void returnProduct(int i, SessionProductEntity sessionProductEntity);
    }

    public GetSessionProductTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(final Data data, final Callback callback) {
        this.mCall = this.mLiveStreamingService.getSessionProduct(data.session_id, data.offset, data.limit);
        final NetworkData<ServerResult<SessionProductEntity>> networkData = Network.get(this.mCall);
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.returnProduct(data.offset, (SessionProductEntity) networkData.data);
                    }
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    Callback callback = callback;
                    if (callback != null) {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    }
                }
            });
        }
    }

    public void shutTask() {
        b<ServerResult<SessionProductEntity>> bVar = this.mCall;
        if (bVar != null && !bVar.c()) {
            this.mCall.b();
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public int limit;
        /* access modifiers changed from: private */
        public int offset;
        /* access modifiers changed from: private */
        public int session_id;

        public Data(int i, int i2, int i3) {
            this.session_id = i;
            this.offset = i2;
            this.limit = i3;
        }
    }
}

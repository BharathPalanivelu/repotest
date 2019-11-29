package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class FollowingPostTask extends AbstractInteractor<FollowingPostTask.Data, FollowingPostTask.Callback> {
    private final LiveStreamingService mCallService;

    public interface Callback {
        void onFailed();

        void onSuccess();
    }

    public FollowingPostTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCallService.postFollowing(data.shop_id));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed();
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        if (networkData.err_code == 0) {
                            callback.onSuccess();
                        } else {
                            callback.onFailed();
                        }
                    }
                });
            }
        }
    }

    public static class Data {
        int shop_id;

        public Data(int i) {
            this.shop_id = i;
        }
    }
}

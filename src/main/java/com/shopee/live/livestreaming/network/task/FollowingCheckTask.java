package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.FollowStatusEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;

public class FollowingCheckTask extends AbstractInteractor<FollowingCheckTask.Data, FollowingCheckTask.Callback> {
    private final LiveStreamingService mCallService;

    public interface Callback {
        void onFailed();

        void onSuccess(boolean z);
    }

    public FollowingCheckTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<FollowStatusEntity>> networkData = Network.get(this.mCallService.checkFollowing(data.shop_id));
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
                        callback.onSuccess(((FollowStatusEntity) networkData.data).isFollowed());
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

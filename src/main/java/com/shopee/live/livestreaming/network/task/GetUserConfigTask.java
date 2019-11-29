package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.LiveStreamingRoomConfigEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.CheckInCoinService;

public class GetUserConfigTask extends AbstractInteractor<Data, Callback> {
    private CheckInCoinService mCheckInCoinService;

    public interface Callback {
        void onError(int i, String str);

        void onSuccess(LiveStreamingRoomConfigEntity liveStreamingRoomConfigEntity);
    }

    public GetUserConfigTask(Executor executor, CheckInCoinService checkInCoinService) {
        super(executor);
        this.mCheckInCoinService = checkInCoinService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<LiveStreamingRoomConfigEntity>> networkData = Network.get(this.mCheckInCoinService.getUserConfig(data.mSid, data.mUid));
        if (callback != null) {
            notify(new Runnable() {
                public void run() {
                    if (networkData.hasError()) {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    } else if (networkData.err_code == 0) {
                        callback.onSuccess((LiveStreamingRoomConfigEntity) networkData.data);
                    } else {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    }
                }
            });
        }
    }

    public static class Data {
        int mSid;
        int mUid;

        public Data(int i, int i2) {
            this.mSid = i;
            this.mUid = i2;
        }
    }
}

package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.CheckInCoinService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PostCoinLockTask extends AbstractInteractor<Data, Callback> {
    private CheckInCoinService mCheckInCoinService;

    public interface Callback {
        void onError(int i, String str);

        void onSuccess();
    }

    public PostCoinLockTask(Executor executor, CheckInCoinService checkInCoinService) {
        super(executor);
        this.mCheckInCoinService = checkInCoinService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCheckInCoinService.postCoinLock(data.mSid, data.mRequestBody));
        if (callback != null) {
            notify(new Runnable() {
                public void run() {
                    if (networkData.hasError()) {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    } else if (networkData.err_code == 0) {
                        callback.onSuccess();
                    } else {
                        callback.onError(networkData.err_code, networkData.err_msg);
                    }
                }
            });
        }
    }

    public static class Data {
        RequestBody mRequestBody;
        int mSid;

        public Data(int i, String str) {
            this.mSid = i;
            this.mRequestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), str);
        }
    }
}

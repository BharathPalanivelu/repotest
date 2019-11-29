package com.shopee.live.livestreaming.network.task;

import com.shopee.e.a.a;
import com.shopee.live.livestreaming.data.entity.LiveStreamingClaimEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.CheckInCoinService;
import com.shopee.live.livestreaming.network.task.PostCoinClaimTask;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PostCoinClaimTask extends AbstractInteractor<Data, Callback> {
    private CheckInCoinService mCheckInCoinService;

    public interface Callback {
        void onError(int i, String str);

        void onSuccess(int i);
    }

    public PostCoinClaimTask(Executor executor, CheckInCoinService checkInCoinService) {
        super(executor);
        this.mCheckInCoinService = checkInCoinService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, Callback callback) {
        NetworkData<ServerResult<LiveStreamingClaimEntity>> networkData = Network.get(this.mCheckInCoinService.postCoinClaim(data.mSid, data.mRequestBody));
        if (callback != null) {
            notify(new Runnable(callback) {
                private final /* synthetic */ PostCoinClaimTask.Callback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PostCoinClaimTask.lambda$run$0(NetworkData.this, this.f$1);
                }
            });
        }
    }

    static /* synthetic */ void lambda$run$0(NetworkData networkData, Callback callback) {
        if (networkData.hasError()) {
            callback.onError(networkData.err_code, networkData.err_msg);
        } else if (networkData.err_code == 0) {
            try {
                callback.onSuccess(((LiveStreamingClaimEntity) networkData.data).getClaim_times_left());
            } catch (Exception e2) {
                a.a((Object) e2.getMessage());
                callback.onError(networkData.err_code, networkData.err_msg);
            }
        } else {
            callback.onError(networkData.err_code, networkData.err_msg);
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

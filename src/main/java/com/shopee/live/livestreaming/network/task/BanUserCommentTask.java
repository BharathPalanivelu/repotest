package com.shopee.live.livestreaming.network.task;

import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.require.BanRequireEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import com.shopee.live.livestreaming.util.h;
import okhttp3.RequestBody;

public class BanUserCommentTask extends AbstractInteractor<Data, Callback> {
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);
    }

    public BanUserCommentTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mLiveStreamingService.banToComment(data.session_id, data.requestBody));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
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
        public RequestBody requestBody;
        /* access modifiers changed from: private */
        public int session_id;

        public Data(int i, long j) {
            this.session_id = i;
            BanRequireEntity banRequireEntity = new BanRequireEntity();
            banRequireEntity.setBan_uid(j);
            this.requestBody = h.a((Object) banRequireEntity);
        }
    }
}

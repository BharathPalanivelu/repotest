package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.require.LikeCountEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class PostLikeTask extends AbstractInteractor<PostLikeTask.Data, PostLikeTask.Callback> {
    private final LiveStreamingService mCallService;

    public interface Callback {
        void onFailed(int i);

        void onSucceess();
    }

    public PostLikeTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(final Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCallService.postLike(data.session_id, data.requestBody));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed(data.count);
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        if (networkData.err_code == 0) {
                            callback.onSucceess();
                        } else {
                            callback.onFailed(data.count);
                        }
                    }
                });
            }
        }
    }

    public static class Data {
        int count;
        RequestBody requestBody;
        int session_id;

        public Data(int i, int i2) {
            this.session_id = i;
            this.count = i2;
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) new LikeCountEntity(i2)));
        }
    }
}

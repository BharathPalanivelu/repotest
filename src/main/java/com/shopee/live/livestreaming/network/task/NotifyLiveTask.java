package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NotifyLiveEntity;
import com.shopee.live.livestreaming.data.entity.require.NotifyRequireEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class NotifyLiveTask extends AbstractInteractor<Data, Callback> {
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);

        void onLiveSuccess();
    }

    public NotifyLiveTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NotifyLiveEntity>> networkData = Network.get(this.mLiveStreamingService.notifyLive(data.session_id, data.requestBody));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.onLiveSuccess();
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

        public Data(int i, boolean z) {
            this.session_id = i;
            NotifyRequireEntity notifyRequireEntity = new NotifyRequireEntity();
            notifyRequireEntity.setNotify_followers(z);
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) notifyRequireEntity));
        }
    }
}

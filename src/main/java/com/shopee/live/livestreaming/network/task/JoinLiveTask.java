package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.LiveStreamingSessionEntity;
import com.shopee.live.livestreaming.data.entity.require.JoinLiveEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class JoinLiveTask extends AbstractInteractor<Data, Callback> {
    private LiveStreamingService mCallService;

    public interface Callback {
        void onFailed(int i);

        void onSucceess(LiveStreamingSessionEntity liveStreamingSessionEntity);
    }

    public JoinLiveTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<LiveStreamingSessionEntity>> networkData = Network.get(this.mCallService.postJoinLiveRoom(data.session_id, data.requestBody));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed(networkData.err_code);
                    }
                });
            } else if (networkData.err_code == 0) {
                notify(new Runnable() {
                    public void run() {
                        callback.onSucceess((LiveStreamingSessionEntity) networkData.data);
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed(networkData.err_code);
                    }
                });
            }
        }
    }

    public static class Data {
        RequestBody requestBody;
        int session_id;

        public Data(int i, String str, String str2) {
            this.session_id = i;
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) new JoinLiveEntity(str, str2)));
        }
    }
}

package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.require.ExitLiveEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ExitLiveTask extends AbstractInteractor<Data, Callback> {
    private LiveStreamingService mCallService;

    public interface Callback {
        void onFailed();

        void onSuccess();
    }

    public ExitLiveTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCallService.postExitLiveRoom(data.sessionId, data.requestBody));
        if (callback != null) {
            if (networkData.hasError()) {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed();
                    }
                });
            } else if (networkData.err_code == 0) {
                notify(new Runnable() {
                    public void run() {
                        callback.onSuccess();
                    }
                });
            } else {
                notify(new Runnable() {
                    public void run() {
                        callback.onFailed();
                    }
                });
            }
        }
    }

    public static class Data {
        /* access modifiers changed from: private */
        public RequestBody requestBody;
        /* access modifiers changed from: private */
        public int sessionId;

        public Data(int i, String str, String str2) {
            this.sessionId = i;
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) new ExitLiveEntity(str, str2)));
        }
    }
}

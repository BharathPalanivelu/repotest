package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.require.MessageEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class SendMessageTask extends AbstractInteractor<Data, Callback> {
    private LiveStreamingService mCallService;

    public interface Callback {
        void onFailed(int i);

        void onSucceess();
    }

    public SendMessageTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mCallService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCallService.postSendMessage(data.session_id, data.requestBody));
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
                        callback.onSucceess();
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

        public Data(String str, int i, String str2, String str3) {
            this.session_id = i;
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), new f().b((Object) new MessageEntity(str2, str3, str)));
        }
    }
}

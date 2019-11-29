package com.shopee.live.livestreaming.network.task;

import android.text.TextUtils;
import com.shopee.live.livestreaming.data.entity.PlayUrlEntity;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import f.b;

public class GetPlayUrlTask extends AbstractInteractor<GetPlayUrlTask.Data, GetPlayUrlTask.Callback> {
    b<ServerResult<PlayUrlEntity>> mCall;
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onReject(int i, String str);

        void onResolve(String str);
    }

    public GetPlayUrlTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<PlayUrlEntity>> networkData = Network.get(this.mLiveStreamingService.getPlayUrl(data.getSession_id()));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    String play_url = networkData.data == null ? "" : ((PlayUrlEntity) networkData.data).getPlay_url();
                    if (!TextUtils.isEmpty(play_url)) {
                        callback.onResolve(play_url);
                    } else {
                        callback.onReject(-1, "Empty play url");
                    }
                }
            });
        } else {
            notify(new Runnable() {
                public void run() {
                    callback.onReject(networkData.err_code, networkData.err_msg);
                }
            });
        }
    }

    public void shutTask() {
        b<ServerResult<PlayUrlEntity>> bVar = this.mCall;
        if (bVar != null && !bVar.c()) {
            this.mCall.b();
        }
    }

    public static class Data {
        private int session_id;

        public Data(int i) {
            this.session_id = i;
        }

        public int getSession_id() {
            return this.session_id;
        }
    }
}

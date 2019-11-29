package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.SessionProductEntity;
import com.shopee.live.livestreaming.data.entity.param.UpLoadProductParams;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class UpLoadShowProductTask extends AbstractInteractor<Data, Callback> {
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);

        void upLoadSuccess();
    }

    public UpLoadShowProductTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mLiveStreamingService.upLoadShowProduct(data.session_id, data.requestBody));
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.upLoadSuccess();
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
        RequestBody requestBody;
        int session_id;

        public Data(int i, SessionProductEntity.ProductItem productItem) {
            this.session_id = i;
            UpLoadProductParams upLoadProductParams = new UpLoadProductParams();
            f fVar = new f();
            if (productItem != null) {
                upLoadProductParams.setItem(fVar.b((Object) productItem));
            } else {
                upLoadProductParams.setItem("");
            }
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), fVar.b((Object) upLoadProductParams));
        }
    }
}

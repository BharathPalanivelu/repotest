package com.shopee.live.livestreaming.network.task;

import com.google.a.f;
import com.shopee.live.livestreaming.data.entity.NullEntity;
import com.shopee.live.livestreaming.data.entity.VoucherEntity;
import com.shopee.live.livestreaming.data.entity.require.ShowVoucerParams;
import com.shopee.live.livestreaming.network.executor.AbstractInteractor;
import com.shopee.live.livestreaming.network.executor.Executor;
import com.shopee.live.livestreaming.network.executor.Network;
import com.shopee.live.livestreaming.network.executor.NetworkData;
import com.shopee.live.livestreaming.network.executor.ServerResult;
import com.shopee.live.livestreaming.network.service.LiveStreamingService;
import f.b;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class ShowVoucherTask extends AbstractInteractor<Data, Callback> {
    b<ServerResult<NullEntity>> mCall;
    private final LiveStreamingService mLiveStreamingService;

    public interface Callback {
        void onError(int i, String str);

        void showSuccess();
    }

    public ShowVoucherTask(Executor executor, LiveStreamingService liveStreamingService) {
        super(executor);
        this.mLiveStreamingService = liveStreamingService;
    }

    /* access modifiers changed from: protected */
    public void run(Data data, final Callback callback) {
        this.mCall = this.mLiveStreamingService.showVoucher(data.requestBody);
        final NetworkData<ServerResult<NullEntity>> networkData = Network.get(this.mCall);
        if (!networkData.hasError()) {
            notify(new Runnable() {
                public void run() {
                    callback.showSuccess();
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

    public void shutTask() {
        b<ServerResult<NullEntity>> bVar = this.mCall;
        if (bVar != null && !bVar.c()) {
            this.mCall.b();
        }
    }

    public static class Data {
        RequestBody requestBody;

        public Data(int i, VoucherEntity voucherEntity) {
            f fVar = new f();
            String jsonStringFromEntity = getJsonStringFromEntity(voucherEntity);
            ShowVoucerParams showVoucerParams = new ShowVoucerParams();
            showVoucerParams.setSession_id(i);
            showVoucerParams.setVoucher(jsonStringFromEntity);
            this.requestBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), fVar.b((Object) showVoucerParams));
        }

        private String getJsonStringFromEntity(VoucherEntity voucherEntity) {
            if (voucherEntity == null) {
                return "";
            }
            f fVar = new f();
            if (voucherEntity.getReward_type() != 2) {
                return fVar.b((Object) voucherEntity);
            }
            VoucherEntity voucherEntity2 = new VoucherEntity();
            voucherEntity2.setExtra_voucher(fVar.b((Object) voucherEntity));
            return fVar.b((Object) voucherEntity2);
        }
    }
}

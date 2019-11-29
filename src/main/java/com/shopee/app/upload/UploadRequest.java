package com.shopee.app.upload;

import com.shopee.app.network.d.az;
import com.shopee.app.network.d.b;
import com.shopee.app.network.d.o;
import com.shopee.app.network.g;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.util.k.a;
import com.shopee.protocol.action.ResponseCommon;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class UploadRequest implements a {
    private BlockingQueue<ResponseCommon> mBlockingQueue;
    private az mRequest;
    private com.shopee.app.ui.product.add.a mSuccessEvent;

    public UploadRequest(UploadGroup uploadGroup) {
        if (uploadGroup.getItem().getItem().itemid.longValue() <= 0) {
            this.mRequest = new b(new g(uploadGroup.getRequestId()), uploadGroup.getItem().getItem(), uploadGroup.getModelList().getModels(), uploadGroup.showProductWeight(), uploadGroup.isUnListItem());
        } else {
            this.mRequest = new o(uploadGroup.getItem().getItem(), uploadGroup.getModelList().getModels(), uploadGroup.showProductWeight(), uploadGroup.isUnListItem());
        }
        this.mBlockingQueue = new ArrayBlockingQueue(1);
    }

    public ResponseCommon startSync() {
        com.shopee.app.h.o.a().a(this.mRequest);
        com.shopee.app.h.o.a().a(this.mRequest.i().a(), (a) this);
        this.mRequest.g();
        try {
            return this.mBlockingQueue.take();
        } catch (InterruptedException unused) {
            ResponseCommon.Builder builder = new ResponseCommon.Builder();
            builder.errcode = -100;
            return builder.build();
        }
    }

    public void onFailed(ResponseCommon responseCommon) {
        this.mBlockingQueue.add(responseCommon);
    }

    public void onSuccess(com.shopee.app.ui.product.add.a aVar) {
        this.mSuccessEvent = aVar;
        ResponseCommon.Builder builder = new ResponseCommon.Builder();
        builder.errcode = 0;
        this.mBlockingQueue.add(builder.build());
    }

    public com.shopee.app.ui.product.add.a getSuccessEvent() {
        return this.mSuccessEvent;
    }
}

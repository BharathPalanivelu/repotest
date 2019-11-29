package com.shopee.app.upload.data;

import com.shopee.protocol.shop.ItemModel;
import java.util.ArrayList;
import java.util.List;

public class UploadModelList {
    public List<UploadModel> modelList;

    private UploadModelList() {
        this.modelList = new ArrayList();
    }

    private UploadModelList(Builder builder) {
        this.modelList = builder.modelList1;
    }

    public List<ItemModel> getModels() {
        ArrayList arrayList = new ArrayList();
        for (UploadModel model : this.modelList) {
            arrayList.add(model.getModel());
        }
        return arrayList;
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<UploadModel> modelList1 = new ArrayList();

        public Builder add(UploadModel uploadModel) {
            this.modelList1.add(uploadModel);
            return this;
        }

        public UploadModelList build() {
            return new UploadModelList(this);
        }
    }
}

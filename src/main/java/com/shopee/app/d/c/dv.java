package com.shopee.app.d.c;

import com.shopee.app.appuser.UserInfo;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.be;
import com.shopee.app.data.store.f;
import com.shopee.app.data.store.m;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.Variation;
import com.shopee.app.network.g;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.upload.UploadManager;
import com.shopee.app.upload.UploadStore;
import com.shopee.app.upload.data.UploadGroup;
import com.shopee.app.upload.data.UploadItem;
import com.shopee.app.upload.data.UploadModel;
import com.shopee.app.upload.data.UploadModelList;
import com.shopee.app.upload.data.UploadVideo;
import com.shopee.app.util.f.a;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.util.List;

public class dv extends dd {

    /* renamed from: d  reason: collision with root package name */
    private final UploadStore f16858d;

    /* renamed from: e  reason: collision with root package name */
    private final UploadManager f16859e;

    /* renamed from: f  reason: collision with root package name */
    private final a f16860f;

    /* renamed from: g  reason: collision with root package name */
    private final be f16861g;
    private boolean h;
    private boolean i;

    /* access modifiers changed from: protected */
    public String d() {
        return "SubmitProductInteractor2";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected dv(n nVar, ba baVar, UploadStore uploadStore, a aVar, be beVar, UploadManager uploadManager, m mVar, af afVar, SettingConfigStore settingConfigStore, UserInfo userInfo, com.shopee.app.d.c.b.a aVar2) {
        super(nVar, baVar, mVar, afVar, settingConfigStore, userInfo, aVar2);
        this.f16858d = uploadStore;
        this.f16859e = uploadManager;
        this.f16860f = aVar;
        this.f16861g = beVar;
    }

    public void a(long j, AddProductInfo addProductInfo, List<WholesaleTierModel> list, List<MediaData> list2, String str, List<ModelDetail> list3, boolean z, boolean z2, boolean z3, List<Variation> list4) {
        this.h = z;
        this.i = z2;
        super.a(j, addProductInfo, list, list2, str, list3, z3, list4);
    }

    /* access modifiers changed from: protected */
    public void a(Item item, MediaData mediaData, List<ItemModel> list, ba baVar, boolean z) {
        UploadGroup.Builder isShareToTwitter = new UploadGroup.Builder().requestId(new g().a()).item(new UploadItem(item)).isEdit(item.itemid.longValue() > 0).showProductWeight(this.f16786c.showProductWeight()).unListItem(z).isShareToFB(this.h).isShareToTwitter(this.i);
        if (mediaData != null) {
            UploadVideo.Builder status = new UploadVideo.Builder().startTime((long) mediaData.getStartTime()).duration(mediaData.getDuration()).path(mediaData.getPath()).thumb(mediaData.getThumb()).status(mediaData.getStatus());
            if (mediaData.getStatus() != 0) {
                status.outPath(mediaData.getPath());
            }
            isShareToTwitter.video(status.build());
        }
        if (!com.shopee.app.util.af.a(list)) {
            UploadModelList.Builder builder = new UploadModelList.Builder();
            for (ItemModel uploadModel : list) {
                builder.add(new UploadModel(uploadModel));
            }
            isShareToTwitter.modelList(builder.build());
        }
        this.f16858d.add(isShareToTwitter.build());
        this.f16402a.a("ITEM_SAVED_LOCALLY", new com.garena.android.appkit.b.a());
        f.a().c().a(Boolean.valueOf(this.i)).v();
        f.a().b().a(Boolean.valueOf(this.h)).v();
    }
}

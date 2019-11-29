package com.shopee.app.d.c;

import android.text.TextUtils;
import com.shopee.app.appuser.UserInfo;
import com.shopee.app.d.a.b;
import com.shopee.app.d.c.b.a;
import com.shopee.app.data.store.SettingConfigStore;
import com.shopee.app.data.store.af;
import com.shopee.app.data.store.ba;
import com.shopee.app.data.store.m;
import com.shopee.app.data.viewmodel.AddProductInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.Variation;
import com.shopee.app.database.orm.bean.DBCategory;
import com.shopee.app.database.orm.bean.DBItemAttribute;
import com.shopee.app.g.d;
import com.shopee.app.g.e;
import com.shopee.app.ui.image.MediaData;
import com.shopee.app.ui.product.add.wholesale.WholesaleTierModel;
import com.shopee.app.ui.product.add.wholesale.j;
import com.shopee.app.ui.product.attributes.u;
import com.shopee.app.util.n;
import com.shopee.protocol.shop.AttributeSnapshot;
import com.shopee.protocol.shop.AttributeValue;
import com.shopee.protocol.shop.CategoryPath;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemAttributeData;
import com.shopee.protocol.shop.ItemExtInfo;
import com.shopee.protocol.shop.ItemModel;
import com.shopee.protocol.shop.ItemModelExtInfo;
import com.shopee.protocol.shop.TierVariation;
import com.shopee.protocol.shop.VideoInfo;
import e.f;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class dd extends a {

    /* renamed from: c  reason: collision with root package name */
    protected final SettingConfigStore f16786c;

    /* renamed from: d  reason: collision with root package name */
    private final af f16787d;

    /* renamed from: e  reason: collision with root package name */
    private final UserInfo f16788e;

    /* renamed from: f  reason: collision with root package name */
    private final ba f16789f;

    /* renamed from: g  reason: collision with root package name */
    private final m f16790g;
    private AddProductInfo h;
    private List<MediaData> i;
    private long j;
    private String k;
    private List<ModelDetail> l;
    private List<WholesaleTierModel> m;
    private List<Variation> n;
    private a o;
    private boolean p;

    /* access modifiers changed from: protected */
    public abstract void a(Item item, MediaData mediaData, List<ItemModel> list, ba baVar, boolean z);

    /* access modifiers changed from: protected */
    public String d() {
        return "ProcessProductInteractor";
    }

    protected dd(n nVar, ba baVar, m mVar, af afVar, SettingConfigStore settingConfigStore, UserInfo userInfo, a aVar) {
        super(nVar);
        this.f16790g = mVar;
        this.f16787d = afVar;
        this.f16788e = userInfo;
        this.f16789f = baVar;
        this.f16786c = settingConfigStore;
        this.o = aVar;
    }

    public void a(long j2, AddProductInfo addProductInfo, List<WholesaleTierModel> list, List<MediaData> list2, String str, List<ModelDetail> list3, boolean z, List<Variation> list4) {
        this.j = j2;
        this.h = addProductInfo;
        this.i = list2;
        this.k = str;
        this.l = list3;
        this.m = list;
        this.p = z;
        this.n = list4;
        a();
    }

    /* access modifiers changed from: protected */
    public void c() {
        e();
    }

    private void e() {
        long j2;
        int i2;
        Iterator<u> it;
        long j3;
        Item.Builder builder = new Item.Builder();
        ArrayList arrayList = new ArrayList();
        MediaData mediaData = null;
        for (MediaData next : this.i) {
            if (next.isVideo()) {
                mediaData = next;
            } else {
                arrayList.add(next.getPath());
            }
        }
        Long a2 = e.a(this.h.getPrice(), "IDR");
        if (a2 == null) {
            j2 = 0;
        } else {
            j2 = a2.longValue();
        }
        builder.shopid(Integer.valueOf(this.f16788e.getShopId())).itemid(Long.valueOf(this.j)).name(this.h.getName()).description(this.h.getDescription()).images(d.a((List<String>) arrayList)).condition(Integer.valueOf(this.h.getConditionId()));
        ArrayList arrayList2 = new ArrayList();
        try {
            i2 = Integer.parseInt(this.h.getStock());
        } catch (NumberFormatException unused) {
            com.garena.android.appkit.d.a.e("no stock", new Object[0]);
            i2 = 0;
        }
        builder.stock(Integer.valueOf(i2)).price(Long.valueOf(j2));
        if (!this.l.isEmpty()) {
            for (ModelDetail next2 : this.l) {
                Long a3 = e.a(next2.getDisplayPrice(), "IDR");
                if (a3 == null) {
                    j3 = 0;
                } else {
                    j3 = a3.longValue();
                }
                ItemModel.Builder builder2 = new ItemModel.Builder();
                builder2.name(next2.getName().trim()).currency("IDR").itemid(Long.valueOf(this.j)).modelid(Long.valueOf(next2.getModelId())).price(Long.valueOf(j3)).stock(Integer.valueOf(Integer.parseInt(next2.getDisplayStock()))).extinfo(f.a(new ItemModelExtInfo.Builder().tier_index(next2.getTierIndexes()).build().toByteArray()));
                arrayList2.add(builder2.build());
            }
        }
        builder.currency("IDR");
        builder.brand(this.h.getBrand());
        ArrayList arrayList3 = new ArrayList();
        if (!com.shopee.app.util.af.a(this.n)) {
            for (Variation next3 : this.n) {
                arrayList3.add(new TierVariation.Builder().name(next3.name).options(next3.options).images(next3.images).build());
            }
        }
        ItemExtInfo.Builder is_pre_order = new ItemExtInfo.Builder().display_weight(this.h.getDisplayWeight()).weight(Long.valueOf(this.h.getWeight())).tier_variation(arrayList3).is_pre_order(Boolean.valueOf(this.h.isPreOrder()));
        AddProductInfo.Dimension dimension = this.h.getDimension();
        if (dimension != null && dimension.isValid()) {
            is_pre_order.dimensions(new b().apply(dimension)).display_dimension(dimension.displayDimension);
        }
        DBCategory a4 = this.f16790g.a(this.h.getCategoryId());
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(0, Integer.valueOf(this.h.getCategoryId()));
        while (a4 != null && a4.d() > 0) {
            arrayList4.add(0, Integer.valueOf(a4.d()));
            a4 = this.f16790g.a(a4.d());
        }
        List<DBCategory> b2 = this.f16790g.b(this.h.getCategoryId());
        if (!com.shopee.app.util.af.a(b2) && arrayList4.size() < 3 && b2.size() == 1) {
            arrayList4.add(Integer.valueOf(b2.get(0).a()));
        }
        CategoryPath.Builder builder3 = new CategoryPath.Builder();
        builder3.catid(arrayList4);
        is_pre_order.cats(Arrays.asList(new CategoryPath[]{builder3.build()}));
        if (this.h.getShippingDays() != 0) {
            is_pre_order.estimated_days(Integer.valueOf(this.h.getShippingDays()));
        }
        if (this.h.getLogisticInfo() != null) {
            try {
                is_pre_order.logistics_info(f.a(this.h.getLogisticInfo().getBytes("UTF-8")));
            } catch (UnsupportedEncodingException e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
            is_pre_order.display_shipping_fee(this.h.getDisplayLogisticInfo());
        }
        is_pre_order.instagram_media_id(this.k);
        AttributeSnapshot.Builder builder4 = new AttributeSnapshot.Builder();
        ArrayList arrayList5 = new ArrayList();
        if (this.h.getModelId() > 0) {
            int modelId = this.h.getModelId();
            List<u> attributeValues = this.h.getAttributeValues();
            if (!com.shopee.app.util.af.a(attributeValues)) {
                boolean z = false;
                for (Iterator<u> it2 = attributeValues.iterator(); it2.hasNext(); it2 = it) {
                    u next4 = it2.next();
                    AttributeValue.Builder builder5 = new AttributeValue.Builder();
                    builder5.attr_id(Integer.valueOf(next4.a()));
                    DBItemAttribute a5 = this.f16787d.a(next4.a());
                    if (z || a5.g() == null) {
                        it = it2;
                    } else {
                        try {
                            it = it2;
                            try {
                                ItemAttributeData itemAttributeData = (ItemAttributeData) com.shopee.app.network.f.f18486a.parseFrom(a5.g(), 0, a5.g().length, ItemAttributeData.class);
                                if (itemAttributeData != null) {
                                    if (com.shopee.app.d.b.b.a(itemAttributeData.brand_option) == 1) {
                                        try {
                                            builder.brand(next4.b());
                                            z = true;
                                        } catch (IOException e3) {
                                            e = e3;
                                            com.garena.android.appkit.d.a.a(e);
                                            builder5.value(next4.b());
                                            arrayList5.add(builder5.build());
                                        }
                                    }
                                    builder5.value(next4.b());
                                    arrayList5.add(builder5.build());
                                }
                            } catch (IOException e4) {
                                e = e4;
                                com.garena.android.appkit.d.a.a(e);
                                builder5.value(next4.b());
                                arrayList5.add(builder5.build());
                            }
                        } catch (IOException e5) {
                            e = e5;
                            it = it2;
                            com.garena.android.appkit.d.a.a(e);
                            builder5.value(next4.b());
                            arrayList5.add(builder5.build());
                        }
                    }
                    builder5.value(next4.b());
                    arrayList5.add(builder5.build());
                }
            }
            builder4.modelid(Integer.valueOf(modelId));
            builder4.values(arrayList5);
            is_pre_order.attributes(builder4.build());
        }
        if (mediaData == null || TextUtils.isEmpty(mediaData.getPath()) || mediaData.isDummy() || new File(mediaData.getPath()).exists()) {
            is_pre_order.video_info_list((List<VideoInfo>) null);
        } else {
            is_pre_order.video_info_list(Collections.singletonList(new VideoInfo.Builder().video_id(mediaData.getPath()).duration(Integer.valueOf(mediaData.getDuration())).thumb_url(mediaData.getThumb()).build()));
        }
        is_pre_order.wholesale_tier_list(j.a(this.m));
        if (this.p) {
            is_pre_order.cats_recommend(com.shopee.app.d.a.a.a(this.o.a((List<Integer>) this.h.getCatRecommendationIds())));
        }
        builder.extinfo(f.a(is_pre_order.build().toByteArray()));
        a(builder.build(), mediaData, arrayList2, this.f16789f, this.h.isDeListProduct());
    }
}

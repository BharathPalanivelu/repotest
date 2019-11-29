package com.shopee.feeds.feedlibrary.data.c;

import android.content.Context;
import com.google.a.f;
import com.shopee.feeds.feedlibrary.a.a;
import com.shopee.feeds.feedlibrary.a.a.c;
import com.shopee.feeds.feedlibrary.a.a.d;
import com.shopee.feeds.feedlibrary.data.entity.ProductEntity;
import org.json.JSONException;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private Context f27711a;

    public g(Context context) {
        this.f27711a = context;
    }

    public void a(int i, int i2, int i3, boolean z, a aVar) {
        if (i == 0) {
            ProductEntity productEntity = (ProductEntity) com.shopee.feeds.feedlibrary.data.d.a.a(this.f27711a).b("key_fav_product");
            if (productEntity != null && productEntity.getItems().size() > 0) {
                aVar.a(productEntity, "from_cache");
                return;
            }
        }
        a(b.f27683d, i, i2, i3, z, aVar);
    }

    public void b(int i, int i2, int i3, boolean z, a aVar) {
        a(b.f27684e, i, i2, i3, z, aVar);
    }

    public void c(int i, int i2, int i3, boolean z, a aVar) {
        if (i == 0) {
            ProductEntity productEntity = (ProductEntity) com.shopee.feeds.feedlibrary.data.d.a.a(this.f27711a).b("key_my_product");
            if (productEntity != null && productEntity.getItems().size() > 0) {
                aVar.a(productEntity, "from_cache");
                return;
            }
        }
        a(b.f27685f, i, i2, i3, z, aVar);
    }

    private void a(String str, int i, int i2, int i3, boolean z, final a aVar) {
        d.a aVar2 = new d.a(this.f27711a);
        aVar2.a(com.shopee.feeds.feedlibrary.util.d.a(str, "offset=" + String.valueOf(i), "limit=" + String.valueOf(i2))).b().e().a(i3);
        if (z) {
            aVar2.c();
        }
        aVar2.a((com.shopee.feeds.feedlibrary.a.a.a<c>) new com.shopee.feeds.feedlibrary.a.a.a<c>() {
            public void a(c cVar, String str) {
                if (cVar != null) {
                    try {
                        ProductEntity productEntity = (ProductEntity) new f().a(new JSONObject(cVar.a()).toString(), ProductEntity.class);
                        if (productEntity != null && aVar != null) {
                            aVar.a(productEntity, "from_network");
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }

            public void a(int i, String str) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.a(str);
                }
            }
        });
        aVar2.f().a();
    }
}

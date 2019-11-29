package com.shopee.app.util.k;

import android.util.Base64;
import com.garena.android.appkit.tools.b;
import com.google.a.i;
import com.google.a.l;
import com.google.a.o;
import com.shopee.app.data.viewmodel.EditCategoryData;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.app.web.WebRegister;
import com.shopee.id.R;
import com.shopee.protocol.shop.Item;
import com.shopee.protocol.shop.ItemModel;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g implements Serializable {
    public String errorMessage = b.e(R.string.sp_label_product_upload_failed);
    public boolean isShareToFB;
    public boolean isShareToTwitter;
    public Item item;
    public List<ItemModel> models;
    public String requestId;
    public int status;
    public int timestamp;
    public a video;

    public static String a(g gVar) {
        o oVar = new o();
        oVar.a("requestId", gVar.requestId);
        oVar.a("item", Base64.encodeToString(gVar.item.toByteArray(), 0));
        oVar.a("status", (Number) Integer.valueOf(gVar.status));
        oVar.a("isShareToFB", Boolean.valueOf(gVar.isShareToFB));
        oVar.a("isShareToTwitter", Boolean.valueOf(gVar.isShareToTwitter));
        oVar.a("errorMessage", gVar.errorMessage);
        i iVar = new i();
        for (ItemModel byteArray : gVar.models) {
            o oVar2 = new o();
            oVar2.a("model", Base64.encodeToString(byteArray.toByteArray(), 0));
            iVar.a((l) oVar2);
        }
        oVar.a("models", (l) iVar);
        a aVar = gVar.video;
        if (aVar != null) {
            oVar.a("video", a.a(aVar));
        }
        return WebRegister.GSON.a((l) oVar);
    }

    public static g a(String str) {
        g gVar = new g();
        o oVar = (o) WebRegister.GSON.a(str, o.class);
        gVar.requestId = oVar.c("requestId").c();
        gVar.status = oVar.c("status").g();
        gVar.isShareToFB = oVar.c("isShareToFB").h();
        gVar.isShareToTwitter = oVar.c("isShareToTwitter").h();
        gVar.errorMessage = oVar.c("errorMessage").c();
        try {
            gVar.item = (Item) f.f18486a.parseFrom(Base64.decode(oVar.c("item").c(), 0), Item.class);
            i d2 = oVar.d("models");
            ArrayList arrayList = new ArrayList();
            Iterator<l> it = d2.iterator();
            while (it.hasNext()) {
                try {
                    arrayList.add((ItemModel) f.f18486a.parseFrom(Base64.decode(it.next().m().c("model").c(), 0), ItemModel.class));
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
            gVar.models = arrayList;
            if (oVar.b("video")) {
                gVar.video = a.a(oVar.c("video").c());
            }
            return gVar;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public boolean a() {
        return this.status == 1;
    }

    public static class a implements Serializable {
        public int duration = 0;
        public String path = "";
        public String thumb = "";
        public String uploadId = "";
        public String videoId = "";

        public static String a(a aVar) {
            o oVar = new o();
            oVar.a("path", aVar.path);
            oVar.a("thumb", aVar.thumb);
            oVar.a("duration", (Number) Integer.valueOf(aVar.duration));
            oVar.a("uploadId", aVar.uploadId);
            oVar.a("videoId", aVar.videoId);
            return WebRegister.GSON.a((l) oVar);
        }

        public static a a(String str) {
            a aVar = new a();
            o oVar = (o) WebRegister.GSON.a(str, o.class);
            aVar.path = oVar.c("path").c();
            aVar.thumb = oVar.c("thumb").c();
            aVar.duration = oVar.c("duration").g();
            aVar.uploadId = oVar.c("uploadId").c();
            if (oVar.b("videoId")) {
                aVar.videoId = oVar.c("videoId").c();
            }
            return aVar;
        }
    }

    public static List<Integer> a(List<EditCategoryData.EditCategory> list) {
        ArrayList arrayList = new ArrayList();
        if (!af.a(list)) {
            for (EditCategoryData.EditCategory editCategory : list) {
                arrayList.add(Integer.valueOf(editCategory.catId));
            }
        }
        return arrayList;
    }
}

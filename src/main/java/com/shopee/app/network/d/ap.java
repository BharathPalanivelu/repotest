package com.shopee.app.network.d;

import com.garena.android.appkit.b.a;
import com.garena.android.appkit.b.b;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.network.c.c;
import com.shopee.app.network.f;
import com.shopee.app.util.af;
import com.shopee.protocol.action.ResponseItem;
import com.shopee.protocol.shop.ItemModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ap extends c {
    public int a() {
        return 25;
    }

    public void c(byte[] bArr, int i) throws IOException {
        DBItemSnapShot dBItemSnapShot;
        ResponseItem responseItem = (ResponseItem) f.f18486a.parseFrom(bArr, 0, i, ResponseItem.class);
        if (a(responseItem) || responseItem.errcode.intValue() == 4) {
            if (responseItem.item != null) {
                ah ahVar = new ah();
                ao aoVar = new ao();
                if (responseItem.errcode.intValue() == 4) {
                    dBItemSnapShot = DBItemSnapShot.a(responseItem.item.shopid, responseItem.item.itemid);
                } else {
                    dBItemSnapShot = new DBItemSnapShot();
                    b.a(responseItem.item, responseItem.snapshotid.longValue(), dBItemSnapShot);
                }
                ahVar.a(dBItemSnapShot);
                ArrayList arrayList = new ArrayList();
                if (!af.a(responseItem.models)) {
                    for (ItemModel a2 : responseItem.models) {
                        DBModelSnapshot dBModelSnapshot = new DBModelSnapshot();
                        b.a(a2, (IModelDetail) dBModelSnapshot);
                        arrayList.add(dBModelSnapshot);
                    }
                    aoVar.b((List<DBModelSnapshot>) arrayList);
                }
                b.a(dBItemSnapShot, (List<ModelDetail>) af.a(arrayList, new af.b<ModelDetail, DBModelSnapshot>() {
                    /* renamed from: a */
                    public ModelDetail map(DBModelSnapshot dBModelSnapshot) {
                        ModelDetail modelDetail = new ModelDetail();
                        b.a((IModelDetail) dBModelSnapshot, modelDetail);
                        return modelDetail;
                    }
                }), new ItemSnapshotInfo());
            }
            com.garena.android.appkit.b.b.a("ITEM_SNAPSHOT_LOAD", new a(), b.a.NETWORK_BUS);
        }
    }

    private boolean a(ResponseItem responseItem) {
        return responseItem.errcode.intValue() == 0;
    }
}

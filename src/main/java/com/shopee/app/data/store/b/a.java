package com.shopee.app.data.store.b;

import android.util.Pair;
import com.shopee.app.d.b.b;
import com.shopee.app.data.store.ah;
import com.shopee.app.data.store.ak;
import com.shopee.app.data.store.ao;
import com.shopee.app.data.store.bh;
import com.shopee.app.data.viewmodel.ItemSnapshotInfo;
import com.shopee.app.data.viewmodel.ModelDetail;
import com.shopee.app.data.viewmodel.OrderDetail;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import com.shopee.app.database.orm.bean.DBModelSnapshot;
import com.shopee.app.database.orm.bean.DBOrderDetail;
import com.shopee.app.database.orm.bean.DBOrderItem;
import com.shopee.app.database.orm.bean.DBUserInfo;
import com.shopee.app.database.orm.bean.IModelDetail;
import com.shopee.app.util.af;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, Integer> f17239a = new HashMap();

    public static void a(DBOrderDetail dBOrderDetail, List<DBOrderItem> list, bh bhVar, ah ahVar, ao aoVar, List<Integer> list2, List<Pair<Integer, Long>> list3, OrderDetail orderDetail) {
        int c2 = dBOrderDetail.c();
        if (dBOrderDetail.c() == ((Integer) ak.a().d().b(-1)).intValue()) {
            c2 = dBOrderDetail.E();
        }
        int i = c2;
        bh bhVar2 = bhVar;
        DBUserInfo a2 = bhVar.a(i);
        if (a2 == null) {
            list2.add(Integer.valueOf(i));
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (DBOrderItem m : list) {
            arrayList.add(Long.valueOf(m.m()));
        }
        List<DBItemSnapShot> d2 = ahVar.d(arrayList);
        for (DBOrderItem next : list) {
            boolean z = false;
            Iterator<DBItemSnapShot> it = d2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    ao aoVar2 = aoVar;
                    break;
                }
                DBItemSnapShot next2 = it.next();
                if (next2.a().longValue() == next.d()) {
                    ItemSnapshotInfo itemSnapshotInfo = new ItemSnapshotInfo();
                    b.a(next2, (List<ModelDetail>) af.a(aoVar.e(next2.a().longValue()), new af.b<ModelDetail, DBModelSnapshot>() {
                        /* renamed from: a */
                        public ModelDetail map(DBModelSnapshot dBModelSnapshot) {
                            ModelDetail modelDetail = new ModelDetail();
                            b.a((IModelDetail) dBModelSnapshot, modelDetail);
                            return modelDetail;
                        }
                    }), itemSnapshotInfo);
                    arrayList2.add(new Pair(next, itemSnapshotInfo));
                    z = true;
                    break;
                }
                ao aoVar3 = aoVar;
            }
            if (!z) {
                arrayList2.add(new Pair(next, (Object) null));
                list3.add(new Pair(Integer.valueOf(next.c()), Long.valueOf(next.m())));
            } else {
                List<Pair<Integer, Long>> list4 = list3;
            }
        }
        DBOrderDetail dBOrderDetail2 = dBOrderDetail;
        b.a(dBOrderDetail, a2, (List<Pair<DBOrderItem, ItemSnapshotInfo>>) arrayList2, orderDetail);
    }

    static {
        f17239a.put(1, 0);
        f17239a.put(2, 1);
        f17239a.put(4, 3);
        f17239a.put(5, 4);
        f17239a.put(3, 3);
    }

    public static void a(DBItemSnapShot dBItemSnapShot, ao aoVar, OrderDetail orderDetail) {
        if (dBItemSnapShot != null) {
            for (DBModelSnapshot next : aoVar.e(dBItemSnapShot.a().longValue())) {
                if (next.f() == orderDetail.getFirstItemVariantId()) {
                    orderDetail.setFirstItemVariantPrice(next.i());
                    orderDetail.setFirstItemVariantPriceBeforeDiscount(next.m());
                    return;
                }
            }
        } else if (orderDetail.getFirstItemVariantId() > 0) {
            DBModelSnapshot d2 = aoVar.d(orderDetail.getFirstItemVariantId());
            if (d2 != null) {
                orderDetail.setFirstItemVariantPrice(d2.i());
                orderDetail.setFirstItemVariantPriceBeforeDiscount(d2.m());
            }
        }
    }
}

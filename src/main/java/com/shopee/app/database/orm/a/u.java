package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.chatP2P.DBOffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class u extends a<DBOffer, Long> {
    public u(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBOffer.class);
    }

    public DBOffer a(long j) {
        try {
            return (DBOffer) b().queryForId(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBOffer> a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(b().queryBuilder().where().in("offerId", (Iterable<?>) list).query());
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return arrayList;
    }

    public void b(final List<DBOffer> list) {
        if (list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBOffer createOrUpdate : list) {
                            b2.createOrUpdate(createOrUpdate);
                        }
                        return null;
                    }
                });
            } catch (Exception e2) {
                com.garena.android.appkit.d.a.a(e2);
            }
        }
    }

    public List<DBOffer> b(long j) {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.addAll(b().queryBuilder().where().eq("itemId", Long.valueOf(j)).query());
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return arrayList;
    }
}

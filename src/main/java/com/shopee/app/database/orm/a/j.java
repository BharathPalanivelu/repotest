package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBChatToOffer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class j extends a<DBChatToOffer, Long> {
    public j(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBChatToOffer.class);
    }

    public DBChatToOffer a(long j) {
        try {
            return (DBChatToOffer) b().queryForId(Long.valueOf(j));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(final List<DBChatToOffer> list) {
        if (list != null && list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBChatToOffer createOrUpdate : list) {
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

    public DBChatToOffer a(long j, int i, int i2, long j2) {
        try {
            return (DBChatToOffer) b().queryBuilder().where().eq("itemId", Long.valueOf(j)).and().eq("shopId", Integer.valueOf(i)).and().eq("userId", Integer.valueOf(i2)).and().eq("orderId", Long.valueOf(j2)).queryForFirst();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBChatToOffer> b(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        try {
            List<T> query = b().queryBuilder().where().in("chatId", (Iterable<?>) list).query();
            if (query != null) {
                return query;
            }
            return arrayList;
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}

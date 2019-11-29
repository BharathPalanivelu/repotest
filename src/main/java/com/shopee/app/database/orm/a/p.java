package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBItemSnapShot;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class p extends a<DBItemSnapShot, Long> {
    public p(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBItemSnapShot.class);
    }

    public DBItemSnapShot a(long j) {
        try {
            return (DBItemSnapShot) b().queryForId(Long.valueOf(j));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(DBItemSnapShot dBItemSnapShot) {
        try {
            b().createOrUpdate(dBItemSnapShot);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBItemSnapShot> a(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() <= 0) {
            return arrayList;
        }
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().in("snapshotId", (Iterable<?>) list);
            arrayList.addAll(queryBuilder.query());
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return arrayList;
    }
}

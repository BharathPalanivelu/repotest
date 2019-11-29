package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBContactInfo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class x extends a<DBContactInfo, Integer> {
    public x(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBContactInfo.class);
    }

    public DBContactInfo a(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("SHOP_ID", Integer.valueOf(i));
            arrayList.addAll(queryBuilder.query());
            if (arrayList.size() > 0) {
                return (DBContactInfo) arrayList.get(0);
            }
            return null;
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void b(int i) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("CONTACT_TYPE", Integer.valueOf(i));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(DBContactInfo dBContactInfo) {
        try {
            b().createOrUpdate(dBContactInfo);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(final List<DBContactInfo> list) {
        if (list != null && list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBContactInfo createOrUpdate : list) {
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

    public List<DBContactInfo> c(int i) {
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("autoid", true).where().eq("CONTACT_TYPE", Integer.valueOf(i));
            arrayList.addAll(queryBuilder.query());
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
        return arrayList;
    }
}

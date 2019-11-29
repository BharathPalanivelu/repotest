package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBUserInfo;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

public class ad extends a<DBUserInfo, Integer> {
    public ad(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBUserInfo.class);
    }

    public DBUserInfo a(int i) {
        try {
            return (DBUserInfo) b().queryForId(Integer.valueOf(i));
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(final List<DBUserInfo> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBUserInfo dBUserInfo : list) {
                        dBUserInfo.l(com.garena.android.appkit.tools.a.a.a());
                        b2.createOrUpdate(dBUserInfo);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(DBUserInfo dBUserInfo) {
        try {
            Dao b2 = b();
            dBUserInfo.l(com.garena.android.appkit.tools.a.a.a());
            b2.createOrUpdate(dBUserInfo);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}

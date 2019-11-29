package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.DBContactLocalInfo;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.Callable;

public class q extends a<DBContactLocalInfo, String> {
    public q(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBContactLocalInfo.class);
    }

    public boolean a(DBContactLocalInfo dBContactLocalInfo) {
        try {
            DBContactLocalInfo dBContactLocalInfo2 = (DBContactLocalInfo) b().queryForId(dBContactLocalInfo.b());
            if (dBContactLocalInfo2 == null || !dBContactLocalInfo2.a().equals(dBContactLocalInfo.a())) {
                return false;
            }
            return true;
        } catch (NullPointerException | SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }

    public void a(final List<DBContactLocalInfo> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBContactLocalInfo createOrUpdate : list) {
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

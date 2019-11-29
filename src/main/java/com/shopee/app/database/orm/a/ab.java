package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.shopee.app.database.orm.bean.DBTransaction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ab extends a<DBTransaction, Long> {
    public ab(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBTransaction.class);
    }

    public void a(final List<DBTransaction> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBTransaction createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBTransaction> a(int i) {
        try {
            return b().queryBuilder().orderBy("autoid", true).where().eq("hisType", Integer.valueOf(i)).query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void b(int i) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("hisType", Integer.valueOf(i));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}

package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.shopee.app.database.orm.bean.chatP2P.DBBlockUser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class f extends a<DBBlockUser, Integer> {
    public f(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBBlockUser.class);
    }

    public void e() {
        try {
            b().deleteBuilder().delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public List<DBBlockUser> f() {
        try {
            return b().queryBuilder().orderBy("sequence", true).query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void a(final List<DBBlockUser> list) {
        if (list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Integer>() {
                    /* renamed from: a */
                    public Integer call() throws Exception {
                        for (DBBlockUser createOrUpdate : list) {
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
}

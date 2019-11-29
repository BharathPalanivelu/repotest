package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.chatP2P.DBChat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class h extends a<DBChat, Long> {
    public h(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBChat.class);
    }

    public void a(DBChat dBChat) {
        try {
            b().createOrUpdate(dBChat);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(final List<DBChat> list) {
        if (list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBChat createOrUpdate : list) {
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

    public List<DBChat> e() {
        ArrayList arrayList = new ArrayList();
        try {
            return b().queryBuilder().orderBy("lastMsgTime", false).query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }

    public List<DBChat> a(long j) {
        ArrayList arrayList = new ArrayList();
        try {
            return b().queryBuilder().orderBy("lastMsgTime", false).limit(Long.valueOf(j)).query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }

    public DBChat b(long j) {
        try {
            return (DBChat) b().queryForId(Long.valueOf(j));
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public void a(int i) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("userId", Integer.valueOf(i));
            deleteBuilder.delete();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public DBChat b(int i) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().eq("userId", Integer.valueOf(i));
            return (DBChat) queryBuilder.queryForFirst();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBChat> f() {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.selectColumns("userId", "lastMsgId");
            queryBuilder.orderBy("lastMsgTime", false);
            return queryBuilder.query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBChat> a(List<Integer> list, long j) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().in("userId", (Iterable<?>) list);
            queryBuilder.orderBy("lastMsgTime", false);
            queryBuilder.limit(Long.valueOf(j));
            return queryBuilder.query();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }
}

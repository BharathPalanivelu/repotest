package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBChatMessage;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class i extends a<DBChatMessage, Long> {
    public i(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBChatMessage.class);
    }

    public DBChatMessage a(long j) {
        try {
            List queryForEq = b().queryForEq("chat_message_id", Long.valueOf(j));
            if (queryForEq == null || queryForEq.isEmpty()) {
                return null;
            }
            return (DBChatMessage) queryForEq.get(0);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public boolean b(long j) {
        try {
            return !b().queryForEq("chat_message_id", Long.valueOf(j)).isEmpty();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return false;
        }
    }

    public void a(final List<DBChatMessage> list) {
        if (list != null && list.size() > 0) {
            try {
                final Dao b2 = b();
                b2.callBatchTasks(new Callable<Object>() {
                    public Object call() throws Exception {
                        for (DBChatMessage createOrUpdate : list) {
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

    public void a(DBChatMessage dBChatMessage) {
        try {
            b().createOrUpdate(dBChatMessage);
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public DBChatMessage a(String str) {
        try {
            List queryForEq = b().queryForEq("requestId", str);
            if (queryForEq == null || queryForEq.isEmpty()) {
                return null;
            }
            return (DBChatMessage) queryForEq.get(0);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return null;
        }
    }

    public List<DBChatMessage> b(List<Long> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            return arrayList;
        }
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.where().in("chat_message_id", (Iterable<?>) list);
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return arrayList;
        }
    }

    public List<DBChatMessage> a(int i, int i2) {
        if (i2 < 20) {
            i2 = 20;
        }
        ArrayList arrayList = new ArrayList();
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("timestamp", false).orderBy("chat_message_id", false).where().eq("toUser", Integer.valueOf(i)).or().eq("fromUser", Integer.valueOf(i));
            queryBuilder.limit(Long.valueOf((long) i2));
            List<DBChatMessage> query = queryBuilder.query();
            if (query != null) {
                return query;
            }
            return arrayList;
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(DBChatMessage dBChatMessage) {
        try {
            b().delete(dBChatMessage);
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(int i) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("toUser", Integer.valueOf(i)).or().eq("fromUser", Integer.valueOf(i));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(int i, int i2) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("toUser", Integer.valueOf(i)).or().eq("fromUser", Integer.valueOf(i)).and().le("timestamp", Integer.valueOf(i2));
            deleteBuilder.delete();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}

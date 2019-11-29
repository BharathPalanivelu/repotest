package com.shopee.app.database.orm.a;

import com.garena.android.appkit.a.a.a;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.shopee.app.database.orm.bean.DBItemComment;
import com.shopee.app.util.af;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

public class n extends a<DBItemComment, Long> {
    public n(com.garena.android.appkit.a.a aVar) {
        super(aVar, DBItemComment.class);
    }

    public List<DBItemComment> a(long j) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("cTime", true);
            queryBuilder.where().eq("itemId", Long.valueOf(j));
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public List<DBItemComment> b(long j) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("cTime", true);
            queryBuilder.where().eq("itemId", Long.valueOf(j)).and().gt("orderId", 0);
            return queryBuilder.query();
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    /* access modifiers changed from: package-private */
    public List<DBItemComment> a(long j, final int i) {
        try {
            QueryBuilder queryBuilder = b().queryBuilder();
            queryBuilder.orderBy("cTime", true);
            queryBuilder.where().eq("itemId", Long.valueOf(j)).and().gt("orderId", 0);
            List<DBItemComment> query = queryBuilder.query();
            if (i == 0) {
                return query;
            }
            return af.a(query, new af.a<DBItemComment>() {
                /* renamed from: a */
                public boolean shouldInclude(DBItemComment dBItemComment) {
                    return dBItemComment.a() == i;
                }
            });
        } catch (SQLException e2) {
            com.garena.android.appkit.d.a.a(e2);
            return new ArrayList();
        }
    }

    public void a(final List<DBItemComment> list) {
        try {
            final Dao b2 = b();
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBItemComment dBItemComment : list) {
                        n.this.a(dBItemComment.f(), dBItemComment.g(), dBItemComment.c());
                    }
                    return null;
                }
            });
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBItemComment createOrUpdate : list) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void b(List<Long> list) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().in("id", (Iterable<?>) list);
            deleteBuilder.delete();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(int i, long j, long j2) {
        try {
            DeleteBuilder deleteBuilder = b().deleteBuilder();
            deleteBuilder.where().eq("shopId", Integer.valueOf(i)).and().eq("itemId", Long.valueOf(j)).and().eq("cmtId", Long.valueOf(j2));
            deleteBuilder.delete();
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }

    public void a(long j, List<DBItemComment> list, boolean z, int i) {
        List<DBItemComment> list2;
        try {
            final Dao b2 = b();
            if (z) {
                list2 = a(j, i);
            } else {
                list2 = a(j);
            }
            final HashMap hashMap = new HashMap();
            for (DBItemComment next : list) {
                hashMap.put(String.valueOf(next.g()) + String.valueOf(next.f()) + String.valueOf(next.c()), next);
            }
            HashMap hashMap2 = new HashMap();
            for (DBItemComment next2 : list2) {
                hashMap2.put(String.valueOf(next2.g()) + String.valueOf(next2.f()) + String.valueOf(next2.c()), next2);
            }
            final List<T> a2 = af.a(af.a(list2, new af.a<DBItemComment>() {
                /* renamed from: a */
                public boolean shouldInclude(DBItemComment dBItemComment) {
                    String str = String.valueOf(dBItemComment.g()) + String.valueOf(dBItemComment.f()) + String.valueOf(dBItemComment.c());
                    boolean z = true;
                    if (!hashMap.containsKey(str)) {
                        return true;
                    }
                    if (((DBItemComment) hashMap.get(str)).n() == dBItemComment.n()) {
                        z = false;
                    }
                    if (!z) {
                        hashMap.remove(str);
                    }
                    return z;
                }
            }), new af.b<Long, DBItemComment>() {
                /* renamed from: a */
                public Long map(DBItemComment dBItemComment) {
                    return Long.valueOf(dBItemComment.b());
                }
            });
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    for (DBItemComment createOrUpdate : hashMap.values()) {
                        b2.createOrUpdate(createOrUpdate);
                    }
                    return null;
                }
            });
            b2.callBatchTasks(new Callable<Object>() {
                public Object call() throws Exception {
                    n.this.b((List<Long>) a2);
                    return null;
                }
            });
        } catch (Exception e2) {
            com.garena.android.appkit.d.a.a(e2);
        }
    }
}
